package com.ccclubs.gateway.jt808.process.decoder;

import com.ccclubs.gateway.common.constant.HandleStatus;
import com.ccclubs.gateway.common.constant.PacErrorType;
import com.ccclubs.gateway.common.dto.AbstractChannelInnerMsg;
import com.ccclubs.gateway.common.process.CCClubChannelInboundHandler;
import com.ccclubs.gateway.common.util.PacValidUtil;
import com.ccclubs.gateway.jt808.message.pac.Package808;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    public static final Logger LOG = LoggerFactory.getLogger(ValidatePacHandler.class);

    @Override
    protected HandleStatus handlePackage(ChannelHandlerContext ctx, Package808 pac) throws Exception {

        Integer startIndex = 0;
        Integer validLen = pac.getSourceBuff().readableBytes() -1;
        boolean pacCurrect = PacValidUtil.xor(pac.getSourceBuff(), startIndex, validLen, pac.getValidCode());

        pac.setErrorPac(!pacCurrect);
        if (pac.getErrorPac()) {
            pac.setPacErrorType(PacErrorType.PAC_VALID_ERROR);
            LOG.error("校验异常, 原始报文[{}]", pac.getSourceHexStr());
        }

        if (LOG.isDebugEnabled()) {
            LOG.debug("validate result: {}", pacCurrect);
        }
        return HandleStatus.NEXT;
    }

    @Override
    protected HandleStatus handleInnerMsg(AbstractChannelInnerMsg innerMsg) {
        return HandleStatus.NEXT;
    }
}
