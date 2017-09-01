package com.ccclubs.protocol.dto.gb;


import com.ccclubs.protocol.inf.IGbMessage;
import com.ccclubs.protocol.inf.IRealTimeAdditionalItem;
import com.ccclubs.protocol.util.ClassUtils;
import com.ccclubs.protocol.util.Tools;

public final class GBMessageFactory {

  public static IGbMessage Create(int messageType, byte[] messageBodyBytes) {
    // 补发信息结构与实时信息一致
    if (messageType == 0x03) {
      messageType = 0x02;
    }
    String nameSpace = GBMessageFactory.class.getPackage().getName();
    String className = nameSpace + ".GB_" + Tools.ToHexString(messageType, 1);

    Object messageBody = ClassUtils.getBean(className);
    if (messageBody != null) {
      IGbMessage msg = (IGbMessage) messageBody;
      msg.ReadFromBytes(messageBodyBytes);
      return msg;
    }
    return null;
  }

  public static IRealTimeAdditionalItem Create(int messageType, int subCode,
      byte[] messageBodyBytes) {

    String nameSpace = GBMessageFactory.class.getPackage().getName();
    String className = nameSpace + ".GB_" + Tools.ToHexString(messageType, 1) + "_" + Tools
        .ToHexString(subCode, 1);

    Object messageBody = ClassUtils.getBean(className);
    if (messageBody != null) {
      IRealTimeAdditionalItem msg = (IRealTimeAdditionalItem) messageBody;
      msg.ReadFromBytes(messageBodyBytes);
      return msg;
    }
    return null;
  }

}