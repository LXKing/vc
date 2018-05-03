package com.ccclubs.gateway.gb.reflect;

import com.ccclubs.gateway.gb.exception.ChannelDisconnException;
import com.ccclubs.gateway.gb.utils.ChannelUtils;
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
 * @Date: 2018/4/2
 * @Time: 11:36
 * Email:  yeanzhi@ccclubs.com
 * 缓存终端连接等信息
 */
public class ClientCache {

    private static final Logger LOG = LoggerFactory.getLogger(ClientCache.class);

    private static final Map<ChannelId, String> CHANNELID_CLIENT_MAP = new ConcurrentHashMap<>();
    private static final Map<String, GBConnection> CLIENT_CONN_MAP = new ConcurrentHashMap<>();

    public static GBConnection getByVIN(String vin) {
        return CLIENT_CONN_MAP.get(vin);
    }

    public static GBConnection getByChannelId(ChannelId id) {
        String vin = CHANNELID_CLIENT_MAP.get(id);
        if (StringUtils.isNotEmpty(vin)) {
            return CLIENT_CONN_MAP.get(vin);
        }
        return null;
    }

    public static GBConnection add(String vin, SocketChannel channel) {
        GBConnection conn = CLIENT_CONN_MAP.get(vin);
        if (Objects.isNull(conn)) {
            // 新建一个连接
            conn = GBConnection.ofNew(vin, channel);
            CLIENT_CONN_MAP.put(vin, conn);
            CHANNELID_CLIENT_MAP.put(channel.id(), vin);
        } else {
            // 连接已存在，则释放原来的连接，使用新连接
            CHANNELID_CLIENT_MAP.remove(conn.getSocketChannel().id());
            conn.replace(channel);
            CHANNELID_CLIENT_MAP.put(channel.id(), vin);
        }
        return conn;
    }

    public static GBConnection checkConnection(String vin, SocketChannel channel) {
        if (StringUtils.isEmpty(vin)) {
            throw new IllegalArgumentException("查询连接时参数vin码为空");
        }
        if (ChannelUtils.notConnected(channel)) {
            throw new ChannelDisconnException(vin);
        }
        GBConnection conn = null;
        if (StringUtils.isEmpty(CHANNELID_CLIENT_MAP.get(channel.id()))) {
            conn = add(vin, channel);
        } else {
            conn = CLIENT_CONN_MAP.get(vin);
        }
        return conn;
    }

    public static void closeWhenInactive(SocketChannel channel) {
        String vin = CHANNELID_CLIENT_MAP.get(channel.id());
        if (StringUtils.isEmpty(vin)) {
            return;
        }
        GBConnection conn = CLIENT_CONN_MAP.get(vin);
        if (Objects.nonNull(conn)) {
            conn.closeWhenDisconnect();
        }
        CHANNELID_CLIENT_MAP.remove(channel.id());
        CLIENT_CONN_MAP.remove(vin);
    }

    public static boolean isOnline(String vin) {
        if (vin == null || vin.length() == 0) {
            LOG.error("查询机车在线时参数vin为空");
            return false;
        }
        GBConnection conn = CLIENT_CONN_MAP.get(vin);
        if (conn == null || !conn.isOnline()) {
            return false;
        }
        return true;
    }





}
