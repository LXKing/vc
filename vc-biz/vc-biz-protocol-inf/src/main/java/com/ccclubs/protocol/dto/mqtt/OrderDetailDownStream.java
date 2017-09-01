package com.ccclubs.protocol.dto.mqtt;


import com.ccclubs.protocol.annotation.size;
import com.ccclubs.protocol.util.UnicodeUtil;

/**
 * 发送给远程车辆的订单附加信息
 * <p>
 * 包括车牌号，订单号，姓名，手机号等
 * </p>
 *
 * @author Administrator
 */
public class OrderDetailDownStream extends CStruct {

  /**
   * 车牌号
   */
  public
  @size(8)
  String mCarNum;
  /**
   * 消息ID
   */
  public long mId = 0;
  /**
   * Fuc Code 标识位 0x52
   */
  public byte mFucCode = 0x52;
  /**
   * 订单号
   */
  public long mOrderId;
  /**
   * 输出地址 0x9020
   */
  public short mOutputAddress = (short) 0x9020;
  /**
   * 输出数量 0x5F20
   */
  public short mQuantityOfOutputs = (short) 0x000A;

  /**
   * 姓名，6个长度的UNICODE编码，不足6位，后面补齐0
   */
  // public @size(6)
  // String mName;
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

  /**
   *
   */
  public OrderDetailDownStream() {
    //  Auto-generated constructor stub
  }

  public OrderDetailDownStream(String number, Long id, String name, String mobile, Long order,
      short gender) {
    //  Auto-generated constructor stub
    this.mCarNum = number;
    // this.mName = name;
    this.mId = id;
    while (mobile.length() < 12) {
      mobile += "0" + mobile;
    }
    this.mMobile = mobile;
    this.mOrderId = order;
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
