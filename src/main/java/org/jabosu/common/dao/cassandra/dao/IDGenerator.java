package org.jabosu.common.dao.cassandra.dao;

import org.jabosu.common.entity.BaseModel;

/**
 *
 * @author satya
 */
public interface IDGenerator<T extends BaseModel> {
    
    public String getNextAvailableId(T t);
    
    public void applyNewId(T t, String newId);
    
    public String getLockKey(T t);
}
