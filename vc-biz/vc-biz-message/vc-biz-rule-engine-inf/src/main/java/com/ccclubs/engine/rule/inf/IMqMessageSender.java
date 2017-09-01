package com.ccclubs.engine.rule.inf;


import com.ccclubs.protocol.dto.mqtt.MqMessage;

public interface IMqMessageSender {

	void sendMqMessage(MqMessage tm);

}
