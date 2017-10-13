package com.ccclubs.engine.rule.inf.impl;

import com.ccclubs.frm.mqtt.inf.IMessageProcessService;
import com.ccclubs.protocol.dto.mqtt.MqMessage;
import com.ccclubs.protocol.inf.IMqMessageProcessService;
import com.ccclubs.protocol.util.MqTagUtils;
import javax.annotation.Resource;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 处理远程控制指令，接收mqtt消息，通过0x8900转发成808命令 FIXME：808网关只发送中导升级指令，拼装好的808消息格式（7E打头的数据）
 */
public class MqttMessageProcessService implements IMessageProcessService {

  private static Logger logger = LoggerFactory.getLogger(MqttMessageProcessService.class);

  @Resource(name = "mqMessageProcessService")
  private IMqMessageProcessService terminalProcessService;

  @Override
  public void processMsg(String upTopic, MqttMessage msg, String hexString) {
    if (msg.getPayload().length >= MqMessage.MESSAGE_MIN_LENGTH) {
      MqMessage mqMessage = new MqMessage();
      mqMessage.ReadFromBytes(msg.getPayload());
      terminalProcessService
          .processAliMqMsg(MqTagUtils.getTag(MqTagUtils.PROTOCOL_MQTT, mqMessage.getFucCode()),
              upTopic, msg.getPayload(), mqMessage.getHexString());
    }
  }

  public IMqMessageProcessService getTerminalProcessService() {
    return terminalProcessService;
  }

  public void setTerminalProcessService(
      IMqMessageProcessService terminalProcessService) {
    this.terminalProcessService = terminalProcessService;
  }
}
