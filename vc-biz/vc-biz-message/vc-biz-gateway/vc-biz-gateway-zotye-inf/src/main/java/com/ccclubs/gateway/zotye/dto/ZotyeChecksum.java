package com.ccclubs.gateway.zotye.dto;

import java.io.Serializable;

/**
 * \* Created with IntelliJ IDEA2017.
 * \* User: Alban
 * \* Date: 2018/1/18
 * \* Time: 15:27
 * \* Description:
 * \
 */
public class ZotyeChecksum implements Serializable {
    private static final long serialVersionUID = -2125571912294129975L;

    /**
     * 长度：1 Byte
     * 名称：校验位
     * 描述：由message header，dispatch date，service date  3个部分异或（^）而得到。
     * */
    private Byte checksum;

    public Byte getChecksum() {
        return checksum;
    }

    public void setChecksum(Byte checksum) {
        this.checksum = checksum;
    }
}
