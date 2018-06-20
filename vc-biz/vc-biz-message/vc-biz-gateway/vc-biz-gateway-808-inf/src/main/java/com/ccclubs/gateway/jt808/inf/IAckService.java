package com.ccclubs.gateway.jt808.inf;


import com.ccclubs.protocol.dto.jt808.T808Message;

public interface IAckService {

  void beginAck(T808Message tm);

  void setMessageSender(IMessageSender handler);

  void start();
}
