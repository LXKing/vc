package com.ccclubs.gateway.jt808.service;

import com.ccclubs.frm.spring.gateway.ConnOnlineStatusEvent;
import com.ccclubs.gateway.common.bean.event.ConnLiveEvent;
import com.ccclubs.gateway.common.constant.ChannelLiveStatus;
import com.ccclubs.gateway.common.constant.GatewayType;
import com.ccclubs.gateway.common.constant.KafkaSendTopicType;
import com.ccclubs.gateway.common.dto.KafkaTask;
import com.ccclubs.gateway.common.service.KafkaService;
import com.ccclubs.gateway.common.util.ChannelAttrbuteUtil;
import com.ccclubs.gateway.common.util.ClientEventFactory;
import com.ccclubs.gateway.jt808.message.pac.Package808;
import io.netty.channel.socket.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SettableListenableFuture;

/**
 * @Author: yeanzi
 * @Date: 2018/7/10
 * @Time: 15:16
 * Email:  yeanzhi@ccclubs.com
 * 事件发送服务
 */
@Service
public class EventService {
    public static final Logger LOG = LoggerFactory.getLogger(EventService.class);

    /**
     * kafka发送服务
     */
    @Autowired
    private KafkaService kafkaService;

    /**
     * redis中的客户端信息
     */
    @Autowired
    private RedisConnService redisConnService;

    public ListenableFuture<SendResult> sendOnlineEvent(String uniqueNo, SocketChannel channel, GatewayType gatewayType) {
        // 发送上线事件
        ConnOnlineStatusEvent connOnlineStatusEvent = ClientEventFactory.ofOnline(uniqueNo, channel, gatewayType);
        KafkaTask task = new KafkaTask(KafkaSendTopicType.CONN, uniqueNo, connOnlineStatusEvent.toJson());
        ListenableFuture<SendResult> resultFut = kafkaService.send(task);

        // 向redis发送上线事件
        redisConnService.sendOnlineEventForOld(connOnlineStatusEvent);

        // 发送上线轨迹事件
        ConnLiveEvent onlineEvent = new ConnLiveEvent()
                .uniqueNo(uniqueNo)
                .channel(channel)
                .online(true)
                .gatewayType(gatewayType)
                .build();
        redisConnService.addTcpStatusTraceEvent(uniqueNo, gatewayType, onlineEvent);
        return resultFut;
    }

    /**
     * 实时刷新online在线
     * @param uniqueNo
     * @param channel
     * @param gatewayType
     */
    public void realtimeReflushOnline(String uniqueNo, SocketChannel channel, GatewayType gatewayType, Package808 pac) {
        ConnOnlineStatusEvent connOnlineStatusEvent = ClientEventFactory.ofOnline(uniqueNo, channel, gatewayType);
        redisConnService.keepOnlineWhenEventCome(connOnlineStatusEvent, pac);
    }

    public ListenableFuture<SendResult> sendOfflineEvent(boolean needUpdateRedis, String uniqueNo, SocketChannel channel, GatewayType gatewayType, ChannelLiveStatus liveStatus) {
        // fixme 如何避免空指针?
        ListenableFuture<SendResult> resultFut = null;
        if (needUpdateRedis) {
            // 下发下线事件
            ConnOnlineStatusEvent connOnlineStatusEvent = ClientEventFactory.ofOffline(uniqueNo, channel, gatewayType);
            // 增加下线类型（后面添加掉线原因）
            int offlineType = 0;
            switch (liveStatus) {
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

            KafkaTask task = new KafkaTask(KafkaSendTopicType.CONN, uniqueNo, connOnlineStatusEvent.toJson());
            resultFut = kafkaService.send(task);

            // 3. 向redis发送下线事件
            redisConnService.sendOfflineEventForOld(connOnlineStatusEvent);
        }

        // 4. 发送离线轨迹信息用于统计
        String exceptionHex = ChannelAttrbuteUtil.getPacTracker(channel).getSourceHex();
        ConnLiveEvent offlineEvent = new ConnLiveEvent()
                .uniqueNo(uniqueNo)
                .channel(channel)
                .online(false)
                .gatewayType(gatewayType);
        if (ChannelLiveStatus.OFFLINE_SERVER_CUT.equals(liveStatus)) {
            // 只有服务端异常时才发送异常报文
            offlineEvent.exceptionHex(exceptionHex);
        }
        offlineEvent.build();

        redisConnService.addTcpStatusTraceEvent(uniqueNo, gatewayType, offlineEvent);
        return resultFut;
    }

}
