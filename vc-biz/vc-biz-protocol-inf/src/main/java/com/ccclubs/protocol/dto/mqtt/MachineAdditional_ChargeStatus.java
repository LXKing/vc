package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17.
 * 充电状态,终端信息
 */
public class MachineAdditional_ChargeStatus implements IMachineAdditionalItem {

  /**
   * 1不充电，2充电，3慢充，4快充，0无效
   */
  private int chargeStatus;

  public int getChargeStatus() {
    return chargeStatus;
  }

  public void setChargeStatus(int chargeStatus) {
    this.chargeStatus = chargeStatus;
  }

  @Override
  public byte getAdditionalId() {
    return 104;
  }

  @Override
  public byte getAdditionalLength() {
    return 1;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((byte) getChargeStatus());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setChargeStatus(buff.get());
  }
}
