package com.ccclubs.gateway.jt808.process.decoder;

import com.ccclubs.gateway.common.bean.track.PacProcessTrack;
import com.ccclubs.gateway.common.process.CCClubChannelInboundHandler;
import com.ccclubs.gateway.common.util.PacValidUtil;
import com.ccclubs.gateway.jt808.constant.PackagePart;
import com.ccclubs.gateway.jt808.message.pac.Package808;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.stereotype.Component;

/**
 * @Author: yeanzi
 * @Date: 2018/5/31
 * @Time: 14:00
 * Email:  yeanzhi@ccclubs.com
 * 消息校验处理器
 */
@Component
@ChannelHandler.Sharable
public class ValidatePacHandler extends CCClubChannelInboundHandler<Package808> {

    @Override
    protected boolean handlePackage(ChannelHandlerContext ctx, Package808 pac, PacProcessTrack pacProcessTrack) throws Exception {

        Integer startIndex = 0;
        Integer validLen = pac.getSourceBuff().readableBytes() -1;
        boolean pacCurrect = PacValidUtil.xor(pac.getSourceBuff(), startIndex, validLen, pac.getValidCode());
        return false;
    }
}
