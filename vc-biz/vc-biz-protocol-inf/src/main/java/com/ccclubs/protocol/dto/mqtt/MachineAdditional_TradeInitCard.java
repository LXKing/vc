package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;
import com.ccclubs.protocol.util.StringUtils;


/**
 * Created by qsxiaogang on 2017/4/17. 业务订单RFID号
 */
public class MachineAdditional_TradeInitCard implements IMachineAdditionalItem {

  private byte additionalLength;
  /**
   * 业务订单RFID号
   */
  private String tradeInitCard;

  public String getTradeInitCard() {
    return StringUtils.trim(tradeInitCard);
  }

  public void setTradeInitCard(String tradeInitCard) {
    this.tradeInitCard = tradeInitCard;
  }

  @Override
  public byte getAdditionalId() {
    return (byte) 140;
  }

  @Override
  public byte getAdditionalLength() {
    return additionalLength;
  }

  public void setAdditionalLength(byte additionalLength) {
    this.additionalLength = additionalLength;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getTradeInitCard());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    setTradeInitCard(new String(bytes));
  }
}
