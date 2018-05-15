package com.ccclubs.report.service.impl;

import java.util.concurrent.atomic.AtomicInteger;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.stereotype.Service;

import com.ccclubs.report.constant.LoginType;
import com.ccclubs.report.constant.ReportProps;
import com.ccclubs.report.constant.ReportServer;
import com.ccclubs.report.constant.ReportType;
import com.ccclubs.report.service.ReportInf;
import com.ccclubs.sdk.protocol.gb.entity.GBMessage;
import com.ccclubs.sdk.protocol.gb.entity.GBMessageHeader;
import com.ccclubs.sdk.protocol.gb.entity.GBMessageType;
import com.ccclubs.sdk.protocol.gb.entity.GB_05;
import com.ccclubs.sdk.protocol.gb.entity.GB_06;
import com.ccclubs.sdk.protocol.gb.util.Tools;

@RefreshScope
@Service
public class TianJingReportImpl implements ReportInf {
    private Logger log = LoggerFactory.getLogger(getClass());
    private LoginType loginType;

    static AtomicInteger count = new AtomicInteger(1);
    private long last = 0L;
    @Autowired
    private ReportProps reportPops;
    @Autowired
    private KafkaListenerEndpointRegistry registry;

    @Override
    public ReportType getBizType() {
        return ReportType.TIAN_JIN;
    }

    @Override
    public ReportServer getReportServer() {
        // TODO Auto-generated method stub
        return reportPops.reportServerByType(getBizType());
    }

    @Override
    public void receivedSuccess(Object msg) {
        // 需要打印日志，控制日志输出
        if (this.getReportServer().isLogPrint()) {
            byte[] b = (byte[]) msg;
            log.info("received:{},hex:{}", loginType, Tools.ToHexString(b));
        }

    }
    private String getMessageTypeString(GBMessage gb) {
        switch (gb.getMessageType()) {
            case 0x01:
                return "车辆登入";
            case 0x02:
                return "实时信息上报";
            case 0x03:
                return "补发信息上报";
            case 0x04:
                return "车辆登出";
            case 0x05:
            case 0x06:
                return "平台传输数据占用";
            case 0x07:
                return "心跳";
            case 0x08:
                return "终端校时";
            default:
                return "0x" + Tools.ToHexString((byte) gb.getMessageType());
        }
    }
    @Override
    public void receivedError(Throwable cause) {
        log.error("receivedError", cause);
    }

    @Override
    public void sendSuccess(Object msg) {
        if (this.getReportServer().isLogPrint()) {
            //log.info("send success:{}", Tools.ToHexString((byte[]) msg));
            byte[] b = (byte[]) msg;
            GBMessage gb = new GBMessage();
            gb.ReadFromBytes(b);
            log.info("send success:{},vin:{},msg:{},hex:{}", loginType, gb.getVin(), getMessageTypeString(gb), Tools.ToHexString(b));
        }
        if(this.loginType.equals(LoginType.LOGIN_IN)) {
            registry.stop();
            log.debug("kafka stop$$$$$$$$$");
        }
    }

    @Override
    public void sendError(Object msg) {
        // TODO Auto-generated method stub
        log.debug("sendError:{}", msg);
        registry.stop();
        log.debug("kafka stop$$$$$$$$$");
    }

    @Override
    public void doBussiness() {
        // TODO Auto-generated method stub
        log.info("doBussiness:{}", loginType);
    }

    @Override
    public LoginType loginType() {
        if (null == this.loginType) {
            this.loginType = LoginType.DEFAULT;
        }
        return this.loginType;
    }

    @Override
    public Object loginInMessage() {
        GBMessage gbMessage = new GBMessage();
        GBMessageHeader head = new GBMessageHeader();
        head.setVin("00000000000000000");
        head.setMessageType(GBMessageType.GB_MSG_REAL_TIME_TYPE_0X05);
        head.setAckType(0xFE);
        head.setEncodeType(0x01);
        gbMessage.setHeader(head);

        GB_05 shMessage = new GB_05();
        ReportServer rs = this.getReportServer();
        shMessage.setUsername(rs.getUsername());
        shMessage.setPassword(rs.getPassword());

        shMessage.setTime(now());// "2018-05-09 21:02:00"
        shMessage.setEncryptRule(1);
        log.debug("last:{}", last);
        boolean isGreater = System.currentTimeMillis() > last;
        if (isGreater) {
            last = new DateTime().withTime(23, 59, 59, 999).getMillis();
            count.set(1);
        }
        int c = count.get();
        if (c > 65531) {
            count.set(1);
            c = 1;
        }
        shMessage.setLoginSerialNo(c);

        gbMessage.setMessageContents(shMessage);
        byte[] b = gbMessage.WriteToBytes();
        log.debug("loginIn :{}", Tools.ToHexString(b));
        return b;
    }

    private String now() {
        DateTime now = new DateTime();
        String s = now.toString("yyyy-MM-dd HH:mm:ss");
        return s;
    }

    @Override
    public void loginInReceived(Object msg) {
        byte[] b = (byte[]) msg;
        if (b[2] == GBMessageType.GB_MSG_REAL_TIME_TYPE_0X05 && b[3] == 0x01) {
            count.getAndIncrement();
            this.loginType = LoginType.LOGIN_IN_SUCCESS;
            registry.start();
            log.debug("kafka start$$$$$$$$");
        } else {
            this.loginType = LoginType.LOGIN_IN_FAIL;
            registry.stop();
            log.debug("kafka stop$$$$$$$$$");
        }
        //this.loginType = LoginType.LOGIN_IN_SUCCESS;
        // 需要打印日志，控制日志输出
        if (this.getReportServer().isLogPrint()) {
            log.info("{} loginInReceived:{}",this.loginType, Tools.ToHexString(b));
        }

    }

    @Override
    public void loginInFail(Throwable cause) {
        log.error("loginInFail", cause);
        registry.stop();
        log.debug("kafka stop$$$$$$$$$");
    }

    @Override
    public Object loginOutMessage() {
        GB_06 shMessage = new GB_06();
        shMessage.setTime(now());
        shMessage.setLoginOutSerialNo(count.get());
        byte[] b = shMessage.WriteToBytes();
        return b;
    }

    @Override
    public void loginOutReceived(Object msg) {
        log.info("loginOutSuccess:{}", Tools.ToHexString((byte[]) msg));
    }

    @Override
    public void loginOutFail(Throwable cause) {
        log.error("loginOutFail", cause);
    }

    @Override
    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

}
