package com.ccclubs.gateway.common.connection;

import io.netty.channel.ChannelFuture;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.internal.PlatformDependent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

/**
 * @Author: yeanzi
 * @Date: 2018/6/13
 * @Time: 14:46
 * Email:  yeanzhi@ccclubs.com
 * 客户端socke连接容器类
 */
@Component
public class ClientSocketCollection {
    public static final Logger LOG = LoggerFactory.getLogger(ClientSocketCollection.class);

    /**
     * 终端唯一标识与终端连接缓存的映射
     *      key=uniqueNo, value=AbstractClientConn
     */
    private static final ConcurrentMap<String, SocketChannel> UNIQUENO_TO_SOCKET = PlatformDependent.newConcurrentHashMap(1000);

    /**
     * 根据uniqueNo获取SocketChannel
     * @param uniqueNo
     * @return
     */
    public Optional<SocketChannel> getByUniqueNo(String uniqueNo) {
        Objects.requireNonNull(uniqueNo);

        return Optional.ofNullable(UNIQUENO_TO_SOCKET.get(uniqueNo));
    }

    /**
     * 更新socket
     *     移除已存在的旧连接，新增新连接
     * @param uniqueNo
     * @param newChannel
     */
    public void updateAndCloseOld(String uniqueNo, SocketChannel newChannel) {
        Objects.requireNonNull(uniqueNo);
        Objects.requireNonNull(newChannel);

        if (channelInActive(newChannel)) {
            throw new IllegalStateException("更新channel时发现：新连接连接状态异常");
        }
        SocketChannel oldChannel = UNIQUENO_TO_SOCKET.get(uniqueNo);
        closeChannel(oldChannel);
        UNIQUENO_TO_SOCKET.put(uniqueNo, newChannel);
    }

    /**
     * uniqueNo是否已存在对应socket
     * @param uniqueNo
     * @return
     */
    public boolean existed(String uniqueNo) {
        Objects.requireNonNull(uniqueNo);

        return UNIQUENO_TO_SOCKET.containsKey(uniqueNo);
    }

    /**
     * 校验是否内存中存在相同的socket
     * @param uniqueNo
     * @param channel
     * @return
     */
    public boolean sameChannel(String uniqueNo, SocketChannel channel) {
        Objects.requireNonNull(uniqueNo);
        Objects.requireNonNull(channel);

        SocketChannel oldChannel = UNIQUENO_TO_SOCKET.get(uniqueNo);
        return Objects.nonNull(oldChannel) &&
                oldChannel.id().equals(channel.id());
    }

    /**
     * 新增一个socket
     * @param uniqueNo
     * @param newChannel
     * @return
     */
    public ClientSocketCollection add(String uniqueNo, SocketChannel newChannel) {
        if (channelInActive(newChannel)) {
            LOG.error("新的连接[{}]状态异常", uniqueNo);
            throw new IllegalStateException("新的连接[{" + uniqueNo+ "}]状态异常");
        }
        if (existed(uniqueNo)) {
            LOG.error("client socket existed when add new one: uniqueNo={}", uniqueNo);
            // 移除旧连接，添加新连接
            updateAndCloseOld(uniqueNo, newChannel);
        } else {
            if (sameChannel(uniqueNo, newChannel)) {
                LOG.error("same client socket found when add new one: uniqueNo={}", uniqueNo);
            } else {
                UNIQUENO_TO_SOCKET.put(uniqueNo, newChannel);
            }
        }
        return this;
    }

    /**
     * 终端下线时
     * @param uniqueNo
     * @param offlineChannel
     * @return
     */
    public ClientSocketCollection offline(String uniqueNo, SocketChannel offlineChannel) {
        if (existed(uniqueNo)) {
            if (sameChannel(uniqueNo, offlineChannel)) {
                closeChannel(offlineChannel);
            } else {
                LOG.error("client socket are not same when offline; both socket will be closed!");
                getByUniqueNo(uniqueNo).ifPresent(socket -> closeChannel(socket));
                closeChannel(offlineChannel);
            }
        } else {
            LOG.error("client socket not existed when offline: uniqueNo={}", uniqueNo);
        }
        return this;
    }

    /**
     * 终端上线
     * @param uniqueNo
     * @param channel
     * @return
     */
    public ClientSocketCollection online(String uniqueNo, SocketChannel channel) {
        if (channelInActive(channel)) {
            LOG.error("socket not active when deal online event: uniqueNo={}", uniqueNo);
            throw new IllegalStateException("illegal socket state when deal online event: uniqueNo=" + uniqueNo);
        }
        if (existed(uniqueNo)) {
            LOG.error("client socket already existed when deal online event: uniqueNo={}", uniqueNo);
            // 移除旧连接，添加新连接
            updateAndCloseOld(uniqueNo, channel);
        } else {
            if (sameChannel(uniqueNo, channel)) {
                LOG.error("a same client socket already existed when deal online event: uniqueNo={}", uniqueNo);
            } else {
                UNIQUENO_TO_SOCKET.put(uniqueNo, channel);
            }
        }
        return this;
    }

    /**
     * socket注销
     * @param uniqueNo
     * @param channel
     * @return
     */
    public ClientSocketCollection logout(String uniqueNo, SocketChannel channel) {
        offline(uniqueNo, channel);
        return this;
    }


    /**
     * 判断连接是否不活跃
     * @param channel
     * @return
     */
    public static boolean channelInActive(SocketChannel channel) {
        Objects.requireNonNull(channel);

        return !channel.isOpen(); // ||
//                !channel.isActive() ||
//                channel.isShutdown();
    }

    /**
     * 关闭socket连接
     * @param channel
     * @return
     */
    private ChannelFuture closeChannel(SocketChannel channel) {
        if (Objects.nonNull(channel)) {
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
