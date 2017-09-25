package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17. 最后一个CAN包时间
 */
public class MachineAdditional_FinallyRemoteTime implements IMachineAdditionalItem {

  /**
   * 最后一个CAN包时间
   */
  private int finallyRemoteTime;

  public int getFinallyRemoteTime() {
    return finallyRemoteTime;
  }

  public void setFinallyRemoteTime(int finallyRemoteTime) {
    this.finallyRemoteTime = finallyRemoteTime;
  }

  @Override
  public byte getAdditionalId() {
    return (byte) 147;
  }

  @Override
  public byte getAdditionalLength() {
    return 4;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getFinallyRemoteTime());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setFinallyRemoteTime(buff.getInt());
  }
}
