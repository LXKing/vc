package com.ccclubs.vehicle.dto;

import com.alibaba.fastjson.JSONArray;

import java.io.Serializable;

/**
 * 校验结果
 *
 * @author jianghaiyang
 * @create 2017-07-11
 **/
public class RegisterOutput implements Serializable {
    //成功
    private JSONArray success = new JSONArray();

    //失败
    private JSONArray failure = new JSONArray();

    public JSONArray getSuccess() {
        return success;
    }

    public void setSuccess(JSONArray success) {
        this.success = success;
    }

    public JSONArray getFailure() {
        return failure;
    }

    public void setFailure(JSONArray failure) {
        this.failure = failure;
    }
}
