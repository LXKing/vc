package com.ccclubs.admin.service.impl;


import com.ccclubs.admin.model.SrvGroup;
import com.ccclubs.admin.model.SrvUser;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
  /**
   * 获取所有权限
   * @return
   */
  @Override
  public List<SrvLimited> getSrvLimitedList(Map params,Integer size)
  {
    return getDao().selectByExample().getSrvLimitedList(params,size);
  }

  /**
   * 获取组权限
   * @param get_login_user
   * @return
   */
  @Override
  public List<SrvLimited> getGroupLimits(SrvGroup srvGroup)
  {
    return srvLimitedDao.getLimitsByActorId(srvGroup.getSgId(), 0);
  }

  /**
   * 获取用户权限，当用户没有权限时，获取该用户所属组的权限
   * @param srvUser
   * @return
   */
  @Override
  public List<SrvLimited> getUserLimits(SrvUser srvUser, boolean bUserGroupLimits)
  {
    List<SrvLimited> list=srvLimitedDao.getLimitsByActorId(srvUser.getSuId(), 1);
    if(list.isEmpty() && bUserGroupLimits)
      return srvLimitedDao.getLimitsByActorId(srvUser.getSuGroupId(), 0);
    else
      return list;
  }

  /**
   * 根据路径获取当前用户的权限
   */
  @Override
  public SrvLimited getUserLimited(SrvUser srvUser, String strPath) {
    return srvLimitedDao.getUserLimited(srvUser,strPath);
  }

  /**
   * 修改权限
   * @param actorId
   * @param actorType
   * @param limits
   */
  @Override
  public void updateLimited(Long actorId, Integer actorType,List<SrvLimited> limits)
  {
//    for(SrvLimited l:limits)
//    {
//      if(l.getSlId()==null)
//        srvLimitedDao.saveSrvLimited(l);
//      else
//        srvLimitedDao.updateSrvLimited(l);
//    }
//
//    List<SrvUser> childUsers;
//    List<SrvGroup> childGroups;
//    String strUserIds="";
//    String strGroupIds="";
//
//    //获取所有子节点用户
//    if(actorType==1)
//    {
//      SrvUser user = srvUserDao.getSrvUserById(actorId);
//      childUsers=srvUserDao.getSrvUserOnwerTree(user);
//    }
//    else
//    {
//      List<SrvUser> tempUsers=srvUserDao.getNoLimitUsersByGroupId(actorId);//获取没有权限的子用户
//      List<String> familys=new ArrayList();
//      for(SrvUser user:tempUsers)
//      {
//        familys.add(user.getSuFamily());
//      }
//
//      childUsers=srvUserDao.getUserTreeByFamilys(familys);
//    }
//    for(SrvUser user:childUsers)
//    {
//      if(!strUserIds.equals(""))
//        strUserIds+=",";
//      strUserIds+=user.getSuId();
//    }
//
//    //获取相关的组
//    childGroups=srvGroupDao.getGroupsByUserIds(strUserIds);
//    for(SrvGroup group:childGroups)
//    {
//      if(!strGroupIds.equals(""))
//        strGroupIds+=",";
//      strGroupIds+=group.getSgId();
//    }
//
//    srvLimitedDao.updateLimitByParent(limits,strUserIds,strGroupIds);//根据父节点用户权限按位与权限，通过SQL语句执行
//
//    srvLimitedDao.delAllNullLimits();//删除权限为0的权限
  }

}