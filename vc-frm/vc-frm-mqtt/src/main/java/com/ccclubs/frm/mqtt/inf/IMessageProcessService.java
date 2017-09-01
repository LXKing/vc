package com.ccclubs.frm.mqtt.inf;

import org.eclipse.paho.client.mqttv3.MqttMessage;


public interface IMessageProcessService {

  /**
   * 对终端发送上来的非自定义mqtt消息进行处理 </br>TODO：添加其它协议如何区分
   * <ul>
   * <li>
   * 808协议：0x7E打头，0x7E结尾</li>
   * <li>
   * 国标协议：两个连续的0x23打头</li>
   * </ul>
   *
   * @param upTopic 上行topic
   * @param msg 原始 MqttMessage 消息
   * @param hexString msg.getPayload() 原始字节十六进制<br>大写</br>字符串()
   */
  void processMsg(final String upTopic, final MqttMessage msg, final String hexString);

}