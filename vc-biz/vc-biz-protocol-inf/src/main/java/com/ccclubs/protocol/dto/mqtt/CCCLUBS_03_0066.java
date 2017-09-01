package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMessageBody;
import com.ccclubs.protocol.util.MyBuffer;
import com.ccclubs.protocol.util.Tools;

public class CCCLUBS_03_0066 implements IMessageBody {

  /**
   * MAC地址，十六进制字符串
   */
  private String macValue;

  public String getMacValue() {
    return macValue;
  }

  public void setMacValue(String macValue) {
    this.macValue = macValue;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();

    buff.put(Tools.HexString2Bytes(getMacValue()));

    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] messageBodyBytes) {
    MyBuffer buff = new MyBuffer(messageBodyBytes);
    byte[] macBytes = buff.gets(6);
    setMacValue(Tools.ToHexString(macBytes));
  }

}
