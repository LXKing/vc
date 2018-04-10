package com.ccclubs.storage.impl;


import com.ccclubs.phoenix.orm.model.CarCan;
import com.ccclubs.phoenix.orm.model.CarGb;
import com.ccclubs.phoenix.orm.model.CarState;
import com.ccclubs.storage.inf.BaseHistoryInf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/3/31
 * @Time: 11:56
 * @Description: 此类是{@Link BaseHistoryInf}接口的实现类。此类做了存储实体的基本操作交由
 * 父类处理，其中，父类会调用本类的SQL拼接语句。
 */
@Service
public class PhoenixStorageService implements BaseHistoryInf {
    static Logger logger= LoggerFactory.getLogger(PhoenixStorageService.class);
    @Autowired
    private BaseInfImpl baseImpl;



    static final String carCanInsertSql="upsert into PHOENIX_CAR_CAN_HISTORY " +
            "(CS_NUMBER,CURRENT_TIME,CAN_DATA,ADD_TIME  ) values (" +
            "?, " + //CS_NUMBER
            "?, " + //CURRENT_TIME
            "?, " + //CAN_DATA
            "? " + //ADD_TIME
            ")";
    static final String carGbInsertSql="upsert into PHOENIX_CAR_GB_HISTORY " +
            "(CS_VIN,ADD_TIME,CURRENT_TIME,GB_DATA,CS_ACCESS,CS_PROTOCOL," +
            "GB_TYPE,CS_VERIFY ) values (" +
            "?, " + //CS_VIN
            "?, " + //ADD_TIME
            "?, " + //CURRENT_TIME
            "?, " + //GB_DATA
            "?, " + //CS_ACCESS
            "?, " + //CS_PROTOCOL
            "?, " + //GB_TYPE
            "? " + //CS_VERIFY
            ")";
    static final String carStateInsertSql = "upsert into PHOENIX_CAR_STATE_HISTORY" +
            " (CS_NUMBER,CURRENT_TIME,CS_ACCESS,ADD_TIME,RENT_FLG,WARN_CODE," +
            "RFID,USER_RFID,OBD_MILES,ENGINE_TEMPE,TOTAL_MILES,SPEED,MOTOR_SPEED," +
            "OIL_COST,POWER_RESERVE,EV_BATTERY,CHARGING_STATUS,FUEL_MILES," +
            "ELEC_MILES,ENDUR_MILES,TEMPE,GPS_NUM,GPS_STRENGTH,GPS_VALID," +
            "LONGITUDE,LATITUDE,DIRECTION_ANGLE,CIRCULAR_MODE,PTC_STATUS," +
            "COMPRE_STATUS,FAN_MODE,SAVING_MODE,DOOR_STATUS,ENGINE_STATUS," +
            "KEY_STATUS,LIGHT_STATUS,LOCK_STATUS,NET_TYPE,BASE_LAC,BASE_CI," +
            "CUR_ORDER, NET_STRENGTH,GEAR,AUTOPILOT_STATUS,HANDBRAKE_STATUS ) values (" +
            "?, " + //CS_NUMBER
            "?, " + //CURRENT_TIME
            "?, " + //CS_ACCESS
            "?, " + //ADD_TIME
            "?, " + //RENT_FLG
            "?, " + //WARN_CODE
            "?, " + //RFID
            "?, " + //USER_RFID
            "?, " + //OBD_MILES
            "?, " + //ENGINE_TEMPE
            "?, " + //TOTAL_MILES
            "?, " + //SPEED
            "?, " + //MOTOR_SPEED
            "?, " + //OIL_COST
            "?, " + //POWER_RESERVE
            "?, " + //EV_BATTERY
            "?, " + //CHARGING_STATUS
            "?, " + //FUEL_MILES
            "?, " + //ELEC_MILES
            "?, " + //ENDUR_MILES
            "?, " + //TEMPE
            "?, " + //GPS_NUM
            "?, " + //GPS_STRENGTH
            "?, " + //GPS_VALID
            "?, " + //LONGITUDE
            "?, " + //LATITUDE
            "?, " + //DIRECTION_ANGLE
            "?, " + //CIRCULAR_MODE
            "?, " + //PTC_STATUS
            "?, " + //COMPRE_STATUS
            "?, " + //FAN_MODE
            "?, " + //SAVING_MODE
            "?, " + //DOOR_STATUS
            "?, " + //ENGINE_STATUS
            "?, " + //KEY_STATUS
            "?, " + //LIGHT_STATUS
            "?, " + //LOCK_STATUS
            "?, " + //NET_TYPE
            "?, " + //BASE_LAC
            "?, " + //BASE_CI
            "?, " + //CUR_ORDER
            "?, " + //NET_STRENGTH
            "?, " + //GEAR
            "?, " + //AUTOPILOT
            "? " + //HANDBRAKE
            ")";


    public void insertBulid(CarState carState, PreparedStatement carStatePs) throws SQLException {
        String cs_number = carState.getCs_number();
        Long current_time = carState.getCurrent_time();
        Integer cs_access = carState.getCs_access();
        Long add_time = carState.getAdd_time();
        Integer rent_flg = carState.getRent_flg();
        String warn_code = carState.getWarn_code();
        String rfid = carState.getRfid();
        String user_rfid = carState.getUser_rfid();
        Float obd_miles = carState.getObd_miles();
        Float engine_tempe = carState.getEngine_tempe();
        Float total_miles = carState.getTotal_miles();
        Float speed = carState.getSpeed();
        Float motor_speed = carState.getMotor_speed();
        Float oil_cost = carState.getOil_cost();
        Float power_reserve = carState.getPower_reserve();
        Float ev_battery = carState.getEv_battery();
        Integer charging_status = carState.getCharging_status();
        Float fuel_miles = carState.getFuel_miles();
        Float elec_miles = carState.getElec_miles();
        Float endur_miles = carState.getEndur_miles();
        Float tempe = carState.getTempe();
        Integer gps_num = carState.getGps_num();
        Integer gps_strength = carState.getGps_strength();
        Integer gps_valid = carState.getGps_valid();
        Double longitude = carState.getLongitude();
        Double latitude = carState.getLatitude();
        Float direction_angle = carState.getDirection_angle();
        Integer circular_mode = carState.getCircular_mode();
        Integer ptc_status = carState.getPtc_status();
        Integer compre_status = carState.getCompre_status();
        Integer fan_mode = carState.getFan_mode();
        Integer saving_mode = carState.getSaving_mode();
        Integer door_status = carState.getDoor_status();
        Integer engine_status = carState.getEngine_status();
        Integer key_status = carState.getKey_status();
        Integer light_status = carState.getLight_status();
        Integer lock_status = carState.getLock_status();
        String net_type = carState.getNet_type();
        String base_lac = carState.getBase_lac();
        String base_ci = carState.getBase_ci();
        String cur_order = carState.getCur_order();
        Integer net_strength = carState.getNet_strength();
        Integer gear = carState.getGear();
        Integer autopilot=carState.getAutopilot_status();
        Integer handbrake=carState.getHandbrake_status();

        carStatePs.setString(1, cs_number);
        carStatePs.setLong(2, current_time);
        if (cs_access == null) {
            carStatePs.setNull(3, Types.INTEGER);
        } else {
            carStatePs.setInt(3, cs_access);
        }
        if (add_time == null) {
            carStatePs.setNull(4, Types.BIGINT);
        } else {
            carStatePs.setLong(4, add_time);
        }
        if (rent_flg == null) {
            carStatePs.setNull(5, Types.INTEGER);
        } else {
            carStatePs.setInt(5, rent_flg);
        }
        carStatePs.setString(6, warn_code);
        carStatePs.setString(7, rfid);
        carStatePs.setString(8, user_rfid);
        if (obd_miles == null) {
            carStatePs.setFloat(9, 0F);
        } else {
            carStatePs.setFloat(9, obd_miles);
        }
        if (engine_tempe == null) {
            carStatePs.setNull(10, Types.FLOAT);
        } else {
            carStatePs.setFloat(10, engine_tempe);
        }
        if (total_miles == null) {
            carStatePs.setNull(11, Types.FLOAT);
        } else {
            carStatePs.setFloat(11, total_miles);
        }
        if (speed == null) {
            carStatePs.setNull(12, Types.FLOAT);
        } else {
            carStatePs.setFloat(12, speed);
        }
        if (motor_speed == null) {
            carStatePs.setNull(13, Types.FLOAT);
        } else {
            carStatePs.setFloat(13, motor_speed);
        }
        if (oil_cost == null) {
            carStatePs.setNull(14, Types.FLOAT);
        } else {
            carStatePs.setFloat(14, oil_cost);
        }
        if (power_reserve == null) {
            carStatePs.setNull(15, Types.FLOAT);
        } else {
            carStatePs.setFloat(15, power_reserve);
        }
        if (ev_battery == null) {
            carStatePs.setNull(16, Types.FLOAT);
        } else {
            carStatePs.setFloat(16, ev_battery);
        }
        if (charging_status == null) {
            carStatePs.setNull(17, Types.INTEGER);
        } else {
            carStatePs.setInt(17, charging_status);
        }
        if (fuel_miles == null) {
            carStatePs.setNull(18, Types.FLOAT);
        } else {
            carStatePs.setFloat(18, fuel_miles);
        }
        if (elec_miles == null) {
            carStatePs.setNull(19, Types.FLOAT);
        } else {
            carStatePs.setFloat(19, elec_miles);
        }
        if (endur_miles == null) {
            carStatePs.setNull(20, Types.FLOAT);
        } else {
            carStatePs.setFloat(20, endur_miles);
        }
        if (tempe == null) {
            carStatePs.setNull(21, Types.FLOAT);
        } else {
            carStatePs.setFloat(21, tempe);
        }
        if (gps_num == null) {
            carStatePs.setNull(22, Types.INTEGER);
        } else {
            carStatePs.setInt(22, gps_num);
        }
        if (gps_strength == null) {
            carStatePs.setNull(23, Types.INTEGER);
        } else {
            carStatePs.setInt(23, gps_strength);
        }
        if (gps_valid == null) {
            carStatePs.setNull(24, Types.INTEGER);
        } else {
            carStatePs.setInt(24, gps_valid);
        }
        if (longitude == null) {
            carStatePs.setNull(25, Types.DOUBLE);
        } else {
            carStatePs.setDouble(25, longitude);
        }
        if (latitude == null) {
            carStatePs.setNull(26, Types.DOUBLE);
        } else {
            carStatePs.setDouble(26, latitude);
        }
        if (direction_angle == null) {
            carStatePs.setNull(27, Types.FLOAT);
        } else {
            carStatePs.setFloat(27, direction_angle);
        }
        if (circular_mode == null) {
            carStatePs.setNull(28, Types.INTEGER);
        } else {
            carStatePs.setInt(28, circular_mode);
        }
        if (ptc_status == null) {
            carStatePs.setNull(29, Types.INTEGER);
        } else {
            carStatePs.setInt(29, ptc_status);
        }
        if (compre_status == null) {
            carStatePs.setNull(30, Types.INTEGER);
        } else {
            carStatePs.setInt(30, compre_status);
        }
        if (fan_mode == null) {
            carStatePs.setNull(31, Types.INTEGER);
        } else {
            carStatePs.setInt(31, fan_mode);
        }
        if (saving_mode == null) {
            carStatePs.setNull(32, Types.INTEGER);
        } else {
            carStatePs.setInt(32, saving_mode);
        }
        if (door_status == null) {
            carStatePs.setNull(33, Types.INTEGER);
        } else {
            carStatePs.setInt(33, door_status);
        }
        if (engine_status == null) {
            carStatePs.setNull(34, Types.INTEGER);
        } else {
            carStatePs.setInt(34, engine_status);
        }
        if (key_status == null) {
            carStatePs.setNull(35, Types.INTEGER);
        } else {
            carStatePs.setInt(35, key_status);
        }
        if (light_status == null) {
            carStatePs.setNull(36, Types.INTEGER);
        } else {
            carStatePs.setInt(36, light_status);
        }
        if (lock_status == null) {
            carStatePs.setNull(37, Types.INTEGER);
        } else {
            carStatePs.setInt(37, lock_status);
        }
        carStatePs.setString(38, net_type);
        carStatePs.setString(39, base_lac);
        carStatePs.setString(40, base_ci);
        carStatePs.setString(41, cur_order);
        if (net_strength == null){
            carStatePs.setNull(42,Types.INTEGER);
        }else {
            carStatePs.setInt(42,net_strength);
        }
        if (gear == null){
            carStatePs.setNull(43,Types.INTEGER);
        }else {
            carStatePs.setInt(43,gear);
        }
        if (autopilot == null){
            carStatePs.setNull(44,Types.INTEGER);
        }else {
            carStatePs.setInt(44,autopilot);
        }
        if (handbrake == null){
            carStatePs.setNull(45,Types.INTEGER);
        }else {
            carStatePs.setInt(45,handbrake);
        }
        carStatePs.addBatch();
    }

    public void insertBulid(CarCan historyDate, PreparedStatement preparedStatement) throws SQLException {
        String cs_number = historyDate.getCs_number();
        Long current_time = historyDate.getCurrent_time();
        String can_data = historyDate.getCan_data();
        Long add_time = historyDate.getAdd_time();
        preparedStatement.setString(1,cs_number);
        preparedStatement.setLong(2,current_time);
        preparedStatement.setString(3,can_data);
        preparedStatement.setLong(4,add_time);
        preparedStatement.addBatch();
    }

    public void insertBulid(CarGb carGb, PreparedStatement preparedStatement) throws SQLException {
        String cs_vin = carGb.getCs_vin();
        Long add_time = carGb.getAdd_time();
        Long current_time = carGb.getCurrent_time();
        String gb_data = carGb.getGb_data();
        Integer cs_access = carGb.getCs_access();
        Integer cs_protocol = carGb.getCs_protocol();
        Integer gb_type = carGb.getGb_type();
        Integer cs_verify = carGb.getCs_verify();
        preparedStatement.setString(1,cs_vin);
        preparedStatement.setLong(2,add_time);
        //logger.info("国标赋值前判断。");
        if (current_time == null) {
            preparedStatement.setNull(3, Types.BIGINT);
        } else {
            preparedStatement.setLong(3, current_time);
        }
        preparedStatement.setString(4,gb_data);
        if (cs_access == null){
            preparedStatement.setNull(5,Types.INTEGER);
        }else {
            preparedStatement.setInt(5, cs_access);
        }
        if (cs_protocol == null){
            preparedStatement.setNull(6,Types.INTEGER);
        }else {
            preparedStatement.setInt(6, cs_protocol);
        }
        if (gb_type == null){
            preparedStatement.setNull(7,Types.INTEGER);
        }else {
            preparedStatement.setInt(7, gb_type);
        }
        if (cs_verify == null){
            preparedStatement.setNull(8,Types.INTEGER);
        }else {
            preparedStatement.setInt(8, cs_verify);
        }
        //logger.info("国标赋值完。");
        preparedStatement.addBatch();
    }


    @Override
    public void insertBulid(Object historyDate, PreparedStatement preparedStatement) throws SQLException {
        String clazzName=historyDate.getClass().getName();
        switch (clazzName){
            case "com.ccclubs.phoenix.orm.model.CarCan":
                insertBulid((CarCan)historyDate,preparedStatement);
                break;
            case "com.ccclubs.phoenix.orm.model.CarGb":
                insertBulid((CarGb)historyDate,preparedStatement);
                break;
            case "com.ccclubs.phoenix.orm.model.CarState":
                insertBulid((CarState)historyDate,preparedStatement);
                break;
            default:break;
        }
    }

    @Override
    public void saveOrUpdate(List records) {
        String clazzName=records.get(0).getClass().getName();
        switch (clazzName){
            case "com.ccclubs.phoenix.orm.model.CarCan":
                baseImpl.saveOrUpdate((List<CarCan>) records,this,carCanInsertSql,"CarCan");
                break;
            case "com.ccclubs.phoenix.orm.model.CarGb":
                baseImpl.saveOrUpdate((List<CarGb>)records,this,carGbInsertSql,"CarGb");
                break;
            case "com.ccclubs.phoenix.orm.model.CarState":
                baseImpl.saveOrUpdate((List<CarState>)records,this,carStateInsertSql,"CarState");
                break;
            default:break;
        }
    }
}
