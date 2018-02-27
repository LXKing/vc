package com.ccclubs.influxdb.api;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccclubs.frm.spring.entity.ApiMessage;
import com.ccclubs.influxdb.inf.CarCanHistoryInf;
import com.ccclubs.influxdb.inf.CarGbHistoryInf;
import com.ccclubs.influxdb.inf.CarStateHistoryInf;
import com.ccclubs.influxdb.input.CarCanHistoryParam;
import com.ccclubs.influxdb.input.CarGbHistoryParam;
import com.ccclubs.influxdb.input.CarStateHistoryParam;
import com.ccclubs.influxdb.model.CarCan;
import com.ccclubs.influxdb.model.CarGb;
import com.ccclubs.influxdb.model.CarState;
import com.ccclubs.influxdb.version.InfluxdbServiceVersion;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import static org.springframework.http.ResponseEntity.ok;


/**
 * Created by Administrator on 2018/2/1 0001.
 */
@RefreshScope
@RestController
@RequestMapping("/history")
public class InfluxdbTest {

    @Reference(version = InfluxdbServiceVersion.V1)
    private CarCanHistoryInf carCanHistoryInf;

    @Reference(version = InfluxdbServiceVersion.V1)
    private CarGbHistoryInf carGbHistoryInf;


    @Reference(version = InfluxdbServiceVersion.V1)
    private CarStateHistoryInf carStateHistoryInf;


    @RequestMapping(value = "/write")
    public  ApiMessage<String>   writeList() {
        int count=100000;
//        //carCanHistory插入数据
//        List<CarCan> carCanList=new ArrayList<>();
//        CarCan carCan=null;
//        for (int i=0;i<count;i++){
//            carCan=new CarCan();
//            carCan.setCs_number("cs_number_"+i);
//            carCan.setAdd_time((long)i);
//            carCan.setCan_data("--"+i);
//            carCan.setCurrent_time((long)i);
//            carCanList.add(carCan);
//        }
//        carCanHistoryInf.insert(carCanList);
//        //
//        //canGb数据插入
//        List<CarGb> carGbList=new ArrayList<>();
//        CarGb carGb=null;
//        for (int i=0;i<count;i++){
//            carGb=new CarGb();
//            carGb.setCs_vin("cs_vin="+i);
//            carGb.setAdd_time(System.currentTimeMillis());
//            carGb.setCurrent_time(System.currentTimeMillis());
//            carGb.setGb_data("1010101");
//            carGb.setCs_access(1);
//            carGb.setCs_protocol(1);
//            carGb.setGb_type(1);
//            carGb.setCs_verify(1);
//            carGbList.add(carGb);
//        }
//        carGbHistoryInf.insert(carGbList);
        //
        //CarState数据插入


        CarState carState=null;
        for(int k=0;k<1;k++){
            List<CarState>  carStateList=new ArrayList<>();


        for (int i=0;i<count;i++){
            carState=new CarState();
            carState.setCs_number("cs_number_"+i);
            carState.setCs_access("1");
            carState.setAdd_time(System.currentTimeMillis());
            carState.setCurrent_time(System.currentTimeMillis());
            carState.setRent_flg(1);
            carState.setWarn_code("0");
            carState.setRfid("0");
            carState.setUser_rfid("u_id");
            carState.setObd_miles((double)1);
            carState.setEngine_tempe((double)1);
            carState.setTotal_miles((double)1);
            carState.setSpeed((double)1);
            carState.setMotor_speed((double)1);
            carState.setOil_cost((double)1);
            carState.setPower_reserve((double)1);
            carState.setEv_battery((double)1);
            carState.setCharging_status(1);
            carState.setFuel_miles((double)1);
            carState.setElec_miles((double)1);
            carState.setEndur_miles((double)1);
            carState.setTempe((double)1);
            carState.setGps_num(1);
            carState.setGps_strength(1);
            carState.setGps_valid(1);
            carState.setNet_strength(1);
            carState.setLatitude((double)1);
            carState.setLongitude((double)1);
            carState.setDirection_angle((double)1);
            carState.setCircular_mode(1);
            carState.setPtc_status(1);
            carState.setCompre_status(1);
            carState.setCurrent_datetime((long)1);
            carState.setFan_mode(1);
            carState.setSaving_mode(1);
            carState.setSaving_mode_str("1");
            carState.setDoor_status(1);
            carState.setEngine_status(1);
            carState.setKey_status(1);
            carState.setLight_status(1);
            carState.setLock_status(1);
            carState.setNet_type("1");
            carState.setBase_lac("1");
            carState.setBase_ci("1");
            carState.setCur_order("--");
            carState.setGear(1);
            carStateList.add(carState);
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                carStateHistoryInf.insert(carStateList);
            }
        }).start();

        }

        return new ApiMessage<String>("SUCCESS");
    }
    @ApiOperation(value="读取CarCan状态数据", notes="读取can状态数据")
    @RequestMapping(value = "/readCarCan", method = RequestMethod.GET)
    public ResponseEntity readCarCan(){
        List<CarCan> carCanHistoryParamList=new ArrayList<>();
        CarCanHistoryParam carCanHistoryParam=null;

            carCanHistoryParam=new CarCanHistoryParam();
            carCanHistoryParam.setCs_number("cs_number_"+1);

        carCanHistoryParamList= carCanHistoryInf.selectCarCanListByCondition(carCanHistoryParam);
        return ok(carCanHistoryParamList);
    }



    @RequestMapping(value = "/readCarGb", method = RequestMethod.GET)
    public ApiMessage readCarGb(){
        List<CarGb> carGbHistoryParamList=new ArrayList<>();
        CarGbHistoryParam carGbHistoryParam=null;
        for (int i=0;i<-1;i++){
            carGbHistoryParam=new CarGbHistoryParam();
            carGbHistoryParam.setCs_vin("");
        }
        carGbHistoryParamList= carGbHistoryInf.selectCarGbListByCondition(carGbHistoryParam);
        return  new ApiMessage<>(carGbHistoryParamList);
    }


    @RequestMapping(value = "/readCarState", method = RequestMethod.GET)
    public  ApiMessage readCarState(){
        List<CarState> carStateHistoryParamList=new ArrayList<>();
        CarStateHistoryParam carStateHistoryParam=null;
        for (int i=0;i<-1;i++){
            carStateHistoryParam=new CarStateHistoryParam();
        }
        carStateHistoryParamList= carStateHistoryInf.selectCarStateListByCondition(carStateHistoryParam);
        return new ApiMessage<>(carStateHistoryParamList);
    }
}
