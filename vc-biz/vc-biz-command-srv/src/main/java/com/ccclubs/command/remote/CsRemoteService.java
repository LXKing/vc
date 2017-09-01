package com.ccclubs.command.remote;

import com.ccclubs.mongodb.orm.model.CsRemote;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsVehicle;
import org.springframework.stereotype.Component;

/**
 * remote service
 *
 * @author jianghaiyang
 * @create 2017-07-06
 **/

public interface CsRemoteService {
    /**
     * 保存cs_remote记录
     * @param v 车辆信息
     * @param m 终端信息
     * @param structId 指令ID
     * @param appId 接口调用方
     * @return remote记录
     */
    public CsRemote save(CsVehicle v, CsMachine m, Integer structId, String appId);

    public CsRemote queryById(Long csrId);

}
