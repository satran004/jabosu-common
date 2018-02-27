package org.jabosu.common.util;

import java.io.UnsupportedEncodingException;

/**
 *
 * @author satya
 */
public class URLUtil {
 
    public static String getUserPhotoUrl(String userId) {
        return EnvConfig.getGlobalBucketUrl("photo/users/" + userId + "/profile_photo/main.jpg");
    }
    
    public static String getUserThumbnailPhotoUrl(String userId) {
        return EnvConfig.getGlobalBucketUrl("photo/users/" + userId + "/profile_photo/thumb.jpg");
    }
    
    public static String getUserProfilePhotoBaseURL() {
        return EnvConfig.getGlobalBucketUrl("photo/users/");
    }
    
    public static String buildOriginalUrl(String originalUrl) { //needed for play authenticate
        try {
            return "originalUrl=" + java.net.URLEncoder.encode(originalUrl, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
        }
        
        return "";
    }
    
}
