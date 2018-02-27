package org.jabosu.common.util;

import org.jabosu.common.services.api.ConfigService;

public class EnvConfig {            
        private static String NAMESPACE = ""; //for prod it should be empty
        private static String APP_NAME;
        private static String APP_ENV;  //for S3 upload
        private static String WEBSITE_NAME;
        private static String WEBSITE_TITLE;
        private static String WEBSITE_TITLE_PREFIX;
        private static boolean COMMENTS_ENABLED; 
        private static String DISQUAS_SHORT_NAME;
        private static String COPYRIGHT;
        private static String LOGO;
        private static String META_KEYWORDS;
        private static String META_DESCRIPTION;
        private static String PROFILE_META_KEYWORDS;
        private static String TnC_URL;
        private static int MAX_PROFILE_COUNT_PER_USER;
        private static int MAX_DEALS_PER_SERVICE;
        private static int MAX_PHOTOS_PER_DEAL;
        private static String CUSTOMER_SUPPORT_EMAIL;
        private static String ADMIN_EMAIL;
        private static String CONTACT_US_EMAIL;
        private static String DEFAULT_EMAIL_SENDER;
        private static String BUILD;
        
        private static String GLOBAL_FILE_BASE_URL;
        private static String FILE_BUCKET_BASE_URL; //s3 url
	
	private static EnvConfig instance = null;
      
	private EnvConfig() {
		initEnvConfig();
	}
	
	public static EnvConfig getInstance() {
		if(instance == null) {
			synchronized(EnvConfig.class) {
				if(instance == null) {
					instance = new EnvConfig();
				}
			}
		}
		
		return instance;
	}
	
	public void initEnvConfig() {
                
                ConfigService configService = InjectorHelper.getInstance().getBean(ConfigService.class);
                NAMESPACE = configService.getString("application.namespace");
		        APP_NAME = configService.getString("application.name");
                APP_ENV = configService.getString("app.env");
                WEBSITE_NAME = configService.getString("website.name");
                WEBSITE_TITLE = configService.getString("website.title");
                WEBSITE_TITLE_PREFIX = configService.getString("website.titlePrefix");
                COMMENTS_ENABLED = configService.getBoolean("enable.comments");
                DISQUAS_SHORT_NAME = configService.getString("disquas.shortname");
                COPYRIGHT = configService.getString("copyright");
                LOGO = configService.getString("logo");
                META_KEYWORDS = configService.getString("meta_keywords");
                META_DESCRIPTION = configService.getString("meta_description");
                PROFILE_META_KEYWORDS = configService.getString("profile_meta_keywords");
                TnC_URL = configService.getString("terms.condition.url");
                MAX_PROFILE_COUNT_PER_USER = configService.getInt("max.free.profiles.peruser");
                
                MAX_DEALS_PER_SERVICE = configService.getInt("max.deals.per.service");
                MAX_PHOTOS_PER_DEAL = configService.getInt("max.photos.per.deal");
                
                CUSTOMER_SUPPORT_EMAIL = configService.getString("customer.support.email");
                ADMIN_EMAIL = configService.getString("admin.email");
                CONTACT_US_EMAIL= configService.getString("contact.us.email");
                DEFAULT_EMAIL_SENDER=configService.getString("default.email.sender");
                BUILD = configService.getString("build");
                
                FILE_BUCKET_BASE_URL = configService.getString("s3.file.bucket");
                
                if("prod".equals(APP_ENV)) {
                    GLOBAL_FILE_BASE_URL = 
                            ApplicationConstants.FILE_BUCKET_PROTOCOL + ApplicationConstants.GLOBAL_BUCKET_PREFIX + "." + FILE_BUCKET_BASE_URL + "/" + APP_NAME; 
                } else {
                    GLOBAL_FILE_BASE_URL = 
                            ApplicationConstants.FILE_BUCKET_PROTOCOL + APP_ENV + "." + ApplicationConstants.GLOBAL_BUCKET_PREFIX + "." + FILE_BUCKET_BASE_URL + "/" + APP_NAME;
                }
	}
	
        public String getEnvNamespace() { //To support multiple env in same riak instance
            if(StringUtil.isEmpty(NAMESPACE))
                return "";
            else
                return NAMESPACE + "_";
        }
        
	public String getApplicationName() {
            return getEnvNamespace() + APP_NAME;
	}
//        
//        public String getAppIDPrefix() {
//            return APP_ID_PREFIX;
//	}
        
        public String getApplicationEnv() {
            return APP_ENV;
        }
        
        public String getWebSiteName() {
            return WEBSITE_NAME;
        }
        
        public String websiteTitle() {
            return WEBSITE_TITLE;
        }
        
        public String websiteTitlePrefix() {
            return WEBSITE_TITLE_PREFIX;
        }
        
        public boolean isCommentsEnabled() {
            return COMMENTS_ENABLED;
        }
        
        public String getDisquasShortName() {
            return DISQUAS_SHORT_NAME;
        }

        public String copyright() {
            return COPYRIGHT;
        }
        
        public String logo() {
            return LOGO;
        }
        
        public String metaKeywords() {
            return META_KEYWORDS;
        }
        
        public String metaDescription() {
            return META_DESCRIPTION;
        }
        
        public String profileMetaKeywords() {
            return PROFILE_META_KEYWORDS;
        }
        
        public String tncUrl() {
            return TnC_URL;
        }
        
        public int maxProfileCountPerUser() {
            return MAX_PROFILE_COUNT_PER_USER;
        }
        
        public int maxDealsPerService() {
            return MAX_DEALS_PER_SERVICE;
        }
        
        public int maxPhotosPerDeal() {
            return MAX_PHOTOS_PER_DEAL;
        }
        
        public String cutomerSupportEmail() {
            return CUSTOMER_SUPPORT_EMAIL;
        }
        
        public String adminEmail() {
            return ADMIN_EMAIL;
        }
        
        public String contactEmail() {
            return CONTACT_US_EMAIL;
        }
        
        public String defaultEmailSender() {
            return DEFAULT_EMAIL_SENDER;
        }
        
        public String build() {
            return BUILD;
        }
        
        public static String wrapWithNameSpace(String id) {
            return EnvConfig.getInstance().getApplicationName() + "_" + id;
        }
        
        public static String socialUrl(String key, String countryCode) {
            String url = ConfigLoader.getConfig().getString(countryCode + "." + key);
            if(StringUtil.isEmpty(url)) {
                return ConfigLoader.getConfig().getString(key);
            } else {
                return url;
            }
        }
        
        public static String getGlobalBucketBaseUrl() {
            return GLOBAL_FILE_BASE_URL;
        }
        
        public static String getGlobalBucketUrl(String path) {
            return GLOBAL_FILE_BASE_URL + "/" + path;
        }
        
        public static String getCountrySpecificBucketUrl(String countryCode) {
            return countryCode + "." + FILE_BUCKET_BASE_URL;
        }
        
        public static String getCountrySpecificBucketUrl(String countryCode, String path) {
            return countryCode + "." + FILE_BUCKET_BASE_URL + "/" + path;
        }
        
}
