package com.ccclubs.protocol.dto.gb;

import com.ccclubs.protocol.inf.IMessageBody;
import com.ccclubs.protocol.util.AccurateOperationUtils;
import com.ccclubs.protocol.util.GbTools;
import com.ccclubs.protocol.util.MyBuffer;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GB_02_08_Item implements IMessageBody {

  /**
   * 可充电储能子系统号；有效值范围：1～250。
   */
  private int chargeEnergyStoreSerial;
  /**
   * 可充电储能装置电压；有效值范围：0～10000（表示0V～1000V），最小计量单元：0.1V，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
   */
  private int chargeEnergyStoreVoltage;
  /**
   * 可充电储能装置电流；有效值范围： 0～20000（数值偏移量1000A，表示-1000A～+1000A），最小计量单元：0.1A，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
   */
  private int chargeEnergyStoreCurrent;
  /**
   * 单体电池总数；N个电池单体，有效值范围：1～65531，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
   */
  private int monomerBatteryNumber;
  /**
   * 本帧起始电池序号；当本帧单体个数超过200时，应拆分成多帧数据进行传输，有效值范围：1～65531。
   */
  private int frameStartBatterySerial;
  /**
   * 本帧单体电池总数；本帧单体总数 m;有效值范围：1～200。
   */
  private int frameStartBatteryNumber;
  /**
   * 单体电池电压；有效值范围：0～60000（表示0V～60.000V），最小计量单元：0.001V，单体电池电压个数等于本帧单体电池总数m，“0xFF,0xFE”表示异常，“0xFF,0xFF”表示无效。
   */
  private List<Short> monomerBatteryVoltageList;

  public int getChargeEnergyStoreSerial() {
    return chargeEnergyStoreSerial & 0xFF;
  }

  public void setChargeEnergyStoreSerial(int chargeEnergyStoreSerial) {
    this.chargeEnergyStoreSerial = chargeEnergyStoreSerial;
  }

  public int getChargeEnergyStoreVoltage() {
    return chargeEnergyStoreVoltage & 0xFFFF;
  }

  public void setChargeEnergyStoreVoltage(int chargeEnergyStoreVoltage) {
    this.chargeEnergyStoreVoltage = chargeEnergyStoreVoltage;
  }

  public int getChargeEnergyStoreCurrent() {
    return chargeEnergyStoreCurrent & 0xFFFF;
  }

  public void setChargeEnergyStoreCurrent(int chargeEnergyStoreCurrent) {
    this.chargeEnergyStoreCurrent = chargeEnergyStoreCurrent;
  }

  public int getMonomerBatteryNumber() {
    return monomerBatteryNumber & 0xFFFF;
  }

  public void setMonomerBatteryNumber(int monomerBatteryNumber) {
    this.monomerBatteryNumber = monomerBatteryNumber;
  }

  public int getFrameStartBatterySerial() {
    return frameStartBatterySerial & 0xFFFF;
  }

  public void setFrameStartBatterySerial(int frameStartBatterySerial) {
    this.frameStartBatterySerial = frameStartBatterySerial;
  }

  public int getFrameStartBatteryNumber() {
    return frameStartBatteryNumber & 0xFF;
  }

  public void setFrameStartBatteryNumber(int frameStartBatteryNumber) {
    this.frameStartBatteryNumber = frameStartBatteryNumber;
  }

  public List<Short> getMonomerBatteryVoltageList() {
    return monomerBatteryVoltageList;
  }

  public void setMonomerBatteryVoltageList(List<Short> monomerBatteryVoltageList) {
    this.monomerBatteryVoltageList = monomerBatteryVoltageList;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((byte) getChargeEnergyStoreSerial());
    buff.put((short) getChargeEnergyStoreVoltage());
    buff.put((short) getChargeEnergyStoreCurrent());
    buff.put((short) getMonomerBatteryNumber());
    buff.put((short) getFrameStartBatterySerial());
    buff.put((byte) getFrameStartBatteryNumber());
    for (Short item : monomerBatteryVoltageList) {
      if (item != null) {
        buff.put(item);
      }
    }

    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] messageBodyBytes) {
    MyBuffer buff = new MyBuffer(messageBodyBytes);
    setChargeEnergyStoreSerial(buff.get());
    setChargeEnergyStoreVoltage(buff.getShort());
    setChargeEnergyStoreCurrent(buff.getShort());
    setMonomerBatteryNumber(buff.getShort());
    setFrameStartBatterySerial(buff.getShort());
    setFrameStartBatteryNumber(buff.get());
    this.monomerBatteryVoltageList = new ArrayList<>();
    if (GbTools.isEffective(getFrameStartBatteryNumber())) {
      for (int i = 0; i < getFrameStartBatteryNumber(); i++) {
        monomerBatteryVoltageList.add(buff.getShort());
      }
    }
  }

  private static String jsonSplit = ",";

  @Override
  public String toString() {
    StringBuilder sBuilder = new StringBuilder();
    sBuilder.append("{");

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "可充电储能子系统号", getChargeEnergyStoreSerial()));
    sBuilder.append(jsonSplit);

    sBuilder.append(
        String.format("\"%1$s\":\"%2$s\"", "可充电储能装置电压", getChargeEnergyStoreVoltageString()));
    sBuilder.append(jsonSplit);

    sBuilder.append(
        String.format("\"%1$s\":\"%2$s\"", "可充电储能装置电流", getChargeEnergyStoreCurrentString()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "单体电池总数", getMonomerBatteryNumberString()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "本帧起始电池序号", getFrameStartBatterySerial()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "本帧单体电池总数", getFrameStartBatteryNumber()));
    sBuilder.append(jsonSplit);

    sBuilder
        .append(String.format("\"%1$s\":\"%2$s\"", "单体电池电压", getMonomerBatteryVoltageListString()));

    sBuilder.append("}");
    return sBuilder.toString();
  }

  public String getChargeEnergyStoreVoltageString() {
    switch (getChargeEnergyStoreVoltage()) {
      case 0xFFFE:
        return "异常";
      case 0xFFFF:
        return "无效";
      default:
        BigDecimal bigDecimal = AccurateOperationUtils.mul(getChargeEnergyStoreVoltage(), 0.1);
        bigDecimal = bigDecimal.setScale(1);
        return bigDecimal.toString() + "V";
    }
  }

  public String getChargeEnergyStoreCurrentString() {
    switch (getChargeEnergyStoreCurrent()) {
      case 0xFFFE:
        return "异常";
      case 0xFFFF:
        return "无效";
      default:
        BigDecimal bigDecimal = AccurateOperationUtils
            .sub(AccurateOperationUtils.mul(getChargeEnergyStoreCurrent(), 0.1).doubleValue(),
                1000);
        bigDecimal = bigDecimal.setScale(1);
        return bigDecimal.toString() + "A";
    }
  }

  public String getMonomerBatteryVoltageListString() {
    StringBuilder sBuilder = new StringBuilder();
    sBuilder.append("[");
    if (getMonomerBatteryVoltageList().size() > 0) {
      for (int i = 0; i < getMonomerBatteryVoltageList().size(); i++) {
        int item = getMonomerBatteryVoltageList().get(i);
        sBuilder.append(getMonomerBatteryVoltageItemString(item));
        if (i != getMonomerBatteryVoltageList().size() - 1) {
          sBuilder.append(jsonSplit);
        }
      }
    }
    sBuilder.append("]");
    return sBuilder.toString();
  }

  public String getMonomerBatteryVoltageItemString(int value) {
    if (value < 0) {
      value = (value & 0xFFFF);
    }
    switch (value) {
      case 0xFFFE:
        return "异常";
      case 0xFFFF:
        return "无效";
      default:
        BigDecimal bigDecimal = AccurateOperationUtils.mul(value, 0.001);
        bigDecimal = bigDecimal.setScale(3, BigDecimal.ROUND_HALF_UP);
        return bigDecimal.toString() + "V";
    }
  }

  public String getMonomerBatteryNumberString() {
    switch (getMonomerBatteryNumber()) {
      case 0xFFFE:
        return "异常";
      case 0xFFFF:
        return "无效";
      default:
        return String.valueOf(getMonomerBatteryNumber());
    }
  }
}
