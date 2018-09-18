package com.ccclubs.admin.service;

import com.ccclubs.frm.base.BaseService;
import com.ccclubs.admin.model.CsCan;

/**
 * 车辆实时CAN信息的Service接口
 *
 * @author Joel
 */
public interface ICsCanService extends BaseService<CsCan, Long> {
    /**
     * 2018/9/18
     * 车辆数 state=null:全部，0不在线，1在线
     *
     * @param state
     * @return java.lang.Integer
     * @author machuanpeng
     */
    Integer getCarCount(Integer state);
}