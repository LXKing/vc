package com.ccclubs.protocol.dto.jt808;

import com.ccclubs.protocol.inf.IMessageBody;
import com.ccclubs.protocol.util.MyBuffer;
import com.ccclubs.protocol.util.StringUtils;

/**
 * 中导终端上报VIN码
 */
public class JT_01F4 implements IMessageBody {

  /**
   * 国家规定的VIN码，ASCC字符
   * 如果收到的平台VIN码与平台
   */
  private String vin;

  public String getVin() {
    return vin;
  }

  public void setVin(String vin) {
    this.vin = vin;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    while (getVin().length() < 17) {
      vin = "0" + vin;
    }
    buff.put(vin.toUpperCase());

    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] messageBodyBytes) {
    MyBuffer buff = new MyBuffer(messageBodyBytes);
    byte[] vinBytes = buff.gets(17);
    setVin((new String(vinBytes)).trim().toUpperCase());
  }
}
