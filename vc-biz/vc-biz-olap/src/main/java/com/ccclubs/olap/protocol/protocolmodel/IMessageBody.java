package com.ccclubs.olap.protocol.protocolmodel;

/**
 *
 */
public interface IMessageBody {

    byte[] WriteToBytes();
    void ReadFromBytes(byte[] messageBodyBytes);
}
