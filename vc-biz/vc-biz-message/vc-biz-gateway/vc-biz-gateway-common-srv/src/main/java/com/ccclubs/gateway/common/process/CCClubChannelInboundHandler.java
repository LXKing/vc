package com.ccclubs.gateway.common.process;

import com.ccclubs.gateway.common.bean.track.PacProcessTrack;
import com.ccclubs.gateway.common.constant.HandleStatus;
import com.ccclubs.gateway.common.constant.InnerMsgType;
import com.ccclubs.gateway.common.constant.KafkaSendTopicType;
import com.ccclubs.gateway.common.dto.AbstractChannelInnerMsg;
import com.ccclubs.gateway.common.dto.KafkaTask;
import com.ccclubs.gateway.common.util.ChannelPacTrackUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Author: yeanzi
 * @Date: 2018/4/27
 * @Time: 11:50
 * Email:  yeanzhi@ccclubs.com
 * 入站处理器基类
 *      一些入站公共处理可以在此处实现
 *          1. 处理器处理用时统计
 */
public abstract class CCClubChannelInboundHandler<T> extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object pac) throws Exception {

//        @SuppressWarnings("unchecked")
//        T imsg = (T) pac;
//        PacProcessTrack pacProcessTrack = ChannelPacTrackUtil.getPacTracker(ctx.channel()).next();
//        // 统计处理器处理用时
//        long startTime = System.nanoTime();
//        // 真正处理消息的方法
//        HandleStatus handleStatus = handlePackage(ctx, imsg, pacProcessTrack);
//
//        long endTime = System.nanoTime();
//        pacProcessTrack.getCurrentHandlerTracker().setUsedTime(endTime - startTime);
//
//        switch (handleStatus) {
//            // 传递到下一个处理器
//            case NEXT:
//                ctx.fireChannelRead(imsg);
//                break;
//            case END:
//                break;
//            case RESP:
//                break;
//                default:
//                    break;
//        }


        HandleStatus handleStatus = null;
        // 真正处理消息的方法
        if (pac instanceof AbstractChannelInnerMsg) {
            AbstractChannelInnerMsg innerMsg = (AbstractChannelInnerMsg) pac;
            handleStatus = handleInnerMsg(innerMsg);
        } else {
            PacProcessTrack pacProcessTrack = ChannelPacTrackUtil.getPacTracker(ctx.channel()).next();
            // 统计处理器处理用时
            long startTime = System.nanoTime();

            @SuppressWarnings("unchecked")
            T imsg = (T) pac;
            handleStatus = handlePackage(ctx, imsg, pacProcessTrack);

            long endTime = System.nanoTime();
            pacProcessTrack.getCurrentHandlerTracker().setUsedTime(endTime - startTime);
        }
        switch (handleStatus) {
            // 传递到下一个处理器
            case NEXT:
                ctx.fireChannelRead(pac);
                break;
            case END:
                break;
            case RESP:
                break;
            default:
                break;
        }

    }

    protected abstract HandleStatus handlePackage(ChannelHandlerContext ctx, T pac, PacProcessTrack pacProcessTrack) throws Exception;

    protected abstract HandleStatus handleInnerMsg(AbstractChannelInnerMsg innerMsg);

    protected void fireChannelInnerMsg(ChannelHandlerContext ctx, InnerMsgType innerMsgType, Object msg) {
        ctx.fireChannelRead(new AbstractChannelInnerMsg().setInnerMsgType(innerMsgType).setMsg(msg));
    }

}
