package com.ccclubs.protocol.inf;

public interface IMessageBody
{
	byte[] WriteToBytes();
	void ReadFromBytes(byte[] messageBodyBytes);
}