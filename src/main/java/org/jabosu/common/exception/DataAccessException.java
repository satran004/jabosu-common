package org.jabosu.common.exception;

public class DataAccessException extends Exception {
	
	public DataAccessException(Exception e) {
		super(e);
	}
	
	public DataAccessException(String msg) {
		super(msg);
	}

}
