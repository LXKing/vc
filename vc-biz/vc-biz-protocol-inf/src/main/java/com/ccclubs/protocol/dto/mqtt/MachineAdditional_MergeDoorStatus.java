package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17.
 * 所有门合并状态,终端信息
 */
public class MachineAdditional_MergeDoorStatus implements IMachineAdditionalItem {

  /**
   * 1	Bit0-Bit1	0-车门未全部关好，1-车门关好，2-车门信息未检测到
   * 2	Bit2-Bit3	主驾驶门：0-OFF，1-ON，2-未知
   * 3	Bit4-Bit5	右一门：0-OFF，1-ON，2-未知
   * 4	Bit6-Bit7	后排门：0-OFF，1-ON，2-未知
   */
  private byte doorStatus;

  public byte getDoorStatus() {
    return doorStatus;
  }

  public void setDoorStatus(byte doorStatus) {
    this.doorStatus = doorStatus;
  }

  @Override
  public byte getAdditionalId() {
    return 112;
  }

  @Override
  public byte getAdditionalLength() {
    return 1;
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
    setDoorStatus(buff.get());
  }
}
