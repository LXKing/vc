package com.ccclubs.protocol.dto.jt808;

import com.ccclubs.protocol.inf.IMessageBody;
import com.ccclubs.protocol.util.MyBuffer;

/**
 * 中岛升级指令
 * Created by qsxiaogang on 2017/5/2.
 */
public class SL_Update implements IMessageBody {

  /**
   * 终端手机号
   */
  private String simId;
  /**
   * 升级内容
   */
  private byte[] msgBody;

  public String getSimId() {
    return simId;
  }

  public void setSimId(String simId) {
    this.simId = simId;
  }

  public byte[] getMsgBody() {
    return msgBody;
  }

  public void setMsgBody(byte[] msgBody) {
    this.msgBody = msgBody;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();
    buff.put(getSimId().getBytes());
    buff.put(getMsgBody());

    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] messageBodyBytes) {
    try {
      MyBuffer buff = new MyBuffer(messageBodyBytes);
      byte[] simIdBytes = buff.gets(11);
      setSimId((new String(simIdBytes)).trim());
      setMsgBody(buff.gets(messageBodyBytes.length - 11));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
