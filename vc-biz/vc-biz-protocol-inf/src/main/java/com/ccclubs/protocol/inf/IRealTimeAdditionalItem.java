package com.ccclubs.protocol.inf;

import com.ccclubs.protocol.inf.IMessageBody;

public interface IRealTimeAdditionalItem extends IMessageBody {

  int getAdditionalId();

  /**
   * 返回-1表示变长
   */
  int getAdditionalLength();
}
