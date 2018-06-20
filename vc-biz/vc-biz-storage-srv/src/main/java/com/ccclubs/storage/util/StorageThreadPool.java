package com.ccclubs.storage.util;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/6/15
 * @Time: 15:44
 * @Description: 存储服务线程池！
 * Email:fengjun@ccclubs.com
 */

public class StorageThreadPool {

    private  static Logger logger= LoggerFactory.getLogger(StorageThreadPool.class);
    private static ExecutorService threadPool;

    static ThreadFactory threadFactory=new ThreadFactoryBuilder().setNameFormat("Storage-pool-%d").build();

    private static int corePoolSize=8;
    private static int maximumPoolSize=80;
    private static long keepAliveTime=100L;
    //此处可以配置无界任务队列。此处暂时每个broker配置1024大小的队列
    private static BlockingQueue blockingQueue=new LinkedBlockingQueue<>(1024*8);

    static {
        threadPool=new ThreadPoolExecutor(corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                TimeUnit.MILLISECONDS,
                blockingQueue,
                threadFactory,
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        logger.error("Storage thread pool discord a task: {}",r.toString());
                    }
                });
    }
    private StorageThreadPool(){}

    public static  ExecutorService getThreadPool(){
        return threadPool;
    }
}
