package com.ccclubs.mongo.service.impl;

import com.ccclubs.mongo.orm.model.history.CsLogger;
import com.ccclubs.mongo.orm.query.CsLoggerQuery;
import com.github.pagehelper.PageInfo;
import com.mongodb.WriteResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author jianghaiyang
 * @create 2018-01-10
 **/
@Service
public class CsLoggerService {
    @Autowired
    @Qualifier("historyMongoTemplate")
    private MongoTemplate historyMongoTemplate;

    public PageInfo<CsLogger> getPage(CsLoggerQuery queryVo, Pageable pageVo) {
        Criteria criteria = Criteria.where("cslId").ne(null);
        Query query = new Query();

        if (queryVo.getCslId() != null) {
            query.addCriteria(criteria.and("cslId").is(queryVo.getCslId()));
        }
        if (queryVo.getCslOrder() != null) {
            query.addCriteria(criteria.and("cslOrder").is(queryVo.getCslOrder()));
        }
        if (queryVo.getCslStatus() != null) {
            query.addCriteria(criteria.and("cslStatus").is(queryVo.getCslStatus()));
        }
        if (StringUtils.isNotEmpty(queryVo.getCslNumber())) {
            query.addCriteria(criteria.and("cslNumber").regex(".*?" + queryVo.getCslNumber() + ".*"));
        }
        if (StringUtils.isNotEmpty(queryVo.getCslLog())) {
            query.addCriteria(criteria.and("cslLog").regex(".*?" + queryVo.getCslLog() + ".*"));
        }
        if (StringUtils.isNotEmpty(queryVo.getCslData())) {
            query.addCriteria(criteria.and("cslData").regex(".*?" + queryVo.getCslData() + ".*"));
        }
        if (null != queryVo.getStartTime()) {
            query.addCriteria(criteria.and("cslAddTime").gte(queryVo.getStartTime()));
        }
        if (null != queryVo.getEndTime()) {
            query.addCriteria(criteria.and("cslAddTime").lte(queryVo.getEndTime()));
        }

        query.skip((pageVo.getPageNumber() - 1) * pageVo.getPageSize());
        query.limit(pageVo.getPageSize());
        query.with(pageVo.getSort());
        List<CsLogger> logs = historyMongoTemplate.find(query, CsLogger.class);
        PageInfo pageInfo = new PageInfo<>(logs);
        long total = historyMongoTemplate.count(query, CsLogger.class);
        int pages = (int) (total / pageVo.getPageSize() + ((total % pageVo.getPageSize() == 0) ? 0 : 1));
        pageInfo.setTotal(total);
        pageInfo.setPages(pages);
        pageInfo.setPageSize(pageVo.getPageSize());
        pageInfo.setPageNum(pageVo.getPageNumber());
        return pageInfo;
    }

    public int delete(String ids) {
        String[] idArr = ids.split(",");
        List<String> idList = Arrays.asList(idArr);
        Query query = new Query(Criteria.where("id").in(idList));
        WriteResult result = historyMongoTemplate.remove(query, CsLogger.class);
        return result.getN();
    }
}
