package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17. SOC，动力电池电量,终端信息
 */
public class MachineAdditional_SOC implements IMachineAdditionalItem {

  /**
   * 动力电池电量，电池电量百分比
   */
  private byte soc;

  public int getSoc() {
    return soc;
  }

  public void setSoc(byte soc) {
    this.soc = soc;
  }

  @Override
  public byte getAdditionalId() {
    return 118;
  }

  @Override
  public byte getAdditionalLength() {
    return 1;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((byte) getSoc());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setSoc(buff.get());
  }
}
