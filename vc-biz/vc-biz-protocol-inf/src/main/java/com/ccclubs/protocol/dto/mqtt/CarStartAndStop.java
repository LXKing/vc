package com.ccclubs.protocol.dto.mqtt;


import com.ccclubs.protocol.annotation.size;

/**
 * 车机启、停信息
 *
 * @author Administrator
 */
public class CarStartAndStop extends CStruct {

  /**
   * 车牌号
   */
  public
  @size(8)
  String mCarNum;
  /**
   * 订单号
   */
  public long mOrderId;
  /**
   * Fuc Code 标识位 0x68
   */
  public byte mFucCode = 0x68;
  /**
   * Subfuc code 标识位
   */
  public byte mSubFucCode;
  /**
   * 车机id号
   */
  public
  @size(16)
  String mCfxId;
  /**
   * SIM卡号
   */
  public
  @size(16)
  String mMobile;
  /**
   * 经度，整数部分
   */
  public
  @size(24)
  String mVin;
  /**
   * 车型
   */
  public short mType;
  /**
   * 硬件版本
   */
  public short mVersion;
  /**
   * IAP版本
   */
  public short mIapVersion;
  /**
   * APP版本
   */
  public short mAppVersion;

  /**
   * 当前时间
   */
  public int mTime;

  /**
   * 经度，整数部分
   */
  public short mLongitude;
  /**
   * 经度，小数部分
   */
  public int mLongitudeDecimal;
  /**
   * 纬度，整数部分
   */
  public short mLatitude;
  /**
   * 纬度，整数部分
   */
  public int mLatitudeDecimal;

  /**
   * 故障码
   */
  public
  @size(8)
  String mErrorCode;

  /**
   * 订单里程
   */
  public int mMiles;
  /**
   * 档位数据，0：停；1：启
   */
  public byte mGear;

  /**
   * MEMS初始化数据
   */
  // public byte mMems;
  public CarStartAndStop() {
    // TODO Auto-generated constructor stub
  }
}
