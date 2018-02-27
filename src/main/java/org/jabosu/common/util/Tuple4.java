package org.jabosu.common.util;

/**
 *
 * @author satya
 */
public class Tuple4<A, B, C, D> implements Tuple {

  public final A _1;
  public final B _2;
  public final C _3;
  public final D _4;

  public Tuple4(A arg1, B arg2, C arg3, D arg4) {
    super();
    this._1 = arg1;
    this._2 = arg2;
    this._3 = arg3;
    this._4 = arg4;
  }

  public Object[] asArray() {
    return new Object[] {_1, _2, _3, _4};
  }

  @Override
  public String toString() {
    return String.format("(%s ,%s, %s, %s)", _1, _2, _3, _4);
  }
}
