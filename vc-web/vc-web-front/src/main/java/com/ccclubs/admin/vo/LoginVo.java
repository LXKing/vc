package com.ccclubs.admin.vo;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 登录参数
 *
 * @author jianghaiyang
 * @create 2018-04-24
 **/
public class LoginVo implements Serializable {
    @NotNull(message = "用户名必填")
    private String username;
    @NotNull(message = "用户密码必填")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
