package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17. E200 PEPS 版本，终端信息
 */
public class MachineAdditional_PepsVersion implements IMachineAdditionalItem {

  /**
   * PEPS 版本
   */
  private int pepsVersion;

  @Override
  public byte getAdditionalId() {
    return 34;
  }

  @Override
  public byte getAdditionalLength() {
    return 1;
  }

  public int getPepsVersion() {
    return pepsVersion;
  }

  public void setPepsVersion(int pepsVersion) {
    this.pepsVersion = pepsVersion;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((byte) getPepsVersion());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setPepsVersion(buff.get());
  }
}
