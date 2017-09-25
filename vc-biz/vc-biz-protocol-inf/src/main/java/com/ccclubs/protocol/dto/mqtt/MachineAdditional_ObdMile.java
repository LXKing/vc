package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17.
 * 累计里程,终端信息
 */
public class MachineAdditional_ObdMile implements IMachineAdditionalItem {

  /**
   * 累计里程
   */
  private int obdMile;

  public int getObdMile() {
    return obdMile;
  }

  public void setObdMile(int obdMile) {
    this.obdMile = obdMile;
  }

  @Override
  public byte getAdditionalId() {
    return 116;
  }

  @Override
  public byte getAdditionalLength() {
    return 4;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getObdMile());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setObdMile(buff.getInt());
  }
}
