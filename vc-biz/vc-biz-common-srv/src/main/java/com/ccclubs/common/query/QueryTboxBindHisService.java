package com.ccclubs.common.query;

import com.ccclubs.pub.orm.mapper.CsTboxBindHisMapper;
import com.ccclubs.pub.orm.model.CsTboxBindHis;
import com.ccclubs.pub.orm.model.CsTboxBindHisExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2018/1/17 0017.
 */
@Component
public class QueryTboxBindHisService {

    @Autowired
    CsTboxBindHisMapper dao;

    public List<CsTboxBindHis> selectByExample(CsTboxBindHisExample example){
       return dao.selectByExample(example);
    }

}
