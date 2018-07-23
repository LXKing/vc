package com.ccclubs.gateway.jt808.constant;

/**
 * @Author: yeanzi
 * @Date: 2018/6/1
 * @Time: 10:44
 * Email:  yeanzhi@ccclubs.com
 * 转义类型
 */
public enum TranslateType {

    /**
     * 转义：
     *  0x7e->0x7d0x02
     */
    HEX_7E((byte) 0x7e, PackageCons.PAC_TRANSLATE_TYPE_HEX_7E),

    /**
     * 转义：
     *  0x7d->0x7d0x01
     */
    HEX_7D((byte) 0x7d, PackageCons.PAC_TRANSLATE_TYPE_HEX_7D);

    /**
     * 目标字节
     */
    private Byte goal;
    /**
     * 要转换的字节数组
     */
    private byte[] escaped;

    TranslateType(Byte goal, byte[] escaped) {
        this.goal = goal;
        this.escaped = escaped;
    }

    public Byte getGoal() {
        return goal;
    }

    public byte[] getEscaped() {
        return escaped;
    }
}
