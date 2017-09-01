package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17.
 * 门锁状态，带mask值,终端信息
 */
public class MachineAdditional_DoorLockStatusWithMask implements IMachineAdditionalItem {

  /**
   * mask值
   * 车锁MASK
   * 1 Bit0 所有门有效位： 0-无效，1-有效
   * 2 Bit1 左前门有效位：0-无效，1-有效
   * 3 Bit2 右前门有效位：0-无效，1-有效
   * 4 Bit3 左后门有效位：0-无效，1-有效
   * 5 Bit4 右后门有效位：0-无效，1-有效
   * 6 Bit5 行李舱门有效位：0-无效，1-有效
   * 7 Bit6 预留
   * 8 Bit7 预留
   */
  /**
   * 车锁状态
   * 1 Bit0 所有门状态： 0-ALLLOCK，1-UNLOCK
   * 2 Bit1 左前门：0-LOCK，1-UNLOCK
   * 3 Bit2 右前门：0-LOCK，1-UNLOCK
   * 4 Bit3 左后门：0-LOCK，1-UNLOCK
   * 5 Bit4 右后门：0-LOCK，1-UNLOCK
   * 6 Bit5 行李舱门：0-LOCK，1-UNLOCK
   * 7 Bit6 预留
   * 8 Bit7 预留
   */
  private short doorLockStatus;

  public short getDoorLockStatus() {
    return doorLockStatus;
  }

  public void setDoorLockStatus(short doorLockStatus) {
    this.doorLockStatus = doorLockStatus;
  }

  @Override
  public byte getAdditionalId() {
    return (byte) 204;
  }

  @Override
  public byte getAdditionalLength() {
    return 2;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getDoorLockStatus());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setDoorLockStatus(buff.getShort());
  }
}
