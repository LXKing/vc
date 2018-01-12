package com.ccclubs.mongo.service.impl;

import com.ccclubs.mongo.orm.model.remote.CsRemote;
import com.ccclubs.mongo.orm.query.CsRemoteQuery;
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
 * 指令结果
 *
 * @author jianghaiyang
 * @create 2018-01-10
 **/
@Service
public class CsRemoteService {
    @Autowired
    @Qualifier("remoteMongoTemplate")
    private MongoTemplate remoteMongoTemplate;

    /*public Page<CsRemote> getPage(CsRemoteQuery query, Pageable pageable){
        CsRemote remote = new CsRemote();
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("csrAccess","csrHost","csrCar","csrWay","csrType","csrEditor","csrAddTime","csrState","csrStatus", "csrCode", "version");
        if(StringUtils.isNotEmpty(remote.getCsrNumber())){
            matcher.withMatcher("csrNumber", ExampleMatcher.GenericPropertyMatchers.exact());
        }
        csRemoteRepository.delete("59b2826033fef6153625ede9");
        Example<CsRemote> example = Example.of(remote);
        return csRemoteRepository.findAll(example, pageable);
    }*/

    public PageInfo<CsRemote> getPage(CsRemoteQuery queryVo, Pageable pageVo) {
        Criteria criteria = Criteria.where("csrId").ne(null);
        Query query = new Query();

        if (queryVo.getCsrId() != null) {
            query.addCriteria(criteria.and("csrId").is(queryVo.getCsrId()));
        }
        if (queryVo.getCsrAccess() != null) {
            query.addCriteria(criteria.and("csrAccess").is(queryVo.getCsrAccess()));
        }
        if (queryVo.getCsrHost() != null) {
            query.addCriteria(criteria.and("csrHost").is(queryVo.getCsrHost()));
        }
        if (queryVo.getCsrCar() != null) {
            query.addCriteria(criteria.and("csrCar").is(queryVo.getCsrCar()));
        }
        if (queryVo.getCsrWay() != null) {
            query.addCriteria(criteria.and("csrWay").is(queryVo.getCsrWay()));
        }
        if (queryVo.getCsrType() != null) {
            query.addCriteria(criteria.and("csrType").is(queryVo.getCsrType()));
        }
        if (queryVo.getCsrState() != null) {
            query.addCriteria(criteria.and("csrState").is(queryVo.getCsrState()));
        }
        if (queryVo.getCsrStatus() != null) {
            query.addCriteria(criteria.and("csrStatus").is(queryVo.getCsrStatus()));
        }
        if (StringUtils.isNotEmpty(queryVo.getCsrNumber())) {
            query.addCriteria(criteria.and("csrNumber").regex(".*?" + queryVo.getCsrNumber() + ".*"));
        }
        if (StringUtils.isNotEmpty(queryVo.getCsrEditor())) {
            query.addCriteria(criteria.and("csrEditor").regex(".*?" + queryVo.getCsrEditor() + ".*"));
        }
        if (null != queryVo.getStartTime()) {
            query.addCriteria(criteria.and("csrAddTime").gte(queryVo.getStartTime()));
        }
        if (null != queryVo.getEndTime()) {
            query.addCriteria(criteria.and("csrAddTime").lte(queryVo.getEndTime()));
        }

        query.skip((pageVo.getPageNumber() - 1) * pageVo.getPageSize());
        query.limit(pageVo.getPageSize());
        Sort sort = new Sort(Sort.Direction.DESC, "csrAddTime");
        query.with(sort);
        List<CsRemote> logs = remoteMongoTemplate.find(query, CsRemote.class);
        PageInfo pageInfo = new PageInfo<>(logs);
        long total = remoteMongoTemplate.count(query, CsRemote.class);
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
        WriteResult result = remoteMongoTemplate.remove(query, CsRemote.class);
        return result.getN();
    }
}
