package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17.
 * 插枪还车校验值，终端信息
 */
public class MachineAdditional_PlugGun implements IMachineAdditionalItem {

  /**
   * 插枪还车校验值
   */
  private int plugGun;

  public int getPlugGun() {
    return plugGun;
  }

  public void setPlugGun(int plugGun) {
    this.plugGun = plugGun;
  }

  @Override
  public byte getAdditionalId() {
    return 0x11;
  }

  @Override
  public byte getAdditionalLength() {
    return 1;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((byte) getPlugGun());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setPlugGun(buff.get());
  }
}
