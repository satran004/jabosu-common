package org.jabosu.common.exception;

/**
 *
 * @author satya
 */
public class BusinessRuntimeException extends RuntimeException implements ErrorCodeException {

    private String errorCode;

    public BusinessRuntimeException(Exception e) {
        super(e);
    }

    public BusinessRuntimeException(String msg, Exception e) {
        super(msg, e);
    }

    public BusinessRuntimeException(String msg) {
        super(msg);
    }

    public BusinessRuntimeException(String msg, String errorCode, Throwable t) {
        super(msg, t);
        this.errorCode = errorCode;
    }

    public BusinessRuntimeException(String msg, String errorCode) {
        super(msg);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
