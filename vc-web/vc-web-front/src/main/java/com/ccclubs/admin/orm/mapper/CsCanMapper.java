package com.ccclubs.admin.orm.mapper;

import com.ccclubs.admin.model.CsCan;
import com.ccclubs.frm.base.BaseDAO;

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
}
