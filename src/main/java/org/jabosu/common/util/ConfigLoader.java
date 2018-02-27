package org.jabosu.common.util;

import org.jabosu.common.services.api.ConfigService;
import com.google.inject.Inject;

/**
 *
 * @author satya
 */
public class ConfigLoader {
    
    private static ConfigLoader instance;
    private static ConfigService configService;
    
    @Inject
    private ConfigLoader(ConfigService configService) {
        this.configService = configService;
    }
    
//    public static ConfigLoader getInstance() {
//        if(instance == null) {
//            instance = new ConfigLoader();
//        } 
//        
//        return instance;
//    }
//    
//    public void init() {
//        configService = new JobsConfigServiceImpl();
//    }

    public static void setConfigService(ConfigService impl) {
        configService = impl;
    }
    
    public static ConfigService getConfig() {
        return configService;
    }
}
