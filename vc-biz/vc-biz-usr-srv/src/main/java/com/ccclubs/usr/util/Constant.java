package com.ccclubs.usr.util;

public class Constant {

	/**
	 * jwt 存活时间 Time to live 7 days
	 */
	public static final int TOKEN_TTL = 7*24*60*60*1000;  //单位：ms

	/**
	 * token 缓存
	 */
	public static final String REDIS_KEY_TOKEN = "token:";  //前缀

}
