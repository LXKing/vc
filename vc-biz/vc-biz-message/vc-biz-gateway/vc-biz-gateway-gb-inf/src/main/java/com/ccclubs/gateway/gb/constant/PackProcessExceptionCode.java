package com.ccclubs.gateway.gb.constant;

/**
 * @Author: yeanzi
 * @Date: 2018/5/3
 * @Time: 19:36
 * Email:  yeanzhi@ccclubs.com
 * 消息处理异常码
 */
public enum PackProcessExceptionCode {
    /**
     * 消息处理成功
     */
    PROCESS_SUCCESS(1000),

    /*校验处理过程中出现异常*/
    PROCESS_VALIDATE_EXCEPTION(1001),
    /*渠道数据统计过程中出现异常*/
    PROCESS_CONN_STATISTIC_EXCEPTION(1002),
    /*消息业务处理过程中出现异常*/
    PROCESS_MSG_DELIVER_EXCEPTION(1003),

    /*消息帧太长*/
//    process_toolong_frame_exception(1004),

    /*连接断开异常*/
    PROCESS_CONN_DISCONN_EXCEPTION(1005),
    /*其他异常*/
    PROCESS_OTHER_EXCEPTION(1006),

    /*校验失败*/
    INVALID_FAIL(1007),

    /*消息解码异常*/
    MESSAGE_DECODE_ERROR(1099);

    private Integer code;

    PackProcessExceptionCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
