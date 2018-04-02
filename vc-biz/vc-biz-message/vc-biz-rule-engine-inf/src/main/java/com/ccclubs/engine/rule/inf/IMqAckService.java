package com.ccclubs.engine.rule.inf;


import com.ccclubs.protocol.dto.mqtt.MqMessage;

/**
 * TBOX应答接口定义
 */
public interface IMqAckService {

  /**
   * 应答TBOX上行信息
   * @param msg
   */
  void beginAck(MqMessage msg);

  /**
   * 设置消息下发 handler
   * @param handler
   */
  void setMessageSender(IMqMessageSender handler);

  /**
   * 依据TBOX当前时间，对TOBX时间进行同步设置
   * @param msg
   * @param terminalTime
   */
  void synchronizeCarTime(MqMessage msg, long terminalTime);

  /**
   * 对应TBOX上报的取车数据
   * @param msg
   */
  void ackTakeCar(MqMessage msg);

  /**
   * 对应TBOX上报的还车数据
   * @param msg
   */
  void ackFurtherCar(MqMessage msg);

}
