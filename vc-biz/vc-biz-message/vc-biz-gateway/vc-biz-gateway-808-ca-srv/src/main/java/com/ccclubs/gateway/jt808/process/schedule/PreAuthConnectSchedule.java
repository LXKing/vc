package com.ccclubs.gateway.jt808.process.schedule;

import com.ccclubs.gateway.common.bean.track.ChannelLifeCycleTrack;
import com.ccclubs.gateway.common.constant.ChannelLiveStatus;
import com.ccclubs.gateway.common.util.ChannelAttrbuteUtil;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;

import java.util.Objects;

/**
 * @Author: yeanzi
 * @Date: 2018/7/23
 * @Time: 11:32
 * Email:  yeanzhi@ccclubs.com
 * 连接鉴权之前的定时任务
 */
public class PreAuthConnectSchedule implements TimerTask {

    /**
     * 渠道连接
     */
    private SocketChannel channel;

    public PreAuthConnectSchedule(SocketChannel channel) {
        this.channel = channel;
    }

    @Override
    public void run(Timeout timeout) throws Exception {
        System.out.println("注册的校验时间到了");
        ChannelLifeCycleTrack lifeCycleTrack = ChannelAttrbuteUtil.getLifeTrack(channel);
        if (Objects.isNull(lifeCycleTrack.getUniqueNo()) &&
                ChannelLiveStatus.ONLINE_CONNECT.equals(lifeCycleTrack.getLiveStatus())) {
            channel.pipeline().fireChannelInactive();
        }
    }
}
