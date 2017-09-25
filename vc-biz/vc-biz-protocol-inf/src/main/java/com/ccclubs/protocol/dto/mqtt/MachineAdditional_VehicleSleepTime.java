package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;


/**
 * Created by qsxiaogang on 2017/4/17. 休眠时间
 */
public class MachineAdditional_VehicleSleepTime implements IMachineAdditionalItem {

  /**
   * 休眠时间
   */
  private int vehicleSleepTime;

  public int getVehicleSleepTime() {
    return vehicleSleepTime;
  }

  public void setVehicleSleepTime(int vehicleSleepTime) {
    this.vehicleSleepTime = vehicleSleepTime;
  }

  @Override
  public byte getAdditionalId() {
    return (byte) 133;
  }

  @Override
  public byte getAdditionalLength() {
    return 2;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((short) getVehicleSleepTime());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setVehicleSleepTime(buff.getShort());
  }
}
