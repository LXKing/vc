package com.ccclubs.gateway.jt808.api;

import com.ccclubs.gateway.common.connection.ClientSocketCollection;
import com.ccclubs.gateway.common.vo.response.Error;
import com.ccclubs.gateway.common.vo.response.OK;
import com.ccclubs.gateway.common.vo.response.R;
import com.ccclubs.protocol.util.StringUtils;
import io.netty.channel.socket.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.Set;

/**
 * @Author: yeanzi
 * @Date: 2018/6/11
 * @Time: 10:33
 * Email:  yeanzhi@ccclubs.com
 * 终端连接监控
 */
@RestController
@RequestMapping("/nio")
public class OverseeSocketChannelController {
    public static final Logger LOG = LoggerFactory.getLogger(OverseeSocketChannelController.class);

    @GetMapping("/count/all")
    public R countAllConnection() {
        int count = ClientSocketCollection.getAll();
        return OK.Statu.SUCCESS_WITH_DATA.build().addData("count", count);
    }

    @GetMapping("/{sim}/detail")
    public R getTerConnDetail(@PathVariable("sim") String sim) {
        if (StringUtils.notEmpty(sim)) {
            SocketChannel channel = ClientSocketCollection.getDetail(sim);
            if (Objects.nonNull(channel)) {
                return OK.Statu.SUCCESS_WITH_DATA.build().addData("channel", channel);
            } else {
                return Error.Statu.SIM_NOT_EXIST.build();
            }
        }
        return Error.Statu.SIM_EMPTY.build();
    }

    @GetMapping("/all/sim")
    public R getAllConnSIMSet() {
        Set<String> simSet = ClientSocketCollection.getAllUniqueNo();
        return OK.Statu.SUCCESS_WITH_DATA.build()
                .addData("total", simSet.size())
                .addData("sims", simSet);
    }

    @GetMapping("/all/disconnected")
    public R getAllDisconnected() {
        Set<String> simSet = ClientSocketCollection.getAllDisConnected();
        return OK.Statu.SUCCESS_WITH_DATA.build()
                .addData("total", simSet.size())
                .addData("sims", simSet);
    }
}
