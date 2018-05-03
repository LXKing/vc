package com.ccclubs.gateway.gb.inf;

import com.ccclubs.gateway.gb.message.GBPackage;

/**
 * @Author: yeanzi
 * @Date: 2018/4/2
 * @Time: 16:59
 * Email:  yeanzhi@ccclubs.com
 */
public interface MsgSender {

    boolean send(GBPackage pac);
}
