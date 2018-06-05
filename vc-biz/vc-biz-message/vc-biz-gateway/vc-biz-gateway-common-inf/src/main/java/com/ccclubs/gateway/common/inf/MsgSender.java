package com.ccclubs.gateway.common.inf;

/**
 * @Author: yeanzi
 * @Date: 2018/4/2
 * @Time: 16:59
 * Email:  yeanzhi@ccclubs.com
 */
public interface MsgSender {

    boolean send(GatewayPackage pac);
}
