package com.ccclubs.phoenix.api;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccclubs.frm.spring.annotation.ApiSecurity;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.entity.ApiMessage;
import com.ccclubs.frm.spring.entity.DateTimeUtil;
import com.ccclubs.phoenix.inf.MqttStateHistoryInf;
import com.ccclubs.phoenix.input.MqttStateParam;
import com.ccclubs.phoenix.output.MqttStateHistoryOutput;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/5/14
 * @Time: 15:35
 * @Description: 请填写描述！
 */
@RestController
@CrossOrigin
@RequestMapping("history")
public class PhoenixHistoryApi {

    private static final Logger logger= LoggerFactory.getLogger(PhoenixHistoryApi.class);
    private static final long ONE_MOUTH=2592000000L;
    private static final long ONE_WEEK=604800000L;
    @Reference(version = "1.0.0")
    MqttStateHistoryInf mqttStateHistoryService;

    @ApiSecurity
    @RequestMapping(value = "/getMqttStates",method = RequestMethod.POST)
    public ApiMessage<MqttStateHistoryOutput> queryCarStateList(
            @RequestBody MqttStateParam param){
        logger.info("we get a request form getMqttStates:"+param.toString());
        if (this.paramTimeCheck(param.getStartTime(),param.getEndTime())){
            logger.info("we find a states request. 查询间隔过长。");
            return new ApiMessage<>(100003,
                    ApiEnum.REQUEST_PARAMS_VALID_FAILED.msg()+"查询间隔过长");
        }
        if (StringUtils.isEmpty(param.getVin())
                &&StringUtils.isEmpty(param.getTeNumber())){
            logger.info("we find a PARAMS_VALID_FAILED at getMqttStates.");
            return new ApiMessage<>(100003,
                    ApiEnum.REQUEST_PARAMS_VALID_FAILED.msg());
        }
        logger.debug("we receive a getMqttStates post request."+param.toString());
        String pointQueryKey;
        if (StringUtils.isEmpty(param.getVin())){
            pointQueryKey=param.getTeNumber();
        }else {
            pointQueryKey=param.getVin();
        }


        if (!paramCheck(pointQueryKey,
                param.getStartTime(),
                param.getEndTime(),
                param.getPageNum(),
                param.getPageSize()))
        {
            return new ApiMessage<>(100003,
                    ApiEnum.REQUEST_PARAMS_VALID_FAILED.msg());
        }

        MqttStateHistoryOutput mqttStateHistoryOutput=
                mqttStateHistoryService.queryListByParam(param);

        return new ApiMessage<>(mqttStateHistoryOutput);

    }

    /**
     * 检查查询的时间，其查询的间隔不能过长。
     * */
    private boolean paramTimeCheck(String startTime,String endTime){
        boolean flag =false;//false为验证通过。
        long startTimeLong= DateTimeUtil.date2UnixFormat(startTime,DateTimeUtil.UNIX_FORMAT);
        long endTimeLong=DateTimeUtil.date2UnixFormat(endTime,DateTimeUtil.UNIX_FORMAT);
        long timeLong=endTimeLong-startTimeLong;
        if(timeLong>ONE_MOUTH){
            flag=true;
        }
        return flag;
    }

    private boolean paramCheck(String pointQueryKey,String startTime,String endTime,Integer pageNo,Integer pageSize){
        if (null==pointQueryKey||null==endTime||null==startTime){return false;}
        if (pointQueryKey.isEmpty()||endTime.isEmpty()||startTime.isEmpty()){return false;}
        //if (pageNo<-1||pageNo==0){return false;}
        //if (pageSize<=0){return false;}
        //if (pageSize>5000){return false;}
        try {
            DateTimeUtil.date2UnixFormat(startTime,DateTimeUtil.UNIX_FORMAT);
            DateTimeUtil.date2UnixFormat(endTime,DateTimeUtil.UNIX_FORMAT);
        }catch (Exception e){
            return false;
        }
        return true;
    }

}
