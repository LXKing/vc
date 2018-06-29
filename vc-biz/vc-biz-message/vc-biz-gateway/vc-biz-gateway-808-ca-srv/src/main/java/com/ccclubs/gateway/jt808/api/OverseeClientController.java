package com.ccclubs.gateway.jt808.api;

import com.ccclubs.gateway.common.connection.ChannelMappingCollection;
import com.ccclubs.gateway.common.vo.response.Error;
import com.ccclubs.gateway.common.vo.response.OK;
import com.ccclubs.gateway.common.vo.response.R;
import com.ccclubs.gateway.jt808.process.conn.JTClientConn;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
@RequestMapping("/conn")
public class OverseeClientController {
    public static final Logger LOG = LoggerFactory.getLogger(OverseeClientController.class);




    @GetMapping("/count/all")
    public R countAllConnection() {
        int countAll = ChannelMappingCollection.getAllConn();

        return OK.Statu.SUCCESS_WITH_DATA.build().addData("count", countAll);
    }

    @GetMapping("/{sim}/detail")
    public R getTerConnDetail(@PathVariable("sim") String sim) {
        if (StringUtils.isNotEmpty(sim)) {
            JTClientConn conn = (JTClientConn) ChannelMappingCollection.getByUniqueNo(sim);
            if (Objects.nonNull(conn)) {
                return OK.Statu.SUCCESS_WITH_DATA.build().addData("conn", conn);
            } else {
                return Error.Statu.SIM_NOT_EXIST.build();
            }
        }
        return Error.Statu.SIM_EMPTY.build();
    }

    @GetMapping("/all/empty")
    public R getAllChannelIdWithEmptyConnList() {
        List<String> emptyList = ChannelMappingCollection.getAllChannelIdWithEmptyConnList();
        return OK.Statu.SUCCESS_WITH_DATA.build().addData("emptyList", emptyList);
    }

    @GetMapping("/all/sim")
    public R getAllConnSIMSet() {
        Set<String> sims = ChannelMappingCollection.getAllConnSIM();
        return OK.Statu.SUCCESS_WITH_DATA.build().addData("sims", sims);
    }
}
