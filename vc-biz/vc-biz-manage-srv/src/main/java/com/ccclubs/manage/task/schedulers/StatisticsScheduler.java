package com.ccclubs.manage.task.schedulers;

import com.ccclubs.manage.task.jobs.StatisticsJob;
import com.ccclubs.manage.util.EvManageContext;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.RedisTemplate;
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


    @Autowired
    RedisTemplate redisTemplate;



    /**
     * 每隔一定的时间计算一次状态数据并且存入数据库。
     * */
    //TODO 这里应该为可以配置的时间大小。
    //@Scheduled(cron="0/8 * * * * ?")
    public void shortTimeJob(){
        long unitTime=30*60*1000;
        EvManageContext.getThreadPool().execute(new StatisticsJob(unitTime));
        /*EvManageContext.getThreadPool().execute(new Runnable() {
            int i=0;
            @Override
            public void run() {
                System.out.println(i++);

            }
        });*/
    }

    //TODO 请在后期开启定时任务。或迁移到其他模块。

    //@Scheduled(cron="0 0 0 * * ?")
    public void everyDayJob(){
        long unitTime=24*60*60*1000;
        EvManageContext.getThreadPool().execute(new StatisticsJob(unitTime));
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context=applicationContext;
    }


}
