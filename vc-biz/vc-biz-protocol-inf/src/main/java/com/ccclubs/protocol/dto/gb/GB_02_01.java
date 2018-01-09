package com.ccclubs.protocol.dto.gb;
import com.ccclubs.protocol.inf.IRealTimeAdditionalItem;
import com.ccclubs.protocol.util.AccurateOperationUtils;
import com.ccclubs.protocol.util.MyBuffer;
import java.math.BigDecimal;

/**
 * 整车数据
 *
 * @author qsxiaogang
 */
public class GB_02_01 implements IRealTimeAdditionalItem {

  /**
   * 0x01：车辆启动状态；0x02：熄火；0x03：其他状态；“0xFE”表示异常，“0xFF”表示无效。
   */
  private int vehicleStatus;
  /**
   * 0x01：停车充电；0x02：行驶充电；0x03：未充电状态；0x04：充电完成；“0xFE”表示异常，“0xFF”表示无效。
   */
  private int charging;
  /**
   * 0x01: 纯电；0x02：混动；0x03：燃油；0xFE表示异常；0xFF表示无效
   */
  private int runningMode;
  /**
   * 有效值范围：0～2200（表示0 km/h～220 km/h），最小计量单元：0.1km/h，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
   */
  private int speed;
  /**
   * 有效值范围：0～9999999（表示0km～999999.9km），最小计量单元：0.1km。“0xFF, 0xFF, 0xFF,0xFE”表示异常，“0xFF,0xFF,0xFF,0xFF”表示无效。
   */
  private int mileage;
  /**
   * 有效值范围：0～10000（表示0V～1000V），最小计量单元：0.1V，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
   */
  private int voltage;
  /**
   * 有效值范围： 0～20000（偏移量1000A，表示-1000A～+1000A），最小计量单元：0.1A，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
   */
  private int current;
  /**
   * 有效值范围：0～100（表示0%～100%），最小计量单元：1%，“0xFE”表示异常，“0xFF”表示无效。
   */
  private int soc;
  /**
   * 0x01：工作；0x02：断开，“0xFE”表示异常，“0xFF”表示无效。
   */
  private int dcDcStatus;
  /**
   * 挡位定义见附录A.1
   */
  private int gear;
  /**
   * 有效范围0～60000（表示0KΩ～60000KΩ），最小计量单元：1KΩ
   */
  private int insulationResistance;
  /**
   * 加速踏板行程值 : 有效值范围：0～100（表示0%～100%），最小计量单元：1%，“0xFE”表示异常，“0xFF”表示无效。
   */
  private int acceleratedPedalStrokeValue;
  /**
   * 制动踏板状态 : 有效值范围：0～100（表示0%～100%），最小计量单元：1%，“0”表示制动关的状态；在无具体行程值情况下，用“0x65”即“101”表示制动有效状态，“0xFE”表示异常，“0xFF”表示无效。
   */
  private int brakePedalState;

  @Override
  public int getAdditionalId() {
    return 0x01;
  }

  @Override
  public int getAdditionalLength() {
    return 20;
  }

  public int getVehicleStatus() {
    return vehicleStatus & 0xFF;
  }

  public void setVehicleStatus(int vehicleStatus) {
    this.vehicleStatus = vehicleStatus;
  }

  public int getCharging() {
    return charging & 0xFF;
  }

  public void setCharging(int charging) {
    this.charging = charging;
  }

  public int getRunningMode() {
    return runningMode & 0xFF;
  }

  public void setRunningMode(int runningMode) {
    this.runningMode = runningMode;
  }

  public int getSpeed() {
    return speed & 0xFFFF;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public int getMileage() {
    return mileage;
  }

  public void setMileage(int mileage) {
    this.mileage = mileage;
  }

  public int getVoltage() {
    return voltage & 0xFFFF;
  }

  public void setVoltage(int voltage) {
    this.voltage = voltage;
  }

  public int getCurrent() {
    return current & 0xFFFF;
  }

  public void setCurrent(int current) {
    this.current = current;
  }

  public int getSoc() {
    return soc & 0xFF;
  }

  public void setSoc(int soc) {
    this.soc = soc;
  }

  public int getDcDcStatus() {
    return dcDcStatus & 0xFF;
  }

  public void setDcDcStatus(int dcDcStatus) {
    this.dcDcStatus = dcDcStatus;
  }

  public int getGear() {
    return gear & 0xF;
  }

  public void setGear(int gear) {
    this.gear = gear;
  }

  public int getInsulationResistance() {
    return insulationResistance & 0xFFFF;
  }

  public void setInsulationResistance(int insulationResistance) {
    this.insulationResistance = insulationResistance;
  }

  public int getAcceleratedPedalStrokeValue() {
    return acceleratedPedalStrokeValue & 0xFF;
  }

  public void setAcceleratedPedalStrokeValue(int acceleratedPedalStrokeValue) {
    this.acceleratedPedalStrokeValue = acceleratedPedalStrokeValue;
  }

  public int getBrakePedalState() {
    return brakePedalState & 0xFF;
  }

  public void setBrakePedalState(int brakePedalState) {
    this.brakePedalState = brakePedalState;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((byte) getVehicleStatus());
    buff.put((byte) getCharging());
    buff.put((byte) getRunningMode());
    buff.put((short) getSpeed());
    buff.put(getMileage());
    buff.put((short) getVoltage());
    buff.put((short) getCurrent());
    buff.put((byte) getSoc());
    buff.put((byte) getDcDcStatus());
    buff.put((byte) getGear());
    buff.put((short) getInsulationResistance());
    buff.put((byte) getAcceleratedPedalStrokeValue());
    buff.put((byte) getBrakePedalState());

    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] messageBodyBytes) {
    MyBuffer buff = new MyBuffer(messageBodyBytes);
    setVehicleStatus(buff.get());
    setCharging(buff.get());
    setRunningMode(buff.get());
    setSpeed(buff.getShort());
    setMileage(buff.getInt());
    setVoltage(buff.getShort());
    setCurrent(buff.getShort());
    setSoc(buff.get());
    setDcDcStatus(buff.get());
    setGear(buff.get());
    setInsulationResistance(buff.getShort());
    setAcceleratedPedalStrokeValue(buff.get());
    setBrakePedalState(buff.get());

  }

  private static String jsonSplit = ",";

  @Override
  public String toString() {
    StringBuilder sBuilder = new StringBuilder();
    sBuilder.append(String.format("\"%1$s\":%2$s", "整车数据", "{"));

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "车辆状态", getVehicleStatusString()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "充电状态", getChargingString()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "运行模式", getRunningModeString()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "车速", getSpeedString()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "累计里程", getMileageString()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "总电压", getVoltageString()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "总电流", getCurrentString()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "SOC", getSocString()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "DC-DC状态", getDcDcStatusString()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "挡位", getGearString()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "绝缘电阻", getInsulationResistance() + "KΩ"));
    sBuilder.append(jsonSplit);

    sBuilder.append(
        String.format("\"%1$s\":\"%2$s\"", "加速踏板行程值", getAcceleratedPedalStrokeValueString()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "制动踏板状态", getBrakePedalStateString()));

    sBuilder.append("}");
    return sBuilder.toString();
  }

  public String getVehicleStatusString() {
    switch (getVehicleStatus()) {
      case 0x01:
        return "车辆启动状态";
      case 0x02:
        return "熄火";
      case 0x03:
        return "其他状态";
      case 0xFE:
        return "异常";
      case 0xFF:
        return "无效";
      default:
        return "";
    }
  }

  public String getChargingString() {
    switch (getCharging()) {
      case 0x01:
        return "停车充电";
      case 0x02:
        return "行驶充电";
      case 0x03:
        return "未充电状态";
      case 0x04:
        return "充电完成";
      case 0xFE:
        return "异常";
      case 0xFF:
        return "无效";
      default:
        return "";
    }
  }

  public String getRunningModeString() {
    switch (getRunningMode()) {
      case 0x01:
        return "纯电";
      case 0x02:
        return "混动";
      case 0x03:
        return "燃油";
      case 0xFE:
        return "异常";
      case 0xFF:
        return "无效";
      default:
        return "";
    }
  }

  public String getSpeedString() {
    switch (getSpeed()) {
      case 0xFFFE:
        return "异常";
      case 0xFFFF:
        return "无效";
      default:
        BigDecimal bigDecimal = AccurateOperationUtils.mul(getSpeed(), 0.1);
        bigDecimal = bigDecimal.setScale(1);
        return bigDecimal.toString() + "km/h";
    }
  }

  public String getMileageString() {
    switch (getMileage()) {
      case 0xFFFFFFFE:
        return "异常";
      case 0xFFFFFFFF:
        return "无效";
      default:
        BigDecimal bigDecimal = AccurateOperationUtils.mul(getMileage(), 0.1);
        bigDecimal = bigDecimal.setScale(1);
        return bigDecimal.toString() + "km";
    }
  }

  public String getVoltageString() {
    switch (getVoltage()) {
      case 0xFFFE:
        return "异常";
      case 0xFFFF:
        return "无效";
      default:
        BigDecimal bigDecimal = AccurateOperationUtils.mul(getVoltage(), 0.1);
        bigDecimal = bigDecimal.setScale(1);
        return bigDecimal.toString() + "V";
    }
  }

  public String getCurrentString() {
    switch (getCurrent()) {
      case 0xFFFE:
        return "异常";
      case 0xFFFF:
        return "无效";
      default:
        BigDecimal bigDecimal = AccurateOperationUtils
            .sub(AccurateOperationUtils.mul(getCurrent(), 0.1).doubleValue(), 1000);
        bigDecimal = bigDecimal.setScale(1);
        return bigDecimal.toString() + "A";
    }
  }

  public String getSocString() {
    switch (getSoc()) {
      case 0xFE:
        return "异常";
      case 0xFF:
        return "无效";
      default:
        return String.valueOf(getSoc()) + "%";
    }
  }

  public String getDcDcStatusString() {
    switch (getDcDcStatus()) {
      case 0x01:
        return "工作";
      case 0x02:
        return "断开";
      case 0xFE:
        return "异常";
      case 0xFF:
        return "无效";
      default:
        return "";
    }
  }

  public String getGearString() {
    int result = (getGear() & 0xF);
    switch (result) {
      case 0:
        return "空挡";
      case 13:
        return "倒挡";
      case 14:
        return "自动D挡";
      case 15:
        return "停车P挡";
      default:
        return result + "档";
    }
  }

  public String getAcceleratedPedalStrokeValueString() {
    switch (getAcceleratedPedalStrokeValue()) {
      case 0xFE:
        return "异常";
      case 0xFF:
        return "无效";
      default:
        return String.valueOf(getAcceleratedPedalStrokeValue());
    }
  }

  public String getBrakePedalStateString() {
    switch (getBrakePedalState()) {
      case 0:
        return "制动关的状态";
      case 0x65:
        return "制动有效状态";
      case 0xFE:
        return "异常";
      case 0xFF:
        return "无效";
      default:
        return String.valueOf(getBrakePedalState());
    }
  }
}
