package com.ccclubs.command.inf.confirm;

import com.ccclubs.command.dto.ConfirmInput;

/**
 * http方式确认指令结果
 *
 * @author jianghaiyang
 * @create 2017-07-25
 **/
public interface HttpConfirmResultInf {
    /**
     * 指令确认
     * @param input
     * @return
     */
    Object confirm(ConfirmInput input);
}
