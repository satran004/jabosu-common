package org.jabosu.common.exception.util;

import org.jabosu.common.exception.ErrorCodeException;
import org.jabosu.common.util.Messages;

/**
 *
 * @author satya
 */
public class ExceptionUtil {
    
    public static String getErrorMessage(ErrorCodeException e) {
        if(e == null) return null;
        
        if(e.getErrorCode() == null) return e.getMessage();
        
        return Messages.get(e.getErrorCode());
    }
    
}
