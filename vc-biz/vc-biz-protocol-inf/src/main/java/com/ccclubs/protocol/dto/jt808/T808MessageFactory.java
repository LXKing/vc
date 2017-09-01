package com.ccclubs.protocol.dto.jt808;


import com.ccclubs.protocol.inf.IMessageBody;
import com.ccclubs.protocol.util.ClassUtils;
import com.ccclubs.protocol.util.Tools;

public final class T808MessageFactory {
	private static final boolean RECORDER_VER_2012 = true;

	public static IMessageBody Create(int messageType, byte[] messageBodyBytes) {

		String nameSpace = T808MessageFactory.class.getPackage().getName();
		if (messageType < 0) {
			messageType = (messageType & 0xFFFF);
		}
		String className = nameSpace + ".JT_" + Tools.ToHexString(messageType, 2);
		if (messageType == 0x0700 && RECORDER_VER_2012) {
			className = nameSpace + "jt2012.JT2012_" + Tools.ToHexString(messageType, 2);
		}

		Object messageBody = ClassUtils.getBean(className);
		if (messageBody != null) {
			IMessageBody msg = (IMessageBody) messageBody;
			msg.ReadFromBytes(messageBodyBytes);
			return msg;
		}
		return null;
	}

}