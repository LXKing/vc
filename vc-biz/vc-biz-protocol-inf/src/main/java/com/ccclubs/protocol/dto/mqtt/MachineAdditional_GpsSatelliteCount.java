package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17. GPS 卫星有效数
 */
public class MachineAdditional_GpsSatelliteCount implements IMachineAdditionalItem {

  /**
   * 卫星有效数
   */
  private int gpsSatelliteCount;

  public int getGpsSatelliteCount() {
    return gpsSatelliteCount;
  }

  public void setGpsSatelliteCount(int gpsSatelliteCount) {
    this.gpsSatelliteCount = gpsSatelliteCount;
  }

  @Override
  public byte getAdditionalId() {
    return 124;
  }

  @Override
  public byte getAdditionalLength() {
    return 1;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((byte) getGpsSatelliteCount());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setGpsSatelliteCount(buff.get());
  }
}
