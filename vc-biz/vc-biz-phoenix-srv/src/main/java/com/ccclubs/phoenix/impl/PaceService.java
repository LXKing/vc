package com.ccclubs.phoenix.impl;



import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.phoenix.inf.PaceInf;
import com.ccclubs.phoenix.orm.model.Pace;
import com.ccclubs.phoenix.orm.model.PaceBlock;
import com.ccclubs.phoenix.util.VehicleUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by taosm on 2017/10/18 0018.
 */
@Service(version = "1.0.0")
public class PaceService implements PaceInf {
    private List<PaceBlock> tempList = new ArrayList<>();
    private List<Pace> paceList = new ArrayList<>();
    //添加驾驶阶段PaceBlock数据
    @Override
    public void addDrivePaceBlock(PaceBlock paceBlock){
        if(paceBlock==null){
            //如果已经到达最后一条记录
            Pace pace = VehicleUtil.createNewPace(tempList);
            //添加一些过滤条件
            //行驶过程中电量减少并且行驶里程数增加
            if(pace!=null&&pace.getPace_changed_ev_battery()<=0
                    &&pace.getPace_changed_miles()>0
                    &&pace.getPace_start_ev_battery()>0
                    &&pace.getPace_end_ev_battery()>0
                    &&pace.getPace_start_obd_miles()>0
                    &&pace.getPace_end_obd_miles()>0){
                paceList.add(pace);
            }
            tempList.clear();
            /*if(paceBlock!=null) {
                tempList.add(paceBlock);
                pace = VehicleUtil.createNewPace(tempList);
                //添加一些过滤条件
                //行驶过程中电量减少并且行驶里程数增加
                if (pace!=null&&pace.getPace_changed_ev_battery() <= 0
                        && pace.getPace_changed_miles() > 0
                        && pace.getPace_start_ev_battery() > 0
                        && pace.getPace_end_ev_battery() > 0
                        && pace.getPace_start_obd_miles() > 0
                        && pace.getPace_end_obd_miles() > 0) {
                    paceList.add(pace);
                }
            }*/
        }
        //如果间隔时间小于30分钟
        else if(VehicleUtil.calIntervalTimeMills(paceBlock,tempList)<=1800000){
            tempList.add(paceBlock);
        }
        else{
            Pace pace = VehicleUtil.createNewPace(tempList);
            //添加一些过滤条件
            //行驶过程中电量减少并且行驶里程数增加
            if(pace!=null&&pace.getPace_changed_ev_battery()<=0
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

    //添加充电阶段PaceBlock数据
    @Override
    public void addChargingPaceBlock(PaceBlock paceBlock){
        if(paceBlock==null){
            //如果已经到达最后一条记录
            Pace pace = VehicleUtil.createNewPace(tempList);
            //添加一些过滤条件
            //充电过程中电量增加并且行驶里程数不变
            if(pace!=null&&pace.getPace_changed_ev_battery()>1
                    &&pace.getPace_changed_miles()==0
                    &&pace.getPace_start_ev_battery()>0
                    &&pace.getPace_end_ev_battery()>0
                    &&pace.getPace_start_obd_miles()>0
                    &&pace.getPace_end_obd_miles()>0){
                paceList.add(pace);
            }
            tempList.clear();
            if(paceBlock!=null) {
                tempList.add(paceBlock);
                pace = VehicleUtil.createNewPace(tempList);
                //添加一些过滤条件
                //充电过程中电量增加并且行驶里程数不变
                if(pace!=null&&pace.getPace_changed_ev_battery()>1
                        &&pace.getPace_changed_miles()==0
                        &&pace.getPace_start_ev_battery()>0
                        &&pace.getPace_end_ev_battery()>0
                        &&pace.getPace_start_obd_miles()>0
                        &&pace.getPace_end_obd_miles()>0){
                    paceList.add(pace);
                }
            }
        }
        //如果间隔时间小于60分钟
        else if(VehicleUtil.calIntervalTimeMills(paceBlock,tempList)<=3600000){
            tempList.add(paceBlock);
        }
        else{
            Pace pace = VehicleUtil.createNewPace(tempList);
            //添加一些过滤条件
            //充电过程中电量增加并且行驶里程数不变
            if(pace!=null&&pace.getPace_changed_ev_battery()>1
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

    @Override
    public List<Pace> getPaceList() {
        return paceList;
    }

}
