package com.ccclubs.gateway.mqtt;

import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.Producer;
import com.ccclubs.frm.mqtt.inf.IMessageProcessService;
import com.ccclubs.frm.ons.OnsMessageFactory;
import com.ccclubs.frm.spring.util.EnvironmentUtils;
import com.ccclubs.protocol.dto.mqtt.MqMessage;
import com.ccclubs.protocol.dto.online.OnlineConnection;
import com.ccclubs.protocol.util.ConstantUtils;
import com.ccclubs.protocol.util.MqTagUtils;
import com.ccclubs.protocol.util.StringUtils;
import com.ccclubs.protocol.util.Tools;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 处理远程控制指令，接收mqtt消息，通过0x8900转发成808命令
 */
public class MqttMessageProcessService implements IMessageProcessService {

  private static Logger logger = LoggerFactory.getLogger(MqttMessageProcessService.class);

  @Resource(name = "onsPublishClient")
  private Producer client;

  @Value("${" + ConstantUtils.MQ_TOPIC + "}")
  String topic;

  @Resource
  RedisTemplate redisTemplate;
  @Resource
  EnvironmentUtils environmentUtils;

  @Override
  public void processMsg(String upTopic, MqttMessage msg, String hexString) {
    if (msg.getPayload().length >= MqMessage.MESSAGE_MIN_LENGTH) {
      MqMessage mqMessage = new MqMessage();
      mqMessage.ReadFromBytes(msg.getPayload());

      if (mqMessage != null && !StringUtils.empty(mqMessage.getCarNumber())) {

        // 记录终端在线情况，MQTT协议使用车机号
        redisTemplate.opsForValue().set(ConstantUtils.ONLINE_REDIS_PRE + mqMessage.getCarNumber(),
            new OnlineConnection(mqMessage.getCarNumber(), "", environmentUtils.getCurrentIp(),
                System.currentTimeMillis()),
            ConstantUtils.ONLINE_IDE_TIME, TimeUnit.MILLISECONDS);

        // 转发数据，数据流转topic：ser , TAG：MQTT_06
        Message message = OnsMessageFactory
            .getProtocolMessage(topic,
                MqTagUtils.getTag(MqTagUtils.PROTOCOL_MQTT, mqMessage.getFucCode()),
                Tools.HexString2Bytes(hexString));

        client.sendOneway(message);

      } else {
        logger.error(ConstantUtils.MQ_TOPIC + " 或  " + ConstantUtils.MQ_TOPIC + " 未配置");
      }
    }
  }
}
