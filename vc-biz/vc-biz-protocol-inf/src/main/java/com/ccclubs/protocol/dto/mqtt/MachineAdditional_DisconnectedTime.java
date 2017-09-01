package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17.
 * 系统断线时间，终端信息
 */
public class MachineAdditional_DisconnectedTime implements IMachineAdditionalItem {

  /**
   * 系统断线时间
   */
  private int disconnectedTime;

  public int getDisconnectedTime() {
    return disconnectedTime;
  }

  public void setDisconnectedTime(int disconnectedTime) {
    this.disconnectedTime = disconnectedTime;
  }

  @Override
  public byte getAdditionalId() {
    return 32;
  }

  @Override
  public byte getAdditionalLength() {
    return 4;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getDisconnectedTime());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setDisconnectedTime(buff.getInt());
  }
}
