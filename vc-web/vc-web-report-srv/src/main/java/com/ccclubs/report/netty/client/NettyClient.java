package com.ccclubs.report.netty.client;

import static com.ccclubs.report.constant.LoginType.LOGIN_IN;
import static com.ccclubs.report.constant.LoginType.LOGIN_IN_FAIL;
import static com.ccclubs.report.constant.LoginType.LOGIN_IN_SUCCESS;
import static com.ccclubs.report.constant.LoginType.LOGIN_OUT;
import static com.ccclubs.report.constant.LoginType.LOGIN_OUT_FAIL;
import static com.ccclubs.report.constant.LoginType.LOGIN_OUT_SUCCESS;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ccclubs.report.constant.ReportServer;
import com.ccclubs.report.netty.handler.NettyChannelPoolHandler;
import com.ccclubs.report.service.ReportInf;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.pool.AbstractChannelPoolMap;
import io.netty.channel.pool.ChannelPoolMap;
import io.netty.channel.pool.FixedChannelPool;
import io.netty.channel.pool.SimpleChannelPool;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;

public class NettyClient {
    private Logger log = LoggerFactory.getLogger(getClass());
    private ChannelPoolMap<InetSocketAddress, SimpleChannelPool> poolMap;
    private Map<InetSocketAddress, ReportInf> bizMap;

    public NettyClient(List<ReportInf> list, Bootstrap bootstrap) {
        if (null != list) {
            bizMap = new HashMap<>();
            ReportServer rs = null;
            for (ReportInf bf : list) {
                rs = bf.getReportServer();
                bizMap.put(rs.getInetSocketAddress(), bf);
            }
        }
        if (null == poolMap) {
            poolMap = new AbstractChannelPoolMap<InetSocketAddress, SimpleChannelPool>() {

                @Override
                protected SimpleChannelPool newPool(InetSocketAddress key) {
                    ReportInf biz = bizMap.get(key);
                    int max = null == biz.getReportServer().getMaxConnections() ? 4
                            : biz.getReportServer().getMaxConnections();
                    return new FixedChannelPool(bootstrap.remoteAddress(key), new NettyChannelPoolHandler(biz), max);
                }

            };
        }

    }

    public void send(String hostName, int port, Object msg) {
        InetSocketAddress inetSocketAddress = new InetSocketAddress(hostName, port);
        ReportInf bInf = bizMap.get(inetSocketAddress);
        if (null == bInf) {
            log.error("Not Found This Bussiness");
            return;
        }

        SimpleChannelPool pool = poolMap.get(inetSocketAddress);
        Future<Channel> f = pool.acquire();
        f.addListener((FutureListener<Channel>) f1 -> {
            if (f1.isSuccess()) {
                log.debug("send success:{}", msg);
                Channel ch = f1.getNow();
                ch.writeAndFlush(msg);
                pool.release(ch); // Release back to pool
            } else {
                log.error("send fail");
                bInf.sendError(msg);
            }
        });
    }

    public void sendLoginIn(ReportInf bInf) {
        if (!LOGIN_IN_SUCCESS.equals(bInf.loginType())) {
            bInf.setLoginType(LOGIN_IN);
            this.send(bInf, bInf.loginInMessage());
        }

    }

    public void sendLoginOut(ReportInf bInf) {
        if (!LOGIN_OUT_SUCCESS.equals(bInf.loginType())) {
            bInf.setLoginType(LOGIN_OUT);
            this.send(bInf, bInf.loginOutMessage());
        }
    }

    public void send(ReportInf bInf, Object msg) {
        ReportServer rs = bInf.getReportServer();
        SimpleChannelPool pool = poolMap.get(rs.getInetSocketAddress());
        Future<Channel> f = pool.acquire();
        f.addListener((FutureListener<Channel>) f1 -> {
            if (f1.isSuccess()) {
                Channel ch = f1.getNow();
                ch.writeAndFlush(msg);
                pool.release(ch); // Release back to pool
                bInf.sendSuccess(msg);
            } else {
                switch (bInf.loginType()) {
                case LOGIN_IN:
                    bInf.setLoginType(LOGIN_IN_FAIL);
                    bInf.loginInFail(f1.cause());
                    break;
                case LOGIN_OUT:
                    bInf.setLoginType(LOGIN_OUT_FAIL);
                    bInf.loginOutFail(f1.cause());
                    break;
                default:
                    bInf.sendError(msg);
                    break;
                }
            }
        });
    }
}
