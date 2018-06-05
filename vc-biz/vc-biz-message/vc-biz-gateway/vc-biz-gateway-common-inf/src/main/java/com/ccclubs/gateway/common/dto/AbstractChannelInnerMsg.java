package com.ccclubs.gateway.common.dto;

import com.ccclubs.gateway.common.constant.InnerMsgType;

/**
 * @Author: yeanzi
 * @Date: 2018/6/5
 * @Time: 18:04
 * Email:  yeanzhi@ccclubs.com
 * 默认渠道内部流通消息
 */
public class AbstractChannelInnerMsg {

    private InnerMsgType innerMsgType;

    private Object msg;

    public InnerMsgType getInnerMsgType() {
        return innerMsgType;
    }

    public AbstractChannelInnerMsg setInnerMsgType(InnerMsgType innerMsgType) {
        this.innerMsgType = innerMsgType;
        return this;
    }

    public Object getMsg() {
        return msg;
    }

    public AbstractChannelInnerMsg setMsg(Object msg) {
        this.msg = msg;
        return this;
    }
}
