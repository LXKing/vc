package com.ccclubs.command.util;

/**
 * cmd redis key 拼装工具类
 *
 * @author jianghaiyang
 * @create 2017-07-06
 **/
public class AssembleHelper {

    public static String assembleKey(Long csrId) {
        return CommandConstants.REMOTE_REDIS_PRE + csrId;
    }

    public static String get(String flag, String key) {
        return "KV." + flag + "." + key;
    }

}
