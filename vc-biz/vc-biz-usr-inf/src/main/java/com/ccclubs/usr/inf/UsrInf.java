package com.ccclubs.usr.inf;

import com.ccclubs.usr.dto.LoginInput;
import com.ccclubs.usr.dto.LoginOutput;
import com.ccclubs.usr.orm.model.VcUsers;

/**
 * 用户api
 *
 * @author jianghaiyang
 * @create 2017-09-13
 **/
public interface UsrInf {
    LoginOutput login(LoginInput input);

    VcUsers queryUserByAccount(String account);
}
