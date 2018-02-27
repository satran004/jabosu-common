package org.jabosu.common.dao.cassandra.dao;

import org.jabosu.common.exception.DataAccessException;
import org.jabosu.common.Model;

/**
 *
 * @author satya
 */
public interface MutationGetter<T extends Model, K> {

    public T find(T model, K... key) throws DataAccessException;
}
