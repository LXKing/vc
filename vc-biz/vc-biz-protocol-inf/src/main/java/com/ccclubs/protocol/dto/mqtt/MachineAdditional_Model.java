package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17.
 * 适配车型，终端信息
 */
public class MachineAdditional_Model implements IMachineAdditionalItem {

  /**
   * 适配车型
   */
  private int model;

  @Override
  public byte getAdditionalId() {
    return 0x04;
  }

  @Override
  public byte getAdditionalLength() {
    return 2;
  }

  public int getModel() {
    return model;
  }

  public void setModel(int model) {
    this.model = model;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((short) getModel());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setModel(buff.getShort());
  }
}
