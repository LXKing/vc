package com.ccclubs.command.inf.old;

import com.ccclubs.command.dto.StorageRemoteCmdInput;
import com.ccclubs.command.dto.StorageRemoteCmdOutput;

/**
 * @version 1.0.0
 * @time 2018/8/21
 * @auther Alban
 * @email fengjun@ccclubs.com
 * @description 将远程日志操作记录存储到持久层！
 */
public interface StorageRemoteCmdInf {

    /**
     * 将指令存储到mongo
     * */
    StorageRemoteCmdOutput saveRemoteCmdToMongo(StorageRemoteCmdInput input);

}
