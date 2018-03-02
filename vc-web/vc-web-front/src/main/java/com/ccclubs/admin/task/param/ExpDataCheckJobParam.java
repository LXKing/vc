package com.ccclubs.admin.task.param;

import java.io.Serializable;

/**
 * @author jianghaiyang
 * @create 2018-03-02
 **/
public class ExpDataCheckJobParam implements Serializable {
    private String username; //用户（数据范围）

    private String toEmail; //收件人

    private String ccEmail; //抄送收件人

    private String subject; //发送主题

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getCcEmail() {
        return ccEmail;
    }

    public void setCcEmail(String ccEmail) {
        this.ccEmail = ccEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
