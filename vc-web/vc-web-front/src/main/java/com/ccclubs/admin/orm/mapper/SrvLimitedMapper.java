package com.ccclubs.admin.orm.mapper;

import com.ccclubs.frm.base.BaseDAO;
import com.ccclubs.admin.model.SrvLimited;
import java.util.Map;

/**
 * 权限配置管理的Mapper实现
 * @author Joel
 */
public interface SrvLimitedMapper extends BaseDAO<SrvLimited,Integer>{
  SrvLimited getUserLimited(Map param);
}
