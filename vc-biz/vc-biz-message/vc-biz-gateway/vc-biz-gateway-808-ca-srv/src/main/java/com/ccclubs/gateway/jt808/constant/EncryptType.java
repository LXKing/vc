package com.ccclubs.gateway.jt808.constant;

/**
 * @Author: yeanzi
 * @Date: 2018/5/30
 * @Time: 18:00
 * Email:  yeanzhi@ccclubs.com
 * 加密方式
 */
public enum EncryptType {

    /**
     * 不加密
     */
    NO(0X0000),

    /**
     * RSA加密
     */
    RSA(0X02000),

    /**
     * 其他保留
     */
    OTHER(0XF000);

    private int code;

    EncryptType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static EncryptType getByCode(int code) {
        for (EncryptType e :
                EncryptType.values()) {
            if (e.getCode() == code) {
                return e;
            }
        }
        return null;
    }

}