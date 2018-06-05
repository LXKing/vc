package com.ccclubs.gateway.common.connection;

import io.netty.channel.ChannelId;
import io.netty.channel.socket.SocketChannel;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: yeanzi
 * @Date: 2018/6/4
 * @Time: 11:24
 * Email:  yeanzhi@ccclubs.com
 * 客户端连接容器
 */
public class ClientConnCollection {
//    public static final String EMPTY_UNIQUENO = "EMPTY_UNIQUENO";

    private static final Logger LOG = LoggerFactory.getLogger(ClientConnCollection.class);

    /**
     * 渠道ID与终端唯一标识的映射
     *      key=channelId, value=uniqueNo
     */
    private static final Map<ChannelId, String> CHANNELID_CLIENT_MAP = new ConcurrentHashMap<>(1000);

    /**
     * 终端唯一标识与终端连接缓存的映射
     *      key=uniqueNo, value=AbstractClientConn
     */
    private static final Map<String, AbstractClientConn> CLIENT_CONN_MAP = new ConcurrentHashMap<>(1000);

    public static AbstractClientConn getByUniqueNo(String uniqueNo) {
        return CLIENT_CONN_MAP.get(uniqueNo);
    }

    public static AbstractClientConn getByChannelId(ChannelId id) {
        String uniqueNo = CHANNELID_CLIENT_MAP.get(id);
        if (StringUtils.isNotEmpty(uniqueNo)) {
            return CLIENT_CONN_MAP.get(uniqueNo);
        }
        return null;
    }

    public static AbstractClientConn add(AbstractClientConn abstractClientConn) {
        String uniqueNo = abstractClientConn.getUniqueNo();
        SocketChannel channel = abstractClientConn.getSocketChannel();
        AbstractClientConn conn = CLIENT_CONN_MAP.get(uniqueNo);
        if (Objects.isNull(conn)) {
            // 新建一个连接
            CLIENT_CONN_MAP.put(uniqueNo, abstractClientConn);
            CHANNELID_CLIENT_MAP.put(channel.id(), uniqueNo);
        } else {
            LOG.warn("创建新连接({})时发现连接已存在：newChannleId={}, oldChannelId={}", uniqueNo, channel.id(), conn.getSocketChannel().id());
            // 连接已存在，则释放原来的连接，使用新连接
            CHANNELID_CLIENT_MAP.remove(conn.getSocketChannel().id());
            conn.replace(channel);
            CHANNELID_CLIENT_MAP.put(channel.id(), uniqueNo);
        }
        return conn;
    }

    public static void channelInactive(SocketChannel channel) {

        CHANNELID_CLIENT_MAP.remove(channel.id());
    }

    public static void channelActive(String uniqueNo, SocketChannel channel) {
        AbstractClientConn conn = CLIENT_CONN_MAP.get(uniqueNo);
        CHANNELID_CLIENT_MAP.remove(conn.getSocketChannel().id());
        conn.replace(channel);
        CHANNELID_CLIENT_MAP.put(channel.id(), uniqueNo);
    }

    public static boolean logout(String uniqueNo, SocketChannel channel) {
        AbstractClientConn conn = CLIENT_CONN_MAP.get(uniqueNo);
        if (Objects.nonNull(conn)) {
            conn.closeWhenDisconnect();
        }
        CHANNELID_CLIENT_MAP.remove(channel.id());
        CLIENT_CONN_MAP.remove(uniqueNo);
        return true;
    }

    public static boolean isOnline(String vin) {
        if (vin == null || vin.length() == 0) {
            LOG.error("查询机车在线时参数vin为空");
            return false;
        }
        AbstractClientConn conn = CLIENT_CONN_MAP.get(vin);
        if (conn == null || !conn.isOnline()) {
            return false;
        }
        return true;
    }
}
