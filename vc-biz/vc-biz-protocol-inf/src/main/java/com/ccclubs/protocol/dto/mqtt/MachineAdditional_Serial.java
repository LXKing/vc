package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;
import com.ccclubs.protocol.util.StringUtils;

/**
 * Created by qsxiaogang on 2017/4/17.
 * 序列号，终端信息
 */
public class MachineAdditional_Serial implements IMachineAdditionalItem {

  private byte additionalLength;
  /**
   * 序列号
   */
  private String cfxId;

  @Override
  public byte getAdditionalId() {
    return 0x01;
  }

  @Override
  public byte getAdditionalLength() {
    return additionalLength;
  }

  public final void setAdditionalLength(byte additionalLength) {
    this.additionalLength = additionalLength;
  }

  public String getCfxId() {
    return StringUtils.trim(cfxId);
  }

  public void setCfxId(String cfxId) {
    this.cfxId = cfxId;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getCfxId());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    setCfxId(new String(bytes));
  }
}
