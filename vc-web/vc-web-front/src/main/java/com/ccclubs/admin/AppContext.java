package com.ccclubs.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AppContext implements ApplicationListener<ApplicationReadyEvent> {
    public static Logger log= LoggerFactory.getLogger(AppContext.class);
    public static ApplicationContext CTX = null;
    public static ExecutorService processPoll = null;
    public static ExecutorService queueSendPoll = null;
    public static int PROCESS_POLL_NUMBER = 10;
    public static int SEND_QUEUE_NUMBER = 20;

    public AppContext()
    {
    }


    public static boolean initSpring()
    {
        return false;
    }

    public static void createPool()
    {
        processPoll = new ThreadPoolExecutor(AppContext.PROCESS_POLL_NUMBER, 20, 30, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
        queueSendPoll = new ThreadPoolExecutor(AppContext.SEND_QUEUE_NUMBER, 50, 30, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        if(CTX == null) {
            CTX = event.getApplicationContext();
            createPool();
        }

    }

}
