package org.jabosu.common.exception;

/**
 *
 * @author satya
 */
public class MaximumProfileCreationReachedException extends BusinessException {

    public MaximumProfileCreationReachedException(Exception e) {
        super(e);
    }
    
    public MaximumProfileCreationReachedException(String msg) {
        super(msg);
    }
    
}
