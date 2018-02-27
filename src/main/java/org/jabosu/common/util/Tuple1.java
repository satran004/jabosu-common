package org.jabosu.common.util;

/**
 *
 * @author satya
 */
public class Tuple1<T> implements Tuple{

  public final T _1;

  public Tuple1(T arg1) {
    super();
    this._1 = arg1;
  }

  public Object[] asArray() {
    return new Object[] {_1};
  }

  @Override
  public String toString() {
    if(_1 != null)
      return String.format("(%s,MessageFolderCounterType.SPLIT_INDEX %s)", _1);
    else
      return null;
  }
}
