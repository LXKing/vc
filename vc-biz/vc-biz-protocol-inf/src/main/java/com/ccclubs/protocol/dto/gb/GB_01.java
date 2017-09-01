package com.ccclubs.protocol.dto.gb;


import com.ccclubs.protocol.inf.IGbMessage;
import com.ccclubs.protocol.util.MyBuffer;
import com.ccclubs.protocol.util.StringUtils;

/**
 * 车辆登入
 *
 * @author qsxiaogang
 */
public class GB_01 implements IGbMessage {

  /**
   * 数据采集时间
   */
  private String time;
  /**
   * 登入流水号 : 车载终端每登入一次，登入流水号自动加1，从1开始循环累加，最大值为65531，循环周期为天。
   */
  private int loginSerialNo;
  /**
   * ICCID : SIM卡ICCID号（ICCID应为终端从SIM卡获取的值，不应人为填写或修改）
   */
  private String iccid;

  /**
   * 可充电储能子系统数 : 可充电储能子系统数n，有效值范围：0～250。
   */
  private int rechargeableEnergyStorageSubsystemsTotalNumber;
  /**
   * 可充电储能系统编码长度 : 可充电储能系统编码长度m，有效范围：0～50，“0”表示不上传该编码
   */
  private int rechargeableEnergyStorageSubsystemsSingleCodeLength;
  /**
   * 可充电储能系统编码 : n*m 可充电储能系统编码宜为终端从车辆获取的值。
   */
  private String rechargeableEnergyStorageSubsystemsCode;

  @Override
  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public int getLoginSerialNo() {
    return loginSerialNo & 0xFFFF;
  }

  public void setLoginSerialNo(int loginSerialNo) {
    this.loginSerialNo = loginSerialNo;
  }

  public String getIccid() {
    return iccid;
  }

  public void setIccid(String iccid) {
    this.iccid = iccid;
  }

  public int getRechargeableEnergyStorageSubsystemsTotalNumber() {
    return rechargeableEnergyStorageSubsystemsTotalNumber & 0xFF;
  }

  public void setRechargeableEnergyStorageSubsystemsTotalNumber(
      int rechargeableEnergyStorageSubsystemsTotalNumber) {
    this.rechargeableEnergyStorageSubsystemsTotalNumber = rechargeableEnergyStorageSubsystemsTotalNumber;
  }

  public int getRechargeableEnergyStorageSubsystemsSingleCodeLength() {
    return rechargeableEnergyStorageSubsystemsSingleCodeLength;
  }

  public void setRechargeableEnergyStorageSubsystemsSingleCodeLength(
      int rechargeableEnergyStorageSubsystemsSingleCodeLength) {
    this.rechargeableEnergyStorageSubsystemsSingleCodeLength = rechargeableEnergyStorageSubsystemsSingleCodeLength;
  }

  public String getRechargeableEnergyStorageSubsystemsCode() {
    return rechargeableEnergyStorageSubsystemsCode;
  }

  public void setRechargeableEnergyStorageSubsystemsCode(
      String rechargeableEnergyStorageSubsystemsCode) {
    this.rechargeableEnergyStorageSubsystemsCode = rechargeableEnergyStorageSubsystemsCode;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(Byte.parseByte(getTime().substring(2, 4), 10));
    buff.put(Byte.parseByte(getTime().substring(5, 7), 10));
    buff.put(Byte.parseByte(getTime().substring(8, 10), 10));
    buff.put(Byte.parseByte(getTime().substring(11, 13), 10));
    buff.put(Byte.parseByte(getTime().substring(14, 16), 10));
    buff.put(Byte.parseByte(getTime().substring(17, 19), 10));

    buff.put((short) getLoginSerialNo());
    while (iccid.length() < 20) {
      iccid = "0" + iccid;
    }
    buff.put((new String(iccid)));
    buff.put((byte) getRechargeableEnergyStorageSubsystemsTotalNumber());
    buff.put((byte) getRechargeableEnergyStorageSubsystemsSingleCodeLength());
    if (!StringUtils.empty(getRechargeableEnergyStorageSubsystemsCode())) {
      buff.put((new String(getRechargeableEnergyStorageSubsystemsCode())));
    }
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] messageBodyBytes) {
    MyBuffer buff = new MyBuffer(messageBodyBytes);
    byte[] timeBytes = buff.gets(6);
    setTime(
        "20" + String.format("%02d", timeBytes[0]) + "-" + String.format("%02d", timeBytes[1]) + "-"
            + String.format("%02d", timeBytes[2]) + " "
            + String.format("%02d", timeBytes[3]) + ":" + String.format("%02d", timeBytes[4]) + ":"
            + String.format("%02d", timeBytes[5]));

    setLoginSerialNo(buff.getShort());
    byte[] iccidBytes = buff.gets(20);
    setIccid(new String(iccidBytes));
    setRechargeableEnergyStorageSubsystemsTotalNumber(buff.get());
    setRechargeableEnergyStorageSubsystemsSingleCodeLength(buff.get());
    int totalLength = getRechargeableEnergyStorageSubsystemsTotalNumber()
        * getRechargeableEnergyStorageSubsystemsSingleCodeLength();
    if (totalLength > 0) {
      byte[] subsystemsCodeBytes = buff.gets(totalLength);
      setRechargeableEnergyStorageSubsystemsCode(new String(subsystemsCodeBytes));
    }
  }

  private static String jsonSplit = ",";

  @Override
  public String toString() {
    StringBuilder sBuilder = new StringBuilder();
    sBuilder.append(String.format("\"%1$s\":%2$s", "数据单元", "{"));

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "数据采集时间", getTime()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "登入流水号", getLoginSerialNo()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "ICCID", getIccid()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "可充电储能子系统数",
        getRechargeableEnergyStorageSubsystemsTotalNumber()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "可充电储能系统编码长度",
        getRechargeableEnergyStorageSubsystemsSingleCodeLength()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String
        .format("\"%1$s\":\"%2$s\"", "可充电储能系统编码", getRechargeableEnergyStorageSubsystemsCode()));

    sBuilder.append("}");
    return sBuilder.toString();
  }
}
