package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17. 业务订单开始时间
 */
public class MachineAdditional_TradeStartTime implements IMachineAdditionalItem {

  /**
   * 业务订单开始时间
   */
  private int tradeStartTime;

  public int getTradeStartTime() {
    return tradeStartTime;
  }

  public void setTradeStartTime(int tradeStartTime) {
    this.tradeStartTime = tradeStartTime;
  }

  @Override
  public byte getAdditionalId() {
    return (byte) 142;
  }

  @Override
  public byte getAdditionalLength() {
    return 4;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getTradeStartTime());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setTradeStartTime(buff.getInt());
  }
}
