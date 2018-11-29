package com.ccclubs.admin.orm.mapper;

import com.ccclubs.admin.dto.CsVehicleDto;
import com.ccclubs.frm.base.BaseDAO;
import com.ccclubs.admin.model.CsVehicle;

import java.util.List;
import java.util.Map;

/**
 * 车辆信息管理的Mapper实现
 *
 * @author Joel
 */
public interface CsVehicleMapper extends BaseDAO<CsVehicle, Integer> {
    /**
     * 解绑Tbox
     *
     * @param record
     * @mbg.generated
     */
    int unbindTbox(CsVehicle record);

    void insertBatchSelective(List<CsVehicle> list);

    void updateBatchByExampleSelective(List<CsVehicle> list);

    /**
     * 2018/9/18
     * 时间段内在线车辆
     *
     * @param params
     * @return void
     * @author machuanpeng
     */
    List<CsVehicle> getCarListWithTime(Map<String, Object> params);
    List<CsVehicleDto> getCarListWithTimeReport(Map<String, Object> params);
}
