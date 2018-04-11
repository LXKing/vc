package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17. 燃油量，单位0.1L
 */
public class MachineAdditional_Oil implements IMachineAdditionalItem {

  /**
   * 燃油量，单位0.1L
   */
  private int oil;

  public int getOil() {
    return oil;
  }

  public void setOil(int oil) {
    this.oil = oil;
  }

  @Override
  public byte getAdditionalId() {
    return 126;
  }

  @Override
  public byte getAdditionalLength() {
    return 2;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((short) getOil());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setOil(buff.getShort());
  }
}
