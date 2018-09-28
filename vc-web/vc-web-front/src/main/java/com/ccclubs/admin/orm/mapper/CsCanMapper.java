package com.ccclubs.admin.orm.mapper;

import com.ccclubs.admin.model.CsCan;
import com.ccclubs.frm.base.BaseDAO;

import java.util.Map;

/**
 * 车辆实时CAN信息的Mapper实现
 *
 * @author Joel
 */
public interface CsCanMapper extends BaseDAO<CsCan, Long> {
    /**
     * 2018/9/18
     * 车辆数 state=null:全部，0不在线，1在线
     *
     * @param state
     * @return java.lang.Integer
     * @author machuanpeng
     */
    Integer getCarCount(Integer state);

    /**
     * 2018/9/18
     * 时间段内在线车辆
     *
     * @param params
     * @return void
     * @author machuanpeng
     */
    void getCarListWithTime(Map<String, Object> params);
}
