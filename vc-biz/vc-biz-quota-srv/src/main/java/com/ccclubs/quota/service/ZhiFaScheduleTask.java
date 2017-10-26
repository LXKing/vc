package com.ccclubs.quota.service;

import com.ccclubs.olap.orm.model.DriveMilesBasicZhifa;
import com.ccclubs.olap.orm.model.SocMilesBasicZhifa;
import com.ccclubs.quota.vo.WeekBeanOutput;
import com.ccclubs.quota.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/15 0015.
 */
@Component
public class ZhiFaScheduleTask {


    @Autowired
    ZhiFaScheduleInsert zhiFaMilesBasicService;

//    @Scheduled(fixedDelay=1000*60*1)
//    //执行数据统计任务
//    @Scheduled(cron="0 15 2 ? * MON") //每周一的2点15执行
    public void executeCensusTask(){
        //获取要计算的所有周的列表
        Calendar cal = Calendar.getInstance();
        String current_datetime = DateTimeUtil.getDateTimeByFormat1(cal.getTimeInMillis());
        List<WeekBeanOutput> weekBeanList = DateTimeUtil.getWeekList(current_datetime,1);
        for(WeekBeanOutput weekBean:weekBeanList){
            String start_time = weekBean.getMonday_datetime();
            String end_time = weekBean.getSunday_datetime();
            //
            System.out.println("正在计算:"+start_time+"~"+end_time+" 期间的车辆指标信息!");
            //
            Map<String,List<Vehicle_zhifa>> vehicle_map =  zhiFaMilesBasicService.getZhiFaCarStateMap(start_time,end_time);
            Iterator<Map.Entry<String,List<Vehicle_zhifa>>> iterator= vehicle_map.entrySet().iterator();
            //
            int cal_count=0;
            while (iterator.hasNext()){
                cal_count++;
                Map.Entry<String,List<Vehicle_zhifa>> entry = iterator.next();
                String cs_number = entry.getKey();
//                System.out.println("正在计算车机号为: "+cs_number+" 车辆的指标,计算进度为  "+cal_count+"/"+vehicle_map.size());
                //
                List<Vehicle_zhifa> vehicle_zhifa_list = entry.getValue();
                Map<Long,PaceBlock> blockMap = DateTimeUtil.generateBlockMap(start_time,end_time);
                //驾驶阶段数据计算
                List<DriveMilesBasicZhifa> drivePaceList = zhiFaMilesBasicService.calDrivePaceList(blockMap,vehicle_zhifa_list);
                zhiFaMilesBasicService.insertDriveMilses(drivePaceList,start_time,end_time);
                //充电阶段数据计算
                List<SocMilesBasicZhifa> socPaceList = zhiFaMilesBasicService.calSocPaceList(blockMap,vehicle_zhifa_list);
                zhiFaMilesBasicService.insertSocMiles(socPaceList,start_time,end_time);

            }
        }
    }
}





