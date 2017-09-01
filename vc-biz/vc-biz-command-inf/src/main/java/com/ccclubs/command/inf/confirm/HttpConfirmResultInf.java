package com.ccclubs.command.inf.confirm;

import com.ccclubs.command.dto.ConfirmInput;

/**
 * http方式确认指令结果
 *
 * @author jianghaiyang
 * @create 2017-07-25
 **/
public interface HttpConfirmResultInf {
    Object confirm(ConfirmInput input);
}
