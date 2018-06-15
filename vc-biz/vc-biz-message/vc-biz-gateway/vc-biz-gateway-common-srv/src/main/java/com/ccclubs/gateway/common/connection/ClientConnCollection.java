package com.ccclubs.gateway.common.connection;

import io.netty.channel.ChannelId;
import io.netty.channel.socket.SocketChannel;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: yeanzi
 * @Date: 2018/6/4
 * @Time: 11:24
 * Email:  yeanzhi@ccclubs.com
 * 客户端连接容器
 */
public class ClientConnCollection {

    private static final Logger LOG = LoggerFactory.getLogger(ClientConnCollection.class);

    /**
     * 渠道ID与终端唯一标识的映射
     *      key=channelId, value=uniqueNo
     *      TODO 对channelId重复校验，防止由于uniqueNo异常导致前一个连接断开
     */
    private static final ConcurrentHashMap<ChannelId, String> CHANNELID_TO_CLIENT = new ConcurrentHashMap<>(1000);

    /**
     * 终端唯一标识与终端连接缓存的映射
     *      key=uniqueNo, value=AbstractClientConn
     */
    private static final ConcurrentHashMap<String, AbstractClientConn> UNIQUENO_TO_CLIENT = new ConcurrentHashMap<>(1000);

    public static AbstractClientConn getByUniqueNo(String uniqueNo) {
        Objects.requireNonNull(uniqueNo);

        return UNIQUENO_TO_CLIENT.get(uniqueNo);
    }

    public static AbstractClientConn getByChannelId(ChannelId id) {
        Objects.requireNonNull(id);

        String uniqueNo = CHANNELID_TO_CLIENT.get(id);
        if (StringUtils.isNotEmpty(uniqueNo)) {
            return UNIQUENO_TO_CLIENT.get(uniqueNo);
        }
        return null;
    }

    public static AbstractClientConn addNew(AbstractClientConn abstractClientConn, SocketChannel newChannel) {
        Objects.requireNonNull(abstractClientConn);
        Objects.requireNonNull(newChannel);
        if (ClientSocketCollection.channelInActive(newChannel)) {
            throw new IllegalStateException("创建新客户端缓存时发现：连接通道状态异常");
        }
        String uniqueNo = abstractClientConn.getUniqueNo();
        AbstractClientConn conn = UNIQUENO_TO_CLIENT.get(uniqueNo);
        if (Objects.isNull(conn)) {
            // 新建一个连接
            ClientSocketCollection.put(uniqueNo, newChannel);
            UNIQUENO_TO_CLIENT.put(uniqueNo, abstractClientConn);
            CHANNELID_TO_CLIENT.put(newChannel.id(), uniqueNo);
        } else {
            conn.markChannelActive();
            if (ClientSocketCollection.existed(uniqueNo, newChannel)) {
                // 同一连接时
                CHANNELID_TO_CLIENT.put(newChannel.id(), uniqueNo);
            } else {
                LOG.warn("创建新连接({})时发现连接已存在", uniqueNo);
                // 1. 移除原连接映射
                SocketChannel oldChannel = ClientSocketCollection.get(uniqueNo);
                removeChannelId(oldChannel);

                // 2. 连接已存在，则释放原来的连接，使用新连接
                ClientSocketCollection.updateAndCloseOld(uniqueNo, newChannel);
                CHANNELID_TO_CLIENT.put(newChannel.id(), uniqueNo);
            }
        }
        return conn;
    }

    public static void doDisconnected(SocketChannel channel) {
        Objects.requireNonNull(channel);

        AbstractClientConn conn = getByChannelId(channel.id());
        if (Objects.nonNull(conn)) {
            // 标记客户端状态
            conn.markChannelClosed();
            // 关闭连接通道
            ClientSocketCollection.delete(conn.getUniqueNo());
        }
        CHANNELID_TO_CLIENT.remove(channel.id());
    }

    /**
     * 终端重连时
     * @param uniqueNo
     * @param channel
     */
    public static void doReconnecte(String uniqueNo, SocketChannel channel) {
        Objects.requireNonNull(channel);

        AbstractClientConn conn = getByUniqueNo(uniqueNo);
        conn.markChannelActive();

        if (ClientSocketCollection.existed(uniqueNo, channel)) {
            // 同一连接时
            CHANNELID_TO_CLIENT.put(channel.id(), uniqueNo);
        } else {
            // 1. 移除原连接映射
            SocketChannel oldChannel = ClientSocketCollection.get(uniqueNo);
            removeChannelId(oldChannel);
            // 连接已存在，则释放原来的连接，使用新连接
            ClientSocketCollection.updateAndCloseOld(uniqueNo, channel);
            CHANNELID_TO_CLIENT.put(channel.id(), uniqueNo);
        }
    }

    public static boolean logout(String uniqueNo, SocketChannel channel) {
        Objects.requireNonNull(channel);

        AbstractClientConn conn = UNIQUENO_TO_CLIENT.get(uniqueNo);
        if (Objects.nonNull(conn)) {
            conn.markChannelClosed();
        }
        ClientSocketCollection.delete(uniqueNo);
        CHANNELID_TO_CLIENT.remove(channel.id());
        UNIQUENO_TO_CLIENT.remove(uniqueNo);
        return true;
    }

    public static boolean isOnline(String vin) {
        if (vin == null || vin.length() == 0) {
            LOG.error("查询机车在线时参数vin为空");
            return false;
        }
        AbstractClientConn conn = UNIQUENO_TO_CLIENT.get(vin);
        if (conn == null || !conn.isOnline()) {
            return false;
        }
        return true;
    }

    public static Optional<AbstractClientConn> getIfExist(String uniqueNo) {
        Optional<AbstractClientConn> connOptional = Optional.empty();
        AbstractClientConn conn = UNIQUENO_TO_CLIENT.get(uniqueNo);
        if (Objects.nonNull(conn)) {
            connOptional = Optional.of(conn);
        }
        return connOptional;
    }

    private static void removeChannelId(SocketChannel channel) {
        if (Objects.nonNull(channel)) {
            CHANNELID_TO_CLIENT.remove(channel.id());
        }
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
        Set<ChannelId> channelIds = CHANNELID_TO_CLIENT.keySet();
        for (ChannelId id :
                channelIds) {
            String idSim = CHANNELID_TO_CLIENT.get(id);
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
