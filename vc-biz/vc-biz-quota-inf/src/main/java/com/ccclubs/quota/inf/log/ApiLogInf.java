package com.ccclubs.quota.inf.log;

import com.ccclubs.mongo.orm.model.VcApiLog;
import com.ccclubs.quota.vo.log.ApiLogInput;
import com.github.pagehelper.PageInfo;

/**
 * API调用日志
 *
 * @author jianghaiyang
 * @create 2017-09-05
 **/
public interface ApiLogInf {
    PageInfo<VcApiLog> queryLogsByPage(ApiLogInput input);
}
