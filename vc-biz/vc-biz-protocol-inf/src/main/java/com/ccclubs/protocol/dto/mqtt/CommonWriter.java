package com.ccclubs.protocol.dto.mqtt;

import com.ccclubs.protocol.annotation.size;

/**
 * 通用0x10 写操作
 * <p>
 * FcCode 0x10
 * </p>
 *
 * @author Administrator
 */
public class CommonWriter extends CStruct {

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
   * Fuc Code
   * <ul>
   * <li>0x05(操作功能码)，开门、关门，允许启动，禁止启动，远程鸣笛</li>
   * <li>0x46(操作功能码)，初始化</li>
   * <li>0x47(操作功能码)，远程取车</li>
   * <li>0x48(操作功能码)，远程还车</li>
   * </ul>
   */
  public byte mFucCode = 0x10;
  /**
   * 输出地址
   * <ul>
   * <li>0x1000：开门，关门</li>
   * <li>0x1004：允许启动，禁止启动</li>
   * <li>0x1012：远程鸣笛</li>
   * <li>0x0000：初始化</li>
   * </ul>
   */
  public short mOutputAddress;
  /**
   * 输出数量
   */
  public short mQuantityOfOutputs;

  /**
   *
   */
  public CommonWriter() {
    // TODO Auto-generated constructor stub
  }

}
