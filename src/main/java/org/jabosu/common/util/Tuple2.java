package org.jabosu.common.util;

/**
 *
 * @author satya
 */
public class Tuple2<T, U> implements Tuple{

  public final T _1;
  public final U _2;

  public Tuple2(T arg1, U arg2) {
    super();
    this._1 = arg1;
    this._2 = arg2;
  }

  public Object[] asArray() {
    return new Object[] {_1, _2};
  }

  @Override
  public String toString() {
    return String.format("(%s,MessageFolderCounterType.SPLIT_INDEX %s)", _1, _2);
  }
}
