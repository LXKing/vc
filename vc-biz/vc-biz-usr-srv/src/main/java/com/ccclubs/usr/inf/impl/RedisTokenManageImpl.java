package com.ccclubs.usr.inf.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.usr.inf.TokenManageInf;
import com.ccclubs.usr.util.Constant;
import com.ccclubs.usr.util.JwtUtil;
import com.ccclubs.usr.version.UserServiceVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * redis管理token
 *
 * @author jianghaiyang
 * @create 2017-09-13
 **/
@Service(version = UserServiceVersion.V1)
public class RedisTokenManageImpl implements TokenManageInf {

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 创建Token
     *
     * @param account 账号
     * @param token
     */
    @Override
    public void saveToken(String account, String token) {
        redisTemplate.opsForValue().set(Constant.REDIS_KEY_TOKEN + account, token, Constant.TOKEN_TTL, TimeUnit.SECONDS);
    }

    /**
     * 通过account获得对应的token
     *
     * @param account 账号
     * @return
     */
    @Override
    public String getTokenByKey(String account) {
        return (String) redisTemplate.opsForValue().get(Constant.REDIS_KEY_TOKEN + account);
    }

    /**
     * 通过account删除Token
     *
     * @param account 账号
     */
    @Override
    public void delTokenByKey(String account) {
        redisTemplate.opsForValue().getOperations().delete(Constant.REDIS_KEY_TOKEN + account);
    }

    /**
     * 解析Token
     *
     * @param token
     */
    @Override
    public Map<String, Object> parseToken(String token, String appKey) throws Exception {
        return JwtUtil.parseJWT(token, appKey);
    }
}
