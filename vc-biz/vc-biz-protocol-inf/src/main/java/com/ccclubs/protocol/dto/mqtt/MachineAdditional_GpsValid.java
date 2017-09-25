package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17. GPS 定位是否有效
 */
public class MachineAdditional_GpsValid implements IMachineAdditionalItem {

  /**
   * GPS 定位是否有效 1 有效，0 无效
   */
  private int gpsValid;

  public int getGpsValid() {
    return gpsValid;
  }

  public void setGpsValid(int gpsValid) {
    this.gpsValid = gpsValid;
  }

  @Override
  public byte getAdditionalId() {
    return 125;
  }

  @Override
  public byte getAdditionalLength() {
    return 1;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((byte) getGpsValid());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setGpsValid(buff.get());
  }
}
