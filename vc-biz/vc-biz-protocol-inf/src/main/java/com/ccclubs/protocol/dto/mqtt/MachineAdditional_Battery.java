package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17. 车机电源电压
 */
public class MachineAdditional_Battery implements IMachineAdditionalItem {

  /**
   * 车机电源电压，单位10mV
   */
  private int battery;

  public int getBattery() {
    return battery;
  }

  public void setBattery(int battery) {
    this.battery = battery;
  }

  @Override
  public byte getAdditionalId() {
    return (byte) 144;
  }

  @Override
  public byte getAdditionalLength() {
    return 2;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((short) getBattery());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setBattery(buff.getShort());
  }
}
