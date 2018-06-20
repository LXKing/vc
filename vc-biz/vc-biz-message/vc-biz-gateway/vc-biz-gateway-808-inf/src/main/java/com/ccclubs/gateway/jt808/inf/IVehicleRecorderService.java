package com.ccclubs.gateway.jt808.inf;

import com.ccclubs.protocol.dto.jt808.T808Message;

/**
 * 行车记录仪服务
 */
public interface IVehicleRecorderService {

  /**
   * 停止服务
   */
  void stop();

  /**
   * 处理多媒体数据包
   */
  void processMediaMsg(T808Message msg);

  void setMessageSender(IMessageSender messageSender);

}
