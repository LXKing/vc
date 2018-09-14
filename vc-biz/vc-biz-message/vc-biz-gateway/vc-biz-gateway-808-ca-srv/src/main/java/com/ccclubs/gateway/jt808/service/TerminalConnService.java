package com.ccclubs.gateway.jt808.service;

import com.ccclubs.frm.spring.gateway.ConnOnlineStatusEvent;
import com.ccclubs.gateway.common.bean.attr.ChannelStatusAttr;
import com.ccclubs.gateway.common.constant.ChannelLiveStatus;
import com.ccclubs.gateway.common.constant.GatewayType;
import com.ccclubs.gateway.common.util.ChannelAttributeUtil;
import com.ccclubs.gateway.jt808.exception.OfflineException;
import io.netty.channel.socket.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.*;

/**
 * @Author: yeanzi
 * @Date: 2018/6/28
 * @Time: 19:11
 * Email:  yeanzhi@ccclubs.com
 * 终端服务
 */
@Service
public class TerminalConnService {
    public static final Logger LOG = LoggerFactory.getLogger(TerminalConnService.class);

    /**
     * redis中的客户端信息
     */
    @Autowired
    private RedisConnService redisConnService;

    /**
     * 事件发送服务
     */
    @Autowired
    private EventService eventService;


    /**
     * 终端第一次注册
     * @param uniqueNo
     * @param newChannel
     * @param gatewayType
     */
    public TerminalConnService register(String uniqueNo, SocketChannel newChannel, GatewayType gatewayType) {
        Objects.requireNonNull(uniqueNo);
        Objects.requireNonNull(newChannel);
        Objects.requireNonNull(gatewayType);

        // 检验连接状态
        if (!newChannel.isActive()) {
            throw new IllegalStateException("创建新客户端缓存时发现：连接通道状态异常");
        }

        // TODO 终端注册成功后，应该发送一段包含 终端ID、手机号、终端IP信息的数据给规则引擎

        boolean existedInReids = redisConnService.isExisted(uniqueNo, gatewayType);
        if (existedInReids) {
            // 已存在：
            boolean existed = ClientCache.existed(uniqueNo, newChannel);
            LOG.error("终端({})注册时发现redis中已存在该客户端信息; 本地缓存信息：对应client存在={}",
                    uniqueNo, existed);
        } else {
            redisConnService.clientRegister(uniqueNo, newChannel, gatewayType);
            LOG.info("client ({}) register success!", uniqueNo);
        }
        return this;
    }

    /**
     * 终端下线
     *          1. 清除本地连接缓存
     *          2. 更新redis在线状态
     *          3. 发送离线事件
     *          4. 发送离线轨迹信息用于统计
     * @param channel
     * @param gatewayType
     */
    public ListenableFuture<SendResult> offline(SocketChannel channel, GatewayType gatewayType) {
        Objects.requireNonNull(channel);
        Objects.requireNonNull(gatewayType);
        ChannelStatusAttr channelStatusAttr = ChannelAttributeUtil.getStatus(channel);

        ChannelLiveStatus liveStatus = channelStatusAttr.getCurrentStatus();
        // 如果已经下线处理过则不重复处理, 防止事件多次在Inactive传递
        if (ChannelLiveStatus.OFFLINE_END.equals(liveStatus)) {
            return null;
        }

        /**
         * 更新channel状态为结束防止重复进入inactive
         */
        channelStatusAttr.setCurrentStatus(ChannelLiveStatus.OFFLINE_END)
                .setChannelLiveStage(ChannelLiveStatus.OFFLINE_END.getCode());

        String uniqueNo = channelStatusAttr.getUniqueNo();
        if (Objects.isNull(uniqueNo)) {
            throw new OfflineException("cannot mapping to a uniqueNo from channelLifeTrace when deal offline");
        }

        // 清理内存缓存
        Optional<ClientCache> clientOpt = ClientCache.getByUniqueNo(uniqueNo);
        if (clientOpt.isPresent()) {
            /**
             * 清除映射
             */
            clientOpt.get().delFromMapping();
        } else {
            LOG.error("cannot find client when deal offline event: uniqueNo={}", uniqueNo);
        }

        /**
         * 任何原因导致的连接断开，如果当前的channel的IP 与 redis 中在线事件中的IP不同，则认为已经上线，不发下线事件，不更新redis中的状态
         */
        boolean needSend2RedisAndUpdateStatu = true;
        ConnOnlineStatusEvent event = redisConnService.getOnlineEvent(uniqueNo, GatewayType.GATEWAY_808);
        // 由于读写超时导致的连接断开，如果当前的channel的IP 与 redis 中在线事件中的IP不同，则认为已经上线，不发下线事件
        if (Objects.nonNull(event) && !channel.localAddress().getHostString().equals(event.getServerIp())) {
            needSend2RedisAndUpdateStatu = false;
        }

        ListenableFuture<SendResult> resultFut = null;
        if (needSend2RedisAndUpdateStatu) {
            // 2. 更新redis在线状态
            redisConnService.offline(uniqueNo, channel, gatewayType);
            // 发送下线事件
            resultFut = eventService.sendOfflineEvent(needSend2RedisAndUpdateStatu,
                    uniqueNo, channel, gatewayType, liveStatus);
            LOG.info("client ({}) offline success!", uniqueNo);
        }

        /**
         * 如果连接活跃，则关闭该连接
         */
        if (channel.isActive()) {
            try {
                channel.close();
            } catch (Exception e) {
                LOG.error("({}) close channel failed when deal offline event, the server will close it forcibly", uniqueNo);
                channel.unsafe().closeForcibly();
            }
        }
        return resultFut;
    }

    /**
     * 终端上线
     *      1. 判断是否已经在Redis中注册，未注册则先执行注册
     *      2. 更新本地缓存
     *      3. 更新redis中在线状态
     *      4. 发送上线事件
     *      5. 发送上线轨迹事件
     * @param uniqueNo
     * @param channel
     * @param gatewayType
     */
    public void online(String uniqueNo, SocketChannel channel, GatewayType gatewayType) {
        // 是否需要发送下线事件
        boolean isNeedSendOnlineEvent = true;
        // 1. 判断是否已经在Redis中注册，未注册则先执行注册
        boolean isRegisted = redisConnService.isExisted(uniqueNo, gatewayType);
        if (!isRegisted) {
            LOG.info("client ({}) info not existed in redis when deal online event, do register begin---", uniqueNo);
            boolean existed = ClientCache.existed(uniqueNo, channel);
            if (existed) {
                LOG.error("client already existed but not register in redis: uniqueNo={}", uniqueNo);
                // 执行下线 TODO 一般不会发生

                ClientCache.getByUniqueNo(uniqueNo).ifPresent(existedClient -> {
                    // 原连接下线
                    ChannelAttributeUtil.getStatus(existedClient.getChannel())
                            .setCurrentStatus(ChannelLiveStatus.OFFLINE_SERVER_CUT);
                    offline(existedClient.getChannel(), GatewayType.GATEWAY_808);
                });
            }
            // 未注册: 重新注册
            register(uniqueNo, channel, gatewayType);
            LOG.info("client ({}) info not existed in redis when deal online event, do register end---", uniqueNo);
        }

        /**
         * 执行上线
         */
        // 已注册
        boolean existed = ClientCache.existed(uniqueNo, channel);
        if (existed) {
            // 如果连接相同，则同一个上线事件不需要再次处理
            if (ClientCache.sameChannel(uniqueNo, channel)) {
                LOG.info("same client send same online event: uniqueNo={}", uniqueNo);
                if (redisConnService.isOnline(uniqueNo, gatewayType)) {
                    isNeedSendOnlineEvent = false;
                } else {
                    LOG.info("found same client but not online in redis, the server will resend the online event: uniqueNo={}", uniqueNo);
                }
            } else {
                // 同一客户端不同连接的上线事件：原连接下线, 新连接上线
                ClientCache.getByUniqueNo(uniqueNo).ifPresent((existedClient) -> {

                    LOG.info("client update to newChannel, old client will offline and new client will online: uniqueNo={}", uniqueNo);
                    // 原连接下线
                    ChannelAttributeUtil.getStatus(existedClient.getChannel())
                            .setCurrentStatus(ChannelLiveStatus.OFFLINE_SERVER_CUT);
                    offline(existedClient.getChannel(), GatewayType.GATEWAY_808);
                    // 新连接上线
                    ClientCache.ofNew(uniqueNo, channel).addToMapping();
                });
            }
        } else {
            // 新连接建立,初始化映射
            ClientCache newClient = ClientCache.ofNew(uniqueNo, channel);
            newClient.addToMapping();
        }

        /**
         * 对于终端上线，如果终端第一次上线也需要发上线事件，但是终端注册不需要，因为终端注册后会发送鉴权（判定为上线）
         */
        if (isNeedSendOnlineEvent) {
            // 3. 更新redis中在线状态
            redisConnService.online(uniqueNo, channel, gatewayType);
            // 4. 发送上线事件
            eventService.sendOnlineEvent(uniqueNo, channel, gatewayType);
            LOG.info("client ({}) online success!", uniqueNo);
        }
    }

    /**
     * 终端注销 (终端注销以后，后面会断开连接，仍会发送离线事件)
     *      1. 判断redis中是否注册了该客户端信息
     *      2. 本地缓存注销
     *      3. 清除redis缓存
     *      4. 发送注销事件
     *      5. 发送注销轨迹事件
     * @param uniqueNo
     * @param gatewayType
     */
    public void logout(String uniqueNo, SocketChannel channel, GatewayType gatewayType) {
        // 1. 判断是否已经在Redis中注册
        boolean isRegisted = redisConnService.isExisted(uniqueNo, gatewayType);
        if (!isRegisted) {
            LOG.error("client info not existed when deal logout event: uniqueNo={}", uniqueNo);
        } else {
            // 3. 清除redis缓存
            redisConnService.logout(uniqueNo, gatewayType);
        }

        /**
         * 下线
         */
        offline(channel, GatewayType.GATEWAY_808);

        LOG.info("client ({}) logout success!", uniqueNo);
    }

    /**
     * 程序退出时，服务端将所有客户端下线
     */
    public void offlineOfAll() {
        Set<String> keysets = ClientCache.getAllKeySet();
        int allClient = keysets.size();
        final List<ListenableFuture<SendResult>> resultFutList = new ArrayList<>();
        keysets.forEach(k->
                ClientCache.getByUniqueNo(k).ifPresent(client -> {
                    SocketChannel channel = client.getChannel();
                    // 更新渠道当前状态为：服务端主动断开
                    ChannelAttributeUtil.getStatus(channel)
                            .setCurrentStatus(ChannelLiveStatus.OFFLINE_SERVER_CUT);
                    try {
                        ListenableFuture<SendResult> resFut = offline(channel, GatewayType.GATEWAY_808);
                        if (Objects.nonNull(resFut)) {
                            resultFutList.add(resFut);
                        }
                    } catch (Exception e) {
                        LOG.error("channel ({}) close failed when server shutdown: {}", k,  e);
                    }
            })
        );
        int unDoneCount = 1;
        while (unDoneCount > 0) {
            unDoneCount = 0;
            for (ListenableFuture fut: resultFutList) {
                if (!fut.isDone()) {
                    ++ unDoneCount;
                }
            }
        }
        LOG.info("({})个终端下线成功", allClient);
    }


}
