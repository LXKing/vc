package com.ccclubs.admin.task.schedulers;


import com.ccclubs.admin.task.jobs.*;
import com.ccclubs.admin.util.EvManageContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA 2017.
 * Author: @author FengJun
 * Date: 2017/11/27
 * Time: 16:03
 * Email:fengjun@ccclubs.com
 */

/**
 * 这个类只应该被作为调度器使用，，请勿在此类中添加逻辑代码。
 */
@Component
public class StatisticsScheduler implements ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(StatisticsScheduler.class);

    private static ApplicationContext context;

    /**
     * 每隔一定的时间计算一次状态数据并且存入数据库。
     */
    @Scheduled(cron = "0 0/30 * * * ?")
    public void shortTimeJob() {
        logger.info("执行了一次  30分钟间隔的计算。");
        long unitTime = 30 * 60 * 1000;
        StatisticsJob statisticsJob = StatisticsJob.getFromApplication();
        statisticsJob.setUnitTime(unitTime);
        EvManageContext.getThreadPool().execute(statisticsJob);

    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void everyDayJob() {
        logger.info("执行了一次  12点定时的计算。");
        long unitTime = 24 * 60 * 60 * 1000;
        StatisticsJob statisticsJob = StatisticsJob.getFromApplication();
        statisticsJob.setUnitTime(unitTime);
        EvManageContext.getThreadPool().execute(statisticsJob);
    }


    @Resource
    JT808OnlineCheckJob jt808OnlineCheckJob;

    //@Scheduled(cron = "0 0/5 * * * ?") 废弃
    public void jt808OnlineCheckJob() {
        logger.info("执行了一次 808车辆在线情况检查。");
        jt808OnlineCheckJob.run();
    }

    @Resource
    ExpDataCheckJob expDataCheckJob;

    @Resource
    ExpDataCleanJob expDataCleanJob;

    @Resource
    ExpDataExportJob expDataExportJob;

    @Scheduled(cron = "0 5 22 * * ?")
    public void expDataCleanJob() {
        logger.info("执行了一次 车辆异常数据的清理。");
        EvManageContext.getThreadPool().execute(expDataCleanJob);
    }

    @Scheduled(cron = "0 10 22 * * ?")
    public void expDataCheckJob() {
        logger.info("执行了一次 车辆异常数据的巡检。");
        expDataCheckJob.run();
    }

    @Scheduled(cron = "0 20 22 * * ?")
    public void expDataExportJob() {
        logger.info("执行了一次 车辆异常数据的导出。");
        EvManageContext.getThreadPool().execute(expDataExportJob);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

}
