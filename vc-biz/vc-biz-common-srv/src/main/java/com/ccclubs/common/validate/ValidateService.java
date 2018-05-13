package com.ccclubs.common.validate;

import com.ccclubs.common.query.QueryAppInfoService;
import com.ccclubs.common.query.QueryTerminalService;
import com.ccclubs.common.query.QueryVehicleService;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsVehicle;
import com.ccclubs.pub.orm.model.SrvHost;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 数据权限校验服务
 *
 * @author jianghaiyang
 * @create 2017-07-17
 **/
@Component
public class ValidateService {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    QueryVehicleService vehicleService;

    @Resource
    QueryTerminalService terminalService;

    @Resource
    QueryAppInfoService hostService;

    /**
     * 校验数据权限
     *
     * @param appId 应用ID
     * @param vin   数据资源标识符 vin
     * @param teNo  数据资源标识符 teNo
     * @return 有权限返回true，否则返回false
     */
    public boolean validateAuth(String appId, String vin, String teNo) {

        logger.info("validate data auth for appId {} vin {} teNo {} start", appId, vin, teNo);
        // 根据appId缓存中获取接入商
        SrvHost host = hostService.queryHostByAppidFromCache(appId);
        if (null == host) {
            logger.error("validate data auth for appId {} vin {} teNo {} failed", appId, vin, teNo);
            return false;
        }
        if (null == vin && null == teNo) {
            logger.error("vin and teNo are all null,validate failed", appId, vin, teNo);
            return false;
        }
        if (StringUtils.isNotEmpty(vin)) {
            CsVehicle vehicle = vehicleService.queryVehicleByVin(vin);
            if (null != vehicle) {
                //E+当做长安出行处理 TODO
                host.setShId(host.getShId() == 11 ? 3 : host.getShId());
                //校验车辆数据权限
                if (host.getShId().intValue() != vehicle.getCsvAccess()) {
                    logger.error("validate data auth for appId {} vin {} teNo {} failed", appId, vin, teNo);
                    return false;
                }
            }
        }
        if (StringUtils.isNotEmpty(teNo)) {
            CsMachine machine = terminalService.queryCsMachineByTeNo(teNo);
            if (null != machine) {
                //E+当做长安出行处理 TODO
                host.setShId(host.getShId() == 11 ? 3 : host.getShId());
                //校验终端数据权限
                if (host.getShId() != machine.getCsmAccess()) {
                    logger.error("validate data auth for appId {} vin {} teNo {} failed", appId, vin, teNo);
                    return false;
                }
            }
        }
        logger.debug("validate data auth for appId {} vin {} teNo {} success", appId, vin, teNo);
        return true;
    }
}
