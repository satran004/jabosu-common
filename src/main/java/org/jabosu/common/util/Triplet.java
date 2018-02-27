package org.jabosu.common.util;

/**
 * Created by satya on 26/3/15.
 */
public class Triplet<T, U, K> {

    public final T _1;
    public final U _2;
    public final K _3;

    public Triplet(T arg1, U arg2, K arg3) {
        super();
        this._1 = arg1;
        this._2 = arg2;
        this._3 = arg3;
    }

    @Override
    public String toString() {
        return String.format("(%s, %s, %s)", _1, _2, _3);
    }
}