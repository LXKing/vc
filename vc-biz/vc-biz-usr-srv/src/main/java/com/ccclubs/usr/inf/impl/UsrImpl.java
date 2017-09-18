package com.ccclubs.usr.inf.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.entity.Subject;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.frm.spring.prop.AppIdAndKeyProp;
import com.ccclubs.usr.dto.LoginInput;
import com.ccclubs.usr.dto.LoginOutput;
import com.ccclubs.usr.inf.TokenManageInf;
import com.ccclubs.usr.inf.UsrInf;
import com.ccclubs.usr.orm.mapper.VcUsersMapper;
import com.ccclubs.usr.orm.model.VcUsers;
import com.ccclubs.usr.orm.model.VcUsersExample;
import com.ccclubs.usr.util.Constant;
import com.ccclubs.usr.util.JwtUtil;
import com.ccclubs.usr.version.UserServiceVersion;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户认证
 *
 * @author jianghaiyang
 * @create 2017-09-13
 **/
@Service(version = UserServiceVersion.V1)
public class UsrImpl implements UsrInf {

    private static Logger logger = LoggerFactory.getLogger(UsrImpl.class);

    @Resource
    private AppIdAndKeyProp appIdAndKeyProp;

    @Autowired
    VcUsersMapper userDao;

    @Autowired
    TokenManageInf tokenManager;

    @Override
    public LoginOutput login(LoginInput input) {
        try {
            VcUsers user = queryUserByAccount(input.getAccount());
            String appKey = appIdAndKeyProp.getSecurity().get(input.getAppId());

            if (null == user || !user.getPassword().equals(this.enc(input.getAccount().trim(), input.getPassword().trim()))) {
                throw new ApiException(ApiEnum.LOGIN_ERROR);
            }

            /*当前用户*/
            Subject subject = new Subject();
            BeanUtils.copyProperties(user, subject);

            /*生成token*/
            String token = JwtUtil.createJWT(user.getUserId().toString(), JSON.toJSONString(subject), Constant.TOKEN_TTL, appKey);

            tokenManager.saveToken(input.getAccount(), token);

            /*返回token*/
            LoginOutput output = new LoginOutput();

            output.setAccount(user.getAccount());
            output.setNickname(user.getNickname());
            output.setToken(token);
            return output;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApiException(ApiEnum.FAIL);
        }
    }

    @Override
    public VcUsers queryUserByAccount(String account) {
        VcUsersExample example = new VcUsersExample();
        VcUsersExample.Criteria criteria = example.createCriteria();
        criteria.andAccountEqualTo(account);
        List<VcUsers> list = userDao.selectByExample(example);
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    private String enc(String user, String pwd){
        String seed = DigestUtils.md5Hex(user +  pwd + user);
        return DigestUtils.md5Hex(pwd+seed);
    }
}
