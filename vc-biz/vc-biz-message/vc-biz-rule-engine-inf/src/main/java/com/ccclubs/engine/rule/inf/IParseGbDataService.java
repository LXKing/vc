package com.ccclubs.engine.rule.inf;


import com.ccclubs.protocol.dto.gb.GBMessage;

public interface IParseGbDataService {

  void processMessage(GBMessage message, byte[] srcByteArray);

}