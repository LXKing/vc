package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17.
 * 防盗状态,终端信息
 */
public class MachineAdditional_AntiTheftStatus implements IMachineAdditionalItem {

  /**
   * 1防盗开启，2防盗关闭，0无效
   */
  private int antiTheftStatus;

  public int getAntiTheftStatus() {
    return antiTheftStatus;
  }

  public void setAntiTheftStatus(int antiTheftStatus) {
    this.antiTheftStatus = antiTheftStatus;
  }

  @Override
  public byte getAdditionalId() {
    return 110;
  }

  @Override
  public byte getAdditionalLength() {
    return 1;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((byte) getAntiTheftStatus());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setAntiTheftStatus(buff.get());
  }
}
