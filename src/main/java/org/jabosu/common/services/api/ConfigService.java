package org.jabosu.common.services.api;

import java.util.List;
/**
 *
 * @author satya
 */
public interface ConfigService {
    
    public boolean getBoolean(String string);

    public Number getNumber(String string);

    public int getInt(String string);

    public long getLong(String string);

    public double getDouble(String string);

    public String getString(String string);
    
    public List getStringList(String key);
    
    public List<Object> getList(String key);
    
}
