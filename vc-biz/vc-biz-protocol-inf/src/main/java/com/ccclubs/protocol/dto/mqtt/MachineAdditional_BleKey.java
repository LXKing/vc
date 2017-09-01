package com.ccclubs.protocol.dto.mqtt;


import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;
import com.ccclubs.protocol.util.StringUtils;

/**
 * Created by qsxiaogang on 2017/4/17.
 * 蓝牙密钥，终端信息
 */
public class MachineAdditional_BleKey implements IMachineAdditionalItem {

  private byte additionalLength;
  /**
   * 蓝牙密钥
   */
  private String bleKey;

  public String getBleKey() {
    return StringUtils.trim(bleKey);
  }

  public void setBleKey(String bleKey) {
    this.bleKey = bleKey;
  }

  @Override
  public byte getAdditionalId() {
    return 33;
  }

  @Override
  public byte getAdditionalLength() {
    return additionalLength;
  }

  public void setAdditionalLength(byte additionalLength) {
    this.additionalLength = additionalLength;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getBleKey());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    setBleKey(new String(bytes));
  }
}
