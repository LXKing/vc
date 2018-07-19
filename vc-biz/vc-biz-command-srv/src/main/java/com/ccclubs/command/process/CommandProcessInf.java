package com.ccclubs.command.process;

import com.ccclubs.mongo.orm.model.remote.CsRemote;
import com.ccclubs.pub.orm.model.CsMachine;

public interface CommandProcessInf {

    /**
     * 主要用于终端升级
     *
     * @param csMachine 待下发指令的终端
     * @param srcArray  待下发的指令字节数组
     * @param isUpdate  是升级指令
     */
    void dealRemoteCommand(CsMachine csMachine, byte[] srcArray, boolean isUpdate);

    /**
     * 处理中导Http升级指令
     *
     * @param csMachine
     * @param srcArray
     */
    void dealZdHttpUpdateCommand(CsMachine csMachine, byte[] srcArray);

    /**
     * 处理远程命令
     * @param remote
     * @param array
     */
    void dealRemoteCommand(CsRemote remote, Object[] array);
}
