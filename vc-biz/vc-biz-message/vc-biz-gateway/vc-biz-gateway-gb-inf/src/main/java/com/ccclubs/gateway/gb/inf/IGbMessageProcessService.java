package com.ccclubs.gateway.gb.inf;


import com.ccclubs.protocol.dto.gb.GBMessage;

public interface IGbMessageProcessService {

  /**
   * 对终端发送上来的消息进行通用应答
   *
   * @param msgFromTerminal 终端消息
   */
  void processMsg(GBMessage msgFromTerminal);

}