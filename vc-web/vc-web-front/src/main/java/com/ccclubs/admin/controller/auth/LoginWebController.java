package com.ccclubs.admin.controller.auth;


import com.ccclubs.admin.constants.Constants;
import com.ccclubs.admin.model.SrvGroup;
import com.ccclubs.admin.model.SrvUser;
import com.ccclubs.admin.orm.mapper.SrvLimitedMapper;
import com.ccclubs.admin.service.ISrvGroupService;
import com.ccclubs.admin.service.ISrvLimitedService;
import com.ccclubs.admin.service.ISrvProjectService;
import com.ccclubs.admin.service.ISrvUserService;
import com.ccclubs.admin.util.HttpUtils;
import com.ccclubs.admin.util.UUIDGenerator;
import com.ccclubs.admin.util.jwt.AccessToken;
import com.ccclubs.admin.vo.LoginVo;
import com.ccclubs.admin.vo.ResultCode;
import com.ccclubs.admin.vo.ResultMsg;
import com.ccclubs.protocol.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 登录
 */
@RestController
public class LoginWebController {

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

    /**
     * 登录
     */
    @PostMapping("user/login")
    public Object getAccessToken(@RequestBody LoginVo loginVo) {
        String strUsername = loginVo.getUsername();
        String strPassword = loginVo.getPassword();
        ResultMsg<Object> resultMsg;
        try {
            if (strUsername == null || strUsername.trim().equals("")) {
                resultMsg = new ResultMsg<Object>(false,
                        ResultCode.USER_NAME_IS_EMPTY, null);
                return resultMsg;
            }
            if (strPassword == null || strPassword.trim().equals("")) {
                resultMsg = new ResultMsg<Object>(false,
                        ResultCode.PASSWORD_IS_EMPTY, null);
                return resultMsg;
            }
            // 验证码校验在后面添加

            // 验证用户名密码
            SrvUser user = new SrvUser();
            user.setSuUsername(strUsername);
            user = srvUserService.selectOne(user);
            // 验证是否超级用户
            if (strUsername.equals("super") && strPassword.equals("data@ccclubs")) {
                user = new SrvUser();//创建超级用户
                user.setSuUsername(strUsername);
                user.setSuRealName("超级用户");
                user.setSuId(0);
            } else {
                if (user == null) {
                    resultMsg = new ResultMsg<Object>(false,
                            ResultCode.USER_DOES_NOT_EXIST, null);
                    return resultMsg;
                }
                if (user.getSuStatus() != 1) {
                    resultMsg = new ResultMsg<Object>(false,
                            ResultCode.INVALID_USERNAME, null);
                    return resultMsg;
                }

                if (!strPassword.equals(user.getSuPassword())
                        && !StringUtils.md5(strPassword).equals(
                        user.getSuPassword().toUpperCase())) {
                    resultMsg = new ResultMsg<Object>(false,
                            ResultCode.INVALID_PASSWORD, null);
                    return resultMsg;
                }

                // 判断用户所属组是否可用
                SrvUser parentUser = user;
                SrvGroup parentGroup;
                while (parentUser != null) {
                    parentGroup = srvGroupService.selectByPrimaryKey(parentUser.getSuGroup().intValue());
                    if (parentUser.getSuStatus().intValue() != 1
                            || parentGroup.getSgStatus().intValue() != 1) {
                        resultMsg = new ResultMsg<Object>(false,
                                ResultCode.USER_IS_UNAVAILABLE, null);
                        return resultMsg;
                    }
                    parentUser = srvUserService.selectByPrimaryKey(
                            parentGroup.getSgParent() == null ? 0 : parentGroup.getSgParent().intValue());
                }
            }
            user.setSuLastTime(new java.util.Date());
            user.setSuLastIp(HttpUtils.getIpAddress());
            srvUserService.updateByPrimaryKeySelective(user);
            //清楚原先的权限值
            Map userMap = (Map) redisTemplate.opsForHash()
                    .get(Constants.PL_AUTH_URL_SESSION, user.getSuId() + Constants.USER_LIMIT);
            if (userMap != null) {
                redisTemplate.opsForHash()
                        .delete(Constants.PL_AUTH_URL_SESSION, user.getSuId() + Constants.USER_LIMIT);
            }
            Map checkMap = (Map) redisTemplate.opsForHash()
                    .get(Constants.PL_AUTH_URL_SESSION, user.getSuId() + Constants.CHECK_LIMIT);
            if (checkMap != null) {
                redisTemplate.opsForHash()
                        .delete(Constants.PL_AUTH_URL_SESSION, user.getSuId() + Constants.CHECK_LIMIT);
            }
            // 清除原先账户token
            Object oldToken = redisTemplate.opsForValue()
                    .get(Constants.ADMIN_USER_PRE + user.getSuId().toString());
            if (oldToken != null && !StringUtils.empty(oldToken.toString())) {
                redisTemplate.delete(Constants.ADMIN_USER_PRE + user.getSuId().toString());
                redisTemplate.delete(Constants.ADMIN_TOKEN_PRE + oldToken.toString());
            }


            String accessToken = UUIDGenerator.getUUID();

            // 返回accessToken
            AccessToken accessTokenEntity = new AccessToken();
            accessTokenEntity.setAccess_token(accessToken);
            accessTokenEntity.setExpires_in(120);
            accessTokenEntity.setToken_type("bearer");
            accessTokenEntity.setUser_id(user.getSuId().longValue());
            redisTemplate.opsForValue()
                    .set(Constants.ADMIN_TOKEN_PRE + accessToken, user.getSuId().toString(),
                            Constants.ADMIN_TIME, TimeUnit.MILLISECONDS);
            redisTemplate.opsForValue()
                    .set(Constants.ADMIN_USER_PRE + user.getSuId().toString(), accessToken,
                            Constants.ADMIN_TIME, TimeUnit.MILLISECONDS);
//            iRedisDataService.set(accessToken,user.getSuId().toString(),Constants.ADMIN_TIME);
//            iRedisDataService.set(user.getSuId().toString(),accessToken,Constants.ADMIN_TIME);
            resultMsg = new ResultMsg<Object>(true, ResultCode.OK,
                    accessTokenEntity);
            HttpUtils.setSession(user.getSuId().toString(), strUsername);
            return resultMsg;
        } catch (Exception ex) {
            ex.printStackTrace();
            resultMsg = new ResultMsg<Object>(false,
                    ResultCode.SYSTEM_ERR, null);
            return resultMsg;
        }
    }

    @PostMapping("oauth/test")
    public ResultMsg<Object> test() {
//        List<Object> list = iRedisDataService.getAll();
//        System.out.print("111111"+list.get(0));
        return new ResultMsg<Object>(false,
                ResultCode.SYSTEM_ERR, null);

    }


    /**
     * @param userId
     * @return
     */
    @PostMapping("oauth/getSrvUser")
    public Object getSrvUser(@RequestParam("userId") Long userId) {
        SrvUser user = srvUserService.selectByPrimaryKey(userId);
        if (user == null) {
            return new ResultMsg<Object>(false,
                    ResultCode.USER_DOES_NOT_EXIST, null);
        }
        return new ResultMsg<Object>(true,
                ResultCode.OK, user);
    }
}
