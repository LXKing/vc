package com.ccclubs.protocol.dto.jt808;

import com.ccclubs.protocol.inf.IMessageBody;
import com.ccclubs.protocol.util.MyBuffer;
import com.ccclubs.protocol.util.StringUtils;

/**
 * 通领终端设置VIN码指令
 */
public class JT_81F4 implements IMessageBody {


  /**
   * 对应VIN码同步请求的消息流水号
   */
  private short messageSerialNo;
  /**
   * 平台VIN码状态
   * 0x00，平台没有VIN码，后面的VIN码可以没有，即使有，终端也忽略；
   * 0x01，平台有VIN码，后面有VIN码字段，如果为空字符串，终端清空内部的VIN码设置。
   */
  private byte platformVinStatus;
  /**
   * 国家规定的VIN码，ASCC字符
   * 如果收到的平台VIN码与平台
   */
  private String platformVin;

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
  }

}
