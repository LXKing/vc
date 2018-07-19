package com.ccclubs.gateway.jt808.api;

import com.ccclubs.gateway.common.vo.response.Error;
import com.ccclubs.gateway.common.vo.response.OK;
import com.ccclubs.gateway.common.vo.response.R;
import com.ccclubs.gateway.jt808.process.command.Command;
import com.ccclubs.gateway.jt808.service.CommandCache;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: yeanzi
 * @Date: 2018/7/18
 * @Time: 16:56
 * Email:  yeanzhi@ccclubs.com
 * 命令下发控制器
 */
@RestController
@RequestMapping("/cmd")
public class CommandController {

    @GetMapping("/open/{sim}")
    public R open(@PathVariable("sim")String sim) {
        if (CommandCache.isOpen()) {
            return Error.Statu.STATUS_INCORRECT.build();
        } else {
            CommandCache.open(sim);
            return OK.Statu.SUCCESS.build();
        }
    }

    @GetMapping("/close")
    public R close() {
        if (CommandCache.isOpen()) {
            CommandCache.close();
            return OK.Statu.SUCCESS.build();
        } else {
            return Error.Statu.STATUS_INCORRECT.build();
        }
    }

    @GetMapping("/all")
    public R cmdDetail() {
        if (CommandCache.isOpen()) {
            List<Command> cmds = CommandCache.getAllCmd();
            return OK.Statu.SUCCESS_WITH_DATA.build().addData("cmds", cmds);
        } else {
            return Error.Statu.STATUS_INCORRECT.build();
        }
    }
}
