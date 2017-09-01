package com.ccclubs.frm.ons;

import com.aliyun.openservices.ons.api.Message;

/**
 * Created by qsxiaogang on 2017/7/24.
 */
public class OnsMessageFactory {

  /**
   * 将其它协议(除mqtt，MQ以外，诸如jt808协议)字节流，发送到MQ消息中间件
   *
   * @param topic 主题，默认为ser
   * @param protocol 协议编码，如jt808
   */
  public static Message getProtocolMessage(String topic, String protocol,
      final byte[] srcByteArray) {
    if (topic == null || topic.trim().length() == 0) {
      return null;
    }
    return new Message(topic, protocol, srcByteArray);
  }
}
