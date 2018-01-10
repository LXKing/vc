package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMessageBody;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * 远程车辆发上来的钥匙插入、拔出信息，状态附加信息
 */
public class MQTT_07_Item implements IMessageBody {

  //  public static int KEY_IN = 0x01;
//  public static int KEY_OUT = 0x02;
  public static int KEY_IN = 0x01;
  public static int KEY_OUT = 0x00;

  /**
   * 协议版本
   */
  private byte keyStatus;
  /**
   * 钥匙改变时终端当前时间
   */
  private int time;

  public byte getKeyStatus() {
    return keyStatus;
  }

  public void setKeyStatus(byte keyStatus) {
    this.keyStatus = keyStatus;
  }

  public int getTime() {
    return time;
  }

  public void setTime(int time) {
    this.time = time;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getKeyStatus());
    buff.put(getTime());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] messageBodyBytes) {
    MyBuffer buff = new MyBuffer(messageBodyBytes);
    setKeyStatus(buff.get());
    setTime(buff.getInt());
  }
}
