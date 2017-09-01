package com.ccclubs.olap.protocol.protocolmodel.gb;

/**
 * 自定义数据
 */
public class GB_02_08 implements IRealTimeAdditionalItem {

    @Override
    public byte[] WriteToBytes() {
        return new byte[0];
    }

    @Override
    public void ReadFromBytes(byte[] messageBodyBytes) {

    }

    @Override
    public int getMessageId() {
        return 0;
    }

    @Override
    public int getMessageLength() {
        return 0;
    }


    @Override
    public String toString() {
        return null;
    }
}
