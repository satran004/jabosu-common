package org.jabosu.common.dao.cassandra.dao;

import org.jabosu.common.exception.DataAccessException;
import org.jabosu.common.util.search.ElasticSearchFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jabosu.common.Model;
import org.elasticsearch.action.index.IndexResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by satya on 15/8/15.
 */
public abstract class SearchDao<T, K> extends BaseDao<T, K> {

    private static Logger logger = LoggerFactory.getLogger(SearchDao.class.getName());
    private static ObjectMapper mapper = new ObjectMapper();

    @Override
    public T save(T bean) throws DataAccessException {
        T newBean = super.save(bean);

        try {
            doIndex(newBean);
        } catch (Exception e) {
            logger.error("Error in index", e);
        }

        return newBean;
    }

    @Override
    public T saveNew(T bean) throws DataAccessException {
        T newBean = super.saveNew(bean);

        try {
            doIndex(newBean);
        } catch (Exception e) {
            logger.error("Error in index", e);
        }

        return newBean;
    }

    @Override
    public void delete(K... key) throws DataAccessException {
        super.delete(key);

        ElasticSearchFactory
                .getInstance()
                .getClient()
                .prepareDelete(getIndexName(), getType(), key.toString())
                .execute()
                .actionGet();
    }

    private void doIndex(T bean) throws Exception{
        IndexResponse response = ElasticSearchFactory
                .getInstance()
                .getClient()
                .prepareIndex(getIndexName(), getType(), ((Model) bean).key())
                .setSource(getJsonString(bean))
                .execute()
                .actionGet();
    }
    private String getJsonString(Object bean) throws Exception {

        try {
            String json = mapper.writeValueAsString(bean);
            return json;
        } catch (JsonProcessingException e) {
            logger.error("Search index failed. Bean could not be converted to json", e);
            throw e;
        }

    }

    protected abstract Object getSearchBean(T bean);

    protected abstract String getIndexName();

    protected abstract String getType();
}
