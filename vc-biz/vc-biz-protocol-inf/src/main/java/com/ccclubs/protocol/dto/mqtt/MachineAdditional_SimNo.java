package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;
import com.ccclubs.protocol.util.StringUtils;

/**
 * Created by qsxiaogang on 2017/4/17.
 * 手机号，终端信息
 */
public class MachineAdditional_SimNo implements IMachineAdditionalItem {

  private byte additionalLength;
  /**
   * 手机号
   */
  private String simNo;

  @Override
  public byte getAdditionalId() {
    return 0x02;
  }

  @Override
  public byte getAdditionalLength() {
    return additionalLength;
  }

  public void setAdditionalLength(byte additionalLength) {
    this.additionalLength = additionalLength;
  }

  public String getSimNo() {
    return StringUtils.trim(simNo);
  }

  public void setSimNo(String simNo) {
    this.simNo = simNo;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getSimNo());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    setSimNo(new String(bytes));
  }
}
