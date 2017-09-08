package com.ccclubs.command.inf.simple.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ccclubs.command.dto.SimpleCmdInput;
import com.ccclubs.command.dto.SimpleCmdOutput;
import com.ccclubs.command.inf.simple.SendSimpleCmdInf;
import com.ccclubs.command.process.CommandProcessInf;
import com.ccclubs.command.remote.CsRemoteService;
import com.ccclubs.command.util.*;
import com.ccclubs.command.version.CommandServiceVersion;
import com.ccclubs.common.aop.DataAuth;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.mongo.orm.model.CsRemote;
import com.ccclubs.protocol.dto.CommonResult;
import com.ccclubs.protocol.util.ProtocolTools;
import com.ccclubs.pub.orm.mapper.CsStructMapper;
import com.ccclubs.pub.orm.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import static com.ccclubs.command.util.CommandConstants.TIMEOUT;

/**
 * 简单指令下发实现
 *
 * @author jianghaiyang
 * @create 2017-06-30
 **/
@Service(version = CommandServiceVersion.V1)
public class SendSimpleCmdImpl implements SendSimpleCmdInf {

    private static final Logger logger = LoggerFactory.getLogger(SendSimpleCmdImpl.class);

    @Autowired
    private CommandProcessInf process;

    @Autowired
    private CsStructMapper sdao;

    @Resource
    private RedisTemplate redisTemplate;

    @Autowired
    private CommandProp commandProp;

    @Resource
    private ValidateHelper validateHelper;

    @Resource
    private CsRemoteService remoteService;

    @Override
    @DataAuth
    public SimpleCmdOutput sendSimpleCmd(SimpleCmdInput input) {

        Integer structId = commandProp.getCmdMap().get(input.getCmd() + "");

        logger.info("begin process command {} start.", structId);
        // 校验指令码
        if (null == structId) {
            throw new ApiException(ApiEnum.COMMAND_NOT_FOUND);
        }

        // 校验终端与车辆绑定关系是否正常，正常则返回终端车辆信息
        Map vm = validateHelper.isVehicleAndCsMachineBoundRight(input.getVin());
        CsVehicle csVehicle = (CsVehicle) vm.get(CommandConstants.MAP_KEY_CSVEHICLE);
        CsMachine csMachine = (CsMachine) vm.get(CommandConstants.MAP_KEY_CSMACHINE);

        /*****************************************************/
        /******************** 适配（低）终端版本 *****************/
        /*****************************************************/
        switch (input.getCmd()) {
            case 1:
                notAdapter(csMachine, input, structId);
                break;
            case 2:
                oldAdapter(csMachine, input, structId);
                break;
            case 3:
                oldAdapter(csMachine, input, structId);
                break;
            case 4:
                oldAdapter(csMachine, input, structId);
                break;
            case 5:
                oldAdapter(csMachine, input, structId);
                break;
            case 6:
                oldAdapter(csMachine, input, structId);
                break;
            case 7:
                notAdapter(csMachine, input, structId);
                break;
            case 8:
                notAdapter(csMachine, input, structId);
                break;
            case 9:
                oldAdapter(csMachine, input, structId);
                break;
            case 10:
                oldAdapter(csMachine, input, structId);
                break;
            case 11:
                oldAdapter(csMachine, input, structId);
                break;
            case 12:
                oldAdapter(csMachine, input, structId);
                break;
            case 13:
                notAdapter(csMachine, input, structId);
                break;
            case 14:
                notAdapter(csMachine, input, structId);
                break;
        }

        // 1.查询指令结构体定义
        CsStructWithBLOBs csStruct = sdao.selectByPrimaryKey(Long.parseLong(structId.toString()));
        String cssReq = csStruct.getCssRequest();
        List<Map> requests = JSONArray.parseArray(cssReq, Map.class);
        List<Map> values = JSONArray.parseArray("[{}]", Map.class);
        Object[] array = ProtocolTools.getArray(requests, values);

        // 2.保存记录 cs_remote
        CsRemote csRemote = remoteService.save(csVehicle, csMachine, structId, input.getAppId());

        // 3.发送指令
        logger.info("command send start.");
        process.dealRemoteCommand(csRemote, array);

        SimpleCmdOutput output = new SimpleCmdOutput();
        // 4.确认结果
        switch (input.getResultType()) {
            case 1://async
                output.setMessageId(csRemote.getCsrId());
                break;
            case 2://sync
                output = confirmResult(csRemote, structId);
                break;
            case 3://http
                break;
        }
        return output;
    }

    private SimpleCmdOutput confirmResult(CsRemote csRemote, Integer structId) {
        Long startTime = System.currentTimeMillis();
        try {
            while ((System.currentTimeMillis() - startTime) < TIMEOUT) {
                // 规则引擎负责把完整结果写入redis
                ValueOperations<String, String> ops = redisTemplate.opsForValue();
                String result = ops.get(AssembleHelper.assembleKey(csRemote.getCsrId()));
                if (null != result && !"".equals(result)) {
                    logger.info("command {} send successfully.", structId);
                    CommonResult<SimpleCmdOutput> commonResult = JSON.parseObject(result, new TypeReference<CommonResult<SimpleCmdOutput>>() {
                    });

                    if (commonResult.isSuccess()) {
                        if (commonResult.getData() == null) {
                            return null;
                        } else {
                            return commonResult.getData();
                        }
                    } else {
                        throw new ApiException(ApiEnum.COMMAND_EXECUTE_FAILED.code(), commonResult.getMessage());
                    }
                }
                Thread.sleep(100l);
            }
            logger.error("command timeout and exit.");
            throw new ApiException(ApiEnum.COMMAND_TIMEOUT);

        } catch (ApiException ex) {
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw new ApiException(ApiEnum.SYSTEM_ERROR);
        }
    }

    /**
     * 指令1,7,8 不适配老机型
     *
     * @param csMachine
     * @param input
     * @param structId
     * @return
     */
    private Integer notAdapter(CsMachine csMachine, SimpleCmdInput input, Integer structId) {
        switch (csMachine.getCsmTeType()) {
            case 0://富士康
                Integer supportV = commandProp.getSupportVersionMap().get(csMachine.getCsmTeType() + "");
                if (null == csMachine.getCsmV1()) {
                    throw new ApiException(ApiEnum.OLD_VERSION_DETECTED, supportV);
                } else {
                    Integer currV = Integer.parseInt(csMachine.getCsmV1().substring(4), 16);
                    if (currV < supportV) {
                        throw new ApiException(ApiEnum.OLD_VERSION_DETECTED, supportV);
                    }
                }
                break;
            case 1://中导
                structId = getNotAdapterStructId(csMachine, input, structId);
                break;
            case 2://慧瀚
                break;
            case 3://通领
                structId = getNotAdapterStructId(csMachine, input, structId);
                break;
        }
        return structId;
    }

    private Integer getNotAdapterStructId(CsMachine csMachine, SimpleCmdInput input, Integer structId) {
        Integer supportV = commandProp.getSupportVersionMap().get(csMachine.getCsmTeType() + "");
        if (null == csMachine.getCsmTlV2()) {
            throw new ApiException(ApiEnum.OLD_VERSION_DETECTED, supportV);
        } else {
            Integer currV = csMachine.getCsmTlV2();
            if (currV < supportV) {
                throw new ApiException(ApiEnum.OLD_VERSION_DETECTED, supportV);
            }
        }
        return structId;
    }

    /**
     * 指令2,3,4,5,6,9,10,11,12 适配老机型
     *
     * @param csMachine
     * @param input
     * @param structId
     * @return
     */
    private Integer oldAdapter(CsMachine csMachine, SimpleCmdInput input, Integer structId) {
        switch (csMachine.getCsmTeType()) {
            case 0://富士康
                if (null == csMachine.getCsmV1()) {
                    structId = commandProp.getCmdMap().get("5" + input.getCmd());
                } else {
                    Integer currV = Integer.parseInt(csMachine.getCsmV1().substring(4), 16);
                    Integer supportV = commandProp.getSupportVersionMap().get(csMachine.getCsmTeType() + "");
                    if (currV < supportV) {
                        structId = commandProp.getCmdMap().get("5" + input.getCmd());
                    }
                }
                break;
            case 1://中导
                structId = getAdapterStructId(csMachine, input, structId);
                break;
            case 2://慧瀚
                break;
            case 3://通领
                structId = getAdapterStructId(csMachine, input, structId);
                break;
        }
        return structId;
    }

    private Integer getAdapterStructId(CsMachine csMachine, SimpleCmdInput input, Integer structId) {
        Integer supportV = commandProp.getSupportVersionMap().get(csMachine.getCsmTeType() + "");
        if (null == csMachine.getCsmTlV2()) {
            throw new ApiException(ApiEnum.OLD_VERSION_DETECTED, supportV);
        } else {
            Integer currV = csMachine.getCsmTlV2();
            if (currV < supportV) {
                structId = commandProp.getCmdMap().get("5" + input.getCmd());
            }
        }
        return structId;
    }
}
