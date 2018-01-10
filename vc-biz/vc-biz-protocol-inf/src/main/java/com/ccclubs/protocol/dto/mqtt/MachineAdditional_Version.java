package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17.
 * <b>通领专用<b/>硬件版本，终端信息
 */
@Deprecated
public class MachineAdditional_Version implements IMachineAdditionalItem {

  /**
   * 硬件版本
   */
  private int version;

  @Override
  public byte getAdditionalId() {
    return 0x05;
  }

  @Override
  public byte getAdditionalLength() {
    return 4;
  }

  public int getVersion() {
    return version;
  }

  public void setVersion(int version) {
    this.version = version;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getVersion());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setVersion(buff.getInt());
  }
}
