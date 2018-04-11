package com.ccclubs.engine.cmd.inf;


import com.ccclubs.protocol.dto.mqtt.MqMessage;

public interface IMqMessageSender {

	void sendMqMessage(MqMessage tm);

}
