package com.ccclubs.admin.service;

import com.ccclubs.protocol.dto.gb.GBMessage;
import com.github.pagehelper.PageInfo;

/**
 * 国标实时状态
 *
 * @author jianghaiyang
 * @create 2018-01-04
 **/
public interface IGbCsStateService {
    /**
     * 分页
     * @param t
     * @param page
     * @param rows
     * @return
     */
    PageInfo<GBMessage> getPage(Object t, int page, int rows);

    /**
     * 详情
     * @param vin
     * @return
     */
    GBMessage detail(String vin);
}
