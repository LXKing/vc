package com.ccclubs.upgrade.srv.init;

import com.ccclubs.upgrade.srv.util.UpgradeConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 计数器初始化
 *
 * @author jianghaiyang
 * @create 2017-08-15
 **/
@Component
@Order(1)
public class CounterInitRunner implements CommandLineRunner {

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public void run(String... strings) throws Exception {
        redisTemplate.opsForValue().setIfAbsent(UpgradeConstants.REDIS_KEY_PROC_COUNT, 0);
        redisTemplate.opsForHash().putIfAbsent(UpgradeConstants.REDIS_KEY_PROC_COUNT, "123","123");//fixme
    }
}
