package com.ccclubs.gateway.common.inf;

import io.netty.buffer.ByteBuf;

/**
 * @Author: yeanzi
 * @Date: 2018/4/2
 * @Time: 16:59
 * Email:  yeanzhi@ccclubs.com
 */
public interface MsgSender {

    boolean send(GatewayPackage pac);

    boolean send(ByteBuf buf);
}
