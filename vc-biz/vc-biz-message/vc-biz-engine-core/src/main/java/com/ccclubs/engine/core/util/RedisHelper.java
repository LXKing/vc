package com.ccclubs.engine.core.util;

import com.ccclubs.frm.redis.old.MyStringRedisTemplate;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

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
  @Autowired
  private MyStringRedisTemplate myRedisTemplate;

  /**
   * 设置映射关系缓存-NotExist(MachineMapping)
   */
  public void setNotExist(String keyPart, Object value) {
    ValueOperations valueOperations = redisTemplate.opsForValue();
    valueOperations.set(AssembleHelper.getKey(RuleEngineConstant.REDIS_KEY_NOT_EXIST, keyPart),
        value,
        RuleEngineConstant.REDIS_EXPIRE, TimeUnit.SECONDS);
  }

  /**
   * 缓存指令执行结果，缓存30s
   */
  public void setRemote(String keyPart, Object value) {
    ValueOperations valueOperations = redisTemplate.opsForValue();
    valueOperations.set(AssembleHelper.getKey(RuleEngineConstant.REDIS_KEY_CMD_REMOTE, keyPart),
        value,
        RuleEngineConstant.RENOTE_EXPIRE, TimeUnit.SECONDS);
  }

  /**
   * 缓存指令执行结果，兼容1.0系统
   */
  public void setRemoteOld(String keyPart, Object value) {
    ValueOperations valueOperations = myRedisTemplate.opsForValue();
    valueOperations.set(AssembleHelper.cmdKey(keyPart), value, RuleEngineConstant.RENOTE_EXPIRE,
        TimeUnit.SECONDS);
  }

  public void setMappingOld(Class modelClass, String keyPart, Object value) {
    ValueOperations valueOperations = myRedisTemplate.opsForValue();
    valueOperations
        .set(new StringBuilder().append("OBJ.")
                .append(modelClass.getName().replaceAll("[^\\.]*\\.", "")).append(".").append(keyPart),
            value,
            RuleEngineConstant.MAPPING_REDIS_EXPIRE,
            TimeUnit.SECONDS);
  }

}
