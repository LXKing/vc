package com.ccclubs.command.inf.lock;

import com.ccclubs.command.dto.LockDoorInput;
import com.ccclubs.command.dto.LockDoorOutput;

/**
 * 车门落锁
 *
 * @author jianghaiyang
 * @create 2018-01-26
 **/
public interface LockDoorInf {
    /**
     * 车门落锁-带控制参数
     * @param input
     * @return
     */
    LockDoorOutput lockDoorWithCtrl(LockDoorInput input);
}
