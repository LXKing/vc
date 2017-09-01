package com.ccclubs.protocol.util;

/**
 * Created by qsxiaogang on 2017/2/22.
 */
public class GbTools {
  /**
   * 检测数据是否有效
   * @param value
   * @return
   */
  public static boolean isEffective(int value){
    boolean result = true;
    if (value < 0){
      value = (value&0xFFFFFFFF);
    }
    if (value==0xFE||value==0xFF)
    {
      result = false;
    }

    return  result;
  }

  /**
   * 通过应答标志位，是否需要应答
   * @param value
   * @return
   */
  public static boolean isNeedToAck(int value){
    boolean result = false;
    if (value < 0){
      value = (value&0xFF);
    }
    if (value==0xFE)
    {
      result = true;
    }
    return  result;
  }

}
