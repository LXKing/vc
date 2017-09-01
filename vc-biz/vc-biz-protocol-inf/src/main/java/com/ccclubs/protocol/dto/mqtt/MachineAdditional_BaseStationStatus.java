package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17.
 * 基站数据，终端信息
 */
public class MachineAdditional_BaseStationStatus implements IMachineAdditionalItem {

  private byte additionalLength;
  /**
   * 基站lac
   */
  private int lac;
  /**
   * 基站ci
   */
  private int ci;

  public int getLac() {
    return lac & 0xFFFF;
  }

  public void setLac(int lac) {
    this.lac = lac;
  }

  public int getCi() {
    return ci;
  }

  public void setCi(int ci) {
    this.ci = ci;
  }

  @Override
  public byte getAdditionalId() {
    return 114;
  }

  @Override
  public byte getAdditionalLength() {
    return 6;
  }

  public void setAdditionalLength(byte additionalLength) {
    this.additionalLength = additionalLength;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((short) getLac());
    buff.put(getCi());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setLac(buff.getShort());
    setCi(buff.getInt());
  }
}
