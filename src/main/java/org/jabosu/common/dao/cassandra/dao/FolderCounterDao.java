package org.jabosu.common.dao.cassandra.dao;

import org.jabosu.common.exception.DataAccessException;
import org.jabosu.common.dao.cassandra.dao.BaseDao;
import org.jabosu.common.util.Tuple3;
import org.jabosu.common.CounterModel;
import org.jabosu.common.CounterType;

import java.util.UUID;
//import models.common.CounterModel.CounterKey;

/**
 * Created by satya on 2/8/15.
 */
public abstract class FolderCounterDao<T extends CounterModel> extends BaseDao<T, Object> {

    public abstract T newInstance();

    public abstract void increment(Object folderId, String type, int splitId, int by) throws DataAccessException;

    public abstract void decrement(Object folderId, String type, int splitId, int by) throws DataAccessException;

//    {
//        T counterModel = get(key);
//
//        if(counterModel == null) {
//            T counter = newInstance();
//            counter.setId(key);
//            counter.setCounter(CounterBuilder.incr());
//            save(counter);
//
//            counterModel = getForUpdate(key);
//        }
//
//        counterModel.getCounter().incr(by);
//
//        long count = counterModel.getCounter().get();
//
//        save(counterModel);
//
//        return count;
//    }

   /* public long decrement(CounterKey key, long by) throws DataAccessException{
        T counterModel = get(key);

        if(counterModel == null) {
            T counter = newInstance();
            counter.setId(key);
            counter.setCounter(CounterBuilder.incr());
            save(counter);

            counterModel = getForUpdate(key);
        }

        if(counterModel.getCounter().get() - by < 0)
            by = counterModel.getCounter().get();

        if(counterModel.getCounter().get() < 0) { //counter is already negative..Increase the counter to reset it
            counterModel.getCounter().incr(-counterModel.getCounter().get());
        } else {
            counterModel.getCounter().decr(by);
        }

        long count = counterModel.getCounter().get();

        save(counterModel);

        return count;
    } */

}
