package com.ccclubs.manage.dto;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA 2017.
 * Author: @author FengJun
 * Date: 2017/11/22
 * Time: 10:13
 * Email:fengjun@ccclubs.com
 */
public class EvLoginOutput implements Serializable {


    private static final long serialVersionUID = -6586160723515116851L;
    private String token;



    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
