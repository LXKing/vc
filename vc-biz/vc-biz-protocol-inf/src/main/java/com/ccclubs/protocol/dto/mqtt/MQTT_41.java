package com.ccclubs.protocol.dto.mqtt;
import com.ccclubs.protocol.inf.IMessageBody;
import com.ccclubs.protocol.util.MyBuffer;
/**
 * Created by qsxiaogang on 2017/7/3.
 */
public class MQTT_41 implements IMessageBody {

  /**
   * RFID号
   */
  private String rfid;
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
   * 订单里程
   */
  private int miles;
  /**
   * 当前时间
   */
  private int time;
  /**
   * 燃油量
   */
  private short oil;
  /**
   * 蓄电池电量
   */
  private short battery;
  /**
   * 转速
   */
  private short rpm;
  /**
   * 车速
   */
  private byte speed;
  /**
   * 车辆租赁状态 ,0x00 初始状态，0x01 收到订单，
   */
  private byte carStatus;
  /**
   * 信号强度
   */
  private byte csq;
  /**
   * 车内温度
   */
  private byte temperature;
  /**
   * 报警类型，0x00：车门开 0x01：车速过高
   */
  private byte alarmType;

  public String getRfid() {
    return rfid;
  }

  public void setRfid(String rfid) {
    this.rfid = rfid;
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

  public int getMiles() {
    return miles;
  }

  public void setMiles(int miles) {
    this.miles = miles;
  }

  public int getTime() {
    return time;
  }

  public void setTime(int time) {
    this.time = time;
  }

  public short getOil() {
    return oil;
  }

  public void setOil(short oil) {
    this.oil = oil;
  }

  public short getBattery() {
    return battery;
  }

  public void setBattery(short battery) {
    this.battery = battery;
  }

  public short getRpm() {
    return rpm;
  }

  public void setRpm(short rpm) {
    this.rpm = rpm;
  }

  public byte getSpeed() {
    return speed;
  }

  public void setSpeed(byte speed) {
    this.speed = speed;
  }

  public byte getCarStatus() {
    return carStatus;
  }

  public void setCarStatus(byte carStatus) {
    this.carStatus = carStatus;
  }

  public byte getCsq() {
    return csq;
  }

  public void setCsq(byte csq) {
    this.csq = csq;
  }

  public byte getTemperature() {
    return temperature;
  }

  public void setTemperature(byte temperature) {
    this.temperature = temperature;
  }

  public byte getAlarmType() {
    return alarmType;
  }

  public void setAlarmType(byte alarmType) {
    this.alarmType = alarmType;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getRfid().getBytes());
    for (int i = 0; i + getRfid().getBytes().length < 8; i++) {
      buff.put(0x00);
    }
    buff.put(getLongitude());
    buff.put(getLongitudeDecimal());
    buff.put(getLongitude());
    buff.put(getLongitudeDecimal());
    buff.put(getMiles());
    buff.put(getTime());
    buff.put(getOil());
    buff.put(getBattery());
    buff.put(getRpm());
    buff.put(getSpeed());
    buff.put(getCarStatus());
    buff.put(getCsq());
    buff.put(getTemperature());
    buff.put(getAlarmType());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] messageBodyBytes) {
    MyBuffer buff = new MyBuffer(messageBodyBytes);
    byte[] rfidBytes = buff.gets(8);
    setRfid((new String(rfidBytes)).trim().toUpperCase());
    setLongitude(buff.getShort());
    setLongitudeDecimal(buff.getInt());
    setLatitude(buff.getShort());
    setLatitudeDecimal(buff.getInt());
    setMiles(buff.getInt());
    setTime(buff.getInt());
    setOil(buff.getShort());
    setBattery(buff.getShort());
    setRpm(buff.getShort());
    setSpeed(buff.get());
    setCarStatus(buff.get());
    setCsq(buff.get());
    setTemperature(buff.get());
    setAlarmType(buff.get());
  }
}
