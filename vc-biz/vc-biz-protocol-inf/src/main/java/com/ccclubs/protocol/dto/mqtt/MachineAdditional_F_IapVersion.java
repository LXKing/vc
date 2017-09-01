package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17.
 * <b>富士康设备专用<b/>富士康IAP版本，终端信息
 */
public class MachineAdditional_F_IapVersion implements IMachineAdditionalItem {

  /**
   * 富士康IAP版本
   */
  private int iapVersion;

  @Override
  public byte getAdditionalId() {
    return 0x1A;
  }

  @Override
  public byte getAdditionalLength() {
    return 2;
  }

  public int getIapVersion() {
    return iapVersion & 0xFFFF;
  }

  public void setIapVersion(int iapVersion) {
    this.iapVersion = iapVersion;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((short) getIapVersion());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setIapVersion(buff.getShort());
  }
}
