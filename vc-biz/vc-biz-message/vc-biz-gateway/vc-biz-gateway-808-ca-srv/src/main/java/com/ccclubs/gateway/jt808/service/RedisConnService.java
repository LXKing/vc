package com.ccclubs.gateway.jt808.service;

import com.ccclubs.frm.spring.constant.RedisConst;
import com.ccclubs.frm.spring.gateway.ConnOnlineStatusEvent;
import com.ccclubs.gateway.common.constant.GatewayType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * @Author: yeanzi
 * @Date: 2018/6/28
 * @Time: 9:29
 * Email:  yeanzhi@ccclubs.com
 * 终端连接信息redis存储服务
 */
@Component
public class RedisConnService {

    @Autowired
    private RedisTemplate redisTemplate;

    public void markOnline(String sim, boolean isOnline) {
        HashOperations operations = redisTemplate.opsForHash();
        operations.put("online:808:" + sim, "online", true);
        operations.put("online:808:" + sim, "createTime", new Date());
        operations.put("online:808:" + sim, "disconnectedTime", 0);
        operations.put("online:808:" + sim, "pacCount", 1);


    }

    public void disconnect(String sim) {
        HashOperations operations = redisTemplate.opsForHash();
        operations.increment("online:808:" + sim, "disconnectedTime", 1);

    }

    /**
     * 从Redis中获取终端（key）的一个在线事件
     * @param key
     * @param gatewayType
     * @return  null：如果不存在
     */
    public ConnOnlineStatusEvent getOnlineEvent(String key, GatewayType gatewayType) {
        ConnOnlineStatusEvent conn = (ConnOnlineStatusEvent)redisTemplate.opsForHash().get(RedisConst.REDIS_KEY_TCP_ONLINE + RedisConst.REDIS_KEY_SPLIT + gatewayType.getDes(), key);
        return conn;
    }

}
