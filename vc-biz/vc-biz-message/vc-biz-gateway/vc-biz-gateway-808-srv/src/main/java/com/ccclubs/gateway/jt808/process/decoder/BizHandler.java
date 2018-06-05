package com.ccclubs.gateway.jt808.process.decoder;

import com.ccclubs.gateway.common.bean.track.PacProcessTrack;
import com.ccclubs.gateway.common.constant.HandleStatus;
import com.ccclubs.gateway.common.dto.AbstractChannelInnerMsg;
import com.ccclubs.gateway.common.process.CCClubChannelInboundHandler;
import com.ccclubs.gateway.jt808.message.pac.Package808;
import com.ccclubs.gateway.jt808.util.PackageBuilder;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yeanzi
 * @Date: 2018/5/31
 * @Time: 11:26
 * Email:  yeanzhi@ccclubs.com
 * 808业务操作处理器
 */
public class BizHandler extends CCClubChannelInboundHandler<Package808> {
    public static final Logger LOG = LoggerFactory.getLogger(BizHandler.class);

    private Map<String, String> multiPartPacMap = new HashMap<>();

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);

        LOG.error("出现异常：{}", cause.getMessage());
        cause.printStackTrace();
    }

    @Override
    protected HandleStatus handlePackage(ChannelHandlerContext ctx, Package808 pac, PacProcessTrack pacProcessTrack) throws Exception {

        LOG.info(pac.printLog());

        // 如果是半包消息，则加到对应包后面
        if (pac.getHeader().getPacContentAttr().isMultiPac()) {
            //
            LOG.info("收到分包消息");
        }
        Package808 ackPac = new PackageBuilder(new PackageBuilder.builder(1,100, "18963984473")).build();

        ctx.pipeline().writeAndFlush(ackPac);
        return HandleStatus.NEXT;
    }

    @Override
    protected HandleStatus handleInnerMsg(AbstractChannelInnerMsg innerMsg) {
        return HandleStatus.NEXT;
    }
}
