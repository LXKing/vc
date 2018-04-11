package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17. <b>通领专用<b/>主版本，软件版本1，终端信息
 */
@Deprecated
public class MachineAdditional_SoftwareVersionI implements IMachineAdditionalItem {

  /**
   * 软件版本1
   */
  private int softwareVersion;

  @Override
  public byte getAdditionalId() {
    return 0x06;
  }

  @Override
  public byte getAdditionalLength() {
    return 4;
  }

  public int getSoftwareVersion() {
    return softwareVersion;
  }

  public void setSoftwareVersion(int softwareVersion) {
    this.softwareVersion = softwareVersion;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getSoftwareVersion());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setSoftwareVersion(buff.getInt());
  }
}
