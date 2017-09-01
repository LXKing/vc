package com.ccclubs.common.query;

import com.ccclubs.pub.orm.mapper.CsStateMapper;
import com.ccclubs.pub.orm.model.CsState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 状态数据查询
 *
 * @author jianghaiyang
 * @create 2017-08-08
 **/
@Component
public class QueryStateService {
    @Autowired
    CsStateMapper dao;
    public CsState queryStateById(Integer id){
        return dao.selectByPrimaryKey(id);
    }
}
