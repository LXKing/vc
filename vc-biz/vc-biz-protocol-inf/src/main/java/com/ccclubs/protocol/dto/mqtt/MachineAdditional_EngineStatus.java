package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17.
 * 发动机状态,终端信息
 */
public class MachineAdditional_EngineStatus implements IMachineAdditionalItem {

  public static int ENGINE_STATUS_ON = 1;
  public static int ENGINE_STATUS_OFF = 2;

  /**
   * 1未熄火，2已熄火，0无效
   */
  private int engineStatus;

  public int getEngineStatus() {
    return engineStatus & 0xFF;
  }

  public void setEngineStatus(int engineStatus) {
    this.engineStatus = engineStatus;
  }

  @Override
  public byte getAdditionalId() {
    return 103;
  }

  @Override
  public byte getAdditionalLength() {
    return 1;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((byte) getEngineStatus());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setEngineStatus(buff.get());
  }
}
