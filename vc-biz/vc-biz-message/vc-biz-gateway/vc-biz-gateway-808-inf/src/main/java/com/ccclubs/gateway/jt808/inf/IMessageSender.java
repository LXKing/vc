package com.ccclubs.gateway.jt808.inf;

import com.ccclubs.protocol.dto.jt808.T808Message;

public interface IMessageSender {

  void send808Message(T808Message tm);

}
