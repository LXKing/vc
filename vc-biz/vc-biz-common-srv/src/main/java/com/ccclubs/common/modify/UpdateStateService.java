package com.ccclubs.common.modify;

import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.mongodb.orm.dao.CsHistoryStateDao;
import com.ccclubs.mongodb.orm.model.CsHistoryState;
import com.ccclubs.pub.orm.mapper.CsStateMapper;
import com.ccclubs.pub.orm.model.CsState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 车机状态数据更新服务
 *
 * @author jianghaiyang
 * @create 2017-08-08
 **/
@Component
public class UpdateStateService {
    @Autowired
    CsStateMapper dao;
    @Autowired
    CsHistoryStateDao hisDao;

    public CsState update(CsState csState) {
        if (csState.getCssId() == null) {
            throw new ApiException(ApiEnum.UPDATE_ID_NOT_SET);
        }
        dao.updateByPrimaryKeySelective(csState);
        return csState;
    }

    public CsState insert(CsState csState) {
        dao.insertSelective(csState);
        return csState;
    }

    public void insertHis(CsHistoryState hisState) {
        hisDao.save(hisState);
    }
}
