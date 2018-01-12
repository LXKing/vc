package com.ccclubs.usr.inf.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.mongo.orm.dao.VcApiLogDao;
import com.ccclubs.mongo.orm.model.history.VcApiLog;
import com.ccclubs.usr.dto.ApiLogInput;
import com.ccclubs.usr.dto.ApiLogOutput;
import com.ccclubs.usr.inf.ApiLogInf;
import com.ccclubs.usr.version.UserServiceVersion;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 记录API调用日志
 *
 * @author jianghaiyang
 * @create 2017-08-29
 **/
@Service(version = UserServiceVersion.V1)
public class ApiLogImpl implements ApiLogInf {

    @Autowired
    private VcApiLogDao dao;

    @Override
    public ApiLogOutput saveLog(ApiLogInput input) {
        VcApiLog log = new VcApiLog();
//        BeanUtils.copyProperties(input, log);
//        log = dao.save(log);
        ApiLogOutput output = new ApiLogOutput();
//        output.setLogId(log.getLogId());
        return output;
    }

    @Override
    public ApiLogOutput updateLog(ApiLogInput input) {
//        Query query = new Query(Criteria.where("logId").is(input.getLogId()));
//        Update update = new Update().set("output", input.getOutput())
//                .set("outTime", input.getOutTime())
//                .set("elapsed", input.getElapsed());
//        dao.update(query, update);
        return null;
    }
}
