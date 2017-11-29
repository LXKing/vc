package com.ccclubs.manage.task.executors;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.manage.dto.CsMachineInput;
import com.ccclubs.manage.dto.CsStateInput;
import com.ccclubs.manage.dto.CsVehicleInput;
import com.ccclubs.manage.inf.CsMachineInf;
import com.ccclubs.manage.inf.CsStateInf;
import com.ccclubs.manage.inf.CsStatisticsInf;
import com.ccclubs.manage.inf.CsVehicleInf;
import com.ccclubs.manage.orm.model.CsMachine;
import com.ccclubs.manage.orm.model.CsState;
import com.ccclubs.manage.orm.model.CsStatistics;
import com.ccclubs.manage.orm.model.CsVehicle;

import java.util.*;

/**
 * Created with IntelliJ IDEA 2017.
 * Author: @author FengJun
 * Date: 2017/11/28
 * Time: 14:39
 * Email:fengjun@ccclubs.com
 */
@Service(version = "1.0.0")
public class StatisticsExecutor {

    @Reference(version = "1.0.0")
    private CsVehicleInf csVehicleService;

    @Reference(version = "1.0.0")
    private CsMachineInf csMachineService;

    @Reference(version = "1.0.0")
    private CsStateInf csStateService;

    @Reference(version = "1.0.0")
    private CsStatisticsInf csStatisticsService;



    public List<CsState> getStateByCsNumbersAndDate(List<String> csNumbers,long intervalTime) {

        List<CsState> csStateList = null;
        if (null!=csNumbers&&csNumbers.size()>0){
            CsStateInput csStateInput=new CsStateInput();
            csStateInput.setCsNumberList(csNumbers);
            if (intervalTime>0){
                Date lowerLimitTime=new Date(System.currentTimeMillis()-intervalTime);
                csStateInput.setCsCurrentTime(lowerLimitTime);
            }
            csStateList=csStateService.getCsStateList(csStateInput);
        }

        return csStateList;
    }


    public List<CsState> getAllStateByCsNumbers(List<String> csNumbers) {
        List<CsState> csStateList = null;
        if (null!=csNumbers&&csNumbers.size()>0){
            CsStateInput csStateInput=new CsStateInput();
            csStateInput.setCsNumberList(csNumbers);
            csStateList=csStateService.getCsStateList(csStateInput);
        }
        return csStateList;

    }


    public List<String> getCsNumbersByModel(Integer modelId) {
        modelId=5;//5是众泰E200
        List<String> stringList = null;
        List<CsVehicle> csVehicleList=null;
        Set<Integer> csMachineSet=new HashSet();
        CsVehicleInput csVehicleInput=new CsVehicleInput();
        csVehicleInput.setCsModel(modelId);
        if (null!=modelId){
            csVehicleList=csVehicleService.getVehicleList(csVehicleInput);
        }
        if (null!=csVehicleList&&csVehicleList.size()>0){
            for (CsVehicle csVehicle:csVehicleList){
                csMachineSet.add(csVehicle.getCsvMachine());
            }
        }
        if (csMachineSet.size()>0){
            List<Integer> csMachineIds=new ArrayList<>();
            for (Integer integer:csMachineSet){
                csMachineIds.add(integer);
            }
            CsMachineInput csMachineInput=new CsMachineInput();
            csMachineInput.setIds(csMachineIds);
            List<CsMachine> csMachineList=csMachineService.getCsMachineList(csMachineInput);

            if (null!=csMachineList&&csMachineList.size()>0){
                stringList=new ArrayList<>();
                for (CsMachine csMachine:csMachineList){
                    stringList.add(csMachine.getCsmNumber());
                }
            }

        }
        return stringList;
    }


    public int calculateOnlineNum(List<CsState> csStateList) {
        int count=0;
        if (null!=csStateList&&csStateList.size()>0){
            for (CsState csState:csStateList){
                if (System.currentTimeMillis()-csState.getCssCurrentTime().getTime()<10*60*1000){
                    count++;
                }
            }
        }
        return count;
    }


    public int calculateOfflineNum(List<CsState> csStateList) {
        int count=0;
        if (null!=csStateList&&csStateList.size()>0){
            for (CsState csState:csStateList){
                if (!(System.currentTimeMillis()-csState.getCssCurrentTime().getTime()<10*60*1000)){
                    count++;
                }
            }
        }
        return count;
    }


    public int calculateChargingNum(List<CsState> csStateList) {
        int count=0;
        if (null!=csStateList&&csStateList.size()>0){
            for (CsState csState:csStateList){
                if (0!=csState.getCssCharging()){
                    count++;
                }
            }
        }
        return count;
    }

    public int calculateRunNum(List<CsState> csStateList) {
        int count=0;
        if (null!=csStateList&&csStateList.size()>0){
            for (CsState csState:csStateList){
                if (15!=csState.getCssGear()
                        ||1==csState.getCssEngine()
                        ||csState.getCssMotor()>0
                        ||csState.getCssSpeed()>0){
                    count++;
                }
            }
        }
        return count;
    }


    public int calculateRegisteredNum(List<CsState> csStateList) {
        int count=0;
        if (null!=csStateList&&csStateList.size()>0){
            count=csStateList.size();
        }
        return count;
    }


    public float calculateTotalMileage(List<CsState> csStateList) {
        int count=0;
        if (null!=csStateList&&csStateList.size()>0){
            for (CsState csState:csStateList){
                count+=csState.getCssObdMile();
            }
        }
        return count;
    }


    public long calculateIncrementMileage(List<CsState> csStateList) {
        int count=0;
        if (null!=csStateList&&csStateList.size()>0){
            //TODO 这里要取CsStatists相减。
        }
        return count;
    }


    //TODO 根据Hbase来计算下面三个函数所需的值。
    public float calculateTotalCharge(){return 0;}
    public float calculateTotalPowerConsumption(){return 0;}
    public long calculateTotalRunTime(){return 0;}

    public void saveResult(CsStatistics csStatistics){}

}
