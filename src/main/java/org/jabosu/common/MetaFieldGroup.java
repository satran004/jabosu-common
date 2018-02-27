package org.jabosu.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by satya on 5/5/15.
 */
public class MetaFieldGroup extends MetaEntity {

    //public String id;
    public String searchUIType;
    public List<String> fieldIds;
    public List<MetaField> fields = new ArrayList<>();
//    public int order;

    public MetaFieldGroup() {
        metaType = "group";
    }

    public List<MetaField> getFields() {
        return fields;
    }

}
