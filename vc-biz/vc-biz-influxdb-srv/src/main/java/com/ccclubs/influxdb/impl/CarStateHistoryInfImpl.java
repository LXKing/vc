package com.ccclubs.influxdb.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.frm.spring.entity.DateTimeUtil;
import com.ccclubs.influxdb.inf.CarStateHistoryInf;
import com.ccclubs.influxdb.input.CarCanHistoryParam;
import com.ccclubs.influxdb.input.CarStateHistoryParam;
import com.ccclubs.influxdb.model.CarCan;
import com.ccclubs.influxdb.model.CarState;
import com.ccclubs.influxdb.version.InfluxdbServiceVersion;
import org.influxdb.dto.Point;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.influxdb.impl.InfluxDBResultMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.influxdb.InfluxDBTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/1/30 0030.
 */

@Service(version= InfluxdbServiceVersion.V1)
public class CarStateHistoryInfImpl implements CarStateHistoryInf {
    Logger logger= LoggerFactory.getLogger(CarStateHistoryInfImpl.class);


    @Autowired
    private InfluxDBTemplate<Point> influxDBTemplate;

    private InfluxDBResultMapper resultMapper = new InfluxDBResultMapper() ;
    //
    @Override
    public void insert( List<CarState> recordList) {
        int i = 0;
        List<Point> pointList=new ArrayList<>();
        for (CarState carState : recordList) {
            Point point = Point.measurement("INFLUXDB_CAR_STATE_HISTORY")
                    .time(DateTimeUtil.date2UnixFormat(carState.getCurrent_time(),"yyyy-MM-dd HH:mm:ss") , TimeUnit.MILLISECONDS)
                    .tag("cs_number", carState.getCs_number())
                    .tag("cs_access",carState.getCs_access())
                    .addField("add_time", carState.getAdd_time())
                    .addField("current_datetime", carState.getCurrent_datetime())
                    .addField("rent_flg", carState.getRent_flg())
                    .addField("warn_code", carState.getWarn_code())
                    .addField("rfid",carState.getRfid())
                    .addField("user_rfid",carState.getUser_rfid())
                    .addField("obd_miles",carState.getObd_miles())
                    .addField("engine_tempe",carState.getEngine_tempe())
                    .addField("total_miles",carState.getTotal_miles())
                    .addField("speed",carState.getSpeed())
                    .addField("motor_speed",carState.getMotor_speed())
                    .addField("oil_cost",carState.getOil_cost())
                    .addField("power_reserve",carState.getPower_reserve())
                    .addField("ev_battery",carState.getEv_battery())
                    .addField("charging_status",carState.getCharging_status())
                    .addField("fuel_miles",carState.getFuel_miles())
                    .addField("elec_miles",carState.getElec_miles())
                    .addField("tempe",carState.getTempe())
                    .addField("gps_num",carState.getGps_num())
                    .addField("gps_strength",carState.getGps_strength())
                    .addField("gps_valid",carState.getGps_valid())
                    .addField("net_strength",carState.getNet_strength())
                    .addField("longitude",carState.getLongitude())
                    .addField("latitude",carState.getLatitude())
                    .addField("direction_angle",carState.getDirection_angle())
                    .addField("circular_mode",carState.getCircular_mode())
                    .addField("ptc_status",carState.getPtc_status())
                    .addField("compre_status",carState.getCompre_status())
                    .addField("fan_mode",carState.getFan_mode())
                    .addField("saving_mode",carState.getSaving_mode())
                    .addField("saving_mode_str",carState.getSaving_mode_str())
                    .addField("door_status",carState.getDoor_status())
                    .addField("engine_status",carState.getEngine_status())
                    .addField("key_status",carState.getKey_status())
                    .addField("light_status",carState.getLight_status())
                    .addField("lock_status",carState.getLock_status())
                    .addField("net_type",carState.getNet_type())
                    .addField("base_lac",carState.getBase_lac())
                    .addField("base_ci",carState.getBase_ci())
                    .addField("cur_order",carState.getCur_order())
                    .addField("gear",carState.getGear())
                    .build();
            //将单条数据存储到集合中
            pointList.add(point);
            i++;
            //每读取1万条数据提交到influxdb存储一次
            if (i / 6000== 1) {
                i = 0;
                logger.info("influxdb 6千条CarState数据开始批量插入");
                influxDBTemplate.write(pointList);
                pointList.clear();
                try{
                    Thread.sleep(1000*1);//暂停一分钟
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }
        logger.info("influxdb 不到6千条CarState数据开始批量插入");
        influxDBTemplate.write(pointList);
    }

    @Override
    public List<CarState> selectCarStateListByCondition(CarStateHistoryParam carStateHistoryParam) {
        String sql = "select " +
                " cs_number, time , cs_access, add_time, rent_flg, warn_code," +
                " rfid, user_rfid,obd_miles, engine_tempe,total_miles, speed," +
                " motor_speed,oil_cost,power_reserve,ev_battery, charging_status," +
                " fuel_miles,elec_miles,endur_miles,tempe,gps_num, gps_strength," +
                " gps_valid,longitude,latitude,direction_angle, circular_mode, ptc_status," +
                " compre_status,fan_mode,saving_mode, door_status, engine_status, key_status," +
                " light_status,lock_status,net_type,base_lac,  base_ci, cur_order, net_strength, gear" +
                " from  INFLUXDB_CAR_STATE_HISTORY  ";


        StringBuffer sb=null;
        if (carStateHistoryParam!=null) {
            sb=new StringBuffer();
            if(carStateHistoryParam.getCs_number()!=null) {
                sb.append("where  cs_number="+ "\'"+carStateHistoryParam.getCs_number()+"\'");
            }
            //
            if (carStateHistoryParam.getStart_time()!=null&&carStateHistoryParam.getEnd_time()!=null){
                if(sb.length()>1){
                    sb.append(" and time >= "+ DateTimeUtil.date2UnixFormat(carStateHistoryParam.getStart_time(),"yyyy-MM-dd HH:mm:ss")*1000*1000+ " and  time<="+DateTimeUtil.date2UnixFormat(carStateHistoryParam.getEnd_time(),"yyyy-MM-dd HH:mm:ss")*1000*1000);
                }else{
                    sb.append(" where time >= "+ DateTimeUtil.date2UnixFormat(carStateHistoryParam.getStart_time(),"yyyy-MM-dd HH:mm:ss")*1000*1000+ " and  time<="+DateTimeUtil.date2UnixFormat(carStateHistoryParam.getEnd_time(),"yyyy-MM-dd HH:mm:ss")*1000*1000);
                }
            }
            sb.append(" order by time "+carStateHistoryParam.getOrder());
            //
            if(carStateHistoryParam.getPage_no()!=null&&carStateHistoryParam.getPage_size()!=null){
                int startPage=carStateHistoryParam.getPage_no()+1;
                int endPage=startPage*carStateHistoryParam.getPage_size()+carStateHistoryParam.getPage_size();
                sb.append(" limit ").append(endPage).append(" offset ").append(startPage);
            }
            //
            sql=sql+sb.toString();
        }
        //
        Query query = new Query(sql, influxDBTemplate.getDatabase());
        //
        logger.info("influxdb 查询CarState数据");
        QueryResult result = influxDBTemplate.query(query);
        List<CarState> carStateList = resultMapper.toPOJO(result, CarState.class);
        return carStateList;
    }
}
