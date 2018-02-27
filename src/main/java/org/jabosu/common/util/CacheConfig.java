package org.jabosu.common.util;


import org.jabosu.common.exception.BusinessRuntimeException;
import org.jabosu.common.services.api.ConfigService;

/**
 *
 * @author satya
 */
public class CacheConfig {
    
    private static String KEY_CACHE_ENABLED = "key.cache.enabled";
    private static String KEY_CACHE_DEFAULT_EXPIRATION_TIME = "key.cache.default.expiration.time";

    private static ConfigService config;
    
    public static boolean isKeyCacheEnabled() {
        return getConfig().getBoolean(KEY_CACHE_ENABLED);
    }
    
    public static int getDefaultKeyCacheExpirationTime() {
        return getConfig().getInt(KEY_CACHE_DEFAULT_EXPIRATION_TIME);
    }

    private static ConfigService getConfig() {
        if(config == null)
            config = ConfigLoader.getConfig();

        if (config == null) {
            throw new BusinessRuntimeException("[ERROR] Looks like Config service has not been started yet.");
        }

        return config;
    }
}
