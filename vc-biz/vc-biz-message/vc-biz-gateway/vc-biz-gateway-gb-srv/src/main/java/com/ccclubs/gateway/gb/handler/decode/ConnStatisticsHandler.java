package com.ccclubs.gateway.gb.handler.decode;

import com.ccclubs.frm.spring.gateway.ExpMessageDTO;
import com.ccclubs.gateway.common.bean.attr.DefaultChannelHealthyAttr;
import com.ccclubs.gateway.common.constant.HandleStatus;
import com.ccclubs.gateway.common.constant.InnerMsgType;
import com.ccclubs.gateway.common.constant.KafkaSendTopicType;
import com.ccclubs.gateway.common.dto.AbstractChannelInnerMsg;
import com.ccclubs.gateway.common.dto.KafkaTask;
import com.ccclubs.gateway.common.process.CCClubChannelInboundHandler;
import com.ccclubs.gateway.common.util.ChannelAttributeUtil;
import com.ccclubs.gateway.gb.constant.CommandType;
import com.ccclubs.gateway.gb.constant.PackProcessExceptionCode;
import com.ccclubs.gateway.gb.message.GBPackage;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Author: yeanzi
 * @Date: 2018/4/27
 * @Time: 9:46
 * Email:  yeanzhi@ccclubs.com
 * 连接数据统计处理器
 *      该类不可与其他渠道共享
 */
@Service
@ChannelHandler.Sharable
public class ConnStatisticsHandler extends CCClubChannelInboundHandler<GBPackage> {
    private static final Logger LOG = LoggerFactory.getLogger(ConnStatisticsHandler.class);

    @Override
    protected HandleStatus handlePackage(ChannelHandlerContext ctx, GBPackage pac) {
        SocketChannel channel = (SocketChannel)ctx.channel();
        if (pac.isErrorPac()) {

            ExpMessageDTO expMessageDTO = ChannelAttributeUtil.getTrace(channel).getExpMessageDTO();
            // 依据不同的校验异常类型，写入不同的错误码
            switch (pac.getPacErrorType()) {
                case PAC_VALID_ERROR:
                    expMessageDTO.setCode(PackProcessExceptionCode.INVALID_FAIL.getCode());
                    break;
                case PAC_LENGTH_ERROR:
                    expMessageDTO
                            .setCode(PackProcessExceptionCode.LACK_LENGTH_FAIL.getCode());
                    break;
                    default:
                        break;
            }

            // 发送至kafka
            fireChannelInnerMsg(ctx, InnerMsgType.TASK_KAFKA, new KafkaTask(
                    KafkaSendTopicType.ERROR,
                    pac.getHeader().getUniqueNo(),
                    expMessageDTO.toJson()));

            countErrorPac(channel);
            // 错误包不进行下发
            ReferenceCountUtil.release(pac.getSourceBuff());
            return HandleStatus.END;
        } else {
            // 因为错误包的数据不准确，所以不在错误包之前初始化连接
            DefaultChannelHealthyAttr channelHealthyAttr = ChannelAttributeUtil.getHealthy(channel);
            // 统计总包数
            channelHealthyAttr.setPackageNum(channelHealthyAttr.getPackageNum() + 1);
            // 实时数据包则需要统计位置包数量
            if (pac.getHeader().getCommandMark().equals(CommandType.REALTIME_DATA)) {
                // 位置包（实时信息包）数
                channelHealthyAttr.setPositionPackageNum(channelHealthyAttr.getPositionPackageNum() + 1);
            }

            // 事件下发
            return HandleStatus.NEXT;
        }
    }

    @Override
    protected HandleStatus handleInnerMsg(AbstractChannelInnerMsg innerMsg) {
        return HandleStatus.NEXT;
    }

    /**
     * 统计异常包数量
     * @param channel
     */
    private void countErrorPac(SocketChannel channel) {
        DefaultChannelHealthyAttr channelHealthyAttr = ChannelAttributeUtil.getHealthy(channel);
        channelHealthyAttr.setErrorPackageNum(channelHealthyAttr.getErrorPackageNum() + 1);
    }
}
