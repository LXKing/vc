package com.ccclubs.engine.rule.inf;


import com.ccclubs.protocol.dto.mqtt.MqMessage;

public interface IMqAckService {

  void beginAck(MqMessage msg);

  void setMessageSender(IMqMessageSender handler);

  void synchronizeCarTime(MqMessage msg, long terminalTime);

  void ackTakeCar(MqMessage msg);

  void ackFurtherCar(MqMessage msg);

}
