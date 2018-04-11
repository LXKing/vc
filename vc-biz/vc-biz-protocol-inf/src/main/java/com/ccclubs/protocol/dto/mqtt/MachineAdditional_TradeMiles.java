package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17. 订单里程
 */
public class MachineAdditional_TradeMiles implements IMachineAdditionalItem {

  /**
   * 订单里程
   */
  private int tradeMiles;

  public int getTradeMiles() {
    return tradeMiles;
  }

  public void setTradeMiles(int tradeMiles) {
    this.tradeMiles = tradeMiles;
  }

  @Override
  public byte getAdditionalId() {
    return (byte) 139;
  }

  @Override
  public byte getAdditionalLength() {
    return 4;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getTradeMiles());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setTradeMiles(buff.getInt());
  }
}
