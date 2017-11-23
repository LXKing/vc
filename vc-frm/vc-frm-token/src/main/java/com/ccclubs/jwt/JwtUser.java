package com.ccclubs.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Alban
 */
public abstract class JwtUser implements Serializable{

    private static final long serialVersionUID = 7360294571399953200L;
    private final Long id;
    private final String username;
    private final boolean enabled;
    private final Date lastPasswordResetDate;
    private String token;

    public JwtUser(
          Long id,
          String username,
          boolean enabled,
          Date lastPasswordResetDate
    ) {
        this.id = id;
        this.username = username;
        this.enabled = enabled;
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    @JsonIgnore
    public boolean isAccountNonExpired() {
        //TODO 从redis处理检查账号过期情况。
        return true;
    }

    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    public boolean isCredentialsNonExpired() {

        //TODO 从redis处理检查证书过期情况。
        return true;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isEnabled() {
        return enabled;
    }

    @JsonIgnore
    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

}
