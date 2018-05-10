package com.ccclubs.report.constant;

/**
 * 业务类型
 * 配合ReportProps类使用
 * @author ccclubs
 *
 */
public enum ReportType {
    TIAN_JIN(1, "tianjin", "天津地标"),
    XIANG_YANG(2, "xiangyang", "襄阳地标"),
    DEFAULT(-1, "Default", "默认");
    private int code;
    /**
     * 配置文件“上报服务器名称”
     */
    private String msg;
    private String memo;

    ReportType(int code, String msg, String memo) {
        this.code = code;
        this.msg = msg;
        this.memo = memo;
    }

    public int code() {
        return code;
    }

    public String msg() {
        return msg;
    }

    public String memo() {
        return memo;
    }

    public static ReportType apiByCode(int code) {

        for (ReportType api : ReportType.values()) {
            if (api.code() == code) {
                return api;
            }
        }

        return DEFAULT;
    }
}
