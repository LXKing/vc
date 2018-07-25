package com.ccclubs.command.inf.update.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.ccclubs.command.dto.MixedUpgradeTask;
import com.ccclubs.command.dto.UpgradeInput;
import com.ccclubs.command.dto.UpgradeOutput;
import com.ccclubs.command.inf.update.TerminalUpgradeInf;
import com.ccclubs.command.process.CommandProcessInf;
import com.ccclubs.command.util.*;
import com.ccclubs.command.version.CommandServiceVersion;
import com.ccclubs.common.query.QueryUpgradeVersionService;
import com.ccclubs.common.validate.AuthValidateHelper;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.protocol.dto.jt808.T808Message;
import com.ccclubs.pub.orm.mapper.VerFtpSerMapper;
import com.ccclubs.pub.orm.mapper.VerUpgradeMapper;
import com.ccclubs.pub.orm.mapper.VerUpgradeRecordMapper;
import com.ccclubs.pub.orm.model.*;
import com.ccclubs.upgrade.constant.TerminalType;
import com.ccclubs.upgrade.constant.VehicleModelType;
import com.ccclubs.upgrade.dto.FtpServer;
import com.ccclubs.upgrade.dto.UpgradeTask;
import com.ccclubs.upgrade.dto.UpgradeVersion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;


/**
 * 终端一键升级实现
 *
 * @author jianghaiyang
 * @create 2017-06-29
 **/
@Service(version = CommandServiceVersion.V1)
public class TerminalUpgradeImpl implements TerminalUpgradeInf {

    private static final Logger logger = LoggerFactory.getLogger(TerminalUpgradeImpl.class);

    @Autowired
    private CommandProcessInf process;

    @Resource
    private ValidateHelper validateHelper;

    @Autowired
    private UpdateHelper updateHelper;

    @Autowired
    private UpgradeHelper upgradeHelper;
    @Resource
    private TerminalOnlineHelper terminalOnlineHelper;
    @Resource
    AuthValidateHelper authValidateHelper;

    @Resource
    VerUpgradeMapper verUpgradeMapper;
    @Resource
    VerFtpSerMapper verFtpSerMapper;
    @Resource
    VerUpgradeRecordMapper verUpgradeRecordMapper;
    @Resource
    QueryUpgradeVersionService queryUpgradeVersionService;

    // TODO: 目前升级API接口仅支持E200车型
    private int E200_MODEL = 5;

    /**
     * 终端升级（直接发送，不返还结果）
     *
     * @param input 升级参数
     */
    @Override
    public UpgradeOutput oneKeyUpgrade(UpgradeInput input) {
        //数据权限校验
        boolean validateResult = authValidateHelper.validateAuth(input.getAppId(), input.getVin(), "");
        if (!validateResult) {
            throw new ApiException(ApiEnum.DATA_ACCESS_CHECK_FAILED);
        }
        // 校验终端与车辆绑定关系是否正常，正常则返回终端车辆信息
        Map vm = validateHelper.isVehicleAndCsMachineBoundRight(input.getVin());
        CsVehicle csVehicle = (CsVehicle) vm.get(CommandConstants.MAP_KEY_CSVEHICLE);
        CsMachine csMachine = (CsMachine) vm.get(CommandConstants.MAP_KEY_CSMACHINE);

        // 0.检查终端是否在线
        terminalOnlineHelper.isOnline(csMachine, input.getVin());

        // 目前仅支持E200车型的升级
        if (E200_MODEL != csVehicle.getCsvModel()) {
            throw new ApiException(ApiEnum.API_RATE_LIMIT);
        }

        Integer currentVersion = csMachine.getCsmTlV2();
        // TODO:检查终端是否在线，暂时通过查询状态数据来实现
        switch (csMachine.getCsmTeType()) {
            //
            case 0:
                if (currentVersion < 0x1322) {
                    process.dealRemoteCommand(csMachine,
                            updateHelper.getUpdateMessageForFskSimple(csMachine.getCsmNumber()), false);
                    logger.info("给终端（CsmNumber {}）发送升级指令", csMachine.getCsmNumber());
                } else {
                    process.dealRemoteCommand(csMachine,
                            updateHelper.getUpdateMessageForFsk(csMachine.getCsmNumber(), input.getFilename()),
                            false);
                    logger.info("给终端（CsmNumber {}）发送升级指令", csMachine.getCsmNumber());
                }
                break;
            case 1:
                if (currentVersion < 0x2018) {
                    byte[] array = updateHelper.getUpdateMessageForZdHttp(csMachine.getCsmMobile());
                    if (null != array) {
                        process.dealZdHttpUpdateCommand(csMachine, array);
                        logger.info("给终端（Mobile {}）发送升级指令", csMachine.getCsmMobile());
                    }
                } else {
                    process.dealRemoteCommand(csMachine,
                            updateHelper.getUpdateMessageForZd(csMachine.getCsmMobile(), input.getFilename())
                                    .WriteToBytes(), false);
                    logger.info("给终端（Mobile {}）发送升级指令", csMachine.getCsmMobile());
                }
                break;
            case 3:
                //升级到最新版本版本，此处的是通领大版本
                T808Message updateMessage = updateHelper
                        .getUpdateMessageForTl(csMachine.getCsmMobile(), input.getFilename());

                /**
                 * 处理远程指令
                 *      处理升级
                 */
                process.dealRemoteCommand(csMachine, updateMessage.WriteToBytes(), true);

                logger.info("给终端（Mobile {}）发送升级指令", csMachine.getCsmMobile());
                break;
            default:
                break;
        }

        return null;
    }


    /**
     * 通领二合一版本升级
     * @param upgradeTask       升级信息
     */
    @Override
    @Transactional
    public UpgradeOutput upgradeMixedVersionTask(MixedUpgradeTask upgradeTask) {
        /**
         * 1. 命令执行前，对命令发起者的权限和车机校验
         */
        // 数据权限校验
        boolean validateResult = authValidateHelper.validateAuth(upgradeTask.getAppId(), upgradeTask.getVin(), "");
        if (!validateResult) {
            throw new ApiException(ApiEnum.DATA_ACCESS_CHECK_FAILED);
        }
        // 校验终端与车辆绑定关系是否正常，正常则返回终端车辆信息
        Map vm = validateHelper.isVehicleAndCsMachineBoundRight(upgradeTask.getVin());
        CsVehicle csVehicle = (CsVehicle) vm.get(CommandConstants.MAP_KEY_CSVEHICLE);
        CsMachine csMachine = (CsMachine) vm.get(CommandConstants.MAP_KEY_CSMACHINE);

        // 检查终端是否在线
        terminalOnlineHelper.isOnline(csMachine, upgradeTask.getVin());

        /**
         * 设置终端信息
         */
        upgradeTask.setTerType(csMachine.getCsmTeType())
                .setTerModel(csMachine.getCsmTeModel());
        /**
         * 查询升级需要的升级包等信息
         */
        VerUpgrade mixedVersion = verUpgradeMapper.selectByPrimaryKey(upgradeTask.getMixedUpVersionId());
        if (Objects.isNull(mixedVersion)) {
            // 未查询对应的升级包
            throw new ApiException(ApiEnum.UPGRADE_VERSION_NOT_FOUND);
        }
        UpgradeVersion upgradeVersion = new UpgradeVersion();
        upgradeVersion.setPluginFileName(mixedVersion.getFileName());

        /**
         * 查询升级文件对应的服务器信息
         */
        VerFtpSer ftpServer = verFtpSerMapper.selectByPrimaryKey(mixedVersion.getSerFtpId());
        if (Objects.isNull(ftpServer)) {
            // 未查询对应的升级包
            throw new ApiException(ApiEnum.UPGRADE_FTP_SERVER_NOT_FOUND);
        }
        upgradeVersion.setFtpServer(new FtpServer()
                .setSerHost(ftpServer.getUrl())
                .setSerPort(ftpServer.getSerPwd())
                .setSerPwd(ftpServer.getSerPwd())
                .setSerUsername(ftpServer.getSerUsername()));

        /**
         * 根据终端类型进行不同方式的升级
         */
        TerminalType terminalType = TerminalType.getByOrdinal(upgradeTask.getTerType());
        if (Objects.isNull(terminalType)) {
            throw new ApiException(ApiEnum.TERMINAL_NOT_TL);
        }
        switch(terminalType) {
            case CCCLUB:
                /**
                 * 车厘子插件升级
                 *      二合一版本时，插件版本的升级文件就是二合一版本的升级文件
                 */
                byte[] upgradeBytes = updateHelper.getUpdateMessageForFsk(csMachine.getCsmNumber(), mixedVersion.getFileName());
                process.dealRemoteCommand(csMachine, upgradeBytes, false);

                logger.info("给终端（CsmNumber {}）发送升级指令", csMachine.getCsmNumber());
                break;
            case ZD:
                /**
                 * 中岛升级时，二合一版本时，插件版本的升级文件就是二合一版本的升级文件
                 */
                process.dealRemoteCommand(csMachine,
                        updateHelper.getUpgradeMsgForByTaskVer(csMachine.getCsmMobile(),
                                upgradeVersion.getPluginFileName(),
                                upgradeVersion.getFtpServer())
                                .WriteToBytes(),
                        false);
                logger.info("给终端（Mobile {}）发送升级指令", csMachine.getCsmMobile());
                break;
            case TL:
                /**
                 * 通领车机的升级（主要）
                 *      由于upgradeMixedVersionTask方法只针对二合一版本的升级，
                 *      所以默认所有版本都是二合一版本（拐点版本），所以不用判断版本之间的依赖关系
                 */
                VehicleModelType vehicleModelType = VehicleModelType.getByCode(csVehicle.getCsvModel());
                if (Objects.nonNull(vehicleModelType)) {
                    /**
                     * TODO 查询升级前置步骤
                     */
                    try {
                        dealTLMixedVersionUpgradeByModel(upgradeTask.getVin(), upgradeVersion);
                    } catch (Exception e) {
                        logger.error("通领终端[{}]升级失败：{}", upgradeTask.getVin(), e.getMessage());
                        e.printStackTrace();
                    }
                } else {
                    logger.error("该车型类型不存在：csModel={}", csVehicle.getCsvModel());
                    throw new IllegalArgumentException("该车型类型不存在：csModel=" + csVehicle.getCsvModel());
                }
                break;
            case HH:
                break;
            default:
                break;
        }

        /**
         * 查询当前升级版本id
         *      车型+终端类型+终端型号=唯一一个升级包
         */
        VerUpgrade currentVer = queryUpgradeVersionService.getCurrentUpgradeVersionInfo(csVehicle.getCsvModel(), upgradeTask.getTerModel(), upgradeTask.getTerType(), csMachine);
        if (Objects.isNull(currentVer)) {
            // 版本升级时未查询到当前车机版本信息
            throw new ApiException(ApiEnum.UPGRADE_CURRENT_VERSION_NOT_FOUND);
        }
        /**
         * 插入一条升级记录
         */
        Date now = new Date();
        VerUpgradeRecord upgradeRecord = new VerUpgradeRecord();
        upgradeRecord.setAddTime(now);
        upgradeRecord.setCarModel(csVehicle.getCsvModel());
        upgradeRecord.setStatus((byte)1);
        upgradeRecord.setFromVersion(currentVer.getId());
        upgradeRecord.setTeModel(upgradeTask.getTerModel());
        upgradeRecord.setTeNumber(csMachine.getCsmTeNo());
        upgradeRecord.setTeType(upgradeTask.getTerType());
        upgradeRecord.setToVersion(upgradeTask.getMixedUpVersionId());
        upgradeRecord.setUpdateTime(now);
        upgradeRecord.setVin(upgradeTask.getVin());
        verUpgradeRecordMapper.insertSelective(upgradeRecord);

        return null;
    }

    /**
     * 拐点升级
     * @param task
     * @return
     */
    @Override
    public UpgradeOutput basicUpgrade(UpgradeTask task) {
        // 校验终端与车辆绑定关系是否正常，正常则返回终端车辆信息
        Map vm = validateHelper.isVehicleAndCsMachineBoundRight(task.getVin());
        CsVehicle csVehicle = (CsVehicle) vm.get(CommandConstants.MAP_KEY_CSVEHICLE);
        CsMachine csMachine = (CsMachine) vm.get(CommandConstants.MAP_KEY_CSMACHINE);

        // 0.检查终端是否在线
        terminalOnlineHelper.isOnline(csMachine, task.getVin());
        Integer pluginVersion = Optional.of(csMachine.getCsmTlV2()).orElse(0);
        String majorVersion = csMachine.getCsmTlV1();
        TerminalType terminalType = TerminalType.getByOrdinal(csMachine.getCsmTeType());
        if (Objects.isNull(terminalType)) {
            throw new ApiException(ApiEnum.TERMINAL_NOT_TL);
        }
        switch(terminalType) {
            case CCCLUB:
                process.dealRemoteCommand(csMachine,
                        updateHelper.getUpdateMessageForFskSimple(csMachine.getCsmNumber()), false);
                logger.info("给终端（CsmNumber {}）发送升级指令", csMachine.getCsmNumber());
                break;
            case ZD:
                byte[] array = updateHelper.getUpdateMessageForZdHttp(csMachine.getCsmMobile());
                if (null != array) {
                    process.dealZdHttpUpdateCommand(csMachine, array);
                    logger.info("给终端（Mobile {}）发送升级指令", csMachine.getCsmMobile());
                }
                break;
            case TL:
                // 升级到拐点版本
                T808Message updateMessage = updateHelper
                        .getUpgradeMsgForByTaskVer(csMachine.getCsmMobile(), task.getUpgradeVersion().getMajorFileName(), task.getUpgradeVersion().getFtpServer());

                process.dealRemoteCommand(csMachine, updateMessage.WriteToBytes(), true);

                logger.info("给终端（Mobile {}）发送升级指令", csMachine.getCsmMobile());
                break;
            case HH:
                break;
            default:
                break;
        }

        return null;

    }

    @Override
    public UpgradeOutput upgradePlugin(UpgradeTask task) {

        // 校验终端与车辆绑定关系是否正常，正常则返回终端车辆信息
        Map vm = validateHelper.isVehicleAndCsMachineBoundRight(task.getVin());
        CsVehicle csVehicle = (CsVehicle) vm.get(CommandConstants.MAP_KEY_CSVEHICLE);
        CsMachine csMachine = (CsMachine) vm.get(CommandConstants.MAP_KEY_CSMACHINE);

        // 0.检查终端是否在线
        terminalOnlineHelper.isOnline(csMachine, task.getVin());
        Integer pluginVersion = Optional.of(csMachine.getCsmTlV2()).orElse(0);
        String majorVersion = csMachine.getCsmTlV1();
        TerminalType terminalType = TerminalType.getByOrdinal(csMachine.getCsmTeType());
        if (Objects.isNull(terminalType)) {
            throw new ApiException(ApiEnum.TERMINAL_NOT_TL);
        }
        switch(terminalType) {
            case CCCLUB:
                // 车厘子插件升级
                byte[] upgradeBytes = updateHelper.getUpdateMessageForFsk(csMachine.getCsmNumber(), task.getUpgradeVersion().getPluginFileName());
                process.dealRemoteCommand(csMachine, upgradeBytes, false);

                logger.info("给终端（CsmNumber {}）发送升级指令", csMachine.getCsmNumber());
                break;
            case ZD:
                process.dealRemoteCommand(csMachine,
                        updateHelper.getUpgradeMsgForByTaskVer(csMachine.getCsmMobile(),
                                task.getUpgradeVersion().getPluginFileName(),
                                task.getUpgradeVersion().getFtpServer())
                                .WriteToBytes(),
                        false);
                logger.info("给终端（Mobile {}）发送升级指令", csMachine.getCsmMobile());
                break;
            case TL:
                VehicleModelType vehicleModelType = VehicleModelType.getByCode(csVehicle.getCsvModel());
                if (Objects.nonNull(vehicleModelType)) {
                    try {
                        dealTLPluginUpgradeByModel(task);
                    } catch (Exception e) {
                        logger.error("通领终端[{}]升级失败：{}", task.getVin(), e.getMessage());
                        e.printStackTrace();
                    }
                } else {
                    // 升级到拐点版本
                    T808Message updateMessage = updateHelper
                            .getUpgradeMsgForByTaskVer(csMachine.getCsmMobile(), task.getUpgradeVersion().getMajorFileName(), task.getUpgradeVersion().getFtpServer());
                    process.dealRemoteCommand(csMachine, updateMessage.WriteToBytes(), true);
                    logger.info("给终端（Mobile {}）发送升级指令", csMachine.getCsmMobile());
                }
                break;
            case HH:
                break;
            default:
                break;
        }

        return null;
    }

    /**
     * 主版本升级：目前只有通领终端类型才有主版本升级
     * @param task
     * @return
     */
    @Override
    public UpgradeOutput upgradeMajor(UpgradeTask task) {
        // 校验终端与车辆绑定关系是否正常，正常则返回终端车辆信息
        Map vm = validateHelper.isVehicleAndCsMachineBoundRight(task.getVin());
        CsVehicle csVehicle = (CsVehicle) vm.get(CommandConstants.MAP_KEY_CSVEHICLE);
        CsMachine csMachine = (CsMachine) vm.get(CommandConstants.MAP_KEY_CSMACHINE);

        // 0.检查终端是否在线
        terminalOnlineHelper.isOnline(csMachine, task.getVin());
        Integer pluginVersion = Optional.of(csMachine.getCsmTlV2()).orElse(0);
        String majorVersion = csMachine.getCsmTlV1();
        TerminalType terminalType = TerminalType.getByOrdinal(csMachine.getCsmTeType());
        if (Objects.isNull(terminalType)) {
            throw new ApiException(ApiEnum.TERMINAL_NOT_TL);
        }
        switch(terminalType) {
            case TL:
            case CCCLUB:
            case ZD:
                // 主版本为： 一般文件升级
                T808Message updateMessage = updateHelper
                        .getUpgradeMsgForByTaskVer(csMachine.getCsmMobile(), task.getUpgradeVersion().getMajorFileName(), task.getUpgradeVersion().getFtpServer());

                process.dealRemoteCommand(csMachine, updateMessage.WriteToBytes(), true);

                logger.info("给终端（Mobile {}）发送升级指令", csMachine.getCsmMobile());
                // TODO 因为现在并没有用到返回
                return null;
            case HH:
                break;
            default:
                break;
        }
        return null;
    }

    /**
     *  根据终端类型处理通领插件升级
     */
    public void dealTLPluginUpgradeByModel(UpgradeTask task) throws InterruptedException {
        Map vm = validateHelper.isVehicleAndCsMachineBoundRight(task.getVin());
        CsVehicle csVehicle = (CsVehicle) vm.get(CommandConstants.MAP_KEY_CSVEHICLE);
        CsMachine csMachine = (CsMachine) vm.get(CommandConstants.MAP_KEY_CSMACHINE);
        // TODO 查询拐点版本信息
        UpgradeVersion turningVer = upgradeHelper.getTurningVer(csVehicle, csMachine);

        String modelRate = null;
        String modelCanHexStr = UpdateHelper.CAN_HEX_STRING;
        String fileName = turningVer.getPluginFileName();
        boolean turningUpgrade = false;
        VehicleModelType vehicleModelType = VehicleModelType.getByCode(csVehicle.getCsvModel());
        if (Objects.isNull(vehicleModelType)) {
            logger.error("通领插件升级找不到匹配的终端类型：task=[{}]", JSON.toJSONString(task));
            return;
        }
        if (csMachine.getCsmTlV2() < turningVer.getId()) {
            turningUpgrade = true;
            switch (vehicleModelType) {
                case CHANGAN_YD_15:
                    // 长安逸动15款
                    modelRate = UpdateHelper.RATE_J;
                    break;
                case CHANGAN_YD_JY:
                    // 长安逸动精英款
                    modelRate = UpdateHelper.RATE_J;
                    break;
                case CHANGAN_YD_HH:
                    //长安逸动豪华款
                    modelRate = UpdateHelper.RATE_H;
                    break;
                case CHANGAN_BENBEN:
                    // 长安奔奔汽油车
                    modelRate = UpdateHelper.RATE_BEN_OIL;
                    break;
                default:
                    break;
            }
        } else {
            turningUpgrade = false;
        }

        if (turningUpgrade) {
            // 设置CAN波特率
            process.dealRemoteCommand(csMachine,
                    updateHelper.getFF01(modelRate, csMachine).WriteToBytes(), false);
            Thread.sleep(1000);
            // 设置CAN 过滤表
            process.dealRemoteCommand(csMachine,
                    updateHelper.getFF03(csMachine, modelCanHexStr).WriteToBytes(),
                    false);
            Thread.sleep(1000);

            process.dealRemoteCommand(csMachine,
                    updateHelper.getUpdateMessageForFsk(csMachine.getCsmNumber(), fileName),
                    true);
            logger.info(
                    "长安逸动15款 待升级终端[{}]信息，插件升级：[{}]", csMachine.getCsmNumber(), turningVer.getPluginVer());
        } else {
            // 下发 自动充电并且不锁门 命令
            byte[] sendArray = updateHelper.getSendBytes(csVehicle, csMachine);
            if (null != sendArray) {
                process.dealRemoteCommand(csMachine, sendArray, false);
            }
        }
    }

    /**
     * 通领二合一版本升级
     *      如果有升级步骤，先执行CAN波特率、过滤表等的设置
     * @param vin
     * @param upgradeVersion    升级的版本信息
     * @throws InterruptedException
     */
    private void dealTLMixedVersionUpgradeByModel(String vin, UpgradeVersion upgradeVersion) throws InterruptedException {
        Map vm = validateHelper.isVehicleAndCsMachineBoundRight(vin);
        CsVehicle csVehicle = (CsVehicle) vm.get(CommandConstants.MAP_KEY_CSVEHICLE);
        CsMachine csMachine = (CsMachine) vm.get(CommandConstants.MAP_KEY_CSMACHINE);

        VehicleModelType vehicleModelType = VehicleModelType.getByCode(csVehicle.getCsvModel());
        if (Objects.isNull(vehicleModelType)) {
            logger.error("通领插件升级找不到匹配的终端类型：vin=[{}]", vin);
            return;
        }

        // CAN波特率报文
        String modelRate = updateHelper.generateTLCANRateByParam(upgradeVersion.getCanRate());
        // CAN过滤表报文
        String modelCanHexStr = updateHelper.genertateTLCanFilterTableByArray(upgradeVersion.getCanIdList());
        /**
         * 根据不同的车型类型，组装不同的CAN波特率报文
         */
        if (Objects.isNull(modelRate)) {
            switch (vehicleModelType) {
                case CHANGAN_YD_15:
                    // 长安逸动15款
                    modelRate = UpdateHelper.RATE_J;
                    break;
                case CHANGAN_YD_JY:
                    // 长安逸动精英款
                    modelRate = UpdateHelper.RATE_J;
                    break;
                case CHANGAN_YD_HH:
                    //长安逸动豪华款
                    modelRate = UpdateHelper.RATE_H;
                    break;
                case CHANGAN_BENBEN:
                    // 长安奔奔汽油车
                    modelRate = UpdateHelper.RATE_BEN_OIL;
                    break;
                default:
                    break;
            }
        }

        /**
         * 设置升级牵制条件
         */
        // 设置CAN波特率
        process.dealRemoteCommand(csMachine,
                updateHelper.getFF01(modelRate, csMachine).WriteToBytes(), false);
        Thread.sleep(1000);
        // 设置CAN 过滤表
        process.dealRemoteCommand(csMachine,
                updateHelper.getFF03(csMachine, modelCanHexStr).WriteToBytes(),
                false);
        Thread.sleep(1000);
        /**
         * 执行车机二合一升级任务
         */
        process.dealRemoteCommand(csMachine,
                updateHelper.getUpdateMessageForFsk(csMachine.getCsmNumber(), upgradeVersion.getPluginFileName()),
                true);
        logger.info("统领二合一版本升级：待升级终端[{}]信息，插件升级：vin=[{}]", csMachine.getCsmNumber(), vin);
    }

    @Override
    public void sendSetCommand(String vin) {
        Map vm = validateHelper.isVehicleAndCsMachineBoundRight(vin);
        CsVehicle csVehicle = (CsVehicle) vm.get(CommandConstants.MAP_KEY_CSVEHICLE);
        CsMachine csMachine = (CsMachine) vm.get(CommandConstants.MAP_KEY_CSMACHINE);
        // 下发 自动充电并且不锁门 命令
        byte[] sendArray = updateHelper.getFskSendBytes(csVehicle, csMachine);
        if (null != sendArray) {
            process.dealRemoteCommand(csMachine, sendArray, false);
        }

    }

}
