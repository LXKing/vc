package com.ccclubs.gateway.gb.api;

import com.ccclubs.gateway.common.bean.attr.ChannelStatusAttr;
import com.ccclubs.gateway.common.bean.attr.DefaultChannelHealthyAttr;
import com.ccclubs.gateway.common.bean.attr.PackageTraceAttr;
import com.ccclubs.gateway.common.conn.ClientCache;
import com.ccclubs.gateway.common.util.ChannelAttributeUtil;
import com.ccclubs.gateway.common.vo.response.Error;
import com.ccclubs.gateway.common.vo.response.OK;
import com.ccclubs.gateway.common.vo.response.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author Andaren
 * email   603822061@qq.com
 * @date 2018/9/15 下午1:52
 * description: 渠道共享数据api层
 *              提供 channnel-healthy：   渠道健康数据
 *                  channel-status：     渠道状态数据
 *                  channel-pac-trace：  渠道当前包解析情况
 *                  数据查询
 * version : v1.0
 * update_log:
 * date[更新日期] time[更新时间] updater[更新人]     for[原因]
 */
@RestController
@RequestMapping("/attr")
public class ChannelAttributeController {

    @GetMapping("/{uniqueNo}/healthy")
    public R healthy(@PathVariable("uniqueNo") String uniqueNo) {
        Optional<ClientCache> clientOpt = ClientCache.getByUniqueNo(uniqueNo);
        if (clientOpt.isPresent()) {
            DefaultChannelHealthyAttr channelHealthyAttr = ChannelAttributeUtil.getHealthy(clientOpt.get().getChannel());
            return OK.Statu.SUCCESS_WITH_DATA.build().addData("healtyAttr", channelHealthyAttr);
        } else {
            return Error.Statu.UNIQUENO_NOT_EXIST.build();
        }
    }

    @GetMapping("/{uniqueNo}/status")
    public R status(@PathVariable("uniqueNo") String uniqueNo) {
        Optional<ClientCache> clientOpt = ClientCache.getByUniqueNo(uniqueNo);
        if (clientOpt.isPresent()) {
            ChannelStatusAttr channelStatusAttr = ChannelAttributeUtil.getStatus(clientOpt.get().getChannel());
            return OK.Statu.SUCCESS_WITH_DATA.build().addData("statusAttr", channelStatusAttr);
        } else {
            return Error.Statu.UNIQUENO_NOT_EXIST.build();
        }
    }

    @GetMapping("/{uniqueNo}/pactrace")
    public R pactrace(@PathVariable("uniqueNo") String uniqueNo) {
        Optional<ClientCache> clientOpt = ClientCache.getByUniqueNo(uniqueNo);
        if (clientOpt.isPresent()) {
            PackageTraceAttr packageTraceAttr = ChannelAttributeUtil.getTrace(clientOpt.get().getChannel());
            return OK.Statu.SUCCESS_WITH_DATA.build().addData("pactraceAttr", packageTraceAttr);
        } else {
            return Error.Statu.UNIQUENO_NOT_EXIST.build();
        }
    }
}
