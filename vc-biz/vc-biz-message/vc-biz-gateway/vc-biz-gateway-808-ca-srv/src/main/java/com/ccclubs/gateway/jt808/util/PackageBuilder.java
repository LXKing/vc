package com.ccclubs.gateway.jt808.util;

import com.ccclubs.gateway.jt808.constant.msg.AckReaultType;
import com.ccclubs.gateway.jt808.message.pac.Package808;
import io.netty.buffer.ByteBuf;

/**
 * @Author: yeanzi
 * @Date: 2018/5/31
 * @Time: 16:29
 * Email:  yeanzhi@ccclubs.com
 * 808消息构造器
 */
public final class PackageBuilder {

    private final Integer serialNo;
    private final Integer pacId;
    private final String mobile;
    private final AckReaultType reaultType;
    private final ByteBuf bodyBuf;

    public PackageBuilder(builder b) {
        this.pacId = b.pacId;
        this.serialNo = b.serialNo;
        this.mobile = b.mobile;
        this.reaultType = b.reaultType;
        this.bodyBuf = b.bodyBuf;
    }

    public Package808 build() {
        Package808 pac = Package808.ofNew();
        // header
        pac.getHeader()
                .setPacId(this.pacId)
                .setTerMobile(this.mobile)
                .setPacSerialNo(this.serialNo)
                // 包体属性和包封装项在encoder中装入数据
                .setPacContentAttr(null)
                .setPacSealInfo(null);

        // body
        pac.getBody().setContent(this.bodyBuf);

        return pac;
    }

    public static class builder {
        private Integer serialNo;
        private Integer pacId;
        private String mobile;
        private AckReaultType reaultType;
        private ByteBuf bodyBuf;

        public builder(Integer pacId, Integer serialNo, String mobile) {
            this(pacId, serialNo, mobile, null, null);
        }

        public builder(Integer pacId, Integer serialNo, String mobile, AckReaultType reaultType) {
            this(pacId, serialNo, mobile, reaultType, null);
        }

        public builder(Integer pacId, Integer serialNo, String mobile, AckReaultType reaultType, ByteBuf bodyBuf) {
            this.pacId = pacId;
            this.serialNo = serialNo;
            this.mobile = mobile;
            this.reaultType = reaultType;
            this.bodyBuf = bodyBuf;
        }

        public Integer getSerialNo() {
            return serialNo;
        }

        public builder setSerialNo(Integer serialNo) {
            this.serialNo = serialNo;
            return this;
        }

        public Integer getPacId() {
            return pacId;
        }

        public builder setPacId(Integer pacId) {
            this.pacId = pacId;
            return this;
        }

        public String getMobile() {
            return mobile;
        }

        public builder setMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public AckReaultType getReaultType() {
            return reaultType;
        }

        public builder setReaultType(AckReaultType reaultType) {
            this.reaultType = reaultType;
            return this;
        }

        public ByteBuf getBodyBuf() {
            return bodyBuf;
        }

        public builder setBodyBuf(ByteBuf bodyBuf) {
            this.bodyBuf = bodyBuf;
            return this;
        }
    }



}
