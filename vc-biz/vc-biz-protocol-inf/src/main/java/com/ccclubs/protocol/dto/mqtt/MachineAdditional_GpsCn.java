package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17. GPS 信号强度,单位分贝
 */
public class MachineAdditional_GpsCn implements IMachineAdditionalItem {

  /**
   * 1插入，2拔出，0无效
   */
  private int gpsCn;

  public int getGpsCn() {
    return gpsCn;
  }

  public void setGpsCn(int gpsCn) {
    this.gpsCn = gpsCn;
  }

  @Override
  public byte getAdditionalId() {
    return 123;
  }

  @Override
  public byte getAdditionalLength() {
    return 1;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((byte) getGpsCn());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setGpsCn(buff.get());
  }
}
