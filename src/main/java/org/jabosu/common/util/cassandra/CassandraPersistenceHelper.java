package org.jabosu.common.util.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.CodecRegistry;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.TypeCodec;
import com.datastax.driver.extras.codecs.enums.EnumNameCodec;
import com.datastax.driver.extras.codecs.enums.EnumOrdinalCodec;
import com.datastax.driver.mapping.MappingManager;
import com.typesafe.config.ConfigObject;
import org.jabosu.common.exception.BusinessRuntimeException;
import org.jabosu.common.services.api.ConfigService;
import org.jabosu.common.util.ConfigLoader;
import org.jabosu.common.util.InjectorHelper;
import org.jabosu.common.util.StringUtil;

import javax.validation.spi.ConfigurationState;
import java.util.List;
import java.util.Map;

/**
 * Created by satya on 9/5/15.
 */
public class CassandraPersistenceHelper {

    private static CassandraPersistenceHelper instance;

//    private PersistenceManager persistenceManager;
//    private AsyncManager asyncManager;

    private Session session;
    private MappingManager mappingManager;
    private static ConfigService config;

    private CassandraPersistenceHelper() {

        config = ConfigLoader.getConfig();

        String keyspace = config.getString("cassandra.keyspace");

       // String entityPackages = config.getString("cassandra.entity.packages");

        if(StringUtil.isEmpty(keyspace))
            throw new BusinessRuntimeException("Cassandra keyspace has not been set.");

//        PersistenceManagerFactory pmFactory = PersistenceManagerFactory.PersistenceManagerFactoryBuilder
//                .builder(getBuilder())
//                .withEntityPackages(entityPackages)
//                .withDefaultReadConsistency(ConsistencyLevel.ONE)
//                .withDefaultWriteConsistency(ConsistencyLevel.QUORUM)
//                .withKeyspaceName(keyspace)
//                .withExecutorServiceMinThreadCount(5)
//                .withExecutorServiceMaxThreadCount(30)
//                .forceTableCreation(true)
////                            .withJacksonMapper(new info.archinnov.achilles.demo.twitter.json.ObjectMapperFactoryBean().getObject())
//                .build();
//
//                persistenceManager = pmFactory.createPersistenceManager();
//                asyncManager = pmFactory.createAsyncManager();


        Cluster cluster = getBuilder();
        session = cluster.connect(keyspace);

//        MappingConfiguration configuration =
//                MappingConfiguration.builder()
//                        .withPropertyMapper(propertyMapper)
//                        .build();

        mappingManager = new MappingManager(session);

    }

    public static CassandraPersistenceHelper getInstance() {
        if(instance == null) {

            synchronized(CassandraPersistenceHelper.class) {
                if(instance == null) {
                    instance = new CassandraPersistenceHelper();

                }
            }
        }

        return instance;
    }

    public static Cluster getBuilder() {
//        ConfigService config = getConfig();

        String user = config.getString("cassandra.user");
        String password = config.getString("cassandra.pwd");

        List cassandraHosts = config.getList("cassandra.hosts");

        Cluster.Builder builder = Cluster.builder();

        for(Object cassandraHost: cassandraHosts) {
            ConfigObject obj = (ConfigObject)cassandraHost;

            String host = obj.get("host").unwrapped().toString();
            builder.addContactPoint(host);
        }

        if(!StringUtil.isEmpty(user) && !StringUtil.isEmpty(password))
            builder.withCredentials(user, password);

        return builder.build();
    }

    public Session getSession() {
        return session;
    }

    public MappingManager getMappingManager() {
        return mappingManager;
    }

    public void registerOrdinalEnum(Class clazz) {
        CodecRegistry.DEFAULT_INSTANCE
                .register(new EnumOrdinalCodec(clazz));
    }

    public void registerNameEnum(Class clazz) {
        CodecRegistry.DEFAULT_INSTANCE
                .register(new EnumNameCodec(clazz));
    }

    public void registerCodec(TypeCodec<?> clazz) {
        CodecRegistry.DEFAULT_INSTANCE
                .register(clazz);
    }
//    private void setPersistenceManager(PersistenceManager pm) {
//        this.persistenceManager = pm;
//    }
//
//    public PersistenceManager getPersistenceManager() {
//        return persistenceManager;
//    }
//
//    public void shutDown() {
//        persistenceManager.shutDown();
//    }

//    private static ConfigService getConfig() {
//        ConfigService config = InjectorHelper.getInstance().getBean(ConfigService.class);
//
//        if (config == null) {
//            throw new BusinessRuntimeException("[ERROR] Looks like Config service has not been started yet.");
//        }
//
//        return config;
//    }

}
