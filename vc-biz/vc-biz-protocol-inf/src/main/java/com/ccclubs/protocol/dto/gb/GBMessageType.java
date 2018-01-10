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

}
