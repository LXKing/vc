package com.ccclubs.admin.service.impl;

import com.ccclubs.admin.model.SrvUser;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.ccclubs.frm.base.CrudService;
import com.ccclubs.admin.orm.mapper.SrvLimitedMapper;
import com.ccclubs.admin.model.SrvLimited;
import com.ccclubs.admin.service.ISrvLimitedService;

/**
 * 权限配置管理的Service实现
 * @author Joel
 */
@Service
public class SrvLimitedServiceImpl extends CrudService<SrvLimitedMapper, SrvLimited, Integer> implements ISrvLimitedService{
  @Override
  public List<SrvLimited> getUserLimits(SrvUser parent,boolean flag)
  {
    List<SrvLimited> _limits;
    SrvLimited limited = new SrvLimited();
    limited.setSlUser(parent.getSuId().longValue());
    _limits=select(limited);
    if((_limits == null || _limits.size()==0) && flag)
    {
      limited = new SrvLimited();
      limited.setSlGroup(parent.getSuGroup());
      _limits=select(limited);
    }
    return _limits;
  }
}