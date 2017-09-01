package com.ccclubs.protocol.dto.jt808;

import com.ccclubs.protocol.inf.IMessageBody;

/**
 * Created by Administrator on 2017/7/31 0031.
 */
public class JT_8900 implements IMessageBody {
    @Override
    public byte[] WriteToBytes() {
        return new byte[0];
    }

    @Override
    public void ReadFromBytes(byte[] messageBodyBytes) {

    }
}
