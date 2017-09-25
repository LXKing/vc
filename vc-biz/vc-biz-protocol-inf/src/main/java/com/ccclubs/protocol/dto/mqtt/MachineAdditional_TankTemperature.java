package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17. 工作温度
 */
public class MachineAdditional_TankTemperature implements IMachineAdditionalItem {

  /**
   * 工作温度
   */
  private int tankTemperature;

  public int getTankTemperature() {
    return tankTemperature;
  }

  public void setTankTemperature(int tankTemperature) {
    this.tankTemperature = tankTemperature;
  }

  @Override
  public byte getAdditionalId() {
    return (byte) 131;
  }

  @Override
  public byte getAdditionalLength() {
    return 1;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((byte) getTankTemperature());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setTankTemperature(buff.get());
  }
}
