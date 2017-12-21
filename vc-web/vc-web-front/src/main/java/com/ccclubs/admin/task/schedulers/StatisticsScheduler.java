package com.ccclubs.admin.task.schedulers;


import com.ccclubs.admin.task.jobs.StatisticsJob;
import com.ccclubs.admin.util.EvManageContext;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA 2017.
 * Author: @author FengJun
 * Date: 2017/11/27
 * Time: 16:03
 * Email:fengjun@ccclubs.com
 */

/**
 * 这个类只应该被作为调度器使用，，请勿在此类中添加逻辑代码。
 * */
@Component
public class StatisticsScheduler implements ApplicationContextAware {

    protected static ApplicationContext context;






    /**
     * 每隔一定的时间计算一次状态数据并且存入数据库。
     * */
    @Scheduled(cron="0 0/30 * * * ?")
    public void shortTimeJob(){
        System.out.println("执行了一次  30分钟间隔的计算。");
        long unitTime=30*60*1000;
        StatisticsJob statisticsJob=StatisticsJob.getFromApplication();
        statisticsJob.setUnitTime(unitTime);
        EvManageContext.getThreadPool().execute(statisticsJob);

    }

    @Scheduled(cron="0 0 0 * * ?")
    public void everyDayJob(){
        System.out.println("执行了一次  12点定时的计算。");
        long unitTime=24*60*60*1000;
        StatisticsJob statisticsJob=StatisticsJob.getFromApplication();
        statisticsJob.setUnitTime(unitTime);
        EvManageContext.getThreadPool().execute(statisticsJob);
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context=applicationContext;
    }


}
