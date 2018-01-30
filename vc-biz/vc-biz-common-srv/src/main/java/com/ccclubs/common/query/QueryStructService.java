package com.ccclubs.common.query;

import com.ccclubs.frm.cache.CacheConstants;
import com.ccclubs.pub.orm.mapper.CsStructMapper;
import com.ccclubs.pub.orm.model.CsStructWithBLOBs;
import com.jarvis.cache.annotation.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 指令结构
 *
 * @author jianghaiyang
 * @create 2018-01-25
 **/
@Component
public class QueryStructService {
    @Autowired
    CsStructMapper dao;
    @Cache(expire = CacheConstants.NORMAL_EXPIRE, key = "'CsStruct:cssId:'+#args[0]", autoload = true)
    public CsStructWithBLOBs queryCsStructByStructId(Long structId){
        return dao.selectByPrimaryKey(structId);
    }
}
