package com.ccclubs.frm.mqtt.util;

/**
 * Created by qsxiaogang on 2017/7/21.
 */
public class MqttHelper {

  /**
   * 将字节数组转换为十六进制字符串
   */
  public static String toHexString(byte[] bts) {
    StringBuilder strBuild = new StringBuilder();

    for (int i = 0; i < bts.length; i++) {
      strBuild.append(toHexString(bts[i]));
    }
    return strBuild.toString();
  }


  /**
   * 将数字转换成16进制字符串，不足补零
   *
   * @param data 需要转换的字节
   */
  public static String toHexString(byte data) {
    return Integer.toHexString(data & 0xff | 0x100).substring(1).toUpperCase();
  }

  /**
   * 获取随机数
   */
  public static int rand(Integer iMax) {
    return Math.abs(new java.util.Random().nextInt() % iMax);
  }

}
