package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17. 业务订单结束时间
 */
public class MachineAdditional_TradeEndTime implements IMachineAdditionalItem {

  /**
   * 业务订单结束时间
   */
  private int tradeEndTime;

  public int getTradeEndTime() {
    return tradeEndTime;
  }

  public void setTradeEndTime(int tradeEndTime) {
    this.tradeEndTime = tradeEndTime;
  }

  @Override
  public byte getAdditionalId() {
    return (byte) 143;
  }

  @Override
  public byte getAdditionalLength() {
    return 4;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getTradeEndTime());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setTradeEndTime(buff.getInt());
  }
}
