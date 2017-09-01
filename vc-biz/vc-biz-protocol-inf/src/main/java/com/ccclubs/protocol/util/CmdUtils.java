package com.ccclubs.protocol.util;


import com.ccclubs.protocol.dto.mqtt.RemoteSimple;

/**
 * Created by qsxiaogang on 2017/7/4.
 */
public class CmdUtils {

  /**
   * 返回需要发送的指令十六进制字符串，简单指令
   *
   * @param transId 远程指令流水号
   * @param carNumber 车机号
   * @param array 指令附加内容
   */
  public static String getSimpleMQTTRemoteCommend(Long transId, String carNumber, Object[] array) {
    RemoteSimple remoteSimple = new RemoteSimple();
    remoteSimple.id = transId;
    remoteSimple.number = carNumber;
    remoteSimple.params = array;

    try {
      return Tools.ToHexString(remoteSimple.getBytes());
    } catch (Exception e) {
      e.printStackTrace();
      return "";
    }
  }
}
