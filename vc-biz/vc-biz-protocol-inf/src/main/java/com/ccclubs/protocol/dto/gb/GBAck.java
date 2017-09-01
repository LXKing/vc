package com.ccclubs.protocol.dto.gb;


import com.ccclubs.protocol.inf.IGbMessage;
import com.ccclubs.protocol.util.MyBuffer;

public class GBAck implements IGbMessage {

  /**
   * 数据采集时间
   */
  private String time;

  @Override
  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
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

    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] messageBodyBytes) {
    MyBuffer buff = new MyBuffer(messageBodyBytes);
    byte[] timeBytes = buff.gets(6);
    setTime(
        "20" + String.format("%02d", timeBytes[0]) + "-" + String.format("%02d", timeBytes[1]) + "-"
            + String
            .format("%02d", timeBytes[2]) + " "
            + String.format("%02d", timeBytes[3]) + ":" + String.format("%02d", timeBytes[4]) + ":"
            + String
            .format("%02d", timeBytes[5]));
  }
}
