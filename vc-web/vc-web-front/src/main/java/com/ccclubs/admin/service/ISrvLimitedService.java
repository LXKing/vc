package com.ccclubs.admin.service;

import com.ccclubs.admin.model.SrvLimited;
import com.ccclubs.admin.model.SrvUser;
import com.ccclubs.frm.base.BaseService;
import java.util.List;

/**
 * 权限配置管理的Service接口
 * @author Joel
 */
public interface ISrvLimitedService extends BaseService<SrvLimited, Integer>{
  List<SrvLimited> getUserLimits(SrvUser parent,boolean flag);
}