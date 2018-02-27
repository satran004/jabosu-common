package org.jabosu.common.util;

import java.util.Collection;
import java.util.List;
import java.util.Map;


/**
 *
 * @author satya
 */
public class MessageUtil {

    /**
    public static String getFormErrorMessage(Form form) {

        StringBuilder builder = new StringBuilder();

        Map<String, List<ValidationError>> errors = form.errors();

        if (errors != null && errors.size() > 0) {
            Collection<List<ValidationError>> lerrors = errors.values();

            if (lerrors == null) {
                return "";
            }

            for (List<ValidationError> le : lerrors) {

                if (le == null || le.size() == 0) {
                    continue;
                }

                for (ValidationError e : le) {
                    builder.append(e.message());
                    builder.append(", ");
                }
            }
        }

        return builder.toString();


    }**/
    
    public static String get(String key, String defaultValue, Object... params) {
       
       if(key == null) return null;
       String value = Messages.get(key, params);
       
       if(key.equals(value)) {
           return defaultValue;
       } else {
           return value;
       }
    }
}
