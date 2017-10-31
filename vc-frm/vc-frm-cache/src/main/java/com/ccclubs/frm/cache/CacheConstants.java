package com.ccclubs.frm.cache;

/**
 * @author qsxiaogang
 * @create 2017-10-10
 **/
public class CacheConstants {

  private static final int MIN = 60;
  private static final int HOUR = 60 * MIN;
  private static final int DAY = 24 * HOUR;

  public static final int NORMAL_EXPIRE = 20 * MIN;
  //  public static final int NORMAL_EXPIRE = 3 * MIN;
  public static final int FAST_EXPIRE = 20 * MIN;
  public static final int NEVER_EXPIRE = 10 * DAY;
}
