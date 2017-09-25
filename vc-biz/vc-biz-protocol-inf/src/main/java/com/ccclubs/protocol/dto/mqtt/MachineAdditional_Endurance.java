package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17. 电动车续航里程
 */
public class MachineAdditional_Endurance implements IMachineAdditionalItem {

  /**
   * 续航里程，单位km
   */
  private short endurance;

  public int getEndurance() {
    return endurance;
  }

  public void setEndurance(short endurance) {
    this.endurance = endurance;
  }

  @Override
  public byte getAdditionalId() {
    return 119;
  }

  @Override
  public byte getAdditionalLength() {
    return 2;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((short) getEndurance());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setEndurance(buff.getShort());
  }
}
