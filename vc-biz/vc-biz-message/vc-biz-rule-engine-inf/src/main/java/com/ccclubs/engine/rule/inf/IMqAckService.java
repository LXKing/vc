package com.ccclubs.engine.rule.inf;


import com.ccclubs.protocol.dto.mqtt.MQTT_66;
import com.ccclubs.protocol.dto.mqtt.MqMessage;

public interface IMqAckService {

  void beginAck(MqMessage msg);

  void setMessageSender(IMqMessageSender handler);

  void synchronizeCarTime(MqMessage msg, MQTT_66 mqtt_66);

  void ackTakeCar(MqMessage msg);

  void ackFurtherCar(MqMessage msg);

}
