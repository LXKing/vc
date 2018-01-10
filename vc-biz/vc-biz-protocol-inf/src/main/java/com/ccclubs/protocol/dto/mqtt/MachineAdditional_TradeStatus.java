package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17. 业务订单状态
 */
public class MachineAdditional_TradeStatus implements IMachineAdditionalItem {

  /**
   * 动业务订单状态
   */
  private byte tradeStatus;

  public int getTradeStatus() {
    return tradeStatus;
  }

  public void setTradeStatus(byte tradeStatus) {
    this.tradeStatus = tradeStatus;
  }

  @Override
  public byte getAdditionalId() {
    return (byte) 138;
  }

  @Override
  public byte getAdditionalLength() {
    return 1;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((byte) getTradeStatus());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setTradeStatus(buff.get());
  }
}
