package com.ccclubs.manage.inf;

import java.util.List;

/**
 * Created with IntelliJ IDEA 2017.
 * Author: @author FengJun
 * Date: 2017/11/7
 * Time: 10:36
 * Email:fengjun@ccclubs.com
 */
public interface CsMappingInf {

    List<Integer> getVehicleIdsByUser(Integer csAccess);

    /**
     * csAccess对应csm_manage,csCar对应csm_car。
     * 成功返回true，失败返回false
     * */
    boolean addCsMapping(Integer csAccessId,Integer csCarId);

    /**
     * csAccess对应csm_manage,csCar对应csm_car。
     * 成功返回true，失败返回false
     * */
    boolean deleteCsMapping(Integer csAccessId,Integer csCarId);

}
