package com.ccclubs.gateway.gb.api;

import com.ccclubs.gateway.common.conn.ClientCache;
import com.ccclubs.gateway.common.vo.response.OK;
import com.ccclubs.gateway.common.vo.response.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    /**
     * 获取所有在线终端数
     * uniqueNo_client size
     * @return
     */
    @GetMapping("/count/all")
    public R countAllConnection() {
        int count = ClientCache.getAll();
        return OK.Statu.SUCCESS_WITH_DATA.build().addData("count", count);
    }

    /**
     * 主要验证终端在线数
     * channel_client size
     * @return
     */
    @GetMapping("/map/all")
    public R countAllChannelMapping() {
        int count = ClientCache.getAllMap();
        return OK.Statu.SUCCESS_WITH_DATA.build().addData("count", count);
    }

    /**
     * 获取所有连接上的终端的sim列表
     * @return
     */
    @GetMapping("/all/sim")
    public R getAllConnSIMSet() {
        Set<String> simSet = ClientCache.getAllUniqueNo();
        return OK.Statu.SUCCESS_WITH_DATA.build()
                .addData("total", simSet.size())
                .addData("sims", simSet);
    }

    /**
     * 获取所有掉线的终端信息
     * 一般终端掉线就不存在了，所以这个接口不实用
     * @return
     */
    @GetMapping("/all/disconnected")
    public R getAllDisconnected() {
        Set<String> simSet = ClientCache.getAllDisConnected();
        return OK.Statu.SUCCESS_WITH_DATA.build()
                .addData("total", simSet.size())
                .addData("sims", simSet);
    }
}
