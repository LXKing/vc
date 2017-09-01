package com.ccclubs.olap.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ccclubs.olap.bean.Cs_vehicle_machine_rel;
import com.ccclubs.olap.bean.Vehicle_zhifa;
import com.ccclubs.olap.util.DBHelper;

import java.sql.SQLException;
import java.util.*;

public class VehicleService {
    //按批次封装待计算的车机
    public List<List<Cs_vehicle_machine_rel>> waitVehicleList(int calSize) throws SQLException {
        DBHelper dbHelper = new DBHelper();
        String sql = " select cs_vin,cs_number,cs_car_no,cs_vender from cs_vehicle_machine_rel where cs_te_no is not null and char_length(cs_vin)=17 order by cs_number ";
        JSONArray array = dbHelper.queryRecords(sql);
        int sizeCount=0;
        List<Cs_vehicle_machine_rel> cs_vehicle_machine_rel_list=new ArrayList<>();
        List<List<Cs_vehicle_machine_rel>> waitList = new ArrayList<>();
        for(Object object:array){
            JSONObject jsonObject = (JSONObject)object;
            String cs_vin = jsonObject.getString("cs_vin");
            String cs_number = jsonObject.getString("cs_number");
            String cs_car_no = jsonObject.getString("cs_car_no");
            String cs_vender = jsonObject.getString("cs_vender");
            Cs_vehicle_machine_rel cs_vehicle_machine_rel = new Cs_vehicle_machine_rel();
            cs_vehicle_machine_rel.setCs_vin(cs_vin);
            cs_vehicle_machine_rel.setCs_number(cs_number);
            cs_vehicle_machine_rel.setCs_car_no(cs_car_no);
            cs_vehicle_machine_rel.setCs_vender(cs_vender);
            sizeCount++;
            if(sizeCount<=calSize){
                cs_vehicle_machine_rel_list.add(cs_vehicle_machine_rel);
            }
            else{
                waitList.add(cs_vehicle_machine_rel_list);
                sizeCount=0;
                cs_vehicle_machine_rel_list=new ArrayList<>();
            }
        }
        if(cs_vehicle_machine_rel_list.size()>0){
            waitList.add(cs_vehicle_machine_rel_list);
        }
        return waitList;
    }

    //按批次封装待计算的车机(长安)
    public List<List<Cs_vehicle_machine_rel>> waitVehicleListForCa(int calSize) throws SQLException {
        DBHelper dbHelper = new DBHelper();
        String sql = " select a.cs_vin,a.cs_number,a.cs_car_no,a.cs_vender from cs_vehicle_machine_rel a inner join car_operate_time_temporary b on a.cs_number=b.csc_number where a.cs_te_no is not null and char_length(a.cs_vin)=17 order by a.cs_number ";
        JSONArray array = dbHelper.queryRecords(sql);
        int sizeCount=0;
        List<Cs_vehicle_machine_rel> cs_vehicle_machine_rel_list=new ArrayList<>();
        List<List<Cs_vehicle_machine_rel>> waitList = new ArrayList<>();
        for(Object object:array){
            JSONObject jsonObject = (JSONObject)object;
            String cs_vin = jsonObject.getString("cs_vin");
            String cs_number = jsonObject.getString("cs_number");
            String cs_car_no = jsonObject.getString("cs_car_no");
            String cs_vender = jsonObject.getString("cs_vender");
            Cs_vehicle_machine_rel cs_vehicle_machine_rel = new Cs_vehicle_machine_rel();
            cs_vehicle_machine_rel.setCs_vin(cs_vin);
            cs_vehicle_machine_rel.setCs_number(cs_number);
            cs_vehicle_machine_rel.setCs_car_no(cs_car_no);
            cs_vehicle_machine_rel.setCs_vender(cs_vender);
            sizeCount++;
            if(sizeCount<=calSize){
                cs_vehicle_machine_rel_list.add(cs_vehicle_machine_rel);
            }
            else{
                waitList.add(cs_vehicle_machine_rel_list);
                sizeCount=0;
                cs_vehicle_machine_rel_list=new ArrayList<>();
            }
        }
        if(cs_vehicle_machine_rel_list.size()>0){
            waitList.add(cs_vehicle_machine_rel_list);
        }
        return waitList;
    }

    //按批次封装待计算的车机(众泰)
    public List<List<Cs_vehicle_machine_rel>> waitVehicleListForZT(int calSize) throws SQLException {
        DBHelper dbHelper = new DBHelper();
        String sql = " select a.cs_vin,a.cs_number,a.cs_car_no,a.cs_vender from cs_vehicle_machine_rel a  where a.cs_te_no is not null and char_length(a.cs_vin)=17 and cs_vender='zt' order by a.cs_number ";
        JSONArray array = dbHelper.queryRecords(sql);
        int sizeCount=0;
        List<Cs_vehicle_machine_rel> cs_vehicle_machine_rel_list=new ArrayList<>();
        List<List<Cs_vehicle_machine_rel>> waitList = new ArrayList<>();
        for(Object object:array){
            JSONObject jsonObject = (JSONObject)object;
            String cs_vin = jsonObject.getString("cs_vin");
            String cs_number = jsonObject.getString("cs_number");
            String cs_car_no = jsonObject.getString("cs_car_no");
            String cs_vender = jsonObject.getString("cs_vender");
            Cs_vehicle_machine_rel cs_vehicle_machine_rel = new Cs_vehicle_machine_rel();
            cs_vehicle_machine_rel.setCs_vin(cs_vin);
            cs_vehicle_machine_rel.setCs_number(cs_number);
            cs_vehicle_machine_rel.setCs_car_no(cs_car_no);
            cs_vehicle_machine_rel.setCs_vender(cs_vender);
            sizeCount++;
            if(sizeCount<=calSize){
                cs_vehicle_machine_rel_list.add(cs_vehicle_machine_rel);
            }
            else{
                waitList.add(cs_vehicle_machine_rel_list);
                sizeCount=0;
                cs_vehicle_machine_rel_list=new ArrayList<>();
            }
        }
        if(cs_vehicle_machine_rel_list.size()>0){
            waitList.add(cs_vehicle_machine_rel_list);
        }
        return waitList;
    }

    //获取电车列表
    public List<Cs_vehicle_machine_rel> waitVehicleForElectric() throws SQLException {
        DBHelper dbHelper = new DBHelper();
        String sql = " select a.csc_id,a.csc_number,a.csc_car_no,a.csc_model from ccclubs_cg_platform.cs_car a where a.csc_model=1 or a.csc_model=2 ";
        JSONArray array = dbHelper.queryRecords(sql);
        List<Cs_vehicle_machine_rel> cs_vehicle_machine_rel_list=new ArrayList<>();
        Cs_vehicle_machine_rel  cs_vehicle_machine_rel = null;
        for(Object object:array){
            cs_vehicle_machine_rel = new Cs_vehicle_machine_rel();
            JSONObject jsonObject = (JSONObject)object;
            //车机号
            String cs_number=jsonObject.getString("csc_number");
            //车牌号
            String cs_car_no=jsonObject.getString("csc_car_no");
            //车辆类型(1:电动车  2:汽油车)
            int car_type=1;

            cs_vehicle_machine_rel.setCs_number(cs_number);
            cs_vehicle_machine_rel.setCs_car_no(cs_car_no);
            cs_vehicle_machine_rel_list.add(cs_vehicle_machine_rel);

        }
        return cs_vehicle_machine_rel_list;
    }

    //获取汽油车列表
    public List<Cs_vehicle_machine_rel> waitVehicleForFuel() throws SQLException {
        DBHelper dbHelper = new DBHelper();
        String sql = " select a.csc_id,a.csc_number,a.csc_car_no,a.csc_model from ccclubs_cg_platform.cs_car a where a.csc_model!=1 and a.csc_model!=2 ";
        JSONArray array = dbHelper.queryRecords(sql);
        List<Cs_vehicle_machine_rel> cs_vehicle_machine_rel_list=new ArrayList<>();
        Cs_vehicle_machine_rel  cs_vehicle_machine_rel = null;
        for(Object object:array){
            cs_vehicle_machine_rel = new Cs_vehicle_machine_rel();
            JSONObject jsonObject = (JSONObject)object;
            //车机号
            String cs_number=jsonObject.getString("csc_number");
            //车牌号
            String cs_car_no=jsonObject.getString("csc_car_no");
            //车辆类型(1:电动车  2:汽油车)
            int car_type=2;

            cs_vehicle_machine_rel.setCs_number(cs_number);
            cs_vehicle_machine_rel.setCs_car_no(cs_car_no);
            cs_vehicle_machine_rel_list.add(cs_vehicle_machine_rel);

        }
        return cs_vehicle_machine_rel_list;
    }

    //获取指定时间范围内的所有汽车状态数据
    public Map<String,List<Vehicle_zhifa>> getZhiFaCarStateMap(String start_time,String end_time) throws SQLException {
        DBHelper dbHelper = new DBHelper();
        Map<String,List<Vehicle_zhifa>> vehicle_map = new HashMap<>();
        String sql = " select a.cshs_number,a.cshs_add_time,cshs_speed,cshs_ev_battery,cshs_longitude,cshs_latitude from ccclubs_cg_platform.cs_history_state a where a.cshs_add_time>='%s' and a.cshs_add_time<='%s' order by a.cshs_number,a.cshs_add_time asc ";
        sql = String.format(sql,start_time,end_time);
        JSONArray array = dbHelper.queryRecords(sql);
        Vehicle_zhifa vehicle_zhifa = null;
        for(Object object:array){
            JSONObject jsonObject = (JSONObject)object;
            //车机号
            String cs_number = jsonObject.getString("cshs_number");
            //车速
            float speed = 0;
            try {
                speed = Float.parseFloat(jsonObject.getString("cshs_speed"));
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
            //电量
            int soc=0;
            try {
                soc = Integer.parseInt(jsonObject.getString("cshs_ev_battery"));
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
            //经度
            double longitude=0.000000d;
            try {
                longitude = Double.parseDouble(jsonObject.getString("cshs_longitude"));
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
            //纬度
            double latitude=0.000000d;
            try {
                latitude = Double.parseDouble(jsonObject.getString("cshs_latitude"));
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
            //发生时间
            String add_time = jsonObject.getString("cshs_add_time");

            vehicle_zhifa = new Vehicle_zhifa();
            vehicle_zhifa.setCs_number(cs_number);
            vehicle_zhifa.setSoc(soc);
            vehicle_zhifa.setSpeed(speed);
            vehicle_zhifa.setLongitude(longitude);
            vehicle_zhifa.setLatitude(latitude);
            vehicle_zhifa.setAdd_time(add_time);
            if(vehicle_map.containsKey(cs_number)){
                List<Vehicle_zhifa>  Vehicle_zhifa_list= vehicle_map.get(cs_number);
                Vehicle_zhifa_list.add(vehicle_zhifa);
            }
            else{
                List<Vehicle_zhifa>  Vehicle_zhifa_list= new ArrayList<>();
                Vehicle_zhifa_list.add(vehicle_zhifa);
                vehicle_map.put(cs_number,Vehicle_zhifa_list);
            }
        }
        return vehicle_map;
    }




    public static void main(String[] args) throws SQLException {
        VehicleService vehicleService = new VehicleService();
        //List<Cs_vehicle_machine_rel> waitList = vehicleService.waitVehicleForElectric();
        List<Cs_vehicle_machine_rel> waitList = vehicleService.waitVehicleForFuel();
        System.out.println();
    }
}
