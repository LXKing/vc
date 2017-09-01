package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;
import com.ccclubs.protocol.util.StringUtils;

/**
 * Created by qsxiaogang on 2017/4/17.
 * 车架号，终端信息
 */
public class MachineAdditional_Vin implements IMachineAdditionalItem {

  private byte additionalLength;
  /**
   * 车架号
   */
  private String vin;

  @Override
  public byte getAdditionalId() {
    return 0x03;
  }

  @Override
  public byte getAdditionalLength() {
    return additionalLength;
  }

  public void setAdditionalLength(byte additionalLength) {
    this.additionalLength = additionalLength;
  }

  public String getVin() {
    return StringUtils.trim(vin);
  }

  public void setVin(String vin) {
    this.vin = vin;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getVin());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    setVin(new String(bytes));
  }
}
