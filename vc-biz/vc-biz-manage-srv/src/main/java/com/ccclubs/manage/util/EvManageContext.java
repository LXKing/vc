package com.ccclubs.manage.util;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA 2017.
 * Author: @author FengJun
 * Date: 2017/11/28
 * Time: 11:26
 * Email:fengjun@ccclubs.com
 */
public class EvManageContext {

    private static ExecutorService threadPool;

    static ThreadFactory threadFactory=new ThreadFactoryBuilder().setNameFormat("Job-pool-%d").build();

    private static int corePoolSize=5;
    private static int maximumPoolSize=5;
    private static long keepAliveTime=0L;
    private static BlockingQueue blockingQueue=new LinkedBlockingQueue<>(1024);

    static {
         threadPool=new ThreadPoolExecutor(corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                TimeUnit.MILLISECONDS,
                blockingQueue,
                threadFactory,
                new ThreadPoolExecutor.AbortPolicy());
    }
    private EvManageContext(){}

    public static  ExecutorService getThreadPool(){
        return threadPool;
    }



}
