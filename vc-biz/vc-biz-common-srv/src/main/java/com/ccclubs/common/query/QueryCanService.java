package com.ccclubs.common.query;

import com.ccclubs.frm.cache.CacheConstants;
import com.ccclubs.pub.orm.mapper.CsCanMapper;
import com.ccclubs.pub.orm.model.CsCan;
import com.ccclubs.pub.orm.model.CsCanExample;
import com.jarvis.cache.annotation.Cache;
import com.jarvis.cache.annotation.ExCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * can数据查询
 *
 * @author jianghaiyang
 * @create 2017-08-08
 **/
@Component
public class QueryCanService {

    @Resource
    CsCanMapper dao;

    @Cache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsCan:cscId:'+#args[0]", autoload = true, exCache = {
            @ExCache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsCan:cscNumber:'+#retVal.cscNumber", condition = "!#empty(#retVal) && !#empty(#retVal.cscNumber)"),
            @ExCache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsCan:cscCar:'+#retVal.cscCar", condition = "!#empty(#retVal) && !#empty(#retVal.cscCar) && #retVal.cscCar > 0")})
    public CsCan queryCanById(Long id) {
        return dao.selectByPrimaryKey(id);
    }

    /**
     * 根据车机号
     *
     * @param carNumber
     * @return
     */
    public CsCan getCsCanByCarNumber(String carNumber) {
        CsCanExample csCanExample = new CsCanExample();
        CsCanExample.Criteria csCanExampleCriteria = csCanExample.createCriteria();
        csCanExampleCriteria.andCscNumberEqualTo(carNumber);
        List<CsCan> canList = dao.selectByExample(csCanExample);

        // 未查询到车辆can
        if (canList.size() > 0) {
            return canList.get(0);
        }
        return null;
    }
}
