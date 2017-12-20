package com.ccclubs.admin.task.executors;


import com.ccclubs.admin.constants.Constants;
import com.ccclubs.admin.entity.CsMachineCrieria;
import com.ccclubs.admin.entity.CsStateCrieria;
import com.ccclubs.admin.entity.CsVehicleCrieria;
import com.ccclubs.admin.model.CsMachine;
import com.ccclubs.admin.model.CsState;
import com.ccclubs.admin.model.CsStatistics;
import com.ccclubs.admin.model.CsVehicle;
import com.ccclubs.admin.service.ICsMachineService;
import com.ccclubs.admin.service.ICsStateService;
import com.ccclubs.admin.service.ICsStatisticsService;
import com.ccclubs.admin.service.ICsVehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created with IntelliJ IDEA 2017.
 * Author: @author FengJun
 * Date: 2017/11/28
 * Time: 14:39
 * Email:fengjun@ccclubs.com
 */

@Service
public class StatisticsExecutor {

    private static final Logger logger= LoggerFactory.getLogger(StatisticsExecutor.class);

    @Autowired
    private ICsVehicleService csVehicleService;

    @Autowired
    private ICsMachineService csMachineService;

    @Autowired
    private ICsStateService csStateService;

    @Autowired
    private ICsStatisticsService csStatisticsService;
    @Autowired
    RedisTemplate redisTemplate;


    /**
     * 依据时间和车机号列表查询状态数据
     * */
    public List<CsState> getStateByCsNumbersAndDate(List<String> csNumbers,long intervalTime) {

        List<CsState> csStateList = null;
        if (null!=csNumbers&&csNumbers.size()>0){
            CsStateCrieria csStateCrieria=new CsStateCrieria();
            CsStateCrieria.Criteria criteria=csStateCrieria.createCriteria();
            criteria.andcssNumberIn(csNumbers);
            if (intervalTime>0){
                Date lowerLimitTime=new Date(System.currentTimeMillis()-intervalTime);
                criteria.andcssCurrentTimeGreaterThan(lowerLimitTime);
            }
            csStateList=csStateService.selectByExample(criteria);
        }

        return csStateList;
    }

    /**
     * 依据车机号列表查询状态数据
     * */
    public List<CsState> getAllStateByCsNumbers(List<String> csNumbers) {
        List<CsState> csStateList = null;
        if (null!=csNumbers&&csNumbers.size()>0){
            CsStateCrieria csStateCrieria=new CsStateCrieria();
            CsStateCrieria.Criteria criteria=csStateCrieria.createCriteria();
            criteria.andcssNumberIn(csNumbers);
            csStateList=csStateService.selectByExample(criteria);
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
        CsVehicleCrieria csVehicleCrieria=new CsVehicleCrieria();
        CsVehicleCrieria.Criteria criteriaVehicle=csVehicleCrieria.createCriteria();
        criteriaVehicle.andcsvModelEqualTo(modelId);
        if (null!=modelId){
            csVehicleList=csVehicleService.selectByExample(criteriaVehicle);
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
            CsMachineCrieria csMachineCrieria=new CsMachineCrieria();
            CsMachineCrieria.Criteria criteriaMachine=csMachineCrieria.createCriteria();
            criteriaMachine.andcsmIdIn(csMachineIds);
            List<CsMachine> csMachineList=csMachineService.selectByExample(criteriaMachine);

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
    public int calculateOnlineNum(List<CsState> csStateList,Long unitTime) {
        int count=0;
        if (null!=csStateList&&csStateList.size()>0){
            for (CsState csState:csStateList){
                if (System.currentTimeMillis()-csState.getCssCurrentTime().getTime()<unitTime){
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
    public int calculateOfflineNum(List<CsState> csStateList,Long unitTime) {
        int count=0;
        if (null!=csStateList&&csStateList.size()>0){
            for (CsState csState:csStateList){
                if (!(System.currentTimeMillis()-csState.getCssCurrentTime().getTime()<unitTime)){
                    count++;
                }
            }
        }
        return count;
    }


    /**
     * 计算当前充电数
     * 方法：依据当前的充电状态//TODO 需要做一个set集合进redis 注意redis要遍历清除set
     * */
    public int calculateChargingNum(List<CsState> csStateList) {
        int count=0;
        if (null!=csStateList&&csStateList.size()>0){
            for (CsState csState:csStateList){
                if (0!=csState.getCssCharging()){
                    redisTemplate.opsForSet().add(Constants.REDIS_KEY_CHARGEING_CAR_SET,csState.getCssCar());
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 计算一天整天的（长间隔）的充电车辆总数，
     * 方法：从redis取出由短间隔计算的充电车辆数的集合做count。
     * */
    public int calculateLongTimeChargingNum(){
        int count=0;
        //FIXME 这里需要删除大量key操作
        count= redisTemplate.opsForSet().size(Constants.REDIS_KEY_CHARGEING_CAR_SET).intValue();
        return count;
    }

    /**
     * 计算当前的运行车辆数。
     * 方法：速度或转速或引擎条件符合//TODO 需要做一个set集合进redis 注意redis要遍历清除set
     * */
    public int calculateRunNum(List<CsState> csStateList) {
        int count=0;
        if (null!=csStateList&&csStateList.size()>0){
            for (CsState csState:csStateList){
                if (15!=csState.getCssGear()
                        ||1==csState.getCssEngine()
                        ||csState.getCssMotor()>0
                        ||csState.getCssSpeed()>0){
                    redisTemplate.opsForSet().add(Constants.REDIS_KEY_RUNNING_CAR_SET,csState.getCssCar());
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 计算一天整天的（长间隔）的运行车辆总数，
     * 方法：从redis取出由短间隔计算的运行车辆数的集合做count。
     * */
    public int calculateLongTimeRunNum(){
        int count=0;
        count= redisTemplate.opsForSet().size(Constants.REDIS_KEY_RUNNING_CAR_SET).intValue();
        //FIXME 这里需要删除S大量key操作
        //一次删除500个。
        /*canOptions scanOptions= ScanOptions.scanOptions().count(500).build();

        Cursor cursor= redisTemplate.opsForSet().scan(Constants.REDIS_KEY_RUNNING_CAR_SET,scanOptions);

        while (cursor.hasNext()){

        }*/
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
     * //注意此方法要在calculateTotalMileage()之后调用。
     * */
    public long calculateIncrementMileage(float nowTotalMileage,Long unitTime) {
        Float count=0F;
        //这里又两个逻辑，第一个是要取离现在最近的时间的
        //第二个是要取时间间隔相同的，如果没有则视为0.
        //注意这里会不会超过long的大小。
        float pastTotalMileage=0;
        CsStatistics csStatistics=new CsStatistics();
        csStatistics.setCssUnitTime(unitTime);
        List<CsStatistics> csStatisticsList= csStatisticsService.select(csStatistics);
        if (null!=csStatisticsList&&csStatisticsList.size()>0){
            if (csStatisticsList.size()==1){
                pastTotalMileage=csStatisticsList.get(0).getCssTotalMileage();
            }
            else {
                for (CsStatistics c:csStatisticsList) {
                    if (c.getCssTotalMileage()>pastTotalMileage){
                        pastTotalMileage=c.getCssTotalMileage();
                    }
                }
            }
        }
        count=nowTotalMileage-pastTotalMileage;
        if (count<0){
            logger.warn("计算出了一个增量里程为负的数据："
                    +"nowTotalMileage:"+nowTotalMileage
                    +"unitTime:"+unitTime
                    +"pastTotalMileage:"+pastTotalMileage);
            count=0F;
        }
        return count.longValue();
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
        csStatisticsService.insert(csStatistics);
    }

}
