package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMessageBody;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * 终端报警数据
 * Created by qsxiaogang on 2017/7/2.
 */
public class MQTT_43 implements IMessageBody {

  /**
   * 终端报警数据
   */
  private byte alarmType;

  public int getAlarmType() {
    return alarmType & 0xFF;
  }

  public void setAlarmType(byte alarmType) {
    this.alarmType = alarmType;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((byte) getAlarmType());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] messageBodyBytes) {
    MyBuffer buff = new MyBuffer(messageBodyBytes);
    setAlarmType(buff.get());
  }
}
