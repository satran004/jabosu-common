package org.jabosu.common.exception;

public class BusinessException extends Exception implements ErrorCodeException {
        private String errorCode;
        
	public BusinessException(Exception e) {
		super(e);
	}
	
	public BusinessException(String msg) {
		super(msg);
	}
	
	public BusinessException(String msg, Throwable t) {
		super(msg, t);
	}
        
        public BusinessException(String msg, String errorCode, Throwable t) {
            super(msg, t);
            this.errorCode = errorCode;
        }
        
        public BusinessException(String msg, String errorCode) {
            super(msg);
            this.errorCode = errorCode;
        }
        
        public String getErrorCode() {
            return errorCode;
        }
}
