package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.inf.IMessageBody;
import com.ccclubs.protocol.util.MyBuffer;

public class CCCLUBS_6C implements IMessageBody {

  private byte mSubFucCode;
  /**
   * 16个长度
   */
  private String mClientId;

  private int mRTC;

  private String mLog;

  public byte getmSubFucCode() {
    return mSubFucCode;
  }

  public void setmSubFucCode(byte mSubFucCode) {
    this.mSubFucCode = mSubFucCode;
  }

  public String getmClientId() {
    return mClientId;
  }

  public void setmClientId(String mClientId) {
    this.mClientId = mClientId;
  }

  public int getmRTC() {
    return mRTC;
  }

  public void setmRTC(int mRTC) {
    this.mRTC = mRTC;
  }

  public String getmLog() {
    return mLog;
  }

  public void setmLog(String mLog) {
    this.mLog = mLog;
  }

  @Override
  public byte[] WriteToBytes() {
    MyBuffer buff = new MyBuffer();

    buff.put(getmSubFucCode());
    buff.put(getmClientId());
    buff.put(getmRTC());
    buff.put(getmLog());

    return buff.array();
  }

  @Override
  public void ReadFromBytes(byte[] messageBodyBytes) {

    MyBuffer buff = new MyBuffer(messageBodyBytes);

    setmSubFucCode(buff.get());
    byte[] clientIdBytes = buff.gets(16);
    setmClientId(new String(clientIdBytes).trim());
    setmRTC(buff.getInt());
    byte[] logBytes = buff.gets(messageBodyBytes.length - 1 - 16 - 4);
    setmLog(new String(logBytes).trim());
  }

}
