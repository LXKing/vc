package com.ccclubs.admin.controller;

import com.ccclubs.admin.constants.Constants;
import com.ccclubs.admin.entity.SrvProjectCrieria;
import com.ccclubs.admin.model.SrvLimited;
import com.ccclubs.admin.model.SrvProject;
import com.ccclubs.admin.model.SrvUser;
import com.ccclubs.admin.orm.mapper.SrvLimitedMapper;
import com.ccclubs.admin.service.ISrvGroupService;
import com.ccclubs.admin.service.ISrvLimitedService;
import com.ccclubs.admin.service.ISrvProjectService;
import com.ccclubs.admin.service.ISrvUserService;
import com.ccclubs.admin.vo.Param;
import com.ccclubs.admin.vo.ResultCode;
import com.ccclubs.admin.vo.ResultMsg;
import com.ccclubs.protocol.util.StringUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * *************************** 版权所有：车厘子 所有权利 创建日期: 2017/9/27 创建作者：zkm 类名称　：AuthWebController.java
 * 版　　本： 功　　能： 最后修改： 修改记录： ****************************
 */
@RestController
public class AuthWebController {


  @Autowired
  ISrvUserService srvUserService;

  @Autowired
  ISrvGroupService srvGroupService;

  @Autowired
  ISrvLimitedService srvLimitedService;

  @Autowired
  SrvLimitedMapper limitedMapper;

  @Autowired
  ISrvProjectService srvProjectService;

  @Autowired
  RedisTemplate redisTemplate;

  private static Integer exps[] =
      {64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536};

  private Map<Long, Integer> limitMap = new HashMap<Long, Integer>();

  Logger logger = Logger.getLogger(AuthWebController.class);


  /**
   * 获取用户所有菜单
   */
  @SuppressWarnings(
      {"rawtypes", "unchecked"})
  @PostMapping("oauth/getUserLimit")
  public ResultMsg getUserLimit(@RequestParam("userid")
      Long actorid) {
    Map resultMap;
    if (actorid == null) {
      return new ResultMsg<>(false,
          ResultCode.INVALID_TOKEN, null);
    }

    Object token = redisTemplate.opsForValue().get(Constants.ADMIN_USER_PRE + actorid.toString());
    if (null == token){
      return new ResultMsg<>(false,
          ResultCode.INVALID_TOKEN, null);
    }
    Object userID = redisTemplate.opsForValue().get(Constants.ADMIN_TOKEN_PRE + token.toString());
    if (null == userID){
      return new ResultMsg<>(false,
          ResultCode.INVALID_TOKEN, null);
    }

    ResultMsg<Object> resultMsg;
    SrvLimited limited = new SrvLimited();
    limited.setSlUser(actorid);
    try {
      resultMap = new HashMap();
      SrvUser srvUser;
      List<SrvProject> _projects;// 权限设置者可见的项目
      List<SrvLimited> _limiteds;// 权限视被设置者的权限

      // 获取该对象的实际权限
      if (0 == actorid) {
        return getSuperLimit();
      } else {
        srvUser = srvUserService.selectByPrimaryKey(actorid.intValue());
        _limiteds = srvLimitedService.getUserLimits(srvUser, true);
        _projects = getUserProject(_limiteds);
        resultMap.put("projects", _projects);
        resultMap.put("limiteds", _limiteds);
        resultMsg = new ResultMsg<>(true,
            ResultCode.OK, analyseLimit(resultMap, actorid));//analyseLimit(resultMap, actorid)
        return resultMsg;
      }
    } catch (Exception ex) {
      ex.printStackTrace();
      return new ResultMsg<Object>(false,
          ResultCode.SYSTEM_ERR, null);
    }
  }

  /**
   * 获取权限
   */
  @SuppressWarnings(
      {"rawtypes", "unchecked"})
  @PostMapping("oauth/getSrvlimit")
  public ResultMsg getSrvlimit(@RequestParam("path") String path,
      @RequestParam("userid") Long userId) {

    Object token = redisTemplate.opsForValue().get(Constants.ADMIN_USER_PRE + userId.toString());
    if (null == token){
      return new ResultMsg<>(false,
          ResultCode.INVALID_TOKEN, null);
    }
    Object userID = redisTemplate.opsForValue().get(Constants.ADMIN_TOKEN_PRE + token.toString());
    if (null == userID){
      return new ResultMsg<>(false,
          ResultCode.INVALID_TOKEN, null);
    }

    Map resutlMap = new HashMap();
    ResultMsg<Object> resultMsg;
    if (path.indexOf("/") == 0)//排除第一位是/的可能
    {
      path = path.substring(1, path.length());
    }
    if (path.indexOf("//") != -1) {//url转化
      path = path.replaceAll("//", "/");
    }
    // 缓存为空，则重新查找权限
    SrvUser user = srvUserService.selectByPrimaryKey(userId.intValue());
    if (user == null || StringUtils.empty(path)) {
      resultMsg = new ResultMsg<>(false,
          ResultCode.PERMISSION_DENIED, null);
      return resultMsg;
    }
    SrvLimited srvLimited = new SrvLimited();
    srvLimited.setSlUser(user.getSuId().longValue());
    List<SrvLimited> srvLimites = srvLimitedService.select(srvLimited);
    Map params = new HashMap();
    params.put("actorId",
        srvLimites.size() > 0 ? user.getSuId() : user.getSuGroup());
    params.put("actorType", srvLimites.size() > 0 ? 1 : 0);
    params.put("path", "%" + path + "%");
    srvLimited = limitedMapper.getUserLimited(params);
    if (srvLimited != null) {
      Integer limitsId = srvLimited.getSlLimit();
      resutlMap.put("add", ((limitsId & 2) == 2) ? 1 : 0);
      resutlMap.put("batchDel", ((limitsId & 8) == 8) ? 1 : 0);
      resutlMap.put("exportData", ((limitsId & 16) == 16) ? 1 : 0);
      resutlMap.put("update", ((limitsId & 4) == 4) ? 1 : 0);
      resutlMap.put("del", ((limitsId & 8) == 8) ? 1 : 0);
      resutlMap.put("detail", ((limitsId & 1) == 1) ? 1 : 0);
      resutlMap.put("canView", ((limitsId & 1) == 1) ? 1 : 0);// &&
      //处理扩展权限
      int canExp[] = new int[exps.length];
      for (int i = 0; i < exps.length; i++) {
        canExp[i] = (limitsId & exps[i]) == exps[i] ? 1
            : 0;
      }
      resutlMap.put("canExp", canExp);
      resultMsg = new ResultMsg<Object>(true, ResultCode.OK,
          resutlMap);
      return resultMsg;
    } else {
      resutlMap.put("canView", 1);// &&
      resutlMap.put("detail", 0);
      resutlMap.put("add", 0);
      resutlMap.put("update", 0);
      resutlMap.put("del", 0);
      resutlMap.put("batchDel", 0);
      resutlMap.put("exportData", 0);
      resultMsg = new ResultMsg<Object>(true, ResultCode.OK,
          resutlMap);
      return resultMsg;
    }
  }


  /**
   * 修改密码
   * @param params
   * @return
   */
  @PostMapping("oauth/editPassword")
  public ResultMsg editPassword(@RequestBody Param<String, Object> params)
  {
    try{
      Integer userId = params.get("userId", Integer.class);
      String oldPass = params.get("oldPass", String.class);

      String newPass = params.get("newPass", String.class);

      SrvUser srvUser=srvUserService.selectByPrimaryKey(userId);

      if(!StringUtils.md5(oldPass).equals(srvUser.getSuPassword().toUpperCase()))
      {
        return new ResultMsg(false, ResultCode.INVALID_OLD_PASSWORD, null);
      }
      if(!newPass.matches("((?=.*\\d)(?=.*\\D)|(?=.*[a-zA-Z])(?=.*[^a-zA-Z]))^.{8,16}$")){
        return new ResultMsg(false, ResultCode.PASSWORD_VALID_INFO, null);
      }
      srvUser.setSuPassword(StringUtils.md5(newPass).substring(0, 32));
      srvUserService.updateByPrimaryKeySelective(srvUser);
      return new ResultMsg(true, ResultCode.PASSWORD_UPDATE_SECCESS, null);
    }catch(Exception ex){
      ex.printStackTrace();
      return new ResultMsg(false, ResultCode.SYSTEM_ERR, null);
    }
  }

  /**
   * 获取用户支持的项目
   */
  private List<SrvProject> getSuperUserProject() {
    List<SrvProject> _projects = null;// 权限设置者可见的项目
    List<Long> strIds = new ArrayList<Long>();

    _projects = srvProjectService.selectAll();
    java.util.Comparator com = new java.util.Comparator<SrvProject>() {
      public int compare(SrvProject o1, SrvProject o2) {
        int o1Str = Integer.parseInt(o1.getSpFamily().split(",")[0]);
        int o2Str = Integer.parseInt(o2.getSpFamily().split(",")[0]);
        if (o1.getSpFamily().split(",").length < o2.getSpFamily().split(",").length) {
          return 0;
        }
        if (o1.getSpFamily().split(",").length == o2.getSpFamily().split(",").length
            && o2Str > o1Str) {
          return 0;
        }
        if (o1Str >= o2Str) {
          return 1;
        }
        return -1;
      }
    };
    java.util.Collections.sort(_projects, com);
    return _projects;
  }

  /**
   * 获取用户支持的项目
   */
  private List<SrvProject> getUserProject(List<SrvLimited> _limits) {
    List<SrvProject> _projects = null;// 权限设置者可见的项目
    List<Long> strIds = new ArrayList<Long>();
    for (SrvLimited o : _limits) {
      limitMap.put(o.getSlProject(), o.getSlLimit());
      if (!strIds.equals("")) {
        strIds.add(o.getSlProject());
      }
    }
    SrvProjectCrieria query = new SrvProjectCrieria();
    query.createCriteria().andspIdIn(strIds).andspStatusEqualTo((short) 1);
    _projects = srvProjectService.selectByExample(query);
    return _projects;
  }


  /**
   * 获得超级管理员权限
   */
  @SuppressWarnings(
      {"rawtypes", "unchecked"})
  public ResultMsg getSuperLimit() {
    ResultMsg<Object> resultMsg;
    Map resutlMap = new HashMap();
    resutlMap.put("detail", 1);
    resutlMap.put("add", 1);
    resutlMap.put("update", 1);
    resutlMap.put("del", 1);
    resutlMap.put("batchDel", 1);
    resutlMap.put("exportData", 1);
    resutlMap.put("canStats", 1);
    int canExp[] = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    resutlMap.put("canExp", canExp);
    resultMsg = new ResultMsg<Object>(true, ResultCode.OK, resutlMap);
    return resultMsg;
  }

  /**
   * 解析当前用户的权限
   */
  @SuppressWarnings(
      {"rawtypes", "unchecked"})
  public Map analyseLimit(Map resultMap, final Long userId) {
    Map<String, Object> result;
    final List<SrvProject> projects = (List<SrvProject>) resultMap
        .get("projects");// 权限设置者可见的项目
    DealProjectThread thread = new DealProjectThread(projects, limitMap, userId);
    result = thread.run();
    result.put("projects", projects);
    return result;
  }

}
