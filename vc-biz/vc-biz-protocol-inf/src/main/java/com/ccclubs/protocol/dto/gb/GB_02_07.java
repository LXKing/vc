package com.ccclubs.protocol.dto.gb;

import com.ccclubs.protocol.inf.IRealTimeAdditionalItem;
import com.ccclubs.protocol.util.GbTools;
import com.ccclubs.protocol.util.MyBuffer;
import com.ccclubs.protocol.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * 报警数据
 *
 * @author qsxiaogang
 */
public class GB_02_07 implements IRealTimeAdditionalItem {

  /**
   * 最高报警等级 : 为当前发生的故障中的最高等级值，有效值范围：0～3，“0”表示无故障；“1”表示1级故障，指代不影响车辆正常行驶的故障；“2”表示2级故障，指代影响车辆性能，需驾驶员限制行驶的故障；“3”表示3级故障，为最高级别故障
   * ，指代驾驶员应立即停车处理或请求救援的故障；具体等级对应的故障内容由厂商自行定义；“0xFE”表示异常，“0xFF”表示无效。
   */
  private int highestAlarmLevel;
  /**
   * 通用报警标志 : 通用报警标志位定义见表18。
   */
  private int generalAlarmFlag;
  /**
   * 可充电储能装置故障总数N1 : N1个可充电储能装置故障，有效值范围：0～252，“0xFE”表示异常，“0xFF”表示无效。
   */
  private int rechargeableEnergyStorageDeviceTotalNumberOfFailures;
  /**
   * 扩展性数据，由厂商自行定义，可充电储能装置故障个数等于可充电储能装置故障总数N1
   */
  private List<Integer> rechargeableEnergyStorageDeviceFailuresCodeList;
  /**
   * 驱动电机故障总数N2 : N2个驱动电机故障，有效值范围：0～252，“0xFE”表示异常，“0xFF”表示无效。
   */
  private int driveMotorTotalNumberOfFailures;
  /**
   * 驱动电机故障代码列表 : 厂商自行定义，驱动电机故障个数等于驱动电机故障总数N2。
   */
  private List<Integer> driveMotorFailuresCodeList;
  /**
   * 发动机故障总数N3 : N3个驱动电机故障，有效值范围：0～252，“0xFE”表示异常，“0xFF”表示无效。
   */
  private int engineTotalNumberOfFailures;

  /**
   * 发动机故障列表 : 厂商自行定义，发动机故障个数等于驱动电机故障总数N3
   */
  private List<Integer> engineFailuresCodeList;
  /**
   * 其他故障总数N4 : N4个其他故障，有效值范围：0～252，“0xFE”表示异常，“0xFF”表示无效。
   */
  private int otherTotalNumberOfFailures;

  /**
   * 其他故障代码列表 : 厂商自行定义，故障个数等于故障总数N4。
   */
  private List<Integer> otherFailuresCodeList;

  @Override
  public int getAdditionalId() {
    return 0x07;
  }

  @Override
  public int getAdditionalLength() {
    return -1;
  }

  public int getHighestAlarmLevel() {
    return highestAlarmLevel;
  }

  public void setHighestAlarmLevel(int highestAlarmLevel) {
    this.highestAlarmLevel = highestAlarmLevel;
  }

  public int getGeneralAlarmFlag() {
    return generalAlarmFlag;
  }

  public void setGeneralAlarmFlag(int generalAlarmFlag) {
    this.generalAlarmFlag = generalAlarmFlag;
  }

  public int getRechargeableEnergyStorageDeviceTotalNumberOfFailures() {
    return rechargeableEnergyStorageDeviceTotalNumberOfFailures & 0xFF;
  }

  public void setRechargeableEnergyStorageDeviceTotalNumberOfFailures(
      int rechargeableEnergyStorageDeviceTotalNumberOfFailures) {
    this.rechargeableEnergyStorageDeviceTotalNumberOfFailures = rechargeableEnergyStorageDeviceTotalNumberOfFailures;
  }

  public List<Integer> getRechargeableEnergyStorageDeviceFailuresCodeList() {
    return rechargeableEnergyStorageDeviceFailuresCodeList;
  }

  public void setRechargeableEnergyStorageDeviceFailuresCodeList(
      List<Integer> rechargeableEnergyStorageDeviceFailuresCodeList) {
    this.rechargeableEnergyStorageDeviceFailuresCodeList = rechargeableEnergyStorageDeviceFailuresCodeList;
  }

  public int getDriveMotorTotalNumberOfFailures() {
    return driveMotorTotalNumberOfFailures & 0xFF;
  }

  public void setDriveMotorTotalNumberOfFailures(int driveMotorTotalNumberOfFailures) {
    this.driveMotorTotalNumberOfFailures = driveMotorTotalNumberOfFailures;
  }

  public List<Integer> getDriveMotorFailuresCodeList() {
    return driveMotorFailuresCodeList;
  }

  public void setDriveMotorFailuresCodeList(List<Integer> driveMotorFailuresCodeList) {
    this.driveMotorFailuresCodeList = driveMotorFailuresCodeList;
  }

  public int getEngineTotalNumberOfFailures() {
    return engineTotalNumberOfFailures & 0xFF;
  }

  public void setEngineTotalNumberOfFailures(int engineTotalNumberOfFailures) {
    this.engineTotalNumberOfFailures = engineTotalNumberOfFailures;
  }

  public List<Integer> getEngineFailuresCodeList() {
    return engineFailuresCodeList;
  }

  public void setEngineFailuresCodeList(List<Integer> engineFailuresCodeList) {
    this.engineFailuresCodeList = engineFailuresCodeList;
  }

  public int getOtherTotalNumberOfFailures() {
    return otherTotalNumberOfFailures & 0xFF;
  }

  public void setOtherTotalNumberOfFailures(int otherTotalNumberOfFailures) {
    this.otherTotalNumberOfFailures = otherTotalNumberOfFailures;
  }

  public List<Integer> getOtherFailuresCodeList() {
    return otherFailuresCodeList;
  }

  public void setOtherFailuresCodeList(List<Integer> otherFailuresCodeList) {
    this.otherFailuresCodeList = otherFailuresCodeList;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((byte) getHighestAlarmLevel());
    buff.put(getGeneralAlarmFlag());
    buff.put((byte) getRechargeableEnergyStorageDeviceTotalNumberOfFailures());
    for (Integer item : rechargeableEnergyStorageDeviceFailuresCodeList) {
      if (item != null) {
        buff.put(item);
      }
    }
    buff.put((byte) getDriveMotorTotalNumberOfFailures());
    for (Integer item : driveMotorFailuresCodeList) {
      if (item != null) {
        buff.put(item);
      }
    }
    buff.put((byte) getEngineTotalNumberOfFailures());
    for (Integer item : engineFailuresCodeList) {
      if (item != null) {
        buff.put(item);
      }
    }
    buff.put((byte) getOtherTotalNumberOfFailures());
    for (Integer item : otherFailuresCodeList) {
      if (item != null) {
        buff.put(item);
      }
    }

    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] messageBodyBytes) {
    MyBuffer buff = new MyBuffer(messageBodyBytes);
    setHighestAlarmLevel(buff.get());
    setGeneralAlarmFlag(buff.getInt());
    setRechargeableEnergyStorageDeviceTotalNumberOfFailures(buff.get());
    this.rechargeableEnergyStorageDeviceFailuresCodeList = new ArrayList<>();
    if (GbTools.isEffective(getRechargeableEnergyStorageDeviceTotalNumberOfFailures())) {
      for (int i = 0; i < getRechargeableEnergyStorageDeviceTotalNumberOfFailures(); i++) {
        rechargeableEnergyStorageDeviceFailuresCodeList.add(buff.getInt());
      }
    }

    setDriveMotorTotalNumberOfFailures(buff.get());
    this.driveMotorFailuresCodeList = new ArrayList<>();
    if (GbTools.isEffective(getDriveMotorTotalNumberOfFailures())) {
      for (int i = 0; i < getDriveMotorTotalNumberOfFailures(); i++) {
        driveMotorFailuresCodeList.add(buff.getInt());
      }
    }

    setEngineTotalNumberOfFailures(buff.get());
    this.engineFailuresCodeList = new ArrayList<>();
    if (GbTools.isEffective(getEngineTotalNumberOfFailures())) {
      for (int i = 0; i < getEngineTotalNumberOfFailures(); i++) {
        engineFailuresCodeList.add(buff.getInt());
      }
    }

    setOtherTotalNumberOfFailures(buff.get());
    this.otherFailuresCodeList = new ArrayList<>();
    if (GbTools.isEffective(getOtherTotalNumberOfFailures())) {
      for (int i = 0; i < getOtherTotalNumberOfFailures(); i++) {
        otherFailuresCodeList.add(buff.getInt());
      }
    }
  }

  private static String jsonSplit = ",";

  @Override
  public String toString() {
    StringBuilder sBuilder = new StringBuilder();
    sBuilder.append(String.format("\"%1$s\":%2$s", "报警数据", "{"));

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "最高报警等级", getHighestAlarmLevelString()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "通用报警标志", getGeneralAlarmFlagString()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "可充电储能装置故障总数N1",
        getTotalNumberString(getRechargeableEnergyStorageDeviceTotalNumberOfFailures())));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":%2$s", "可充电储能装置故障代码列表",
        getRechargeableEnergyStorageDeviceFailuresCodeListString()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "驱动电机故障总数N2",
        getTotalNumberString(getDriveMotorTotalNumberOfFailures())));
    sBuilder.append(jsonSplit);

    sBuilder.append(
        String.format("\"%1$s\":%2$s", "驱动电机故障代码列表", getDriveMotorFailuresCodeListString()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "发动机故障总数N3",
        getTotalNumberString(getEngineTotalNumberOfFailures())));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":%2$s", "发动机故障列表", getEngineFailuresCodeListString()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "其他故障总数N4",
        getTotalNumberString(getOtherTotalNumberOfFailures())));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":%2$s", "其他故障代码列表", getOtherFailuresCodeListString()));

    sBuilder.append("}");
    return sBuilder.toString();
  }

  public String getHighestAlarmLevelString() {
    switch (getHighestAlarmLevel()) {
      case 0x00:
        return "无故障";
      case 0x01:
        return "1级故障";
      case 0x02:
        return "2级故障";
      case 0x03:
        return "最高级别故障";
      case 0xFE:
        return "异常";
      case 0xFF:
        return "无效";
      default:
        return "";
    }
  }

  public String getTotalNumberString(int value) {
    switch (value) {
      case 0xFE:
        return "异常";
      case 0xFF:
        return "无效";
      default:
        return String.valueOf(value);
    }
  }

  public String getGeneralAlarmFlagString() {
    //		return $.zerofill(Integer.toBinaryString(getGeneralAlarmFlag()), 32);
    String alarmFlag = StringUtils.zerofill(Integer.toBinaryString(getGeneralAlarmFlag()), 32);
    StringBuilder sBuilder = new StringBuilder();
    sBuilder.append((Byte.parseByte(alarmFlag.substring(31, 32), 10) & 0x1) == 0 ? "正常" : "温度差异报警");
    sBuilder.append(";");
    sBuilder.append((Byte.parseByte(alarmFlag.substring(30, 31), 10) & 0x1) == 0 ? "正常" : "电池高温报警");
    sBuilder.append(";");
    sBuilder
        .append(
                (Byte.parseByte(alarmFlag.substring(29, 30), 10) & 0x1) == 0 ? "正常" : "车载储能装置类型过压报警");
    sBuilder.append(";");
    sBuilder
        .append(
                (Byte.parseByte(alarmFlag.substring(28, 29), 10) & 0x1) == 0 ? "正常" : "车载储能装置类型欠压报警");
    sBuilder.append(";");
    sBuilder.append((Byte.parseByte(alarmFlag.substring(27, 28), 10) & 0x1) == 0 ? "正常" : "SOC低报警");
    sBuilder.append(";");
    sBuilder
            .append((Byte.parseByte(alarmFlag.substring(26, 27), 10) & 0x1) == 0 ? "正常" : "单体电池过压报警");
    sBuilder.append(";");
    sBuilder
            .append((Byte.parseByte(alarmFlag.substring(25, 26), 10) & 0x1) == 0 ? "正常" : "单体电池欠压报警");
    sBuilder.append(";");
    sBuilder
            .append((Byte.parseByte(alarmFlag.substring(24, 25), 10) & 0x1) == 0 ? "正常" : "SOC过高报警");
    sBuilder.append(";");
    sBuilder
            .append((Byte.parseByte(alarmFlag.substring(23, 24), 10) & 0x1) == 0 ? "正常" : "SOC跳变报警");
    sBuilder.append(";");
    sBuilder.append(
            (Byte.parseByte(alarmFlag.substring(22, 23), 10) & 0x1) == 0 ? "正常" : "可充电储能系统不匹配报警");
    sBuilder.append(";");
    sBuilder
            .append((Byte.parseByte(alarmFlag.substring(21, 22), 10) & 0x1) == 0 ? "正常" : "电池单体一致性差报警");
    sBuilder.append(";");
    sBuilder.append((Byte.parseByte(alarmFlag.substring(20, 21), 10) & 0x1) == 0 ? "正常" : "绝缘报警");
    sBuilder.append(";");
    sBuilder
            .append((Byte.parseByte(alarmFlag.substring(19, 20), 10) & 0x1) == 0 ? "正常" : "DC-DC温度报警");
    sBuilder.append(";");
    sBuilder.append((Byte.parseByte(alarmFlag.substring(18, 19), 10) & 0x1) == 0 ? "正常" : "制动系统报警");
    sBuilder.append(";");
    sBuilder
            .append((Byte.parseByte(alarmFlag.substring(17, 18), 10) & 0x1) == 0 ? "正常" : "DC-DC状态报警");
    sBuilder.append(";");
    sBuilder.append(
            (Byte.parseByte(alarmFlag.substring(16, 17), 10) & 0x1) == 0 ? "正常" : "驱动电机控制器温度报警");
    sBuilder.append(";");
    sBuilder
            .append((Byte.parseByte(alarmFlag.substring(15, 16), 10) & 0x1) == 0 ? "正常" : "高压互锁状态报警");
    sBuilder.append(";");
    sBuilder
            .append((Byte.parseByte(alarmFlag.substring(14, 15), 10) & 0x1) == 0 ? "正常" : "驱动电机温度报警");
    sBuilder.append(";");
    sBuilder
            .append((Byte.parseByte(alarmFlag.substring(13, 14), 10) & 0x1) == 0 ? "正常" : "车载储能装置类型过充");
    return sBuilder.toString();
  }

  public String getRechargeableEnergyStorageDeviceFailuresCodeListString() {
    StringBuilder sBuilder = new StringBuilder();
    sBuilder.append("[");
    if (getRechargeableEnergyStorageDeviceFailuresCodeList().size() > 0) {
      for (int i = 0, length = getRechargeableEnergyStorageDeviceFailuresCodeList().size();
          i < length; i++) {
        int item = getRechargeableEnergyStorageDeviceFailuresCodeList().get(i);
        sBuilder.append(item);
        if (i != length - 1) {
          sBuilder.append(jsonSplit);
        }
      }
    }
    sBuilder.append("]");
    return sBuilder.toString();
  }

  public String getEngineFailuresCodeListString() {
    StringBuilder sBuilder = new StringBuilder();
    sBuilder.append("[");
    if (getEngineFailuresCodeList().size() > 0) {
      for (int i = 0, length = getEngineFailuresCodeList().size(); i < length; i++) {
        int item = getEngineFailuresCodeList().get(i);
        sBuilder.append(item);
        if (i != length - 1) {
          sBuilder.append(jsonSplit);
        }
      }
    }
    sBuilder.append("]");
    return sBuilder.toString();
  }

  public String getDriveMotorFailuresCodeListString() {
    StringBuilder sBuilder = new StringBuilder();
    sBuilder.append("[");
    if (getDriveMotorFailuresCodeList().size() > 0) {
      for (int i = 0, length = getDriveMotorFailuresCodeList().size(); i < length; i++) {
        int item = getDriveMotorFailuresCodeList().get(i);
        sBuilder.append(item);
        if (i != length - 1) {
          sBuilder.append(jsonSplit);
        }
      }
    }
    sBuilder.append("]");
    return sBuilder.toString();
  }

  public String getOtherFailuresCodeListString() {
    StringBuilder sBuilder = new StringBuilder();
    sBuilder.append("[");
    if (getOtherFailuresCodeList().size() > 0) {
      for (int i = 0, length = getOtherFailuresCodeList().size(); i < length; i++) {
        int item = getOtherFailuresCodeList().get(i);
        sBuilder.append(item);
        if (i != length - 1) {
          sBuilder.append(jsonSplit);
        }
      }
    }
    sBuilder.append("]");
    return sBuilder.toString();
  }
}
