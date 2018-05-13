package com.ccclubs.report.netty.handler;


import java.util.concurrent.TimeUnit;

import com.ccclubs.report.constant.NettyConstant;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.timeout.IdleStateHandler;


public class NettyPoolHandlerInitializer extends ChannelInitializer<SocketChannel> {
    private static final int READ_IDEL_TIME_OUT = 4; // 读超时
    private static final int WRITE_IDEL_TIME_OUT = 5;// 写超时
    private static final int ALL_IDEL_TIME_OUT = 7; // 所有超时

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new LineBasedFrameDecoder(NettyConstant.FRAME_MAXLENGTH));
        //pipeline.addLast(new StringDecoder(Charset.forName("UTF-8")));
        pipeline.addLast(new ByteArrayDecoder());
        pipeline.addLast(new IdleStateHandler(READ_IDEL_TIME_OUT, WRITE_IDEL_TIME_OUT,
                ALL_IDEL_TIME_OUT, TimeUnit.SECONDS));
        //pipeline.addLast(new NettyPoolServerHandler());
    }

}
