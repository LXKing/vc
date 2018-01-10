package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;


/**
 * Created by qsxiaogang on 2017/4/17. 空调状态
 */
public class MachineAdditional_AirConditionerCircular implements IMachineAdditionalItem {

  /**
   * 空调状态
   */
  private int airConditionerCircular;

  public int getAirConditionerCircular() {
    return airConditionerCircular;
  }

  public void setAirConditionerCircular(int airConditionerCircular) {
    this.airConditionerCircular = airConditionerCircular;
  }

  @Override
  public byte getAdditionalId() {
    return (byte) 136;
  }

  @Override
  public byte getAdditionalLength() {
    return 1;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((byte) getAirConditionerCircular());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setAirConditionerCircular(buff.get());
  }
}
