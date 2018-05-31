package com.ccclubs.gateway.jt808.constant;

public enum PackagePart {
    /**
     * 终端手机号
     */
    TER_MOBILE(0, 4, 6, "终端手机号"),

    /**
     * 消息ID
     */
    PAC_ID(1, 0, 2, "消息ID"),

    /**
     * 消息体属性
     */
    PAC_ATTR(2, 2, 2, "消息体属性"),


    /**
     * 消息流水号
     */
    PAC_SERIAL_NO(3, 10, 2, "消息流水号"),

    /**
     * 消息包封顶项
     *     如果消息属性中相关标识位确定消息分包处理，则该项有值，否则无值
     */
    PAC_BOTTOM_MARK(4, 12, 1, "消息包封顶项");

    // 编码
    private int code;
    // 字节段开始索引
    private Integer startIndex;

    // 字节段总字节数
    private Integer len;

    // 描述
    private String des;

    PackagePart(int code, int startIndex, int len, String des) {
        this.code = code;
        this.startIndex = startIndex;
        this.len = len;
        this.des = des;
    }

    public static PackagePart getByCode(int code) {
        for (PackagePart e :
                PackagePart.values()) {
            if (e.getCode() == code) {
                return e;
            }
        }
        return null;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public Integer getLen() {
        return len;
    }

    public String getDes() {
        return des;
    }

    public int getCode() {
        return code;
    }
}
