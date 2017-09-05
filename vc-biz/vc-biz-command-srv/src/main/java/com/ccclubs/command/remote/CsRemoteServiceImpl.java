package com.ccclubs.command.remote;

import com.ccclubs.mongo.orm.dao.CsRemoteDao;
import com.ccclubs.mongo.orm.model.CsRemote;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsVehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

/**
 * remote service
 *
 * @author jianghaiyang
 * @create 2017-07-06
 **/
@Component
public class CsRemoteServiceImpl implements CsRemoteService {

    private static Logger logger = LoggerFactory.getLogger(CsRemoteServiceImpl.class);

    @Autowired
    private CsRemoteDao rdao;


    /**
     * 保存cs_remote记录
     *
     * @param v        车辆信息
     * @param m        终端信息
     * @param structId 指令ID
     * @param appId    接口调用方
     * @return remote记录
     */
    @Override
    public CsRemote save(CsVehicle v, CsMachine m, Integer structId, String appId) {
        logger.info("start insert csRemote in mongo...");
        CsRemote csRemote = new CsRemote();
        csRemote.setCsrAccess(m.getCsmAccess());
        csRemote.setCsrHost(m.getCsmHost());
        csRemote.setCsrNumber(m.getCsmNumber());
        csRemote.setCsrCar(v.getCsvId());
        csRemote.setCsrWay(0);//0:网关 1:短信 断线的车辆建议用短信方式
        csRemote.setCsrType(structId);
        csRemote.setCsrEditor(appId);
        csRemote.setCsrAddTime(System.currentTimeMillis());
        csRemote.setCsrUpdateTime(null);
        csRemote.setCsrState(2);//0:未发送 1:已发送 2:组装中
        csRemote.setCsrStatus(0);//0:未知 1:操作成功 2:操作失败
        csRemote = rdao.save(csRemote);
        return csRemote;
    }

    @Override
    public CsRemote queryById(Long csrId) {
        Query query = new Query(Criteria.where("csrId").is(csrId));
        CsRemote csRemote = rdao.findOne(query);
        return csRemote;
    }
}
