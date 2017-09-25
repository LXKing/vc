package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17.
 * CAN波特率，终端信息
 */
public class MachineAdditional_CanBaudRate implements IMachineAdditionalItem {

  /**
   * CAN波特率，单位k
   */
  private int canBaudRate;

  public int getCanBaudRate() {
    return canBaudRate;
  }

  public void setCanBaudRate(int canBaudRate) {
    this.canBaudRate = canBaudRate;
  }

  @Override
  public byte getAdditionalId() {
    return 0x12;
  }

  @Override
  public byte getAdditionalLength() {
    return 2;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((short) getCanBaudRate());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setCanBaudRate(buff.getShort());
  }
}
