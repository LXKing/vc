package com.ccclubs.mongo.service.impl;

import com.ccclubs.mongo.orm.model.history.CsVehicleExp;
import com.ccclubs.mongo.orm.query.CsVehicleExpQuery;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 异常车辆数据
 *
 * @author jianghaiyang
 * @create 2018-03-02
 **/
//@Service
public class CsVehicleExpService {

    @Autowired
    @Qualifier("historyMongoTemplate")
    private MongoTemplate historyMongoTemplate;

    public PageInfo<CsVehicleExp> getPage(CsVehicleExpQuery queryVo, Pageable pageVo) {
        Criteria criteria = Criteria.where("_id").ne(null);
        Query query = new Query();

        if (queryVo.getCsvCarNo() != null) {
            query.addCriteria(criteria.and("csvCarNo").regex(".*?" + queryVo.getCsvCarNo() + ".*"));
        }
        if (queryVo.getCsvVin() != null) {
            query.addCriteria(criteria.and("csvVin").regex(".*?" + queryVo.getCsvVin() + ".*"));
        }
        if (queryVo.getCsvEngineNo() != null) {
            query.addCriteria(criteria.and("csvEngineNo").regex(".*?" + queryVo.getCsvEngineNo() + ".*"));
        }
        if (StringUtils.isNotEmpty(queryVo.getCsvBataccuCode())) {
            query.addCriteria(criteria.and("csvBataccuCode").regex(".*?" + queryVo.getCsvBataccuCode() + ".*"));
        }
        if (StringUtils.isNotEmpty(queryVo.getCsvModelCodeFull())) {
            query.addCriteria(criteria.and("csvModelCodeFull").regex(".*?" + queryVo.getCsvModelCodeFull() + ".*"));
        }
        if (StringUtils.isNotEmpty(queryVo.getCsvModelCodeSimple())) {
            query.addCriteria(criteria.and("csvModelCodeSimple").regex(".*?" + queryVo.getCsvModelCodeSimple() + ".*"));
        }
        if (StringUtils.isNotEmpty(queryVo.getCsmNumber())) {
            query.addCriteria(criteria.and("csmNumber").regex(".*?" + queryVo.getCsmNumber() + ".*"));
        }
        if (StringUtils.isNotEmpty(queryVo.getCsmTeNo())) {
            query.addCriteria(criteria.and("csmTeNo").regex(".*?" + queryVo.getCsmTeNo() + ".*"));
        }
        if (StringUtils.isNotEmpty(queryVo.getCsmTeModel())) {
            query.addCriteria(criteria.and("csmTeModel").regex(".*?" + queryVo.getCsmTeModel() + ".*"));
        }
        if (StringUtils.isNotEmpty(queryVo.getCsmTeCode())) {
            query.addCriteria(criteria.and("csmTeCode").regex(".*?" + queryVo.getCsmTeCode() + ".*"));
        }
        if (StringUtils.isNotEmpty(queryVo.getCsmTeLotNo())) {
            query.addCriteria(criteria.and("csmTeLotNo").regex(".*?" + queryVo.getCsmTeLotNo() + ".*"));
        }
        if (StringUtils.isNotEmpty(queryVo.getCsmTeSerial())) {
            query.addCriteria(criteria.and("csmTeSerial").regex(".*?" + queryVo.getCsmTeSerial() + ".*"));
        }
        if (StringUtils.isNotEmpty(queryVo.getCsmMobile())) {
            query.addCriteria(criteria.and("csmMobile").regex(".*?" + queryVo.getCsmMobile() + ".*"));
        }
        if (StringUtils.isNotEmpty(queryVo.getCsmIccid())) {
            query.addCriteria(criteria.and("csmIccid").regex(".*?" + queryVo.getCsmIccid() + ".*"));
        }

        //注意mongo存储的是date类型
        if (null != queryVo.getStartTime() && null != queryVo.getEndTime()) {
            query.addCriteria(criteria.and("csvAddTime").gte(queryVo.getStartTime()).lte(queryVo.getEndTime()));
        }
        if (null != queryVo.getStartTime() && null == queryVo.getEndTime()) {
            query.addCriteria(criteria.and("csvAddTime").gte(queryVo.getStartTime()));
        }
        if (null == queryVo.getStartTime() && null != queryVo.getEndTime()) {
            query.addCriteria(criteria.and("csvAddTime").lte(queryVo.getEndTime()));
        }

        query.skip((pageVo.getPageNumber() - 1) * pageVo.getPageSize());
        query.limit(pageVo.getPageSize());
        query.with(pageVo.getSort());
        List<CsVehicleExp> logs = historyMongoTemplate.find(query, CsVehicleExp.class);
        PageInfo pageInfo = new PageInfo<>(logs);
        long total = historyMongoTemplate.count(query, CsVehicleExp.class);
        int pages = (int) (total / pageVo.getPageSize() + ((total % pageVo.getPageSize() == 0) ? 0 : 1));
        pageInfo.setTotal(total);
        pageInfo.setPages(pages);
        pageInfo.setPageSize(pageVo.getPageSize());
        pageInfo.setPageNum(pageVo.getPageNumber());
        return pageInfo;
    }

    public List<CsVehicleExp> getAll(){
        return historyMongoTemplate.findAll(CsVehicleExp.class);
    }
}
