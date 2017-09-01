package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17.
 * 钥匙状态,终端信息
 */
public class MachineAdditional_KeyStatus implements IMachineAdditionalItem {

  public static int KEY_STATUS_UNKNOW = 0;
  public static int KEY_STATUS_IN = 1;
  public static int KEY_STATUS_OUT = 2;

  /**
   * 1插入，2拔出，0无效
   */
  private int keyStatus;

  public int getKeyStatus() {
    return keyStatus;
  }

  public void setKeyStatus(int keyStatus) {
    this.keyStatus = keyStatus;
  }

  @Override
  public byte getAdditionalId() {
    return 105;
  }

  @Override
  public byte getAdditionalLength() {
    return 1;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((byte) getKeyStatus());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setKeyStatus(buff.get());
  }
}
