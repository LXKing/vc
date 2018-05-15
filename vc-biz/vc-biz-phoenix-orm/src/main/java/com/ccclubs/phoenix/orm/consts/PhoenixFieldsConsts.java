package com.ccclubs.phoenix.orm.consts;

import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * Module Desc:
 * User: taosm
 * DateTime: 2017/11/28 0028
 */
public class PhoenixFieldsConsts {
    //车辆状态分页查询默认字段列表
    @Deprecated
    public static final List<String> carStatePageDefaultFields = ImmutableList.of(
            "cs_number", "current_time", "add_time", "obd_miles", "speed", "ev_battery", "saving_mode", "cur_order"
    );
    //车辆状态所有字段列表
    @Deprecated
    public static final List<String> carStateAllFields = ImmutableList.of("cs_number", "current_time", "cs_access", "add_time", "rent_flg",
            "warn_code", "rfid", "user_rfid", "obd_miles", "engine_tempe", "total_miles", "speed", "motor_speed",
            "oil_cost", "power_reserve", "ev_battery", "charging_status", "fuel_miles", "elec_miles", "endur_miles",
            "tempe", "gps_num", "gps_strength", "gps_valid", "net_strength", "longitude", "latitude", "direction_angle",
            "circular_mode", "ptc_status", "compre_status", "fan_mode", "saving_mode", "door_status", "engine_status",
            "key_status", "light_status", "lock_status", "net_type", "base_lac", "base_ci", "cur_order", "gear", "autopilot_status", "handbrake_status"
    );
    //车辆阶段数据默认字段列表
    @Deprecated
    public static final List<String> carPaceFields = ImmutableList.of(
            "cs_number", "current_time", "engine_status",
            "add_time", "obd_miles", "speed", "ev_battery", "saving_mode",
            "cur_order", "longitude",
            "latitude", "charging_status");

    //车辆CAN分页查询默认字段列表
    @Deprecated
    public static final List<String> carCanPageDefaultFields = ImmutableList.of(
            "cs_number", "current_time", "add_time", "can_data");
    //车辆CAN所有字段列表
    @Deprecated
    public static final List<String> carCanAllFields = ImmutableList.of(
            "cs_number", "current_time", "add_time", "can_data");

    //车辆GB分页查询默认字段列表
    @Deprecated
    public static final List<String> carGbPageDefaultFields = ImmutableList.of(
            "cs_vin", "add_time", "current_time", "gb_data");

    //车辆GB所有字段列表
    @Deprecated
    public static final List<String> carGbAllFields = ImmutableList.of(
            "cs_vin", "add_time", "current_time", "gb_data", "cs_access",
            "cs_protocol", "gb_type", "cs_verify");

    //车辆MqttState分时租赁状态数据全部字段列表
    public static final List<String>  MQTT_STATE_ALL_FIELDS=ImmutableList.of(
            "VIN","CURRENT_TIME","TE_NUMBER","TE_NO","ICCID","MOBILE",
            "ACCESS","ADD_TIME","RENT_FLG","WARN_CODE","RFID",
            "USER_RFID","OBD_MILES","ENGINE_TEMPE","TOTAL_MILES","SPEED",
            "MOTOR_SPEED","OIL_COST","POWER_RESERVE","EV_BATTERY",
            "CHARGING_STATUS","FUEL_MILES","ELEC_MILES","ENDUR_MILES",
            "TEMPE","GPS_NUM","GPS_STRENGTH","GPS_VALID","NET_STRENGTH",
            "LONGITUDE","LATITUDE","DIRECTION_ANGLE", "CIRCULAR_MODE",
            "PTC_STATUS","COMPRE_STATUS","FAN_MODE","SAVING_MODE",
            "DOOR_STATUS","ENGINE_STATUS","KEY_STATUS", "LIGHT_STATUS",
            "LOCK_STATUS","NET_TYPE","BASE_LAC","BASE_CI","CUR_ORDER",
            "GEAR","AUTOPILOT_STATUS","HANDBRAKE_STATUS","SOURCE_HEX"
    );
    //车辆MqttState分时租赁状态数据默认字段列表
    public static final List<String>  MQTT_STATE_DEFAULT_FIELDS=ImmutableList.of(
            "VIN","CURRENT_TIME","TE_NUMBER","TE_NO","ICCID",
            "MOBILE", "ACCESS","ADD_TIME", "OBD_MILES",
            "EV_BATTERY", "SPEED","SAVING_MODE","CUR_ORDER"
    );

    //车辆MqttState分时租赁状态数据默认字段列表
    public static final List<String>  MQTT_STATE_PACE_FIELDS=ImmutableList.of(
            "VIN","CURRENT_TIME","TE_NUMBER","TE_NO","ICCID",
            "MOBILE", "ACCESS","ADD_TIME", "OBD_MILES",
            "EV_BATTERY", "SPEED","SAVING_MODE","CUR_ORDER",
            "LONGITUDE","LATITUDE","CHARGING_STATUS","ENGINE_STATUS"
    );

    //车辆GbMessage国标数据全部字段列表
    public static final List<String>  GBMESSAGE_ALL_FIELDS=ImmutableList.of(
            "VIN","MOBILE","ACCESS","ICCID", "ADD_TIME",
            "CURRENT_TIME","TE_NUMBER","TE_NO",
            "PROTOCOL","MESSAGE_TYPE","VERIFY","SOURCE_HEX"
    );
    //车辆GbMessage国标数据默认字段列表
    public static final List<String>  GBMESSAGE_DEFAULT_FIELDS=ImmutableList.of(
            "VIN", "ADD_TIME", "CURRENT_TIME","SOURCE_HEX"
    );
    //车辆JT808位置数据全部字段列表
    public static final List<String>  JT808_POSITION_ALL_FIELDS=ImmutableList.of(
            "TE_NUMBER","CURRENT_TIME","VIN","TE_NO","ICCID","ADD_TIME","MOBILE","ALARM_FLAG",
            "STATUS","LONGITUDE","LATITUDE","ALTITUDE","GPS_SPEED","NET_STRENGTH","COURSE",
            "GPS_VALID","SOURCE_HEX"
    );
    //车辆JT808位置数据默认字段列表
    public static final List<String>  JT808_POSITION_DEFAULT_FIELDS=ImmutableList.of(
            "TE_NUMBER","VIN","CURRENT_TIME","ADD_TIME",
            "LONGITUDE","LATITUDE","ALTITUDE","NET_STRENGTH"

    );
    //车辆CAN总线数据全部字段列表
    public static final List<String>  CAN_ALL_FIELDS=ImmutableList.of(
            "VIN", "CURRENT_TIME","TE_NUMBER","TE_NO","ICCID","MOBILE","SOURCE_HEX","ADD_TIME"
    );
    //车辆CAN总线数据默认字段列表
    public static final List<String>  CAN_DEFAULT_FIELDS=ImmutableList.of(
            "VIN", "CURRENT_TIME","TE_NUMBER",
            "SOURCE_HEX","ADD_TIME"
    );


}
