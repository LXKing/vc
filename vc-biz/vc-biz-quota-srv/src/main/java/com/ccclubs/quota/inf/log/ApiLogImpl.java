package com.ccclubs.quota.inf.log;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.mongo.orm.model.VcApiLog;
import com.ccclubs.quota.vo.log.ApiLogInput;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * API调用日志
 *
 * @author jianghaiyang
 * @create 2017-09-05
 **/
@Service(version = "1.0.0")
public class ApiLogImpl implements ApiLogInf {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public PageInfo<VcApiLog> queryLogsByPage(ApiLogInput input) {
        Criteria criteria = Criteria.where("logId").ne(null);
        Query query = new Query();

        if (StringUtils.isNotEmpty(input.getAppId())) {
            query.addCriteria(criteria.and("appId").regex("/" + input.getAppId() + "/"));
        }
        if (StringUtils.isNotEmpty(input.getUrl())) {
            query.addCriteria(criteria.and("url").regex("/" + input.getUrl() + "/"));
        }
        if (StringUtils.isNotEmpty(input.getHttpMethod())) {
            query.addCriteria(criteria.and("httpMethod").regex("/" + input.getHttpMethod() + "/"));
        }
        if (StringUtils.isNotEmpty(input.getIp())) {
            query.addCriteria(criteria.and("ip").regex("/" + input.getIp() + "/"));
        }
        if (StringUtils.isNotEmpty(input.getClassMethod())) {
            query.addCriteria(criteria.and("classMethod").regex("/" + input.getClassMethod() + "/"));
        }
        if (StringUtils.isNotEmpty(input.getInput())) {
            query.addCriteria(criteria.and("input").regex("/" + input.getInput() + "/"));
        }
        if (StringUtils.isNotEmpty(input.getOutput())) {
            query.addCriteria(criteria.and("output").regex("/" + input.getOutput() + "/"));
        }
        if (null != input.getInTime()) {
            query.addCriteria(criteria.and("inTime").gte(input.getInTime()));
        }
        if (null != input.getOutTime()) {
            query.addCriteria(criteria.and("outTime").lte(input.getOutTime()));
        }

        query.skip((input.getPageNum() - 1) * input.getPageSize());
        query.limit(input.getPageSize());

        List<VcApiLog> logs = mongoTemplate.find(query, VcApiLog.class);
        PageInfo pageInfo = new PageInfo<>(logs);
        pageInfo.setTotal(mongoTemplate.count(query, VcApiLog.class));

        return pageInfo;
    }
}
