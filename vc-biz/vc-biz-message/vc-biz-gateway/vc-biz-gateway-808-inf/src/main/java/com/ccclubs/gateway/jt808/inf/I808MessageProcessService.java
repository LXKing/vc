package com.ccclubs.gateway.jt808.inf;


import com.ccclubs.protocol.dto.jt808.T808Message;

public interface I808MessageProcessService {

  /**
   * 对终端发送上来的消息进行通用应答
   *
   * @param msgFromTerminal 终端消息
   */
  void processMsg(T808Message msgFromTerminal);

}