package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17. 航向角
 */
public class MachineAdditional_Heading implements IMachineAdditionalItem {

  /**
   * 0-359，正北为 0，顺时针
   */
  private short heading;

  public int getHeading() {
    return heading;
  }

  public void setHeading(short heading) {
    this.heading = heading;
  }

  @Override
  public byte getAdditionalId() {
    return 122;
  }

  @Override
  public byte getAdditionalLength() {
    return 2;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((short) getHeading());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setHeading(buff.getShort());
  }
}
