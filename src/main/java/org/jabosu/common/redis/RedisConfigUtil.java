package org.jabosu.common.redis;

/**
 *
 * @author satya
 */
public class RedisConfigUtil {

    /** TODO

    public static void initRedisConfig() {
        
        ConfigService config = getConfig();
        
        List writeNodes = config.getList("redis.write.nodes");
        List readNodes = config.getList("redis.read.nodes");
        
        JedisConnectionFactory.getInstance().init(readNodes, writeNodes, getReadPoolConfig(config), getWritePoolConfig(config));
    }

    private static GenericObjectPoolConfig getReadPoolConfig(ConfigService config) {

        if (config == null) {
            throw new BusinessRuntimeException("[ERROR] Looks like Config service has not been started yet.");
        }

        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setBlockWhenExhausted(true);
        poolConfig.setMaxIdle(config.getInt("redis.read.pool.max.idle"));
        poolConfig.setMaxTotal(config.getInt("redis.read.pool.max.total"));
        poolConfig.setMinIdle(config.getInt("redis.read.pool.min.idle"));
        poolConfig.setMaxWaitMillis(config.getInt("redis.read.pool.max.wait.millis"));
        poolConfig.setMinEvictableIdleTimeMillis(config.getInt("redis.read.pool.min.evictable.idle.time.millis"));
        poolConfig.setTestOnBorrow(config.getBoolean("redis.read.pool.test.on.borrow"));
        poolConfig.setTestOnReturn(config.getBoolean("redis.read.pool.test.on.return"));
        poolConfig.setTestWhileIdle(config.getBoolean("redis.read.pool.test.while.idle"));
        poolConfig.setTimeBetweenEvictionRunsMillis(config.getInt("redis.read.pool.time.between.eviction.runs.millis"));

        return poolConfig;
    }
    
    private static GenericObjectPoolConfig getWritePoolConfig(ConfigService config) {

        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setBlockWhenExhausted(true);
        poolConfig.setMaxIdle(config.getInt("redis.write.pool.max.idle"));
        poolConfig.setMaxTotal(config.getInt("redis.write.pool.max.total"));
        poolConfig.setMinIdle(config.getInt("redis.write.pool.min.idle"));
        poolConfig.setMaxWaitMillis(config.getInt("redis.write.pool.max.wait.millis"));
        poolConfig.setMinEvictableIdleTimeMillis(config.getInt("redis.write.pool.min.evictable.idle.time.millis"));
        poolConfig.setTestOnBorrow(config.getBoolean("redis.write.pool.test.on.borrow"));
        poolConfig.setTestOnReturn(config.getBoolean("redis.write.pool.test.on.return"));
        poolConfig.setTestWhileIdle(config.getBoolean("redis.write.pool.test.while.idle"));
        poolConfig.setTimeBetweenEvictionRunsMillis(config.getInt("redis.write.pool.time.between.eviction.runs.millis"));

        return poolConfig;
    }
    
    private static ConfigService getConfig() {
        ConfigService config = InjectorHelper.getInstance().getBean(ConfigService.class);

        if (config == null) {
            throw new BusinessRuntimeException("[ERROR] Looks like Config service has not been started yet.");
        }
        
        return config;
    }
     **/
}
