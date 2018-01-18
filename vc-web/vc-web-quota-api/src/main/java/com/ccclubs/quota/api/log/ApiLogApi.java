package com.ccclubs.quota.api.log;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccclubs.frm.spring.entity.ApiMessage;
import com.ccclubs.mongo.orm.model.history.VcApiLog;
import com.ccclubs.quota.inf.log.ApiLogInf;
import com.ccclubs.quota.vo.log.ApiLogInput;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API调用日志
 *
 * @author jianghaiyang
 * @create 2017-09-04
 **/
@RefreshScope
@RestController
public class ApiLogApi {

    @Reference(version = "1.0.0")
    ApiLogInf logInf;

    @PostMapping("apiLog")
    public ApiMessage<PageInfo<VcApiLog>> logs(ApiLogInput input){
        return new ApiMessage(logInf.queryLogsByPage(input));
    }
}
