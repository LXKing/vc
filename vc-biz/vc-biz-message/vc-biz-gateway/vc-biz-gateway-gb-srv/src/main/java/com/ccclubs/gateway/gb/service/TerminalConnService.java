package com.ccclubs.gateway.gb.service;

import com.ccclubs.frm.spring.gateway.ConnOnlineStatusEvent;
import com.ccclubs.gateway.common.bean.attr.ChannelStatusAttr;
import com.ccclubs.gateway.common.conn.ClientCache;
import com.ccclubs.gateway.common.constant.ChannelLiveStatus;
import com.ccclubs.gateway.common.constant.GatewayType;
import com.ccclubs.gateway.common.constant.KafkaSendTopicType;
import com.ccclubs.gateway.common.dto.KafkaTask;
import com.ccclubs.gateway.common.exception.ClientMappingException;
import com.ccclubs.gateway.common.service.KafkaService;
import com.ccclubs.gateway.common.util.ChannelAttributeUtil;
import com.ccclubs.gateway.common.util.ClientEventFactory;
import io.netty.channel.socket.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

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

    @Autowired
    private KafkaService kafkaService;

    /**
     * 终端下线
     *          1. 清除本地连接缓存
     *          2. 更新redis在线状态
     *          3. 发送离线事件
     *          4. 发送离线轨迹信息用于统计
     * @param channel
     * @param gatewayType
     */
    public void offline(SocketChannel channel, GatewayType gatewayType) {
        Objects.requireNonNull(channel);
        Objects.requireNonNull(gatewayType);


        ChannelStatusAttr channelStatusAttr = ChannelAttributeUtil.getStatus(channel);
        // 保存当前渠道状态
        ChannelLiveStatus currentLiveStatus = channelStatusAttr.getCurrentStatus();
        // 如果已经下线处理过则不重复处理, 防止事件多次在Inactive传递
        if (ChannelLiveStatus.OFFLINE_END.equals(channelStatusAttr.getCurrentStatus())) {
            return;
        }

        /**
         * 更新channel状态为结束防止重复进入inactive
         */
        channelStatusAttr.setCurrentStatus(ChannelLiveStatus.OFFLINE_END)
                .setChannelLiveStage(ChannelLiveStatus.OFFLINE_END.getCode());
        String uniqueNo = channelStatusAttr.getUniqueNo();
        if (Objects.isNull(uniqueNo)) {
            throw new ClientMappingException("cannot mapping to a uniqueNo from channelStatusAttr when deal offline");
        }

        // 发送下线事件
        ConnOnlineStatusEvent connOnlineStatusEvent = ClientEventFactory.ofOffline(uniqueNo, channel, gatewayType);
        // 增加下线类型（后面添加掉线原因）
        int offlineType = 0;
        switch (currentLiveStatus) {
            case OFFLINE_IDLE:
                offlineType = 2;
                break;
            case OFFLINE_SERVER_CUT:
                offlineType = 1;
                break;
            case OFFLINE_CLIENT_CUT:
                offlineType = 3;
                break;
            default:
                break;
        }
        connOnlineStatusEvent.setOfflineType(offlineType);
        kafkaService.send(new KafkaTask(KafkaSendTopicType.CONN, uniqueNo, connOnlineStatusEvent.toJson()));

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
        LOG.info("client ({}) offline success!", uniqueNo);
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
        /**
         * 执行上线
         */
        // 已注册
        boolean existed = ClientCache.existed(uniqueNo, channel);
        if (existed) {
            // 同一客户端不同连接的上线事件：原连接下线, 新连接上线
            ClientCache.getByUniqueNo(uniqueNo).ifPresent((existedClient) -> {

                LOG.info("client update to newChannel, old client will offline and new client will online: uniqueNo={}", uniqueNo);
                // 原连接下线
                ChannelAttributeUtil.getStatus(existedClient.getChannel())
                        .setCurrentStatus(ChannelLiveStatus.OFFLINE_SERVER_CUT);
                offline(existedClient.getChannel(), gatewayType);
                // 新连接上线
                ClientCache.ofNew(uniqueNo, channel).addToMapping();
            });
        } else {
            // 新连接建立,初始化映射
            ClientCache newClient = ClientCache.ofNew(uniqueNo, channel);
            newClient.addToMapping();
        }
        ConnOnlineStatusEvent connOnlineStatusEvent = ClientEventFactory.ofOnline(uniqueNo, channel, gatewayType);
        // 发送至kafka
        kafkaService.send(new KafkaTask(KafkaSendTopicType.CONN, uniqueNo, connOnlineStatusEvent.toJson()));

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
        // 1. 判断客户端缓存是否存在该连接
        boolean existed = ClientCache.existed(uniqueNo, channel);
        if (!existed) {
            LOG.error("client info not existed when deal logout event: uniqueNo={}", uniqueNo);
        } else {
            /**
             * 下线
             */
            offline(channel, GatewayType.GB);
            LOG.info("client ({}) logout success!", uniqueNo);
        }
    }

    /**
     * 程序退出时，服务端将所有客户端下线
     */
    public void offlineOfAll() {
        Set<String> keysets = ClientCache.getAllKeySet();
        int allClient = keysets.size();
        keysets.forEach(k->
                ClientCache.getByUniqueNo(k).ifPresent(client -> {
                    SocketChannel channel = client.getChannel();
                    ChannelAttributeUtil.getStatus(channel).setCurrentStatus(ChannelLiveStatus.OFFLINE_SERVER_CUT);
                    try {
                        offline(channel, GatewayType.GB);
                    } catch (Exception e) {
                        LOG.error("channel ({}) close failed when server shutdown: {}", k,  e);
                    }
            })
        );
        LOG.info("({})个终端下线成功", allClient);
    }


}
