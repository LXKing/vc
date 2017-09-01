package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17.
 * <b>中导专用<b/>主版本，硬件版本，终端信息
 */
public class MachineAdditional_Z_HardWareVersion implements IMachineAdditionalItem {

  /**
   * 硬件版本
   */
  private int hardWareVersion;

  @Override
  public byte getAdditionalId() {
    return 28;
  }

  @Override
  public byte getAdditionalLength() {
    return 2;
  }

  public int getHardWareVersion() {
    return hardWareVersion & 0xFFFF;
  }

  public void setHardWareVersion(int hardWareVersion) {
    this.hardWareVersion = hardWareVersion;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((short) getHardWareVersion());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setHardWareVersion(buff.getShort());
  }
}
