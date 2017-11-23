package com.ccclubs.manage.dto;

import com.ccclubs.manage.model.CsManage;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA 2017.
 * Author: @author FengJun
 * Date: 2017/11/22
 * Time: 11:19
 * Email:fengjun@ccclubs.com
 */
public class CsManageOutput implements Serializable {


    private static final long serialVersionUID = -8409586763861609341L;
    private CsManage userInfo;//注意此对象应该清除其中的密码字段再返回。

    public CsManage getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(CsManage userInfo) {
        this.userInfo = userInfo;
    }
}
