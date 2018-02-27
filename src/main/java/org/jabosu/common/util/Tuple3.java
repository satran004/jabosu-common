package org.jabosu.common.util;

/**
 *
 * @author satya
 */
public class Tuple3<A, B, C> implements Tuple{

  public final A _1;
  public final B _2;
  public final C _3;

  public Tuple3(A arg1, B arg2, C arg3) {
    super();
    this._1 = arg1;
    this._2 = arg2;
    this._3 = arg3;
  }

  public Object[] asArray() {
    return new Object[] {_1, _2, _3};
  }
  @Override
  public String toString() {
    return String.format("(%s, %s, %s)", _1, _2, _3);
  }
}
