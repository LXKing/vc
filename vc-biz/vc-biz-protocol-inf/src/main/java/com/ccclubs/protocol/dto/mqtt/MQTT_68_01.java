package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMessageBody;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/7/14.
 */
public class MQTT_68_01 implements IMessageBody {

  /**
   * Subfuc code 标识位
   */
  public byte subFucCode;
  /**
   * 车机id号
   */
  public String cfxId;
  /**
   * SIM卡号
   */
  private String simNo;
  /**
   * 经度，整数部分
   */
  private String vin;
  /**
   * 车型
   */
  private short model;
  /**
   * 硬件版本
   */
  private int hardWareVersion;
  /**
   * IAP版本
   */
  private int iapVersion;
  /**
   * APP版本
   */
  private int appVersion;

  /**
   * 终端当前时间
   */
  private int time;

  /**
   * 经度，整数部分
   */
  private short longitude;
  /**
   * 经度，小数部分
   */
  private int longitudeDecimal;
  /**
   * 纬度，整数部分
   */
  private short latitude;
  /**
   * 纬度，整数部分
   */
  private int latitudeDecimal;

  /**
   * 故障码 8 byte
   */
  private String errorCode;

  /**
   * 订单里程
   */
  private int miles;
  /**
   * 档位数据，0：停；1：启
   */
  private byte gear;

  public byte getSubFucCode() {
    return subFucCode;
  }

  public void setSubFucCode(byte subFucCode) {
    this.subFucCode = subFucCode;
  }

  public String getCfxId() {
    return cfxId;
  }

  public void setCfxId(String cfxId) {
    this.cfxId = cfxId;
  }

  public String getSimNo() {
    return simNo;
  }

  public void setSimNo(String simNo) {
    this.simNo = simNo;
  }

  public String getVin() {
    return vin;
  }

  public void setVin(String vin) {
    this.vin = vin;
  }

  public short getModel() {
    return model;
  }

  public void setModel(short model) {
    this.model = model;
  }

  public int getHardWareVersion() {
    return hardWareVersion;
  }

  public void setHardWareVersion(int hardWareVersion) {
    this.hardWareVersion = hardWareVersion;
  }

  public int getIapVersion() {
    return iapVersion;
  }

  public void setIapVersion(int iapVersion) {
    this.iapVersion = iapVersion;
  }

  public int getAppVersion() {
    return appVersion;
  }

  public void setAppVersion(int appVersion) {
    this.appVersion = appVersion;
  }

  public int getTime() {
    return time;
  }

  public void setTime(int time) {
    this.time = time;
  }

  public short getLongitude() {
    return longitude;
  }

  public void setLongitude(short longitude) {
    this.longitude = longitude;
  }

  public int getLongitudeDecimal() {
    return longitudeDecimal;
  }

  public void setLongitudeDecimal(int longitudeDecimal) {
    this.longitudeDecimal = longitudeDecimal;
  }

  public short getLatitude() {
    return latitude;
  }

  public void setLatitude(short latitude) {
    this.latitude = latitude;
  }

  public int getLatitudeDecimal() {
    return latitudeDecimal;
  }

  public void setLatitudeDecimal(int latitudeDecimal) {
    this.latitudeDecimal = latitudeDecimal;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public int getMiles() {
    return miles;
  }

  public void setMiles(int miles) {
    this.miles = miles;
  }

  public byte getGear() {
    return gear;
  }

  public void setGear(byte gear) {
    this.gear = gear;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getSubFucCode());
    buff.put(getCfxId().getBytes());
    for (int i = 0; i + getCfxId().getBytes().length < 16; i++) {
      buff.put((byte) 0x00);
    }
    buff.put(getSimNo().getBytes());
    for (int i = 0; i + getSimNo().getBytes().length < 16; i++) {
      buff.put((byte) 0x00);
    }
    buff.put(getVin().getBytes());
    for (int i = 0; i + getVin().getBytes().length < 24; i++) {
      buff.put((byte) 0x00);
    }

    buff.put(getModel());
    buff.put((short) getHardWareVersion());
    buff.put((short) getIapVersion());
    buff.put((short) getAppVersion());
    buff.put(getTime());

    buff.put(getLongitude());
    buff.put(getLongitudeDecimal());
    buff.put(getLongitude());
    buff.put(getLongitudeDecimal());

    buff.put(getErrorCode().getBytes());
    for (int i = 0; i + getErrorCode().getBytes().length < 8; i++) {
      buff.put((byte) 0x00);
    }
    buff.put(getMiles());
    buff.put(getGear());

    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] messageBodyBytes) {
    MyBuffer buff = new MyBuffer(messageBodyBytes);
    setSubFucCode(buff.get());
    byte[] cfxIdBytes = buff.gets(16);
    setCfxId((new String(cfxIdBytes)).trim().toUpperCase());

    byte[] simNoBytes = buff.gets(16);
    setSimNo((new String(simNoBytes)).trim().toUpperCase());

    byte[] vinBytes = buff.gets(24);
    setVin((new String(vinBytes)).trim().toUpperCase());

    setModel(buff.getShort());
    setHardWareVersion(buff.getShort());
    setIapVersion(buff.getShort());
    setAppVersion(buff.getShort());
    setTime(buff.getInt());

    setLongitude(buff.getShort());
    setLongitudeDecimal(buff.getInt());
    setLatitude(buff.getShort());
    setLatitudeDecimal(buff.getInt());

    byte[] errorBytes = buff.gets(8);
    setErrorCode((new String(errorBytes)).trim().toUpperCase());

    setMiles(buff.getInt());
    setGear(buff.get());
  }
}
