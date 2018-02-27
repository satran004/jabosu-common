package org.jabosu.common;

import org.jabosu.common.exception.BusinessRuntimeException;
import org.jabosu.common.services.api.StaticDataService;
import org.jabosu.common.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;


/**
 *
 * @author satya
 */
public class MetaFieldInfo {

    private static Logger logger = LoggerFactory.getLogger(MetaFieldInfo.class.getName());

    public final static String KEY_DEALS = "deals";
    public final static String KEY_SERVICE = "service";

    private static String[] keys = new String[]{KEY_SERVICE};
    private static Map<String, MetaFieldInfo> metaFieldInfos = new HashMap();

    private static Map<String, CategoryInfo> metaFields = new HashMap();
    private static Map<String, Object> lookupDataList = new HashMap();

    public static MetaFieldInfo get(String key) {

        if(metaFieldInfos.size() == 0) {
            throw new BusinessRuntimeException("MetaFieldInfo is not initialized yet.");
        }

        return metaFieldInfos.get(key);
    }

    public static void initializeAll(StaticDataService loaderService) throws FileNotFoundException {

        for(String key: keys) {
            MetaFieldInfo metaFieldInfo = new MetaFieldInfo();
            metaFieldInfo.initialize(key, loaderService);

            metaFieldInfos.put(key, metaFieldInfo);
        }
    }


    public void initialize(String name, StaticDataService loaderService) throws FileNotFoundException {

//        CustomClassLoaderConstructor classLoaderConstructor =
//                new CustomClassLoaderConstructor(CategoryInfo.class, CategoryInfo.class.getClassLoader());
        //Yaml yaml = new Yaml(classLoaderConstructor);

        //load field infos
//        InputStream input = Play.application().resourceAsStream("data/meta_fields/custom-fields.yml");
//        try {
        List objects = loaderService.loadList("meta_fields/" + name + "/custom-fields.yml", CategoryInfo.class);//yaml.loadAll(input);

        CategoryInfo common = null;
        for (Object data : objects) {
            CategoryInfo catInfo = (CategoryInfo)data;

            if("common".equals(catInfo.category)) {
                common = catInfo;
            }

            metaFields.put(catInfo.category, catInfo);
        }

        for(String key: metaFields.keySet()) { //update group fields for common category
            if("common".equals(key)) {
                //update common groupfields
                populateGroupFields(common);
                break;
            }
        }

        for(String key: metaFields.keySet()) { //add common fields to all categories
            if("common".equals(key)) {
                continue;
            }

            CategoryInfo catInfo = metaFields.get(key);
            if(catInfo.getFields() == null) {
                catInfo.initFields();
            }

            populateGroupFields(catInfo);

            catInfo.getFields().addAll(common.getFields());

            catInfo.getGroups().addAll(common.getGroups()); //add common groups also

            catInfo.getGroupFields().addAll(common.getGroupFields());

            System.out.println("*********** " + catInfo.category + "   " + common.getGroupFields().size());

            Collections.sort(catInfo.getFields());

            Collections.sort(catInfo.getGroupFields());

        }
//        }
//        finally {
//            if(input != null)
//                try {
//                input.close();
//            } catch (IOException ex) {
//
//            }
//        }

        prepareLookupDataList(name, loaderService);

    }

    private void populateGroupFields(CategoryInfo catInfo) {


        if(catInfo.groups != null && catInfo.groups.size() > 0) {
            catInfo.getGroupFields().addAll(catInfo.getFields());

            for(MetaFieldGroup fieldGroup: catInfo.getGroups()) {

                for(String fieldId: fieldGroup.fieldIds) {
                    MetaField metaField = getField(catInfo.getFields(), fieldId);
                    if(metaField != null) {
                        fieldGroup.getFields().add(metaField);
                        catInfo.getGroupFields().remove(metaField); //remove field from group fields
                    }
                }

                if(fieldGroup.fields.size() > 0) {
                    Collections.sort(fieldGroup.fields);
                    catInfo.getGroupFields().add(fieldGroup);
                }
            }
            //catInfo.getGroupFields().addAll(catInfo.getGroups());
        } else {
            catInfo.getGroupFields().addAll(catInfo.getFields());
        }

//        Collections.sort(catInfo.getGroupFields());
    }

    private MetaField getField(Collection<MetaField> fields, String id) {
        for(MetaField field: fields) {
            if(id.equals(field.id))
                return field;
        }

        return null;
    }

    private void prepareLookupDataList(String name, StaticDataService loaderService) {
        //load lookup data
        Map<String, Object> lookupData = (Map)loaderService.load("meta_fields/" + name + "/custom-fields-lookup-data.yml");

        Set<String> keys = lookupData.keySet();

        for(String key: keys) {
            Object value = lookupData.get(key);

            if(value == null)
                continue;

            if(value instanceof Map) {
                Map<String, String> lookupValues = (Map<String, String>)lookupData.get(key);

                String namespace = (String) lookupData.get(key + ".namespace");
                if(StringUtil.isEmpty(namespace))
                    namespace = key;

                List<LookupItem> lookupDataValues = new LinkedList<LookupItem>();
                for (Entry<String, String> item : lookupValues.entrySet()) {
                    LookupItem lookupItem = new LookupItem(item.getKey(), item.getValue());
                    lookupDataValues.add(lookupItem);

                    //add it to lookupdata map also for faster retrieval
                    lookupDataList.put(namespace + ":" + item.getKey(), item.getValue());

                    if(namespace.endsWith("_type"))
                    logger.info(namespace + ":" + item.getKey() + "------" + item.getValue());
                }

                lookupDataList.put(key, lookupDataValues);
            }else if(value instanceof String) { //for metadata like group.name etc.
                lookupDataList.put(key, value);
            }
        }
    }

    public List<MetaField> getMetaFields(String category) {
        if (category == null) {
            return Collections.EMPTY_LIST;
        }

        CategoryInfo catInfo = metaFields.get(category);

        if (catInfo == null) {
            return Collections.EMPTY_LIST;
        }

        return catInfo.getFields();
    }

    public List<MetaEntity> getMetaGroupFields(String category) {
        if (category == null) {
            return Collections.EMPTY_LIST;
        }

        CategoryInfo catInfo = metaFields.get(category);

        if (catInfo == null) {
            return Collections.EMPTY_LIST;
        }

        return catInfo.getGroupFields();
    }

//    public static Map<String, String> lookupData(String key) {
//        Map data = lookupData.get(key);
//
//        if(data == null) return Collections.EMPTY_MAP;
//        else
//            return data;
//    }

    public static List<LookupItem> lookupItems(String key) {
        List<LookupItem> items = (List<LookupItem>)lookupDataList.get(key);

        if(items == null)
            return Collections.EMPTY_LIST;
        else
            return items;
    }

    public static String lookupString(String key) {
        String value = (String)lookupDataList.get(key);

        if(value == null)
            return "";
        else
            return value;
    }

    public static String lookupString(String lookup, String key) {

        if(StringUtil.isEmpty(lookup))
            return key;

        String value = (String) lookupDataList.get(lookup + ":" + key);

        if(value == null)
            return key;
        else
            return value;
    }

    public static String[] lookupString(String lookup, String[] keys) {

        if(StringUtil.isEmpty(lookup))
            return keys;

        if(keys == null || keys.length == 0)
            return keys;

        String[] result = Arrays.stream(keys).map(key -> lookupString(lookup, key)).collect(Collectors.toList()).toArray(new String[0]);

        return result;

    }

    public static String[] lookupString(String lookup, List<String> keys) {

        if(StringUtil.isEmpty(lookup))
            return keys.toArray(new String[0]);

        if(keys == null || keys.size() == 0)
            return keys.toArray(new String[0]);

        String[] result = keys.stream().map(key -> lookupString(lookup, key)).collect(Collectors.toList()).toArray(new String[0]);

        return result;

    }

}
