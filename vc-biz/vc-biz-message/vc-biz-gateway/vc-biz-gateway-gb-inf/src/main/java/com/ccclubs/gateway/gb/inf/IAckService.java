package com.ccclubs.gateway.gb.inf;

import com.ccclubs.protocol.dto.gb.GBMessage;

public interface IAckService {

  void beginAck(GBMessage tm);

  void setMessageSender(IMessageSender handler);

}
