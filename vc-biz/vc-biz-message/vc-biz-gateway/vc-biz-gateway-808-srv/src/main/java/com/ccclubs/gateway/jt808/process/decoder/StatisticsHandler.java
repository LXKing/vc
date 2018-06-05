package com.ccclubs.gateway.jt808.process.decoder;

import com.ccclubs.frm.spring.gateway.ExpMessageDTO;
import com.ccclubs.gateway.common.bean.track.PacProcessTrack;
import com.ccclubs.gateway.common.connection.ClientConnCollection;
import com.ccclubs.gateway.common.constant.HandleStatus;
import com.ccclubs.gateway.common.constant.InnerMsgType;
import com.ccclubs.gateway.common.constant.KafkaSendTopicType;
import com.ccclubs.gateway.common.constant.PackProcessExceptionCode;
import com.ccclubs.gateway.common.dto.AbstractChannelInnerMsg;
import com.ccclubs.gateway.common.dto.KafkaTask;
import com.ccclubs.gateway.common.process.CCClubChannelInboundHandler;
import com.ccclubs.gateway.jt808.constant.msg.UpPacType;
import com.ccclubs.gateway.jt808.message.pac.Package808;
import com.ccclubs.gateway.jt808.process.conn.JTClientConn;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * @Author: yeanzi
 * @Date: 2018/5/31
 * @Time: 18:35
 * Email:  yeanzhi@ccclubs.com
 * 数据统计处理器
 */
public class StatisticsHandler extends CCClubChannelInboundHandler<Package808> {
    public static final Logger LOG = LoggerFactory.getLogger(StatisticsHandler.class);

    @Override
    protected HandleStatus handlePackage(ChannelHandlerContext ctx, Package808 pac, PacProcessTrack pacProcessTrack) throws Exception {

        JTClientConn conn = (JTClientConn) ClientConnCollection.getByUniqueNo(pac.getHeader().getTerMobile());
        if (Objects.nonNull(conn)) {
            conn.increPackageNum();
            // 统计错误报文
            if (pac.getErrorPac()) {
                conn.increErrorPacketNum();
                releaseErrorPac(pac.getSourceBuff());

                // 发送一个kafkaTask给SendoutHandelr
                ExpMessageDTO expMessageDTO = pacProcessTrack.getExpMessageDTO();
                expMessageDTO.setMsgTime(System.currentTimeMillis());
                // 依据不同的校验异常类型，写入不同的错误码
                switch (pac.getPacErrorType()) {
                    case PAC_VALID_ERROR:
                        expMessageDTO.setCode(PackProcessExceptionCode.INVALID_FAIL.getCode());
                        break;
                    default:
                        break;
                }
                KafkaTask task = new KafkaTask(KafkaSendTopicType.ERROR,
                        pacProcessTrack.getUniqueNo(),
                        expMessageDTO.toJson());
                ctx.fireChannelRead(new com.ccclubs.gateway.common.dto.AbstractChannelInnerMsg().setInnerMsgType(InnerMsgType.TASK_KAFKA).setMsg(task));
                return HandleStatus.END;
            }
            // 统计位置报文
            if (UpPacType.POSITION_REPORT.getCode() == pac.getHeader().getPacId()) {
                conn.increPositionPackageNum();
            }
        } else {
            LOG.error("统计处理器统计报文时发现终端({})的连接不存在", pac.getHeader().getTerMobile());
        }
        return HandleStatus.NEXT;
    }

    @Override
    protected HandleStatus handleInnerMsg(AbstractChannelInnerMsg innerMsg) {
        return HandleStatus.NEXT;
    }

    /**
     * 销毁错误报文缓存，终止消息传递
     * @param erroPacBuf
     */
    private void releaseErrorPac(ByteBuf erroPacBuf) {

        ReferenceCountUtil.release(erroPacBuf);
    }

}
