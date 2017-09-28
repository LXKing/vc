package com.ccclubs.engine.cmd.inf.impl;

import com.ccclubs.engine.cmd.inf.IMqAckService;
import com.ccclubs.engine.cmd.inf.IMqMessageSender;
import com.ccclubs.protocol.dto.mqtt.MQTT_07;
import com.ccclubs.protocol.dto.mqtt.MQTT_07_Ack;
import com.ccclubs.protocol.dto.mqtt.MqMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MqAckService implements IMqAckService {

  private static Logger logger = LoggerFactory.getLogger(MqAckService.class);

  private IMqMessageSender messageSender;

  @Override
  public void beginAck(MqMessage msg) {
    if (getMessageSender() == null) {
      return;
    }

    byte headerType = msg.getFucCode();
    switch (headerType) {
      case 0x07:
        ackKeyStatus(msg);
        break;
      default:
        break;
    }
  }


  @Override
  public void ackKeyStatus(MqMessage msg) {
    try {
      MQTT_07 mqtt_07 = new MQTT_07();
      mqtt_07.ReadFromBytes(msg.getMsgBody());

      MQTT_07_Ack mqtt_07_ack = new MQTT_07_Ack();
      mqtt_07_ack.setSubFucCode(mqtt_07.getSubFucCode());
      mqtt_07_ack.setMessageSerialNo(mqtt_07.getMessageSerialNo());

      msg.setMsgBody(mqtt_07_ack.WriteToBytes());

      getMessageSender().sendMqMessage(msg);
    } catch (Exception e) {
      e.printStackTrace();
      logger.error(e.getMessage(), e);
    }
  }

  @Override
  public void setMessageSender(IMqMessageSender handler) {
    this.messageSender = handler;
  }

  public IMqMessageSender getMessageSender() {
    return messageSender;
  }

}
