package org.jabosu.common;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author satya
 */
public class CategoryInfo {
    
    public String category;
    
//    public CategoryInfo(String category) {
//        this.category = category;
//    }
//    
    public List<MetaField> fields = new LinkedList<MetaField>();
    public List<MetaFieldGroup> groups = new LinkedList<>();

    public List<MetaEntity> groupFields = new LinkedList<>();
    
    public void addField(MetaField f) {
        fields.add(f);
    }
    
    public List<MetaField> getFields() {
        return fields;
    }

    public List<MetaFieldGroup> getGroups() {
        return groups;
    }

    public List<MetaEntity> getGroupFields() {
        return groupFields;
    }
    
    public void initFields() {
        fields = new LinkedList<MetaField>();
    }
    
    
}
