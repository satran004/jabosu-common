package org.jabosu.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author satya
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public interface Notification {
    
    public String getId();
    
    public void setId(String id);
//
    public void setBucket(String bucket); //same as splitId

    public String getBucket();
    
    public void setIsFirst(boolean first);
    
    public void setIsLast(boolean isLast);
    
    public boolean getIsFirst();
    
    public boolean getIsLast();
}
