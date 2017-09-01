package com.ccclubs.protocol.dto.gb;

import com.ccclubs.protocol.inf.IRealTimeAdditionalItem;
import com.ccclubs.protocol.util.AccurateOperationUtils;
import com.ccclubs.protocol.util.MyBuffer;
import java.math.BigDecimal;

/**
 * 极值数据
 *
 * @author qsxiaogang
 */
public class GB_02_06 implements IRealTimeAdditionalItem {

  /**
   * 最高电压电池子系统号 : 有效值范围：1～250，“0xFE”表示异常，“0xFF”表示无效。
   */
  private int highestVoltageBatterySubsystemNumber;
  /**
   * 最高电压电池单体代号 : 有效值范围：1～250，“0xFE”表示异常，“0xFF”表示无效。
   */
  private int highestVoltageBatterySingleModuleCode;
  /**
   * 电池单体电压最高值 : 有效值范围：0～15000（表示0V～15V），最小计量单元：0.001V，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
   */
  private int batterySingleVoltageHighestValue;
  /**
   * 最低电压电池子系统号 : 有效值范围：1～250，“0xFE”表示异常，“0xFF”表示无效。
   */
  private int lowestVoltageBatterySubsystemNumber;
  /**
   * 最低电压电池单体代号 : 有效值范围：1～250，“0xFE”表示异常，“0xFF”表示无效。
   */
  private int lowestVoltageBatterySingleModuleCode;
  /**
   * 电池单体电压最低值 : 有效值范围：0～15000（表示0V～15V），最小计量单元：0.001V，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
   */
  private int batterySingleVoltageLowestValue;
  /**
   * 最高温度子系统号 : 有效值范围：1～250，“0xFE”表示异常，“0xFF”表示无效。
   */
  private int highestTemperatureSubsystemNumber;
  /**
   * 最高温度探针单体代号 : 有效值范围：1～250，“0xFE”表示异常，“0xFF”表示无效。
   */
  private int highestTemperatureProbeMonomerSingleCode;
  /**
   * 最高温度值 : 有效值范围：0～250（数值偏移量40℃，表示-40℃～+210℃），最小计量单元：1℃，“0xFE”表示异常，“0xFF”表示无效。
   */
  private int highestTemperatureValue;
  /**
   * 最低温度子系统号 : 有效值范围：1～250，“0xFE”表示异常，“0xFF”表示无效。
   */
  private int lowestTemperatureSubsystemNumber;
  /**
   * 最低温度探针子系统代号 : 有效值范围：1～250，“0xFE”表示异常，“0xFF”表示无效。
   */
  private int lowestTemperatureProbeSubsystemCode;
  /**
   * 最低温度值 : 有效值范围：0～250（数值偏移量40℃，表示-40℃～+210℃），最小计量单元：1℃，“0xFE”表示异常，“0xFF”表示无效。
   */
  private int lowestTemperatureValue;

  @Override
  public int getAdditionalId() {
    return 0x06;
  }

  @Override
  public int getAdditionalLength() {
    return 14;
  }

  public int getHighestVoltageBatterySubsystemNumber() {
    return highestVoltageBatterySubsystemNumber & 0xFF;
  }

  public void setHighestVoltageBatterySubsystemNumber(int highestVoltageBatterySubsystemNumber) {
    this.highestVoltageBatterySubsystemNumber = highestVoltageBatterySubsystemNumber;
  }

  public int getHighestVoltageBatterySingleModuleCode() {
    return highestVoltageBatterySingleModuleCode & 0xFF;
  }

  public void setHighestVoltageBatterySingleModuleCode(int highestVoltageBatterySingleModuleCode) {
    this.highestVoltageBatterySingleModuleCode = highestVoltageBatterySingleModuleCode;
  }

  public int getBatterySingleVoltageHighestValue() {
    return batterySingleVoltageHighestValue & 0xFFFF;
  }

  public void setBatterySingleVoltageHighestValue(int batterySingleVoltageHighestValue) {
    this.batterySingleVoltageHighestValue = batterySingleVoltageHighestValue;
  }

  public int getLowestVoltageBatterySubsystemNumber() {
    return lowestVoltageBatterySubsystemNumber & 0xFF;
  }

  public void setLowestVoltageBatterySubsystemNumber(int lowestVoltageBatterySubsystemNumber) {
    this.lowestVoltageBatterySubsystemNumber = lowestVoltageBatterySubsystemNumber;
  }

  public int getLowestVoltageBatterySingleModuleCode() {
    return lowestVoltageBatterySingleModuleCode & 0xFF;
  }

  public void setLowestVoltageBatterySingleModuleCode(int lowestVoltageBatterySingleModuleCode) {
    this.lowestVoltageBatterySingleModuleCode = lowestVoltageBatterySingleModuleCode;
  }

  public int getBatterySingleVoltageLowestValue() {
    return batterySingleVoltageLowestValue & 0xFFFF;
  }

  public void setBatterySingleVoltageLowestValue(int batterySingleVoltageLowestValue) {
    this.batterySingleVoltageLowestValue = batterySingleVoltageLowestValue;
  }

  public int getHighestTemperatureSubsystemNumber() {
    return highestTemperatureSubsystemNumber & 0xFF;
  }

  public void setHighestTemperatureSubsystemNumber(int highestTemperatureSubsystemNumber) {
    this.highestTemperatureSubsystemNumber = highestTemperatureSubsystemNumber;
  }

  public int getHighestTemperatureProbeMonomerSingleCode() {
    return highestTemperatureProbeMonomerSingleCode & 0xFF;
  }

  public void setHighestTemperatureProbeMonomerSingleCode(
      int highestTemperatureProbeMonomerSingleCode) {
    this.highestTemperatureProbeMonomerSingleCode = highestTemperatureProbeMonomerSingleCode;
  }

  public int getHighestTemperatureValue() {
    return highestTemperatureValue & 0xFF;
  }

  public void setHighestTemperatureValue(int highestTemperatureValue) {
    this.highestTemperatureValue = highestTemperatureValue;
  }

  public int getLowestTemperatureSubsystemNumber() {
    return lowestTemperatureSubsystemNumber & 0xFF;
  }

  public void setLowestTemperatureSubsystemNumber(int lowestTemperatureSubsystemNumber) {
    this.lowestTemperatureSubsystemNumber = lowestTemperatureSubsystemNumber;
  }

  public int getLowestTemperatureProbeSubsystemCode() {
    return lowestTemperatureProbeSubsystemCode & 0xFF;
  }

  public void setLowestTemperatureProbeSubsystemCode(int lowestTemperatureProbeSubsystemCode) {
    this.lowestTemperatureProbeSubsystemCode = lowestTemperatureProbeSubsystemCode;
  }

  public int getLowestTemperatureValue() {
    return lowestTemperatureValue & 0xFF;
  }

  public void setLowestTemperatureValue(int lowestTemperatureValue) {
    this.lowestTemperatureValue = lowestTemperatureValue;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((byte) getHighestVoltageBatterySubsystemNumber());
    buff.put((byte) getHighestVoltageBatterySingleModuleCode());
    buff.put((short) getBatterySingleVoltageHighestValue());
    buff.put((byte) getLowestVoltageBatterySubsystemNumber());
    buff.put((byte) getLowestVoltageBatterySingleModuleCode());
    buff.put((short) getBatterySingleVoltageLowestValue());
    buff.put((byte) getHighestTemperatureSubsystemNumber());
    buff.put((byte) getHighestTemperatureProbeMonomerSingleCode());
    buff.put((byte) getHighestTemperatureValue());
    buff.put((byte) getLowestTemperatureSubsystemNumber());
    buff.put((byte) getLowestTemperatureProbeSubsystemCode());
    buff.put((byte) getLowestTemperatureValue());

    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] messageBodyBytes) {
    MyBuffer buff = new MyBuffer(messageBodyBytes);
    setHighestVoltageBatterySubsystemNumber(buff.get());
    setHighestVoltageBatterySingleModuleCode(buff.get());
    setBatterySingleVoltageHighestValue(buff.getShort());
    setLowestVoltageBatterySubsystemNumber(buff.get());
    setLowestVoltageBatterySingleModuleCode(buff.get());
    setBatterySingleVoltageLowestValue(buff.getShort());
    setHighestTemperatureSubsystemNumber(buff.get());
    setHighestTemperatureProbeMonomerSingleCode(buff.get());
    setHighestTemperatureValue(buff.get());
    setLowestTemperatureSubsystemNumber(buff.get());
    setLowestTemperatureProbeSubsystemCode(buff.get());
    setLowestTemperatureValue(buff.get());
  }

  private static String jsonSplit = ",";

  @Override
  public String toString() {
    StringBuilder sBuilder = new StringBuilder();
    sBuilder.append(String.format("\"%1$s\":%2$s", "极值数据", "{"));

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "最高电压电池子系统号",
        getDataString(getHighestVoltageBatterySubsystemNumber())));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "最高电压电池单体代号",
        getDataString(getHighestVoltageBatterySingleModuleCode())));
    sBuilder.append(jsonSplit);

    sBuilder.append(String
        .format("\"%1$s\":\"%2$s\"", "电池单体电压最高值", getBatterySingleVoltageHighestValueString()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "最低电压电池单体代号",
        getDataString(getLowestVoltageBatterySingleModuleCode())));
    sBuilder.append(jsonSplit);

    sBuilder.append(String
        .format("\"%1$s\":\"%2$s\"", "电池单体电压最低值", getBatterySingleVoltageLowestValueString()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "最高温度子系统号",
        getDataString(getHighestTemperatureSubsystemNumber())));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "最高温度探针单体代号",
        getDataString(getHighestTemperatureProbeMonomerSingleCode())));
    sBuilder.append(jsonSplit);

    sBuilder
        .append(String.format("\"%1$s\":\"%2$s\"", "最高温度值", getHighestTemperatureValueString()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "最低温度子系统号",
        getDataString(getLowestTemperatureSubsystemNumber())));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "最低温度探针子系统代号",
        getDataString(getLowestTemperatureProbeSubsystemCode())));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "最低温度值", getLowestTemperatureValueString()));

    sBuilder.append("}");
    return sBuilder.toString();
  }

  public String getDataString(int value) {
    switch (value) {
      case 0xFE:
        return "异常";
      case 0xFF:
        return "无效";
      default:
        return String.valueOf(value);
    }
  }

  public String getBatterySingleVoltageHighestValueString() {
    switch (getBatterySingleVoltageHighestValue()) {
      case 0xFFFE:
        return "异常";
      case 0xFFFF:
        return "无效";
      default:
        BigDecimal bigDecimal = AccurateOperationUtils
            .mul(getBatterySingleVoltageHighestValue(), 0.001);
        bigDecimal = bigDecimal.setScale(3, BigDecimal.ROUND_HALF_UP);
        return bigDecimal.toString() + "V";
    }
  }

  public String getBatterySingleVoltageLowestValueString() {
    switch (getBatterySingleVoltageLowestValue()) {
      case 0xFFFE:
        return "异常";
      case 0xFFFF:
        return "无效";
      default:
        BigDecimal bigDecimal = AccurateOperationUtils
            .mul(getBatterySingleVoltageLowestValue(), 0.001);
        bigDecimal = bigDecimal.setScale(3, BigDecimal.ROUND_HALF_UP);
        return
            bigDecimal.toString() + "V";
    }
  }

  public String getHighestTemperatureValueString() {
    switch (getHighestTemperatureValue()) {
      case 0xFE:
        return "异常";
      case 0xFF:
        return "无效";
      default:
        return String.valueOf(getHighestTemperatureValue() - 40) + "℃";
    }
  }

  public String getLowestTemperatureValueString() {
    switch (getLowestTemperatureValue()) {
      case 0xFE:
        return "异常";
      case 0xFF:
        return "无效";
      default:
        return String.valueOf(getLowestTemperatureValue() - 40) + "℃";
    }
  }
}
