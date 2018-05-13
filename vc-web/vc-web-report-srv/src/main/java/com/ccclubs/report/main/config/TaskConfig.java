package com.ccclubs.report.main.config;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import com.ccclubs.report.netty.service.LoginCheck;
import com.ccclubs.report.service.ReportAgency;
import com.ccclubs.report.service.ReportInf;

@Configuration
@EnableAsync
@EnableScheduling
public class TaskConfig {
    private Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    private ReportAgency dInf;
    @Autowired
    private List<ReportInf> list;

    @Bean // (destroyMethod="shutdown")
    public Executor taskExecutor() {
        log.debug("init taskExecutor");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(25);
        executor.setThreadNamePrefix("tl_executor");
        executor.initialize();
        log.debug("init taskExecutor end");
        return executor;// Executors.newScheduledThreadPool(20)
    }

    @Bean
    public ThreadPoolTaskScheduler taskScheduler() {
        log.debug("init taskScheduler");
        // return new ConcurrentTaskScheduler(); //single threaded by default

        ThreadPoolTaskScheduler ts = new ThreadPoolTaskScheduler();
        ts.initialize();
        ts.setThreadNamePrefix("tl_scheduler");
        ts.setPoolSize(10);
        ts.setThreadFactory(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        });
        // 设置线程池中任务的等待时间，如果超过这个时候还没有销毁就强制销毁，以确保应用最后能够被关闭，而不是阻塞住
        ts.setAwaitTerminationSeconds(60);
        // 线程池对拒绝任务的处理策略,当线程池没有处理能力的时候，该策略会直接在 execute
        // 方法的调用线程中运行被拒绝的任务；如果执行程序已关闭，则会丢弃该任务
        ts.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //立即
        for (ReportInf bf : list) {
            ts.submit(new LoginCheck(bf, dInf));
        }
        for (ReportInf bf : list) {
            ts.scheduleAtFixedRate(new LoginCheck(bf, dInf), bf.getReportServer().getLoginCheckPeriod());
        }

        log.debug("init taskScheduler end");
        return ts;
    }

}
