package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17.
 * 门开合状态,终端信息
 */
public class MachineAdditional_MergeDoorStatusWithMask implements IMachineAdditionalItem {

  /**
   * 车门MASK
   * 1 Bit0 所有门状态有效位： 0-无效，1-有效
   * 2 Bit1 左前门有效位：0-无效，1-有效
   * 3 Bit2 右前门有效位：0-无效，1-有效
   * 4 Bit3 左后门有效位：0-无效，1-有效
   * 5 Bit4 右后门有效位：0-无效，1-有效
   * 6 Bit5 行李舱门有效位：0-无效，1-有效
   * 7 Bit6 前机舱有效位：0-无效，1-有效
   * 8 Bit7 预留
   */
  /**
   * 车门开关状态
   * 1 Bit0 所有门状态： 0-CLOSE，1-OPEN
   * 2 Bit1 左前门：0-CLOSE，1-OPEN
   * 3 Bit2 右前门：0-CLOSE，1-OPEN
   * 4 Bit3 左后门：0-CLOSE，1-OPEN
   * 5 Bit4 右后门：0-CLOSE，1-OPEN
   * 6 Bit5 行李舱门：0-CLOSE，1-OPEN
   * 7 Bit6 前机舱：0-CLOSE，1-OPEN
   * 8 Bit7 预留
   */
  private short doorStatus;

  public short getDoorStatus() {
    return doorStatus;
  }

  public void setDoorStatus(short doorStatus) {
    this.doorStatus = doorStatus;
  }

  @Override
  public byte getAdditionalId() {
    return (byte) 202;
  }

  @Override
  public byte getAdditionalLength() {
    return 2;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getDoorStatus());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setDoorStatus(buff.getShort());
  }
}
