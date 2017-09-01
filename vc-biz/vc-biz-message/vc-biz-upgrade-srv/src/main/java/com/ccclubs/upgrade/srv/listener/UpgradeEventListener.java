package com.ccclubs.upgrade.srv.listener;

import com.ccclubs.upgrade.srv.event.UpgradeFailedEvent;
import com.ccclubs.upgrade.srv.event.UpgradeProcessEvent;
import com.ccclubs.upgrade.srv.event.UpgradeSuccessEvent;
import com.ccclubs.upgrade.srv.util.UpgradeConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 升级事件监听
 *
 * @author jianghaiyang
 * @create 2017-08-15
 **/
@Component
public class UpgradeEventListener {

    private static final Logger logger = LoggerFactory.getLogger(UpgradeEventListener.class);

    @Autowired
    RedisTemplate redisTemplate;

    @EventListener
    public void handleProcessEvent(UpgradeProcessEvent event) {
        logger.info("ProcessEvent:[vin:{}]", event.getInput().getVin());
        redisTemplate.opsForValue().increment(UpgradeConstants.REDIS_KEY_PROC_COUNT, 1);
    }

    @EventListener
    public void handleSuccessEvent(UpgradeSuccessEvent event) {
        logger.info("SuccessEvent:[vin:{}], cost {} ms", event.getInput().getVin(), event.getInput().getProcOutTime() - event.getInput().getProcOutTime());
        long count = (Integer) redisTemplate.opsForValue().get(UpgradeConstants.REDIS_KEY_PROC_COUNT);
        redisTemplate.opsForValue().set(UpgradeConstants.REDIS_KEY_PROC_COUNT, count - 1);//计数器减1
    }

    @EventListener
    public void handleFailedEvent(UpgradeFailedEvent event) {
        logger.error("Upgrade request of " + event.getInput().getVin() + " failed, because time out:" + UpgradeConstants.UPGRADE_TIMEOUT + "ms");
        long count = (Integer) redisTemplate.opsForValue().get(UpgradeConstants.REDIS_KEY_PROC_COUNT);
        redisTemplate.opsForValue().set(UpgradeConstants.REDIS_KEY_PROC_COUNT, count - 1);//计数器减1
    }
}
