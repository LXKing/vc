package com.ccclubs.gateway.gb.handler.decode;

import com.ccclubs.gateway.gb.message.GBPackage;
import com.ccclubs.gateway.gb.reflect.ClientCache;
import com.ccclubs.gateway.gb.reflect.GBConnection;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Author: yeanzi
 * @Date: 2018/3/25
 * @Time: 21:41
 * Email:  yeanzhi@ccclubs.com
 *      动态添加的 展现单个通道通信数据的handler
 */
@Component
@Scope("prototype")
public class SingleChannelDetailHandler extends ChannelInboundHandlerAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(SingleChannelDetailHandler.class);

    private GBConnection conn;
    public SingleChannelDetailHandler() {

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        GBPackage pac = (GBPackage) msg;
        if (null == conn) {
            SocketChannel channel = (SocketChannel)ctx.channel();
            conn = ClientCache.getByChannelId(channel.id());
        }

        // 每50次请求，报告一次通道数据
        Integer allPacCount = conn.getPackageNum();
        if (allPacCount % 50 == 0) {

            LOG.info(conn.toLogString());
        }

        ctx.fireChannelRead(pac);
    }

}
