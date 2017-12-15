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


    /**
     * 依据时间和车机号列表查询状态数据
     * */
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

    /**
     * 依据车机号列表查询状态数据
     * */
    public List<CsState> getAllStateByCsNumbers(List<String> csNumbers) {
        List<CsState> csStateList = null;
        if (null!=csNumbers&&csNumbers.size()>0){
            CsStateInput csStateInput=new CsStateInput();
            csStateInput.setCsNumberList(csNumbers);
            csStateList=csStateService.getCsStateList(csStateInput);
        }
        return csStateList;

    }

    /**
     * 依据车型查询车机号
     * */
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


    /**
     * 计算当前在线车辆数
     * 方法：依据十分钟之内发过数据的车辆。
     * */
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


    /**
     * 计算离线车辆数
     * 方法：距离现在已经10分钟没发数据上来。
     * */
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


    /**
     * 计算当前充电数
     * 方法：依据当前的充电状态
     * */
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

    /**
     * 计算当前的运行车辆数。
     * 方法：速度或转速或引擎条件符合
     * */
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

    /**
     * 计算注册车辆数
     * 方法：得到所有车辆
     * */
    public int calculateRegisteredNum(List<CsState> csStateList) {
        int count=0;
        if (null!=csStateList&&csStateList.size()>0){
            count=csStateList.size();
        }
        return count;
    }

    /**
     * 计算总里程
     * 方法：所有的OBD里程直接相加。
     * */
    public float calculateTotalMileage(List<CsState> csStateList) {
        int count=0;
        if (null!=csStateList&&csStateList.size()>0){
            for (CsState csState:csStateList){
                count+=csState.getCssObdMile();
            }
        }
        return count;
    }

    /**
     * 计算增量里程
     * 初步想法是拿到昨天的总里程值与今天的相减
     * */
    public long calculateIncrementMileage(List<CsState> csStateList) {
        int count=0;
        if (null!=csStateList&&csStateList.size()>0){
            //TODO 这里要取CsStatists相减。
        }
        return count;
    }


    //TODO 根据Hbase来计算下面三个函数所需的值。
    //TODO 随时注意以下三个方法的时间消耗！
    /**
     * 初步想法是，查询当前一天的所有在线车机的充电状态
     * 然后首尾相减最后所有车机的充电量相加
     * */
    public float calculateTotalCharge(){return 0;}
    /**
     *
     * */
    public float calculateTotalPowerConsumption(){return 0;}
    /**
     *此方法可以参考calculateTotalCharge的思想，找出所有的驾驶阶段并把时间相加。
     * */
    public long calculateTotalRunTime(){return 0;}



    public void saveResult(CsStatistics csStatistics){
        csStatisticsService.insertCsStatistics(csStatistics);
    }

}
