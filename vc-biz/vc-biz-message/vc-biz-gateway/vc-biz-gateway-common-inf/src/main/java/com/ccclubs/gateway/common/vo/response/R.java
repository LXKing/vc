package com.ccclubs.gateway.common.vo.response;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: yeanzi
 * @Date: 18-6-9
 * @Time: 下午10:35
 * Email:  yeanzhi@ccclubs.com
 */
public abstract class R {

    /**
     * 接口调用结果
     */
    private Boolean success;

    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回信息
     *   错误时为异常信息
     */
    private String message;

    /**
     * 返回的数据
     */
    private Map<String, Object> data;

    /**
     * 提供添加返回数据的方法
     * @param key
     * @param value
     * @return
     */
    public R addData(String key, Object value) {
        if (Objects.isNull(this.data)) {
            this.data = new HashMap<>(1);
        }
        this.data.put(key, value);
        return this;
    }

    public Boolean getSuccess() {
        return success;
    }

    public R setSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public R setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public R setMessage(String message) {
        this.message = message;
        return this;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public R setData(Map<String, Object> data) {
        this.data = data;
        return this;
    }
}
