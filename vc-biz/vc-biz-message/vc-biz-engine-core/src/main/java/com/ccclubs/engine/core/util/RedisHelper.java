package com.ccclubs.engine.core.util;

import com.ccclubs.frm.redis.old.MyStringRedisTemplate;
import com.ccclubs.helper.MachineMapping;
import com.ccclubs.protocol.dto.jt808.Can2State;
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

  /**
   * 老系统中，获取 MachineMapping
   */
  public MachineMapping getMappingOld(String keyPart) {
    return (MachineMapping) myRedisTemplate.opsForValue()
        .get("OBJ.MachineMapping." + keyPart);
  }


  /**
   * 老系统中，获取 MachineMapping
   */
  public Can2State getCan2State(String simNo) {
    return (Can2State) redisTemplate.opsForValue()
        .get("Can2State:" + simNo);
  }

  /**
   * 老系统中，获取 MachineMapping
   */
  public void setCan2State(String simNo) {
    redisTemplate.opsForValue()
        .set("Can2State:" + simNo, 3 * 60 * 60);
  }
}
