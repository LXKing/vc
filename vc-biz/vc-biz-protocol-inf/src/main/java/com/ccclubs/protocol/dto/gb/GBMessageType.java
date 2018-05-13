package com.ccclubs.protocol.dto.gb;

/**
 * GB消息类型
 *
 * @author jianghaiyang
 * @create 2018-01-04
 **/
public class GBMessageType {
    /**
     * 0x01:注册信息(上报)
     */
    public static final int GB_MSG_TYPE_0X01 = 0x01;
    /**
     * 0x02:实时信息上报(上报)
     */
    public static final int GB_MSG_TYPE_0X02 = 0x02;
    /**
     * 0x03:补发信息数据(上报)
     */
    public static final int GB_MSG_TYPE_0X03 = 0x03;
    /**
     * 0x04:车辆登出(上报)
     */
    public static final int GB_MSG_TYPE_0X04 = 0x04;
    /**
     * 0x05:平台登入(上报)
     */
    public static final int GB_MSG_TYPE_0X05 = 0x05;
    /**
     * 0x06:平台登出(上报)
     */
    public static final int GB_MSG_TYPE_0X06 = 0x06;
    /**
     * 0x07:心跳(上报)
     */
    public static final int GB_MSG_TYPE_0X07 = 0x07;
    /**
     * 0x08:终端校时(上报)
     */
    public static final int GB_MSG_TYPE_0X08 = 0x08;
    /**
     * 实时信息：0x01:整车数据
     */
    public static final int GB_MSG_REAL_TIME_TYPE_0X01 = 0x01;
    /**
     * 实时信息：0x02:驱动电机数据
     */
    public static final int GB_MSG_REAL_TIME_TYPE_0X02 = 0x02;
    /**
     * 实时信息：0x03:燃料电池数据
     */
    public static final int GB_MSG_REAL_TIME_TYPE_0X03 = 0x03;
      /**
     * 实时信息：0x04:发动机数据
     */
    public static final int GB_MSG_REAL_TIME_TYPE_0X04 = 0x04;
      /**
     * 实时信息：0x05:车辆位置数据
     */
    public static final int GB_MSG_REAL_TIME_TYPE_0X05 = 0x05;
      /**
     * 实时信息：0x06:极值数据
     */
    public static final int GB_MSG_REAL_TIME_TYPE_0X06 = 0x06;
      /**
     * 实时信息：0x07:报警数据
     */
    public static final int GB_MSG_REAL_TIME_TYPE_0X07 = 0x07;
      /**
     * 实时信息：0x08:可充电储能装置电压数据
     */
    public static final int GB_MSG_REAL_TIME_TYPE_0X08 = 0x08;
      /**
     * 实时信息：0x09:可充电储能装置温度数据
     */
    public static final int GB_MSG_REAL_TIME_TYPE_0X09 = 0x09;

}
