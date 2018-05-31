package com.ccclubs.gateway.jt808.message.pac;

/**
 * @Author: yeanzi
 * @Date: 2018/5/30
 * @Time: 17:58
 * Email:  yeanzhi@ccclubs.com
 * 消息体属性
 */
public class PacContentAttr {

    /**
     * 消息体长度
     */
    private Integer contentLen;

    /**
     * 加密方式
     *     true:  加密
     *     false: 不加密
     */
    private boolean encrypted;

    /**
     * 是否分包
     *     true:  是分包
     *     false: 不是分包
     */
    private boolean multiPac;

    public Integer getContentLen() {
        return contentLen;
    }

    public PacContentAttr setContentLen(Integer contentLen) {
        this.contentLen = contentLen;
        return this;
    }

    public boolean isEncrypted() {
        return encrypted;
    }

    public PacContentAttr setEncrypted(boolean encrypted) {
        this.encrypted = encrypted;
        return this;
    }

    public boolean isMultiPac() {
        return multiPac;
    }

    public PacContentAttr setMultiPac(boolean multiPac) {
        this.multiPac = multiPac;
        return this;
    }
}
