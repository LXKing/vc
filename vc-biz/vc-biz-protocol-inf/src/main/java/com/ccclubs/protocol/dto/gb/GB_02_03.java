package com.ccclubs.protocol.dto.gb;

import com.ccclubs.protocol.inf.IRealTimeAdditionalItem;
import com.ccclubs.protocol.util.AccurateOperationUtils;
import com.ccclubs.protocol.util.GbTools;
import com.ccclubs.protocol.util.MyBuffer;
import java.math.BigDecimal;

/**
 * 燃料电池数据
 *
 * @author qsxiaogang
 */
public class GB_02_03 implements IRealTimeAdditionalItem {

  /**
   * 燃料电池电压；有效值范围：0～20000（表示0V～2000V），最小计量单元：0.1V，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
   */
  private int fuelCellVoltage;
  /**
   * 燃料电池电流；有效值范围： 0～20000（表示0A～+2000A），最小计量单元：0.1A，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
   */
  private int fuelCellCurrent;
  /**
   * 燃料消耗率；有效值范围：0～60000（表示0kg/100km～600kg/100km），最小计量单元：0.01kg/100km，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
   */
  private int fuelConsumptionRate;
  /**
   * 燃料电池温度探针总数；N个燃料电池温度探针，有效值范围：0～65531，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
   */
  private int fuelCellTemperatureProbeNumber;
  /**
   * 探针温度值；有效值范围：0～240（数值偏移量40℃，表示-40℃～+200℃），最小计量单元：1℃。
   */
  private byte[] probeTemperature;
  /**
   * 氢系统中最高温度；有效值范围：0～2400（偏移量40℃，表示-40℃～200℃），最小计量单元：0.1℃，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
   */
  private int hydrogenMaxTemperature;
  /**
   * 氢系统中最高温度探针代号；有效值范围：1～252，“0xFE”表示异常，“0xFF”表示无效。
   */
  private int hydrogenMaxTemperatureProbeSerial;
  /**
   * 氢气最高浓度；有效值范围：0～60000（表示0ppm～50000ppm），最小计量单元：1ppm，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
   */
  private int hydrogenMaxConcentration;
  /**
   * 氢气最高浓度传感器代号；有效值范围：1～252，“0xFE”表示异常，“0xFF”表示无效。
   */
  private int hydrogenMaxConcentrationSensorSerial;
  /**
   * 氢气最高压力；有效值范围：0～1000（表示0MPa～100MPa），最小计量单元：0.1MPa。
   */
  private int hydrogenMaxPressure;
  /**
   * 氢气最高压力传感器代号；有效值范围：1～252，“0xFE”表示异常，“0xFF”表示无效。
   */
  private int hydrogenMaxPressureSensorSerial;
  /**
   * 高压DC/DC状态；0x01：工作；0x02：断开；“0xFE”表示异常，“0xFF”表示无效。
   */
  private int highvoltageDCDCStatus;

  @Override
  public int getAdditionalId() {
    return 0x03;
  }

  @Override
  public int getAdditionalLength() {
    return -1;
  }

  public int getFuelCellVoltage() {
    return fuelCellVoltage & 0xFFFF;
  }

  public void setFuelCellVoltage(int fuelCellVoltage) {
    this.fuelCellVoltage = fuelCellVoltage;
  }

  public int getFuelCellCurrent() {
    return fuelCellCurrent & 0xFFFF;
  }

  public void setFuelCellCurrent(int fuelCellCurrent) {
    this.fuelCellCurrent = fuelCellCurrent;
  }

  public int getFuelConsumptionRate() {
    return fuelConsumptionRate & 0xFFFF;
  }

  public void setFuelConsumptionRate(int fuelConsumptionRate) {
    this.fuelConsumptionRate = fuelConsumptionRate;
  }

  public int getFuelCellTemperatureProbeNumber() {
    return fuelCellTemperatureProbeNumber & 0xFFFF;
  }

  public void setFuelCellTemperatureProbeNumber(int fuelCellTemperatureProbeNumber) {
    this.fuelCellTemperatureProbeNumber = fuelCellTemperatureProbeNumber;
  }

  public byte[] getProbeTemperature() {
    return probeTemperature;
  }

  public void setProbeTemperature(byte[] probeTemperature) {
    this.probeTemperature = probeTemperature;
  }

  public int getHydrogenMaxTemperature() {
    return hydrogenMaxTemperature & 0xFFFF;
  }

  public void setHydrogenMaxTemperature(int hydrogenMaxTemperature) {
    this.hydrogenMaxTemperature = hydrogenMaxTemperature;
  }

  public int getHydrogenMaxTemperatureProbeSerial() {
    return hydrogenMaxTemperatureProbeSerial & 0xFF;
  }

  public void setHydrogenMaxTemperatureProbeSerial(int hydrogenMaxTemperatureProbeSerial) {
    this.hydrogenMaxTemperatureProbeSerial = hydrogenMaxTemperatureProbeSerial;
  }

  public int getHydrogenMaxConcentration() {
    return hydrogenMaxConcentration & 0xFFFF;
  }

  public void setHydrogenMaxConcentration(int hydrogenMaxConcentration) {
    this.hydrogenMaxConcentration = hydrogenMaxConcentration;
  }

  public int getHydrogenMaxConcentrationSensorSerial() {
    return hydrogenMaxConcentrationSensorSerial & 0xFF;
  }

  public void setHydrogenMaxConcentrationSensorSerial(int hydrogenMaxConcentrationSensorSerial) {
    this.hydrogenMaxConcentrationSensorSerial = hydrogenMaxConcentrationSensorSerial;
  }

  public int getHydrogenMaxPressure() {
    return hydrogenMaxPressure & 0xFFFF;
  }

  public void setHydrogenMaxPressure(int hydrogenMaxPressure) {
    this.hydrogenMaxPressure = hydrogenMaxPressure;
  }

  public int getHydrogenMaxPressureSensorSerial() {
    return hydrogenMaxPressureSensorSerial & 0xFF;
  }

  public void setHydrogenMaxPressureSensorSerial(int hydrogenMaxPressureSensorSerial) {
    this.hydrogenMaxPressureSensorSerial = hydrogenMaxPressureSensorSerial;
  }

  public int getHighvoltageDCDCStatus() {
    return highvoltageDCDCStatus & 0xFF;
  }

  public void setHighvoltageDCDCStatus(int highvoltageDCDCStatus) {
    this.highvoltageDCDCStatus = highvoltageDCDCStatus;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((short) getFuelCellVoltage());
    buff.put((short) getFuelCellCurrent());
    buff.put((short) getFuelConsumptionRate());
    buff.put((short) getFuelCellTemperatureProbeNumber());
    for (byte item : probeTemperature) {
      buff.put(item);
    }
    buff.put((short) getHydrogenMaxTemperature());
    buff.put((byte) getHydrogenMaxTemperatureProbeSerial());
    buff.put((short) getHydrogenMaxConcentration());
    buff.put((byte) getHydrogenMaxConcentrationSensorSerial());
    buff.put((short) getHydrogenMaxPressure());
    buff.put((byte) getHydrogenMaxPressureSensorSerial());
    buff.put((byte) getHighvoltageDCDCStatus());

    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] messageBodyBytes) {
    MyBuffer buff = new MyBuffer(messageBodyBytes);
    setFuelCellVoltage(buff.getShort());
    setFuelCellCurrent(buff.getShort());
    setFuelConsumptionRate(buff.getShort());
    setFuelCellTemperatureProbeNumber(buff.getShort());
    int probeNumber = getFuelCellTemperatureProbeNumber();

    if (GbTools.isEffective(probeNumber)) {
      this.probeTemperature = new byte[probeNumber];
      for (int i = 0; i < probeNumber; i++) {
        //				byte subByte = messageBodyBytes[8+i];
        getProbeTemperature()[i] = buff.get();
      }
    }

    setHydrogenMaxTemperature(buff.getShort());
    setHydrogenMaxTemperatureProbeSerial(buff.get());
    setHydrogenMaxConcentration(buff.getShort());
    setHydrogenMaxConcentrationSensorSerial(buff.get());
    setHydrogenMaxPressure(buff.getShort());
    setHydrogenMaxPressureSensorSerial(buff.get());
    setHighvoltageDCDCStatus(buff.get());
  }

  private static String jsonSplit = ",";

  @Override
  public String toString() {
    StringBuilder sBuilder = new StringBuilder();
    sBuilder.append(String.format("\"%1$s\":%2$s", "燃料电池数据", "{"));

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "燃料电池电压", getFuelCellVoltageString()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "燃料电池电流", getFuelCellCurrentString()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "燃料消耗率", getFuelConsumptionRateString()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String
        .format("\"%1$s\":\"%2$s\"", "燃料电池温度探针总数", getFuelCellTemperatureProbeNumberString()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "探针温度值", getProbeTemperatureString()));
    sBuilder.append(jsonSplit);

    sBuilder
        .append(String.format("\"%1$s\":\"%2$s\"", "氢系统中最高温度", getHydrogenMaxTemperatureString()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String
        .format("\"%1$s\":\"%2$s\"", "氢系统中最高温度探针代号", getHydrogenMaxTemperatureProbeSerialString()));
    sBuilder.append(jsonSplit);

    sBuilder
        .append(String.format("\"%1$s\":\"%2$s\"", "氢气最高浓度", getHydrogenMaxConcentrationString()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "氢气最高浓度传感器代号",
        getHydrogenMaxConcentrationSensorSerialString()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "氢气最高压力", getHydrogenMaxPressureString()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String
        .format("\"%1$s\":\"%2$s\"", "氢气最高压力传感器代号", getHydrogenMaxPressureSensorSerialString()));
    sBuilder.append(jsonSplit);

    sBuilder
        .append(String.format("\"%1$s\":\"%2$s\"", "高压DC/DC状态", getHighvoltageDCDCStatusString()));

    sBuilder.append("}");
    return sBuilder.toString();
  }

  public String getFuelCellVoltageString() {
    switch (getFuelCellVoltage()) {
      case 0xFFFE:
        return "异常";
      case 0xFFFF:
        return "无效";
      default:
        BigDecimal bigDecimal = AccurateOperationUtils.mul(getFuelCellVoltage(), 0.1);
        bigDecimal = bigDecimal.setScale(1);
        return bigDecimal.toString() + "V";
    }
  }

  public String getFuelCellCurrentString() {
    switch (getFuelCellCurrent()) {
      case 0xFFFE:
        return "异常";
      case 0xFFFF:
        return "无效";
      default:
        BigDecimal bigDecimal = AccurateOperationUtils.mul(getFuelCellCurrent(), 0.1);
        bigDecimal = bigDecimal.setScale(1);
        return bigDecimal.toString() + "A";
    }
  }

  public String getFuelConsumptionRateString() {
    switch (getFuelConsumptionRate()) {
      case 0xFFFE:
        return "异常";
      case 0xFFFF:
        return "无效";
      default:
        BigDecimal bigDecimal = AccurateOperationUtils.mul(getFuelConsumptionRate(), 0.01);
        bigDecimal = bigDecimal.setScale(2);
        return bigDecimal.toString() + "kg/100km";
    }
  }

  public String getFuelCellTemperatureProbeNumberString() {
    switch (getFuelCellTemperatureProbeNumber()) {
      case 0xFFFE:
        return "异常";
      case 0xFFFF:
        return "无效";
      default:
        return String.valueOf(getFuelCellTemperatureProbeNumber());
    }
  }

  public String getHydrogenMaxTemperatureString() {
    switch (getHydrogenMaxTemperature()) {
      case 0xFFFE:
        return "异常";
      case 0xFFFF:
        return "无效";
      default:
        BigDecimal bigDecimal = AccurateOperationUtils
            .sub(AccurateOperationUtils.mul(getHydrogenMaxTemperature(), 0.1).doubleValue(), 40);
        bigDecimal = bigDecimal.setScale(1);
        return bigDecimal.toString() + "℃";
    }
  }

  public String getHydrogenMaxTemperatureProbeSerialString() {
    switch (getHydrogenMaxTemperatureProbeSerial()) {
      case 0xFE:
        return "异常";
      case 0xFF:
        return "无效";
      default:
        return String.valueOf(getHydrogenMaxTemperatureProbeSerial());
    }
  }

  public String getHydrogenMaxConcentrationSensorSerialString() {
    switch (getHydrogenMaxConcentrationSensorSerial()) {
      case 0xFE:
        return "异常";
      case 0xFF:
        return "无效";
      default:
        return String.valueOf(getHydrogenMaxConcentrationSensorSerial());
    }
  }

  public String getHydrogenMaxPressureSensorSerialString() {
    switch (getHydrogenMaxPressureSensorSerial()) {
      case 0xFE:
        return "异常";
      case 0xFF:
        return "无效";
      default:
        return String.valueOf(getHydrogenMaxPressureSensorSerial());
    }
  }

  public String getHighvoltageDCDCStatusString() {
    switch (getHighvoltageDCDCStatus()) {
      case 0x01:
        return "工作";
      case 0x02:
        return "断开";
      case 0xFE:
        return "异常";
      case 0xFF:
        return "无效";
      default:
        return String.valueOf(getHighvoltageDCDCStatus());
    }
  }

  public String getHydrogenMaxConcentrationString() {
    switch (getHydrogenMaxConcentration()) {
      case 0xFFFE:
        return "异常";
      case 0xFFFF:
        return "无效";
      default:
        return String.valueOf(getHydrogenMaxConcentration() - 10000) + "ppm";
    }
  }

  public String getHydrogenMaxPressureString() {
    switch (getHydrogenMaxPressure()) {
      case 0xFFFE:
        return "异常";
      case 0xFFFF:
        return "无效";
      default:
        BigDecimal bigDecimal = AccurateOperationUtils.mul(getHydrogenMaxPressure(), 0.1);
        bigDecimal = bigDecimal.setScale(1);
        return bigDecimal.toString() + "MPa";
    }
  }

  public String getProbeTemperatureString() {
    StringBuilder sBuilder = new StringBuilder();
    sBuilder.append("[");
    if (getProbeTemperature().length > 0) {
      for (int i = 0; i < getProbeTemperature().length; i++) {
        byte item = getProbeTemperature()[i];
        sBuilder.append((item & 0xFF) - 40);
        sBuilder.append("℃");
        if (i != getProbeTemperature().length - 1) {
          sBuilder.append(jsonSplit);
        }
      }
    }
    sBuilder.append("]");
    return sBuilder.toString();
  }
}
