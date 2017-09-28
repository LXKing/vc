package com.ccclubs.engine.cmd.inf;


import com.ccclubs.protocol.dto.mqtt.MqMessage;

public interface IMqAckService {

  void beginAck(MqMessage msg);

  void setMessageSender(IMqMessageSender handler);

  void ackKeyStatus(MqMessage msg);

}
