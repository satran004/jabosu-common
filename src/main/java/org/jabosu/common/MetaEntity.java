package org.jabosu.common;

/**
 * Created by satya on 5/5/15.
 */
public class MetaEntity implements Comparable<MetaEntity> {
    public String id;
    public String label;
    public String searchLabel;
    public String labelcode;
    public int order;
    public String inputType;
    public String metaType;

    public int maxLength;
    public String attributes;
    public String pattern; //for input mask

    @Override
    public int compareTo(MetaEntity o) {

        if(o == null)
            return -1;

        if(this.order < o.order)
            return -1;
        else if(this.order == o.order)
            return 0;
        else
            return 1;

    }
}
