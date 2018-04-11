package com.ccclubs.command.inf.confirm.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ccclubs.command.dto.ConfirmInput;
import com.ccclubs.command.inf.confirm.HttpConfirmResultInf;
import com.ccclubs.command.version.CommandServiceVersion;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.mongo.orm.model.remote.CsRemote;
import com.ccclubs.mongo.service.impl.CsRemoteService;
import com.ccclubs.protocol.dto.CommonResult;

import javax.annotation.Resource;

/**
 * 通过http方式查询指令结果
 *
 * @author jianghaiyang
 * @create 2017-07-25
 **/
@Service(version = CommandServiceVersion.V1)
public class HttpConfirmResultImpl implements HttpConfirmResultInf {
    @Resource
    private CsRemoteService remoteService;

    @Override
    public JSONObject confirm(ConfirmInput input) {
        CsRemote remote = remoteService.queryById(input.getMessageId());
        if (null == remote || remote.getCsrStatus() != 1) {
            throw new ApiException(ApiEnum.COMMAND_EXECUTE_FAILED);
        }
        CommonResult commonResult = JSON.parseObject(remote.getCsrResult(), new TypeReference<CommonResult>() {
        });

        if (commonResult.isSuccess()) {
            if (commonResult.getData() == null) {
                return null;
            } else {
                return (JSONObject) commonResult.getData();
            }
        } else {
            throw new ApiException(ApiEnum.COMMAND_EXECUTE_FAILED.code(),
                    commonResult.getMessage());
        }
    }
}
