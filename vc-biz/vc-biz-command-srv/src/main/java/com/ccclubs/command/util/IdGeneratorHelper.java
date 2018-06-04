package com.ccclubs.command.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

import static com.ccclubs.frm.spring.constant.RedisConst.REDIS_KEY_808_CSRSID_GEN;
import static com.ccclubs.frm.spring.constant.RedisConst.REDIS_KEY_CSRID_GEN;

/**
 * 指令流水号生成器
 *
 * @author jianghaiyang
 * @create 2018-01-25
 **/
@Component
public class IdGeneratorHelper {

    private static final Logger logger = LoggerFactory.getLogger(IdGeneratorHelper.class);

    /**
     * sid最大值
     */
    private static final int MAX_SID = 65535;
    /**
     * 6天后过期
     */
    private static final int EXPIRE = 6;

    @Resource(name = "ttpRedisConnectionFactory")
    RedisConnectionFactory redisConnectionFactory;

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 指令记录全局唯一ID
     *
     * @return
     */
    public Long getNextId() {
        RedisAtomicLong idGen = new RedisAtomicLong(REDIS_KEY_CSRID_GEN, redisConnectionFactory);
        long csrId = idGen.incrementAndGet();
        return csrId;
    }

    /**
     * 808指令-2字节流水号
     *
     * @param vin 车辆vin码
     * @return
     */
    public Long getNextSid(String vin) {
        String key = REDIS_KEY_808_CSRSID_GEN + ":" + vin;
        RedisAtomicLong sidGen = new RedisAtomicLong(key, redisConnectionFactory);
        sidGen.expire(EXPIRE, TimeUnit.DAYS);
        long csrsId = sidGen.incrementAndGet();
        if (MAX_SID <= csrsId) {
            redisTemplate.delete(key);
        }
        return csrsId;
    }
}
