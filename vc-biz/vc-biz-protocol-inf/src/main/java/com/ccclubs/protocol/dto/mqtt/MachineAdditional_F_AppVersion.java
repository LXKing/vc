package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17. <b>富士康设备专用<b/>富士康软件版本，终端信息
 */
@Deprecated
public class MachineAdditional_F_AppVersion implements IMachineAdditionalItem {

  /**
   * 富士康软件版本
   */
  private int appVersion;

  @Override
  public byte getAdditionalId() {
    return 0x1B;
  }

  @Override
  public byte getAdditionalLength() {
    return 2;
  }

  public int getAppVersion() {
    return appVersion;
  }

  public void setAppVersion(int appVersion) {
    this.appVersion = appVersion;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((short) getAppVersion());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setAppVersion(buff.getShort());
  }
}
