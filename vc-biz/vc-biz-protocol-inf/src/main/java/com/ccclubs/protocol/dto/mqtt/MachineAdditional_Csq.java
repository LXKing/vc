package com.ccclubs.protocol.dto.mqtt;
import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * Created by qsxiaogang on 2017/4/17. GPRS 信号强度
 */
public class MachineAdditional_Csq implements IMachineAdditionalItem {

  /**
   * GPRS 信号强度
   */
  private int csq;

  public int getCsq() {
    return csq;
  }

  public void setCsq(int csq) {
    this.csq = csq;
  }

  @Override
  public byte getAdditionalId() {
    return (byte) 129;
  }

  @Override
  public byte getAdditionalLength() {
    return 1;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((byte) getCsq());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setCsq(buff.get());
  }
}
