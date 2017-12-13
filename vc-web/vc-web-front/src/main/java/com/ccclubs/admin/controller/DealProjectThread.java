package com.ccclubs.admin.controller;

import com.ccclubs.admin.model.SrvProject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;


/**
 * *************************** 版权所有：车厘子 所有权利 创建日期: 2017-10-18 创建作者：zkm 类名称　：DealProjectThread.java
 * 版　　本： 功　　能：项目批量处理线程，提高页面响应速度 最后修改： 修改记录： ****************************
 */
public class DealProjectThread {

  /**
   * 数量
   */
  private int count;

  /**
   * 索引
   */
  private int index = 0;

  /**
   * 总数
   */
  private int TESKSIZE = 20;

  @Autowired
  RedisTemplate redisTemplate;


  private Map<String, Object> resultMap = new HashMap<String, Object>();

  private Map<String, Object> checkLimits = new HashMap<String, Object>();


  /**
   * 对象锁
   */
  public Object lock = new Object();

  private static Integer exps[] =
      {64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536};

  private Map<Long, Integer> limitMap;

  private Long userId;

  List<SrvProject> projects;

  public DealProjectThread(List<SrvProject> projects, Map<Long, Integer> limitMap, Long userId) {
    this.userId = userId;
    this.projects = projects;
    this.limitMap = limitMap;
  }

  public Map<String, Object> run() {
    List<SrvProject> excuteProject = projects;
    Map<String, Object> result = new HashMap<>();
    Integer slLimit;
    Map<String, Object> limit = new HashMap<>();
    Map<String, String> checkLimit = new HashMap<>();
    for (SrvProject project : excuteProject) {
      // 权限值
      slLimit = getLimitMap().get(project.getSpId());
      if (slLimit == null) {
        continue;
      }
      // 处理页面显示权限
      limit.put("canView", ((slLimit & 1) == 1) ? 1 : 0);
      limit.put("detail", ((slLimit & 1) == 1) ? 1 : 0);
      limit.put("add", ((slLimit & 2) == 2) ? 1 : 0);
      limit.put("update", ((slLimit & 4) == 4) ? 1 : 0);
      limit.put("del", ((slLimit & 8) == 8) ? 1 : 0);
      limit.put("batchDel", ((slLimit & 8) == 8) ? 1 : 0);
      limit.put("exportData", ((slLimit & 16) == 16) ? 1 : 0);
      limit.put("canStats", ((slLimit & 32) == 32) ? 1 : 0);
      //处理扩展权限
      int canExp[] = new int[exps.length];
      for (int i = 0; i < exps.length; i++) {
        canExp[i] = (slLimit & exps[i]) == exps[i] ? 1
            : 0;
      }
      limit.put("canExp", canExp);
      result.put(project.getSpUrl(), limit);
    }
    checkLimits.putAll(checkLimit);
    resultMap.putAll(result);

    return resultMap;
  }

  public Map<Long, Integer> getLimitMap() {
    return limitMap;
  }

  public void setLimitMap(Map<Long, Integer> limitMap) {
    this.limitMap = limitMap;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public List<SrvProject> getProjects() {
    return projects;
  }

  public void setProjects(List<SrvProject> projects) {
    this.projects = projects;
  }

}

