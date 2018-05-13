package com.ccclubs.report.constant;

public enum LoginType {
    LOGIN_IN(1, "登入", ""), LOGIN_IN_SUCCESS(2, "登入成功", ""), LOGIN_IN_FAIL(3, "登入失败", ""), 
    LOGIN_OUT(-1, "登出", ""), LOGIN_OUT_SUCCESS(-2, "登出失败", ""), LOGIN_OUT_FAIL(-3, "登出失败", ""),
    DEFAULT(0, "默认", "Default");
    private int code;
    private String msg;
    private String memo;

    LoginType(int code, String msg, String memo) {
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

    public static LoginType byCode(int code) {

        for (LoginType api : LoginType.values()) {
            if (api.code() == code) {
                return api;
            }
        }

        return DEFAULT;
    }
}
