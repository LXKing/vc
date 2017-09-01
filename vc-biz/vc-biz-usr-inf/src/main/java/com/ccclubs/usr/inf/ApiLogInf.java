package com.ccclubs.usr.inf;

import com.ccclubs.usr.dto.ApiLogInput;
import com.ccclubs.usr.dto.ApiLogOutput;

/**
 * API调用日志
 *
 * @author jianghaiyang
 * @create 2017-08-29
 **/
public interface ApiLogInf {
    ApiLogOutput saveLog(ApiLogInput input);
    ApiLogOutput updateLog(ApiLogInput input);
}
