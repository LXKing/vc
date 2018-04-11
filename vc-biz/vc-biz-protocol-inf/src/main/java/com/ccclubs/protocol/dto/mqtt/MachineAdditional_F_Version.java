package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17. <b>富士康专用<b/>富士康硬件版本，终端信息
 */
@Deprecated
public class MachineAdditional_F_Version implements IMachineAdditionalItem {

  /**
   * 硬件版本
   */
  private int version;

  @Override
  public byte getAdditionalId() {
    return 0x19;
  }

  @Override
  public byte getAdditionalLength() {
    return 2;
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
    buff.put((short) getVersion());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setVersion(buff.getShort());
  }
}
