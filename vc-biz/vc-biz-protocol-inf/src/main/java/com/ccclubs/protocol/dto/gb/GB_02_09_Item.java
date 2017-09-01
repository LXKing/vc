package com.ccclubs.protocol.dto.gb;

import com.ccclubs.protocol.inf.IMessageBody;
import com.ccclubs.protocol.util.GbTools;
import com.ccclubs.protocol.util.MyBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * 每个可充电储能子系统上温度数据格式和定义
 *
 * @author qsxiaogang
 */
public class GB_02_09_Item implements IMessageBody {

  /**
   * 可充电储能子系统号 : 有效值范围：1～250。
   */
  private int rechargeableEnergyStorageSubsystemNumber;
  /**
   * 可充电储能温度探针个数 : N个温度探针，有效值范围：1～65531，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
   */
  private int rechargeableEnergyStorageTemperatureProbesTotalNumber;
  /**
   * 可充电储能子系统各温度探针检测到的温度值 : 有效值范围：0～250 （数值偏移量40℃，表示-40℃～+210℃），最小计量单元：1℃，“0xFE”表示异常，“0xFF”表示无效。
   */
  private List<Byte> temperatureProbesList;

  public int getRechargeableEnergyStorageSubsystemNumber() {
    return rechargeableEnergyStorageSubsystemNumber & 0xFF;
  }

  public void setRechargeableEnergyStorageSubsystemNumber(
      int rechargeableEnergyStorageSubsystemNumber) {
    this.rechargeableEnergyStorageSubsystemNumber = rechargeableEnergyStorageSubsystemNumber;
  }

  public int getRechargeableEnergyStorageTemperatureProbesTotalNumber() {
    return rechargeableEnergyStorageTemperatureProbesTotalNumber & 0xFFFF;
  }

  public void setRechargeableEnergyStorageTemperatureProbesTotalNumber(
      int rechargeableEnergyStorageTemperatureProbesTotalNumber) {
    this.rechargeableEnergyStorageTemperatureProbesTotalNumber = rechargeableEnergyStorageTemperatureProbesTotalNumber;
  }

  public List<Byte> getTemperatureProbesList() {
    return temperatureProbesList;
  }

  public void setTemperatureProbesList(List<Byte> temperatureProbesList) {
    this.temperatureProbesList = temperatureProbesList;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((byte) getRechargeableEnergyStorageSubsystemNumber());
    buff.put((short) getRechargeableEnergyStorageTemperatureProbesTotalNumber());
    for (Byte item : temperatureProbesList) {
      if (item != null) {
        buff.put(item);
      }
    }

    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] messageBodyBytes) {
    MyBuffer buff = new MyBuffer(messageBodyBytes);
    setRechargeableEnergyStorageSubsystemNumber(buff.get());
    setRechargeableEnergyStorageTemperatureProbesTotalNumber(buff.getShort());
    this.temperatureProbesList = new ArrayList<>();
    if (GbTools.isEffective(getRechargeableEnergyStorageTemperatureProbesTotalNumber())) {
      for (int i = 0; i < getRechargeableEnergyStorageTemperatureProbesTotalNumber(); i++) {
        temperatureProbesList.add(buff.get());
      }
    }
  }

  private static String jsonSplit = ",";

  @Override
  public String toString() {
    StringBuilder sBuilder = new StringBuilder();
    sBuilder.append("{");

    sBuilder.append(
        String.format("\"%1$s\":\"%2$s\"", "可充电储能子系统号",
            getRechargeableEnergyStorageSubsystemNumber()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "可充电储能温度探针个数",
        getRechargeableEnergyStorageTemperatureProbesTotalNumberString()));
    sBuilder.append(jsonSplit);

    sBuilder.append(
        String
            .format("\"%1$s\":\"%2$s\"", "可充电储能子系统各温度探针检测到的温度值", getTemperatureProbesListString()));

    sBuilder.append("}");
    return sBuilder.toString();
  }

  public String getRechargeableEnergyStorageTemperatureProbesTotalNumberString() {
    switch (getRechargeableEnergyStorageTemperatureProbesTotalNumber()) {
      case 0xFFFE:
        return "异常";
      case 0xFFFF:
        return "无效";
      default:
        return String.valueOf(getRechargeableEnergyStorageTemperatureProbesTotalNumber());
    }
  }

  public String getTemperatureProbesListString() {
    StringBuilder sBuilder = new StringBuilder();
    sBuilder.append("[");
    if (getTemperatureProbesList().size() > 0) {
      for (int i = 0; i < getTemperatureProbesList().size(); i++) {
        byte item = getTemperatureProbesList().get(i);
        sBuilder.append(getTemperatureValueString(item));
        if (i != getTemperatureProbesList().size() - 1) {
          sBuilder.append(jsonSplit);
        }
      }
    }
    sBuilder.append("]");
    return sBuilder.toString();
  }

  public String getTemperatureValueString(int value) {
    if (value < 0) {
      value = (value & 0xFF);
    }
    switch (value) {
      case 0xFE:
        return "异常";
      case 0xFF:
        return "无效";
      default:
        return String.valueOf(value - 40) + "℃";
    }
  }
}
