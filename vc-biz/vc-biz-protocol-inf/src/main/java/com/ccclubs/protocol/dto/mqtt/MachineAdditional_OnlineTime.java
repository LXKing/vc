package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17.
 * 系统在线时间，终端信息
 */
public class MachineAdditional_OnlineTime implements IMachineAdditionalItem {

  /**
   * 系统在线时间
   */
  private int onlineTime;

  public int getOnlineTime() {
    return onlineTime;
  }

  public void setOnlineTime(int onlineTime) {
    this.onlineTime = onlineTime;
  }

  @Override
  public byte getAdditionalId() {
    return 31;
  }

  @Override
  public byte getAdditionalLength() {
    return 4;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getOnlineTime());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setOnlineTime(buff.getInt());
  }
}
