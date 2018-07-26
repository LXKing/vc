package com.ccclubs.gateway.common.vo.response;

/**
 * @Author: yeanzi
 * @Date: 2018/6/2
 * @Time: 16:48
 * Email:  yeanzhi@ccclubs.com
 */
public class Error extends R {

    public static enum Statu {

        /**SIM不存在**/
        SIM_NOT_EXIST(400100, "SIM不存在"),

        /**SIM为空**/
        SIM_EMPTY(400101, "SIM为空"),

        PARAM_INCORECT_FORMAT(400105, "参数格式不正确"),

        STATUS_INCORRECT(400106, "状态异常"),

        /**
         * 没有足够的权限进行操作
         */
        AUTH_FAILED(400110, "权限不足");

        private int code;
        private String msg;
        Statu(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public R build() {
            return new Error()
                    .setSuccess(false)
                    .setCode(this.code)
                    .setMessage(this.msg)
                    .setData(null);
        }
    }
}
