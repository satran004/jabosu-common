package org.jabosu.common.dao.cassandra.dao;

import org.jabosu.common.dao.cassandra.dao.IDGenerator;
import org.slf4j.LoggerFactory;

/**
 *
 * @author satya
 */
public abstract class AbstractDao {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(AbstractDao.class.getName());
    protected boolean updateBucketProps = false;

    public AbstractDao() {
        //update bucket property
    }

//    public abstract String getBucketName();

    protected int dw() {
        return 0;
    }

    protected int w() {
        return 2;
    }

    protected int r() {
        return 2;
    }

//    protected boolean allowSibling() {
//        return false;
//    }
//
//    protected ConflictResolver getConflictResolver() {
//        return null;
//    }

//    protected MutationProducer getMutationProducer() {
//        return null;
//    }
//
//    protected Converter getConverter(String bucketName) {
//        return null;
//    }

    protected IDGenerator getIDGenerator() {return null;}

//    public Bucket getBucket(IRiakClient client, String bucketName)
//            throws DataAccessException {
//
//        try {
//            Bucket bucket = client.fetchBucket(bucketName).execute();
//
//            if (bucket == null || !updateBucketProps) {
//                bucket = client.createBucket(bucketName)
//                        .allowSiblings(allowSibling())
//                        .withRetrier(new DefaultRetrier(4))
//                        .r(r())
//                        .w(w())
//                        .dw(dw())
//                        .execute();
//
//                updateBucketProps = true;
//            }
//
//            return bucket;
//        } catch (Exception e) {
//            throw new DataAccessException(e);
//        }
//    }

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
