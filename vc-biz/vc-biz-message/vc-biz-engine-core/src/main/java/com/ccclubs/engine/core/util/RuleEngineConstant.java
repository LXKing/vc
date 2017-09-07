package com.ccclubs.engine.core.util;

/**
 * Created by qsxiaogang on 2017/7/7.
 */
public class RuleEngineConstant {

    public static final String REDIS_KEY_VIN = "mappings:vin";
    public static final String REDIS_KEY_SIMNO = "mappings:simno";
    public static final String REDIS_KEY_CARNUM = "mappings:carnum";
    public static final String REDIS_KEY_TENO = "mappings:teno";
    public static final String REDIS_KEY_NOT_EXIST = "not-exist:";
    /*指令执行结果*/
    public static final String REDIS_KEY_CMD_REMOTE = "cmd:";

    public static final String REDIS_KEY_CAN2STATE = "Can2State";
    public static final String REDIS_KEY_MANCHINE = "CsMachine";
    public static final String REDIS_KEY_VEHICLE = "CsVehicle";


    public static final String REDIS_NAME = "ccclubs.redis.0";
    public static final String REDIS_FLAG = "NOT_EXIST.";
    public static final int REDIS_EXPIRE = 30 * 24 * 60 * 60;
    public static final int RENOTE_EXPIRE = 30;
    public static final String REMOTE_REDIS_PRE = "remoteOrder";
}
