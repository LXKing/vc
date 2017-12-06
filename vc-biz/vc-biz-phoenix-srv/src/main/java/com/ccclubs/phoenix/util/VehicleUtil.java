package com.ccclubs.phoenix.util;



import com.ccclubs.frm.spring.entity.DateTimeUtil;
import com.ccclubs.phoenix.orm.consts.VehicleConsts;
import com.ccclubs.phoenix.orm.model.CarState;
import com.ccclubs.phoenix.orm.model.Pace;
import com.ccclubs.phoenix.orm.model.PaceBlock;

import java.util.*;

/**
 * Created by taosm on 2017/10/14 0014.
 */
public class VehicleUtil {
    //根据输入记录集合计算驾驶阶段
    public static List<Pace> calDrivePaceList(List<CarState> carStateList){
        List<Pace> paceList = new ArrayList<>();
        //得到数据块序列
        List<PaceBlock> paceBlockList = calPaceBlockList(carStateList, VehicleConsts.PACE_BLOCK_INTERVAL_DRIVE,VehicleConsts.CAL_PACE_TYPE_DRIVE);
        List<PaceBlock> tempList = new ArrayList<>();
        for(int i=0;i<paceBlockList.size();i++){
            PaceBlock paceBlock = paceBlockList.get(i);
            //如果间隔时间小于30分钟
            if(VehicleUtil.calIntervalTimeMills(paceBlock,tempList)<=1800000){
                tempList.add(paceBlock);
                //如果已经到达最后一条记录
                if(i==(paceBlockList.size()-1)){
                    Pace pace = VehicleUtil.createNewPace(tempList);
                    //添加一些过滤条件
                    //行驶过程中电量减少并且行驶里程数增加
                    if(pace.getPace_changed_ev_battery()<=0
                            &&pace.getPace_changed_miles()>0
                            &&pace.getPace_start_ev_battery()>0
                            &&pace.getPace_end_ev_battery()>0
                            &&pace.getPace_start_obd_miles()>0
                            &&pace.getPace_end_obd_miles()>0){
                        paceList.add(pace);
                    }
                    tempList.clear();
                }
            }
            else{
                Pace pace = VehicleUtil.createNewPace(tempList);
                //添加一些过滤条件
                //行驶过程中电量减少并且行驶里程数增加
                if(pace.getPace_changed_ev_battery()<=0
                        &&pace.getPace_changed_miles()>0
                        &&pace.getPace_start_ev_battery()>0
                        &&pace.getPace_end_ev_battery()>0
                        &&pace.getPace_start_obd_miles()>0
                        &&pace.getPace_end_obd_miles()>0){
                    paceList.add(pace);
                }
                tempList.clear();
                tempList.add(paceBlock);
            }
        }
        return paceList;
    }


    //根据输入记录集合计算充电阶段
    public static List<Pace> calChargingPaceList(List<CarState> carStateList){
        List<Pace> paceList = new ArrayList<>();
        //得到数据块序列
        List<PaceBlock> paceBlockList = calPaceBlockList(carStateList,VehicleConsts.PACE_BLOCK_INTERVAL_CHARGING,VehicleConsts.CAL_PACE_TYPE_CHARGING);
        List<PaceBlock> tempList = new ArrayList<>();
        for(int i=0;i<paceBlockList.size();i++){
            PaceBlock paceBlock = paceBlockList.get(i);
            //如果间隔时间小于60分钟
            if(VehicleUtil.calIntervalTimeMills(paceBlock,tempList)<=3600000){
                tempList.add(paceBlock);
                //如果已经到达最后一条记录
                if(i==(paceBlockList.size()-1)){
                    Pace pace = VehicleUtil.createNewPace(tempList);
                    //添加一些过滤条件
                    //充电过程中电量增加并且行驶里程数不变
                    if(pace.getPace_changed_ev_battery()>1
                            &&pace.getPace_changed_miles()==0
                            &&pace.getPace_start_ev_battery()>0
                            &&pace.getPace_end_ev_battery()>0
                            &&pace.getPace_start_obd_miles()>0
                            &&pace.getPace_end_obd_miles()>0){
                        paceList.add(pace);
                    }
                    tempList.clear();
                }
            }
            else{
                Pace pace = VehicleUtil.createNewPace(tempList);
                //添加一些过滤条件
                //充电过程中电量增加并且行驶里程数不变
                if(pace.getPace_changed_ev_battery()>1
                        &&pace.getPace_changed_miles()==0
                        &&pace.getPace_start_ev_battery()>0
                        &&pace.getPace_end_ev_battery()>0
                        &&pace.getPace_start_obd_miles()>0
                        &&pace.getPace_end_obd_miles()>0){
                    paceList.add(pace);
                }
                tempList.clear();
                tempList.add(paceBlock);
            }
        }
        return paceList;
    }

    //根据输入数据记录得到整合好的数据序列
    private static List<PaceBlock> calPaceBlockList(List<CarState> carStateList,int cal_interval,int cal_pace_type) {
        List<PaceBlock> paceBlockList = new ArrayList<>();
        CarState firstCarState = carStateList.get(0);
        CarState lastCarState = carStateList.get(carStateList.size()-1);
        long start_cal_timemills = firstCarState.getCurrent_time();
        long end_cal_timemills = lastCarState.getCurrent_time();
        end_cal_timemills+=cal_interval*60*1000;
        long start_cal_timemills_fix = DateTimeUtil.getTimeMillsFixByInterval(start_cal_timemills, cal_interval);
        long end_cal_timemills_fix = DateTimeUtil.getTimeMillsFixByInterval(end_cal_timemills,cal_interval);
        Map<String,PaceBlock> paceBlockMap = new LinkedHashMap<>();
        Calendar start_cal = Calendar.getInstance();
        Calendar end_cal = Calendar.getInstance();
        start_cal.setTimeInMillis(start_cal_timemills_fix);
        end_cal.setTimeInMillis(end_cal_timemills_fix);
        PaceBlock paceBlock = null;
        while(start_cal.getTimeInMillis()<end_cal.getTimeInMillis()){
            paceBlock = new PaceBlock();
            paceBlock.setBlock_start_timemills(start_cal.getTimeInMillis());
            paceBlock.setBlock_end_timemills(start_cal.getTimeInMillis()+cal_interval *60*1000);
            paceBlockMap.put(DateTimeUtil.getDateTimeByFormat1(start_cal.getTimeInMillis()),paceBlock);
            start_cal.add(Calendar.MINUTE,cal_interval);
        }
        //进行相关数据插入
        for(CarState carState:carStateList){
            long key_timemills = DateTimeUtil.getTimeMillsFixByInterval(carState.getCurrent_time(),cal_interval);
            String key_datetime = DateTimeUtil.getDateTimeByFormat1(key_timemills);
            if(paceBlockMap.containsKey(key_datetime)){
                paceBlock=paceBlockMap.get(key_datetime);
                //paceBlock.setCs_vin(carState.getCs_vin());
                paceBlock.setCs_number(carState.getCs_number());
                List<CarState> recordList = paceBlock.getRecordList();
                recordList.add(carState);
            }
        }
        //数据块状态设置
        Iterator<Map.Entry<String,PaceBlock>> iterator = paceBlockMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String,PaceBlock> entry = iterator.next();
            paceBlock=entry.getValue();
            //当数据块里存在数据记录
            if(paceBlock.getRecordList().size()>1){
                List<CarState> recordList = paceBlock.getRecordList();

                //判断数据块状态
                List<CarState> fixRecordList = new ArrayList<>();
                //需要计算驾驶状态的数据列表
                if(cal_pace_type== VehicleConsts.CAL_PACE_TYPE_DRIVE){
                    fixRecordList=filterPaceBlock(recordList);
                    paceBlock.setRecordList(fixRecordList);
                    //重新计算数据块相关信息
                    recordList = paceBlock.getRecordList();
                    if(recordList.size()>1) {
                        float total_speed = 0.00f;
                        for (int i = 0; i < recordList.size(); i++) {
                            CarState carState = recordList.get(i);
                            total_speed+=carState.getSpeed();
                        }
                        //得到平均速度
                        float block_avg_speed = total_speed/recordList.size();
                        if(block_avg_speed>0){
                            //设置该数据块的状态
                            paceBlock.setBlock_status(VehicleConsts.CAR_STATUS_DRIVE);
                            //重新修正数据块的起止和结束时间
                            CarState startCarState = recordList.get(0);
                            CarState endCarState = recordList.get(recordList.size()-1);
                            //设置数据块内相关属性
                            paceBlock.setBlock_start_timemills(startCarState.getCurrent_time());
                            paceBlock.setBlock_end_timemills(endCarState.getCurrent_time());
                            paceBlock.setBlock_start_datetime(DateTimeUtil.getDateTimeByFormat1(startCarState.getCurrent_time()));
                            paceBlock.setBlock_end_datetime(DateTimeUtil.getDateTimeByFormat1(endCarState.getCurrent_time()));
                            Float block_changed_miles = endCarState.getObd_miles()-startCarState.getObd_miles();
                            paceBlock.setBlock_changed_miles(block_changed_miles);
                            paceBlock.setBlock_start_obd_miles(startCarState.getObd_miles());
                            paceBlock.setBlock_end_obd_miles(endCarState.getObd_miles());
                            paceBlock.setBlock_start_ev_battery(startCarState.getEv_battery());
                            paceBlock.setBlock_end_ev_battery(endCarState.getEv_battery());
                            Float block_changed_ev_battery = endCarState.getEv_battery()-startCarState.getEv_battery();
                            paceBlock.setBlock_changed_ev_battery(block_changed_ev_battery);
                            if(block_changed_miles<(VehicleConsts.CAR_STATUS_DRIVE*2)){
                                paceBlockList.add(paceBlock);
                            }
                        }
                    }
                }
                //充电阶段的数据
                else if(cal_pace_type==VehicleConsts.CAL_PACE_TYPE_CHARGING){
                    fixRecordList=filterPaceBlock(recordList);
                    paceBlock.setRecordList(fixRecordList);
                    //重新计算数据块相关信息
                    recordList = paceBlock.getRecordList();
                    if(recordList.size()>1) {
                        float total_changed_ev_battery =0.0f;
                        float total_speed = 0.00f;
                        for (int i = 1; i < recordList.size()-1; i++) {
                            CarState prevCarState = recordList.get(i-1);
                            CarState afterCarState = recordList.get(i);
                            total_changed_ev_battery+=afterCarState.getEv_battery()-prevCarState.getEv_battery();
                        }
                        for (int i = 0; i < recordList.size(); i++) {
                            CarState carState = recordList.get(i);
                            total_speed+=carState.getSpeed();
                        }
                        //得到平均速度
                        float block_avg_speed = total_speed/recordList.size();
                        //如果是充电状态
                        if(total_changed_ev_battery>0&&block_avg_speed==0){
                            //设置该数据块的状态
                            paceBlock.setBlock_status(VehicleConsts.CAR_STATUS_SOC);
                            //重新修正数据块的起止和结束时间
                            CarState startCarState = recordList.get(0);
                            CarState endCarState = recordList.get(recordList.size()-1);
                            //设置数据块内相关属性
                            paceBlock.setBlock_start_timemills(startCarState.getCurrent_time());
                            paceBlock.setBlock_end_timemills(endCarState.getCurrent_time());
                            paceBlock.setBlock_start_datetime(DateTimeUtil.getDateTimeByFormat1(startCarState.getCurrent_time()));
                            paceBlock.setBlock_end_datetime(DateTimeUtil.getDateTimeByFormat1(endCarState.getCurrent_time()));
                            Float block_changed_miles = endCarState.getObd_miles()-startCarState.getObd_miles();
                            paceBlock.setBlock_changed_miles(block_changed_miles);
                            paceBlock.setBlock_start_obd_miles(startCarState.getObd_miles());
                            paceBlock.setBlock_end_obd_miles(endCarState.getObd_miles());
                            paceBlock.setBlock_start_ev_battery(startCarState.getEv_battery());
                            paceBlock.setBlock_end_ev_battery(endCarState.getEv_battery());
                            Float block_changed_ev_battery = endCarState.getEv_battery()-startCarState.getEv_battery();
                            paceBlock.setBlock_changed_ev_battery(block_changed_ev_battery);

                            if(block_changed_ev_battery>0&&block_changed_ev_battery<50){
                                paceBlockList.add(paceBlock);
                            }
                        }
                    }
                }
            }
        }

        return paceBlockList;
    }

    /**
     * 过滤掉一些不符合常理的数据
     * */
    private static List<CarState> filterPaceBlock(List<CarState> recordList){
        List<CarState> fixRecordList = new ArrayList<>();
        for(CarState carState:recordList){
            //过滤掉一些不符合常理的数据
            //速度
            Float speed = carState.getSpeed();
            //obd里程
            Float obd_miles = carState.getObd_miles();
            //电量
            Float ev_battery = carState.getEv_battery();
            if(obd_miles==0
                    ||(speed>0&&ev_battery==0)){
                continue;
            }
            else{
                fixRecordList.add(carState);
            }
        }
        return fixRecordList;
    }

    //设置PaceBlock的内部信息
    public static PaceBlock configPaceBlock(PaceBlock paceBlock,int cal_pace_type){
        //当数据块里存在数据记录
        if(paceBlock.getRecordList().size()>1){
            List<CarState> recordList = paceBlock.getRecordList();

            //判断数据块状态
            List<CarState> fixRecordList = new ArrayList<>();
            //需要计算驾驶状态的数据列表
            if(cal_pace_type==VehicleConsts.CAL_PACE_TYPE_DRIVE){
                fixRecordList=filterPaceBlock(recordList);
                paceBlock.setRecordList(fixRecordList);
                //重新计算数据块相关信息
                recordList = paceBlock.getRecordList();
                if(recordList.size()>1) {
                    float total_speed = 0.00f;
                    for (int i = 0; i < recordList.size(); i++) {
                        CarState carState = recordList.get(i);
                        total_speed+=carState.getSpeed();
                    }
                    //得到平均速度
                    float block_avg_speed = total_speed/recordList.size();
                    if(block_avg_speed>0){
                        //设置该数据块的状态
                        paceBlock.setBlock_status(VehicleConsts.CAR_STATUS_DRIVE);
                        //重新修正数据块的起止和结束时间
                        CarState startCarState = recordList.get(0);
                        CarState endCarState = recordList.get(recordList.size()-1);
                        //设置数据块内相关属性
                        paceBlock.setBlock_start_timemills(startCarState.getCurrent_time());
                        paceBlock.setBlock_end_timemills(endCarState.getCurrent_time());
                        paceBlock.setBlock_start_datetime(DateTimeUtil.getDateTimeByFormat1(startCarState.getCurrent_time()));
                        paceBlock.setBlock_end_datetime(DateTimeUtil.getDateTimeByFormat1(endCarState.getCurrent_time()));
                        Float block_changed_miles = endCarState.getObd_miles()-startCarState.getObd_miles();
                        paceBlock.setBlock_changed_miles(block_changed_miles);
                        paceBlock.setBlock_start_obd_miles(startCarState.getObd_miles());
                        paceBlock.setBlock_end_obd_miles(endCarState.getObd_miles());
                        paceBlock.setBlock_start_ev_battery(startCarState.getEv_battery());
                        paceBlock.setBlock_end_ev_battery(endCarState.getEv_battery());
                        Float block_changed_ev_battery = endCarState.getEv_battery()-startCarState.getEv_battery();
                        paceBlock.setBlock_changed_ev_battery(block_changed_ev_battery);
                        if(block_changed_miles>=(VehicleConsts.CAR_STATUS_DRIVE*2)){
                            paceBlock=null;
                        }
                    }
                    else {
                        paceBlock=null;
                    }
                }
                else {
                    paceBlock=null;
                }
            }
            //充电阶段的数据
            else if(cal_pace_type==VehicleConsts.CAL_PACE_TYPE_CHARGING){
                fixRecordList=filterPaceBlock(recordList);
                paceBlock.setRecordList(fixRecordList);
                //重新计算数据块相关信息
                recordList = paceBlock.getRecordList();
                if(recordList.size()>1) {
                    float total_changed_ev_battery =0.0f;
                    float total_speed = 0.00f;
                    for (int i = 1; i < recordList.size()-1; i++) {
                        CarState prevCarState = recordList.get(i-1);
                        CarState afterCarState = recordList.get(i);
                        total_changed_ev_battery+=afterCarState.getEv_battery()-prevCarState.getEv_battery();
                    }
                    for (int i = 0; i < recordList.size(); i++) {
                        CarState carState = recordList.get(i);
                        total_speed+=carState.getSpeed();
                    }
                    //得到平均速度
                    float block_avg_speed = total_speed/recordList.size();
                    //如果是充电状态
                    if(total_changed_ev_battery>0&&block_avg_speed==0){
                        //设置该数据块的状态
                        paceBlock.setBlock_status(VehicleConsts.CAR_STATUS_SOC);
                        //重新修正数据块的起止和结束时间
                        CarState startCarState = recordList.get(0);
                        CarState endCarState = recordList.get(recordList.size()-1);
                        //设置数据块内相关属性
                        paceBlock.setBlock_start_timemills(startCarState.getCurrent_time());
                        paceBlock.setBlock_end_timemills(endCarState.getCurrent_time());
                        paceBlock.setBlock_start_datetime(DateTimeUtil.getDateTimeByFormat1(startCarState.getCurrent_time()));
                        paceBlock.setBlock_end_datetime(DateTimeUtil.getDateTimeByFormat1(endCarState.getCurrent_time()));
                        Float block_changed_miles = endCarState.getObd_miles()-startCarState.getObd_miles();
                        paceBlock.setBlock_changed_miles(block_changed_miles);
                        paceBlock.setBlock_start_obd_miles(startCarState.getObd_miles());
                        paceBlock.setBlock_end_obd_miles(endCarState.getObd_miles());
                        paceBlock.setBlock_start_ev_battery(startCarState.getEv_battery());
                        paceBlock.setBlock_end_ev_battery(endCarState.getEv_battery());
                        Float block_changed_ev_battery = endCarState.getEv_battery()-startCarState.getEv_battery();
                        paceBlock.setBlock_changed_ev_battery(block_changed_ev_battery);

                        if(!(block_changed_ev_battery>0&&block_changed_ev_battery<50)){
                            paceBlock=null;
                        }
                    }
                    else{
                        paceBlock=null;
                    }
                }
                else{
                    paceBlock=null;
                }
            }
        }
        else{
            paceBlock=null;
        }
        return paceBlock;
    }

    //计算当前记录距离缓存序列最后一条记录的间隔时间
    public static long calIntervalTimeMills(PaceBlock currentPaceBlock, List<PaceBlock> tempList){
        long timeMills=0;
        if(tempList!=null&&tempList.size()>0){
            PaceBlock paceBlock = tempList.get(tempList.size()-1);
            timeMills=currentPaceBlock.getBlock_start_timemills()-paceBlock.getBlock_end_timemills();
        }
        return timeMills;
    }

    //计算新阶段
    public static Pace createNewPace(List<PaceBlock> tempList){
        Pace pace = null;
        if(tempList!=null&&tempList.size()>0){
            try {
                pace = new Pace();
                PaceBlock headPaceBlock = tempList.get(0);
                PaceBlock tailPaceBlock = tempList.get(tempList.size() - 1);
                //车机号
                String cs_number = headPaceBlock.getCs_number();
                String cs_vin = headPaceBlock.getCs_vin();
                //阶段开始时间(毫秒)
                long pace_start_timemills = headPaceBlock.getBlock_start_timemills();
                //阶段结束时间(毫秒)
                long pace_end_timemills = tailPaceBlock.getBlock_end_timemills();
                //阶段经历时间
                long pace_timemills = pace_end_timemills - pace_start_timemills;
                //阶段开始时间
                String pace_start_time = DateTimeUtil.getDateTimeByFormat1(headPaceBlock.getBlock_start_timemills());
                //阶段结束时间
                String pace_end_time = DateTimeUtil.getDateTimeByFormat1(tailPaceBlock.getBlock_end_timemills());
                //阶段起始里程数
                float pace_start_obd_miles = headPaceBlock.getBlock_start_obd_miles();
                //阶段结束里程数
                float pace_end_obd_miles = tailPaceBlock.getBlock_end_obd_miles();
                //阶段变化里程数
                float pace_changed_miles = pace_end_obd_miles - pace_start_obd_miles;
                //阶段起始电量
                float pace_start_ev_battery = headPaceBlock.getBlock_start_ev_battery();
                //阶段结束电量
                float pace_end_ev_battery = tailPaceBlock.getBlock_end_ev_battery();
                //阶段变化电量
                float pace_changed_ev_battery = pace_end_ev_battery - pace_start_ev_battery;
                //重新组织阶段内状态记录数据
                List<CarState> recordList = new ArrayList<>();
                for (PaceBlock paceBlock : tempList) {
                    recordList.addAll(paceBlock.getRecordList());
                }
                pace.setCs_vin(cs_vin);
                pace.setCs_number(cs_number);
                pace.setPace_start_timemills(pace_start_timemills);
                pace.setPace_end_timemills(pace_end_timemills);
                pace.setPace_timemills(pace_timemills);
                pace.setPace_start_datetime(pace_start_time);
                pace.setPace_end_datetime(pace_end_time);
                pace.setPace_start_obd_miles(pace_start_obd_miles);
                pace.setPace_end_obd_miles(pace_end_obd_miles);
                pace.setPace_changed_miles(pace_changed_miles);
                pace.setPace_start_ev_battery(pace_start_ev_battery);
                pace.setPace_end_ev_battery(pace_end_ev_battery);
                pace.setPace_changed_ev_battery(pace_changed_ev_battery);
                pace.setRecordList(recordList);
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return pace;
    }

    public static String generateCsNumberSqlSegement(List<String> cs_numbers){
        String sql=null;
        if(cs_numbers!=null&&cs_numbers.size()>0){
            sql="";
            for(int i=0;i<cs_numbers.size();i++){
                sql+="'"+cs_numbers.get(i)+"'";
                if(i!=cs_numbers.size()-1){
                    sql+=",";
                }
            }
            sql="("+sql+")";
        }
        return sql;
    }
}
