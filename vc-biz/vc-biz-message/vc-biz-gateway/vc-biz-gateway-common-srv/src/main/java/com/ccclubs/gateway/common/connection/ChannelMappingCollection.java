package com.ccclubs.gateway.common.connection;

import io.netty.channel.ChannelId;
import io.netty.util.internal.PlatformDependent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: yeanzi
 * @Date: 2018/6/4
 * @Time: 11:24
 * Email:  yeanzhi@ccclubs.com
 * 客户端连接容器
 */
@Component
public class ChannelMappingCollection {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelMappingCollection.class);

    /**
     * 渠道ID与终端唯一标识的映射
     *      key=channelId.longText, value=uniqueNo
     *      TODO 对channelId重复校验，防止由于uniqueNo异常导致前一个连接断开
     */
    private static final Map<String, String> CHANNELID_TO_UNIQUENO = PlatformDependent.newConcurrentHashMap(1000);

    public ChannelMappingCollection add(String uniqueNo, ChannelId channelId) {
        String channelIdText = channelId.asLongText();
        if (!existed(channelIdText)) {
            CHANNELID_TO_UNIQUENO.put(channelIdText, uniqueNo);
        } else {
            LOG.error("channelId existed when put one; channelIdText: {}", channelIdText);
        }
        return this;
    }

    /**
     * 验证映射是否已存在
     * @param channelIdLongText
     * @return
     */
    public boolean existed(String channelIdLongText) {
        Objects.requireNonNull(channelIdLongText);

        return CHANNELID_TO_UNIQUENO.containsKey(channelIdLongText);
    }

    /**
     * 终端下线时，移除channelId映射
     * @param uniqueNo
     * @param channelIdLongText
     * @return
     */
    public ChannelMappingCollection offline(String uniqueNo, String channelIdLongText) {
        Objects.requireNonNull(uniqueNo);
        Objects.requireNonNull(channelIdLongText);

        String oldUniqueNoMapping = CHANNELID_TO_UNIQUENO.get(channelIdLongText);
        if (uniqueNo.equals(oldUniqueNoMapping)) {
            CHANNELID_TO_UNIQUENO.remove(channelIdLongText);
        } else {
            LOG.error("uniqueNo not same in remove channelIdMapping when socket offline; existed={}, offlined={}",
                    oldUniqueNoMapping, uniqueNo);
            CHANNELID_TO_UNIQUENO.remove(channelIdLongText);
        }
        return this;
    }

    /**
     * 处理上线事件
     * @param uniqueNo
     * @param channelId
     * @return
     */
    public ChannelMappingCollection online(String uniqueNo, ChannelId channelId) {
        String channelIdText = channelId.asLongText();
        if (!existed(channelIdText)) {
            CHANNELID_TO_UNIQUENO.put(channelIdText, uniqueNo);
        } else {
            LOG.error("channelId existed when deal online event; channelIdText: {}", channelIdText);
        }
        return this;
    }

    /**
     * 处理注销
     * @param uniqueNo
     * @param channelIdLongText
     * @return
     */
    public ChannelMappingCollection logout(String uniqueNo, String channelIdLongText) {
        CHANNELID_TO_UNIQUENO.remove(channelIdLongText);
        return this;
    }

    /**
     * 获取channelId对应的uniqueNo
     * @param channelIdLongText
     * @return
     */
    public Optional<String> getUniqueNoByChannelIdLongText(String channelIdLongText) {
        Objects.requireNonNull(channelIdLongText);

        return Optional.ofNullable(CHANNELID_TO_UNIQUENO.get(channelIdLongText));
    }
}
