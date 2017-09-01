package com.ccclubs.protocol.dto.gb;

import com.ccclubs.protocol.inf.IMessageBody;
import com.ccclubs.protocol.util.AccurateOperationUtils;
import com.ccclubs.protocol.util.MyBuffer;
import java.math.BigDecimal;

public class GB_02_02_Item implements IMessageBody {

  /**
   * 驱动电机序号；有效值范围1～253
   */
  private int driveMotorSerial;
  /**
   * 驱动电机状态；0x01：耗电；0x02：发电；0x03：关闭状态；0x04：准备状态“0xFE”表示异常，“0xFF”表示无效。
   */
  private int driveMotorStatus;
  /**
   * 驱动电机控制器温度；有效值范围：0～250 （数值偏移量40℃，表示-40℃～+210℃），最小计量单元：1℃，“0xFE”表示异常，“0xFF”表示无效。
   */
  private int driveMotorControllerTemperature;
  /**
   * 驱动电机转速；有效值范围：0～65531（数值偏移量20000表示-20000 r/min～45531r/min），最小计量单元：1r/min，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
   */
  private int driveMotorSpeed;
  /**
   * 驱动电机转矩；有效值范围：0～65531（数值偏移量20000表示-2000N*m～4553.1N*m），最小计量单元：0.1N*m，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
   */
  private int driveMotorTorque;
  /**
   * 驱动电机温度；有效值范围：0～250 （数值偏移量40℃，表示-40℃～+210℃），最小计量单元：1℃，“0xFE”表示异常，“0xFF”表示无效。
   */
  private int driveMotorTemperature;
  /**
   * 电机控制器输入电压；有效值范围：0～60000（表示0V～6000V），最小计量单元：0.1V，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
   */
  private int motorInputVoltage;
  /**
   * 电机控制器直流母线电流；有效值范围： 0～20000（数值偏移量1000A，表示-1000A～+1000A），最小计量单元：0.1A，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
   */
  private int motorControllerDCBusCurrent;

  public int getDriveMotorSerial() {
    return driveMotorSerial & 0xFF;
  }

  public void setDriveMotorSerial(int driveMotorSerial) {
    this.driveMotorSerial = driveMotorSerial;
  }

  public int getDriveMotorStatus() {
    return driveMotorStatus & 0xFF;
  }

  public void setDriveMotorStatus(int driveMotorStatus) {
    this.driveMotorStatus = driveMotorStatus;
  }

  public int getDriveMotorControllerTemperature() {
    return driveMotorControllerTemperature & 0xFF;
  }

  public void setDriveMotorControllerTemperature(int driveMotorControllerTemperature) {
    this.driveMotorControllerTemperature = driveMotorControllerTemperature;
  }

  public int getDriveMotorSpeed() {
    return driveMotorSpeed & 0xFFFF;
  }

  public void setDriveMotorSpeed(int driveMotorSpeed) {
    this.driveMotorSpeed = driveMotorSpeed;
  }

  public int getDriveMotorTorque() {
    return driveMotorTorque & 0xFFFF;
  }

  public void setDriveMotorTorque(int driveMotorTorque) {
    this.driveMotorTorque = driveMotorTorque;
  }

  public int getDriveMotorTemperature() {
    return driveMotorTemperature & 0xFF;
  }

  public void setDriveMotorTemperature(int driveMotorTemperature) {
    this.driveMotorTemperature = driveMotorTemperature;
  }

  public int getMotorInputVoltage() {
    return motorInputVoltage & 0xFFFF;
  }

  public void setMotorInputVoltage(int motorInputVoltage) {
    this.motorInputVoltage = motorInputVoltage;
  }

  public int getMotorControllerDCBusCurrent() {
    return motorControllerDCBusCurrent & 0xFFFF;
  }

  public void setMotorControllerDCBusCurrent(int motorControllerDCBusCurrent) {
    this.motorControllerDCBusCurrent = motorControllerDCBusCurrent;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((byte) getDriveMotorSerial());
    buff.put((byte) getDriveMotorStatus());
    buff.put((byte) getDriveMotorControllerTemperature());
    buff.put((short) getDriveMotorSpeed());
    buff.put((short) getDriveMotorTorque());
    buff.put((byte) getDriveMotorTemperature());
    buff.put((short) getMotorInputVoltage());
    buff.put((short) getMotorControllerDCBusCurrent());

    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] messageBodyBytes) {
    MyBuffer buff = new MyBuffer(messageBodyBytes);
    setDriveMotorSerial(buff.get());
    setDriveMotorStatus(buff.get());
    setDriveMotorControllerTemperature(buff.get());
    setDriveMotorSpeed(buff.getShort());
    setDriveMotorTorque(buff.getShort());
    setDriveMotorTemperature(buff.get());
    setMotorInputVoltage(buff.getShort());
    setMotorControllerDCBusCurrent(buff.getShort());
  }

  private static String jsonSplit = ",";

  @Override
  public String toString() {
    StringBuilder sBuilder = new StringBuilder();
    sBuilder.append("{");

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "驱动电机序号", getDriveMotorSerial()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "驱动电机状态", getDriveMotorStatusString()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String
        .format("\"%1$s\":\"%2$s\"", "驱动电机控制器温度", getDriveMotorControllerTemperatureString()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "驱动电机转速", getDriveMotorSpeedString()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "驱动电机转矩", getDriveMotorTorqueString()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "驱动电机温度", getDriveMotorTemperatureString()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "电机控制器输入电压", getMotorInputVoltageString()));
    sBuilder.append(jsonSplit);

    sBuilder.append(
        String.format("\"%1$s\":\"%2$s\"", "电机控制器直流母线电流", getMotorControllerDCBusCurrentString()));

    sBuilder.append("}");
    return sBuilder.toString();
  }

  public String getDriveMotorStatusString() {
    switch (getDriveMotorStatus()) {
      case 0x01:
        return "耗电";
      case 0x02:
        return "发电";
      case 0x03:
        return "关闭状态";
      case 0x04:
        return "准备状态";
      case 0xFE:
        return "异常";
      case 0xFF:
        return "无效";
      default:
        return "";
    }
  }

  public String getDriveMotorControllerTemperatureString() {
    switch (getDriveMotorControllerTemperature()) {
      case 0xFE:
        return "异常";
      case 0xFF:
        return "无效";
      default:
        return String.valueOf(getDriveMotorControllerTemperature() - 40) + "℃";
    }
  }

  public String getDriveMotorSpeedString() {
    switch (getDriveMotorSpeed()) {
      case 0xFE:
        return "异常";
      case 0xFF:
        return "无效";
      default:
        return String.valueOf(getDriveMotorSpeed() - 20000) + "r/min";
    }
  }

  public String getDriveMotorTorqueString() {
    switch (getDriveMotorTorque()) {
      case 0xFFFE:
        return "异常";
      case 0xFFFF:
        return "无效";
      default:
        BigDecimal bigDecimal = AccurateOperationUtils
            .sub(AccurateOperationUtils.mul(getDriveMotorTorque(), 0.1).doubleValue(), 2000);
        bigDecimal = bigDecimal.setScale(1);
        return bigDecimal.toString() + "N*m";
    }
  }

  public String getDriveMotorTemperatureString() {
    switch (getDriveMotorTemperature()) {
      case 0xFE:
        return "异常";
      case 0xFF:
        return "无效";
      default:
        return String.valueOf(getDriveMotorTemperature() - 40) + "℃";
    }
  }

  public String getMotorInputVoltageString() {
    switch (getMotorInputVoltage()) {
      case 0xFFFE:
        return "异常";
      case 0xFFFF:
        return "无效";
      default:
        BigDecimal bigDecimal = AccurateOperationUtils.mul(getMotorInputVoltage(), 0.1);
        bigDecimal = bigDecimal.setScale(1);
        return bigDecimal + "V";
    }
  }

  public String getMotorControllerDCBusCurrentString() {
    switch (getMotorControllerDCBusCurrent()) {
      case 0xFFFE:
        return "异常";
      case 0xFFFF:
        return "无效";
      default:
        BigDecimal bigDecimal = AccurateOperationUtils
            .sub(AccurateOperationUtils.mul(getMotorControllerDCBusCurrent(), 0.1).doubleValue(),
                1000);
        bigDecimal = bigDecimal.setScale(1);
        return bigDecimal.toString() + "A";
    }
  }
}
