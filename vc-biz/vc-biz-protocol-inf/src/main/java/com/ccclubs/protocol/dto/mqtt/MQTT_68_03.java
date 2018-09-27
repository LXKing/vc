package com.ccclubs.protocol.dto.mqtt;

import com.alibaba.fastjson.JSON;
import com.ccclubs.protocol.inf.IMessageBody;
import com.ccclubs.protocol.util.AccurateOperationUtils;
import com.ccclubs.protocol.util.MyBuffer;
import com.ccclubs.protocol.util.ProtocolTools;
import com.ccclubs.protocol.util.Tools;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 新版本状态数据0x68，协议版本0x03
 *
 * Created by qsxiaogang on 2017-09-24
 */
public class MQTT_68_03 implements IMessageBody {

  // 预留部分总长度：34
  private static int BASE_LENGTH_RESERVED = 34;
  // 基础部分总长度：100 - 17 = 83
  private static int BASE_LENGTH_TOTAL = 100 - MqMessage.MESSAGE_MIN_LENGTH;

  /**
   * Subfuc code 标识位 0x03
   */
  public byte subFucCode;
  /**
   * 车型
   */
  private short model;
  /**
   * 终端当前时间
   */
  private int time;

  /**
   * 发动机状态 0:无效 1:START 2:STOP 3:ACC
   */
  private byte engineStatus;
  /**
   * 1插入，2拔出，0无效
   */
  private byte keyStatus;

  /**
   * =0000   空挡 =0001   1挡 =0010   2挡 =0011   3挡 =0100   4挡 =0101   5挡 =0110   6挡 =…… =1101   倒挡
   * =1110   自动D挡 =1111   停车P挡
   */
  private byte gearStatus;
  /**
   * 经度，以度为单位的经度值乘以10的6次方，精确到百万分之一度
   */
  private int longitude;
  /**
   * 纬度，以度为单位的经度值乘以10的6次方，精确到百万分之一度
   */
  private int latitude;
  /**
   * 车辆累计里程，单位0.1公里
   */
  private int obdMile;
  /**
   * GPS航向，0-359，正北为 0，顺时针
   */
  private short heading;
  /**
   * GPS信号强度
   */
  private byte cn;
  /**
   * 可视卫星数量
   */
  private byte satelliteCount;
  /**
   * GPS定位是否有效
   */
  private byte gpsValid;
  /**
   * 转速
   */
  private short rpm;

  /**
   * 车速，单位0.1km/h
   */
  private short speed;

  /**
   * 信号强度
   */
  private byte csq;
  /**
   * 车机温度
   */
  private byte terminalTemperature;
  /**
   * 水箱温度，汽油车为水箱温度，电动车为动力电池温度
   */
  private byte tankTemperature;

  /**
   * 车机的功耗的工作状态
   */
  private byte vehicleWorkingStatus;
  /**
   * 车机的休眠时间
   */
  private short vehicleSleepTime;

  /**
   * 蓄电池（小电瓶）电量，单位10mV
   */
  private short battery;
  /**
   * 门开合状态，带mask
   */
  private short doorStatusWithMask;
  /**
   * 门闭锁状态，带mask
   */
  private short doorLockStatusWithMask;
  /**
   * 灯状态，带mask
   */
  private int lightStatusWithMask;
  /**
   * 控制状态
   */
  private short controlStatusWithMask;
  /**
   * 预留，30个bytes
   */
  private String reservedBytes;
  /**
   * 车机属性
   */
  private CCCLUBS_60 ccclubs_60;

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    //FIXME:未完成 WriteToBytes 方法
    buff.put(getSubFucCode());

    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] messageBodyBytes) {
    MyBuffer buff = new MyBuffer(messageBodyBytes);
    setSubFucCode(buff.get());
    setModel(buff.getShort());
    setTime(buff.getInt());
    setEngineStatus(buff.get());
    setKeyStatus(buff.get());
    setGearStatus(buff.get());
    setLongitude(buff.getInt());
    setLatitude(buff.getInt());
    setObdMile(buff.getInt());
    setHeading(buff.getShort());
    setCn(buff.get());
    setSatelliteCount(buff.get());
    setGpsValid(buff.get());
    setRpm(buff.getShort());
    setSpeed(buff.getShort());
    setCsq(buff.get());
    setTerminalTemperature(buff.get());
    setTankTemperature(buff.get());
    setVehicleWorkingStatus(buff.get());
    setVehicleSleepTime(buff.getShort());
    setBattery(buff.getShort());
    setDoorStatusWithMask(buff.getShort());
    setDoorLockStatusWithMask(buff.getShort());
    setLightStatusWithMask(buff.getInt());
    setControlStatusWithMask(buff.getShort());
    setReservedBytes(Tools.ToHexString(buff.gets(BASE_LENGTH_RESERVED)));
    CCCLUBS_60 ccclubs_60 = new CCCLUBS_60();
    ccclubs_60.ReadFromBytes(buff.gets(messageBodyBytes.length - BASE_LENGTH_TOTAL));
    setCcclubs_60(ccclubs_60);
  }

  /*public static void main(String[] args) {
    String hexString = "54363739353232310000000000002CF006031404233F7B2BCA020000CC020000CE0400000000D002030167010268010069010071080729C04C01CC9FA1720657B9000036417404000000007601009901009A04000000036F0200009C10000000000000000000000000000000006C01008801009B180729C04C01CC9FA10729C04C01CC9FA10729C04C01CC9FA1";
    MqMessage mqMessage = new MqMessage();
    mqMessage.ReadFromBytes(Tools.HexString2Bytes(hexString));
    CCCLUBS_60 ccclubs_60 = new CCCLUBS_60();
    ccclubs_60.ReadFromBytes(mqMessage.getMsgBody());
    //System.out.println(JSON.toJSONString(ccclubs_60));
    MQTT_68_03 mqtt_68_03 = new MQTT_68_03();
    mqtt_68_03.ReadFromBytes(mqMessage.getMsgBody());
    CCCLUBS_60 ccclubs_60_ = new CCCLUBS_60();
    String hexString_ ="031404233EE1D5CA027E00CC020000CE0401FE0000D0020302670101680102690101710806FD613201E724627206D5D608065533740400003DA47601076C01008801009B1806FD613101E7246206FD613201E7246206FD613101E72462";
    ccclubs_60_.ReadFromBytes(Tools.HexString2Bytes(hexString_));
    System.out.println(JSON.toJSONString(ccclubs_60_));
  }*/

  public byte getSubFucCode() {
    return subFucCode;
  }

  public void setSubFucCode(byte subFucCode) {
    this.subFucCode = subFucCode;
  }

  public short getModel() {
    return model;
  }

  public void setModel(short model) {
    this.model = model;
  }

  public long getTime() {
    return ProtocolTools.transformToServerTime(time);
  }

  public void setTime(int time) {
    this.time = time;
  }

  public int getEngineStatus() {
    return engineStatus < 0 ? 0 : (int) engineStatus;
  }

  public void setEngineStatus(byte engineStatus) {
    this.engineStatus = engineStatus;
  }

  public int getKeyStatus() {
    return keyStatus < 0 ? 0 : (int) keyStatus;
  }

  public void setKeyStatus(byte keyStatus) {
    this.keyStatus = keyStatus;
  }

  public int getGearStatus() {
    return gearStatus < 0 ? 0 : (int) gearStatus;
  }

  public void setGearStatus(byte gearStatus) {
    this.gearStatus = gearStatus;
  }

  public int getLongitude() {
    return longitude;
  }

  public void setLongitude(int longitude) {
    this.longitude = longitude;
  }

  public int getLatitude() {
    return latitude;
  }

  public void setLatitude(int latitude) {
    this.latitude = latitude;
  }

  public BigDecimal getObdMile() {
    return AccurateOperationUtils.mul(this.obdMile,0.1).setScale(1, RoundingMode.HALF_UP);
  }

  public void setObdMile(int obdMile) {
    this.obdMile = obdMile;
  }

  public int getHeading() {
    return heading < 0 ? 0 : (int) heading;
  }

  public void setHeading(short heading) {
    this.heading = heading;
  }

  public int getCn() {
    return cn < 0 ? 0 : (int) cn;
  }

  public void setCn(byte cn) {
    this.cn = cn;
  }

  public int getSatelliteCount() {
    return satelliteCount & 0xFF;
  }

  public void setSatelliteCount(byte satelliteCount) {
    this.satelliteCount = satelliteCount;
  }

  public int getGpsValid() {
    return gpsValid < 0 ? 0 : (int) gpsValid;
  }

  public void setGpsValid(byte gpsValid) {
    this.gpsValid = gpsValid;
  }

  public int getRpm() {
    return rpm < 0 ? 0 : (int) rpm;
  }

  public void setRpm(short rpm) {
    this.rpm = rpm;
  }

  public BigDecimal getSpeed() {
    return AccurateOperationUtils.mul(this.speed,0.1).setScale(1,RoundingMode.HALF_UP);
  }

  public void setSpeed(short speed) {
    this.speed = (speed);
  }

  public int getCsq() {
    return csq & 0xFF;
  }

  public void setCsq(byte csq) {
    this.csq = csq;
  }

  public int getTerminalTemperature() {
    return (terminalTemperature & 0xFF) - 40;
  }

  public void setTerminalTemperature(byte terminalTemperature) {
    this.terminalTemperature = terminalTemperature;
  }

  public int getTankTemperature() {
    return (tankTemperature & 0xFF) - 40;
  }

  public void setTankTemperature(byte tankTemperature) {
    this.tankTemperature = tankTemperature;
  }

  public int getVehicleWorkingStatus() {
    return vehicleWorkingStatus & 0xFF;
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

  public int getBattery() {
    return battery < 0 ? 0 : (int) battery;
  }

  public void setBattery(short battery) {
    this.battery = battery;
  }

  public int getDoorStatusWithMask() {
    return doorStatusWithMask & 0xFFFF;
  }

  public void setDoorStatusWithMask(short doorStatusWithMask) {
    this.doorStatusWithMask = doorStatusWithMask;
  }

  public int getDoorLockStatusWithMask() {
    return doorLockStatusWithMask & 0xFFFF;
  }

  public void setDoorLockStatusWithMask(short doorLockStatusWithMask) {
    this.doorLockStatusWithMask = doorLockStatusWithMask;
  }

  public int getLightStatusWithMask() {
    return lightStatusWithMask;
  }

  public void setLightStatusWithMask(int lightStatusWithMask) {
    this.lightStatusWithMask = lightStatusWithMask;
  }

  public short getControlStatusWithMask() {
    return controlStatusWithMask;
  }

  public void setControlStatusWithMask(short controlStatusWithMask) {
    this.controlStatusWithMask = controlStatusWithMask;
  }

  public String getReservedBytes() {
    return reservedBytes;
  }

  public void setReservedBytes(String reservedBytes) {
    this.reservedBytes = reservedBytes;
  }

  public CCCLUBS_60 getCcclubs_60() {
    return ccclubs_60;
  }

  public void setCcclubs_60(CCCLUBS_60 ccclubs_60) {
    this.ccclubs_60 = ccclubs_60;
  }

}
