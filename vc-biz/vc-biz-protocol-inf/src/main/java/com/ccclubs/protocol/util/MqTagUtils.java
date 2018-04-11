package com.ccclubs.protocol.util;

/**
 * MQ消息  获取消息类型 TAG 类型
 *
 * @author qsxiaogang
 */
public class MqTagUtils {

  // 网关接收到消息后，转发到数据解析层响应的TAG前缀
  /**
   * 分时租赁协议TAG前缀
   */
  public static String PROTOCOL_MQTT = "MQTT";
  /**
   * JT808协议TAG前缀
   */
  public static String PROTOCOL_JT808 = "JT";
  /**
   * 新能源国标GB32960协议TAG前缀
   */
  public static String PROTOCOL_GB = "GB";

  /**
   * 默认给808协议获取TAG
   *
   * @param tagPre 默认值为 PROTOCOL_JT808
   * @param messageType 消息ID
   * @return JT_0200
   */
  public static String getTag(String tagPre, int messageType) {
    return String.format("%s_%s", tagPre, Tools.ToHexString((messageType & 0xFFFF), 2));
  }

  /**
   * 默认给808协议获取TAG
   *
   * @param tagPre 默认值为 PROTOCOL_JT808
   * @param messageType 消息ID
   * @param fcCode 01,F1,FD
   * @return JT_0900_01
   */
  public static String getTag(String tagPre, int messageType, byte fcCode) {
    return String.format("%s_%s_%s", tagPre, Tools.ToHexString((messageType & 0xFFFF), 2),
        Tools.ToHexString((fcCode & 0xFF), 1));
  }

  /**
   * @param tagPre 默认值为 PROTOCOL_MQTT
   * @param messageType fcCode
   * @return MQTT_10
   */
  public static String getTag(String tagPre, byte messageType) {
    return String.format("%s_%s", tagPre, Tools.ToHexString((messageType & 0xFF), 1));
  }
}
