package com.ccclubs.protocol.inf;


import com.ccclubs.protocol.dto.mqtt.MqMessage;

public interface IParseDataService {
	void processMessage(MqMessage message);

	// 处理订单数据
	void processOrderStatus(MqMessage message);

	// 处理订单详情数据
	void processOrderDetailStatus(MqMessage message);

	// 处理订单续订数据
	void processOrderModify(MqMessage msg);

	// 写入状态数据
	void processCarStatus(MqMessage message);

	// 写入报警数据
	void processAlarmStatus(MqMessage message);

	// 写入CAN数据
	void processCanStatus(MqMessage message);

	// 写入启动、停止数据
	void processStartStopStatus(MqMessage message);

	// 写入远程操作结果
	void processRemoteStatus(MqMessage message);

	// 写入取车数据
	void processTakeCarStatus(MqMessage message);

	// 写入还车数据
	void processFurtherCarStatus(MqMessage message);

	// 写入车机网络日志
	void processTerminalLog(MqMessage message);
}