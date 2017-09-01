package com.ccclubs.protocol.dto.gb;

import com.ccclubs.protocol.inf.IRealTimeAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * 可充电储能装置温度数据
 *
 * @author qsxiaogang
 */
public class GB_02_09 implements IRealTimeAdditionalItem {

  /**
   * 可充电储能子系统个数 : N个可充电储能装置，有效值范围：1～250，“0xFE”表示异常，“0xFF”表示无效。
   */
  private int rechargeableEnergyStorageSubsystemsTotalNumber;
  /**
   * 可充电储能子系统温度信息列表 : 按可充电储能子系统代号依次排列，每个可充电储能子系统温度分布数据格式和定义见表B.8。
   */
  private List<GB_02_09_Item> assemblyList;

  @Override
  public int getAdditionalId() {
    return 0x09;
  }

  @Override
  public int getAdditionalLength() {
    return -1;
  }

  public int getRechargeableEnergyStorageSubsystemsTotalNumber() {
    return rechargeableEnergyStorageSubsystemsTotalNumber & 0xFF;
  }

  public void setRechargeableEnergyStorageSubsystemsTotalNumber(
      int rechargeableEnergyStorageSubsystemsTotalNumber) {
    this.rechargeableEnergyStorageSubsystemsTotalNumber = rechargeableEnergyStorageSubsystemsTotalNumber;
  }

  public List<GB_02_09_Item> getAssemblyList() {
    return assemblyList;
  }

  public void setAssemblyList(List<GB_02_09_Item> assemblyList) {
    this.assemblyList = assemblyList;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((byte) getRechargeableEnergyStorageSubsystemsTotalNumber());
    for (GB_02_09_Item item : assemblyList) {
      if (item != null) {
        buff.put(item.WriteToBytes());
      }
    }

    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] messageBodyBytes) {
    MyBuffer buff = new MyBuffer(messageBodyBytes);
    this.assemblyList = new ArrayList<>();
    setRechargeableEnergyStorageSubsystemsTotalNumber(buff.get());
    int rechargeableEnergyStorageTotalNumber = getRechargeableEnergyStorageSubsystemsTotalNumber();

    int pos = 1;
    for (int i = 0; i < rechargeableEnergyStorageTotalNumber; i++) {
      byte[] subBytes = new byte[messageBodyBytes.length - pos];
      System.arraycopy(messageBodyBytes, pos, subBytes, 0, subBytes.length);

      GB_02_09_Item item = new GB_02_09_Item();
      item.ReadFromBytes(subBytes);
      if (item != null) {
        getAssemblyList().add(item);
        pos = pos + item.WriteToBytes().length;
      }
    }
  }

  private static String jsonSplit = ",";

  @Override
  public String toString() {
    StringBuilder sBuilder = new StringBuilder();
    sBuilder.append(String.format("\"%1$s\":%2$s", "可充电储能装置温度数", "{"));

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "可充电储能子系统个数",
        getDataString(getRechargeableEnergyStorageSubsystemsTotalNumber())));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":[", "可充电储能子系统温度信息列表"));

    if (assemblyList.size() > 0) {
      for (int i = 0; i < assemblyList.size(); i++) {
        GB_02_09_Item item = assemblyList.get(i);
        sBuilder.append(item.toString());
        if (i != assemblyList.size() - 1) {
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
