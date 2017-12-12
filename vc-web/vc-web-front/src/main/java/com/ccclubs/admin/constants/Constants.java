package com.ccclubs.admin.constants;

/**
 ****************************
 * 版权所有：车厘子 所有权利
 * 创建日期: 2017-9-14
 * 创建作者：zkm
 * 类名称　：Constants.java
 * 版　　本：
 * 功　　能：
 * 最后修改：
 * 修改记录：
 *****************************
 */
public class Constants
{

    public final static String ADMIN_TOKEN_PRE = "Admin:user:id:";
    public final static String ADMIN_USER_PRE = "Admin:user:id:";

    /** 权限Token **/
    public final static String AUTH_TOKEN = "reset_token";

    /** 授权者 **/
    public final static String AUTH_WRITE = "authority_center";
    
    /** 请求者 **/
    public final static String ROLE_ADMIN="tp2017d62d0a7ef521";

    /** token标识 **/
    public final static String HEADER_TYPE = "typ";

    /** token类型 **/
    public final static String HEADER_JWT = "JWT";
    
    /** token对应的用户ID **/
    public final static String JWT_USERID = "user_id";
    
    /**admin时效半小时**/
    public final static long ADMIN_TIME = 1800000;
    
    /**admin-base64Security**/
    public final static String ADMIN_BASE64SECURITY = "08afb98e33f26ab1ae7dc7ca27fbd956";

    /**app会员标识**/
    public final static String  MEMBERID = "plapp_uid";

    /**失效时间**/
    public static final Long SESSION_LIFE_CYCLE = 60L * 60 * 24 * 7;

    /** 一级缓存 **/
    public static final String PL_APP_MEMBER_SESSION = "tk";

    /** 权限缓存 **/
    public static final String PL_AUTH_CENTER_SESSION = "auth";

    /** url缓存 **/
    public static final String PL_AUTH_URL_SESSION = "requstUrl";
    
    /** 存放需要校验权限的url **/
    public static final String AUTH_LIMIT_URL_SESSION = "limitPath";
    
    /** 存放需要校验权限的url **/
    public static final String CHECK_LIMIT = "checkLimit";
    
    /** 存放需要校验权限 **/
    public static final String USER_LIMIT = "userLimit";
}
