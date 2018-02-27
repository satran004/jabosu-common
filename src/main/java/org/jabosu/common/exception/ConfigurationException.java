package org.jabosu.common.exception;

/**
 *
 * @author satya
 */
public class ConfigurationException extends RuntimeException {

    public ConfigurationException(Exception e) {
        super(e);
    }

    public ConfigurationException(String msg) {
        super(msg);
    }

    public ConfigurationException(String msg, Throwable t) {
        super(msg, t);
    }
}
