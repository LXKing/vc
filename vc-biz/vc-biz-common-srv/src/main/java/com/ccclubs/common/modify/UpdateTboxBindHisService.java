package com.ccclubs.common.modify;

import com.ccclubs.pub.orm.mapper.CsTboxBindHisMapper;
import com.ccclubs.pub.orm.model.CsTboxBindHis;
import com.ccclubs.pub.orm.model.CsTboxBindHisExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/1/15 0015.
 */
@Component
public class UpdateTboxBindHisService {

    @Autowired
    CsTboxBindHisMapper dao;


    public int insert(CsTboxBindHis csTboxBindHis){
       return  dao.insert(csTboxBindHis);
    }

    public void updateByExampleSelective(CsTboxBindHis record, CsTboxBindHisExample example){
        dao.updateByExampleSelective(record,example);
    }
}
