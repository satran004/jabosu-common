package org.jabosu.common.util;

public class BucketConstant {
        
	private static String SIGNUP_USERS_BUCKET;
        private static String USER_EMAIL_ID_MAPPING_BUCKET;
	private static String USERS_BUCKET;
        private static String USERS_ACCOUNT_INFO_BUCKET;
	private static String TENDERS_BUCKET;
	private static String PROFILE_METADATA_BUCKET;
	private static String PROFILE_BUCKET;
	private static String PROFILE_ASSETS_BUCKET;
        private static String PROFILE_ACCOUNT_BUCKET;
        private static String USER_PROFILES_MAPPING_BUCKET;
        private static String EXT_USER_BUCKET;
        private static String TOKEN_BUCKET;
        
        //messages bucket
//        private static String USER_INBOX_BUCKET;
//        private static String USER_OUTBOX_BUCKET;
//        private static String PROFILE_INBOX;
//        private static String PROFILE_OUTBOX;
        private static String CONVERSATION_BUCKET;
        private static String CONVERSATION_MESSAGE_LIST_BUCKET;
        private static String MESSAGE_BUCKET;
        private static String MESSAGE_FOLDERS_BUCKET;
        private static String MESSAGE_METADATA_LIST_BUCKET;
        private static String MESSAGE_FOLDER_COUNTER_BUCKET;
        
        //Wall buckets
        private static String WALL_FOLDERS_BUCKET;
        private static String WALL_FOLDER_CONVERSATION_LIST_BUCKET;
        
       // private static String WALL_CONVERSATION_BUCKET;
        //private static String WALL_CONVERSATION_MESSAGE_LIST_BUCKET;
        private static String WALL_MESSAGE_BUCKET;
      //  private static String WALL_MESSAGE_FOLDERS_BUCKET;
        private static String WALL_COMMENT_NOTIFICATION_LIST_BUCKET;
        private static String WALL_COUNTER_BUCKET;
        
        private static String CMS_BUCKET; //app specific cms_bucket
        private static String CMS_PAGE_BUCKET;
        private static String GLOBAL_CMS_BUCKET;
        
        //dealbuckets
        private static String DEAL_BUCKET;
        private static String DEAL_META_BUCKET;
        private static String SERVICE_DEAL_LIST_BUCKET;
        
        // booking buckets
    	private static String BOOKING_BUCKET;
    	private static String BOOKING_CALENDAR_BUCKET;
    	private static String SERVICE_BOOKING_BUCKET;
    	private static String BOOKING_META_DATA_BUCKET;
        
        //social buckets
        private static String FOLLOWERS_BUCKET; //app specific bucket
        private static String FOLLOWER_FOLDERS_BUCKET; //appspecific
        
	
	private static boolean nameInitialized;
	
	public static void initBucketNames() {
            
                //Global buckets start here
		SIGNUP_USERS_BUCKET = EnvConfig.getInstance().getEnvNamespace() + "signup_users";
                USER_EMAIL_ID_MAPPING_BUCKET = EnvConfig.getInstance().getEnvNamespace() + "user_email_id_mapping";
		USERS_BUCKET=  EnvConfig.getInstance().getEnvNamespace() + "users";
                USERS_ACCOUNT_INFO_BUCKET = EnvConfig.getInstance().getEnvNamespace() + "user_account_info";              
                EXT_USER_BUCKET = EnvConfig.getInstance().getEnvNamespace() + "ext_users";
                TOKEN_BUCKET = EnvConfig.getInstance().getEnvNamespace() + "tokens";
                
                //messaging related buckets
                CONVERSATION_BUCKET = EnvConfig.getInstance().getApplicationName() + "_" + "conversations";
                CONVERSATION_MESSAGE_LIST_BUCKET = EnvConfig.getInstance().getApplicationName() + "_"  + "conversation_message_list";
                MESSAGE_BUCKET = EnvConfig.getInstance().getApplicationName() + "_"  + "messages";
//                USER_INBOX_BUCKET = EnvConfig.getInstance().getEnvNamespace() + "user_inbox";
//                USER_OUTBOX_BUCKET = EnvConfig.getInstance().getEnvNamespace() + "user_outbox";
                MESSAGE_FOLDERS_BUCKET = EnvConfig.getInstance().getApplicationName() + "_" + "message_folders"; 
                MESSAGE_METADATA_LIST_BUCKET = EnvConfig.getInstance().getApplicationName() + "_" + "message_metadata_list"; 
		MESSAGE_FOLDER_COUNTER_BUCKET = EnvConfig.getInstance().getApplicationName() + "_" + "message_folder_counter_bucket"; 
                
                //wall messaging related buckets
                WALL_FOLDERS_BUCKET = EnvConfig.getInstance().getApplicationName() + "_" + "wall_folders";
                WALL_FOLDER_CONVERSATION_LIST_BUCKET = EnvConfig.getInstance().getApplicationName() + "_"  + "wall_folder_conversation_list";
                        
               // WALL_CONVERSATION_BUCKET = EnvConfig.getInstance().getApplicationName() + "_" + "wall_conversations";
               // WALL_CONVERSATION_MESSAGE_LIST_BUCKET = EnvConfig.getInstance().getApplicationName() + "_"  + "wall_conversation_message_list";
                WALL_MESSAGE_BUCKET = EnvConfig.getInstance().getApplicationName() + "_"  + "wall_messages";
               // WALL_MESSAGE_FOLDERS_BUCKET = EnvConfig.getInstance().getApplicationName() + "_" + "wall_message_folders"; 
                WALL_COMMENT_NOTIFICATION_LIST_BUCKET = EnvConfig.getInstance().getApplicationName() + "_" + "wall_comment_notification_list"; 
		WALL_COUNTER_BUCKET = EnvConfig.getInstance().getApplicationName() + "_" + "wall_counter_bucket"; 
		
                //Country specific buckets start here
                PROFILE_METADATA_BUCKET = EnvConfig.getInstance().getApplicationName() + "_" + "profiles_metadata";
		PROFILE_BUCKET = EnvConfig.getInstance().getApplicationName() + "_" + "profiles";
		PROFILE_ASSETS_BUCKET = EnvConfig.getInstance().getApplicationName() + "_" + "profile_assets";
                PROFILE_ACCOUNT_BUCKET = EnvConfig.getInstance().getApplicationName() + "_" + "profile_account";
                
                USER_PROFILES_MAPPING_BUCKET = EnvConfig.getInstance().getApplicationName() +  "_" + "user_profiles_mappings";        
                
//                PROFILE_INBOX = EnvConfig.getInstance().getApplicationName() + "_" + "profile_inbox";
//                PROFILE_OUTBOX = EnvConfig.getInstance().getApplicationName() + "_" + "profile_outbox";
                TENDERS_BUCKET = EnvConfig.getInstance().getApplicationName() + "_" + "tenders";
                
                CMS_BUCKET = EnvConfig.getInstance().getApplicationName() + "_" + "cms_bucket";
                CMS_PAGE_BUCKET = EnvConfig.getInstance().getApplicationName() + "_" + "cms_pages";
                GLOBAL_CMS_BUCKET = "global_cms_bucket";
                
                DEAL_BUCKET = EnvConfig.getInstance().getApplicationName() + "_" + "deals";
                DEAL_META_BUCKET = EnvConfig.getInstance().getApplicationName() + "_" + "deals_metadata";
                SERVICE_DEAL_LIST_BUCKET = EnvConfig.getInstance().getApplicationName() + "_" + "service_deal_list";
                
                BOOKING_BUCKET = EnvConfig.getInstance().getApplicationName() + "_"
        				+ "bookings";
                BOOKING_CALENDAR_BUCKET = EnvConfig.getInstance().getApplicationName() + "_"
        				+ "bookings_calendar";
                BOOKING_META_DATA_BUCKET = EnvConfig.getInstance().getApplicationName() + "_"
        				+ "booking_meta_data";
                
                //Application specific bucket
                FOLLOWERS_BUCKET = EnvConfig.getInstance().getApplicationName() + "_" + "followers";
                FOLLOWER_FOLDERS_BUCKET = EnvConfig.getInstance().getApplicationName() + "_" + "follower_folders";
                
		nameInitialized = true;
	}
	
	public static String getSignUpUsersBucket() {
		if(!nameInitialized)
			initBucketNames();
		
		return SIGNUP_USERS_BUCKET;
	}
        
        public static String getUserEmailIdMappingBucket() {
		if(!nameInitialized)
			initBucketNames();
		
		return USER_EMAIL_ID_MAPPING_BUCKET;
	}
	
	public static String getUsersBucket() {
		if(!nameInitialized)
			initBucketNames();
		
		return USERS_BUCKET;
	}
        
        public static String getUserAccountInfoBucket() {
            if(!nameInitialized)
                initBucketNames();
            
            return USERS_ACCOUNT_INFO_BUCKET;
        }
	
	public static String getTenderBucket() {
		if(!nameInitialized)
			initBucketNames();
		
		return TENDERS_BUCKET;
	}
	
	public static String getProfileMetaDataBucket() {
		if(!nameInitialized)
			initBucketNames();
		
		return PROFILE_METADATA_BUCKET;
	}
	
	public static String getProfileBucket() {
		if(!nameInitialized)
			initBucketNames();
		
		return PROFILE_BUCKET;
	}
	
	public static String getProfileAssetsBucket() {
		if(!nameInitialized)
			initBucketNames();
		
		return PROFILE_ASSETS_BUCKET;
	}
        
        public static String getProfileAccountBucket() {
                if(!nameInitialized)
			initBucketNames();
		
		return PROFILE_ACCOUNT_BUCKET;
        }
        
        public static String getUserProfilesMappingBucket() {
		if(!nameInitialized)
			initBucketNames();
		
		return USER_PROFILES_MAPPING_BUCKET;
	}
	
        public static String getExtUserBucket() {
		if(!nameInitialized)
			initBucketNames();
		
		return EXT_USER_BUCKET;
	}
        
        public static String getTokensBucket() {
		if(!nameInitialized)
			initBucketNames();
		
		return TOKEN_BUCKET;
	}
        
//        public static String getUserInboxBucket() {
//            if(!nameInitialized)
//			initBucketNames();
//		
//		return USER_INBOX_BUCKET;
//        }
//        
//        public static String getUserOutboxBucket() {
//            if(!nameInitialized)
//			initBucketNames();
//		
//		return USER_OUTBOX_BUCKET;
//        }
        
        public static String getConversationsBucket() {
            if(!nameInitialized) {
                initBucketNames();
            }
            
            return CONVERSATION_BUCKET;
        }
        
        public static String getMessagesBucket() {
            if(!nameInitialized) {
                initBucketNames();
            }
            
            return MESSAGE_BUCKET;
        }
        
//        private static String getProfileInboxBucket() {
//            if(!nameInitialized) {
//                initBucketNames();
//            }
//            
//            return PROFILE_INBOX;
//        }
//        
//        private static String getProfileOutboxBucket() {
//            if(!nameInitialized) {
//                initBucketNames();
//            }
//            
//            return PROFILE_OUTBOX;
//        }
        
        public static String getMessageFolderBucket() {
            if(!nameInitialized) {
                initBucketNames();
            }
            
            return MESSAGE_FOLDERS_BUCKET;
        }
        
        public static String getMessageFolderCounterBucket() {
            if(!nameInitialized) {
                initBucketNames();
            }
            
            return MESSAGE_FOLDER_COUNTER_BUCKET;
        }
        
        public static String getMessageMetaDataListBucket() {
            if(!nameInitialized) {
                initBucketNames();
            }
            
            return MESSAGE_METADATA_LIST_BUCKET;
        }
        
        public static String getConversationMessageListBucket() {
            if(!nameInitialized) {
                initBucketNames();
            }
            
            return CONVERSATION_MESSAGE_LIST_BUCKET;
        }
        
        
        //Wall bucket
        public static String getWallFoldersBucket() {
            if(!nameInitialized) {
                initBucketNames();
            }
            
            return WALL_FOLDERS_BUCKET;
        }
        
        public static String getWallFolderConversationListBucket() {
            if(!nameInitialized) {
                initBucketNames();
            }
            
            return WALL_FOLDER_CONVERSATION_LIST_BUCKET;
        }
         
//        public static String getWallConversationsBucket() {
//            if(!nameInitialized) {
//                initBucketNames();
//            }
//            
//            return WALL_CONVERSATION_BUCKET;
//        }
        
        public static String getWallMessagesBucket() {
            if(!nameInitialized) {
                initBucketNames();
            }
            
            return WALL_MESSAGE_BUCKET;
        }
     
//        public static String getWallMessageFolderBucket() {
//            if(!nameInitialized) {
//                initBucketNames();
//            }
//            
//            return WALL_MESSAGE_FOLDERS_BUCKET;
//        }
        
        public static String getWallCounterBucket() {
            if(!nameInitialized) {
                initBucketNames();
            }
            
            return WALL_COUNTER_BUCKET;
        }
        
        public static String getWallCommentNotificationListBucket() {
            if(!nameInitialized) {
                initBucketNames();
            }
            
            return WALL_COMMENT_NOTIFICATION_LIST_BUCKET;
        }
        
//        public static String getWallConversationMessageListBucket() {
//            if(!nameInitialized) {
//                initBucketNames();
//            }
//            
//            return WALL_CONVERSATION_MESSAGE_LIST_BUCKET;
//        }
        
        
        public static String getCmsBucket() {
            if(!nameInitialized) {
                initBucketNames();
            }
            
            return CMS_BUCKET;
        }

        public static String getCmsPageBucket() {
            if(!nameInitialized) {
                initBucketNames();
            }

            return CMS_PAGE_BUCKET;
        }
        
        public static String getDealBucket() {
            if(!nameInitialized) {
                initBucketNames();
            }
            
            return DEAL_BUCKET;
        }
        
        public static String getDealMetaBucket() {
            if(!nameInitialized) {
                initBucketNames();
            }
            
            return DEAL_META_BUCKET;
        }
        
         public static String getServiceDealListBucket() {
            if(!nameInitialized) {
                initBucketNames();
            }
            
            return SERVICE_DEAL_LIST_BUCKET;
        }
         
        public static String getBookingBucket() {
     		if (!nameInitialized) {
     			initBucketNames();
     		}
     		return BOOKING_BUCKET;
     	} 
        
        public static String getBookingCalendarBucket() {
     		if (!nameInitialized) {
     			initBucketNames();
     		}
     		return BOOKING_CALENDAR_BUCKET;
     	} 
        
        public static String getServiceBookingBucket() {
     		if (!nameInitialized) {
     			initBucketNames();
     		}
     		return SERVICE_BOOKING_BUCKET;
     	}
        
        public static String getBookingMetaDataBucket() {
     		if (!nameInitialized) {
     			initBucketNames();
     		}
     		return BOOKING_META_DATA_BUCKET;
     	} 
        
        public static String getGlobalCmsBucket() {
            return GLOBAL_CMS_BUCKET;
        }
        
        public static String getFollowersBucket() {
            return FOLLOWERS_BUCKET;
        }
        
        public static String getFollowerFoldersBucket() {
            return FOLLOWER_FOLDERS_BUCKET;
        }
        
        public static String getProfileBucket(String countryCode) {
            return countryCode + "_" + getProfileBucket();
        }
        
        public static String getProfileAssetsBucket(String countryCode) {
            return countryCode + "_" + getProfileAssetsBucket();
        }
        
        public static String getProfileMetaDataBucket(String countryCode) {
            return countryCode + "_" + getProfileMetaDataBucket();
        }
        
//        public static String getProfileInboxBucket(String countryCode) {
//            return countryCode + "_" + getProfileInboxBucket();
//        }
//        
//        public static String getProfileOutboxBucket(String countryCode) {
//            return countryCode + "_" + getProfileOutboxBucket();
//        }
        
        public static String getCountryBucketName(String countryCode, String bucketName) {

            if (countryCode == null) {
                return bucketName;
            } else {
                return countryCode + "_" + bucketName;
            }
        }
        
}
