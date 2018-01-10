package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMachineAdditionalItem;
import com.ccclubs.protocol.util.MyBuffer;


/**
 * Created by qsxiaogang on 2017/4/17. 车机温度
 */
public class MachineAdditional_TerminalTemperature implements IMachineAdditionalItem {

  /**
   * 车机温度
   */
  private int terminalTemperature;

  public int getTerminalTemperature() {
    return terminalTemperature;
  }

  public void setTerminalTemperature(int terminalTemperature) {
    this.terminalTemperature = terminalTemperature;
  }

  @Override
  public byte getAdditionalId() {
    return (byte) 130;
  }

  @Override
  public byte getAdditionalLength() {
    return 1;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put((byte) getTerminalTemperature());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] bytes) {
    MyBuffer buff = new MyBuffer(bytes);
    setTerminalTemperature(buff.get());
  }
}
