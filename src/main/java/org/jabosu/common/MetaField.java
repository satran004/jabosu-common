package org.jabosu.common;

import java.util.List;

/**
 *
 * @author satya
 */
public class MetaField extends MetaEntity {

    public final static String INPUT_FIELD = "input";
    public final static String SELECT_FIELD = "select";
    public final static String TEXTAREA_FIELD = "textarea";
    public final static String CHECKBOX_FIELD = "checkbox";
    public final static String CURRENCY_FIELD = "currency";
    
    //public String id;
//    public String label;
//    public String labelcode;
    public String type;
    public String placeholder;
    public String ui;
    public String clazz;  //class for div for edit page
    public String viewClazz; //For display
    public String compClazz = ""; //class for component itself
    //only applicable for ui type "input"
//    public String inputType;
    //used for select field 
    public String lookup;
    public String[] lookupGroups;

    public boolean required;
    public String errorcode;
    
    public String validator;
    public String specialType; 
    public String icon; //for social links
    public boolean cleanHtml;

    //public int order;

    public boolean searchable;
    public String logicalOperator = "AND"; // needed for multivalue filter

    public String comparator = "=";

    public boolean hidden; //only hide in detail page

    //only set to display in the UI for searchable fields.
    public List<LookupItem> lookupItems;

    public MetaField() {
        metaType = "field";
    }

    public boolean isRichText() {
        if(compClazz != null && (compClazz.equals("rich-text") || compClazz.equals("rich-text-simple")))
            return true;
        else
            return false;
    }
//    public String getSearchFieldId() {
//        if(searchType == null)
//            return id;
//        else
//            return id + "_" + searchType;
//    }
//    public String[] getSearchValues(String values[]) {
//        if(values == null || values.length == 0)
//            return values;
//
//        if(searchType != null && searchType.endsWith("_txt")) { //for _txt type.. the whole string needs to be searched. no whitespace.
//
//            return Arrays.stream(values).map(
//                    (val) -> val.replaceAll(" ","") //remove space from the search token
//            ).collect(Collectors.toList()).toArray(new String[0]);
//        } else
//            return values;
//    }

}
