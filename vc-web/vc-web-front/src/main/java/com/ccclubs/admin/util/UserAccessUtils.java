package com.ccclubs.admin.util;

import com.ccclubs.admin.constants.Constants;
import com.ccclubs.admin.model.SrvUser;
import com.ccclubs.admin.service.ISrvUserService;
import com.ccclubs.protocol.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author qsxiaogang
 * @create 2017-12-14
 **/
@Component
public class UserAccessUtils {

  @Autowired
  RedisTemplate redisTemplate;
  @Autowired
  ISrvUserService srvUserService;

  public SrvUser getCurrentUser(String token) {
    if (StringUtils.empty(token)) {
      return null;
    }
    Object userID = redisTemplate.opsForValue().get(Constants.ADMIN_TOKEN_PRE + token);
    if (null == userID) {
      return null;
    }

    return srvUserService.selectByPrimaryKey(Integer.parseInt(userID.toString()));
  }
}
