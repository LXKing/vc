package com.ccclubs.command.util;


import com.ccclubs.protocol.dto.jt808.*;
import com.ccclubs.protocol.util.ProtocolTools;
import com.ccclubs.protocol.util.StringUtils;
import com.ccclubs.protocol.util.Tools;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsVehicle;
import com.ccclubs.upgrade.constant.UpgradeVerType;
import com.ccclubs.upgrade.dto.FtpServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by qsxiaogang on 2017/7/6.
 */
@Component
public class UpdateHelper {
    private static final Logger logger = LoggerFactory.getLogger(UpdateHelper.class);

    /**
     * 精英型
     */
    public static final String RATE_J = "020000000504C00001F40000000604C00001F4";
    /**
     * 豪华型
     */
    public static final String RATE_H = "020000000504C00001F40000000604C000007D";
    /**
     * 奔奔汽油版，500K
     */
    public static final String RATE_BEN_OIL = "020000000504C00001F40000000604C00001F4";
    /**
     * 逸动can
     */
    public static final String CAN_HEX_STRING = "0100000001C8001600400000030500000F01400000052100000F02400000030700000F0340000002B100000F04400000021800000F05400000027000000F06400000028800000F0740000002A200000F08400000019100000F09400000032000000F0A400000028000000F0BC00000030500000F0CC00000052100000F0DC00000030700000F0EC0000002B100000F0FC00000021800000F10C00000027000000F11C00000028800000F12C0000002A200000F13C00000019100000F14C00000032000000F15C00000028000000F";

    @Autowired
    ZdHttpHelper zdHttpHelper;

    /**
     * 通领大版本升级
     *
     * @param simNo    终端手机号
     * @param fileName FTP升级文件名
     */
    public T808Message getUpdateMessageForTl(String simNo, String fileName) {
        T808Message ts = new T808Message();
        ts.setHeader(new T808MessageHeader());
        ts.getHeader().setSimId(simNo);
        ts.getHeader().setIsPackage(false);
        ts.getHeader().setMessageSerialNo((short) 16);
        ts.getHeader().setMessageType(0x81F0);
        // 终端升级
        JT_81F0 cmdData = new JT_81F0();

        // 通领FTP升级
        cmdData.setMessageType((byte) 0x01);
        cmdData.setFtpAddress("www.hopelead.link");
        cmdData.setFtpPort("2014");
        cmdData.setFtpUserName("ccclubs");
        cmdData.setFtpPassword("ccclubs");

        cmdData.setFileName(fileName);
        cmdData.setConnectToServerTimeLimit("5");

        ts.setMessageContents(cmdData);

        return ts;
    }

    /**
     * 富士康终端[ 低版本，插件版本 < 0x1322 ]升级
     *
     * @param number 车机号
     */
    public byte[] getUpdateMessageForFskSimple(String number) {
        return Tools.HexString2Bytes(
                Tools.ToHexString(number) + "0000000001e3816749c0020000");
    }

    /**
     * 富士康终端[ 低版本，插件版本 >= 0x1322 ]升级
     *
     * @param number   车机号
     * @param fileName 待升级文件名
     */
    public byte[] getUpdateMessageForFsk(String number, String fileName) {
        return Tools.HexString2Bytes(
                Tools.ToHexString(number) + "000000000083C4E210C00200010003"
                        + Tools.ToHexString(fileName) + "0000");
    }

    /**
     * 中导FTP升级指令，通过Http方式升级
     *
     * @param simNo 终端手机号
     */
    public byte[] getUpdateMessageForZdHttp(String simNo) {
        String cmd = zdHttpHelper.getCmd(simNo);
        if (!StringUtils.empty(cmd)) {
            SL_Update slUpdate = new SL_Update();
            slUpdate.setSimId(simNo);
            slUpdate.setMsgBody(Tools.HexString2Bytes(cmd));
            return slUpdate.WriteToBytes();
        } else {
            return null;
        }
    }

    public T808Message getUpgradeMsgForByTaskVer(String simNo, String fileName, FtpServer ftpServer) {
        T808Message ts = new T808Message();
        ts.setHeader(new T808MessageHeader());
        ts.getHeader().setSimId(simNo);
        ts.getHeader().setIsPackage(false);
        ts.getHeader().setMessageSerialNo((short) 16);
        ts.getHeader().setMessageType(0x81F0);
        // 终端升级
        JT_81F0 cmdData = new JT_81F0();

        // 通领FTP升级
        cmdData.setMessageType((byte) 0x01);
        cmdData.setFtpAddress(ftpServer.getSerHost());
        cmdData.setFtpPort(ftpServer.getSerPort());
        cmdData.setFtpUserName(ftpServer.getSerUsername());
        cmdData.setFtpPassword(ftpServer.getSerPwd());

        cmdData.setFileName(fileName);
        cmdData.setConnectToServerTimeLimit("5");

        ts.setMessageContents(cmdData);

        return ts;
    }


    /**
     * 中导FTP升级指令
     *
     * @param simNo    终端手机号
     * @param fileName FTP升级文件名
     */
    public T808Message getUpdateMessageForZd(String simNo, String fileName) {
        T808Message ts = new T808Message();
        ts.setHeader(new T808MessageHeader());
        ts.getHeader().setSimId(simNo);
        ts.getHeader().setIsPackage(false);
        ts.getHeader().setMessageSerialNo((short) 16);
        ts.getHeader().setMessageType(0x81F0);
        // 终端升级
        JT_81F0 cmdData = new JT_81F0();

        cmdData.setMessageType((byte) 0x01);
        //中导FTP升级
        cmdData.setFtpAddress("ftp2.ccclubs.com");
        cmdData.setFtpPort("36797");
        cmdData.setFtpUserName("evnet507");
        cmdData.setFtpPassword("Rn1Qu3OR");

        cmdData.setFileName(fileName);
        cmdData.setConnectToServerTimeLimit("5");

        ts.setMessageContents(cmdData);

        return ts;
    }

    /**
     * 获取终端类型为：车厘子（0）的升级时需要的字节码数组
     * @param plugin            当前插件版本
     * @param number            升级的车机号
     * @param targetPluginFile  目标插件版本
     * @return
     */
    public byte[] getCCClubUpgradeMsg(int plugin, String number, String targetPluginFile) {
        if (plugin < UpgradeVerType.CCCLUB_BASIC_VER.getCode()) {
            logger.info("待升级终端:车厘子[{}]， 拐点版本[{}]", number, UpgradeVerType.CCCLUB_BASIC_VER.getCode());
            return Tools.HexString2Bytes(Tools.ToHexString(number) + "000000000000000049c0020000");
        } else {
            logger.info("待升级终端:车厘子[{}]， 升级版本[{}]", number, targetPluginFile);
            return Tools.HexString2Bytes(
                    Tools.ToHexString(number) + "000000000000000010C00200010003" + Tools
                            .ToHexString(targetPluginFile) + "0000");
        }
    }

    /**
     * 设置CAN过滤表
     */
    public T808Message getFF03(CsMachine csMachine, String canHexString) {
        JT_FF03 ff03 = new JT_FF03();
        ff03.setMsgBody(Tools.HexString2Bytes(canHexString));
        T808Message ts03 = new T808Message();
        ts03.setHeader(new T808MessageHeader());
        ts03.getHeader().setSimId(csMachine.getCsmMobile());
        ts03.getHeader().setIsPackage(false);
        ts03.getHeader().setMessageSerialNo((short) 1);
        ts03.getHeader().setMessageType(0xFF03);
        ts03.setMessageContents(ff03);
        return ts03;
    }

    /**
     * 设置 CAN2 波特率
     */
    public T808Message getFF01(String rateString, CsMachine csMachine) {
        JT_FF03 ff01 = new JT_FF03();
        ff01.setMsgBody(Tools.HexString2Bytes(rateString));
        T808Message ts = new T808Message();
        ts.setHeader(new T808MessageHeader());
        ts.getHeader().setSimId(csMachine.getCsmMobile());
        ts.getHeader().setIsPackage(false);
        ts.getHeader().setMessageSerialNo((short) 1);
        ts.getHeader().setMessageType(0xFF01);
        ts.setMessageContents(ff01);
        return ts;
    }

    public byte[] getSendBytes(CsVehicle csVehicle, CsMachine csMachine) {
        if (StringUtils.empty(csMachine.getCsmFunctions())) {
            // TODO 现在的车辆升级都是客户提供的列表升级的，那就是必然会在列表中，不用该判断
            if (isSharingCar(csVehicle.getCsvVin())) {
                return getAutoChargeAndLockMessage(csMachine);
            } else {
                return getAutoChargeAndUnlockMessage(csMachine);
            }
        }

        if (!csMachine.getCsmFunctions().contains("#4#")) {
            if (isSharingCar(csVehicle.getCsvVin())) {
                return getAutoChargeAndLockMessage(csMachine);
            } else {
                return getAutoChargeAndUnlockMessage(csMachine);
            }
        } else {
            if (isSharingCar(csVehicle.getCsvVin()) && csMachine.getCsmFunctions().contains("#3#")) {
                return getAutoChargeAndLockMessage(csMachine);
            } else {
                return getAutoChargeAndUnlockMessage(csMachine);
            }
        }
    }

    /**
     * 获取自动充电并且不锁门配置
     */
    public byte[] getAutoChargeAndUnlockMessage(CsMachine csMachine) {

        byte[] contentArray = Tools.HexString2Bytes(
                Tools.ToHexString(csMachine.getCsmNumber()) + "0000000000000000F01004CA000103");

        return ProtocolTools.package2T808Message(csMachine.getCsmMobile(), contentArray).WriteToBytes();
    }

    /**
     * 获取自动充电并且锁门配置
     */
    public byte[] getAutoChargeAndLockMessage(CsMachine csMachine) {

        byte[] contentArray = Tools.HexString2Bytes(
                Tools.ToHexString(csMachine.getCsmNumber()) + "0000000000000000F01004CA000101");

        return ProtocolTools.package2T808Message(csMachine.getCsmMobile(), contentArray).WriteToBytes();
    }

    // -------------------------------------------------------------------------------------------------------
    public byte[] getFskSendBytes(CsVehicle csVehicle, CsMachine csMachine) {
        if (StringUtils.empty(csMachine.getCsmFunctions())) {
            return getAutoChargeAndLockMessageForFsk(csMachine);
        }
        if (!csMachine.getCsmFunctions().contains("#4#")) {
            return getAutoChargeAndLockMessageForFsk(csMachine);
        } else {
            if (csMachine.getCsmFunctions().contains("#3#")) {
                return getAutoChargeAndLockMessageForFsk(csMachine);
            } else {
                return getAutoChargeAndUnlockMessageForFsk(csMachine);
            }
        }
    }


    /**
     * 富士康
     * 获取自动充电并且不锁门配置
     */
    public byte[] getAutoChargeAndUnlockMessageForFsk(CsMachine csMachine) {

        return Tools.HexString2Bytes(
                Tools.ToHexString(csMachine.getCsmNumber()) + "0000000000000000F01004CA000103");
    }

    /**
     * 富士康
     * 获取自动充电并且锁门配置
     */
    public byte[] getAutoChargeAndLockMessageForFsk(CsMachine csMachine) {

        return Tools.HexString2Bytes(
                Tools.ToHexString(csMachine.getCsmNumber()) + "0000000000000000F01004CA000101");
    }

    public boolean isSharingCar(String vin) {
        // TODO
        return true;
    }


}
