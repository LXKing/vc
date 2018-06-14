package com.ccclubs.gateway.common.connection;

import io.netty.channel.ChannelFuture;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.internal.PlatformDependent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

/**
 * @Author: yeanzi
 * @Date: 2018/6/13
 * @Time: 14:46
 * Email:  yeanzhi@ccclubs.com
 * 客户端socke连接容器类
 */
public class ClientSocketCollection {
    public static final Logger LOG = LoggerFactory.getLogger(ClientSocketCollection.class);

    /**
     * 终端唯一标识与终端连接缓存的映射
     *      key=uniqueNo, value=AbstractClientConn
     */
    private static final ConcurrentMap<String, SocketChannel> UNIQUENO_TO_SOCKET = PlatformDependent.newConcurrentHashMap(1000);

    public static SocketChannel get(String uniqueNo) {
        Objects.requireNonNull(uniqueNo);

        return UNIQUENO_TO_SOCKET.get(uniqueNo);
    }

    public static void updateAndCloseOld(String uniqueNo, SocketChannel newChannel) {
        Objects.requireNonNull(uniqueNo);
        Objects.requireNonNull(newChannel);

        if (channelInActive(newChannel)) {
            throw new IllegalStateException("更新channel时发现：新连接连接状态异常");
        }
        SocketChannel oldChannel = UNIQUENO_TO_SOCKET.get(uniqueNo);
        closeChannel(oldChannel);
        UNIQUENO_TO_SOCKET.put(uniqueNo, newChannel);
    }

    public static SocketChannel update(String uniqueNo, SocketChannel newChannel) {
        Objects.requireNonNull(uniqueNo);
        Objects.requireNonNull(newChannel);

        if (channelInActive(newChannel)) {
            throw new IllegalStateException("更新channel时发现：新连接连接状态异常");
        }

        SocketChannel oldChannel = UNIQUENO_TO_SOCKET.get(uniqueNo);
        UNIQUENO_TO_SOCKET.put(uniqueNo, newChannel);

        return oldChannel;
    }

    /**
     * 检验连接是否已经缓存
     * @param uniqueNo
     * @param checkChannel
     * @return
     */
    public static boolean existed(String uniqueNo, SocketChannel checkChannel) {
        Objects.requireNonNull(uniqueNo);
        Objects.requireNonNull(checkChannel);

        SocketChannel existedChannel = UNIQUENO_TO_SOCKET.get(uniqueNo);
        if (Objects.nonNull(existedChannel) && checkChannel.id().equals(existedChannel.id())) {
            return true;
        } else {
            return false;
        }
    }

    public static void delete(String uniqueNo) {
        Objects.requireNonNull(uniqueNo);

        SocketChannel deletingChannel = UNIQUENO_TO_SOCKET.get(uniqueNo);
        if (Objects.isNull(deletingChannel)) {
            LOG.error("删除连接时发现：连接[uniqueNo={}]不存在", uniqueNo);
        } else {
            // 1. 关闭连接
            closeChannel(deletingChannel);
            // 2. 移除映射
            UNIQUENO_TO_SOCKET.remove(uniqueNo);
        }
    }

    public static void put(String uniqueNo, SocketChannel newChannel) {
        Objects.requireNonNull(uniqueNo);
        Objects.requireNonNull(newChannel);

        if (channelInActive(newChannel)) {
            LOG.error("新的连接[{}]状态异常", uniqueNo);
            return;
        }
        UNIQUENO_TO_SOCKET.put(uniqueNo, newChannel);
    }
















    public static boolean channelInActive(SocketChannel channel) {
        Objects.requireNonNull(channel);

        return !channel.isOpen() ||
                !channel.isActive() ||
                channel.isShutdown();
    }

    private static ChannelFuture closeChannel(SocketChannel channel) {
        if (Objects.nonNull(channel) && channel.isOpen()) {
            return channel.close();
        }
        return null;
    }


    /**
     * 以下方法不要在业务上调用，仅调试用
     */
    @Deprecated
    public static SocketChannel getDetail(String uniqueNo) {
        return UNIQUENO_TO_SOCKET.get(uniqueNo);
    }

    @Deprecated
    public static int getAll() {
        return UNIQUENO_TO_SOCKET.size();
    }

    @Deprecated
    public static Set<String> getAllUniqueNo() {
        return UNIQUENO_TO_SOCKET.keySet();
    }

    @Deprecated
    public static Set<String> getAllDisConnected() {
        Set<String> uniqueNos = new HashSet<>();
        UNIQUENO_TO_SOCKET.forEach((no, channel) -> {
            if (channelInActive(channel)) {
                uniqueNos.add(no);
            }
        });
        return uniqueNos;
    }
}
