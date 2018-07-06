package com.ccclubs.gateway.jt808.service;

import com.ccclubs.frm.spring.constant.RedisConst;
import com.ccclubs.frm.spring.gateway.ConnOnlineStatusEvent;
import com.ccclubs.gateway.common.bean.event.ConnLiveEvent;
import com.ccclubs.gateway.common.constant.GatewayType;
import com.ccclubs.gateway.jt808.util.RedisObjectBuilder;
import io.netty.channel.socket.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @Author: yeanzi
 * @Date: 2018/6/28
 * @Time: 9:29
 * Email:  yeanzhi@ccclubs.com
 * 终端连接信息redis存储服务
 */
@Component
public class RedisConnService {
    private static final Logger LOG = LoggerFactory.getLogger(RedisConnService.class);

    /**
     * 客户端统计详情
     */
    private static final String REDIS_KEY_TCP_CLIENT_PRIFIX = "tcp:client";

    /**
     * 终端上线下线轨迹
     */
    private static final String REDIS_KEY_TCP_TRACE_PRIFIX = "tcp:trace";

    @Autowired
    private RedisTemplate redisTemplate;

    @Deprecated
    public void cleanChacheForTheFirstTime() {
        Set<String> tcpKeys = redisTemplate.keys("tcp*");
        redisTemplate.delete(tcpKeys);
        Set<String> TCPKeys = redisTemplate.keys("TCP*");
        redisTemplate.delete(TCPKeys);
    }

    /**
     * 客户端第一次注册
     * @param uniqueNo
     * @param channel
     * @param gatewayType
     */
    public void clientRegister(String uniqueNo, SocketChannel channel, GatewayType gatewayType) {
        HashOperations operations = redisTemplate.opsForHash();
        String clientKey = getClientKey(uniqueNo, gatewayType);

        // remote redis中是否已存在该客户端
        if (isExisted(uniqueNo, gatewayType)) {
            LOG.warn("redis中已存在一个(uniqueNo={})的客户端,将覆盖已存在的客户端信息", uniqueNo);
        }
        String nowStr = DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.now());
        RedisObjectBuilder.RedisObj redisObj =
                new RedisObjectBuilder.RedisObj(clientKey)
                // 身份信息
                .put("uniqueNo", uniqueNo)
                .put("channelIdLongText", channel.id().asLongText())
                // 在线状态
                .put("online", true)
                .put( "createTime", nowStr)
                .put( "LastOnlineTime", nowStr)
                .put( "currentServerIp", channel.localAddress().getHostString())
                .put( "lastOfflineServerIp", null)
                // 报文统计信息
                .put( "packageNum", 0)
                .put( "errorPackageNum", 0)
                .put( "positionPackageNum", 0)
                .put( "disconnectTime", 0);

        operations.putAll(redisObj.getIdKey(), redisObj);

        // 设置轨迹信息过期时间
        String traceKey = getTraceKey(uniqueNo, gatewayType);
        redisTemplate.expire(traceKey, 7 * 24, TimeUnit.HOURS);
    }

    /**
     * 客户端下线
     * @param uniqueNo
     * @param channel
     * @param gatewayType
     */
    public void offline(String uniqueNo, SocketChannel channel, GatewayType gatewayType) {
        if (!isExisted(uniqueNo, gatewayType)) {
            LOG.error("client info not existed in redis when update offline", uniqueNo);
        }

        String clientKey = getClientKey(uniqueNo, gatewayType);
        HashOperations operations = redisTemplate.opsForHash();

        operations.put(clientKey, "online", false);
        operations.increment(clientKey, "disconnectTime", 1);
        operations.put(clientKey, "channelIdLongText", null);
        operations.put(clientKey, "lastOfflineServerIp", channel.localAddress().getHostString());
    }

    /**
     * 客户端上线
     * @param uniqueNo
     * @param channel
     * @param gatewayType
     */
    public void online(String uniqueNo, SocketChannel channel, GatewayType gatewayType) {
        if (!isExisted(uniqueNo, gatewayType)) {
            LOG.error("client info not existed in redis when update online", uniqueNo);
        }
        String clientKey = getClientKey(uniqueNo, gatewayType);
        HashOperations operations = redisTemplate.opsForHash();
        String nowStr = DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.now());
        RedisObjectBuilder.RedisObj redisObj =
                new RedisObjectBuilder.RedisObj(clientKey)
                        .put("online", true)
                .put("channelIdLongText", channel.id().asLongText())
                .put("LastOnlineTime", nowStr)
                .put("currentServerIp", channel.localAddress().getHostString());

        operations.putAll(redisObj.getIdKey(), redisObj);
    }

    /**
     * 客户端注销
     * @param uniqueNo
     * @param gatewayType
     */
    public void logout(String uniqueNo, GatewayType gatewayType) {
        if (!isExisted(uniqueNo, gatewayType)) {
            LOG.error("client info not existed in redis when logout", uniqueNo);
        }

        // 清除客户端信息
        String clientKey = getClientKey(uniqueNo, gatewayType);
//        HashOperations operations = redisTemplate.opsForHash();
//        Set<String> keySets = operations.keys(clientKey);
//        operations.delete(clientKey, keySets.toArray());

        // 清除客户端轨迹信息
        String traceKey = getTraceKey(uniqueNo, gatewayType);

        List<String> keyList = new ArrayList<>();
        keyList.add(clientKey);

        // TODO 暂时不清理轨迹列表, 注销也属于轨迹事件
//        keyList.add(traceKey);
        redisTemplate.delete(keyList);
    }

    /**
     * 更新客户端统计数据
     * @param uniqueNo
     * @param key
     * @param add
     * @param gatewayType
     */
    public void updatePac(String uniqueNo, String key, int add, GatewayType gatewayType) {
        if (!isExisted(uniqueNo, gatewayType)) {
            LOG.error("client info not existed in redis when update package info", uniqueNo);
            throw new IllegalStateException("client info not existed");
        }

        String clientKey = getClientKey(uniqueNo, gatewayType);
        HashOperations operations = redisTemplate.opsForHash();
        operations.increment(clientKey, key, add);
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

    /**
     * 检查该uniqueNo对应的客户端是否存在于redis 中
     * @param uniqueNo
     * @param gatewayType
     * @return
     */
    public boolean isExisted(String uniqueNo, GatewayType gatewayType) {
        Objects.requireNonNull(uniqueNo);
        Objects.requireNonNull(gatewayType);

        String clientKey = getClientKey(uniqueNo, gatewayType);
        Map objMap = redisTemplate.opsForHash().entries(clientKey);
        return Objects.nonNull(objMap) &&
                objMap.size() > 0;
    }

    /**
     * 查询在redis中client是否在线
     * @param uniqueNo
     * @param gatewayType
     * @return
     */
    public boolean isOnline(String uniqueNo, GatewayType gatewayType) {
        Objects.requireNonNull(uniqueNo);
        Objects.requireNonNull(gatewayType);

        String clientKey = getClientKey(uniqueNo, gatewayType);
        Map objMap = redisTemplate.opsForHash().entries(clientKey);
        if (Objects.isNull(objMap) || objMap.size() == 0) {
            LOG.error("client info not existed when check online, uniqueNo={}", uniqueNo);
            return false;
        }
        return (boolean) objMap.get("online");
    }

    public void addTcpStatusTraceEvent(String uniqueNo, GatewayType gatewayType, ConnLiveEvent event) {
        Objects.requireNonNull(uniqueNo);
        Objects.requireNonNull(gatewayType);
        Objects.requireNonNull(event);

        String traceKey = getTraceKey(uniqueNo, gatewayType);
        redisTemplate.opsForList().leftPush(traceKey, event);
    }

    private String getClientKey(String uniqueNo, GatewayType gatewayType) {
        return REDIS_KEY_TCP_CLIENT_PRIFIX + ":" + gatewayType.getDes() + ":" + uniqueNo;
    }

    private String getTraceKey(String uniqueNo, GatewayType gatewayType) {
        return REDIS_KEY_TCP_TRACE_PRIFIX + ":" + gatewayType.getDes() + ":" + uniqueNo;
    }

}
