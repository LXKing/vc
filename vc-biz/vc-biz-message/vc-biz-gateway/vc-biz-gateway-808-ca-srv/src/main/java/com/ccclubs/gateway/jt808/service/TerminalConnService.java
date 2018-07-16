package com.ccclubs.gateway.jt808.service;

import com.ccclubs.gateway.common.connection.ChannelMappingCollection;
import com.ccclubs.gateway.common.connection.ClientSocketCollection;
import com.ccclubs.gateway.common.constant.ChannelLiveStatus;
import com.ccclubs.gateway.common.constant.GatewayType;
import com.ccclubs.gateway.common.util.ChannelAttrbuteUtil;
import com.ccclubs.gateway.jt808.exception.OfflineException;
import io.netty.channel.socket.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

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
     * 本地缓存的channId->uniqueNo映射信息
     */
    @Resource
    private ChannelMappingCollection channelMappingCollection;

    /**
     * 本地缓存的
     */
    @Resource
    private ClientSocketCollection clientSocketCollection;

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
        if (ClientSocketCollection.channelInActive(newChannel)) {
            throw new IllegalStateException("创建新客户端缓存时发现：连接通道状态异常");
        }

        // TODO 终端注册成功后，应该发送一段包含 终端ID、手机号、终端IP信息的数据给规则引擎

        boolean existedInReids = redisConnService.isExisted(uniqueNo, gatewayType);
        if (existedInReids) {
            // 已存在：
            boolean socketExisted = clientSocketCollection.existed(uniqueNo);
            boolean channelIdMappingExisted = channelMappingCollection.existed(newChannel.id().asLongText());
            LOG.error("终端({})注册时发现redis中已存在该客户端信息; 本地缓存信息：对应socket存在={}，对应channelIdMapping存在={}",
                    uniqueNo, socketExisted, channelIdMappingExisted);
        } else {
            // 不存在：新建一个连接

            // 1. 本地缓存socket
//            clientSocketCollection.add(uniqueNo, newChannel);
            // 2. 本地缓存channelId -> uniqueNo的映射
//            channelMappingCollection.add(uniqueNo, newChannel.id());
            // 3. redis缓存客户端信息
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
        ChannelLiveStatus liveStatus = ChannelAttrbuteUtil.getLifeTrack(channel).getLiveStatus();

        // 如果已经下线处理过则不重复处理, 防止事件多次在Inactive传递
        if (ChannelLiveStatus.OFFLINE_END.equals(liveStatus)) {
            return null;
        } else {
            ChannelAttrbuteUtil.getLifeTrack(channel).setLiveStatus(ChannelLiveStatus.OFFLINE_END);
        }
        Optional<String> uniqueNoOpt = channelMappingCollection.getUniqueNoByChannelIdLongText(channel.id().asLongText());
        String uniqueNo = null;
        if (uniqueNoOpt.isPresent()) {
            uniqueNo = uniqueNoOpt.get();
        } else {
            LOG.error("this channelId ({}) can not mapping to uniquNo when offline!", channel.id().asLongText());
            uniqueNo = ChannelAttrbuteUtil.getPacTracker(channel).getUniqueNo();
        }
        if (Objects.isNull(uniqueNo)) {
            throw new OfflineException("cannot mapping to a uniqueNo when deal offline");
        }
        // 1. 清除本地连接缓存
        clientSocketCollection.offline(uniqueNo, channel);
        channelMappingCollection.offline(uniqueNo, channel.id().asLongText());

        /**
         * 由于读写超时导致的连接断开，如果当前的channel的IP 与 redis 中在线事件中的IP不同，则认为已经上线，不发下线事件，不更新redis中的状态
         */
        boolean needSend2RedisAndUpdateStatu = true;
        if (ChannelLiveStatus.OFFLINE_IDLE.equals(liveStatus)) {
            com.ccclubs.frm.spring.gateway.ConnOnlineStatusEvent event = redisConnService.getOnlineEvent(uniqueNo, GatewayType.GATEWAY_808);
            // 由于读写超时导致的连接断开，如果当前的channel的IP 与 redis 中在线事件中的IP不同，则认为已经上线，不发下线事件
            if (Objects.nonNull(event) && !channel.localAddress().getHostString().equals(event.getServerIp())) {
                needSend2RedisAndUpdateStatu = false;
            }
        }

        if (needSend2RedisAndUpdateStatu) {
            // 2. 更新redis在线状态
            redisConnService.offline(uniqueNo, channel, gatewayType);
        }
        // 发送下线事件
        ListenableFuture<SendResult> resultFut = eventService.sendOfflineEvent(needSend2RedisAndUpdateStatu,
                uniqueNo, channel, gatewayType, liveStatus);

        LOG.info("client ({}) offline success!", uniqueNo);
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
            LOG.info("client ({}) info not existed when deal online event, do register begin---", uniqueNo);
            boolean socketExisted = clientSocketCollection.existed(uniqueNo);
            boolean channelIdMappingExisted = channelMappingCollection.existed(channel.id().asLongText());
            if (channelIdMappingExisted) {
                LOG.error("channelMapping already existed but not register in redis: uniqueNo={}", uniqueNo);
                // 执行下线 TODO 一般不会发生
                channelMappingCollection.offline(uniqueNo, channel.id().asLongText());
            }
            if (socketExisted) {
                LOG.error("socket already existed but not register in redis: uniqueNo={}", uniqueNo);
                SocketChannel existedChannel = clientSocketCollection.getByUniqueNo(uniqueNo).get();
                // old socket 执行下线
                clientSocketCollection.offline(uniqueNo, existedChannel);
            }
            // 未注册: 重新注册
            register(uniqueNo, channel, gatewayType);
            LOG.info("client ({}) info not existed when deal online event, do register end---", uniqueNo);
        }

        /**
         * 执行上线
         */
        // 已注册
        if (redisConnService.isOnline(uniqueNo, gatewayType)) {
            // 已经在线（redis在线）
            boolean socketExisted = clientSocketCollection.existed(uniqueNo);
            boolean channelIdMappingExisted = channelMappingCollection.existed(channel.id().asLongText());
            if (channelIdMappingExisted) {
                LOG.error("channelMapping already existed in local when deal online event : uniqueNo={}", uniqueNo);
                String channelIdLongText = channel.id().asLongText();
                String existedUniqueNo = channelMappingCollection.getUniqueNoByChannelIdLongText(channelIdLongText).get();
                if (!uniqueNo.equals(existedUniqueNo)) {
                    // 不可能发生事件
                    LOG.error("!!!channelMapping already existed and not same in local when deal online event : uniqueNo={}", uniqueNo);
                }
            } else {
                // 修正本地在线缓存
                channelMappingCollection.online(uniqueNo, channel.id());
            }
            if (socketExisted) {
                LOG.error("socketchannel already existed in local when deal online event : uniqueNo={}", uniqueNo);
                boolean isSameSocket = clientSocketCollection.sameChannel(uniqueNo, channel);
                if (isSameSocket) {
                    // socket 相同：不发送上线事件
                    isNeedSendOnlineEvent = false;
                } else {
                    LOG.error("socketchannel already existed and not the same socket in local when deal online event, we will update to the new channel : uniqueNo={}", uniqueNo);
                    // socket 不同：更新socket
                    clientSocketCollection.updateAndCloseOld(uniqueNo, channel);
                }
            } else {
                // 修正本地在线缓存
                clientSocketCollection.online(uniqueNo, channel);
            }
        } else {
            /**
             * 2. 更新本地缓存
             *      这里先处理 channelIdMapping映射
             */
            channelMappingCollection.online(uniqueNo, channel.id());
            clientSocketCollection.online(uniqueNo, channel);
            // 3. 更新redis中在线状态
            redisConnService.online(uniqueNo, channel, gatewayType);
        }

        /**
         * 对于终端上线，如果终端第一次上线也需要发上线事件，但是终端注册不需要，因为终端注册后会发送鉴权（判定为上线）
         */
        if (isNeedSendOnlineEvent) {
            // 4. 发送上线事件
            eventService.sendOnlineEvent(uniqueNo, channel, gatewayType);
        }

        LOG.info("client ({}) online success!", uniqueNo);
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

        // 2. 本地缓存注销
        channelMappingCollection.logout(uniqueNo, channel.id().asLongText());
        clientSocketCollection.logout(uniqueNo, channel);

        // 4. 发送注销事件 TODO

        LOG.info("client ({}) logout success!", uniqueNo);
    }

    /**
     * 程序退出时，服务端将所有客户端下线
     */
    public void offlineOfAll() {
        Set<String> keysets = clientSocketCollection.getAllKeySet();
        int allClient = keysets.size();
        final List<ListenableFuture<SendResult>> resultFutList = new ArrayList<>();
        keysets.stream().forEach(k->
            clientSocketCollection.getByUniqueNo(k).ifPresent(channel -> {
                ChannelAttrbuteUtil.getLifeTrack(channel).setLiveStatus(ChannelLiveStatus.OFFLINE_SERVER_CUT);
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
