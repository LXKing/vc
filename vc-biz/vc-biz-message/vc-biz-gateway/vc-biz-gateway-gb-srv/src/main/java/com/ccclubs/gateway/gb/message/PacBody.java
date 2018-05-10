package com.ccclubs.gateway.gb.message;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;

/**
 * @Author: yeanzi
 * @Date: 2018/3/26
 * @Time: 15:16
 * Email:  yeanzhi@ccclubs.com
 */
public class PacBody {
    private ByteBuf content;

    public ByteBuf getContent() {
        return content;
    }

    public PacBody setContent(ByteBuf content) {
        this.content = content.duplicate();
        return this;
    }

    @Override
    public String toString() {
        return ByteBufUtil.hexDump(content);
    }
}
