package com.ccclubs.gateway.jt808.process.decoder;

import com.ccclubs.gateway.common.bean.track.ChannelLifeCycleTrack;
import com.ccclubs.gateway.common.bean.track.PacProcessTrack;
import com.ccclubs.gateway.common.constant.ChannelLiveStatus;
import com.ccclubs.gateway.common.constant.GatewayType;
import com.ccclubs.gateway.common.constant.HandleStatus;
import com.ccclubs.gateway.common.dto.AbstractChannelInnerMsg;
import com.ccclubs.gateway.common.process.CCClubChannelInboundHandler;
import com.ccclubs.gateway.common.util.ChannelAttrbuteUtil;
import com.ccclubs.gateway.common.util.DecodeUtil;
import com.ccclubs.gateway.jt808.constant.PackageCons;
import com.ccclubs.gateway.jt808.constant.msg.UpPacType;
import com.ccclubs.gateway.jt808.message.pac.Package808;
import com.ccclubs.gateway.jt808.service.TerminalConnService;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Author: yeanzi
 * @Date: 2018/5/31
 * @Time: 14:47
 * Email:  yeanzhi@ccclubs.com
 * 连接身份认证处理器
 */
@Component
@ChannelHandler.Sharable
public class AuthConnectionHandler extends CCClubChannelInboundHandler<Package808> {
    public static final Logger LOG = LoggerFactory.getLogger(AuthConnectionHandler.class);

    @Autowired
    private TerminalConnService terminalConnService;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        SocketChannel channel = (SocketChannel) ctx.channel();
        LOG.info("终端建立连接: ip={}, port={}, channelId={}",
                    channel.remoteAddress().getHostString(),
                    channel.remoteAddress().getPort(),
                    channel.id().asLongText()
                );

        ChannelAttrbuteUtil.setChannelLiveStatus(channel, ChannelLiveStatus.ONLINE_CONNECT);
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        SocketChannel channel = (SocketChannel) ctx.channel();

        ChannelLifeCycleTrack channelLifeCycleTrack = ChannelAttrbuteUtil.getLifeTrack(channel);
        if (Objects.nonNull(channelLifeCycleTrack) &&
                !ChannelLiveStatus.OFFLINE_IDLE.equals(channelLifeCycleTrack.getLiveStatus()) &&
                !ChannelLiveStatus.OFFLINE_SERVER_CUT.equals(channelLifeCycleTrack.getLiveStatus()) &&
                !ChannelLiveStatus.OFFLINE_END.equals(channelLifeCycleTrack.getLiveStatus()) ) {
            ChannelAttrbuteUtil.setChannelLiveStatus(channel, ChannelLiveStatus.OFFLINE_CLIENT_CUT);
        }
        terminalConnService.offline(channel, GatewayType.GATEWAY_808);
    }

    @Override
    protected HandleStatus handlePackage(ChannelHandlerContext ctx, Package808 pac, PacProcessTrack pacProcessTrack) throws Exception {
        UpPacType upPacType = UpPacType.getByCode(pac.getHeader().getPacId());
        String uniqueNo = pac.getHeader().getTerMobile();
        // 处理认证类型消息
        switch(upPacType) {
                // 终端注册
            case REGISTER:
                doRegister(uniqueNo, ctx);
                break;
                // 终端注销
            case LOGOUT:
                doLogout(uniqueNo, ctx);
                break;
                // 终端鉴权
            case AUTH:
                doAuth(pac, ctx);
                break;
            default:
                break;
        }

        if (LOG.isDebugEnabled()) {
            LOG.debug("auth complete");
        }
        return HandleStatus.NEXT;
    }

    @Override
    protected HandleStatus handleInnerMsg(AbstractChannelInnerMsg innerMsg) {
        return HandleStatus.NEXT;
    }

    private void doRegister(String uniqueNo, ChannelHandlerContext ctx) {
        SocketChannel newChannel = (SocketChannel) ctx.channel();

        ChannelAttrbuteUtil.setChannelLiveStatus(newChannel, ChannelLiveStatus.ONLINE_REGISTER);
        terminalConnService.register(uniqueNo, newChannel, GatewayType.GATEWAY_808);
        // TODO 终端注册成功后，应该发送一段包含 终端ID、手机号、终端IP信息的数据给规则引擎
    }

    /**
     * 终端注销
     *      注销时：
     *          删除终端在内存中的所有统计数据和终端连接
     * @param uniqueNo
     * @param ctx
     */
    private void doLogout(String uniqueNo, ChannelHandlerContext ctx) {
        SocketChannel channel = (SocketChannel) ctx.channel();
        terminalConnService.logout(uniqueNo, channel, GatewayType.GATEWAY_808);
    }

    /**
     * 鉴权处理
     *      鉴权成功：应答鉴权成功
     *      鉴权失败：应答鉴权失败
     * @param pac
     */
    private void doAuth(Package808 pac, ChannelHandlerContext ctx) {
        SocketChannel channel = (SocketChannel) ctx.channel();
        String uniqueNo = pac.getHeader().getTerMobile();
        boolean authSuccess = true;
        if (Objects.isNull(pac.getBody().getContent()) || 0 == pac.getBody().getContent().readableBytes()) {
            // 无鉴权码
            LOG.error("终端({})鉴权时发现无鉴权码, 原始报文[{}]", uniqueNo, pac.getSourceHexStr());
            authSuccess = false;
        } else {
            String authCode = DecodeUtil.byte2Str(pac.getBody().getContent(), pac.getBody().getContent().readableBytes());
            // TODO 目前鉴权码全局唯一定义的一个常量
            if (!PackageCons.GLOBAL_AUTH_CODE.equals(authCode)) {
                authSuccess = false;
            }
        }
        // 鉴权失败: 断开连接
        if (!authSuccess) {
            pac.setErrorPac(true);
            LOG.error("重连的终端({})鉴权失败, 原始报文[{}]", uniqueNo, pac.getSourceHexStr());
        } else {
            ChannelAttrbuteUtil.setChannelLiveStatus(channel, ChannelLiveStatus.ONLINE_AUTH);
            // 终端上线
            terminalConnService.online(uniqueNo, channel, GatewayType.GATEWAY_808);
            LOG.info("重连的终端({})鉴权成功", uniqueNo);
        }
    }
}
