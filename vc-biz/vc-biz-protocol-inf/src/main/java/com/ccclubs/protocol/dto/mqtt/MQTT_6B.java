package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMessageBody;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * 车机重启数据上报
 * Created by qsxiaogang on 2017/6/24.
 */
public class MQTT_6B implements IMessageBody {

  private int subFucCode;
  /**
   * 车机序列号，16 byte
   */
  private String cfxId;
  /**
   * SIM卡号，16 byte
   */
  private String simNo;
  /**
   * VIN码，24 byte
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
   * 订阅主题，32 byte
   */
  private String subscribeTopic;

  /**
   * 超级手机号，16 byte
   */
  private String superSimNo;
  /**
   * 终端的功耗工作状态
   */
  private byte vehicleWorkingStatus;

  /**
   * 终端的休眠时间
   */
  private int sleepTime;
  /**
   * MEMS初始化数据
   */
  private byte mems;


  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();

    buff.put((byte) getSubFucCode());
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
    buff.put(getLatitude());
    buff.put(getLatitudeDecimal());
    buff.put(getSubscribeTopic().getBytes());
    for (int i = 0; i + getSubscribeTopic().getBytes().length < 32; i++) {
      buff.put((byte) 0x00);
    }
    buff.put(getSuperSimNo().getBytes());
    for (int i = 0; i + getSuperSimNo().getBytes().length < 16; i++) {
      buff.put((byte) 0x00);
    }
    buff.put(getVehicleWorkingStatus());
    buff.put((byte) getSleepTime());
    buff.put(getMems());

    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] messageBodyBytes) {
    MyBuffer buff = new MyBuffer(messageBodyBytes);
    setSubFucCode(buff.get());
    byte[] cfxIdBytes = buff.gets(16);
    setCfxId((new String(cfxIdBytes)).trim().toUpperCase());
    byte[] simNoBytes = buff.gets(16);
    setSimNo((new String(simNoBytes)).trim());
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
    byte[] subscribeTopicBytes = buff.gets(32);
    setSubscribeTopic((new String(subscribeTopicBytes)).trim());
    byte[] superSimNoBytes = buff.gets(16);
    setSuperSimNo((new String(superSimNoBytes)).trim());
    setVehicleWorkingStatus(buff.get());
    setSleepTime(buff.get());
    setMems(buff.get());
  }

  public int getSubFucCode() {
    return subFucCode & 0xFF;
  }

  public void setSubFucCode(int subFucCode) {
    this.subFucCode = subFucCode;
  }

  public String getCfxId() {
    return cfxId.trim();
  }

  public void setCfxId(String cfxId) {
    this.cfxId = cfxId;
  }

  public String getSimNo() {
    return simNo.trim();
  }

  public void setSimNo(String simNo) {
    this.simNo = simNo;
  }

  public String getVin() {
    return vin.trim();
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
    return hardWareVersion & 0xFFFF;
  }

  public void setHardWareVersion(int hardWareVersion) {
    this.hardWareVersion = hardWareVersion;
  }

  public int getIapVersion() {
    return iapVersion & 0xFFFF;
  }

  public void setIapVersion(int iapVersion) {
    this.iapVersion = iapVersion;
  }

  public int getAppVersion() {
    return appVersion & 0xFFFF;
  }

  public void setAppVersion(int appVersion) {
    this.appVersion = appVersion;
  }

  public int getTime() {
    return time & 0xFFFFFFFF;
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

  public String getSubscribeTopic() {
    return subscribeTopic.trim();
  }

  public void setSubscribeTopic(String subscribeTopic) {
    this.subscribeTopic = subscribeTopic;
  }

  public String getSuperSimNo() {
    return superSimNo.trim();
  }

  public void setSuperSimNo(String superSimNo) {
    this.superSimNo = superSimNo;
  }

  public byte getVehicleWorkingStatus() {
    return vehicleWorkingStatus;
  }

  public void setVehicleWorkingStatus(byte vehicleWorkingStatus) {
    this.vehicleWorkingStatus = vehicleWorkingStatus;
  }

  public int getSleepTime() {
    return sleepTime & 0xFFFFFFFF;
  }

  public void setSleepTime(int sleepTime) {
    this.sleepTime = sleepTime;
  }

  public byte getMems() {
    return mems;
  }

  public void setMems(byte mems) {
    this.mems = mems;
  }
}
