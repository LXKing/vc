package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17.
 * GPS数据，终端信息
 */
public class MachineAdditional_GpsStatus implements IMachineAdditionalItem {

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
    return longitude & 0xFFFF;
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
    return latitude & 0xFFFF;
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
    return 12;
  }

  public void setAdditionalLength(byte additionalLength) {
    this.additionalLength = additionalLength;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((short) getLongitude());
    buff.put(getLongitudeDecimal());
    buff.put((short) getLatitude());
    buff.put(getLatitudeDecimal());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setLongitude(buff.getShort());
    setLongitudeDecimal(buff.getInt());
    setLatitude(buff.getShort());
    setLatitudeDecimal(buff.getInt());
  }
}
