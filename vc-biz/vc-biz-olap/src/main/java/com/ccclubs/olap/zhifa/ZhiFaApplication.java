package com.ccclubs.olap.zhifa;

import com.ccclubs.olap.bean.*;
import com.ccclubs.olap.service.VehicleService;
import com.ccclubs.olap.service.ZhiFaService;
import com.ccclubs.olap.util.DBHelper;
import com.ccclubs.olap.util.DateTimeUtil;

import java.sql.SQLException;
import java.util.*;

public class ZhiFaApplication {
    public static void main(String[] args) throws Exception {
        VehicleService vehicleService = new VehicleService();
        //获取参与计算的电动车列表
        List<Cs_vehicle_machine_rel> elect_car_list = vehicleService.waitVehicleForElectric();
        //获取参与计算的汽油车列表
        List<Cs_vehicle_machine_rel> fuel_car_list = vehicleService.waitVehicleForFuel();
        //获取所有参与计算的汽车列表
        List<Cs_vehicle_machine_rel> all_car_list = new ArrayList<>();
        all_car_list.addAll(elect_car_list);
        all_car_list.addAll(fuel_car_list);
        //获取要计算的所有周的列表
        Calendar cal = Calendar.getInstance();
        String current_datetime = DateTimeUtil.getDateTimeByFormat1(cal.getTimeInMillis());
        List<WeekBean> weekBeanList = DateTimeUtil.getWeekList(current_datetime,7);

        //取得所有车辆指定时间段内的状态数据列表
        for(WeekBean weekBean:weekBeanList){
            String start_time = weekBean.getMonday_datetime();
            String end_time = weekBean.getSunday_datetime();
            System.out.println("正在计算:"+start_time+"~"+end_time+" 期间的车辆指标信息!");
            Map<String,List<Vehicle_zhifa>> vehicle_map = vehicleService.getZhiFaCarStateMap(start_time,end_time);
            Iterator<Map.Entry<String,List<Vehicle_zhifa>>> iterator= vehicle_map.entrySet().iterator();
            int cal_count=0;
            ZhiFaService zhiFaService = null;
            while (iterator.hasNext()){
                zhiFaService = new ZhiFaService();
                cal_count++;
                Map.Entry<String,List<Vehicle_zhifa>> entry = iterator.next();
                String cs_number = entry.getKey();
                System.out.println("正在计算车机号为: "+cs_number+" 车辆的指标,计算进度为  "+cal_count+"/"+vehicle_map.size());
                List<Vehicle_zhifa> vehicle_zhifa_list = entry.getValue();
                Map<Long,PaceBlock> blockMap = DateTimeUtil.generateBlockMap(start_time,end_time);

                System.out.println("正在进行驾驶阶段数据的计算!");
                //驾驶阶段数据计算
                List<DrivePace> drivePaceList = zhiFaService.calDrivePaceList(blockMap,vehicle_zhifa_list);

                //驾驶阶段数据的插入
                System.out.println("正在插入驾驶阶段的数据!");
                zhiFaService.insertDriveData(drivePaceList);

                System.out.println("正在进行充电阶段数据的计算!");
                //充电阶段数据计算
                List<SocPace> socPaceList = zhiFaService.calSocPaceList(blockMap,vehicle_zhifa_list);

                //充电阶段数据的插入
                System.out.println("正在插入充电阶段的数据!");
                zhiFaService.insertSocData(socPaceList);

            }

            System.out.println();
        }


    }
}
