package com.ccclubs.phoenix.orm.consts;

import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * Module Desc:
 * User: taosm
 * DateTime: 2017/11/28 0028
 */
public class PhoenixConsts {
    //车辆状态分页查询默认字段列表
    public static final List<String> carStatePageDefaultFields = ImmutableList.of("cs_number", "current_time", "add_time", "obd_miles", "speed", "ev_battery", "saving_mode", "cur_order");
    //车辆状态所有字段列表
    public static final List<String> carStateAllFields = ImmutableList.of("cs_number", "current_time", "cs_access", "add_time", "rent_flg",
            "warn_code", "rfid", "user_rfid", "obd_miles", "engine_tempe", "total_miles", "speed", "motor_speed",
            "oil_cost", "power_reserve", "ev_battery", "charging_status", "fuel_miles", "elec_miles", "endur_miles",
            "tempe", "gps_num", "gps_strength", "gps_valid", "net_strength", "longitude", "latitude", "direction_angle",
            "circular_mode", "ptc_status", "compre_status", "fan_mode", "saving_mode", "door_status", "engine_status",
            "key_status", "light_status", "lock_status", "net_type", "base_lac", "base_ci", "cur_order", "gear", "autopilot_status", "handbrake_status"
    );
    //车辆阶段数据默认字段列表
    public static final List<String> carPaceFields = ImmutableList.of(
            "cs_number", "current_time", "engine_status",
            "add_time", "obd_miles", "speed", "ev_battery", "saving_mode",
            "cur_order", "speed", "longitude",
            "latitude", "charging_status");

    //车辆CAN分页查询默认字段列表
    public static final List<String> carCanPageDefaultFields = ImmutableList.of(
            "cs_number", "current_time", "add_time", "can_data");
    //车辆CAN所有字段列表
    public static final List<String> carCanAllFields = ImmutableList.of(
            "cs_number", "current_time", "add_time", "can_data");

    //车辆GB分页查询默认字段列表
    public static final List<String> carGbPageDefaultFields = ImmutableList.of(
            "cs_vin", "add_time", "current_time", "gb_data");
    //车辆GB所有字段列表
    public static final List<String> carGbAllFields = ImmutableList.of(
            "cs_vin", "add_time", "current_time", "gb_data", "cs_access",
            "cs_protocol", "gb_type", "cs_verify");


    /**
     * 以下三个字段是TableStore表名
     */
    public static final String TBL_NAME_CAR_STATE_HISTORY = "TBS_CAR_STATE_HISTORY";
    public static final String TBL_NAME_CAR_CAN_HISTORY = "TBS_CAR_CAN_HISTORY";
    public static final String TBL_NAME_CAR_GB_HISTORY = "TBS_CAR_GB_HISTORY";


    /**
     * HBASE的Phoenix表名
     */
    public static final String PHOENIX_CAR_STATE_HISTORY = "phoenix_car_state_history";
    public static final String PHOENIX_CAR_CAN_HISTORY = "phoenix_car_can_history";
    public static final String PHOENIX_CAR_GB_HISTORY = "phoenix_car_gb_history";

    public static final String PHOENIX_CAR_STATE_HISTORY_NIU = "phoenix_car_state_history_niu";
//    public static final String PHOENIX_CAR_STATE_HISTORY =PHOENIX_CAR_STATE_HISTORY_NIU;

}
