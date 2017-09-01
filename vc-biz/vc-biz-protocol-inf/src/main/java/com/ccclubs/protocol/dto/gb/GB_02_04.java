package com.ccclubs.protocol.dto.gb;

import com.ccclubs.protocol.inf.IRealTimeAdditionalItem;
import com.ccclubs.protocol.util.AccurateOperationUtils;
import com.ccclubs.protocol.util.MyBuffer;
import java.math.BigDecimal;

/**
 * 发动机数据
 *
 * @author qsxiaogang
 */
public class GB_02_04 implements IRealTimeAdditionalItem {

  /**
   * 发动机状态；0x01：启动状态；0x02：关闭状态，“0xFE”表示异常，“0xFF”表示无效。
   */
  private int engineStatus;
  /**
   * 曲轴转速；有效范围：0～60000(表示0rpm～60000rpm)，最小计量单元：1rpm，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
   */
  private int crankshaftSpeed;
  /**
   * 燃料消耗率；有效值范围：0～60000（表示0L/100km～600L/100km），最小计量单元：0.01L/100km，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
   */
  private int fuelConsumptionRate;

  @Override
  public int getAdditionalId() {
    return 0x04;
  }

  @Override
  public int getAdditionalLength() {
    return 5;
  }

  public int getEngineStatus() {
    return engineStatus & 0xFF;
  }

  public void setEngineStatus(int engineStatus) {
    this.engineStatus = engineStatus;
  }

  public int getCrankshaftSpeed() {
    return crankshaftSpeed & 0xFFFF;
  }

  public void setCrankshaftSpeed(int crankshaftSpeed) {
    this.crankshaftSpeed = crankshaftSpeed;
  }

  public int getFuelConsumptionRate() {
    return fuelConsumptionRate & 0xFFFF;
  }

  public void setFuelConsumptionRate(int fuelConsumptionRate) {
    this.fuelConsumptionRate = fuelConsumptionRate;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((byte) getEngineStatus());
    buff.put((short) getCrankshaftSpeed());
    buff.put((short) getFuelConsumptionRate());

    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] messageBodyBytes) {
    MyBuffer buff = new MyBuffer(messageBodyBytes);
    setEngineStatus(buff.get());
    setCrankshaftSpeed(buff.getShort());
    setFuelConsumptionRate(buff.getShort());
  }

  private static String jsonSplit = ",";

  @Override
  public String toString() {
    StringBuilder sBuilder = new StringBuilder();
    sBuilder.append(String.format("\"%1$s\":%2$s", "发动机数据", "{"));

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "发动机状态", getEngineStatusString()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "曲轴转速", getEngineStatusString()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "燃料消耗率", getFuelConsumptionRateString()));

    sBuilder.append("}");
    return sBuilder.toString();
  }

  public String getEngineStatusString() {
    switch (getEngineStatus()) {
      case 0x01:
        return "启动状态";
      case 0x02:
        return "关闭状态";
      case 0xFE:
        return "异常";
      case 0xFF:
        return "无效";
      default:
        return "";
    }
  }

  public String getCrankshaftSpeedString() {
    switch (getCrankshaftSpeed()) {
      case 0xFFFE:
        return "异常";
      case 0xFFFF:
        return "无效";
      default:
        return String.valueOf(getCrankshaftSpeed()) + "rpm";
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
        return bigDecimal.toString() + "L/100km";
    }
  }
}
