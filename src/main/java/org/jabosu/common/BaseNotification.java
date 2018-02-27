package org.jabosu.common;

import com.datastax.driver.mapping.annotations.Field;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author satya
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseNotification implements Notification {

    @Field(name="id")
    public String id;

    @JsonIgnore
    @Field(name = "is_first")
    public boolean isFirst;

    @JsonIgnore
    @Field(name="is_last")
    public boolean isLast;

    @Field(name = "bucket")
    public String bucket;

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    @Override
    public void setIsFirst(boolean first) {
        this.isFirst = first;
    }

    @Override
    public void setIsLast(boolean isLast) {
        this.isLast = isLast;
    }

    @Override
    public boolean getIsFirst() {
        return isFirst;
    }
    
    @Override
    public boolean getIsLast() {
        return isLast;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof BaseNotification)) {
            return false;
        }

        if (id.equals(((BaseNotification) o).id)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }
}
