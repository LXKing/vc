package com.ccclubs.protocol.dto.jt808;

import com.ccclubs.protocol.inf.IMessageBody;
import com.ccclubs.protocol.util.MyBuffer;
import com.ccclubs.protocol.util.StringUtils;

/**
 * 通领终端上报VIN码
 */
public class JT_00F4 implements IMessageBody {

  /**
   * 国家规定的VIN码，ASCC字符
   * 如果收到的平台VIN码与平台
   */
  private String vin;
  /**
   * 可充电储能子系统数n，有效值范围：0～250。
   */
  private byte rechargeableSubsystemsTotalNumber;
  /**
   * 电池编码长度，十六进制，如果为0后面无电池编码字段，表示终端内部无电池编码
   */
  private byte rechargeableSubsystemsLength;
  /**
   * ASCII字符
   */
  private String rechargeableSubsystemsCode;

  public String getVin() {
    return vin.trim();
  }

  public void setVin(String vin) {
    this.vin = vin;
  }

  public byte getRechargeableSubsystemsTotalNumber() {
    return rechargeableSubsystemsTotalNumber;
  }

  public void setRechargeableSubsystemsTotalNumber(byte rechargeableSubsystemsTotalNumber) {
    this.rechargeableSubsystemsTotalNumber = rechargeableSubsystemsTotalNumber;
  }

  public byte getRechargeableSubsystemsLength() {
    return rechargeableSubsystemsLength;
  }

  public void setRechargeableSubsystemsLength(byte rechargeableSubsystemsLength) {
    this.rechargeableSubsystemsLength = rechargeableSubsystemsLength;
  }

  public String getRechargeableSubsystemsCode() {
    return rechargeableSubsystemsCode;
  }

  public void setRechargeableSubsystemsCode(String rechargeableSubsystemsCode) {
    this.rechargeableSubsystemsCode = rechargeableSubsystemsCode;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getVin().getBytes());
    for (int i = 0; i + getVin().getBytes().length < 17; i++) {
      buff.put((byte) 0x00);
    }
    buff.put(getRechargeableSubsystemsTotalNumber());
    buff.put(getRechargeableSubsystemsLength());
    if (!StringUtils.empty(getRechargeableSubsystemsCode())) {
      buff.put(getRechargeableSubsystemsCode().getBytes());
    }
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] messageBodyBytes) {
    MyBuffer buff = new MyBuffer(messageBodyBytes);
    byte[] vinBytes = buff.gets(17);
    setVin((new String(vinBytes)).trim().toUpperCase());
    setRechargeableSubsystemsTotalNumber(buff.get());
    setRechargeableSubsystemsLength(buff.get());
    int totalLength = getRechargeableSubsystemsTotalNumber()
        * getRechargeableSubsystemsLength();
    if (totalLength > 0) {
      byte[] subsystemsCodeBytes = buff.gets(totalLength);
      setRechargeableSubsystemsCode(new String(subsystemsCodeBytes));
    }
  }

}
