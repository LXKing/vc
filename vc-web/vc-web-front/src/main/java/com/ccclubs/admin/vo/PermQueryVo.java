package com.ccclubs.admin.vo;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 权限查询
 *
 * @author jianghaiyang
 * @create 2018-04-24
 **/
public class PermQueryVo implements Serializable {
    @NotNull(message = "用户ID必填")
    private Long userid;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }
}
