package com.ccclubs.gateway.common.connection;

import io.netty.channel.ChannelId;
import io.netty.channel.socket.SocketChannel;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;
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
    private static final ConcurrentHashMap<String, String> CHANNELID_TO_UNIQUENO = new ConcurrentHashMap<>(1000);

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






    /**以下方法属于连接监控参数查询用，业务操作时请不要调用**/
    @Deprecated
    public static Integer getAllConn() {
        return UNIQUENO_TO_CLIENT.size();
    }

    @Deprecated
    public static Set<String> getAllConnSIM() {
        return UNIQUENO_TO_CLIENT.keySet();
    }

    /**
     * 获取在channelIdMap中存在，而连接不存在的sim卡号列表
     * @return
     */
    @Deprecated
    public static List<String> getAllChannelIdWithEmptyConnList() {
        List<String> simList = new ArrayList<>();
        Set<ChannelId> channelIds = CHANNELID_TO_UNIQUENO.keySet();
        for (ChannelId id :
                channelIds) {
            String idSim = CHANNELID_TO_UNIQUENO.get(id);
            boolean isExist = false;
            for (String sim:
            UNIQUENO_TO_CLIENT.keySet()) {
                if (idSim.equals(sim)) {
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                simList.add(idSim);
            }
        }
        return simList;
    }
}
