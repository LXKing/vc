package com.ccclubs.gateway.gb.constant;

public enum PackagePart{
    /**
     * 唯一标识码
     */
    UNIQUENO(0, 4, 17, "唯一标识码"),

    /**
     * 起始符
     */
    START_SYMBOL(1, 0, 2, "起始符"),

    /**
     * 命令标识
     */
    COMMAND_MARK(2, 2, 1, "命令标识"),

    /**
     * 应答标志
     */
    ACK_MARK(3, 3, 1, "应答标志"),

    /**
     * 数据单元加密方式
     */
    ENCRYPT_TYPE(4, 21, 1, "数据单元加密方式"),

    /**
     * 数据单元长度
     */
    CONTENT_LENGTH(5, 22, 2, "数据单元长度"),

    /**
     * 数据单元
     */
    CONTENT(6, 24, -1, "数据单元"),

    /**
     * 校验码
     */
    VALIDE_CODE(7, -1, 1, "校验码");

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
