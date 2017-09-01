package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17.
 * 系统当前时间，终端信息
 */
public class MachineAdditional_SystemTime implements IMachineAdditionalItem {

  /**
   * 系统当前时间
   */
  private int currentTime;

  public int getCurrentTime() {
    return currentTime;
  }

  public void setCurrentTime(int currentTime) {
    this.currentTime = currentTime;
  }

  @Override
  public byte getAdditionalId() {
    return 0x14;
  }

  @Override
  public byte getAdditionalLength() {
    return 4;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getCurrentTime());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setCurrentTime(buff.getInt());
  }
}
