package com.ccclubs.jwt;

import com.ccclubs.jwt.JwtUser;

import java.util.Date;

/**
 * Created with IntelliJ IDEA 2017.
 * Author: @author FengJun
 * Date: 2017/11/21
 * Time: 10:58
 * Email:fengjun@ccclubs.com
 */
public class JwtManage extends JwtUser {

    private static final long serialVersionUID = -7252731408648475567L;
    private  String csm_name;
    private  Integer csm_id;

    public JwtManage(Long id, String username, boolean enabled, Date lastPasswordResetDate, String csm_name, Integer csm_id) {
        super(id, username, enabled, lastPasswordResetDate);
        this.csm_name = csm_name;
        this.csm_id = csm_id;
    }

    @Deprecated
    public JwtManage(Long id, String username, boolean enabled, Date lastPasswordResetDate) {
        super(id, username, enabled, lastPasswordResetDate);
    }

    public String getCsm_name() {
        return csm_name;
    }

    public void setCsm_name(String csm_name) {
        this.csm_name = csm_name;
    }

    public Integer getCsm_id() {
        return csm_id;
    }

    public void setCsm_id(Integer csm_id) {
        this.csm_id = csm_id;
    }

}
