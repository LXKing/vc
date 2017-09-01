package com.ccclubs.protocol.protocolmodel.evnet;

import com.ccclubs.protocol.util.ClassUtils;
import com.ccclubs.protocol.util.Tools;

/**
 * Created by Administrator on 2017/7/10 0010.
 */
public class EVMessageFactory {

    public static IEvMessage Create(int messageType, byte[] messageBodyBytes) {

        String nameSpace = EVMessageFactory.class.getPackage().getName();
        String className = nameSpace + ".EV_" + Tools.ToHexString(messageType, 1);
        //通过反射得到类实列
        Object messageBody = ClassUtils.getBean(className);
        if (messageBody != null) {
            IEvMessage msg = (IEvMessage) messageBody;
            msg.ReadFromBytes(messageBodyBytes);
            return msg;
        }
        return null;
    }

}
