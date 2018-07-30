package com.ccclubs.gateway.jt808;

import com.ccclubs.gateway.jt808.service.ClientCache;
import com.ccclubs.gateway.jt808.service.TerminalConnService;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;
import java.util.Objects;

/**
 * @Author: yeanzi
 * @Date: 2018/4/4
 * @Time: 12:24
 * Email:  yeanzhi@ccclubs.com
 */
@Component
public class TcpServerStarter implements SmartLifecycle {
    private static final Logger LOG = LoggerFactory.getLogger(TcpServerStarter.class);

    /**
     * 是否开启缓存检查（debug时用）
     */
    private boolean checkBufferLeaker;

    @Autowired
    @Qualifier("serverBootstrap")
    private ServerBootstrap serverBootstrap;

    @Autowired
    @Qualifier("tcpSocketAddress")
    private InetSocketAddress tcpPort;

    private Channel serverChannel;

    @Autowired
    private TerminalConnService terminalConnService;

    /**
     * 1. 我们主要在该方法中启动任务或者其他异步服务，比如开启MQ接收消息
     * 2. 当上下文被刷新（所有对象已被实例化和初始化之后）时，将调用该方法，默认生命周期处理器将检查每个SmartLifecycle对象的isAutoStartup()方法返回的布尔值。
     *    如果为“true”，则该方法会被调用，而不是等待显式调用自己的start()方法
     */
    @Override
    public void start() {
        ChannelFuture bindFuture = serverBootstrap.bind(tcpPort);

        this.serverChannel = bindFuture.channel();

        bindFuture.addListener((future -> {
            if (future.isCancelled()) {
                LOG.error("808-TCP server cancelled: ", future.cause());
            } else if (!future.isSuccess()) {
                LOG.error("808-TCP bind failed cause：{}", future.cause());
            } else {
                ClientCache.setServerChannel(this.serverChannel);
                LOG.info("808-TCP server start success: port={}", tcpPort);
            }
        }));
        this.serverChannel.closeFuture().addListener((f)-> {
            if (!f.isSuccess()) {
                LOG.error("server channel closing failed, cause: {}", f.cause());
            } else {
                LOG.info("server channel closed success");
            }
        });
    }

    @Override
    public void stop() {
        serverChannel.close().syncUninterruptibly();
        if (Objects.nonNull(serverChannel.parent())) {
            serverChannel.parent().close().syncUninterruptibly();
        }
        try {
            LOG.info("tcp server is closing, all client will offline");
            terminalConnService.offlineOfAll();
        } catch (Exception e) {
            LOG.error("exception occured in offline all client when server shutdown: {}", e);
        }
    }

    /**
     * 根据该方法的返回值决定是否执行start方法。
     * 返回true时start方法会被自动执行，返回false则不会。
     */
    @Override
    public boolean isAutoStartup() {
        return false;
    }

    /**
     *
     * @param callback
     */
    @Override
    public void stop(Runnable callback) {
        this.stop();
        // 如果你让isRunning返回true，需要执行stop这个方法，那么就不要忘记调用callback.run()。
        // 否则在你程序退出时，Spring的DefaultLifecycleProcessor会认为你这个TestSmartLifecycle没有stop完成，程序会一直卡着结束不了，等待一定时间（默认超时时间30秒）后才会自动结束。
        // PS：如果你想修改这个默认超时时间，可以按下面思路做，当然下面代码是springmvc配置文件形式的参考，在SpringBoot中自然不是配置xml来完成，这里只是提供一种思路。
        // <bean id="lifecycleProcessor" class="org.springframework.context.support.DefaultLifecycleProcessor">
        //      <!-- timeout value in milliseconds -->
        //      <property name="timeoutPerShutdownPhase" value="10000"/>
        // </bean>

        callback.run();
    }

    @Override
    public boolean isRunning() {
        /**
         * 返回true时执行stop方法
         * 返回false时执行start方法
         */
        return true;
    }

    /**
     * 设置为max希望在程序销毁前执行该动作
     * @return
     */
    @Override
    public int getPhase() {
        return Integer.MAX_VALUE;
    }

    public InetSocketAddress getTcpPort() {
        return tcpPort;
    }

    public TcpServerStarter setTcpPort(InetSocketAddress tcpPort) {
        this.tcpPort = tcpPort;
        return this;
    }

    public Channel getServerChannel() {
        return serverChannel;
    }

    public TcpServerStarter setServerChannel(Channel serverChannel) {
        this.serverChannel = serverChannel;
        return this;
    }

    public boolean isCheckBufferLeaker() {
        return checkBufferLeaker;
    }

    public TcpServerStarter setCheckBufferLeaker(boolean checkBufferLeaker) {
        this.checkBufferLeaker = checkBufferLeaker;
        return this;
    }
}
