package org.jabosu.common.exception;

/**
 *
 * @author satya
 */
public class ServiceNotAllowedException extends BusinessException {
    
    public ServiceNotAllowedException(Exception e) {
        super(e);
    }
    
    public ServiceNotAllowedException(String msg) {
        super(msg);
    }
    
}
