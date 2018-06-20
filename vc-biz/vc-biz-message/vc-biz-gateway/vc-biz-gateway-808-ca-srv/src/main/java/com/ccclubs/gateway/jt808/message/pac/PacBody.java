package com.ccclubs.gateway.jt808.message.pac;

import io.netty.buffer.ByteBuf;

/**
 * @Author: yeanzi
 * @Date: 2018/5/30
 * @Time: 16:20
 * Email:  yeanzhi@ccclubs.com
 * 消息体
 */
public class PacBody {
    /**
     * 消息包体内容
     */
    private ByteBuf content;

    public ByteBuf getContent() {
        return content;
    }

    public PacBody setContent(ByteBuf content) {
        this.content = content;
        return this;
    }
}
