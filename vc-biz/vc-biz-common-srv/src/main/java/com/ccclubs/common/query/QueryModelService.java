package com.ccclubs.common.query;

import com.ccclubs.pub.orm.mapper.CsModelMapper;
import com.ccclubs.pub.orm.model.CsModel;
import com.ccclubs.pub.orm.model.CsModelExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 查询车型
 *
 * @author jianghaiyang
 * @create 2017-07-11
 **/
@Component
public class QueryModelService {

    @Resource
    CsModelMapper dao;

    /**
     * 查询车型
     *
     * @param flag 车型备案号
     * @return 车型CsModel
     */
    //@Cacheable(cacheNames = "models", key = "#flag")
    public CsModel queryModelByFlag(String flag) {
        CsModelExample example = new CsModelExample();
        CsModelExample.Criteria criteria = example.createCriteria();
        criteria.andCsmFlagEqualTo(flag);
        List<CsModel> list = dao.selectByExample(example);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}
