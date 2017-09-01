package com.ccclubs.protocol.inf;


public interface IPositionAdditionalItem
{
	byte getAdditionalId();
	byte getAdditionalLength();
	byte[] WriteToBytes();
	void ReadFromBytes(byte[] bytes);
}