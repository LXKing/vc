package com.ccclubs.frm.spring.entity;

/**
 * 用户
 *
 * @author jianghaiyang
 * @create 2017-09-13
 **/
public class Subject {
    /*用户ID*/
    private Long userId;
    /*账号*/
    private String account;
    /*手机号*/
    private String mobile;
    /*昵称*/
    private String nickname;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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

    @Override
    public String toString() {
        return "Subject{" +
                "userId=" + userId +
                ", account='" + account + '\'' +
                ", mobile='" + mobile + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
