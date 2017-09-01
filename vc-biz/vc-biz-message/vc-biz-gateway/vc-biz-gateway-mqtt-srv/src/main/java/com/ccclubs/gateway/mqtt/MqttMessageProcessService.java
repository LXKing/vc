package com.ccclubs.gateway.mqtt;

import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.Producer;
import com.ccclubs.frm.mqtt.inf.IMessageProcessService;
import com.ccclubs.protocol.dto.mqtt.MqMessage;
import com.ccclubs.protocol.util.ConstantUtils;
import com.ccclubs.protocol.util.MqTagUtils;
import com.ccclubs.protocol.util.Tools;
import com.ccclubs.frm.ons.OnsMessageFactory;
import javax.annotation.Resource;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

/**
 * 处理远程控制指令，接收mqtt消息，通过0x8900转发成808命令
 */
public class MqttMessageProcessService implements IMessageProcessService {

  private static Logger logger = LoggerFactory.getLogger(MqttMessageProcessService.class);

  @Resource(name = "onsPublishClient")
  private Producer client;

  @Value("${" + ConstantUtils.MQ_TOPIC + "}")
  String topic;

  @Override
  public void processMsg(String upTopic, MqttMessage msg, String hexString) {
    if (msg.getPayload().length >= MqMessage.MESSAGE_MIN_LENGTH) {
      MqMessage mqMessage = new MqMessage();
      mqMessage.ReadFromBytes(msg.getPayload());
      // 转发数据，数据流转topic：ser , TAG：MQTT_06
      Message message = OnsMessageFactory
          .getProtocolMessage(topic,
              MqTagUtils.getTag(MqTagUtils.PROTOCOL_MQTT, mqMessage.getFucCode()),
              Tools.HexString2Bytes(hexString));
      if (mqMessage != null) {
        client.sendOneway(message);
      } else {
        logger.error(ConstantUtils.MQ_TOPIC + " 或  " + ConstantUtils.MQ_TOPIC + " 未配置");
      }
    }
  }
}
