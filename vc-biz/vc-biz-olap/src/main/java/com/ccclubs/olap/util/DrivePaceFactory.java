package com.ccclubs.olap.util;


import com.ccclubs.olap.bean.Pace;
import com.ccclubs.olap.bean.Vehicle_entire;

import java.util.ArrayList;
import java.util.List;

public class DrivePaceFactory {


    //状态出现次数
    private Integer status_num=0;

    //上一条记录
    private Vehicle_entire previousVehicleEntire;
    //当前记录
    private Vehicle_entire currentVehicleEntire;

    private List<Pace> paceList = new ArrayList<>();

    private List<Vehicle_entire> tempList = new ArrayList<>();

    public void addVehicleEntire(Vehicle_entire vehicle_entire){
        if(previousVehicleEntire==null&&currentVehicleEntire==null){
            previousVehicleEntire=vehicle_entire;
            currentVehicleEntire=vehicle_entire;
        }
        else{
            previousVehicleEntire=currentVehicleEntire;
            currentVehicleEntire=vehicle_entire;
        }
        //取得终结标识
        Integer terminate_flg = vehicle_entire.getTerminate_flg();
        //取得can充电状态
        Integer can_batt_status = vehicle_entire.getCan_batt_status();
        //取得车辆状态
        Integer cs_car_status = vehicle_entire.getCs_car_status();
        //省电状态
        Integer saving_status = vehicle_entire.getSaving_status();

        if(cs_car_status==null){
            cs_car_status=-1;
        }
        if(can_batt_status==null){
            can_batt_status=-1;
        }
        if(saving_status==null){
            saving_status=-1;
        }


        //判断是否为车辆启动状态
        if(cs_car_status==1){
            status_num=0;
            //判断是否间隔超过1小时
            if(calIntervalTimeMills()>3600000){
                Pace pace = createNewPace(tempList);
                if(pace!=null){
                    //驾驶间隔大于5分钟且行驶里程大于等于1公里
                    if(pace.getPace_timemills()>300000&&pace.getChanged_miles()>=1) {
                        paceList.add(pace);
                    }

                }
            }
            tempList.add(vehicle_entire);
        }
        else{
            if(status_num>1){
                Pace pace = createNewPace(tempList);
                if(pace!=null){
                    //驾驶间隔大于5分钟且行驶里程大于等于1公里
                    if(pace.getPace_timemills()>300000&&pace.getChanged_miles()>=1) {
                        paceList.add(pace);
                    }

                }
            }
            else{
                status_num++;
            }
        }

    }

    //计算当前记录距离缓存序列最后一条记录的间隔时间
    private long calIntervalTimeMills(){
        long timeMills=0;
        if(currentVehicleEntire.getAddTime()==null || currentVehicleEntire.getAddTime()==""){
            currentVehicleEntire.setAddTime("2999-01-01 00:00:00");
        }
        long curTimeMills = DateTimeUtil.date2UnixFormat(currentVehicleEntire.getAddTime(),DateTimeUtil.format1);
        if(tempList!=null&&tempList.size()>0){
            long lastTimeMills =  DateTimeUtil.date2UnixFormat(tempList.get(tempList.size()-1).getAddTime(),DateTimeUtil.format1);
            timeMills=curTimeMills-lastTimeMills;
        }
        return timeMills;
    }

    //生成新阶段
    private Pace createNewPace(List<Vehicle_entire> tempList){
        Pace pace = null;
        if(tempList!=null&&tempList.size()>1){
            Vehicle_entire headVehicleEntire = tempList.get(0);
            Vehicle_entire tailVehicleEntire = tempList.get(tempList.size()-1);
            pace = new Pace();
            String cs_vin = headVehicleEntire.getCs_vin();
            String cs_number = headVehicleEntire.getCs_number();
            Integer start_soc = headVehicleEntire.getSoc();
            Integer end_soc = tailVehicleEntire.getSoc();
            Integer changed_soc = end_soc-start_soc;
            float start_miles = headVehicleEntire.getTotal_miles();
            float end_miles = tailVehicleEntire.getTotal_miles();
            float changed_miles = end_miles-start_miles;
            String start_time = headVehicleEntire.getAddTime();
            String end_time = tailVehicleEntire.getAddTime();
            long pace_timemills = DateTimeUtil.date2UnixFormat(end_time, DateTimeUtil.format1)-DateTimeUtil.date2UnixFormat(start_time, DateTimeUtil.format1);

            pace.setCs_vin(cs_vin);
            pace.setCs_number(cs_number);
            pace.setStart_soc(start_soc);
            pace.setEnd_soc(end_soc);
            pace.setChanged_soc(changed_soc);
            pace.setChanged_miles(changed_miles);
            pace.setStart_miles(start_miles);
            pace.setEnd_miles(end_miles);
            pace.setStart_time(start_time);
            pace.setEnd_time(end_time);
            pace.setPace_timemills(pace_timemills);

            //进行初始状态重置
            status_num=0;
            this.tempList = new ArrayList<>();
        }
        return pace;
    }

    public List<Pace> getPaceList() {
        return paceList;
    }

    public void setPaceList(List<Pace> paceList) {
        this.paceList = paceList;
    }

    public List<Vehicle_entire> getTempList() {
        return tempList;
    }

    public void setTempList(List<Vehicle_entire> tempList) {
        this.tempList = tempList;
    }

}
