package com.ccclubs.admin.task.jobs;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccclubs.admin.model.CsState;
import com.ccclubs.admin.model.CsStatistics;
import com.ccclubs.admin.task.executors.StatisticsExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA 2017.
 * Author: @author FengJun
 * Date: 2017/11/28
 * Time: 10:52
 * Email:fengjun@ccclubs.com
 */
@Component
public class StatisticsJob implements Runnable {

    private long unitTime;

    @Autowired
    private StatisticsExecutor statisticsExecutor;

    //防止不包含必要参数的初始化。
    private StatisticsJob(){}

    public StatisticsJob(long unitTime) {

        this.unitTime=unitTime;

    }

    @Override
    public void run() {
        CsStatistics csStatistics=new CsStatistics();
        csStatistics.setCssCarModel(5);
        csStatistics.setCssUnitTime(this.unitTime);
        csStatistics.setCssTime(new Date(System.currentTimeMillis()));
        //csStatistics.setCssAccess();
        List<CsState>csStateList=statisticsExecutor.getStateByCsNumbersAndDate(
                statisticsExecutor.getCsNumbersByModel(csStatistics.getCssCarModel()),
                this.unitTime);
        csStatistics.setCssChargingNum(statisticsExecutor.calculateChargingNum(csStateList));
        csStatistics.setCssOfflineNum(statisticsExecutor.calculateOfflineNum(csStateList));
        csStatistics.setCssOnlineNum(statisticsExecutor.calculateOnlineNum(csStateList));
        csStatistics.setCssRegisteredNum(statisticsExecutor.calculateRegisteredNum(csStateList));
        csStatistics.setCssRunNum(statisticsExecutor.calculateRunNum(csStateList));
        csStatistics.setCssTotalMileage(statisticsExecutor.calculateTotalMileage(csStateList));
        //csStatistics.setCssIncrementMileage(statisticsExecutor.calculateIncrementMileage(csStateList));
        //csStatistics.setCssTotalCharge(statisticsExecutor.calculateTotalCharge());
        //csStatistics.setCssTotalPowerConsumption(statisticsExecutor.calculateTotalPowerConsumption());
        //csStatistics.setCssTotalRunTime(statisticsExecutor.calculateTotalRunTime());

        statisticsExecutor.saveResult(csStatistics);

    }




}
