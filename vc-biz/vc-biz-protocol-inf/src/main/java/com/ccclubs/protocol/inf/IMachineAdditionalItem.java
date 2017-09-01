package com.ccclubs.protocol.inf;


public interface IMachineAdditionalItem {

  byte getAdditionalId();

  byte getAdditionalLength();

  byte[] WriteToBytes();

  void ReadFromBytes(byte[] bytes);
}