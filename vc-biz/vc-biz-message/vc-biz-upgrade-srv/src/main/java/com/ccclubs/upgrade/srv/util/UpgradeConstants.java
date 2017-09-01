package com.ccclubs.upgrade.srv.util;

/**
 * @author jianghaiyang
 * @create 2017-08-15
 **/
public class UpgradeConstants {
    /*升级请求队列*/
    public static final String REDIS_KEY_REQ_QUEUE = "upgrades:req";
    /*当前处理队列（为了判断升级是否成功，引入处理队列，通过查询终端的当前版本是否最新来确认升级进度） TODO 终端升级完成应该主动推送成功消息*/
    public static final String REDIS_KEY_PROC_QUEUE = "upgrades:proc";
    /*当前升级处理计数器*/
    public static final String REDIS_KEY_PROC_COUNT = "upgrades:count";
    /*定时自动升级列表*/
    public static final String REDIS_KEY_AUTO_QUEUE = "upgrades:auto";
    /*处理队列控制*/
    public static final long UPGRADE_LIMIT = 50;
    /*升级处理超时时间 10min*/
    public static final long UPGRADE_TIMEOUT = 600000;
}
