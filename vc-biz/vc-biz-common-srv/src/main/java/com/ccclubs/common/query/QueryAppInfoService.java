package com.ccclubs.common.query;

import com.ccclubs.pub.orm.mapper.SrvHostMapper;
import com.ccclubs.pub.orm.mapper.SrvHostMapper;
import com.ccclubs.pub.orm.model.SrvHost;
import com.ccclubs.pub.orm.model.SrvHostExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 查询接入的应用系统信息
 *
 * @author jianghaiyang
 * @create 2017-07-11
 **/
@Component
public class QueryAppInfoService {

    @Autowired
    SrvHostMapper dao;

    /**
     * 查询车型
     *
     * @param appId 系统约定APPID
     * @return 车型SrvHost
     */
    //@Cacheable(cacheNames = "hosts", key = "#appId")
    public SrvHost queryHostByAppid(String appId) {
        SrvHostExample example = new SrvHostExample();
        SrvHostExample.Criteria criteria = example.createCriteria();
        criteria.andShAppidEqualTo(appId);
        List<SrvHost> list = dao.selectByExample(example);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public SrvHost queryHostById(Integer id) {
        SrvHost host = dao.selectByPrimaryKey(id);

        return host;
    }
}
