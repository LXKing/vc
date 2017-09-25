package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17. 输出口状态
 */
public class MachineAdditional_OutputStatus implements IMachineAdditionalItem {

  /**
   * 输出口状态
   */
  private int outputStatus;

  public int getOutputStatus() {
    return outputStatus;
  }

  public void setOutputStatus(int outputStatus) {
    this.outputStatus = outputStatus;
  }

  @Override
  public byte getAdditionalId() {
    return (byte) 150;
  }

  @Override
  public byte getAdditionalLength() {
    return 4;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getOutputStatus());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setOutputStatus(buff.getInt());
  }
}
