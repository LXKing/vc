package com.ccclubs.common.query;

import com.ccclubs.frm.cache.CacheConstants;
import com.ccclubs.pub.orm.mapper.SrvHostMapper;
import com.ccclubs.pub.orm.model.SrvHost;
import com.ccclubs.pub.orm.model.SrvHostExample;
import com.jarvis.cache.annotation.Cache;
import com.jarvis.cache.annotation.ExCache;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 查询接入的应用系统信息
 *
 * @author jianghaiyang
 * @create 2017-07-11
 **/
@Component
public class QueryAppInfoService {

  @Resource
  SrvHostMapper dao;

  /**
   * 查询车型
   *
   * @param appId 系统约定APPID
   * @return 车型SrvHost
   */
  @Cache(expire = CacheConstants.NORMAL_EXPIRE, key = "'SrvHost:shAppid:'+#args[0]", autoload = true, exCache = {
      @ExCache(expire = CacheConstants.NORMAL_EXPIRE, key = "'SrvHost:shId:'+#retVal.shId", condition = "!#empty(#retVal) && !#empty(#retVal.shId)")})
  public SrvHost queryHostByAppidFromCache(String appId) {
    return queryHostByAppid(appId);
  }

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

  @Cache(expire = CacheConstants.NORMAL_EXPIRE, key = "'SrvHost:shId:'+#args[0]", autoload = true, exCache = {
      @ExCache(expire = CacheConstants.NORMAL_EXPIRE, key = "'SrvHost:shAppid:'+#retVal.shAppid", condition = "!#empty(#retVal) && !#empty(#retVal.shAppid)")})
  public SrvHost queryHostByIdFromCache(Integer id) {
    return queryHostById(id);
  }

  public SrvHost queryHostById(Integer id) {
    return dao.selectByPrimaryKey(id);
  }












}
