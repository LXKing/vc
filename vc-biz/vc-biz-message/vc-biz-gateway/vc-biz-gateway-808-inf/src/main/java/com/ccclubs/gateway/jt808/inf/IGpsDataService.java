package com.ccclubs.gateway.jt808.inf;

import com.ccclubs.protocol.dto.jt808.T808Message;

public interface IGpsDataService {

  void processMessage(T808Message message);

  // 重置GPS上线状态
  // void resetGpsOnlineState();
}