package com.ccclubs.engine.core.util;

/**
 * redis key 拼装工具类
 *
 * @author jianghaiyang
 * @create 2017-07-06
 **/
public class AssembleHelper {

    public static String cmdKey(Long csrId) {
        return "OBJ." + RuleEngineConstant.REMOTE_REDIS_PRE + "." + csrId;
    }

    public static String mappingKey(String flag, String key) {
        return "KV." + flag + "." + key;
    }

    public static String getKey(String prefix, String unique) {
        return prefix + ":" + unique;
    }

}
