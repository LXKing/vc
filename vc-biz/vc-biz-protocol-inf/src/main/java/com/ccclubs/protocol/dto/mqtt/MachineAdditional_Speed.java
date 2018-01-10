package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17. 车速，单位0.1km/h
 */
public class MachineAdditional_Speed implements IMachineAdditionalItem {

  /**
   * 车速，单位0.1km/h
   */
  private int speed;

  public int getSpeed() {
    return speed;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  @Override
  public byte getAdditionalId() {
    return (byte) 128;
  }

  @Override
  public byte getAdditionalLength() {
    return 2;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((short) getSpeed());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setSpeed(buff.getShort());
  }
}
