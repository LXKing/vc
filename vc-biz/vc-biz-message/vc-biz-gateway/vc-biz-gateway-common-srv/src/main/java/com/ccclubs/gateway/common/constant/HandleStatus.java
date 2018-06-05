package com.ccclubs.gateway.common.constant;

/**
 * @Author: yeanzi
 * @Date: 2018/6/1
 * @Time: 16:21
 * Email:  yeanzhi@ccclubs.com
 * 处理器处理状态
 */
public enum HandleStatus {
    /**
     * 消息流向下一个channelHandler
     */
    NEXT(0),

    /**
     * 消息处理终止：
     *      消息将不再向下一个ChannelHandler传递
     */
    END(1),

    RESP(2),

    WAIT(3);

    private int code;

    HandleStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static HandleStatus getByCode(int code) {
        for (HandleStatus e :
                HandleStatus.values()) {
            if (e.getCode() == code) {
                return e;
            }
        }
        return null;
    }

}