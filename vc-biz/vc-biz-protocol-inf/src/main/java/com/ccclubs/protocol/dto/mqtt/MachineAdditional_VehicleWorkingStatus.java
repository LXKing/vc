package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17. 休眠模式
 */
public class MachineAdditional_VehicleWorkingStatus implements IMachineAdditionalItem {

  /**
   * 休眠模式
   */
  private int vehicleWorkingStatus;

  public int getVehicleWorkingStatus() {
    return vehicleWorkingStatus;
  }

  public void setVehicleWorkingStatus(int vehicleWorkingStatus) {
    this.vehicleWorkingStatus = vehicleWorkingStatus;
  }

  @Override
  public byte getAdditionalId() {
    return (byte) 132;
  }

  @Override
  public byte getAdditionalLength() {
    return 1;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((byte) getVehicleWorkingStatus());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setVehicleWorkingStatus(buff.get());
  }
}
