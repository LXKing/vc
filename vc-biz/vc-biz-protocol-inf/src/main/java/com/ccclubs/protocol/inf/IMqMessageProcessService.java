package com.ccclubs.protocol.inf;

/**
 * 用于规则引擎处理来自 MQ 消息中间件的消息，主要来源：
 * <ul>
 * <li>
 * 车机终端直连 MQ 发送状态数据，订单数据，CAN数据等
 * </li>
 * <li>
 * 其它 Server 端（如：808网关，国标网关）发上来的消息等
 * </li>
 * </ul>
 */
public interface IMqMessageProcessService {

  /**
   * 对终端发送上来的非自定义mqtt消息进行处理 </br>TODO：添加其它协议如何区分
   * <ul>
   * <li>
   * 808协议：0x7E打头，0x7E结尾</li>
   * <li>
   * 国标协议：两个连续的0x23打头</li>
   * </ul>
   *
   * @param tag 区分是哪种协议
   * @param upTopic mqtt主题
   * @param srcByteArray 原始字节数组
   * @param hexString 原始字节十六进制字符串
   */
  void processAliMqMsg(String tag, String upTopic, byte[] srcByteArray, String hexString);

}