package com.ccclubs.command.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ccclubs.command.dto.CommonOutput;
import com.ccclubs.frm.logger.VehicleControlLogger;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.mongo.orm.model.remote.CsRemote;
import com.ccclubs.protocol.dto.CommonResult;
import com.ccclubs.pub.orm.model.CsMachine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import static com.ccclubs.command.util.CommandConstants.TIMEOUT;


/**
 * 指令发送结果查询
 *
 * @author jianghaiyang
 * @create 2017-07-06
 **/
@Component
public class ResultHelper {

    private static final Logger logger = LoggerFactory.getLogger(ResultHelper.class);
    private static final Logger loggerBusiness = VehicleControlLogger.getLogger();

    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 确认指令结果
     * @param csRemote
     * @param resultType
     * @param output
     * @param csMachine
     * @param <T>
     * @return
     */
    public <T> T confirmResult(CsRemote csRemote, Integer resultType, T output, CsMachine csMachine) {
        switch (resultType) {
            case 1://async
                CommonOutput object = new CommonOutput();
                object.setMessageId(csRemote.getCsrId());
                BeanUtils.copyProperties(object, output);
                break;
            case 2://sync
                output = confirmResultSync(csRemote, output, csMachine);
                break;
            case 3://http
                break;
        }
        return output;
    }

    /**
     * 从redis内拿返回结果并设置过期时间10秒，有两个来源1、超时，轮询；2、正常返回，由终端返回 TODO 采用线程锁的方式来处理，开启线程轮询结果
     */
    private <T> T confirmResultSync(CsRemote csRemote, T output, CsMachine csMachine) {
        Long startTime = System.currentTimeMillis();
        String key = AssembleHelper.assembleKey(csRemote.getCsrId());
        try {
            while ((System.currentTimeMillis() - startTime) < TIMEOUT) {
                // 规则引擎负责把完整结果写入redis
                ValueOperations<String, String> ops = redisTemplate.opsForValue();
                String result = ops.get(key);
                if (null != result && !"".equals(result)) {
                    logger.debug("command {} send successfully.", csRemote.getCsrType());
                    csRemote.setCsrUpdateTime(System.currentTimeMillis());
                    csRemote.setCsrStatus(1);
                    csRemote.setCsrResult(result);
                    JSONObject jsonObject = (JSONObject) JSONObject.toJSON(csRemote);
                    jsonObject.put("csrTerminalType", csMachine.getCsmTeType());
                    jsonObject.put("csrTerminalMobile", csMachine.getCsmMobile());
                    jsonObject.put("csrTerminalPlugin", csMachine.getCsmTlV2());
                    jsonObject.put("csrTerminalVersion", csMachine.getCsmTlV1());
                    loggerBusiness.info(JSONObject.toJSONString(jsonObject));
                    CommonResult commonResult = JSON.parseObject(result, new TypeReference<CommonResult>() {
                    });

                    if (commonResult.isSuccess()) {
                        return null;//不返回data
                    } else {
                        throw new ApiException(ApiEnum.COMMAND_EXECUTE_FAILED.code(),
                                commonResult.getMessage());
                    }
                }
                Thread.sleep(300L);
            }
            logger.debug("command timeout and exit.");
            csRemote.setCsrUpdateTime(System.currentTimeMillis());
            csRemote.setCsrStatus(-1);
            JSONObject jsonObject = (JSONObject) JSONObject.toJSON(csRemote);
            jsonObject.put("csrTerminalType", csMachine.getCsmTeType());
            jsonObject.put("csrTerminalMobile", csMachine.getCsmMobile());
            jsonObject.put("csrTerminalPlugin", csMachine.getCsmTlV2());
            jsonObject.put("csrTerminalVersion", csMachine.getCsmTlV1());
            loggerBusiness.info(JSONObject.toJSONString(jsonObject));
            throw new ApiException(ApiEnum.COMMAND_TIMEOUT);
        } catch (ApiException ex) {
            throw ex;
        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            throw new ApiException(ApiEnum.SYSTEM_ERROR);
        }
    }

    /*public static void main(String[] args) {
        CsRemote csRemote = new CsRemote();
        csRemote.setCsrId(1231231L);
        AirAllOutput output = new AirAllOutput();
        output = new ResultHelper().confirmResult(csRemote,1, output);
        System.err.println(output);
    }*/
}
