package org.jabosu.common;

import org.jabosu.common.util.MessageUtil;
import org.jabosu.common.util.StringUtil;
import java.util.List;

/**
 *
 * @author satya
 */
public class Category {
    public String label;
    public String alternateLabel; //needed for other -> others
    public String code;
    public String type;
    public String mainCategory; //only set for subcategories
    public List<String> banner;
    public String thumbnail;
    public String errorThumbnail;
    public List<Category> subcategories; 
    public String tagline2;

    public String url; //for user friendly url
    
    public String description() {
        return label;
    }
    
    public String tagline1(String city) {
      
        if(alternateLabel != null) {
            return MessageUtil.get("category.banner.default.label", "", alternateLabel,  city);
        } else
            return MessageUtil.get("category.banner.default.label", "", label,  city);
          
    }
    
    public String tagline2() {
        if(!StringUtil.isEmpty(tagline2))
            return tagline2;
        else 
            return "";
    }

    public String getUrl(){
        if(url == null)
            return code;
        else
            return url;
    }
    
}
