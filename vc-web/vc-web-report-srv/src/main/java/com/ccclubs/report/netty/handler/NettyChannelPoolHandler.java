package com.ccclubs.report.netty.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ccclubs.report.service.ReportInf;

import io.netty.channel.Channel;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.pool.ChannelPoolHandler;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.codec.bytes.ByteArrayEncoder;

public class NettyChannelPoolHandler implements ChannelPoolHandler {
    private Logger log = LoggerFactory.getLogger(getClass());

    private ReportInf bf;

    public NettyChannelPoolHandler(ReportInf bf) {
        this.bf = bf;
    }

    @Override
    public void channelReleased(Channel ch) throws Exception {
        log.debug("Pool Released. Channel ID: {}", ch);
    }

    @Override
    public void channelAcquired(Channel ch) throws Exception {
        log.debug("Pool Acquired. Channel ID: {}", ch);
    }

    @Override
    public void channelCreated(Channel ch) throws Exception {
        log.debug("Pool Created. Channel ID: {}", ch);
        // ByteBuf delimiter = Unpooled.copiedBuffer("$_".getBytes());
        SocketChannel channel = (SocketChannel) ch;
        channel.config().setKeepAlive(true);
        channel.config().setTcpNoDelay(true);

        ChannelPipeline pipeline = channel.pipeline();
        // pipeline.addLast(new DelimiterBasedFrameDecoder(1024, delimiter));
        // pipeline.addLast(new LineBasedFrameDecoder(NettyConstant.FRAME_MAXLENGTH));
        //pipeline.addLast(new StringDecoder(Charset.forName("UTF-8")));
        //pipeline.addLast(new StringEncoder(Charset.forName("UTF-8")));
        pipeline.addLast(new ByteArrayDecoder());
        pipeline.addLast(new ByteArrayEncoder());
        pipeline.addLast(new NettyChannelHandler(bf));
    }


}
