package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;
import com.ccclubs.protocol.util.Tools;

/**
 * Created by qsxiaogang on 2017/4/17.
 * 序列号，终端信息
 */
public class MachineAdditional_MacAddress implements IMachineAdditionalItem {

  /**
   * 蓝牙MAC地址
   */
  private String macAddress;

  @Override
  public byte getAdditionalId() {
    return 0x0C;
  }

  @Override
  public byte getAdditionalLength() {
    return 6;
  }

  public String getMacAddress() {
    return macAddress;
  }

  public void setMacAddress(String macAddress) {
    this.macAddress = macAddress;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(Tools.HexString2Bytes(getMacAddress()));
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    setMacAddress(Tools.ToHexString(bytes));
  }
}
