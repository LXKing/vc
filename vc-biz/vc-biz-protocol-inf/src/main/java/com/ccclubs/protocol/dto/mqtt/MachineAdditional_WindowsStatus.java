package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17.
 * 车窗状态,终端信息
 */
@Deprecated
public class MachineAdditional_WindowsStatus implements IMachineAdditionalItem {

  /**
   * 1未关，2全关，0无效
   */
  private int windowsStatus;

  public int getWindowsStatus() {
    return windowsStatus;
  }

  public void setWindowsStatus(int windowsStatus) {
    this.windowsStatus = windowsStatus;
  }

  @Override
  public byte getAdditionalId() {
    return 106;
  }

  @Override
  public byte getAdditionalLength() {
    return 1;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((byte) getWindowsStatus());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setWindowsStatus(buff.get());
  }
}
