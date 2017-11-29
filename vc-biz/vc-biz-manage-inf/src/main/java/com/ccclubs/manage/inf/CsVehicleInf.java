package com.ccclubs.manage.inf;

import com.ccclubs.manage.dto.CsVehicleInput;
import com.ccclubs.manage.dto.CsVehicleOutput;
import com.ccclubs.manage.orm.model.CsVehicleBiz;
import com.ccclubs.manage.orm.model.CsVehicle;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created with IntelliJ IDEA 2017.
 * Author: @author FengJun
 * Date: 2017/11/7
 * Time: 10:37
 * Email:fengjun@ccclubs.com
 */
public interface CsVehicleInf {
    PageInfo<CsVehicle> getCsVehiclePage(CsVehicleInput csVehicleInput);
    CsVehicleOutput getCsVehicleAll(CsVehicleInput csVehicleInput);
    List<Integer> getMachineIdListByVehicles(List<Integer> ids);
    List<CsVehicle> getVehiclesByIds(List<Integer> ids);

    List<CsVehicle> getVehicleList(CsVehicleInput csVehicleInput);


    CsVehicle getCsVehicleByCsMachineId(Integer id);
    CsVehicle getCsVehicleByCsVin(String csVin);
    CsVehicle getCsVehicleByCsCarNo(String csCarNo);

    /**
     * 删除的时候，只删除一个也当做批量删除。因为一个是批量的特殊情况。
     * 删除的时候要判断是否有权限。
     * 成功返回true，失败返回false
     * */
    boolean deleteCsVehicles(CsVehicleInput csVehicleInput);
    /**
     * 通过id是否为空来判断是插入还是更新。
     * 更新的时候需要更新到权限表cs_mapping。
     * 成功返回true，失败返回false
     * */
    boolean insertOrUpdateCsVehicle(CsVehicleInput csVehicleInput);

    public PageInfo<CsVehicleBiz> getCsVehicleBizPage(CsVehicleInput csVehicleInput);


}
