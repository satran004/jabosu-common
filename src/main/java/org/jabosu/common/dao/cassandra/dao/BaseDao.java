package org.jabosu.common.dao.cassandra.dao;

import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import org.jabosu.common.entity.BaseModel;
import org.jabosu.common.exception.DataAccessException;
import org.jabosu.common.dao.cassandra.dao.IDGenerator;
import org.jabosu.common.util.cassandra.CassandraPersistenceHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseDao<T, K> extends AbstractDao {
    private static Logger logger = LoggerFactory.getLogger(BaseDao.class.getName());

    protected static MappingManager manager;
    protected Mapper mapper;

    public BaseDao() {

        if(manager == null)
            manager = CassandraPersistenceHelper.getInstance().getMappingManager();

        mapper = manager.mapper(getDomainClass());

    }

//    protected boolean updateBucketProps = false;
    
//    public abstract String getBucketName();

    public abstract Class<T> getDomainClass();
    
    public T save(T bean) throws DataAccessException {
        return save(bean, null, false);
    }
    
//    public T save(T bean, String countryCode) throws DataAccessException {
//        return save(bean, countryCode, false);
//    }
    
    public T saveNew(T bean) throws DataAccessException {
        return save(bean, null, true);
    }
    
//    public T saveNew(T bean, String countryCode) throws DataAccessException {
//        return save(bean, countryCode, true);
//    }

    public T save(T bean, String countryCode, boolean isNew) throws DataAccessException {

        try {
            if (bean != null)
                prePersist(bean);

            if (bean instanceof BaseModel) {
                ((BaseModel) bean).setLastUpdatedOn(System.currentTimeMillis());
                if (((BaseModel) bean).getCreatedOn() == 0) {
                    ((BaseModel) bean).setCreatedOn(((BaseModel) bean).getLastUpdatedOn());
                }
            }

            //System.out.println(mapper.saveQuery(bean).enableTracing());
            if (isNew) {

                IDGenerator idGenerator = getIDGenerator();
                if(idGenerator != null) {
                   // idGenerator.applyNewId((BaseModel)bean, idGenerator.getNextAvailableId((BaseModel) bean));
                    idGenerator.applyNewId((BaseModel)bean, idGenerator.getNextAvailableId((BaseModel) bean)); //TODO replace correct model
                }

                mapper.save(bean);
                return bean;
               //return manager.insert(bean, OptionsBuilder.ifNotExists());
            } else {

                mapper.save(bean);
//               manager.insertOrUpdate(bean);
               return bean;
            }
        } catch (Exception e) {
            logger.error("Cassandra Exception while saving", e);
            throw new DataAccessException(e);
        }

    }

    public T get(K... key) throws DataAccessException {

        try {

            return (T)mapper.get(key);
//            T proxy = manager.find(getDomainClass(), key);
//            if(proxy != null)
//                return manager.removeProxy(proxy);
//            else
//                return null;

        } catch (Exception ex) {
            logger.error("Cassandra Exception while fetching", ex);
            throw new DataAccessException(ex);
        }

    }

    public T getForUpdate(K... key) throws DataAccessException {

        try {

            return (T)mapper.get(key);
//            return manager.find(getDomainClass(), key);
        } catch (Exception ex) {
            logger.error("Cassandra Exception while fetching", ex);
            throw new DataAccessException(ex);
        }

    }

//    public void delete(K key) throws DataAccessException {
//        delete(key, null);
//    }

    public void delete(K... key) throws DataAccessException {

        try {
            mapper.delete(key);
            //manager.deleteById(getDomainClass(), key);
        } catch (Exception ex) {
            logger.error("Cassandra Exception while fetching", ex);
            throw new DataAccessException(ex);
        }

    }

   /* public DomainBucket<T> getDomainBucket(IRiakClient client, String bucketName, Class<T> clazz, boolean enableMutator)
            throws DataAccessException {

        try {
            Bucket bucket = client.fetchBucket(bucketName).execute();

            if (bucket == null || !updateBucketProps) {
                bucket = client.createBucket(bucketName).allowSiblings(allowSibling()).execute();
                updateBucketProps = true;
            }

            DomainBucketBuilder<T> domainBucketBuilder = DomainBucket.builder(bucket, clazz)
                    // .withResolver(new MergeCartResolver())
                    .returnBody(true).retrier(new DefaultRetrier(4)).w(w()).dw(dw())
                    .r(r());//.rw(1)
                    // .mutationProducer(new CartMutator())
            
            if(enableMutator) {
                MutationProducer<T> mutator = getMutationProducer();
                if(mutator != null)
                    domainBucketBuilder = domainBucketBuilder.mutationProducer(mutator);
            }
            
            ConflictResolver conflictResolver = getConflictResolver();
            if(conflictResolver != null) {
                domainBucketBuilder = domainBucketBuilder.withResolver(conflictResolver);
            }
            
            Converter converter = getConverter(bucketName);
            if(converter != null) {
                domainBucketBuilder = domainBucketBuilder.withConverter(converter);
            }
                    
            final DomainBucket<T> domainBucket =  domainBucketBuilder.build();

            return domainBucket;
        } catch (Exception e) {
            throw new DataAccessException(e);
        }
    }*/

    
    protected void prePersist(T t) { //update the bean before saving
        
    }

//    protected String getCountryBucketName(String countryCode) {
//
//        if (countryCode == null) {
//            return getBucketName();
//        } else {
//            return countryCode + "_" + getBucketName();
//        }
//    }

//    protected IRiakClient getConnection() throws DataAccessException {
//        return RiakConnectionFactory.getInstance().getConnection();
//    }
//
//    protected void returnConnection(IRiakClient client) {
//        RiakConnectionFactory.getInstance().returnConnection(client);
//    }

}
