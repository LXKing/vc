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
import com.ccclubs.command.remote.CsRemoteManager;
import com.ccclubs.command.util.*;
import com.ccclubs.command.version.CommandServiceVersion;
import com.ccclubs.common.validate.AuthValidateHelper;
import com.ccclubs.frm.logger.VehicleControlLogger;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.mongo.orm.model.remote.CsRemote;
import com.ccclubs.protocol.dto.CommonResult;
import com.ccclubs.protocol.util.ProtocolTools;
import com.ccclubs.pub.orm.mapper.CsStructMapper;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsStructWithBLOBs;
import com.ccclubs.pub.orm.model.CsVehicle;
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
    private static final Logger loggerBusiness = VehicleControlLogger.getLogger();

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
    private CsRemoteManager csRemoteManager;
    @Resource
    IdGeneratorHelper idGen;

    @Resource
    private TerminalOnlineHelper terminalOnlineHelper;
    @Resource
    AuthValidateHelper authValidateHelper;

    /**
     * 下发简单指令
     * @param input
     * @return
     */
    @Override
    public SimpleCmdOutput sendSimpleCmd(SimpleCmdInput input) {
        //数据权限校验
        boolean validateResult = authValidateHelper.validateAuth(input.getAppId(), input.getVin(), "");
        if (!validateResult) {
            throw new ApiException(ApiEnum.DATA_ACCESS_CHECK_FAILED);
        }
        Integer structId = commandProp.getCmdMap().get(input.getCmd() + "");

        logger.debug("begin process command {} start.", structId);
        // 校验指令码
        if (null == structId) {
            throw new ApiException(ApiEnum.COMMAND_NOT_FOUND);
        }

        // 校验终端与车辆绑定关系是否正常，正常则返回终端车辆信息
        Map vm = validateHelper.isVehicleAndCsMachineBoundRight(input.getVin());
        CsVehicle csVehicle = (CsVehicle) vm.get(CommandConstants.MAP_KEY_CSVEHICLE);
        CsMachine csMachine = (CsMachine) vm.get(CommandConstants.MAP_KEY_CSMACHINE);

        // 0.检查终端是否在线
        terminalOnlineHelper.isOnline(csMachine, input.getVin());

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
                oldAdapter(csMachine, input, structId);
                break;
            case 14:
                oldAdapter(csMachine, input, structId);
                break;
            default:
                break;
        }

        // 1.查询指令结构体定义
        CsStructWithBLOBs csStruct = sdao.selectByPrimaryKey(structId.longValue());
        String cssReq = csStruct.getCssRequest();
        List<Map> requests = JSONArray.parseArray(cssReq, Map.class);
        List<Map> values = JSONArray.parseArray("[{}]", Map.class);
        Object[] array = ProtocolTools.getArray(requests, values);

        // 2.保存记录 cs_remote
        long csrId = idGen.getNextId();
        CsRemote csRemote = CsRemoteUtil.construct(csVehicle, csMachine, structId.longValue(), array, input.getAppId(), csrId);
        csRemoteManager.asyncSave(csRemote);

        // 3.发送指令
        logger.debug("command send start.");
        process.dealRemoteCommand(csRemote, array);

        // 4.确认结果
        SimpleCmdOutput output = new SimpleCmdOutput();
        switch (input.getResultType()) {
            case 1://async
                output.setMessageId(csRemote.getCsrId());
                break;
            case 2://sync
                output = confirmResult(csRemote, structId, csMachine);
                break;
            case 3://http
                break;
        }
        return output;
    }

    private SimpleCmdOutput confirmResult(CsRemote csRemote, Integer structId, CsMachine csMachine) {
        Long startTime = System.currentTimeMillis();
        try {
            while ((System.currentTimeMillis() - startTime) < TIMEOUT) {
                // 规则引擎负责把完整结果写入redis
                ValueOperations<String, String> ops = redisTemplate.opsForValue();
                String result = ops.get(AssembleHelper.assembleKey(csRemote.getCsrId()));
                if (null != result && !"".equals(result)) {
                    logger.debug("command {} send successfully.", structId);
                    csRemote.setCsrUpdateTime(System.currentTimeMillis());
                    csRemote.setCsrStatus(1);
                    csRemote.setCsrResult(result);
                    JSONObject jsonObject = (JSONObject) JSONObject.toJSON(csRemote);
                    jsonObject.put("csrTerminalType", csMachine.getCsmTeType());
                    jsonObject.put("csrTerminalMobile", csMachine.getCsmMobile());
                    jsonObject.put("csrTerminalPlugin", csMachine.getCsmTlV2());
                    jsonObject.put("csrTerminalVersion", csMachine.getCsmTlV1());
                    loggerBusiness.info(JSONObject.toJSONString(jsonObject));
                    CommonResult<SimpleCmdOutput> commonResult = JSON.parseObject(result,
                            new TypeReference<CommonResult<SimpleCmdOutput>>() {});

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
            case 1://中导
            case 3://通领
                structId = getNotAdapterStructId(csMachine, input, structId);
                break;
            case 2://慧瀚
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
     * 指令2,3,4,5,6,9,10,11,12,13,14 适配老机型
     *
     * @param csMachine
     * @param input
     * @param structId
     * @return
     */
    private Integer oldAdapter(CsMachine csMachine, SimpleCmdInput input, Integer structId) {
        switch (csMachine.getCsmTeType()) {
            case 0://富士康
            case 1://中导
            case 3://通领
                structId = getAdapterStructId(csMachine, input, structId);
                break;
            case 2://慧瀚
                break;
        }
        return structId;
    }

    /**
     * 获取适配结构ID
     * @param csMachine  车机
     * @param input
     * @param structId
     * @return
     */
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
