package org.jabosu.common.util;

//import com.events37.modules.redis.serializers.SerializationException;
//import com.events37.modules.redis.serializers.SerializationFactory;
//import com.events37.modules.redis.serializers.Serializer;
import org.jabosu.common.exception.BusinessException;


/**
 *
 * @author satya
 */
public class SerializationUtil {
    /** TODO

    public static byte[] serialize(Object obj) throws BusinessException {
        
        if(obj == null)
            return null;
        
        Serializer serializer = SerializationFactory.getSerializer();

        if (serializer == null) {
            throw new BusinessException("Redis data serializer is null. Could not store session.");
        }
        try {
            return serializer.serialize(obj);
        } catch (SerializationException ex) {
            throw new BusinessException("Unable to serialize session data", ex);
        }
    }

    public static Object deSerialize(byte[] bytes, Class clazz) throws BusinessException {
        
        if(bytes == null)
            return null;
        
        Serializer serializer = SerializationFactory.getSerializer();

        if (serializer == null) {
            throw new BusinessException("Redis data serializer is null. Could not store session.");
        }
        try {
            return serializer.deSerialize(bytes, clazz);
        } catch (SerializationException ex) {
            throw new BusinessException("Unable to serialize session data", ex);
        }
    }
    
    
    public static String serializeAsString(Object obj) throws BusinessException {
        
        if(obj == null)
            return null;
        
        Serializer serializer = SerializationFactory.getSerializer();

        if (serializer == null) {
            throw new BusinessException("Redis data serializer is null. Could not store session.");
        }
        try {
            return serializer.serializeAsString(obj);
        } catch (SerializationException ex) {
            throw new BusinessException("Unable to serialize session data", ex);
        }
    }
    
    public static Object deSerializeFromString(String txt, Class clazz) throws BusinessException {
        
        if(txt == null)
            return null;
        
        return deSerialize(txt.getBytes(), clazz);
    }
     **/
}
