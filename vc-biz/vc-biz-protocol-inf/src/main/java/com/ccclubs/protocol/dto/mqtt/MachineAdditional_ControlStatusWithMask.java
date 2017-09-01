package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17.
 * 控制，带mask值,终端信息
 */
public class MachineAdditional_ControlStatusWithMask implements IMachineAdditionalItem {

  /**
   * 控制MASK
   * 1 Bit0 钥匙启动有效位： 0-无效，1-有效
   * 2 Bit1 按钮启动有效位： 0-无效，1-有效
   * 3 Bit2 预留
   * 4 Bit3 预留
   * 5 Bit4 预留
   * 6 Bit5 预留
   * 7 Bit6 预留
   * 8 Bit7 预留
   */
  private byte mask;
  /**
   * 控制状态
   * 1 Bit0 钥匙启动控制： 0-禁止钥匙启动，1-允许钥匙启动
   * 2 Bit1 按钮启动控制： 0-按钮无效    ，1-按钮有效
   * 3 Bit2 预留
   * 4 Bit3 预留
   * 5 Bit4 预留
   * 6 Bit5 预留
   * 7 Bit6 预留
   * 8 Bit7 预留
   */
  private byte controlStatus;

  public byte getMask() {
    return mask;
  }

  public void setMask(byte mask) {
    this.mask = mask;
  }

  public byte getControlStatus() {
    return controlStatus;
  }

  public void setControlStatus(byte controlStatus) {
    this.controlStatus = controlStatus;
  }

  @Override
  public byte getAdditionalId() {
    return (byte) 208;
  }

  @Override
  public byte getAdditionalLength() {
    return 2;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getMask());
    buff.put(getControlStatus());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setMask(buff.get());
    setControlStatus(buff.get());
  }
}
