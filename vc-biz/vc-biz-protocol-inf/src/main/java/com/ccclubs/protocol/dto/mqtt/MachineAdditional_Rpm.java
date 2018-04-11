package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17. 转速，单位1r/min
 */
public class MachineAdditional_Rpm implements IMachineAdditionalItem {

  /**
   * 转速，单位1r/min
   */
  private int rpm;

  public int getRpm() {
    return rpm;
  }

  public void setRpm(int rpm) {
    this.rpm = rpm;
  }

  @Override
  public byte getAdditionalId() {
    return 127;
  }

  @Override
  public byte getAdditionalLength() {
    return 2;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((short) getRpm());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setRpm(buff.getShort());
  }
}
