package com.ccclubs.manage.task.jobs;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccclubs.manage.orm.model.CsState;
import com.ccclubs.manage.orm.model.CsStatistics;
import com.ccclubs.manage.task.executors.StatisticsExecutor;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA 2017.
 * Author: @author FengJun
 * Date: 2017/11/28
 * Time: 10:52
 * Email:fengjun@ccclubs.com
 */
public class StatisticsJob implements Runnable {

    private long unitTime;

    @Reference(version = "1.0.0")
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
