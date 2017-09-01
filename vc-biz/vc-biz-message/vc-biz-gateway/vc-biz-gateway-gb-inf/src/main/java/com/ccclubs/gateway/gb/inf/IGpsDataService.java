package com.ccclubs.gateway.gb.inf;


import com.ccclubs.protocol.dto.gb.GBMessage;

public interface IGpsDataService {

  void processMessage(GBMessage message);

}