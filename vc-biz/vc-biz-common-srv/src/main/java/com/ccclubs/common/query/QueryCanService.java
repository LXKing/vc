package com.ccclubs.common.query;

import com.ccclubs.pub.orm.mapper.CsCanMapper;
import com.ccclubs.pub.orm.model.CsCan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * can数据查询
 *
 * @author jianghaiyang
 * @create 2017-08-08
 **/
@Component
public class QueryCanService {

    @Autowired
    CsCanMapper dao;

    public CsCan queryCanById(Long id){
        return dao.selectByPrimaryKey(id);
    }
}
