package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17. 收到CAN包数量
 */
public class MachineAdditional_ReceivedCanAmount implements IMachineAdditionalItem {

  /**
   * 收到CAN包数量
   */
  private int receivedCanAmount;

  public int getReceivedCanAmount() {
    return receivedCanAmount;
  }

  public void setReceivedCanAmount(int receivedCanAmount) {
    this.receivedCanAmount = receivedCanAmount;
  }

  @Override
  public byte getAdditionalId() {
    return (byte) 148;
  }

  @Override
  public byte getAdditionalLength() {
    return 4;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getReceivedCanAmount());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setReceivedCanAmount(buff.getInt());
  }
}
