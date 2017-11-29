package com.ccclubs.manage.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.manage.dto.CsStateInput;
import com.ccclubs.manage.dto.CsStateOutput;
import com.ccclubs.manage.inf.CsStateInf;
import com.ccclubs.manage.inf.CsVehicleInf;
import com.ccclubs.manage.orm.mapper.CsStateMapper;
import com.ccclubs.manage.orm.model.CsState;
import com.ccclubs.manage.orm.model.CsStateExample;
import com.ccclubs.manage.orm.model.CsVehicle;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA 2017.
 * Author: @author FengJun
 * Date: 2017/11/7
 * Time: 16:36
 * Email:fengjun@ccclubs.com
 */
@Service(version = "1.0.0")
public class CsStateInfImpl implements CsStateInf {

    @Resource
    private CsStateMapper csStateMapper;
    @Autowired
    private CsVehicleInf csVehicleService;



    @Override
    public PageInfo<CsState> getCsStatePage(CsStateInput csStateInput) {

        CsVehicle csVehicle=null;
        if (null!=csStateInput.getCsVin()){
            csVehicle=csVehicleService.getCsVehicleByCsVin(csStateInput.getCsVin());
        }
        if (null!=csStateInput.getCsCarNo()){
            csVehicle=csVehicleService.getCsVehicleByCsCarNo(csStateInput.getCsCarNo());
        }
        if (null!=csVehicle){
            if (csVehicle.getCsvAccess().equals(csStateInput.getCsAccess())){
                //if (null==csStateInput.getCsVehicleId())
                {
                    csStateInput.setCsVehicleId(csVehicle.getCsvId());
                }
            }
        }

        CsStateExample csStateExample=new CsStateExample();
        CsStateExample.Criteria criteria=csStateExample.createCriteria();
        if(StringUtils.isNotBlank(csStateInput.getCsNumber())){
            criteria.andCssNumberEqualTo(csStateInput.getCsNumber());
        }
        if (null!=csStateInput.getCsVehicleId()){
            criteria.andCssCarEqualTo(csStateInput.getCsVehicleId());
        }
        if(null!=csStateInput.getCsAccess()&&csStateInput.getCsAccess()>0){
            //TODO 权限处理应更换为token取值
            criteria.andCssAccessEqualTo(csStateInput.getCsAccess().byteValue());
        }
        if (null!=csStateInput.getId()){
            criteria.andCssIdEqualTo(csStateInput.getId());
        }
        int pageNum = null == csStateInput.getPageNum() ? 1 : csStateInput.getPageNum();
        int pageSize = null == csStateInput.getPageSize() ? 10 : csStateInput.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        PageHelper.orderBy("css_add_time DESC");
        List<CsState> csStateList=csStateMapper.selectByExample(csStateExample);
        PageInfo<CsState> pi=new PageInfo<>(csStateList);
        return pi;
    }



    @Override
    public CsStateOutput getCsStateAll(CsStateInput csStateInput) {
        CsStateOutput csStateOutput=new CsStateOutput();
        CsStateExample csStateExample=new CsStateExample();
        //TODO 权限处理
        CsStateExample.Criteria criteria=csStateExample.createCriteria();
        csStateOutput.setList(csStateMapper.selectByExample(csStateExample));

        return csStateOutput;
    }

    @Override
    public CsState getCsState(CsStateInput csStateInput) {
        CsVehicle csVehicle=null;
        if (null!=csStateInput.getCsVin()){
            csVehicle=csVehicleService.getCsVehicleByCsVin(csStateInput.getCsVin());
        }
        if (null!=csStateInput.getCsCarNo()){
            csVehicle=csVehicleService.getCsVehicleByCsCarNo(csStateInput.getCsCarNo());
        }
        if (null!=csVehicle){
            if (csVehicle.getCsvAccess().equals(csStateInput.getCsAccess())){
                //if (null==csStateInput.getCsVehicleId())
                {
                    csStateInput.setCsVehicleId(csVehicle.getCsvId());
                }
            }
        }

        CsStateExample csStateExample=new CsStateExample();
        CsStateExample.Criteria criteria=csStateExample.createCriteria();
        if(StringUtils.isNotBlank(csStateInput.getCsNumber())){
            criteria.andCssNumberEqualTo(csStateInput.getCsNumber());
        }
        if (null!=csStateInput.getCsVehicleId()){
            criteria.andCssCarEqualTo(csStateInput.getCsVehicleId());
        }
        if(null!=csStateInput.getCsAccess()&&csStateInput.getCsAccess()>0){
            //TODO 权限处理应更换为token取值
            criteria.andCssAccessEqualTo(csStateInput.getCsAccess().byteValue());
        }
        if (null!=csStateInput.getId()){
            criteria.andCssIdEqualTo(csStateInput.getId());
        }
        List<CsState> csStateList=csStateMapper.selectByExample(csStateExample);
        if (null!=csStateList&&csStateList.size()>0){
            return csStateList.get(0);
        }
        return null;
    }

    @Override
    public List<CsState> getCsStateList(CsStateInput csStateInput) {
        CsVehicle csVehicle=null;
        if (null!=csStateInput.getCsVin()){
            csVehicle=csVehicleService.getCsVehicleByCsVin(csStateInput.getCsVin());
        }
        if (null!=csStateInput.getCsCarNo()){
            csVehicle=csVehicleService.getCsVehicleByCsCarNo(csStateInput.getCsCarNo());
        }
        if (null!=csVehicle){
            if (csVehicle.getCsvAccess().equals(csStateInput.getCsAccess())){
                //if (null==csStateInput.getCsVehicleId())
                {
                    csStateInput.setCsVehicleId(csVehicle.getCsvId());
                }
            }
        }

        CsStateExample csStateExample=new CsStateExample();
        CsStateExample.Criteria criteria=csStateExample.createCriteria();
        if(StringUtils.isNotBlank(csStateInput.getCsNumber())){
            criteria.andCssNumberEqualTo(csStateInput.getCsNumber());
        }
        if (null!=csStateInput.getCsVehicleId()){
            criteria.andCssCarEqualTo(csStateInput.getCsVehicleId());
        }
        if(null!=csStateInput.getCsAccess()&&csStateInput.getCsAccess()>0){
            //TODO 权限处理应更换为token取值
            criteria.andCssAccessEqualTo(csStateInput.getCsAccess().byteValue());
        }
        if (null!=csStateInput.getId()){
            criteria.andCssIdEqualTo(csStateInput.getId());
        }
        if (null!=csStateInput.getCsNumberList()&&csStateInput.getCsNumberList().size()>0){
            criteria.andCssNumberIn(csStateInput.getCsNumberList());
        }
        if (null!=csStateInput.getCsCurrentTime()){
            criteria.andCssCurrentTimeGreaterThan(csStateInput.getCsCurrentTime());
        }


        List<CsState> csStateList=csStateMapper.selectByExample(csStateExample);
        if (null!=csStateList&&csStateList.size()>0){
            return csStateList;
        }
        return null;
    }
}
