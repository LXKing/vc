package com.ccclubs.protocol.dto.mqtt;


import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17.
 * APP版本，终端信息
 */
public class MachineAdditional_BleVersion implements IMachineAdditionalItem {

  /**
   * 蓝牙版本
   */
  private int bleVersion;

  @Override
  public byte getAdditionalId() {
    return 0x08;
  }

  @Override
  public byte getAdditionalLength() {
    return 2;
  }

  public int getBleVersion() {
    return bleVersion & 0xFFFF;
  }

  public void setBleVersion(int bleVersion) {
    this.bleVersion = bleVersion;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((short) getBleVersion());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setBleVersion(buff.getShort());
  }
}
