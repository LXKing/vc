package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMessageBody;
import com.ccclubs.protocol.util.ClassUtils;
import com.ccclubs.protocol.util.Tools;

public final class MqMessageFactory {

  public static IMessageBody Create(int fucCode, int outputAddress, byte[] messageBodyBytes) {

    String nameSpace = MqMessageFactory.class.getPackage().getName();
    if (fucCode < 0) {
      fucCode = (outputAddress & 0xFF);
    }
    if (outputAddress < 0) {
      outputAddress = (outputAddress & 0xFFFF);
    }
    String className =
        nameSpace + ".entity" + ".CCCLUBS_" + Tools.ToHexString(fucCode, 1) + "_" + Tools
            .ToHexString(outputAddress, 2);

    Object messageBody = ClassUtils.getBean(className);
    if (messageBody != null) {
      IMessageBody msg = (IMessageBody) messageBody;
      msg.ReadFromBytes(messageBodyBytes);
      return msg;
    }
    return null;
  }

}