package com.ccclubs.gateway.gb.dto;

import com.alibaba.fastjson.JSON;
import com.ccclubs.gateway.gb.inf.IExceptionDtoJsonParse;

/**
 * @Author: yeanzi
 * @Date: 2018/5/3
 * @Time: 19:29
 * Email:  yeanzhi@ccclubs.com
 * 校验异常包dto
 */
public class InValideMsgExceptionDTO implements IExceptionDtoJsonParse {

    @Override
    public String toJson() {
        return JSON.toJSONString(this);
    }
}
