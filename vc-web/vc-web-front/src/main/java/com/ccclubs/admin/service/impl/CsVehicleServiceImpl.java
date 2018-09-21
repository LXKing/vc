package com.ccclubs.admin.service.impl;

import com.ccclubs.admin.model.CsVehicle;
import com.ccclubs.admin.orm.mapper.BackCsVehicleMapper;
import com.ccclubs.admin.orm.mapper.CsVehicleMapper;
import com.ccclubs.admin.service.ICsVehicleService;
import com.ccclubs.frm.base.CrudService;
import com.ccclubs.protocol.util.StringUtils;
import com.ccclubs.pub.orm.page.PageInput;
import com.ccclubs.pub.orm.vo.VehicleMachineVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 车辆信息管理的Service实现
 *
 * @author Joel
 */
@Service
public class CsVehicleServiceImpl extends
        CrudService<CsVehicleMapper, CsVehicle, Integer> implements ICsVehicleService {

    @Resource
    BackCsVehicleMapper backDao;
    @Autowired
    CsVehicleMapper vehicleMapper;

    @Override
    public int unbindTbox(CsVehicle record) {
        return getDao().unbindTbox(record);
    }

    @Override
    public void insertBatchSelective(List<CsVehicle> list) {
        getDao().insertBatchSelective(list);
    }

    @Override
    public void updateBatchByExampleSelective(List<CsVehicle> list) {
        getDao().updateBatchByExampleSelective(list);
    }

    @Override
    public CsVehicle getVehicleInfo(String vin, Integer machineId) {

        if (vin == null && machineId == null) {
            return null;
        }
        CsVehicle csVehicle = new CsVehicle();
        if (vin != null) {
            csVehicle.setCsvVin(vin);
        }
        if (machineId != null) {
            csVehicle.setCsvMachine(machineId);
        }
        return getDao().selectOne(csVehicle);
    }

    /**
     * 根据用户分页查询名下车辆
     *
     * @param vo
     * @return
     */
    public PageInfo<VehicleMachineVo> queryVehicleMachineByPage(VehicleMachineVo vo, PageInput input) {
        PageHelper.startPage(input.getPage(), input.getRows());
        List<VehicleMachineVo> list = backDao.queryVehicleMachineByPage(vo);
        if (list == null || list.size() == 0) {
            return new PageInfo<>(new ArrayList<>());
        }
        return new PageInfo<>(list);
    }

    /**
     * 根据用户查询名下车辆
     *
     * @param vo
     * @return
     */
    @Override
    public List<VehicleMachineVo> queryVehicleMachineByUser(VehicleMachineVo vo) {
        return backDao.queryVehicleMachineByUser(vo);
    }

    @Override
    public PageInfo<CsVehicle> getCarListWithTime(String vin, Integer days) {
        Map<String, Object> params = new HashMap<>();
        if (!StringUtils.empty(vin)) {
            params.put("vin", vin);
        }
        params.put("days", days);
        List<CsVehicle> list = vehicleMapper.getCarListWithTime(params);
        return new PageInfo<>(list);
    }

    @Override
    public List<CsVehicle> getAllCarListWithTime(String vin, Integer days) {
        Map<String, Object> params = new HashMap<>();
        if (!StringUtils.empty(vin)) {
            params.put("vin", vin);
        }
        params.put("days", days);
        List<CsVehicle> list = vehicleMapper.getCarListWithTime(params);
        return list;
    }
}