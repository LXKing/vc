package com.ccclubs.phoenix.orm.consts;

/**
 * Created by taoshangming on 2017/9/29 0029.
 */
public class VehicleConsts {
    //车辆状态(充电)
    public static final Integer CAR_STATUS_SOC = 1;
    //车辆状态(驾驶)
    public static final Integer CAR_STATUS_DRIVE = 2;
    //车辆状态(其它)
    public static final Integer CAR_STATUS_OTHER = 3;
    //驾驶阶段计算间隔(分钟)
    public static final Integer PACE_BLOCK_INTERVAL_DRIVE = 5;
    //充电阶段计算间隔(分钟)
    public static final Integer PACE_BLOCK_INTERVAL_CHARGING = 12;
    //钥匙状态(无效)
    public static final Integer KEY_STATUS_INVALID = 0;
    //钥匙状态(插入)
    public static final Integer KEY_STATUS_IN = 1;
    //钥匙状态(拔出)
    public static final Integer KEY_STATUS_OUT = 2;
    //发动机状态(无效)
    public static Integer ENGINE_STATUS_INVALID = 0;
    //发动机状态(START)
    public static Integer ENGINE_STATUS_START = 1;
    //发动机状态(STOP)
    public static Integer ENGINE_STATUS_STOP = 2;
    //发动机状态(ACC)
    public static Integer ENGINE_STATUS_ACC = 3;
    //充电状态(是)
    public static Integer CHARGING_STATUS_YES = 1;
    //充电状态(否)
    public static Integer CHARGING_STATUS_NO = 0;
    //驾驶数据块时间间隔(单位:分钟)
    public static Integer DRIVE_MINUTES_INTERVAL = 5;
    //充电数据块时间间隔(单位:分钟)
    public static Integer CHARGING_MINUTES_INTERVAL = 12;
    //计算阶段数据类型(驾驶)
    public static Integer CAL_PACE_TYPE_DRIVE = 1;
    //计算阶段数据类型(充电)
    public static Integer CAL_PACE_TYPE_CHARGING = 2;


}
