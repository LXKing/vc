package com.ccclubs.upgrade.srv.task;

import com.ccclubs.upgrade.dto.UpgradeInput;
import com.ccclubs.upgrade.srv.event.UpgradeFailedEvent;
import com.ccclubs.upgrade.srv.event.UpgradeProcessEvent;
import com.ccclubs.upgrade.srv.event.UpgradeSuccessEvent;
import com.ccclubs.upgrade.srv.impl.UpgradeService;
import com.ccclubs.upgrade.srv.util.UpgradeConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 升级定时任务
 *
 * @author jianghaiyang
 * @create 2017-08-15
 **/
@Component
public class ProcessJobs implements ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(ProcessJobs.class);

    @Autowired
    private UpgradeService upgradeService;

    @Autowired
    RedisTemplate redisTemplate;

    protected static ApplicationContext context;

    /**
     * 扫描请求队列，移除成功的记录并重置计数器
     */
    @Scheduled(fixedRate = 60000)
    public void fixedRateJob() {
        long count = (Integer) redisTemplate.opsForValue().get(UpgradeConstants.REDIS_KEY_PROC_COUNT);
        logger.info("scanning counter [{}] >>> {}", UpgradeConstants.REDIS_KEY_PROC_COUNT, count);

        while (count < UpgradeConstants.UPGRADE_LIMIT) {
            Object req = redisTemplate.opsForList().rightPop(UpgradeConstants.REDIS_KEY_REQ_QUEUE);
            if (null == req) {
                logger.info("no upgrade request found in request queue [REQ_QUEUE]");
            } else {
                UpgradeInput input = (UpgradeInput) req;
                input.setReqOutTime(System.currentTimeMillis());
                input.setProcInTime(System.currentTimeMillis());

                boolean flag = redisTemplate.hasKey(UpgradeConstants.REDIS_KEY_PROC_QUEUE);
                if (flag) {
                    List<UpgradeInput> processList = redisTemplate.opsForList().range(UpgradeConstants.REDIS_KEY_PROC_QUEUE, 0, -1);
                    for (int i = processList.size() - 1; i >= 0; i--) {
                        UpgradeInput in = (UpgradeInput) redisTemplate.opsForList().index(UpgradeConstants.REDIS_KEY_PROC_QUEUE, i);
                        if (input.getVin().equals(in.getVin())) {
                            logger.info("proc aready exist for {vin:{}}", in.getVin());
                            return;//已经在升级中，不加入处理队列
                        }
                    }
                }

                redisTemplate.opsForList().leftPush(UpgradeConstants.REDIS_KEY_PROC_QUEUE, input);

                // 调用升级指令 command api
                try {
                    upgradeService.upgradeCommand(input.getVin(), input.getFilename());
                } catch (Exception e) {
                    logger.error("call command api failed: " + e.getMessage(), e);
                }

                //发布处理ing event
                context.publishEvent(new UpgradeProcessEvent(input));
            }
        }
    }

    /**
     * 扫描处理队列，移除成功的记录并重置计数器
     */
    @Scheduled(fixedDelay = 120000)
    public void fixedDelayJob() throws InterruptedException {
        ListOperations ops = redisTemplate.opsForList();
        logger.info("scanning process queue [PROC_QUEUE]....");
        boolean flag = redisTemplate.hasKey(UpgradeConstants.REDIS_KEY_PROC_QUEUE);
        if (flag) {
            List<UpgradeInput> processList = ops.range(UpgradeConstants.REDIS_KEY_PROC_QUEUE, 0, -1);
            for (int i = processList.size() - 1; i >= 0; i--) {
                UpgradeInput input = (UpgradeInput) ops.index(UpgradeConstants.REDIS_KEY_PROC_QUEUE, i);
                // 调用查询是否最新版本 search api
                boolean isSuccess = false;
                try {
                    isSuccess = upgradeService.isSuccess(input.getVin());
                } catch (Exception e) {
                    logger.error("call search api failed: " + e.getMessage(), e);
                    long now = System.currentTimeMillis();
                    if (now - input.getProcInTime() > UpgradeConstants.UPGRADE_TIMEOUT) {
                        input.setProcOutTime(System.currentTimeMillis());
                        ops.rightPop(UpgradeConstants.REDIS_KEY_PROC_QUEUE);
                        //发布处理失败event
                        context.publishEvent(new UpgradeFailedEvent(input));
                    }
                }
                if (isSuccess) {
                    // 从处理队列移除
                    input.setProcOutTime(System.currentTimeMillis());
                    ops.rightPop(UpgradeConstants.REDIS_KEY_PROC_QUEUE);
                    //发布处理成功event
                    context.publishEvent(new UpgradeSuccessEvent(input));
                } else {
                    long now = System.currentTimeMillis();
                    if (now - input.getProcInTime() > UpgradeConstants.UPGRADE_TIMEOUT) {
                        input.setProcOutTime(System.currentTimeMillis());
                        ops.rightPop(UpgradeConstants.REDIS_KEY_PROC_QUEUE);
                        //发布处理失败event
                        context.publishEvent(new UpgradeFailedEvent(input));
                    }
                }
            }
        } else {
            redisTemplate.opsForValue().set(UpgradeConstants.REDIS_KEY_PROC_COUNT, 0);
        }
    }

    // TODO 自动升级 每周三中午12点
    //@Scheduled(cron="0 0 12 ? * WED")
    public void cronJob() {
        Set<String> set = redisTemplate.opsForHash().keys(UpgradeConstants.REDIS_KEY_AUTO_QUEUE);
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            upgradeService.upgradeCron(it.next());
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
