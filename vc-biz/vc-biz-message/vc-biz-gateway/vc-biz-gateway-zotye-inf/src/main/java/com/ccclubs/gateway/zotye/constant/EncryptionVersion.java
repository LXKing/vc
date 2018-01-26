package com.ccclubs.gateway.zotye.constant;

import java.io.Serializable;

public enum EncryptionVersion implements Serializable {

    //不加密
    NONE(0x0),
    //AES128BIT加密
    AES128BIT(0x1),
    //AES256BIT加密
    AES256BIT(0x2),
    //BASE64加密
    BASE64(0x3);

    private Integer bitValue;

    private EncryptionVersion(Integer bitValue){
        this.bitValue=bitValue;
    }

    public Integer getBitValue() {
        return bitValue;
    }

    public void setBitValue(Integer bitValue) {
        this.bitValue = bitValue;
    }
}
