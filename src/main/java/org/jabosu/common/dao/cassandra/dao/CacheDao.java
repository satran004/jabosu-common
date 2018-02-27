package org.jabosu.common.dao.cassandra.dao;

import org.jabosu.common.exception.BusinessException;
import org.jabosu.common.exception.DataAccessException;
import org.jabosu.common.util.CacheConfig;
import org.jabosu.common.util.SerializationUtil;
import org.jabosu.common.Model;

/**
 *
 * @author satya
 */
public abstract class CacheDao<T extends Model, K> {//} extends BaseDao<T, K> {
    
//    protected static int DEFAULT_EXPIRY_TILE = CacheConfig.getDefaultKeyCacheExpirationTime();
//
////    @Override
//    public T get(K... key) throws DataAccessException {
//
//        if(!CacheConfig.isKeyCacheEnabled()) {
//            return super.get(key);
//        } else {
//
//        }
//
//    }
//
////    @Override
//    public T get(String key, String country) throws DataAccessException {
//
//        if(!CacheConfig.isKeyCacheEnabled()) {
//            return super.get(key, country);
//        } else {
//
//            T retObj = null;
//
//            String cacheKey = getCacheKey(key, country);
//
//            Object data = Cache.get(cacheKey);
//
//            if (data != null) {
//                if(Logger.isDebugEnabled()) {
//                    Logger.debug(" Data fetched from cache : " + key);
//                }
//                retObj = deserialize(data);
//            }
//
//            if (retObj != null) {
//                return retObj;
//            } else {
//
//                if(Logger.isDebugEnabled()) {
//                    Logger.debug("Data is not there in cache. Fetch it from riak");
//                }
//
//                retObj = super.get(key, country);
//
//                if(retObj != null) {
//                    //put on cache
//                    if(expiry() == -1) {
//                        Cache.set(cacheKey, serialize(retObj));
//                    } else {
//                        Cache.set(cacheKey, serialize(retObj), expiry());
//                    }
//                }
//                return retObj;
//            }
//
//        }
//    }
//
//    @Override
//    public T save(T bean) throws DataAccessException {
//        T t = super.save(bean);
//
//        //invalidate  cache
//        if (CacheConfig.isKeyCacheEnabled() && isInvalidateCacheOnSave()) {
//            String cacheKey = getCacheKey(bean.key(), null);
//            Cache.remove(cacheKey);
//        }
//
//        return t;
//    }
//
//    @Override
//    public T save(T bean, String country) throws DataAccessException {
//        T t = super.save(bean, country);
//
//        //invalidate  cache
//        if (CacheConfig.isKeyCacheEnabled() && isInvalidateCacheOnSave()) {
//            String cacheKey = getCacheKey(bean.key(), country);
//            Cache.remove(cacheKey);
//        }
//
//        return t;
//    }
//
//    @Override
//    public T saveNew(T bean) throws DataAccessException { //For safer side.. not required to clear cache usually
//        T t = super.saveNew(bean);
//
//        //invalidate  cache
//        if (CacheConfig.isKeyCacheEnabled() && isInvalidateCacheOnSave()) {
//            String cacheKey = getCacheKey(bean.key(), null);
//            Cache.remove(cacheKey);
//        }
//
//        return t;
//    }
//
//    @Override
//    public T saveNew(T bean, String country) throws DataAccessException {
//        T t = super.saveNew(bean, country);
//
//        //invalidate  cache
//        if (CacheConfig.isKeyCacheEnabled() && isInvalidateCacheOnSave()) {
//            String cacheKey = getCacheKey(bean.key(), country);
//            Cache.remove(cacheKey);
//        }
//
//        return t;
//    }
//
//    protected T deserialize(Object data) {
//        try {
//            return (T) SerializationUtil.deSerializeFromString(String.valueOf(data), getDomainClass());
//        } catch (BusinessException ex) {
//            Logger.warn("Could not deserialize data from cache..");
//            return null;
//        }
//    }
//
//    protected Object serialize(T data) {
//        try {
//            String str = SerializationUtil.serializeAsString(data);
//            return str;
//        } catch (BusinessException ex) {
//            Logger.warn("Could not deserialize data from cache..");
//            return null;
//        }
//    }
//
//    protected boolean isInvalidateCacheOnSave() {
//        return true;
//    }
//
//    protected int expiry() {
//        return DEFAULT_EXPIRY_TILE;
//    }
//
//    private String getCacheKey(String key, String country) {
//
//        if (country == null) {
//            return getBucketName() + ":" + key;
//        } else {
//            return getCountryBucketName(country) + ":" + key;
//        }
//
//    }
//

}
