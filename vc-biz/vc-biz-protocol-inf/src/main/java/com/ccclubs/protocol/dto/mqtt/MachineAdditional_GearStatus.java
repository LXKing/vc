package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17.
 * 档位状态,终端信息
 */
public class MachineAdditional_GearStatus implements IMachineAdditionalItem {

  public static int GEAR_STATUS_P = 15;
  public static int GEAR_STATUS_N = 0;
  public static int GEAR_STATUS_D = 14;
  public static int GEAR_STATUS_R = 13;

  /**
   * =0000   空挡
   * =0001   1挡
   * =0010   2挡
   * =0011   3挡
   * =0100   4挡
   * =0101   5挡
   * =0110   6挡
   * =……
   * =1101   倒挡
   * =1110   自动D挡
   * =1111   停车P挡
   */
  private int gearStatus;

  public int getGearStatus() {
    return gearStatus & 0xFF;
  }

  public void setGearStatus(int gearStatus) {
    this.gearStatus = gearStatus;
  }

  @Override
  public byte getAdditionalId() {
    return 108;
  }

  @Override
  public byte getAdditionalLength() {
    return 1;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((byte) getGearStatus());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setGearStatus(buff.get());
  }
}
