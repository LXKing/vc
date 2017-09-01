package com.ccclubs.gateway.gb.inf;

import com.ccclubs.protocol.dto.gb.GBMessage;

public interface IMessageSender {

  void sendGbMessage(GBMessage gm);

}
