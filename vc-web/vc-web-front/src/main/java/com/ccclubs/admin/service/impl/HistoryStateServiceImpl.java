package com.ccclubs.admin.service.impl;


import com.alibaba.dubbo.config.annotation.Reference;
import com.ccclubs.admin.model.HistoryState;
import com.ccclubs.admin.query.HistoryStateQuery;
import com.ccclubs.admin.service.IHistoryStateService;
import com.ccclubs.admin.vo.Page;
import com.ccclubs.admin.vo.TableResult;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.entity.ApiMessage;
import com.ccclubs.frm.spring.entity.DateTimeUtil;
import com.ccclubs.phoenix.inf.MqttStateHistoryInf;
import com.ccclubs.phoenix.input.MqttStateParam;
import com.ccclubs.phoenix.orm.dto.MqttStateDto;
import com.ccclubs.phoenix.output.MqttStateHistoryOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 车辆状态历史数据的Service实现
 * @author Joel
 */
@Service
public class HistoryStateServiceImpl implements IHistoryStateService{

    Logger logger= LoggerFactory.getLogger(HistoryStateServiceImpl.class);

    @Reference(version = "1.0.0")
    MqttStateHistoryInf mqttStateHistoryService;


    @Override
    public TableResult<HistoryState> getPage(HistoryStateQuery query,
                                             Integer pageNo, Integer pageSize,String order) {
        ApiMessage<MqttStateHistoryOutput> apiMessage;
        TableResult<HistoryState> result=new TableResult<>();
        Page page=new Page(0,pageSize,0);
        result.setData(new ArrayList<>());
        result.setPage(page);

        String startTime= DateTimeUtil.getDateTimeByUnixFormat(query.getCurrentTimeStart().getTime());
        String endTime= DateTimeUtil.getDateTimeByUnixFormat(query.getCurrentTimeEnd().getTime());
        try {
            apiMessage=this.queryMqttStateListFromHbase(query.getCsVinEquals(),
                    startTime,endTime,
                    pageNo,pageSize,order);
            if(apiMessage!=null&&apiMessage.getCode()== ApiEnum.SUCCESS.code()){
                if (apiMessage.getData()!=null){
                    if (null!=apiMessage.getData().getTotal()
                            &&apiMessage.getData().getTotal()>0){
                        List<MqttStateDto> mqttStateDtoList=apiMessage.getData().getList();
                        page=new Page(pageNo,pageSize,apiMessage.getData().getTotal());
                        result.setData(dealMqttStateToHistoryStateAll(mqttStateDtoList));
                        result.setPage(page);
                    }
                    else if (null!=apiMessage.getData().getList()
                            &&apiMessage.getData().getList().size()>0){
                        List<MqttStateDto> mqttStateDtoList=apiMessage.getData().getList();
                        page=new Page(pageNo,pageSize,apiMessage.getData().getList().size());
                        result.setData(dealMqttStateToHistoryStateAll(mqttStateDtoList));
                        result.setPage(page);
                    }
                    else {
                        if (!(apiMessage.getData().getTotal() >0)){
                            page=new Page(pageNo,pageSize,0);
                        }
                        else {
                            page=new Page(pageNo,pageSize,apiMessage.getData().getTotal());
                        }

                        result.setData(new ArrayList<>());
                        result.setPage(page);
                        //没有查询到数据
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    private static HistoryState dealMqttStateToHistoryState(MqttStateDto mqttState){
        if (null!=mqttState){

            HistoryState historyState=new HistoryState();
            //BeanUtils.copyProperties(mqttState,historyState);
            historyState.setAddTime(mqttState.getAddTime());
            historyState.setBaseCi(mqttState.getBaseCi());
            historyState.setBaseLac(mqttState.getBaseLac());
            historyState.setChargingStatus(mqttState.getChargingStatus());
            historyState.setCurrentTime(mqttState.getCurrentTime());
            historyState.setCircularMode(mqttState.getCircularMode());
            historyState.setCompreStatus(mqttState.getCompreStatus());
            historyState.setCsAccess(mqttState.getAccess());
            historyState.setCsNumber(mqttState.getTeNumber());
            historyState.setCurOrder(mqttState.getCurOrder());
            historyState.setDirectionAngle(mqttState.getDirectionAngle());
            historyState.setDoorStatus(mqttState.getDoorStatus());
            historyState.setElecMiles(mqttState.getElecMiles());
            historyState.setEndurMiles(mqttState.getEndurMiles());
            historyState.setEngineStatus(mqttState.getEngineStatus());
            historyState.setEngineTempe(mqttState.getEngineTempe());
            historyState.setEvBattery(mqttState.getEvBattery());
            historyState.setFanMode(mqttState.getFanMode());
            historyState.setFuelMiles(mqttState.getFuelMiles());
            historyState.setGpsNum(mqttState.getGpsNum());
            historyState.setGpsStrength(mqttState.getGpsStrength());
            historyState.setGpsValid(mqttState.getGpsValid());
            historyState.setKeyStatus(mqttState.getKeyStatus());
            historyState.setLatitude(mqttState.getLatitude());
            historyState.setLightStatus(mqttState.getLightStatus());
            historyState.setLockStatus(mqttState.getLockStatus());
            historyState.setLongitude(mqttState.getLongitude());
            historyState.setMotorSpeed(mqttState.getMotorSpeed());
            historyState.setNetStrength(mqttState.getNetStrength());
            historyState.setNetType(mqttState.getNetType());
            historyState.setObdMiles(mqttState.getObdMiles());
            historyState.setOilCost(mqttState.getOilCost());
            historyState.setPowerReserve(mqttState.getPowerReserve());
            historyState.setPtcStatus(mqttState.getPtcStatus());
            historyState.setRentFlg(mqttState.getRentFlg());
            historyState.setRfid(mqttState.getRfid());
            historyState.setSavingMode(mqttState.getSavingMode());
            historyState.setSpeed(mqttState.getSpeed());
            historyState.setTempe(mqttState.getTempe());
            historyState.setTotalMiles(mqttState.getTotalMiles());
            historyState.setUserRfid(mqttState.getUserRfid());
            historyState.setWarnCode(mqttState.getWarnCode());
            historyState.setGear(mqttState.getGear());
            return historyState;
        }
        else {
            return null;
        }
    }



    private static List<HistoryState> dealMqttStateToHistoryStateAll(List<MqttStateDto> mqttStateDtoList){
        if (null!=mqttStateDtoList&&mqttStateDtoList.size()>0){
            List<HistoryState> historyStateList=new ArrayList<>();
            for (MqttStateDto mqttStateDto :mqttStateDtoList){
                historyStateList.add(dealMqttStateToHistoryState(mqttStateDto));
            }
            return historyStateList;
        }
        else {
            return null;
        }

    }


    private ApiMessage<MqttStateHistoryOutput> queryMqttStateListFromHbase(String vin,
                                                                           String startTime,
                                                                         String endTime,Integer pageNo,
                                                                         Integer pageSize,String order) throws Exception {
        MqttStateParam param=new MqttStateParam();
        param.setQueryFields("*");
        param.setVin(vin);
        param.setStartTime(startTime);
        param.setEndTime(endTime);
        param.setPageNum(pageNo);
        param.setPageSize(pageSize);
        param.setOrder(order);
        return  new ApiMessage<>(mqttStateHistoryService.queryListByParam(param));
    }


}