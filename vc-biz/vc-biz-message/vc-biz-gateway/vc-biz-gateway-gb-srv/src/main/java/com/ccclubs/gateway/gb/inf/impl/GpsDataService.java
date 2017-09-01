package com.ccclubs.gateway.gb.inf.impl;

import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.Producer;
import com.ccclubs.gateway.gb.inf.IGpsDataService;
import com.ccclubs.protocol.dto.gb.GBMessage;
import com.ccclubs.protocol.util.ConstantUtils;
import com.ccclubs.protocol.util.MqTagUtils;
import com.ccclubs.protocol.util.Tools;
import com.ccclubs.frm.ons.OnsMessageFactory;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

/**
 * 终端上行数据处理实现类
 */
public class GpsDataService implements IGpsDataService {

  private static final Logger logger = LoggerFactory.getLogger(GpsDataService.class);

  @Value("${" + ConstantUtils.MQ_TOPIC + "}")
  String topic;
  @Resource(name = "onsPublishClient")
  private Producer client;

  // 获取实时数据
  // 保存终端参数
  // 处理GPS数据
  public final void processMessage(GBMessage message) {
    // 消息类型
    transferToMQ(message);
  }

  /**
   * 将GB协议数据转发到消息中间件MQ，topic：ser，tag：GB
   */
  private void transferToMQ(GBMessage message) {
    // 转发数据，数据流转topic：ser
    Message mqMessage = OnsMessageFactory.getProtocolMessage(topic, MqTagUtils.PROTOCOL_GB,
        Tools.HexString2Bytes(message.getPacketDescr()));
    if (mqMessage != null) {
      client.send(mqMessage);
    } else {
      logger.error(ConstantUtils.MQ_TOPIC + " 或  " + ConstantUtils.MQ_TOPIC + " 未配置");
    }
  }

  /**
   * 收到GB消息后，根据消息的不同，进行不同的处理
   */
  private void processData(GBMessage message) {
//    int headerType = message.getHeader().getMessageType();
  }

}