package com.ccclubs.protocol.dto.mqtt;


import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by Administrator on 2017/8/15 0015. 车机硬件版本
 */
public class MachineAdditional_HardwareVersion implements IMachineAdditionalItem {

  //车机硬件版本
  private int hardwareVersion;

  public int getHardwareVersion() {
    return hardwareVersion;
  }

  public void setHardwareVersion(int hardwareVersion) {
    this.hardwareVersion = hardwareVersion;
  }

  @Override
  public byte getAdditionalId() {
    return 36;
  }

  @Override
  public byte getAdditionalLength() {
    return 4;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buffer = new MyBuffer();
    buffer.put(getHardwareVersion());
    return buffer.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buffer = new MyBuffer(bytes);
    setHardwareVersion(buffer.getInt());

  }
}
