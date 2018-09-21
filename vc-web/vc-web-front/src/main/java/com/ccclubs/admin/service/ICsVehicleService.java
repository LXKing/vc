package com.ccclubs.admin.service;

import com.ccclubs.admin.model.CsVehicle;
import com.ccclubs.frm.base.BaseService;
import com.ccclubs.pub.orm.page.PageInput;
import com.ccclubs.pub.orm.vo.VehicleMachineVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 车辆信息管理的Service接口
 *
 * @author Joel
 */
public interface ICsVehicleService extends BaseService<CsVehicle, Integer> {
    int unbindTbox(CsVehicle record);

    void insertBatchSelective(List<CsVehicle> list);

    void updateBatchByExampleSelective(List<CsVehicle> list);

    //通过vin码，找到一条符合要求的数据
    CsVehicle getVehicleInfo(String vin, Integer machineId);

    /**
     * 根据用户查询名下车辆
     *
     * @param vo
     * @return
     */
    PageInfo<VehicleMachineVo> queryVehicleMachineByPage(VehicleMachineVo vo, PageInput input);

    /**
     * 根据用户查询名下车辆
     *
     * @param vo
     * @return
     */
    List<VehicleMachineVo> queryVehicleMachineByUser(VehicleMachineVo vo);

    /**
     * 2018/9/18
     * 时间段内在线车辆
     *
     * @param vin
     * @param days
     * @return java.util.List<com.ccclubs.admin.model.CsVehicle>
     * @author machuanpeng
     */
    PageInfo<CsVehicle> getCarListWithTime(String vin, Integer days);
    /**
     * 2018/9/21
     * 时间段内在线所有辆
     *
     * @param vin
     * @param days
     * @return java.util.List<com.ccclubs.admin.model.CsVehicle>
     * @author machuanpeng
     */
    List<CsVehicle> getAllCarListWithTime(String vin, Integer days);
}