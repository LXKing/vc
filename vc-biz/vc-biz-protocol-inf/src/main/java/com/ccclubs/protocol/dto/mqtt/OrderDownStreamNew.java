package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.annotation.size;
import com.ccclubs.protocol.util.UnicodeUtil;

/**
 * 发送给远程车辆的订单信息，新
 * <p>
 * 包括车牌号，订单号，RFID，经、纬度，里程，油量等
 * </p>
 *
 * @author Administrator
 */
public class OrderDownStreamNew extends CStruct {

  /**
   * 车牌号
   */
  public
  @size(8)
  String mCarNum;
  /**
   * 消息ID
   */
  public long mId;
  /**
   * Fuc Code 标识位 0x54
   */
  public byte mFucCode = 0x54;
  /**
   * 订单号
   */
  public long mOrderId;
  /**
   * 输出地址 0x9000
   */
  public short mOutputAddress = (short) 0x9000;
  /**
   * 输出数量 0x0014,0x000a
   */
  public short mQuantityOfOutputs = (short) 0x0014;
  /**
   * 订单开始时间
   */
  public int mStartTime;
  /**
   * 订单结束时间
   */
  public int mEndTime;
  /**
   * RFID号
   */
  public
  @size(8)
  String mRfid;
  /**
   * 授权码
   */
  public int mCode;
  /**
   * RFID号
   */
  public
  @size(12)
  String mMobile;
  /**
   * 性别
   */
  public short mGender;

  /**
   * 姓名
   */
  public short mFirstName;

  /**
   * 姓名
   */
  public short mSecendName;

  /**
   * 姓名
   */
  public short mLastName;

  public Object[] array;

  public Object[] getArray() {
    Object[] temp = new Object[10];
    temp[0] = mOrderId;
    temp[1] = mStartTime;
    temp[2] = mEndTime;
    temp[3] = mRfid;
    temp[4] = mCode;
    temp[5] = mMobile;
    temp[6] = mGender;
    temp[7] = mFirstName;
    temp[8] = mSecendName;
    temp[9] = mLastName;
    return temp;
  }

  /**
   *
   */
  public OrderDownStreamNew() {
    //  Auto-generated constructor stub
  }

  public OrderDownStreamNew(String number, Long id, int startTime, int endTime, Long order,
      String rfid, int code, String name, String mobile, short gender) {
    //  Auto-generated constructor stub
    super();
    this.mCarNum = number;
    this.mId = id;
    this.mStartTime = startTime;
    this.mEndTime = endTime;
    this.mOrderId = order;
    this.mRfid = rfid;
    this.mCode = code;

    while (mobile.length() < 12) {
      mobile += "0" + mobile;
    }
    this.mMobile = mobile;
    this.mGender = gender;

    if (name.length() >= 3) {
      name = name.substring(0, 3);
    }

    switch (name.length()) {
      case 0:
        this.mFirstName = 0x0000;
        this.mSecendName = 0x0000;
        this.mLastName = 0x0000;
        break;
      case 1:
        this.mFirstName = UnicodeUtil.string2UnicodeHex(name);
        this.mSecendName = 0x0000;
        this.mLastName = 0x0000;
        break;
      case 2:
        this.mFirstName = UnicodeUtil.string2UnicodeHex(name.substring(0, 1));
        this.mSecendName = UnicodeUtil.string2UnicodeHex(name.substring(1, 2));
        this.mLastName = 0x0000;
        break;
      case 3:
        this.mFirstName = UnicodeUtil.string2UnicodeHex(name.substring(0, 1));
        this.mSecendName = UnicodeUtil.string2UnicodeHex(name.substring(1, 2));
        this.mLastName = UnicodeUtil.string2UnicodeHex(name.substring(2, 3));
        break;
    }
  }
}
