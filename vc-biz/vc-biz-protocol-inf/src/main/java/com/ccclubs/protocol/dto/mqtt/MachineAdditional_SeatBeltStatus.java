package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17.
 * 安全带状态,终端信息
 */
public class MachineAdditional_SeatBeltStatus implements IMachineAdditionalItem {

  /**
   * 待确定
   */
  private int seatBeltStatus;

  public int getSeatBeltStatus() {
    return seatBeltStatus;
  }

  public void setSeatBeltStatus(int seatBeltStatus) {
    this.seatBeltStatus = seatBeltStatus;
  }

  @Override
  public byte getAdditionalId() {
    return 111;
  }

  @Override
  public byte getAdditionalLength() {
    return 1;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((byte) getSeatBeltStatus());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setSeatBeltStatus(buff.get());
  }
}
