package com.ccclubs.engine.core.util;

import com.ccclubs.protocol.util.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * redis操作类
 *
 * @author jianghaiyang
 * @create 2017-08-10
 **/
@Component
public class RedisHelper {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 设置映射关系缓存-NotExist(MachineMapping)
     *
     * @param keyPart
     * @return
     */
    public void setNotExist(String keyPart,Object value) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set(AssembleHelper.getKey(RuleEngineConstant.REDIS_KEY_NOT_EXIST, keyPart),
                value,
                RuleEngineConstant.REDIS_EXPIRE, TimeUnit.SECONDS);
    }

    /**
     * 缓存指令执行结果，缓存30s
     *
     * @param keyPart
     * @return
     */
    public void setRemote(String keyPart,Object value) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set(AssembleHelper.getKey(RuleEngineConstant.REDIS_KEY_CMD_REMOTE, keyPart),
                value,
                RuleEngineConstant.RENOTE_EXPIRE, TimeUnit.SECONDS);
    }
}
