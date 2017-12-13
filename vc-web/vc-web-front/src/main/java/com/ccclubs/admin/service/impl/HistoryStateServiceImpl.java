package com.ccclubs.admin.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ccclubs.admin.query.HistoryStateQuery;
import com.ccclubs.admin.vo.Page;
import com.ccclubs.admin.vo.TableResult;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.entity.ApiMessage;
import com.ccclubs.frm.spring.entity.DateTimeUtil;
import com.ccclubs.phoenix.orm.model.CarState;
import com.ccclubs.phoenix.output.CarStateHistoryOutput;
import com.github.pagehelper.PageInfo;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ccclubs.admin.model.HistoryState;
import com.ccclubs.admin.service.IHistoryStateService;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 车辆状态历史数据的Service实现
 * @author Joel
 */
@Service
public class HistoryStateServiceImpl implements IHistoryStateService{




    @Value("${hbaseSrv.host:101.37.178.63}")
    private String host;
    @Value("${hbaseSrv.urlPathState:/history/states-internal}")
    private String urlPath;

    @Override
    public TableResult<HistoryState> getPage(HistoryStateQuery query,
                                             Integer pageNo, Integer pageSize,String order) {
        ApiMessage<CarStateHistoryOutput> apiMessage;
        TableResult<HistoryState> result=new TableResult<>();
        Page page=new Page(0,pageSize,0);
        result.setData(new ArrayList<>());
        result.setPage(page);

        String startTime= DateTimeUtil.getDateTimeByFormat1(query.getCurrentTimeStart().getTime());
        String endTime= DateTimeUtil.getDateTimeByFormat1(query.getCurrentTimeEnd().getTime());
        try {
            apiMessage=this.queryCarStateListFromHbase(query.getCsNumberEquals(),
                    startTime,endTime,
                    pageNo,pageSize,order);
            if(apiMessage!=null&&apiMessage.getCode()== ApiEnum.SUCCESS.code()){
                if (apiMessage.getData()!=null){
                    if (apiMessage.getData().getTotal()>0){
                        List<CarState> carStateList=apiMessage.getData().getList();
                        page=new Page(pageNo,pageSize,apiMessage.getData().getTotal());
                        result.setData(dealCarStateToHistoryStateAll(carStateList));
                        result.setPage(page);
                    }
                    else {
                        //没有查询到数据
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    private static HistoryState dealCarStateToHistoryState(CarState carState){
        if (null!=carState){
            HistoryState historyState=new HistoryState();
            historyState.setAddTime(carState.getAdd_time());
            historyState.setBaseCi(carState.getBase_ci());
            historyState.setBaseLac(carState.getBase_lac());
            historyState.setChargingStatus(carState.getCharging_status());
            historyState.setCurrentTime(carState.getCurrent_time());
            historyState.setCircularMode(carState.getCircular_mode());
            historyState.setCompreStatus(carState.getCompre_status());
            historyState.setCsAccess(carState.getCs_access());
            historyState.setCsNumber(carState.getCs_number());
            historyState.setCurOrder(carState.getCur_order());
            historyState.setDirectionAngle(carState.getDirection_angle());
            historyState.setDoorStatus(carState.getDoor_status());
            historyState.setElecMiles(carState.getElec_miles());
            historyState.setEndurMiles(carState.getEndur_miles());
            historyState.setEngineStatus(carState.getEngine_status());
            historyState.setEngineTempe(carState.getEngine_tempe());
            historyState.setEvBattery(carState.getEv_battery());
            historyState.setFanMode(carState.getFan_mode());
            historyState.setFuelMiles(carState.getFuel_miles());
            historyState.setGpsNum(carState.getGps_num());
            historyState.setGpsStrength(carState.getGps_strength());
            historyState.setGpsValid(carState.getGps_valid());
            historyState.setKeyStatus(carState.getKey_status());
            historyState.setlatitude(carState.getLatitude());
            historyState.setLightStatus(carState.getLight_status());
            historyState.setLockStatus(carState.getLock_status());
            historyState.setlongitude(carState.getLongitude());
            historyState.setMotorSpeed(carState.getMotor_speed());
            historyState.setNetStrength(carState.getNet_strength());
            historyState.setNetType(carState.getNet_type());
            historyState.setObdMiles(carState.getObd_miles());
            historyState.setOilCost(carState.getOil_cost());
            historyState.setPowerReserve(carState.getPower_reserve());
            historyState.setPtcStatus(carState.getPtc_status());
            historyState.setRentFlg(carState.getRent_flg());
            historyState.setrfid(carState.getRfid());
            historyState.setSavingMode(carState.getSaving_mode());
            historyState.setspeed(carState.getSpeed());
            historyState.settempe(carState.getTempe());
            historyState.setTotalMiles(carState.getTotal_miles());
            historyState.setUserRfid(carState.getUser_rfid());
            historyState.setWarnCode(carState.getWarn_code());
            historyState.setgear(carState.getGear());
            return historyState;
        }
        else {
            return null;
        }
    }



    private static List<HistoryState> dealCarStateToHistoryStateAll(List<CarState> carStateList){
        if (null!=carStateList&&carStateList.size()>0){
            List<HistoryState> historyStateList=new ArrayList<>();
            for (CarState carState :carStateList){
                historyStateList.add(dealCarStateToHistoryState(carState));
            }
            return historyStateList;
        }
        else {
            return null;
        }

    }


    private ApiMessage<CarStateHistoryOutput> queryCarStateListFromHbase(String csNumber,String startTime,
                                                                         String endTime,Integer pageNo,
                                                                         Integer pageSize,String order) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //114.55.173.208:7002  127.0.0.1:8888 101.37.178.63
        HttpGet httpGet=new HttpGet();
        httpGet.setHeader("Content-Type", "application/json;charset=utf-8");
        String param="?cs_number="+csNumber.trim()
                +"&start_time="+startTime.trim()
                +"&end_time="+endTime.trim()
                +"&query_fields=*"
                +"&order="+order.trim()
                +"&page_no="+pageNo
                +"&page_size="+pageSize;
        param=param.replaceAll(" ","%20");
        String url="http://"+host+urlPath;
        URI uri=URI.create(url+param);
        httpGet.setURI(uri);
        CloseableHttpResponse response = httpclient.execute(httpGet);
       return this.checkResponse(response);

    }

    private ApiMessage<CarStateHistoryOutput> checkResponse(CloseableHttpResponse response)
            throws IOException,Exception {
        ApiMessage<CarStateHistoryOutput> apiMessage=null;
        try {
            //System.out.println(response.getStatusLine());
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                HttpEntity entity = response.getEntity();
                String result = IOUtils.toString(entity.getContent(), "UTF-8");
                //System.out.println(result);
                apiMessage=JSON.parseObject(result, new TypeReference<ApiMessage<CarStateHistoryOutput>>() {});
                EntityUtils.consume(entity);
            }

        } finally {
            response.close();
        }
        return apiMessage;
    }
}