package org.jabosu.common;

/**
 * Created by satya on 2/8/15.
 */
public interface CounterType {

    default String getType() {
        return toString();
    }


}
