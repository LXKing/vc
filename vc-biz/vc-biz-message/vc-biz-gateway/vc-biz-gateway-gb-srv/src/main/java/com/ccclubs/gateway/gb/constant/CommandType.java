package com.ccclubs.gateway.gb.constant;

import com.ccclubs.gateway.gb.inf.ICodedStatus;

import java.util.Objects;

/**
 * @Author: yeanzi
 * @Date: 2018/3/26
 * @Time: 13:45
 * Email:  yeanzhi@ccclubs.com
 * 命令标识
 */
public enum CommandType  implements ICodedStatus {

    /**
     * 车辆登入
     */
    VEHICLE_LOGIN(0x01, "车辆登入"),

    /**
     * 实时信息上报
     */
    REALTIME_DATA(0x02, "实时信息上报"),

    /**
     * 补发信息上报
     */
    REISSUE_DATA(0x03, "补发信息上报"),

    /**
     * 车辆登出
     */
    VEHICLE_LOGOUT(0x04, "车辆登出"),

    /**
     * 平台登入
     */
    PLATE_LOGIN(0x05, "平台登入"),

    /**
     * 平台登出
     */
    PLATE_LOGOUT(0x06, "平台登出"),

    /**
     * 心跳
     */
    HEARTBEAT(0x07, "心跳"),

    /**
     * 终端校时
     */
    TIME_CHECK(0x08, "终端校时"),

    /**
     * 查询命令
     */
    QUERY_COMMAND(0x80, "查询命令"),

    /**
     * 设置命令
     */
    SET_COMMAND(0x81, "设置命令"),

    /**
     * 车载终端控制命令
     */
    CONTROL_COMMAND(0x82, "车载终端控制命令");

    /**
     * 期望值
     */
    private static String EXCEPTE_VALUES;

    private int code;   // 编码
    private String des; // 描述

    CommandType(int code, String des) {
        this.code = code;
        this.des = des;
    }

    @Override
    public int getCode() {
        return code;
    }

    public String getDes() {
        return des;
    }

    public static CommandType getByCode(int code) {
        for (CommandType c :
                CommandType.values()) {
            if (c.getCode() == code) {
                return c;
            }
        }
        return null;
    }

    // 预期的期望值，逗号分隔
    public static String expectedVals() {
        if (Objects.isNull(EXCEPTE_VALUES)) {
            StringBuilder valSb = new StringBuilder();
            for (CommandType c :
                    CommandType.values()) {
                valSb.append(c.getCode()).append(",");
            }
            // 删除最后一个逗号
            valSb.deleteCharAt(valSb.length() - 1);
            EXCEPTE_VALUES = valSb.toString();
        }
        return EXCEPTE_VALUES;
    }
}
