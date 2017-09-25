package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17. 收到网络命令数量
 */
public class MachineAdditional_ReceivedRemoteOrders implements IMachineAdditionalItem {

  /**
   * 收到网络命令数量
   */
  private int receivedRemoteOrders;

  public int getReceivedRemoteOrders() {
    return receivedRemoteOrders;
  }

  public void setReceivedRemoteOrders(int receivedRemoteOrders) {
    this.receivedRemoteOrders = receivedRemoteOrders;
  }

  @Override
  public byte getAdditionalId() {
    return (byte) 146;
  }

  @Override
  public byte getAdditionalLength() {
    return 4;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getReceivedRemoteOrders());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setReceivedRemoteOrders(buff.getInt());
  }
}
