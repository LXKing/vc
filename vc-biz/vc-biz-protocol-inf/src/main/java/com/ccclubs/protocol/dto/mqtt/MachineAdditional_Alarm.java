package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17. 车机警报
 */
public class MachineAdditional_Alarm implements IMachineAdditionalItem {

  /**
   * 车机警报
   */
  private int alarm;

  public int getAlarm() {
    return alarm;
  }

  public void setAlarm(int alarm) {
    this.alarm = alarm;
  }

  @Override
  public byte getAdditionalId() {
    return (byte) 145;
  }

  @Override
  public byte getAdditionalLength() {
    return 2;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((short) getAlarm());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setAlarm(buff.getShort());
  }
}
