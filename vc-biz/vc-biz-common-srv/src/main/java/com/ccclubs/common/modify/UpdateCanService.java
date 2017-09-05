package com.ccclubs.common.modify;

import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.mongo.orm.dao.CsHistoryCanDao;
import com.ccclubs.mongo.orm.model.CsHistoryCan;
import com.ccclubs.pub.orm.mapper.CsCanMapper;
import com.ccclubs.pub.orm.model.CsCan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 更新can
 *
 * @author jianghaiyang
 * @create 2017-08-08
 **/
@Component
public class UpdateCanService {

    @Autowired
    CsCanMapper dao;

    @Autowired
    CsHistoryCanDao hisDao;

    public CsCan update(CsCan can) {
        if (can.getCscId() == null) {
            throw new ApiException(ApiEnum.UPDATE_ID_NOT_SET);
        }
        dao.updateByPrimaryKey(can);
        return can;
    }

    public CsCan insert(CsCan csCan) {
        dao.insertSelective(csCan);
        return csCan;
    }

    public void insertHis(CsHistoryCan hisCan) {
        hisDao.save(hisCan);
    }
}
