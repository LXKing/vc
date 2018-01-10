package com.ccclubs.usr.inf;

import java.util.Map;

/**
 * 管理token
 *
 * @author jianghaiyang
 * @create 2017-09-13
 **/
public interface TokenManageInf {
    /**
     * 创建Token
     * @param account 账号
     * @param token
     */
    void saveToken(String account, String token);

    /**
     * 通过account获得对应的token
     * @param account 账号
     * @return
     */
    String getTokenByKey(String account);

    /**
     * 通过account删除Token
     * @param account 账号
     */
    void delTokenByKey(String account);

    /**
     * 解析Token
     * @param token
     */
    Map<String, Object> parseToken(String token, String appKey) throws Exception;
}
