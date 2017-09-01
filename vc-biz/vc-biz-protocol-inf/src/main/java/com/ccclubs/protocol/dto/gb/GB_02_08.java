package com.ccclubs.protocol.dto.gb;

import com.ccclubs.protocol.inf.IRealTimeAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;
import java.util.ArrayList;
import java.util.List;

public class GB_02_08 implements IRealTimeAdditionalItem {

  /**
   * 可充电储能子系统个数；N个可充电储能子系统，有效值范围：1～250，“0xFE”表示异常，“0xFF”表示无效。
   */
  private int chargeEnergyStoreSubSystemNumber;
  /**
   * 可充电储能子系统电压信息列表，按可充电储能子系统序号依次排列
   */
  private List<GB_02_08_Item> chargeEnergyStoreSubSystemVoltageList;

  public int getChargeEnergyStoreSubSystemNumber() {
    return chargeEnergyStoreSubSystemNumber & 0xFF;
  }

  public void setChargeEnergyStoreSubSystemNumber(int chargeEnergyStoreSubSystemNumber) {
    this.chargeEnergyStoreSubSystemNumber = chargeEnergyStoreSubSystemNumber;
  }

  public List<GB_02_08_Item> getChargeEnergyStoreSubSystemVoltageList() {
    return chargeEnergyStoreSubSystemVoltageList;
  }

  public void setChargeEnergyStoreSubSystemVoltageList(
      List<GB_02_08_Item> chargeEnergyStoreSubSystemVoltageList) {
    this.chargeEnergyStoreSubSystemVoltageList = chargeEnergyStoreSubSystemVoltageList;
  }

  @Override
  public int getAdditionalId() {
    return 0x08;
  }

  @Override
  public int getAdditionalLength() {
    return -1;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((byte) getChargeEnergyStoreSubSystemNumber());
    for (GB_02_08_Item item : chargeEnergyStoreSubSystemVoltageList) {
      if (item != null) {
        buff.put(item.WriteToBytes());
      }
    }

    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] messageBodyBytes) {
    MyBuffer buff = new MyBuffer(messageBodyBytes);
    this.chargeEnergyStoreSubSystemVoltageList = new ArrayList<>();
    setChargeEnergyStoreSubSystemNumber(buff.get());
    int cessNumber = getChargeEnergyStoreSubSystemNumber();

    int pos = 1;
    for (int i = 0; i < cessNumber; i++) {
      byte[] subBytes = new byte[messageBodyBytes.length - pos];
      System.arraycopy(messageBodyBytes, pos, subBytes, 0, subBytes.length);

      GB_02_08_Item item = new GB_02_08_Item();
      item.ReadFromBytes(subBytes);
      if (item != null) {
        getChargeEnergyStoreSubSystemVoltageList().add(item);
        pos = pos + item.WriteToBytes().length;
      }
    }
  }

  private static String jsonSplit = ",";

  @Override
  public String toString() {
    StringBuilder sBuilder = new StringBuilder();
    sBuilder.append(String.format("\"%1$s\":%2$s", "可充电储能装置电压数据", "{"));

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "可充电储能子系统个数",
        getDataString(getChargeEnergyStoreSubSystemNumber())));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":[", "可充电储能子系统电压信息列表"));

    if (chargeEnergyStoreSubSystemVoltageList.size() > 0) {
      for (int i = 0; i < chargeEnergyStoreSubSystemVoltageList.size(); i++) {
        GB_02_08_Item item = chargeEnergyStoreSubSystemVoltageList.get(i);
        sBuilder.append(item.toString());
        if (i != chargeEnergyStoreSubSystemVoltageList.size() - 1) {
          sBuilder.append(jsonSplit);
        }
      }
    }
    sBuilder.append("]");

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
}
