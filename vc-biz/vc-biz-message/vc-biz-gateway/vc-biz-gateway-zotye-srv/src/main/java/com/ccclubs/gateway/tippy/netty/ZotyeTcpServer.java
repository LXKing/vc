package com.ccclubs.gateway.tippy.netty;

import com.ccclubs.gateway.tippy.handler.ZotyeTboxProtocolHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * \* Created with IntelliJ IDEA2017.
 * \* User: Alban
 * \* Date: 2018/1/16
 * \* Time: 15:08
 * \* Description:
 * \
 */
public class ZotyeTcpServer {
    protected static final int BIZTHREADSIZE = 4;
    protected static final int BIZGROUPSIZE = 2;
    public static final int MAX_FRAME_LENGTH = Integer.MAX_VALUE;
    public static final int LENGTH_FIELD_OFFSET = 0;
    public static final int LENGTH_FIELD_LENGTH = 2;
    public static final int LENGTH_ADJUSTMENT = -28;
    public static final int INITIAL_BYTES_TO_STRIP = 0;
    private static final EventLoopGroup bossGroup = new NioEventLoopGroup(BIZGROUPSIZE);
    private static final EventLoopGroup workerGroup = new NioEventLoopGroup(BIZTHREADSIZE);

    public void start(int port) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 100)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch)
                                throws Exception {
                            // Decoders  
                            /***
                             * LengthFieldBasedFrameDecoder
                             * 用于解决粘包分包，根据协议头的长度字段来分包
                             * MAX_FRAME_LENGTH:最大长度
                             * LENGTH_FIELD_OFFSET：协议头部起始地址
                             * LENGTH_FIELD_LENGTH：协议头部偏移量
                             * LENGTH_ADJUSTMENT：头部偏移量 -4 代表包长度包括长度字段
                             * INITIAL_BYTES_TO_STRIP：可设置返回包跳过长度字段
                             */
                            //这里要使用基于偏移可调整长度的截断拆包
                            ch.pipeline().addLast(new ZotyeLengthFieldBasedFrameDecoder(
                                    ZotyeTcpServer.MAX_FRAME_LENGTH,
                                    ZotyeTcpServer.LENGTH_FIELD_OFFSET,
                                    ZotyeTcpServer.LENGTH_FIELD_LENGTH,
                                    ZotyeTcpServer.LENGTH_ADJUSTMENT,
                                    ZotyeTcpServer.INITIAL_BYTES_TO_STRIP));
                            ch.pipeline().addLast("bytesDecoder", new ByteArrayDecoder());
                            // Encoder  
                            ch.pipeline().addLast("bytesEncoder", new ByteArrayEncoder());
//                            ch.pipeline().addLast(new IdleStateHandler());
                            ch.pipeline().addLast(new ZotyeTboxProtocolHandler(ch));
                            //ch.alloc().buffer().writeBytes()
                        }
                    });
            b.bind(port);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Shut down all event loops to terminate all threads.  
//                bossGroup.shutdownGracefully();
//                workerGroup.shutdownGracefully();
        }
    }
}
