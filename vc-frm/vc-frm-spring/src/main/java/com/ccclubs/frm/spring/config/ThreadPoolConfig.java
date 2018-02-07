package com.ccclubs.frm.spring.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * 线程池配置
 *
 * @author jianghaiyang
 * @create 2018-01-25
 **/
@Configuration
public class ThreadPoolConfig {
    @Bean("vcThreadPool")
    public ExecutorService getThreadPool() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("remote-pool-%d").build();
        ExecutorService pool = new ThreadPoolExecutor(80, 200, 60L, TimeUnit.SECONDS
                , new LinkedBlockingDeque<>(2048), threadFactory, new ThreadPoolExecutor.AbortPolicy());
        return pool;
    }
}
