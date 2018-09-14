package com.ccclubs.gateway.jt808.process.decoder;

import com.ccclubs.gateway.common.bean.attr.ChannelStatusAttr;
import com.ccclubs.gateway.common.config.TcpServerConf;
import com.ccclubs.gateway.common.constant.ChannelAttrKey;
import com.ccclubs.gateway.common.constant.ChannelLiveStatus;
import com.ccclubs.gateway.common.constant.GatewayType;
import com.ccclubs.gateway.common.constant.HandleStatus;
import com.ccclubs.gateway.common.dto.AbstractChannelInnerMsg;
import com.ccclubs.gateway.common.process.CCClubChannelInboundHandler;
import com.ccclubs.gateway.common.util.ChannelAttributeUtil;
import com.ccclubs.gateway.common.util.ChannelUtils;
import com.ccclubs.gateway.common.util.DecodeUtil;
import com.ccclubs.gateway.jt808.constant.PackageCons;
import com.ccclubs.gateway.jt808.constant.msg.UpPacType;
import com.ccclubs.gateway.jt808.message.pac.Package808;
import com.ccclubs.gateway.jt808.service.ClientCache;
import com.ccclubs.gateway.jt808.service.TerminalConnService;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;
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
public class AuthConnectionHandler extends CCClubChannelInboundHandler<Package808> {
    public static final Logger LOG = LoggerFactory.getLogger(AuthConnectionHandler.class);

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
        LOG.info("connection established: ip={}, port={}, channelId={}",
                    channel.remoteAddress().getHostString(),
                    channel.remoteAddress().getPort(),
                    channel.id().asLongText()
                );
        /**
         * 初始化渠道生命周期
         */
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
        SocketChannel channel = (SocketChannel) ctx.channel();

        ChannelStatusAttr channelStatusAttr = ChannelAttributeUtil.getStatus(channel);
        LOG.info("connection closing: ip={}, port={}, uniqueNo={}",
                channel.remoteAddress().getHostString(),
                channel.remoteAddress().getPort(),
                channelStatusAttr.getUniqueNo()
        );
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

        if (!ChannelLiveStatus.OFFLINE_IDLE.equals(channelStatusAttr.getCurrentStatus()) &&
                !ChannelLiveStatus.OFFLINE_SERVER_CUT.equals(channelStatusAttr.getCurrentStatus()) &&
                !ChannelLiveStatus.OFFLINE_END.equals(channelStatusAttr.getCurrentStatus()) ) {
            channelStatusAttr.setCurrentStatus(ChannelLiveStatus.OFFLINE_CLIENT_CUT);
        }

        terminalConnService.offline(channel, GatewayType.GATEWAY_808);
    }

    @Override
    protected HandleStatus handlePackage(ChannelHandlerContext ctx, Package808 pac) throws Exception {
        if (pac.getErrorPac()) {
            // 如果是校验异常，不做认证
            return HandleStatus.NEXT;
        }
        SocketChannel channel = (SocketChannel) ctx.channel();
        UpPacType upPacType = UpPacType.getByCode(pac.getHeader().getPacId());
        String uniqueNo = pac.getHeader().getTerMobile();
        boolean isAuthEvent = false;
        // 处理认证类型消息
        switch(upPacType) {
                // 终端注册
            case REGISTER:
                doRegister(uniqueNo, ctx);
                isAuthEvent = true;
                break;
                // 终端注销
            case LOGOUT:
                doLogout(uniqueNo, ctx);
                isAuthEvent = true;
                break;
                // 终端鉴权
            case AUTH:
                doAuth(pac, ctx);
                isAuthEvent = true;
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
        ChannelStatusAttr channelStatusAttr = ChannelAttributeUtil.getStatus(channel);

        // channel状态是否存在
        if (Objects.nonNull(channelStatusAttr)) {
            // 已认证
            if (ChannelLiveStatus.ONLINE_AUTH.equals(channelStatusAttr.getCurrentStatus())) {
                return HandleStatus.NEXT;
            } else {
                // 未认证：判断是否需要执行下线
                LOG.error("message cannot pass to next handler without auth first: uniqueNo={}", uniqueNo);
                if (channelStatusAttr.getChannelLiveStage() > ChannelLiveStatus.ONLINE_REGISTER.getCode()) {

                    releasePacBuffer(pac.getSourceBuff());
                    // 未鉴权就发送报文： 踢掉
                    channelStatusAttr.setCurrentStatus(ChannelLiveStatus.OFFLINE_SERVER_CUT);
                    channel.pipeline().fireChannelInactive();
                    return HandleStatus.END;
                }
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

    private void doRegister(String uniqueNo, ChannelHandlerContext ctx) {
        SocketChannel newChannel = (SocketChannel) ctx.channel();

        ChannelAttributeUtil.getStatus(newChannel)
                .setCurrentStatus(ChannelLiveStatus.ONLINE_REGISTER)
                .nextStage();
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
        ChannelAttributeUtil.getStatus(channel)
                .setCurrentStatus(ChannelLiveStatus.OFFLINE_LOGOUT);
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
            LOG.error("terminal({})can not find authcode when deal auth event, sourceHex[{}]", uniqueNo, pac.getSourceHexStr());
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
            LOG.error("terminal({})auth failed, sourceHex[{}]", uniqueNo, pac.getSourceHexStr());
        } else {
            ChannelStatusAttr channelStatusAttr = ChannelAttributeUtil.getStatus(channel);
            /**
             * 如果已认证后的重复认证
             *     如果是重复的认证报文：不重复验证
             *     如果是新建的连接发起认证，而旧连接还未断开：再走认证，更新连接
             */
            boolean isReAuth = false;
            if (ChannelLiveStatus.ONLINE_AUTH.equals(channelStatusAttr.getCurrentStatus())) {
                Optional<ClientCache> clientOpt = ClientCache.getByUniqueNo(uniqueNo);
                if (clientOpt.isPresent()) {
                    ClientCache existedClient = clientOpt.get();
                    if (existedClient.getChannel().equals(channel)) {
                        isReAuth = true;
                        if (TcpServerConf.GATEWAY_PRINT_LOG) {
                            LOG.info("terminal ({}) already auth successed", uniqueNo);
                        }
                    }
                }
            }
            if (!isReAuth) {
                channelStatusAttr.setCurrentStatus(ChannelLiveStatus.ONLINE_AUTH)
                        .nextStage();

                // 终端上线
                terminalConnService.online(uniqueNo, channel, GatewayType.GATEWAY_808);
                // 给所有ChannelAttribute赋值vin
                ChannelAttrKey.initUniqueNoForAll(channel, uniqueNo, GatewayType.GATEWAY_808);
                LOG.info("terminal({})auth success", uniqueNo);
            }
        }
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
}
