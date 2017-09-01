package com.ccclubs.command.process;

import com.ccclubs.mongodb.orm.model.CsRemote;
import com.ccclubs.pub.orm.model.CsMachine;

public interface CommandProcessInf {

  /**
   * 主要用于终端升级
   * @param csMachine 待下发指令的终端
   * @param srcArray 待下发的指令字节数组
   * @param isUpdate 是升级指令
   */
  void dealRemoteCommand(CsMachine csMachine, byte[] srcArray,boolean isUpdate);

  void dealRemoteCommand(CsRemote remote, Object[] array);
}
