package com.ccclubs.protocol.dto.gb;

import com.ccclubs.protocol.inf.IGbMessage;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * 平台登入
 *
 * @author qsxiaogang
 */
public class GB_05 implements IGbMessage {

  /**
   * 数据采集时间
   */
  private String time;
  /**
   * 登入流水号 : 车载终端每登入一次，登入流水号自动加1，从1开始循环累加，最大值为65531，循环周期为天。
   */
  private int loginSerialNo;
  /**
   * 平台用户名
   */
  private String username;

  /**
   * 平台密码
   */
  private String password;
  /**
   * 加密规则 : 0x01：数据不加密；0x02：数据经过RSA算法加密；0x03:数据经过AES128位算法加密；“0xFE”表示异常，“0xFF”表示无效，其他预留。
   */
  private int encryptRule;

  @Override
  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public int getLoginSerialNo() {
    return loginSerialNo & 0xFFFF;
  }

  public void setLoginSerialNo(int loginSerialNo) {
    this.loginSerialNo = loginSerialNo;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getEncryptRule() {
    return encryptRule & 0xFF;
  }

  public void setEncryptRule(int encryptRule) {
    this.encryptRule = encryptRule;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(Byte.parseByte(getTime().substring(2, 4), 10));
    buff.put(Byte.parseByte(getTime().substring(5, 7), 10));
    buff.put(Byte.parseByte(getTime().substring(8, 10), 10));
    buff.put(Byte.parseByte(getTime().substring(11, 13), 10));
    buff.put(Byte.parseByte(getTime().substring(14, 16), 10));
    buff.put(Byte.parseByte(getTime().substring(17, 19), 10));

    buff.put((short) getLoginSerialNo());
    buff.put((new String(getUsername())));
    buff.put((new String(getPassword())));
    buff.put((byte) getEncryptRule());
    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] messageBodyBytes) {
    MyBuffer buff = new MyBuffer(messageBodyBytes);
    byte[] timeBytes = buff.gets(6);
    setTime(
        "20" + String.format("%02d", timeBytes[0]) + "-" + String.format("%02d", timeBytes[1]) + "-"
            + String
            .format("%02d", timeBytes[2]) + " "
            + String.format("%02d", timeBytes[3]) + ":" + String.format("%02d", timeBytes[4]) + ":"
            + String
            .format("%02d", timeBytes[5]));

    setLoginSerialNo(buff.getShort());
    setUsername(new String(buff.gets(12)));
    setPassword(new String(buff.gets(20)));
    setEncryptRule(buff.get());
  }
}
