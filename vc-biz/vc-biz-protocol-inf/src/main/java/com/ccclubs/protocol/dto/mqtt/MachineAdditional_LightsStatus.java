package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17.
 * 灯状态,终端信息
 */
public class MachineAdditional_LightsStatus implements IMachineAdditionalItem {

  /**
   * 1未关，2全关，0无效
   */
  private int lightsStatus;

  public int getLightsStatus() {
    return lightsStatus;
  }

  public void setLightsStatus(int lightsStatus) {
    this.lightsStatus = lightsStatus;
  }

  @Override
  public byte getAdditionalId() {
    return 107;
  }

  @Override
  public byte getAdditionalLength() {
    return 1;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((byte) getLightsStatus());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setLightsStatus(buff.get());
  }
}
