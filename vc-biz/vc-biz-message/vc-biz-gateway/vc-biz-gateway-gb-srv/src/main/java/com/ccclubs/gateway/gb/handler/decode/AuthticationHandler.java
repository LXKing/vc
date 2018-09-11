package com.ccclubs.gateway.gb.handler.decode;

import com.ccclubs.gateway.common.bean.attr.ChannelStatusAttr;
import com.ccclubs.gateway.common.constant.ChannelAttrKey;
import com.ccclubs.gateway.common.constant.ChannelLiveStatus;
import com.ccclubs.gateway.common.constant.GatewayType;
import com.ccclubs.gateway.common.constant.HandleStatus;
import com.ccclubs.gateway.common.dto.AbstractChannelInnerMsg;
import com.ccclubs.gateway.common.process.CCClubChannelInboundHandler;
import com.ccclubs.gateway.common.util.ChannelAttributeUtil;
import com.ccclubs.gateway.common.util.ChannelUtils;
import com.ccclubs.gateway.gb.constant.CommandType;
import com.ccclubs.gateway.gb.message.GBPackage;
import com.ccclubs.gateway.gb.service.TerminalConnService;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @Author: yeanzi
 * @Date: 2018/5/31
 * @Time: 14:47
 * Email:  yeanzhi@ccclubs.com
 * 连接身份认证处理器
 */
@Component
@ChannelHandler.Sharable
public class AuthticationHandler extends CCClubChannelInboundHandler<GBPackage> {
    public static final Logger LOG = LoggerFactory.getLogger(AuthticationHandler.class);

    /**
     * 连接建立后未发送鉴权的超时时间(秒)
     * （注意）延迟的时间越短越好，越短则回收channel越快
     */
    private static final int TIMEOUT_SECONDS_PRE_AUTH = 60;

    @Autowired
    private TerminalConnService terminalConnService;


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        final SocketChannel channel = (SocketChannel) ctx.channel();
        LOG.info("new channel active: ip={}, port={}",
                channel.remoteAddress().getHostString(),
                channel.remoteAddress().getPort());

        ChannelAttributeUtil.getStatus(channel)
                .setCurrentStatus(ChannelLiveStatus.ONLINE_CONNECT)
                .nextStage();

        /**
         * 注册定时任务：如果1分钟秒内没有发送鉴权(或者鉴权失败)，断开该连接
         */
        channel.eventLoop().schedule(() -> {
            ChannelStatusAttr channelStatusAttr = ChannelAttributeUtil.getStatus(channel);
            if (Objects.isNull(channelStatusAttr.getUniqueNo()) &&
                    ChannelLiveStatus.ONLINE_CONNECT.equals(channelStatusAttr.getCurrentStatus())) {
                channel.pipeline().fireChannelInactive();
            }
        }, TIMEOUT_SECONDS_PRE_AUTH, TimeUnit.SECONDS);
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        final SocketChannel channel = (SocketChannel) ctx.channel();

        ChannelStatusAttr channelStatusAttr = ChannelAttributeUtil.getStatus(channel);
        if (!ChannelLiveStatus.OFFLINE_IDLE.equals(channelStatusAttr.getCurrentStatus()) &&
                !ChannelLiveStatus.OFFLINE_SERVER_CUT.equals(channelStatusAttr.getCurrentStatus()) &&
                !ChannelLiveStatus.OFFLINE_END.equals(channelStatusAttr.getCurrentStatus()) ) {
            channelStatusAttr.setCurrentStatus(ChannelLiveStatus.OFFLINE_CLIENT_CUT)
                    .setChannelLiveStage(ChannelLiveStatus.OFFLINE_CLIENT_CUT.getCode());
        }

        /**
         * 注入销毁时间
         */
        channelStatusAttr.setCloseTime(LocalDateTime.now());
        /**
         *连接被探测
         */
        if (isPingPongEvent(channelStatusAttr)) {
            LOG.error("tcp server received ping-pong event: client={}", ChannelUtils.getUniqueNoOrHost(null, channel));
            ChannelAttributeUtil.getStatus(channel).setCurrentStatus(ChannelLiveStatus.OFFLINE_END)
                    .setChannelLiveStage(ChannelLiveStatus.OFFLINE_END.getCode());
            channel.close();
            return;
        }
        terminalConnService.offline(channel, GatewayType.GB);
    }

    @Override
    protected HandleStatus handlePackage(ChannelHandlerContext ctx, GBPackage pac) throws Exception {
        SocketChannel channel = (SocketChannel) ctx.channel();
        CommandType upPacType = pac.getHeader().getCommandMark();
        String uniqueNo = pac.getHeader().getUniqueNo();
        boolean isAuthEvent = false;
        // 处理认证类型消息
        switch(upPacType) {
                // 终端注册
            case VEHICLE_LOGIN:
                dealVehicleLogin(channel, uniqueNo);
                isAuthEvent = true;
                break;
                // 终端注销
            case VEHICLE_LOGOUT:
                dealVehicleLogout(channel, uniqueNo);
                break;
            default:
                break;
        }

        if (LOG.isDebugEnabled()) {
            LOG.debug("auth complete");
        }

        /**
         * 终端发送 注册、注销、鉴权 等认证事件则：正常通过
         */
        if (isAuthEvent) {
            return HandleStatus.NEXT;
        }

        /**
         * 其他报文，并且为已认证状态：通过
         */
        ChannelStatusAttr liveStatus =  ChannelAttributeUtil.getStatus(channel);

        // channel状态是否存在
        if (Objects.nonNull(liveStatus)) {
            // 已认证
            if (ChannelLiveStatus.ONLINE_REGISTER.equals(liveStatus.getCurrentStatus())) {
                return HandleStatus.NEXT;
            } else {
                // 未登入
                LOG.error("message cannot pass to next handler without login first: uniqueNo={}", uniqueNo);
            }
        } else {
            LOG.error("channel live status is empty when deal auth: uniqueNo={}", uniqueNo);
        }
        /**
         * 未鉴权，释放buffer，关闭channel
         */
        releasePacBuffer(pac.getSourceBuff());
        channel.unsafe().closeForcibly();
        return HandleStatus.END;
    }

    @Override
    protected HandleStatus handleInnerMsg(AbstractChannelInnerMsg innerMsg) {
        return HandleStatus.NEXT;
    }

    /**
     * 判定渠道状态是否为pingpong事件状态
     * @param channelStatusAttr
     * @return
     */
    private boolean isPingPongEvent(ChannelStatusAttr channelStatusAttr) {
        /**
         * 如果连接建立后，无报文交互，在idle前断开
         */
        if (ChannelLiveStatus.ONLINE_CONNECT.equals(channelStatusAttr.getCurrentStatus())) {
            return true;
        }
        /**
         * 如果连接建立后，无报文交互，在idle后断开
         */
        String uniqueNo = channelStatusAttr.getUniqueNo();
        if (Objects.isNull(uniqueNo) && ChannelLiveStatus.OFFLINE_IDLE.equals(channelStatusAttr.getCurrentStatus())) {
            return true;
        }
        return false;
    }

    private void dealVehicleLogin(SocketChannel channel, String uniqueNo) {
        ChannelStatusAttr channelStatusAttr = ChannelAttributeUtil.getStatus(channel);
        if (ChannelLiveStatus.ONLINE_CONNECT.equals(channelStatusAttr.getCurrentStatus()) &&
                ChannelLiveStatus.ONLINE_CONNECT.getCode() == channelStatusAttr.getChannelLiveStage()) {
            /**
             * 标记当前状态为已注册状态
             */
            ChannelAttributeUtil.getStatus(channel)
                    .setCurrentStatus(ChannelLiveStatus.ONLINE_REGISTER)
                    .nextStage();
            // 车辆首次连入系统, 创建客户端缓存
            terminalConnService.online(uniqueNo, channel, GatewayType.GB);
            // 给所有ChannelAttribute赋值vin
            ChannelAttrKey.initUniqueNoForAll(channel, uniqueNo, GatewayType.GB);
            LOG.info("车机[{}]登入成功", uniqueNo);
        } else {
            LOG.info("车机[{}]重复登入", uniqueNo);
        }
    }

    private void dealVehicleLogout(SocketChannel channel, String uniqueNo) {
        /**
         * 标记当前状态为已登出状态
         */
        ChannelAttributeUtil.getStatus(channel)
                .setCurrentStatus(ChannelLiveStatus.OFFLINE_LOGOUT)
                .setChannelLiveStage(ChannelLiveStatus.OFFLINE_LOGOUT.getCode())
                .setCloseTime(LocalDateTime.now());
        // 不存在重复登出的问题
        terminalConnService.logout(uniqueNo, channel, GatewayType.GB);
        LOG.info("车机[{}]登出成功", uniqueNo);
    }
}
