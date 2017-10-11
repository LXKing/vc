package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17. GPS数据，终端信息
 */
public class MachineAdditional_GpsStatus implements IMachineAdditionalItem {

  // 协议版本2时，长度为12
  private static int SUBCODE_02_LENGTH = 12;
  // 协议版本3时，长度为8
  private static int SUBCODE_03_LENGTH = 8;

  private byte additionalLength;
  /**
   * 经度，整数部分
   */
  private int longitude;
  /**
   * 经度，小数部分
   */
  private int longitudeDecimal;
  /**
   * 纬度，整数部分
   */
  private int latitude;
  /**
   * 纬度，整数部分
   */
  private int latitudeDecimal;

  public int getLongitude() {
    return longitude;
  }

  public void setLongitude(int longitude) {
    this.longitude = longitude;
  }

  public int getLongitudeDecimal() {
    return longitudeDecimal;
  }

  public void setLongitudeDecimal(int longitudeDecimal) {
    this.longitudeDecimal = longitudeDecimal;
  }

  public int getLatitude() {
    return latitude;
  }

  public void setLatitude(int latitude) {
    this.latitude = latitude;
  }

  public int getLatitudeDecimal() {
    return latitudeDecimal;
  }

  public void setLatitudeDecimal(int latitudeDecimal) {
    this.latitudeDecimal = latitudeDecimal;
  }

  @Override
  public byte getAdditionalId() {
    return 113;
  }

  @Override
  public byte getAdditionalLength() {
    return this.additionalLength;
  }

  public void setAdditionalLength(byte additionalLength) {
    this.additionalLength = additionalLength;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    if (SUBCODE_03_LENGTH == getAdditionalLength()) {
      buff.put(getLongitude());
      buff.put(getLatitude());
    } else {
      buff.put((short) getLongitude());
      buff.put(getLongitudeDecimal());
      buff.put((short) getLatitude());
      buff.put(getLatitudeDecimal());
    }
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    if (SUBCODE_03_LENGTH == getAdditionalLength()) {
      setLongitude(buff.getInt());
      setLatitude(buff.getInt());
    } else {
      setLongitude(buff.getShort());
      setLongitudeDecimal(buff.getInt());
      setLatitude(buff.getShort());
      setLatitudeDecimal(buff.getInt());
    }

  }
}
