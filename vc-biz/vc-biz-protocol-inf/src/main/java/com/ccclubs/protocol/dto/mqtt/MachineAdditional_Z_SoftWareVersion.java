package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17.
 * <b>中导专用<b/>主版本，软件版本，终端信息
 */
public class MachineAdditional_Z_SoftWareVersion implements IMachineAdditionalItem {

  /**
   * 软件版本
   */
  private int softWareVersion;

  @Override
  public byte getAdditionalId() {
    return 29;
  }

  @Override
  public byte getAdditionalLength() {
    return 4;
  }

  public int getSoftWareVersion() {
    return softWareVersion;
  }

  public void setSoftWareVersion(int softWareVersion) {
    this.softWareVersion = softWareVersion;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getSoftWareVersion());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setSoftWareVersion(buff.getInt());
  }
}
