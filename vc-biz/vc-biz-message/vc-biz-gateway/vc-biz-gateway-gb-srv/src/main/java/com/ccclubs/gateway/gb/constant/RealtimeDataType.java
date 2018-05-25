package com.ccclubs.gateway.gb.constant;

import com.ccclubs.gateway.gb.inf.ICodedStatus;

/**
 * 实时数据信息类型标志定义
 *
 */
public enum RealtimeDataType implements ICodedStatus {

    /**
     * 整车信息
     */
    ALL(0x01, "整车信息"),

    /**
     * 驱动电机数据
     */
    MOTOR(0x02, "驱动电机数据"),

    /**
     * 燃料电池数据
     */
    FUEL_CELL(0x03, "燃料电池数据"),

    /**
     * 发动机数据
     */
    ENGINE(0x04, "发动机数据"),

    /**
     * 车辆位置
     */
    POSITION(0x05, "车辆位置"),

    /**
     * 极值数据
     */
    EXTREMUM(0x06, "极值数据"),

    /**
     * 报警数据
     */
    ALARM(0x07, "报警数据"),

    /**
     * 可充电储能装置电压数据
     */
    RECHARGEABLE_ENERGY_STORAGE_DEVICE_VOLTAGE(0x08, "可充电储能装置电压数据"),

    /**
     * 可充电储能温度数据
     */
    RECHARGEABLE_ENERGY_STORAGE_TEMPERATURE(0x09, "可充电储能温度数据");

    /**
     * 平台交换协议数据
     * 0x0A~0x2F
     */

    /**
     * 预留
     * 0x30~0x7F
     */

    /**
     * 用户自定义
     * 0x80~0xFE
     */

    private int code;
    private String des;

    RealtimeDataType(int code, String des) {
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

    public static RealtimeDataType getByCode(int code) {
        for (RealtimeDataType d :
                RealtimeDataType.values()) {
            if (d.getCode() == code) {
                return d;
            }
        }
        return null;
    }
}
