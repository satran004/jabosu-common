package org.jabosu.common.dao.cassandra.dao;

import org.jabosu.common.exception.DataAccessException;
import org.jabosu.common.dao.cassandra.dao.BaseDao;
import org.jabosu.common.util.Tuple;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by satya on 3/6/15.
 */
public abstract class WideRowDao<T, K extends Tuple, Z extends Tuple> extends BaseDao<T, Object> {


    public T add(T bean) throws DataAccessException {
        updateKeyIfRequired(bean);
        return super.save(bean);
    }

    @Override
    public T get(Object... key) throws DataAccessException {
        return super.get(key);
    }

    public List<T> getPrevMessages(K partitionKey, Z clusterKey, int count, K firstPartitionKey) throws DataAccessException {

        List<T> coll = new ArrayList<>();

        K partKey = partitionKey;
        int recCount = count;
        while(coll == null || coll.size() < count) {

            List<T> result = null;

            if(clusterKey == null) {
            //if (partKey == null || getClusteringKeys(partKey) == null) {
//                result = manager.sliceQuery(getDomainClass())
//                        .forSelect()
//                        .withPartitionComponents(getPartitionKeys(partKey))
//                        .limit(recCount)
//                        .get();
                result = getPrevMessages(partKey, null, recCount);

            } else {
//                result = manager.sliceQuery(getDomainClass())
//                        .forSelect()
//                        .withPartitionComponents(getPartitionKeys(partKey))
//                        .fromExclusiveToInclusiveBounds()
//                        .fromClusterings(getClusteringKeys(partKey))
//                        .limit(recCount)
//                        .get();

                result = getPrevMessages(partKey, clusterKey, recCount);
            }

            if(result != null)
                coll.addAll(result);

            if(coll != null && coll.size() < count) {
                partKey = getPrevPartitionKey(partKey, firstPartitionKey);

                if(partKey == null)
                    return coll;

                recCount = count - coll.size();
            }
        }

//        if(coll != null && !coll.isEmpty() && coll.size() < count) {
////            ConversationNotification notification = coll.get(coll.size() - 1).getNotification();
////            if(notification != null)
////                notification.setIsFirst(true);
//        }

        return coll;
    }

    public List<T> getNextMessages(K partitionKey, Z clusterKey, int count, K lastPartitionKey) throws DataAccessException {

        List<T> coll = new ArrayList<>();

        K partKey = partitionKey;
        int recCount = count;
        while(coll == null || coll.size() < count) {

            List<T> result = null;
            if(clusterKey == null) {
//            if (partKey == null || getClusteringKeys(partKey) == null) {
//                result = manager.sliceQuery(getDomainClass())
//                        .forSelect()
//                        .withPartitionComponents(getPartitionKeys(partKey))
////                        .orderByDescending()
//                        .limit(recCount)
//                        .get();

                  result = getNextMessages(partKey, null, recCount);
            } else {
//                result = manager.sliceQuery(getDomainClass())
//                        .forSelect()
//                        .withPartitionComponents(getPartitionKeys(partKey))
//                        .fromInclusiveToExclusiveBounds()
//                        .toClusterings(getClusteringKeys(partKey))
////                        .orderByDescending()
//                        .limit(recCount)
//                        .get();

                   result = getNextMessages(partKey, clusterKey, recCount);
            }

            if(result != null)
                coll.addAll(result);

            if(coll != null && coll.size() < count) {
                partKey = getNextPartitionKey(partKey, lastPartitionKey);

                if(partKey == null)
                    return coll;

                recCount = count - coll.size();
            }

        }

//        if(coll != null && !coll.isEmpty() && coll.size() < count) {
////            ConversationNotification notification = coll.get(coll.size() - 1).getNotification();
////            if(notification != null)
////                notification.setIsFirst(true);
//        }

        return coll;
    }


    public abstract void updateKeyIfRequired(T bean) throws DataAccessException;

    public abstract K getPrevPartitionKey(K k, K firstKey);

    public abstract K getNextPartitionKey(K k, K lastKey);

//    public abstract Object[] getPartitionKeys(K key);
//
//    public abstract Object[] getClusteringKeys(Z key);

    protected abstract List<T> getPrevMessages(K partitionKeys, Z clusteringKeys, int count);

    protected abstract List<T> getNextMessages(K partitionKeys, Z clusteringKeys, int count);


}
