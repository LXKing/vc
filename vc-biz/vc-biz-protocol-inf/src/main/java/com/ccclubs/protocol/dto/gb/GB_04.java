package com.ccclubs.protocol.dto.gb;


import com.ccclubs.protocol.inf.IGbMessage;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * 车辆登出
 *
 * @author qsxiaogang
 */
public class GB_04 implements IGbMessage {

  /**
   * 数据采集时间
   */
  private String time;
  /**
   * 登出流水号 : 登出流水号与当次登入流水号一致。
   */
  private int loginOutSerialNo;

  @Override
  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public int getLoginOutSerialNo() {
    return loginOutSerialNo & 0xFFFF;
  }

  public void setLoginOutSerialNo(int loginOutSerialNo) {
    this.loginOutSerialNo = loginOutSerialNo;
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
    buff.put((short) getLoginOutSerialNo());
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

    setLoginOutSerialNo(buff.getShort());
  }

  private static String jsonSplit = ",";

  @Override
  public String toString() {
    StringBuilder sBuilder = new StringBuilder();
    sBuilder.append(String.format("\"%1$s\":%2$s", "数据单元", "{"));

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "登出时间", getTime()));
    sBuilder.append(jsonSplit);

    sBuilder.append(String.format("\"%1$s\":\"%2$s\"", "登出流水号", getLoginOutSerialNo()));

    sBuilder.append("}");
    return sBuilder.toString();
  }
}
