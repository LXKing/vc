package com.ccclubs.gateway.jt808.process.decoder;

import com.ccclubs.gateway.common.constant.HandleStatus;
import com.ccclubs.gateway.common.dto.AbstractChannelInnerMsg;
import com.ccclubs.gateway.common.process.CCClubChannelInboundHandler;
import com.ccclubs.gateway.common.util.DateUtil;
import com.ccclubs.gateway.jt808.constant.CommandStatus;
import com.ccclubs.gateway.jt808.constant.PackageCons;
import com.ccclubs.gateway.jt808.constant.msg.AckResultType;
import com.ccclubs.gateway.jt808.constant.msg.DownPacType;
import com.ccclubs.gateway.jt808.constant.msg.UpPacType;
import com.ccclubs.gateway.jt808.message.pac.Package808;
import com.ccclubs.gateway.jt808.service.CommandCache;
import com.ccclubs.gateway.jt808.util.AckBuilder;
import com.ccclubs.gateway.jt808.util.PacUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Author: yeanzi
 * @Date: 2018/6/4
 * @Time: 10:38
 * Email:  yeanzhi@ccclubs.com
 * 应答处理器
 */
@Component
@ChannelHandler.Sharable
public class AckHandler extends CCClubChannelInboundHandler<Package808> {
    private static final Logger LOG = LoggerFactory.getLogger(AckHandler.class);

    @Override
    protected HandleStatus handlePackage(ChannelHandlerContext ctx, Package808 pac) throws Exception {
        Package808 ackPac = null;

        // 对于终端的应答不需要平台再次应答
        if (UpPacType.getByCode(pac.getHeader().getPacId()).toString().startsWith(PackageCons.UP_PAC_ACK_PRIFIX)) {
            // TODO 对于终端通用应答，应该记录它应答了什么，因为这是一个带操作结果的应答

            /**
             * 用于命令监控
             */
//            dealCmdWatch(pac);
            return HandleStatus.NEXT;
        }

        if (PacUtil.needNormalAck(pac.getHeader().getPacId())) {
            // 平台通用应答

            AckResultType reaultType = pac.getErrorPac()?AckResultType.ERROR:AckResultType.SUCCESS;
            ackPac = normalAck(pac, reaultType);
        } else {
            // 各个消息个性化的应答

            // 补传分包请求返回通用应答
            if (UpPacType.LOGOUT.getCode() == pac.getHeader().getPacId()) {
                // 终端注销返回通用应答
                ackPac = normalAck(pac, AckResultType.SUCCESS);
            } else {
                ackPac = personallyAck(pac);
            }
        }
        if (Objects.nonNull(ackPac)) {
            ctx.pipeline().writeAndFlush(ackPac);
        }

        return HandleStatus.NEXT;
    }

    @Override
    protected HandleStatus handleInnerMsg(AbstractChannelInnerMsg innerMsg) {
        return HandleStatus.NEXT;
    }

    private Package808 normalAck(Package808 pac, AckResultType reaultType) {
        Package808 ackPac = Package808.ofNew();
        // header
        ackPac.getHeader()
                .setPacId(DownPacType.ACK_NORMAL.getCode())
                .setTerMobile(pac.getHeader().getTerMobile())
                .setPacSerialNo(null)
                .setPacContentAttr(null)
                .setPacSealInfo(null);

        // body
        ByteBuf contentBuf = Unpooled.buffer();
        contentBuf
                // 对应的终端流水号
                .writeShort(pac.getHeader().getPacSerialNo())
                // 对应的终端消息的ID
                .writeShort(pac.getHeader().getPacId())
                // 结果
                .writeByte(reaultType.ordinal() & 0xFF);
        ackPac.getBody().setContent(contentBuf);
        return ackPac;
    }

    /**
     * TODO 处理各个消息的个性化应答部分
     * @param pac
     * @return
     */
    private Package808 personallyAck(Package808 pac) {
        Package808 ackPac = null;
        DownPacType downPacType = PacUtil.getAckPacType(pac.getHeader().getPacId());
        switch (downPacType) {
                // 数据上行透传的应答为通用应答
            case SEND_MQTT:
                ackPac = normalAck(pac, pac.getErrorPac()?AckResultType.ERROR:AckResultType.SUCCESS);
                break;
                // 注册应答
            case ACK_REGISTER:
                ackPac = AckBuilder.fromSourcePac(pac);
                // TODO 暂且现在所有终端的鉴权码都是同一个
                ByteBuf contentBuf = Unpooled.buffer();
                contentBuf.writeShort(pac.getHeader().getPacSerialNo())
                        .writeByte(AckResultType.SUCCESS.ordinal() & 0xFF)
                        .writeBytes(PackageCons.GLOBAL_AUTH_CODE.getBytes());
                ackPac.getBody().setContent(contentBuf);
                break;
                // TODO 同步VIN码
                default:
                    break;
        }
        return ackPac;
    }

    /**
     * 根据808消息的序列号，更新命令监控中该命令的808应答内容
     *      由于当前下发指令中808消息序列号固定为0，故该值不可用也不用更新
     * @param pac
     */
    @Deprecated
    private void dealCmdWatch(Package808 pac) {
        if (UpPacType.ACK.getCode() == pac.getHeader().getPacId()) {
            if (CommandCache.isOpen() && CommandCache.isCurrent(pac.getHeader().getTerMobile())) {
                short serialNo = pac.getBody().getContent().getShort(0);
                CommandCache.getBy808SerivalNo(serialNo).ifPresent(cmd -> {
                    if (cmd.getSerialNo808() == serialNo) {
                        cmd.setCommandStatus(CommandStatus.ANSWERD_808)
                                .setAck808Time(DateUtil.getNowStr());
                    }
                });
            }
        }
    }
}
