package com.ccclubs.gateway.common.vo.response;

/**
 * @Author: yeanzi
 * @Date: 2018/6/2
 * @Time: 16:48
 * Email:  yeanzhi@ccclubs.com
 */
public class OK extends R {

    public static enum Statu {
        SUCCESS(600000, "请求完成"),
        SUCCESS_WITH_DATA(600100 ,"请求完成并返回数据");

        private int code;
        private String msg;
        Statu(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public R build() {
            return new OK()
                    .setSuccess(true)
                    .setCode(this.code)
                    .setMessage(this.msg)
                    .setData(null);
        }
    }

}
