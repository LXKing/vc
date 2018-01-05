package com.ccclubs.admin.controller;

import com.ccclubs.admin.service.IGbCsStateService;
import com.ccclubs.admin.vo.TableResult;
import com.ccclubs.protocol.dto.gb.GBMessage;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 车辆实时监控（国标协议）
 *
 * @author jianghaiyang
 * @create 2018-01-04
 **/
@RestController
@RequestMapping("monitor/gbState")
public class GbCsStateController {

    @Autowired
    IGbCsStateService igbCsStateService;

    /**
     * 获取分页列表数据
     *
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public TableResult<GBMessage> list(@RequestParam(defaultValue = "1") Integer page,
                                       @RequestParam(defaultValue = "10") Integer rows) {
        PageInfo<GBMessage> pageInfo = igbCsStateService.getPage(null, page, rows);
        TableResult<GBMessage> r = new TableResult<>(pageInfo);
        return r;
    }

    /**
     * 获取分页列表数据
     *
     * @param vin
     * @return
     */
    @RequestMapping(value = "detail/{vin}", method = RequestMethod.GET)
    public GBMessage detail(@PathVariable("vin") String vin) {
        GBMessage gbMessage = igbCsStateService.detail(vin);
        return gbMessage;
    }

}
