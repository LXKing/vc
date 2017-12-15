package com.ccclubs.manage.dto;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA 2017.
 * Author: @author FengJun
 * Date: 2017/11/20
 * Time: 11:38
 * Email:fengjun@ccclubs.com
 */
public class EvLoginInput implements Serializable{


    private static final long serialVersionUID = -2460429043274542251L;
    private String username;
    private String password;
    private Short state=0;//表示希望执行的动作。0为登录，-1为登出，1为刷新


    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }

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
