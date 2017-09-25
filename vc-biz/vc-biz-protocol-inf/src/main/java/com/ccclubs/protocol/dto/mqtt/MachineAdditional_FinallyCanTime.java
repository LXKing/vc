package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17. 最后一条网络命令时间
 */
public class MachineAdditional_FinallyCanTime implements IMachineAdditionalItem {

  /**
   * 最后一条网络命令时间
   */
  private int finallyCanTime;

  public int getFinallyCanTime() {
    return finallyCanTime;
  }

  public void setFinallyCanTime(int finallyCanTime) {
    this.finallyCanTime = finallyCanTime;
  }

  @Override
  public byte getAdditionalId() {
    return (byte) 149;
  }

  @Override
  public byte getAdditionalLength() {
    return 4;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getFinallyCanTime());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setFinallyCanTime(buff.getInt());
  }
}
