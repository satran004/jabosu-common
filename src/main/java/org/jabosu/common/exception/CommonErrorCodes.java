package org.jabosu.common.exception;

import org.jabosu.common.exception.ErrorCode;

/**
 *
 * @author satya
 */
public enum CommonErrorCodes implements ErrorCode {
    
    TEMP_ERROR("ERROR_TEMPORARY");
    
    private String code;
    
    private CommonErrorCodes(String errorCode) {
        this.code = errorCode;
    }
    
    public String getErrorCode() {
        return code;
    }
}
