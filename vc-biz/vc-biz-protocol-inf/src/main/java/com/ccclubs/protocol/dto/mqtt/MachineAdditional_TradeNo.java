package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17. 业务订单号
 */
public class MachineAdditional_TradeNo implements IMachineAdditionalItem {

  /**
   * 业务订单号
   */
  private long tradeNo;

  public long getTradeNo() {
    return tradeNo;
  }

  public void setTradeNo(long tradeNo) {
    this.tradeNo = tradeNo;
  }

  @Override
  public byte getAdditionalId() {
    return (byte) 137;
  }

  @Override
  public byte getAdditionalLength() {
    return 8;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getTradeNo());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setTradeNo(buff.getLong());
  }
}
