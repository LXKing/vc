package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17.
 * 所有门状态,终端信息
 */
@Deprecated
public class MachineAdditional_AllDoorStatus implements IMachineAdditionalItem {

  /**
   * 1开启，2关闭，0无效
   */
  private int doorStatus;

  public int getDoorStatus() {
    return doorStatus;
  }

  public void setDoorStatus(int doorStatus) {
    this.doorStatus = doorStatus;
  }

  @Override
  public byte getAdditionalId() {
    return 102;
  }

  @Override
  public byte getAdditionalLength() {
    return 1;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((byte) getDoorStatus());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setDoorStatus(buff.get());
  }
}
