package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMessageBody;
import com.ccclubs.protocol.util.MyBuffer;

public class CCCLUBS_03_0481 implements IMessageBody {

  /**
   * 蓝牙密钥
   */
  private String bleKey;

  public String getBleKey() {
    return bleKey;
  }

  public void setBleKey(String bleKey) {
    this.bleKey = bleKey;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();

    buff.put(getBleKey().getBytes());

    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] messageBodyBytes) {
    MyBuffer buff = new MyBuffer(messageBodyBytes);
    byte[] bleBytes = buff.gets(16);
    setBleKey((new String(bleBytes)).trim());
  }

}
