package com.ccclubs.engine.rule.inf;


import com.ccclubs.protocol.dto.gb.GBMessage;

public interface IParseGbDataService {

  void processRtMessage(GBMessage message);
  void processAllMessage(GBMessage message);

}