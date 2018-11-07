package com.ccclubs.common.validate;

import com.ccclubs.common.query.QueryAppInfoService;
import com.ccclubs.common.query.QueryTerminalService;
import com.ccclubs.common.query.QueryVehicleService;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsVehicle;
import com.ccclubs.pub.orm.model.SrvHost;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 数据权限校验服务
 *
 * @author jianghaiyang
 * @create 2018-06-04
 **/
@Component
public class AuthValidateHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthValidateHelper.class);

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
     *
     * @return 有权限返回true，否则返回false
     */
    public boolean validateAuth(String appId, String vin, String teNo) {

        LOGGER.info("validate data auth for appId {} vin {} teNo {} start", appId, vin, teNo);
        // 根据appId缓存中获取接入商
        SrvHost host = hostService.queryHostByAppidFromCache(appId);
        if (null == host) {
            LOGGER.error("validate data auth for appId {} vin {} teNo {} failed", appId, vin, teNo);
            return false;
        }
        if (null == vin && null == teNo) {
            LOGGER.error("vin and teNo are all null,validate failed", appId, vin, teNo);
            return false;
        }
        if (StringUtils.isNotEmpty(vin)) {
            CsVehicle vehicle = vehicleService.queryVehicleByVin(vin);
            if (null != vehicle) {
                switch (host.getShId()) {
                    //E+当做长安出行处理
                    case 11:
                        host.setShId(3);
                        break;
                    //国家支撑计划对接当做众车纷享处理
                    case 18:
                        host.setShId(1);
                        break;
                    default:
                        break;
                }
                //校验车辆数据权限
                if (host.getShId().equals(vehicle.getCsvAccess())) {
                    LOGGER.error("validate data auth for appId {} vin {} teNo {} failed", appId,
                            vin, teNo);
                    return false;
                }
            }
        }
        if (StringUtils.isNotEmpty(teNo)) {
            CsMachine machine = terminalService.queryCsMachineByTeNo(teNo);
            if (null != machine) {
                switch (host.getShId()) {
                    //E+当做长安出行处理
                    case 11:
                        host.setShId(3);
                        break;
                    //国家支撑计划对接当做众车纷享处理
                    case 18:
                        host.setShId(1);
                        break;
                    default:
                        break;
                }
                //校验终端数据权限
                if (host.getShId().equals(machine.getCsmAccess())) {
                    LOGGER.error("validate data auth for appId {} vin {} teNo {} failed", appId,
                            vin, teNo);
                    return false;
                }
            }
        }
        LOGGER.debug("validate data auth for appId {} vin {} teNo {} success", appId, vin, teNo);
        return true;
    }
}
