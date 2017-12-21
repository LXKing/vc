package com.ccclubs.admin.task.jobs;

import com.ccclubs.admin.AppContext;
import com.ccclubs.admin.model.CsState;
import com.ccclubs.admin.model.CsStatistics;
import com.ccclubs.admin.task.executors.StatisticsExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA 2017.
 * Author: @author FengJun
 * Date: 2017/11/28
 * Time: 10:52
 * Email:fengjun@ccclubs.com
 */
@Service("StatisticsJob")
public class StatisticsJob implements Runnable {


    public void setUnitTime(long unitTime) {
        this.unitTime = unitTime;
    }

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
        if (this.unitTime>8*60*60*1000L){
            //长间隔统计
            longTimeJob();
        }else {
            shortTimeJob();
        }

    }

    private void longTimeJob(){
        CsStatistics csStatistics=new CsStatistics();
        csStatistics.setCssCarModel(5);
        csStatistics.setCssUnitTime(this.unitTime);
        csStatistics.setCssTime(new Date(System.currentTimeMillis()));
        //csStatistics.setCssAccess();
        List<CsState>csStateList=statisticsExecutor.getStateByCsNumbersAndDate(
                statisticsExecutor.getCsNumbersByModel(csStatistics.getCssCarModel()),
                this.unitTime);
        csStatistics.setCssChargingNum(statisticsExecutor.calculateLongTimeChargingNum());
        csStatistics.setCssOfflineNum(statisticsExecutor.calculateOfflineNum(csStateList,this.unitTime));
        csStatistics.setCssOnlineNum(statisticsExecutor.calculateOnlineNum(csStateList,this.unitTime));
        csStatistics.setCssRegisteredNum(statisticsExecutor.calculateRegisteredNum(csStateList));
        csStatistics.setCssRunNum(statisticsExecutor.calculateLongTimeRunNum());
        csStatistics.setCssTotalMileage(statisticsExecutor.calculateTotalMileage(csStateList));
        csStatistics.setCssIncrementMileage(statisticsExecutor.calculateIncrementMileage(csStatistics.getCssTotalMileage(),this.unitTime));
        //csStatistics.setCssTotalCharge(statisticsExecutor.calculateTotalCharge());
        //csStatistics.setCssTotalPowerConsumption(statisticsExecutor.calculateTotalPowerConsumption());
        //csStatistics.setCssTotalRunTime(statisticsExecutor.calculateTotalRunTime());

        statisticsExecutor.saveResult(csStatistics);
    }

    private void  shortTimeJob(){
        CsStatistics csStatistics=new CsStatistics();
        csStatistics.setCssCarModel(5);
        csStatistics.setCssUnitTime(this.unitTime);
        csStatistics.setCssTime(new Date(System.currentTimeMillis()));
        //csStatistics.setCssAccess();
        List<CsState>csStateList=statisticsExecutor.getStateByCsNumbersAndDate(
                statisticsExecutor.getCsNumbersByModel(csStatistics.getCssCarModel()),
                this.unitTime);
        csStatistics.setCssChargingNum(statisticsExecutor.calculateChargingNum(csStateList));
        csStatistics.setCssOfflineNum(statisticsExecutor.calculateOfflineNum(csStateList,this.unitTime));
        csStatistics.setCssOnlineNum(statisticsExecutor.calculateOnlineNum(csStateList,this.unitTime));
        csStatistics.setCssRegisteredNum(statisticsExecutor.calculateRegisteredNum(csStateList));
        csStatistics.setCssRunNum(statisticsExecutor.calculateRunNum(csStateList));
        csStatistics.setCssTotalMileage(statisticsExecutor.calculateTotalMileage(csStateList));
        csStatistics.setCssIncrementMileage(statisticsExecutor.calculateIncrementMileage(csStatistics.getCssTotalMileage(),this.unitTime));
        //csStatistics.setCssTotalCharge(statisticsExecutor.calculateTotalCharge());
        //csStatistics.setCssTotalPowerConsumption(statisticsExecutor.calculateTotalPowerConsumption());
        //csStatistics.setCssTotalRunTime(statisticsExecutor.calculateTotalRunTime());

        statisticsExecutor.saveResult(csStatistics);
    }

    public static StatisticsJob getFromApplication(){
        return AppContext.CTX.getBean(StatisticsJob.class);
    }


}
