package com.ccclubs.protocol.dto.jt808;

import com.ccclubs.protocol.inf.IPositionAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

public class PostitionAdditional_Csq implements IPositionAdditionalItem {

  public final byte getAdditionalId() {
    return 0x30;
  }

  public final byte getAdditionalLength() {
    return 0x01;
  }

  /**
   * 无线通信网络信号强度
   */
  private byte signal;

  public final byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getSignal());
    return buff.array();
  }

  public final void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setSignal(buff.get());
  }

  public byte getSignal() {
    return signal;
  }

  public void setSignal(byte signal) {
    this.signal = signal;
  }
}