package com.ccclubs.gateway.jt808.process.decoder;

import com.ccclubs.gateway.common.bean.track.PacProcessTrack;
import com.ccclubs.gateway.common.constant.HandleStatus;
import com.ccclubs.gateway.common.process.CCClubChannelInboundHandler;
import com.ccclubs.gateway.jt808.constant.PackageCons;
import com.ccclubs.gateway.jt808.constant.msg.AckReaultType;
import com.ccclubs.gateway.jt808.constant.msg.DownPacType;
import com.ccclubs.gateway.jt808.constant.msg.UpPacType;
import com.ccclubs.gateway.jt808.message.pac.Package808;
import com.ccclubs.gateway.jt808.util.AckBuilder;
import com.ccclubs.gateway.jt808.util.PacUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * @Author: yeanzi
 * @Date: 2018/6/4
 * @Time: 10:38
 * Email:  yeanzhi@ccclubs.com
 * 应答处理器
 */
public class AckHandler extends CCClubChannelInboundHandler<Package808> {
    private static final Logger LOG = LoggerFactory.getLogger(AckHandler.class);

    @Override
    protected HandleStatus handlePackage(ChannelHandlerContext ctx, Package808 pac, PacProcessTrack pacProcessTrack) throws Exception {
        Package808 ackPac = null;

        // 对于终端的应答不需要平台再次应答
        if (UpPacType.getByCode(pac.getHeader().getPacId()).toString().startsWith(PackageCons.UP_PAC_ACK_PRIFIX)) {
            // TODO 对于终端通用应答，应该记录它应答了什么，因为这是一个带操作结果的应答
            return HandleStatus.NEXT;
        }

        if (PacUtil.needNormalAck(pac.getHeader().getPacId())) {
            // 平台通用应答

            AckReaultType reaultType = pac.getErrorPac()?AckReaultType.ERROR:AckReaultType.SUCCESS;
            ackPac = normalAck(pac.getHeader().getPacSerialNo(), pac.getHeader().getTerMobile(), reaultType);
        } else {
            // 各个消息个性化的应答

            ackPac = personallyAck(pac);
        }
        if (Objects.nonNull(ackPac)) {
            ctx.pipeline().writeAndFlush(ackPac);
        }

        // 校验异常的报文不需要向下传递
        if (pac.getErrorPac()) {
            return HandleStatus.END;
        } else {
            return HandleStatus.NEXT;
        }
    }

    @Override
    protected HandleStatus handleInnerMsg(AbstractChannelInnerMsg innerMsg) {
        return HandleStatus.NEXT;
    }

    private Package808 normalAck(Integer serialNo, String mobile, AckReaultType reaultType) {

        Package808 pac = Package808.ofNew();
        // header
        pac.getHeader()
                .setPacId(DownPacType.ACK_NORMAL.getCode())
                .setTerMobile(mobile)
                .setPacSerialNo(serialNo)
                .setPacContentAttr(null)
                .setPacSealInfo(null);

        // body
        pac.getBody().setContent(null);

        return pac;
    }

    private Package808 personallyAck(Package808 pac) {
        Package808 ackPac = null;
        DownPacType downPacType = PacUtil.getAckPacType(pac.getHeader().getPacId());
        switch (downPacType) {
                // 注册应答
            case ACK_REGISTER:
                ackPac = AckBuilder.fromSourcePac(pac);
                String authCode = pac.getHeader().getTerMobile();
                ackPac.getBody().setContent(Unpooled.wrappedBuffer((authCode).getBytes()));
//                ackPac = downPacType.getFunction().apply(authCode);
                break;
                default:
                    break;
        }
        return ackPac;
    }
}
