package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;
import com.ccclubs.protocol.util.StringUtils;

/**
 * Created by qsxiaogang on 2017/4/17. 操作卡号
 */
public class MachineAdditional_TradeTakeCard implements IMachineAdditionalItem {

  private byte additionalLength;
  /**
   * 操作卡号
   */
  private String tradeTakeCard;

  public String getTradeTakeCard() {
    return StringUtils.trim(tradeTakeCard);
  }

  public void setTradeTakeCard(String tradeTakeCard) {
    this.tradeTakeCard = tradeTakeCard;
  }

  @Override
  public byte getAdditionalId() {
    return (byte) 141;
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
    buff.put(getTradeTakeCard());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    setTradeTakeCard(new String(bytes));
  }
}
