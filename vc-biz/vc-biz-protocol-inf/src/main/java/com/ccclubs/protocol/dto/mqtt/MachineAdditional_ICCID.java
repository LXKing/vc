package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;
import com.ccclubs.protocol.util.StringUtils;

/**
 * Created by qsxiaogang on 2017/4/17.
 * 网络类型，终端信息
 */
public class MachineAdditional_ICCID implements IMachineAdditionalItem {

  private byte additionalLength;
  /**
   * CCID，手机全球唯一编码
   */
  private String iccid;

  public String getIccid() {
    return StringUtils.trim(iccid);
  }

  public void setIccid(String iccid) {
    this.iccid = iccid;
  }

  @Override
  public byte getAdditionalId() {
    return 0x0B;
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
    buff.put(getIccid());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    setIccid(new String(bytes));
  }
}
