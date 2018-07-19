package com.ccclubs.command.util;

/**
 * 指令执行结果 redis key
 *
 * @author jianghaiyang
 * @create 2017-07-06
 **/
public class AssembleHelper {

    /**
     * 获取集合的key
     * @param csrId
     * @return
     */
    public static String assembleKey(Long csrId) {
        return CommandConstants.REMOTE_REDIS_PRE + csrId;
    }

}
