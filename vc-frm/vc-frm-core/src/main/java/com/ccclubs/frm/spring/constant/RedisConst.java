package com.ccclubs.frm.spring.constant;

/**
 * redis常量
 *
 * @author jianghaiyang
 * @create 2018-01-04
 **/
public class RedisConst {
    /**
     * GB实时状态数据
     */
    public static final String REDIS_KEY_RT_STATES_HASH = "RT-STATUS-HASH:GB";
    public static final String REDIS_KEY_RT_STATES_ZSET = "RT-STATUS-ZSET:GB";

    /**
     * 指令记录全局ID生成器 csrId
     */
    public static final String REDIS_KEY_CSRID_GEN = "cmd:idgen";
    /**
     * 808指令流水号生成器 csrsId
     */
    public static final String REDIS_KEY_808_CSRSID_GEN = "cmd:sidgen";

}
