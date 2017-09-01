package com.ccclubs.protocol.dto.jt808;

import com.ccclubs.protocol.inf.IMessageBody;
import com.ccclubs.protocol.util.MyBuffer;
import com.ccclubs.protocol.util.StringUtils;

/**
 * 通领终端设置VIN码指令
 */
public class JT_80F4 implements IMessageBody {


  /**
   * 对应VIN码同步请求的消息流水号
   */
  private short messageSerialNo;
  /**
   * 平台VIN码状态
   * 0x00:平台没有VIN码,后面的VIN字段字段全部0x00,终端忽略设置
   * 0x01:平台有VIN码,后面有VIN码字段,如果全部为0x00,终端清空内部的VIN码设置
   */
  private byte platformVinStatus;
  /**
   * 国家规定的VIN码，ASCC字符
   * 如果收到的平台VIN码与平台
   */
  private String platformVin;

  /**
   * 0x00:平台没有电池编码,后面的电池子系统数为0x00，电池编码长度为0x00，终端忽略设置
   * 0x01:平台有电池编码
   */
  private byte platformCodeStatus;

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

  public short getMessageSerialNo() {
    return messageSerialNo;
  }

  public void setMessageSerialNo(short messageSerialNo) {
    this.messageSerialNo = messageSerialNo;
  }

  public byte getPlatformVinStatus() {
    return platformVinStatus;
  }

  public void setPlatformVinStatus(byte platformVinStatus) {
    this.platformVinStatus = platformVinStatus;
  }

  public String getPlatformVin() {
    return platformVin;
  }

  public void setPlatformVin(String platformVin) {
    this.platformVin = platformVin;
  }

  public byte getPlatformCodeStatus() {
    return platformCodeStatus;
  }

  public void setPlatformCodeStatus(byte platformCodeStatus) {
    this.platformCodeStatus = platformCodeStatus;
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
    buff.put(getMessageSerialNo());
    buff.put(getPlatformVinStatus());
    if (platformVinStatus == 0x01 && !StringUtils.empty(getPlatformVin())) {
      while (getPlatformVin().length() < 17) {
        platformVin = "0" + platformVin;
      }
      buff.put(platformVin.toUpperCase());
    } else {
      int flag = 0;
      while (flag < 17) {
        flag++;
        buff.put((byte) 0x00);
      }
    }

    buff.put(getPlatformCodeStatus());

    if (getPlatformCodeStatus() == 0x00) {
      buff.put((byte) 0x00);
      buff.put((byte) 0x00);
    } else {
      buff.put(getRechargeableSubsystemsTotalNumber());
      buff.put(getRechargeableSubsystemsLength());
      buff.put(getRechargeableSubsystemsCode().getBytes());
    }

    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] messageBodyBytes) {
    MyBuffer buff = new MyBuffer(messageBodyBytes);

    setMessageSerialNo(buff.getShort());
    setPlatformVinStatus(buff.get());
    if (getPlatformVinStatus() == 0x01) {
      byte[] vinBytes = buff.gets(17);
      setPlatformVin((new String(vinBytes)).trim().toUpperCase());
    }

    setPlatformCodeStatus(buff.get());
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
