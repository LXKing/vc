package com.ccclubs.command.inf.old;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONArray;
import com.ccclubs.command.dto.DealRemoteCmdInput;
import com.ccclubs.command.dto.DealRemoteCmdOutput;
import com.ccclubs.command.process.CommandProcessInf;
import com.ccclubs.command.version.CommandServiceVersion;
import com.ccclubs.common.query.QueryStructService;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.mongo.orm.model.remote.CsRemote;
import com.ccclubs.mongo.service.impl.CsRemoteService;
import com.ccclubs.protocol.util.ProtocolTools;
import com.ccclubs.pub.orm.model.CsStructWithBLOBs;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 远程指令下发
 *
 * @author jianghaiyang
 * @create 2018-08-16
 **/
@Service(version = CommandServiceVersion.V1)
public class DealRemoteCmdInfImpl implements DealRemoteCmdInf {

    private static final Logger LOGGER = LoggerFactory.getLogger(DealRemoteCmdInfImpl.class);

    @Autowired
    CsRemoteService csRemoteService;

    @Autowired
    QueryStructService structService;

    @Autowired
    CommandProcessInf process;

    /**
     * 提供远程指令下发功能
     */
    @Override
    public DealRemoteCmdOutput dealRemoteCommend(DealRemoteCmdInput input) {
        // 1.查询指令远程控制记录
        CsRemote csRemote = csRemoteService.queryById(input.getRemoteId());
        if (csRemote == null || (csRemote.getCsrType() == 0 || csRemote.getCsrType() == null)) {
            throw new ApiException(ApiEnum.REMOTE_RECORD_NOT_FOUND, input.getRemoteId());
        }
        // 2.查询指令结构体定义
        CsStructWithBLOBs csStruct = structService
                .queryCsStructByStructId(csRemote.getCsrType().longValue());
        if (csStruct == null || StringUtils.isEmpty(csStruct.getCssRequest())) {
            LOGGER.error("指令[{}]不存在!", csRemote.getCsrType());
            throw new ApiException(ApiEnum.COMMAND_NOT_FOUND);
        }
        String cssReq = csStruct.getCssRequest();
        List<Map> requests = JSONArray.parseArray(cssReq, java.util.Map.class);
        List<Map> values = JSONArray.parseArray(input.getStrJson(), java.util.Map.class);
        Object[] array = ProtocolTools.getArray(requests, values);

        // 3.发送指令
        LOGGER.debug("command send start.");
        process.dealRemoteCommand(csRemote, array);

        return new DealRemoteCmdOutput();
    }
}
