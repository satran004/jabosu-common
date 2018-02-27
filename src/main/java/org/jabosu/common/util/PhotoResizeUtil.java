package org.jabosu.common.util;

import java.util.Map;

/**
 *
 * @author satya
 */
public class PhotoResizeUtil {
    
    private static double userPhotoWidth;
    private static double userPhotoHeight;
    private static double userThumbWidth;
    private static double userThumbHeight;
    
    private static double profileWidth;
    private static double profileHeight;
    private static double profileThumbWidth;
    private static double profileThumbHeight;
    
    public static double getUserPhotoWidth() {
        if(userPhotoWidth == 0)
            userPhotoWidth = getDoubleValue(getMainObj("user.profile.photo").get("width"));
        
        return userPhotoWidth;
    }
    
    public static double getUserPhotoHeight() {
        if(userPhotoHeight == 0)
            userPhotoHeight = getDoubleValue(getMainObj("user.profile.photo").get("height"));
        
        return userPhotoHeight;
    }
    
    public static double getUserThumbnailPhotoWidth() {
        
        if(userThumbWidth == 0)
            userThumbWidth = getDoubleValue(getThumbnailObj("user.profile.photo").get("width"));
        
        return userThumbWidth;
    }
    
    public static double getUserThumbnailPhotoHeight() {
         if(userThumbHeight == 0)
            userThumbHeight = getDoubleValue(getThumbnailObj("user.profile.photo").get("height"));
        
        return userThumbHeight;
    }
    
    public static double getProfilePhotoWidth() {
        
        if(profileWidth == 0)
            profileWidth = getDoubleValue(getMainObj("profile.photo").get("width"));
        
        return profileWidth; 
    }
    
    public static double getProfilePhotoHeight() {
        if(profileHeight == 0)
            profileHeight = getDoubleValue(getMainObj("profile.photo").get("height"));
        
        return profileHeight;
    }
    
    public static double getProfileThumbnailPhotoWidth() {
        if(profileThumbWidth == 0)
            profileThumbWidth = getDoubleValue(getThumbnailObj("profile.photo").get("width"));
        
        return profileThumbWidth;
    }
    
    public static double getProfileThumbnailPhotoHeight() {
        if(profileThumbHeight == 0)
            profileThumbHeight = getDoubleValue(getThumbnailObj("profile.photo").get("height"));
        
        return profileThumbHeight;
    }
    
    public static String getResizeFilePath(String orgFile, String resizeFileName) {

        if(orgFile == null)
            return resizeFileName;
        
        String filename = orgFile;
                        
        int index = orgFile.lastIndexOf("/"); //see if the file has a prefix path also. Then remove the folder path from file name
        if (index != -1) {
            filename = orgFile.substring(index + 1); 
        }

        int ext = filename.lastIndexOf(".");
        if(ext == -1) {
            return filename + "/" + resizeFileName;
        }
           
	String folderName = filename.substring(0, ext);
	
        String extension = filename.substring(ext);
        
        return folderName + "/" + resizeFileName + extension;
    }
    
    private static Map getThumbnailObj(String key) {
       return (Map)ConfigLoader.getConfig().getList(key).get(1); 
    }
    
    private static Map getMainObj(String key) {
        return (Map)ConfigLoader.getConfig().getList(key).get(0);
    }
    
    private static double getDoubleValue(Object value) {
        if(value instanceof Double)
            return (double)value;
        else
            return Double.parseDouble(value.toString());
    }
}
