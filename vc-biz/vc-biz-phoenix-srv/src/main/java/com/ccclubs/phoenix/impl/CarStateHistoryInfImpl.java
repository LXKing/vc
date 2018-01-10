package com.ccclubs.phoenix.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.ccclubs.frm.spring.entity.DateTimeUtil;
import com.ccclubs.hbase.phoenix.config.PhoenixHelper;
import com.ccclubs.phoenix.inf.CarStateHistoryInf;
import com.ccclubs.phoenix.input.CarStateHistoryParam;
import com.ccclubs.phoenix.orm.consts.VehicleConsts;
import com.ccclubs.phoenix.orm.mapper.CarStateMapper;
import com.ccclubs.phoenix.orm.model.CarState;
import com.ccclubs.phoenix.orm.model.Pace;
import com.ccclubs.phoenix.orm.model.PaceBlock;
import com.ccclubs.phoenix.output.CarStateHistoryOutput;
import com.ccclubs.phoenix.util.VehicleUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Module Desc:
 * User: taosm
 * DateTime: 2017/11/28 0028
 */
@org.springframework.stereotype.Service
@Service(version = "1.0.0")
public class CarStateHistoryInfImpl implements CarStateHistoryInf {

    static  final Logger logger= LoggerFactory.getLogger(CarStateHistoryInfImpl.class);

    static final String insert_sql = "upsert into " +
            "PHOENIX_CAR_STATE_HISTORY " +
            "(" +
            "CS_NUMBER," +
            "CURRENT_TIME," +
            "CS_ACCESS," +
            "ADD_TIME," +
            "RENT_FLG," +
            "WARN_CODE," +
            "RFID," +
            "USER_RFID," +
            "OBD_MILES," +
            "ENGINE_TEMPE," +
            "TOTAL_MILES," +
            "SPEED," +
            "MOTOR_SPEED," +
            "OIL_COST," +
            "POWER_RESERVE," +
            "EV_BATTERY," +
            "CHARGING_STATUS," +
            "FUEL_MILES," +
            "ELEC_MILES," +
            "ENDUR_MILES," +
            "TEMPE," +
            "GPS_NUM," +
            "GPS_STRENGTH," +
            "GPS_VALID," +
            "LONGITUDE," +
            "LATITUDE," +
            "DIRECTION_ANGLE," +
            "CIRCULAR_MODE," +
            "PTC_STATUS," +
            "COMPRE_STATUS," +
            "FAN_MODE," +
            "SAVING_MODE," +
            "DOOR_STATUS," +
            "ENGINE_STATUS," +
            "KEY_STATUS," +
            "LIGHT_STATUS," +
            "LOCK_STATUS," +
            "NET_TYPE," +
            "BASE_LAC," +
            "BASE_CI," +
            "CUR_ORDER, " +
            "NET_STRENGTH," +
            "GEAR" +
            " " +
            ") " +
            "values " +
            "(" +
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
            "? " + //GEAR
            ")";


    static final String count_sql = "select " +
            "count(cs_number) as total " +
            "from phoenix_car_state_history " +
            "where cs_number=? " +
            "and current_time>=? " +
            "and current_time<=? ";




    @Autowired
    private JdbcTemplate phoenixJdbcTemplate;

    @Autowired
    private PhoenixHelper phoenixHelper;

    @Override
    public List<CarState> queryCarStateListNoPage(final CarStateHistoryParam carStateHistoryParam) {
        final String queryFields = carStateHistoryParam.getQuery_fields();
        String query_sql = "select " +
                queryFields + " " +
                "from phoenix_car_state_history " +
                "where cs_number=? " +
                "and current_time>=? " +
                "and current_time<=? " +
                "order by current_time  " + carStateHistoryParam.getOrder() + " ";

        List<CarState> carStateList = new ArrayList<CarState>();
        long start_mills = System.currentTimeMillis();
        List<JSONObject> jsonObjList = phoenixJdbcTemplate.query(query_sql,
                new PreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps) throws SQLException {
                        String cs_number = carStateHistoryParam.getCs_number();
                        long start_time = DateTimeUtil.date2UnixFormat(carStateHistoryParam.getStart_time(), DateTimeUtil.UNIX_FORMAT);
                        long end_time = DateTimeUtil.date2UnixFormat(carStateHistoryParam.getEnd_time(), DateTimeUtil.UNIX_FORMAT);
                        ps.setString(1, cs_number);
                        ps.setLong(2, start_time);
                        ps.setLong(3, end_time);
                    }
                },
                new CarStateMapper());

        CarState carState = null;
        for (JSONObject jsonObject : jsonObjList) {
            carState = new CarState();
            String[] fields = queryFields.split(",");
            for (String field : fields) {
                try {
                    BeanUtils.setProperty(carState, field, jsonObject.get(StringUtils.upperCase(field)));
                } catch (Exception ex) {

                }
            }
            carStateList.add(carState);
        }
        long end_mills=System.currentTimeMillis();
        long cost_seconds=(end_mills-start_mills)/1000;
        System.out.println("本次查询耗时"+cost_seconds+"秒!");
        return carStateList;
    }
    @Override
    public List<CarState> queryCarStateListWithPage(final CarStateHistoryParam carStateHistoryParam) {
        Integer page_size = carStateHistoryParam.getPage_size();
        Integer page_no = carStateHistoryParam.getPage_no();
        final Integer limit = page_size;
        final Integer offset = (page_no - 1) * page_size;
        final String queryFields = carStateHistoryParam.getQuery_fields();
        String query_sql = "select " +
                queryFields + " " +
                "from phoenix_car_state_history " +
                "where cs_number=? " +
                "and current_time>=? " +
                "and current_time<=? " +
                "order by current_time  " + carStateHistoryParam.getOrder() + " " +
                "limit ? offset ? ";
        List<CarState> carStateList = new ArrayList<CarState>();
        List<JSONObject> jsonObjList = phoenixJdbcTemplate.query(query_sql,
                new PreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps) throws SQLException {
                        String cs_number = carStateHistoryParam.getCs_number();
                        long start_time = DateTimeUtil.date2UnixFormat(carStateHistoryParam.getStart_time(), DateTimeUtil.UNIX_FORMAT);
                        long end_time = DateTimeUtil.date2UnixFormat(carStateHistoryParam.getEnd_time(), DateTimeUtil.UNIX_FORMAT);
                        ps.setString(1, cs_number);
                        ps.setLong(2, start_time);
                        ps.setLong(3, end_time);
                        ps.setInt(4, limit);
                        ps.setInt(5, offset);
                    }
                },
                new CarStateMapper());
        CarState carState = null;
        for (JSONObject jsonObject : jsonObjList) {
            carState = new CarState();
            String[] fields = queryFields.split(",");
            for (String field : fields) {
                try {
                    BeanUtils.setProperty(carState, field, jsonObject.get(StringUtils.upperCase(field)));
                } catch (Exception ex) {

                }
            }
            carStateList.add(carState);
        }
        return carStateList;
    }


    @Override
    public Long queryCarStateListCount(final CarStateHistoryParam carStateHistoryParam) {
        long total = 0L;

        total = phoenixJdbcTemplate.execute(count_sql, new PreparedStatementCallback<Long>() {
            @Override
            public Long doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                String cs_number = carStateHistoryParam.getCs_number();
                long start_time = DateTimeUtil.date2UnixFormat(carStateHistoryParam.getStart_time(), DateTimeUtil.UNIX_FORMAT);
                long end_time = DateTimeUtil.date2UnixFormat(carStateHistoryParam.getEnd_time(), DateTimeUtil.UNIX_FORMAT);
                ps.setString(1, cs_number);
                ps.setLong(2, start_time);
                ps.setLong(3, end_time);
                ResultSet rs = ps.executeQuery();
                long record_count = 0;
                while (rs.next()) {
                    record_count = rs.getLong(1);
                }
                return record_count;
            }
        });
        return total;
    }
    @Override
    public CarStateHistoryOutput queryCarStateListByOutput(CarStateHistoryParam carStateHistoryParam) {
        CarStateHistoryOutput carStateHistoryOutput = new CarStateHistoryOutput();
        long total = -1L;
        //首先判断是否是分页查询
        if (carStateHistoryParam.getPage_no() > 0) {
//            //判断是否已获取过记录总数
//            total=carStateHistoryParam.getTotal();
//            //已经获取过记录总数
//            if(total>-1){
//                total = carStateHistoryParam.getTotal();
//            }
//            else{
//                total = queryCarStateListCount(carStateHistoryParam);
//            }
            total = queryCarStateListCount(carStateHistoryParam);
            List<CarState> carStateList = queryCarStateListWithPage(carStateHistoryParam);
            carStateHistoryOutput.setTotal(total);
            carStateHistoryOutput.setList(carStateList);
        }
        //非分页查询
        else {
            List<CarState> carStateList = queryCarStateListNoPage(carStateHistoryParam);
            carStateHistoryOutput.setList(carStateList);
        }
        return carStateHistoryOutput;
    }
    @Override
    //批量更新车辆状态数据
    public void saveOrUpdate(final List<CarState> records) {

        Connection connection = null;
        PreparedStatement carStatePs = null;
        try {
            connection = phoenixHelper.getConnection();
            carStatePs = connection.prepareStatement(insert_sql);
            Long count =0L;
            for(CarState carState:records){
                count++;
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
                    carStatePs.setNull(9, Types.FLOAT);
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
                carStatePs.addBatch();
                if(count%500==0){
                    carStatePs.executeBatch();
                    connection.commit();

                }
            }
            carStatePs.executeBatch();
            connection.commit();
        }
        catch (Exception e) {
            logger.info("car state phoenix throw a error"+e.getMessage());
            e.printStackTrace();
        }
        finally {
            if(carStatePs!=null){
                try {
                    carStatePs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    //驾驶阶段数据计算
    public List<Pace> calDrivePaceList(List<CarState> carStateList){
        List<Pace> paceList = null;
        Iterator<CarState> carStateIterator = carStateList.iterator();
        PaceService paceService = new PaceService();
        PaceBlock paceBlock = null;
        while (carStateIterator.hasNext()){
            CarState carState = carStateIterator.next();
            long current_time = carState.getCurrent_time();
            long fix_current_time = DateTimeUtil.getTimeMillsFixByInterval(current_time, VehicleConsts.DRIVE_MINUTES_INTERVAL);
            if(paceBlock==null){
                paceBlock=new PaceBlock();
                long block_start_timemills = fix_current_time;
                long block_end_timemills = fix_current_time+VehicleConsts.DRIVE_MINUTES_INTERVAL*60*1000;
                paceBlock.setCs_number(carState.getCs_number());
                paceBlock.setBlock_start_timemills(block_start_timemills);
                paceBlock.setBlock_end_timemills(block_end_timemills);
                List<CarState> recordList = paceBlock.getRecordList();
                recordList.add(carState);
            }
            else{
                long block_start_timemills = paceBlock.getBlock_start_timemills();
                long block_end_timemills = paceBlock.getBlock_end_timemills();
                if(current_time>=block_start_timemills&&current_time<block_end_timemills){
                    List<CarState> recordList = paceBlock.getRecordList();
                    recordList.add(carState);
                }
                else{
                    paceBlock = VehicleUtil.configPaceBlock(paceBlock,VehicleConsts.CAL_PACE_TYPE_DRIVE);
                    if(paceBlock!=null) {
                        paceService.addDrivePaceBlock(paceBlock);
                    }
                    paceBlock=new PaceBlock();
                    block_start_timemills = fix_current_time;
                    block_end_timemills = fix_current_time+VehicleConsts.DRIVE_MINUTES_INTERVAL*60*1000;
                    paceBlock.setCs_number(carState.getCs_number());
                    paceBlock.setBlock_start_timemills(block_start_timemills);
                    paceBlock.setBlock_end_timemills(block_end_timemills);
                    List<CarState> recordList = paceBlock.getRecordList();
                    recordList.add(carState);
                }
            }
        }
        if(paceBlock!=null){
            paceBlock=VehicleUtil.configPaceBlock(paceBlock,VehicleConsts.CAL_PACE_TYPE_DRIVE);
            paceService.addDrivePaceBlock(paceBlock);

        }
        paceList= paceService.getPaceList();
        return paceList;
    }

    @Override
    //充电阶段数据计算
    public List<Pace> calChargingPaceList(List<CarState> carStateList){
        List<Pace> paceList = null;
        Iterator<CarState> carStateIterator = carStateList.iterator();
        PaceService paceService = new PaceService();
        PaceBlock paceBlock = null;
        while (carStateIterator.hasNext()){
            CarState carState = carStateIterator.next();
            long current_time = carState.getCurrent_time();
            long fix_current_time = DateTimeUtil.getTimeMillsFixByInterval(current_time, VehicleConsts.CHARGING_MINUTES_INTERVAL);
            if(paceBlock==null){
                paceBlock=new PaceBlock();
                long block_start_timemills = fix_current_time;
                long block_end_timemills = fix_current_time+VehicleConsts.CHARGING_MINUTES_INTERVAL*60*1000;
                paceBlock.setCs_number(carState.getCs_number());
                paceBlock.setBlock_start_timemills(block_start_timemills);
                paceBlock.setBlock_end_timemills(block_end_timemills);
                List<CarState> recordList = paceBlock.getRecordList();
                recordList.add(carState);
            }
            else if(paceBlock!=null){
                long block_start_timemills = paceBlock.getBlock_start_timemills();
                long block_end_timemills = paceBlock.getBlock_end_timemills();
                if(current_time>=block_start_timemills&&current_time<block_end_timemills){
                    List<CarState> recordList = paceBlock.getRecordList();
                    recordList.add(carState);
                }
                else{
                    paceBlock = VehicleUtil.configPaceBlock(paceBlock,VehicleConsts.CAL_PACE_TYPE_CHARGING);
                    if(paceBlock!=null) {
                        paceService.addChargingPaceBlock(paceBlock);
                    }
                    paceBlock=new PaceBlock();
                    block_start_timemills = fix_current_time;
                    block_end_timemills = fix_current_time+VehicleConsts.CHARGING_MINUTES_INTERVAL*60*1000;
                    paceBlock.setCs_number(carState.getCs_number());
                    paceBlock.setBlock_start_timemills(block_start_timemills);
                    paceBlock.setBlock_end_timemills(block_end_timemills);
                    List<CarState> recordList = paceBlock.getRecordList();
                    recordList.add(carState);
                }
            }
        }
        if(paceBlock!=null){
            paceBlock= VehicleUtil.configPaceBlock(paceBlock, VehicleConsts.CAL_PACE_TYPE_CHARGING);
            paceService.addChargingPaceBlock(paceBlock);

        }
        paceList= paceService.getPaceList();
        return paceList;
    }



}
