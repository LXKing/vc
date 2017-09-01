package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMessageBody;
import com.ccclubs.protocol.util.MyBuffer;

public class CCCLUBS_03_0492 implements IMessageBody {

  /**
   * 插枪还车状态
   */
  private Short gun;

  public short getGun() {
    return gun;
  }

  public void setGun(short gun) {
    this.gun = gun;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getGun());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] messageBodyBytes) {
    MyBuffer buff = new MyBuffer(messageBodyBytes);
    short bleBytes = buff.getShort();
    setGun(bleBytes);
  }
}
