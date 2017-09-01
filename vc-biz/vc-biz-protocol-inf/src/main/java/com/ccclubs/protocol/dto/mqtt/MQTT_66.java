package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMessageBody;
import com.ccclubs.protocol.util.MyBuffer;
import com.ccclubs.protocol.util.ProtocolTools;

/**
 * 状态数据
 * Created by qsxiaogang on 2017/7/2.
 */
public class MQTT_66 implements IMessageBody {

  //纯电模式
  public static int MODEL_STATUS_ELECTRICITY = 0x66;
  //纯油模式
  public static int MODEL_STATUS_OIL = 0x41;

  public static final int TYPE_00_LENGTH = 72 - 17;
  public static final int TYPE_01_LENGTH = 102 - 17;
  public static final int TYPE_02_LENGTH = 109 - 17;

  /**
   * Subfuc code 标识位 0x00,0x01,0x02
   * 多个状态数据版本
   */
  private byte subFucCode = 0x00;
  /**
   * RFID号
   */
  private String rfid;
  /**
   * 读取的RFID号
   */
  private String rfidDte;
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
  // ===================================
  /**
   * GPS速度，整数部分
   */
  private short gpsSpeed;
  /**
   * GPS速度，小数部分
   */
  private short gpsSpeedDecimal;
  /**
   * 海拔，整数部分
   */
  private short altitude;
  /**
   * 海拔，小数部分
   */
  private short altitudeDecimal;
  /**
   * 航向角，整数部分
   */
  private short heading;
  /**
   * 航向角，小数部分
   */
  private short headingDecimal;
  /**
   * CN值
   */
  private byte cn;
  /**
   * 可视卫星数量
   */
  private byte satelliteCount;
  /**
   * 卫星有效数位
   */
  private byte satelliteEffective;

  // ===================================
  /**
   * 订单里程
   */
  private int miles;
  /**
   * 车辆OBD里程
   */
  private int obdMiles;
  /**
   * 当前时间
   */
  private int time;
  /**
   * 续航里程
   */
  private short endurance;

  /**
   * 动力电池电量
   */
  private byte soc;
  /**
   * 是否在充电
   */
  private byte charging;

  /**
   * 蓄电池电量
   */
  private short battery;
  /**
   * 转速
   */
  private short rpm;
  // =======================================
  /**
   * 订单开始时间
   */
  private short orderStartTime;
  /**
   * 订单结束时间
   */
  private short orderEndTime;
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
   * 发动机温度
   */
  private byte engineTemperature;
  /**
   * GPS有效性
   */
  private short gpsValid;
  /**
   * 车辆开关门状态
   */
  private byte doorStatus;
  /**
   * 车辆状态(外部部件开关状态1+外部部件开关状态2)
   */
  private short vehicleStatus;
  /**
   * 车机的功耗的工作状态
   */
  private byte vehicleWorkingStatus;
  /**
   * 车机的休眠时间
   */
  private short vehicleSleepTime;
  /**
   * 空调状态
   */
  private byte airConditionerStatus;
  /**
   * 车辆启动状态 （bit0-bit3,0静止，1ACC，2ON，档位杆信息：bit4-bit7）
   */
  private byte vehicleStartStatus;
  /**
   * 报警类型，0x00：车门开 0x01：车速过高
   */
  private short alarmType;
  /**
   * 网络类型,0-GSM，1-3G/4G,2-CDMA
   */
  private byte netType;

  /**
   * 基站LAC
   */
  private short baseLAC;

  /**
   * 基站CI
   */
  private int baseCI;

  public byte getSubFucCode() {
    return subFucCode;
  }

  public void setSubFucCode(byte subFucCode) {
    this.subFucCode = subFucCode;
  }

  public String getRfid() {
    return rfid.trim();
  }

  public void setRfid(String rfid) {
    this.rfid = rfid;
  }

  public String getRfidDte() {
    return rfidDte.trim();
  }

  public void setRfidDte(String rfidDte) {
    this.rfidDte = rfidDte;
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

  public short getGpsSpeed() {
    return gpsSpeed;
  }

  public void setGpsSpeed(short gpsSpeed) {
    this.gpsSpeed = gpsSpeed;
  }

  public short getGpsSpeedDecimal() {
    return gpsSpeedDecimal;
  }

  public void setGpsSpeedDecimal(short gpsSpeedDecimal) {
    this.gpsSpeedDecimal = gpsSpeedDecimal;
  }

  public short getAltitude() {
    return altitude;
  }

  public void setAltitude(short altitude) {
    this.altitude = altitude;
  }

  public short getAltitudeDecimal() {
    return altitudeDecimal;
  }

  public void setAltitudeDecimal(short altitudeDecimal) {
    this.altitudeDecimal = altitudeDecimal;
  }

  public short getHeading() {
    return heading;
  }

  public void setHeading(short heading) {
    this.heading = heading;
  }

  public short getHeadingDecimal() {
    return headingDecimal;
  }

  public void setHeadingDecimal(short headingDecimal) {
    this.headingDecimal = headingDecimal;
  }

  public byte getCn() {
    return cn;
  }

  public void setCn(byte cn) {
    this.cn = cn;
  }

  public byte getSatelliteCount() {
    return satelliteCount;
  }

  public void setSatelliteCount(byte satelliteCount) {
    this.satelliteCount = satelliteCount;
  }

  public byte getSatelliteEffective() {
    return satelliteEffective;
  }

  public void setSatelliteEffective(byte satelliteEffective) {
    this.satelliteEffective = satelliteEffective;
  }

  public int getMiles() {
    return miles;
  }

  public void setMiles(int miles) {
    this.miles = miles;
  }

  public int getObdMiles() {
    return obdMiles;
  }

  public void setObdMiles(int obdMiles) {
    this.obdMiles = obdMiles;
  }

  public Long getTime() {
    return ProtocolTools.transformToServerTime(time);
  }

  public void setTime(int time) {
    this.time = time;
  }

  public short getEndurance() {
    return endurance;
  }

  public void setEndurance(short endurance) {
    this.endurance = endurance;
  }

  public byte getSoc() {
    return soc > 100 ? 100 : soc;
  }

  public void setSoc(byte soc) {
    this.soc = soc;
  }

  public byte getCharging() {
    return charging;
  }

  public void setCharging(byte charging) {
    this.charging = charging;
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

  public int getOrderStartTime() {
    return orderStartTime;
  }

  public void setOrderStartTime(short orderStartTime) {
    this.orderStartTime = orderStartTime;
  }

  public int getOrderEndTime() {
    return orderEndTime;
  }

  public void setOrderEndTime(short orderEndTime) {
    this.orderEndTime = orderEndTime;
  }

  public int getSpeed() {
    return speed & 0xFF;
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

  public byte getEngineTemperature() {
    return engineTemperature;
  }

  public void setEngineTemperature(byte engineTemperature) {
    this.engineTemperature = engineTemperature;
  }

  public short getGpsValid() {
    return gpsValid;
  }

  public void setGpsValid(short gpsValid) {
    this.gpsValid = gpsValid;
  }

  public int getDoorStatus() {
    return ProtocolTools.getTransformDoorStatus(doorStatus);
  }

  public void setDoorStatus(byte doorStatus) {
    this.doorStatus = doorStatus;
  }

  public short getVehicleStatus() {
    return vehicleStatus;
  }

  public void setVehicleStatus(short vehicleStatus) {
    this.vehicleStatus = vehicleStatus;
  }

  /**
   * 转换前：旧协议：（bit0-bit3,0静止，1ACC，2ON，档位杆信息：bit4-bit7）
   * 转换后：新协议：1未熄火，2已熄火，0无效
   */
  public int getEngineStatus() {
    if ((this.vehicleStartStatus & 0xF) == 0x01 || (this.vehicleStartStatus & 0xF) == 0x02) {
      return MachineAdditional_EngineStatus.ENGINE_STATUS_ON;
    }
    return MachineAdditional_EngineStatus.ENGINE_STATUS_OFF;
  }

  /**
   * 转换前：旧协议：车辆启动状态1 byte（bit0-bit3,0静止，1ACC，2ON，档位杆信息：bit4-bit7）
   * 0x0：无效
   * 0x1：P
   * 0x2：N
   * 0x3：D
   * 0x4：R
   */
  public int getGear() {
    int result = MachineAdditional_GearStatus.GEAR_STATUS_N;
    switch (this.vehicleStatus >> 4) {
      case 1:
        result = MachineAdditional_GearStatus.GEAR_STATUS_P;
        break;
      case 3:
        result = MachineAdditional_GearStatus.GEAR_STATUS_D;
        break;
      case 4:
        result = MachineAdditional_GearStatus.GEAR_STATUS_R;
        break;
      default:
        break;
    }
    return result;
  }

  /**
   * 转换前：旧协议：Bit3-Bit4	钥匙拔出状态：0-拔出，1-未拔出，2-未知
   * 转换后：新协议：1插入，2拔出，0无效
   */
  public int getKeyStatus() {
    if ((this.vehicleStatus & 0x1800) == 0x0) {
      return MachineAdditional_KeyStatus.KEY_STATUS_OUT;
    } else if ((this.vehicleStatus & 0x1800) == 0x800) {
      return MachineAdditional_KeyStatus.KEY_STATUS_IN;
    } else {
      return MachineAdditional_KeyStatus.KEY_STATUS_UNKNOW;
    }
  }

  public int getSavingModel() {
    return (this.vehicleWorkingStatus >> 2) & 0x03;
  }

  public byte getVehicleWorkingStatus() {
    return vehicleWorkingStatus;
  }

  public void setVehicleWorkingStatus(byte vehicleWorkingStatus) {
    this.vehicleWorkingStatus = vehicleWorkingStatus;
  }

  public short getVehicleSleepTime() {
    return vehicleSleepTime;
  }

  public void setVehicleSleepTime(short vehicleSleepTime) {
    this.vehicleSleepTime = vehicleSleepTime;
  }

  public byte getAirConditionerStatus() {
    return airConditionerStatus;
  }

  public int getAirConditionerCircular() {
    return airConditionerStatus & 0x01;
  }

  public int getAirConditionerPtc() {
    return (airConditionerStatus >> 1) & 0x01;
  }

  public int getAirConditionerCompres() {
    return (airConditionerStatus >> 2) & 0x01;
  }

  /**
   * 0x0：OFF
   * 0x1：1档风量
   * 0x2：2档风量
   * 0x3：3档风量
   * 0x4：4档风量
   */
  public int getAirConditionerFan() {
    return (airConditionerStatus >> 3) & 0x07;
  }

  public void setAirConditionerStatus(byte airConditionerStatus) {
    this.airConditionerStatus = airConditionerStatus;
  }

  public byte getVehicleStartStatus() {
    return vehicleStartStatus;
  }

  public void setVehicleStartStatus(byte vehicleStartStatus) {
    this.vehicleStartStatus = vehicleStartStatus;
  }

  public short getAlarmType() {
    return alarmType;
  }

  public void setAlarmType(short alarmType) {
    this.alarmType = alarmType;
  }

  public byte getNetType() {
    return netType;
  }

  public void setNetType(byte netType) {
    this.netType = netType;
  }

  public int getBaseLAC() {
    return baseLAC & 0xFFFF;
  }

  public void setBaseLAC(short baseLAC) {
    this.baseLAC = baseLAC;
  }

  public int getBaseCI() {
    return baseCI;
  }

  public void setBaseCI(int baseCI) {
    this.baseCI = baseCI;
  }

  @Override
  public byte[] WriteToBytes() {

    MyBuffer buff = new MyBuffer();
    // 小计 长度：17
    buff.put(getSubFucCode());
    buff.put(getRfid().getBytes());
    for (int i = 0; i + getRfid().getBytes().length < 8; i++) {
      buff.put(0x00);
    }
    buff.put(getRfidDte().getBytes());
    for (int i = 0; i + getRfidDte().getBytes().length < 8; i++) {
      buff.put(0x00);
    }
    // 小计 长度：12
    buff.put(getLongitude());
    buff.put(getLongitudeDecimal());
    buff.put(getLongitude());
    buff.put(getLongitudeDecimal());

    // 小计 长度：15
    if (getSubFucCode() > 0x00) {
      buff.put(getGpsSpeed());
      buff.put(getGpsSpeedDecimal());
      buff.put(getAltitude());
      buff.put(getAltitudeDecimal());
      buff.put(getHeading());
      buff.put(getHeadingDecimal());
      buff.put(getCn());
      buff.put(getSatelliteCount());
      buff.put(getSatelliteEffective());
    }

// 小计 长度：20
    buff.put(getMiles());
    buff.put(getObdMiles());
    buff.put(getTime());
    buff.put(getEndurance());
    buff.put(getSoc());
    buff.put(getCharging());
    buff.put(getBattery());
    buff.put(getRpm());
// 小计 长度：21
    if (getSubFucCode() > 0x00) {
      buff.put(getOrderStartTime());
      buff.put(getOrderEndTime());
    }

    buff.put(getSpeed());
    buff.put(getCarStatus());
    buff.put(getCsq());
    buff.put(getTemperature());
    buff.put(getEngineTemperature());

    if (getSubFucCode() > 0x00) {
      buff.put(getGpsValid());
      buff.put(getDoorStatus());
      buff.put(getVehicleStatus());
      buff.put(getVehicleWorkingStatus());
      buff.put(getVehicleSleepTime());
      buff.put(getAirConditionerStatus());
      buff.put(getVehicleStartStatus());
      buff.put(getAlarmType());
    } else {
      buff.put((byte) getAlarmType());
    }

    if (getSubFucCode() > 0x01) {
      // 小计 长度：7
      buff.put(getNetType());
      buff.put((short) getBaseLAC());
      buff.put(getBaseCI());
    }
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] messageBodyBytes) {
    MyBuffer buff = new MyBuffer(messageBodyBytes);
    // 小计 长度：17
    setSubFucCode(buff.get());
    // 校正subCode
    switch (messageBodyBytes.length) {
      case TYPE_00_LENGTH:
        setSubFucCode((byte) 0);
        break;
      case TYPE_01_LENGTH:
        setSubFucCode((byte) 1);
        break;
      case TYPE_02_LENGTH:
        setSubFucCode((byte) 2);
        break;
    }

    byte[] rfidBytes = buff.gets(8);
    setRfid((new String(rfidBytes)).trim().toUpperCase());
    byte[] rfidDteBytes = buff.gets(8);
    setRfidDte((new String(rfidDteBytes)).trim().toUpperCase());

    // 小计 长度：12
    setLongitude(buff.getShort());
    setLongitudeDecimal(buff.getInt());
    setLatitude(buff.getShort());
    setLatitudeDecimal(buff.getInt());

    // 小计 长度：15
    if (getSubFucCode() > 0x00) {
      setGpsSpeed(buff.getShort());
      setGpsSpeedDecimal(buff.getShort());
      setAltitude(buff.getShort());
      setAltitudeDecimal(buff.getShort());
      setHeading(buff.getShort());
      setHeadingDecimal(buff.getShort());
      setCn(buff.get());
      setSatelliteCount(buff.get());
      setSatelliteEffective(buff.get());
    }

// 小计 长度：20
    setMiles(buff.getInt());
    setObdMiles(buff.getInt());
    setTime(buff.getInt());
    setEndurance(buff.getShort());
    setSoc(buff.get());
    setCharging(buff.get());
    setBattery(buff.getShort());
    setRpm(buff.getShort());

    // 小计 长度：4
    if (getSubFucCode() > 0x00) {
      setOrderStartTime(buff.getShort());
      setOrderEndTime(buff.getShort());
    }

    // 小计 长度：5
    setSpeed(buff.get());
    setCarStatus(buff.get());
    setCsq(buff.get());
    setTemperature(buff.get());
    setEngineTemperature(buff.get());

    // 小计 长度：12
    if (getSubFucCode() > 0x00) {
      setGpsValid(buff.getShort());
      setDoorStatus(buff.get());
      setVehicleStatus(buff.getShort());
      setVehicleWorkingStatus(buff.get());
      setVehicleSleepTime(buff.getShort());
      setAirConditionerStatus(buff.get());
      setVehicleStartStatus(buff.get());
      setAlarmType(buff.getShort());
    } else {
      setAlarmType(buff.get());
    }

    if (getSubFucCode() > 0x01) {
      // 小计 长度：7
      setNetType(buff.get());
      setBaseLAC(buff.getShort());
      setBaseCI(buff.getInt());
    }
  }
}
