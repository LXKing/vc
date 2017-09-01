package com.ccclubs.protocol.dto.gb;

import com.ccclubs.protocol.inf.IRealTimeAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * 驱动电机数据
 *
 * @author qsxiaogang
 */
public class GB_02_02 implements IRealTimeAdditionalItem {

  /**
   * 驱动电机个数；有效值1～253
   */
  private int driveMotorNumber;
  /**
   * 驱动电机总成信息列表，按驱动电机序号依次排列
   */
  private List<GB_02_02_Item> assemblyList;

  @Override
  public int getAdditionalId() {
    return 0x02;
  }

  @Override
  public int getAdditionalLength() {
    return -1;
  }

  public int getDriveMotorNumber() {
    return driveMotorNumber & 0xFF;
  }

  public void setDriveMotorNumber(int driveMotorNumber) {
    this.driveMotorNumber = driveMotorNumber;
  }

  public List<GB_02_02_Item> getAssemblyList() {
    return assemblyList;
  }

  public void setAssemblyList(List<GB_02_02_Item> assemblyList) {
    this.assemblyList = assemblyList;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((byte) getDriveMotorNumber());
    for (GB_02_02_Item item : assemblyList) {
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
    setDriveMotorNumber(buff.get());
    for (int i = 0; i < getDriveMotorNumber(); i++) {
      byte[] subBytes = new byte[12];
      System.arraycopy(messageBodyBytes, 1, subBytes, 0, subBytes.length);

      GB_02_02_Item item = new GB_02_02_Item();
      item.ReadFromBytes(subBytes);
      if (item != null) {
        getAssemblyList().add(item);
      }
    }
  }

  private static String jsonSplit = ",";

  @Override
  public String toString() {
    StringBuilder sBuilder = new StringBuilder();
    sBuilder.append(String.format("\"%1$s\":%2$s", "驱动电机数据", "{"));

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "驱动电机个数", getDriveMotorNumber()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":[", "驱动电机总成信息列表"));

    if (assemblyList.size() > 0) {
      for (int i = 0, length = assemblyList.size(); i < length; i++) {
        GB_02_02_Item item = assemblyList.get(i);
        sBuilder.append(item.toString());
        if (i != length - 1) {
          sBuilder.append(jsonSplit);
        }
      }
    }

    sBuilder.append("]");
    sBuilder.append("}");
    return sBuilder.toString();
  }
}
