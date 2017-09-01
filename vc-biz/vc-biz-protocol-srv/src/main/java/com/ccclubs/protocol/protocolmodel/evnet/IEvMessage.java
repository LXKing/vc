package com.ccclubs.protocol.protocolmodel.evnet;

import com.ccclubs.protocol.inf.IMessageBody;
import java.util.List;

/**
 * Created by Administrator on 2017/7/10 0010.
 */
public interface IEvMessage extends IMessageBody {

  List getCanList();

  // 获取包的数量
  byte getCanCount();
}
