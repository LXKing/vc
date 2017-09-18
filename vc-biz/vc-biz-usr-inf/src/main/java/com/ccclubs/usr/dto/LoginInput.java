package com.ccclubs.usr.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 登录
 *
 * @author jianghaiyang
 * @create 2017-09-13
 **/
public class LoginInput implements Serializable {
    /*账号*/
    @NotNull
    @Length(min = 1, max = 11)
    private String account;
    /*密码*/
    @NotNull
    @Length(min = 1)
    private String password;

    private String appId;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}
