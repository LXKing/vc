package com.ccclubs.protocol.dto.gb;


import com.ccclubs.protocol.util.MyBuffer;

public class GBMessageHeader {

  /**
   * 命令标识，1个字节，无符号8位
   */
  private int messageType;

  /**
   * 命令标识</br> 0x01:注册信息(上报),0x02:实时信息上报(上报),0x03:补发信息数据(上报),0x04:车辆登出(上报),0x05:平台登入(上报),0x06:平台登出(上报),0x07～0x08:终端数据预留
   * 上行,0x09～0x7F:上行数据系统预留 上行,0x80～0x82:终端数据预留 下行,0x83～0xBF:下行数据系统预留 下行,0xC0～0xFE:平台交换自定义数据 自定义
   * </p>
   */
  public final int getMessageType() {
    return messageType & 0xFF;
  }

  public final void setMessageType(int value) {
    messageType = value;
  }

  /**
   * 应答标志，1个字节，无符号8位
   */
  private int ackType;

  /**
   * 应答标志</br> 0x01:成功(接收到的信息正确),0x02:错误(设置未成功),0x03:VIN重复(VIN重复错误),0xFE:命令(表示数据包为命令包，而非应答包)
   */
  public int getAckType() {
    return ackType & 0xFF;
  }

  public void setAckType(int ackType) {
    this.ackType = ackType;
  }

  /**
   * 唯一识别码 VIN码
   */
  private String vin;

  /**
   * 唯一识别码 VIN码
   */
  public String getVin() {
    return vin;
  }

  public void setVin(String vin) {
    this.vin = vin;
  }

  /**
   * 数据加密方式
   */
  private int encodeType;

  /**
   * 0x01：数据不加密；0x02：数据经过RSA算法加密；0x03:数据经过AES128位算法加密；“0xFE”表示异常，“0xFF”表示无效，其他预留。
   */
  public int getEncodeType() {
    return encodeType & 0xFF;
  }

  public void setEncodeType(int encodeType) {
    this.encodeType = encodeType;
  }

  /**
   * 数据单元长度
   */
  private int messageSize;

  public int getMessageSize() {
    return messageSize;
  }

  public void setMessageSize(int messageSize) {
    this.messageSize = messageSize;
  }

  public static final int getHeaderSize() {
    return 1 + 1 + 17 + 1 + 2; // 命令标识，应答标志，VIN码，加密方式，数据单元长度
  }

  public final byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((byte) getMessageType());
    buff.put((byte) getAckType());
    while (vin.length() < 17) {
      vin = "0" + vin;
    }
    buff.put((new String(vin)).toUpperCase());
    buff.put((byte) getEncodeType());
    buff.putShort((short) getMessageSize());

    return buff.array();

  }

  public final void ReadFromBytes(byte[] headerBytes) {
    MyBuffer buff = new MyBuffer(headerBytes);
    setMessageType(buff.get());
    setAckType(buff.get());
    byte[] vinBytes = buff.gets(17);
    setVin((new String(vinBytes)).trim().toUpperCase());
    setEncodeType(buff.get());
    setMessageSize(buff.getShort());
  }

}