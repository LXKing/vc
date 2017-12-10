package com.ccclubs.admin.service;

import com.ccclubs.admin.model.SrvGroup;
import com.ccclubs.admin.model.SrvUser;
import com.ccclubs.frm.base.BaseService;
import com.ccclubs.admin.model.SrvLimited;
import java.util.List;
import java.util.Map;

/**
 * 权限配置管理的Service接口
 * @author Joel
 */
public interface ISrvLimitedService extends BaseService<SrvLimited, Integer>{
  /**
   * 获取所有权限
   * @return
   */
  public List<SrvLimited> getSrvLimitedList(Map params,Integer size);

  List<SrvLimited> getUserLimits(SrvUser login, boolean b);

  List<SrvLimited> getGroupLimits(SrvGroup srvGroup);

  void updateLimited(Long actorid, Integer actortype, List<SrvLimited> limits);

  public SrvLimited getUserLimited(SrvUser login, String strPath);

}