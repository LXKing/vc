package com.ccclubs.phoenix.api;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccclubs.frm.spring.annotation.ApiSecurity;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.entity.ApiMessage;
import com.ccclubs.frm.spring.entity.DateTimeUtil;
import com.ccclubs.phoenix.inf.CanHistoryInf;
import com.ccclubs.phoenix.inf.GbMessageHistoryInf;
import com.ccclubs.phoenix.inf.Jt808PositionHistoryInf;
import com.ccclubs.phoenix.inf.MqttStateHistoryInf;
import com.ccclubs.phoenix.input.CanParam;
import com.ccclubs.phoenix.input.GbMessageParam;
import com.ccclubs.phoenix.input.Jt808PositionParam;
import com.ccclubs.phoenix.input.MqttStateParam;
import com.ccclubs.phoenix.orm.dto.MqttStateDto;
import com.ccclubs.phoenix.output.CanHistoryOutput;
import com.ccclubs.phoenix.output.GbMessageHistoryOutput;
import com.ccclubs.phoenix.output.Jt808PositionHistoryOutput;
import com.ccclubs.phoenix.output.MqttStateHistoryOutput;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    private static final Logger logger = LoggerFactory.getLogger(PhoenixHistoryApi.class);
    private static final long ONE_MOUTH = 2592000000L;
    private static final long ONE_WEEK = 604800000L;

    @Reference(version = "1.0.0")
    MqttStateHistoryInf mqttStateHistoryService;
    @Reference(version = "1.0.0")
    Jt808PositionHistoryInf jt808PositionHistoryService;
    @Reference(version = "1.0.0")
    CanHistoryInf canHistoryService;
    @Reference(version = "1.0.0")
    GbMessageHistoryInf gbMessageHistoryService;

    @ApiSecurity
    @RequestMapping(value = "/getJt808Position", method = RequestMethod.POST)
    public ApiMessage<Jt808PositionHistoryOutput> queryJt808PositionList(
            @RequestBody Jt808PositionParam param) {
        logger.info("we get a request form getJt808Position:" + param.toString());
        if (this.paramTimeCheck(param.getStartTime(), param.getEndTime())) {
            logger.info("we find a getGbMessage request. 查询间隔过长。");
            return new ApiMessage<>(100003,
                    ApiEnum.REQUEST_PARAMS_VALID_FAILED.msg() + "查询间隔过长");
        }
        if (StringUtils.isEmpty(param.getVin())
                && StringUtils.isEmpty(param.getTeNumber())) {
            logger.info("we find a PARAMS_VALID_FAILED at getJt808Position.");
            return new ApiMessage<>(100003,
                    ApiEnum.REQUEST_PARAMS_VALID_FAILED.msg());
        }
        logger.debug("we receive a getJt808Position post request." + param.toString());
        String pointQueryKey;
        if (StringUtils.isEmpty(param.getVin())) {
            pointQueryKey = param.getTeNumber();
        } else {
            pointQueryKey = param.getVin();
        }


        if (!paramCheck(pointQueryKey,
                param.getStartTime(),
                param.getEndTime(),
                param.getPageNum(),
                param.getPageSize())) {
            return new ApiMessage<>(100003,
                    ApiEnum.REQUEST_PARAMS_VALID_FAILED.msg());
        }

        Jt808PositionHistoryOutput jt808PositionHistoryOutput =
                jt808PositionHistoryService.queryListByParam(param);

        return new ApiMessage<>(jt808PositionHistoryOutput);

    }

    @ApiSecurity
    @RequestMapping(value = "/getGbMessage", method = RequestMethod.POST)
    public ApiMessage<GbMessageHistoryOutput> queryGbMessageList(
            @RequestBody GbMessageParam param) {
        logger.info("we get a request form getGbMessage:" + param.toString());
        if (this.paramTimeCheck(param.getStartTime(), param.getEndTime())) {
            logger.info("we find a getGbMessage request. 查询间隔过长。");
            return new ApiMessage<>(100003,
                    ApiEnum.REQUEST_PARAMS_VALID_FAILED.msg() + "查询间隔过长");
        }
        if (StringUtils.isEmpty(param.getVin())
                && StringUtils.isEmpty(param.getTeNumber())) {
            logger.info("we find a PARAMS_VALID_FAILED at getGbMessage.");
            return new ApiMessage<>(100003,
                    ApiEnum.REQUEST_PARAMS_VALID_FAILED.msg());
        }
        logger.debug("we receive a getGbMessage post request." + param.toString());
        String pointQueryKey;
        if (StringUtils.isEmpty(param.getVin())) {
            pointQueryKey = param.getTeNumber();
        } else {
            pointQueryKey = param.getVin();
        }


        if (!paramCheck(pointQueryKey,
                param.getStartTime(),
                param.getEndTime(),
                param.getPageNum(),
                param.getPageSize())) {
            return new ApiMessage<>(100003,
                    ApiEnum.REQUEST_PARAMS_VALID_FAILED.msg());
        }

        GbMessageHistoryOutput gbMessageHistoryOutput =
                gbMessageHistoryService.queryListByParam(param);


        return new ApiMessage<>(gbMessageHistoryOutput);

    }

    @ApiSecurity
    @RequestMapping(value = "/getCan", method = RequestMethod.POST)
    public ApiMessage<CanHistoryOutput> queryCanList(
            @RequestBody CanParam param) {
        logger.info("we get a request form getCan:" + param.toString());
        if (this.paramTimeCheck(param.getStartTime(), param.getEndTime())) {
            logger.info("we find a getCan request. 查询间隔过长。");
            return new ApiMessage<>(100003,
                    ApiEnum.REQUEST_PARAMS_VALID_FAILED.msg() + "查询间隔过长");
        }
        if (StringUtils.isEmpty(param.getVin())
                && StringUtils.isEmpty(param.getTeNumber())) {
            logger.info("we find a PARAMS_VALID_FAILED at getCan.");
            return new ApiMessage<>(100003,
                    ApiEnum.REQUEST_PARAMS_VALID_FAILED.msg());
        }
        logger.debug("we receive a getCan post request." + param.toString());
        String pointQueryKey;
        if (StringUtils.isEmpty(param.getVin())) {
            pointQueryKey = param.getTeNumber();
        } else {
            pointQueryKey = param.getVin();
        }


        if (!paramCheck(pointQueryKey,
                param.getStartTime(),
                param.getEndTime(),
                param.getPageNum(),
                param.getPageSize())) {
            return new ApiMessage<>(100003,
                    ApiEnum.REQUEST_PARAMS_VALID_FAILED.msg());
        }

        CanHistoryOutput canHistoryOutput =
                canHistoryService.queryListByParam(param);

        return new ApiMessage<>(canHistoryOutput);

    }

    @ApiSecurity
    @RequestMapping(value = "/getMqttStates", method = RequestMethod.POST)
    public ApiMessage<MqttStateHistoryOutput> queryMqttStateList(
            @RequestBody MqttStateParam param) {
        logger.info("we get a request form getMqttStates:" + param.toString());
        if (this.paramTimeCheck(param.getStartTime(), param.getEndTime())) {
            logger.info("we find a states request. 查询间隔过长。");
            return new ApiMessage<>(100003,
                    ApiEnum.REQUEST_PARAMS_VALID_FAILED.msg() + "查询间隔过长");
        }
        if (StringUtils.isEmpty(param.getVin())
                && StringUtils.isEmpty(param.getTeNumber())) {
            logger.info("we find a PARAMS_VALID_FAILED at getMqttStates.");
            return new ApiMessage<>(100003,
                    ApiEnum.REQUEST_PARAMS_VALID_FAILED.msg());
        }
        logger.debug("we receive a getMqttStates post request." + param.toString());
        String pointQueryKey;
        if (StringUtils.isEmpty(param.getVin())) {
            pointQueryKey = param.getTeNumber();
        } else {
            pointQueryKey = param.getVin();
        }


        if (!paramCheck(pointQueryKey,
                param.getStartTime(),
                param.getEndTime(),
                param.getPageNum(),
                param.getPageSize())) {
            return new ApiMessage<>(100003,
                    ApiEnum.REQUEST_PARAMS_VALID_FAILED.msg());
        }

        MqttStateHistoryOutput mqttStateHistoryOutput =
                mqttStateHistoryService.queryListByParam(param);

        return new ApiMessage<>(mqttStateHistoryOutput);

    }

    @ApiSecurity
    @RequestMapping(value = "/getMqttStateLastOne", method = RequestMethod.POST)
    public ApiMessage<MqttStateDto> queryMqttStateLastOne(
            @RequestBody MqttStateParam param) {
        logger.info("we get a request form getMqttStates:" + param.toString());
        if (this.paramTimeCheck(param.getStartTime(), param.getEndTime())) {
            logger.info("we find a states request. 查询间隔过长。");
            return new ApiMessage<>(100003,
                    ApiEnum.REQUEST_PARAMS_VALID_FAILED.msg() + "查询间隔过长");
        }
        if (StringUtils.isEmpty(param.getVin())
                && StringUtils.isEmpty(param.getTeNumber())) {
            logger.info("we find a PARAMS_VALID_FAILED at getMqttStates.");
            return new ApiMessage<>(100003,
                    ApiEnum.REQUEST_PARAMS_VALID_FAILED.msg());
        }
        logger.debug("we receive a getMqttStates post request." + param.toString());
        String pointQueryKey;
        if (StringUtils.isEmpty(param.getVin())) {
            pointQueryKey = param.getTeNumber();
        } else {
            pointQueryKey = param.getVin();
        }


        if (!paramCheck(pointQueryKey,
                param.getStartTime(),
                param.getEndTime(),
                param.getPageNum(),
                param.getPageSize())) {
            return new ApiMessage<>(100003,
                    ApiEnum.REQUEST_PARAMS_VALID_FAILED.msg());
        }

        MqttStateHistoryOutput mqttStateHistoryOutput =
                mqttStateHistoryService.queryListByParam(param);
        List<MqttStateDto> mqttStateDtoList=mqttStateHistoryOutput.getList();

        MqttStateDto mqttStateDtoOutput=null;
        if (null!=mqttStateDtoList&&mqttStateDtoList.size()>0){
            mqttStateDtoOutput=mqttStateDtoList.get(0);
            for (MqttStateDto mqttStateDto:mqttStateDtoList){
                if (mqttStateDto.getCurrentTime()<mqttStateDtoOutput.getCurrentTime()){
                    mqttStateDtoOutput=mqttStateDto;
                }
            }
        }
        return new ApiMessage<>(mqttStateDtoOutput);
    }

    /**
     * 检查查询的时间，其查询的间隔不能过长。
     */
    private boolean paramTimeCheck(String startTime, String endTime) {
        boolean flag = false;//false为验证通过。
        long startTimeLong = DateTimeUtil.date2UnixFormat(startTime, DateTimeUtil.UNIX_FORMAT);
        long endTimeLong = DateTimeUtil.date2UnixFormat(endTime, DateTimeUtil.UNIX_FORMAT);
        long timeLong = endTimeLong - startTimeLong;
        if (timeLong > ONE_MOUTH) {
            flag = true;
        }
        return flag;
    }

    private boolean paramCheck(String pointQueryKey, String startTime, String endTime, Integer pageNo, Integer pageSize) {
        if (null == pointQueryKey || null == endTime || null == startTime) {
            return false;
        }
        if (pointQueryKey.isEmpty() || endTime.isEmpty() || startTime.isEmpty()) {
            return false;
        }
        //if (pageNo<-1||pageNo==0){return false;}
        //if (pageSize<=0){return false;}
        //if (pageSize>5000){return false;}
        try {
            DateTimeUtil.date2UnixFormat(startTime, DateTimeUtil.UNIX_FORMAT);
            DateTimeUtil.date2UnixFormat(endTime, DateTimeUtil.UNIX_FORMAT);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
