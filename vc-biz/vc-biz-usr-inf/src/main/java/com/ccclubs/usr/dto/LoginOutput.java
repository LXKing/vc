package com.ccclubs.usr.dto;

import java.io.Serializable;

/**
 * 登录返回
 *
 * @author jianghaiyang
 * @create 2017-09-13
 **/
public class LoginOutput implements Serializable {
    /*账号*/
    private String account;
    /*token*/
    private String token;
    /*手机号*/
    private String mobile;
    /*昵称*/
    private String nickname;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
