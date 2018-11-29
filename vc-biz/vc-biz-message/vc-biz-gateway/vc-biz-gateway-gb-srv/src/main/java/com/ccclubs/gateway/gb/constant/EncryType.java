package com.ccclubs.gateway.gb.constant;


import com.ccclubs.gateway.gb.inf.ICodedStatus;

import java.util.Objects;

public enum EncryType implements ICodedStatus {

    /**
     * 数据不加密
      */
    ENCRY_EMPTY(0x01),
    /**
     * RSA算法加密
     */
    ENCRY_RSA(0x02),
    /**
     * AES128位算法加密
     */
    ENCRY_AES128(0x03),
    /**
     * 异常
     */
    ENCRY_EXCEPTION(0xFE),
    /**
     * 无效
     */
    ENCRY_INVALID(0xFF);

    /**
     * 其他数值为预留
     */

    private static String EXCEPTED_VALUES;
    private int code;
    EncryType(int code) {
        this.code = code;
    }


    public static EncryType getByCode(int code) {
        for (EncryType e :
                EncryType.values()) {
            if (e.getCode() == code) {
                return e;
            }
        }
        return null;
    }

    @Override
    public int getCode() {
        return code;
    }

    // 预期的期望值，逗号分隔
    public static String expectedVals() {
        if (Objects.isNull(EXCEPTED_VALUES)) {
            StringBuilder valSb = new StringBuilder();
            for (EncryType c :
                    EncryType.values()) {
                valSb.append(c.getCode()).append(",");
            }
            // 删除最后一个逗号
            valSb.deleteCharAt(valSb.length() - 1);
            EXCEPTED_VALUES = valSb.toString();
        }
        return EXCEPTED_VALUES;
    }
}
