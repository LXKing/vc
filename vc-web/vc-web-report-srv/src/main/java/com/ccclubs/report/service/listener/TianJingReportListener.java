package com.ccclubs.report.service.listener;

import static com.ccclubs.frm.spring.constant.KafkaConst.KAFKA_CONSUMER_GROUP_REPORT_GB_TIANJING;
import static com.ccclubs.frm.spring.constant.KafkaConst.KAFKA_TOPIC_GATEWAY_GB_SUCCESS;

import java.util.concurrent.ConcurrentLinkedQueue;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.ccclubs.report.constant.LoginType;
import com.ccclubs.report.service.ReportAgency;
import com.ccclubs.report.service.ReportInf;
import com.ccclubs.sdk.protocol.gb.entity.GBMessage;
import com.ccclubs.sdk.protocol.gb.entity.GBMessageType;
import com.ccclubs.sdk.protocol.gb.util.Tools;

@Component
public class TianJingReportListener {
    private Logger log = LoggerFactory.getLogger(getClass());
    private static final DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
    @Qualifier("tianJingReportImpl")
    @Autowired
    private ReportInf bInf;
    @Autowired
    private ReportAgency dInf;
    private ConcurrentLinkedQueue<KafkaMq> queue = new ConcurrentLinkedQueue<>();

    @KafkaListener(id = "${" + KAFKA_CONSUMER_GROUP_REPORT_GB_TIANJING + "}", topics = "${"
            + KAFKA_TOPIC_GATEWAY_GB_SUCCESS + "}", containerFactory = "batchFactory")
    public void receive(String payload) {
        log.debug("kafka receive $$$$$$$$$$$$");
        KafkaMq mq = JSONObject.parseObject(payload, KafkaMq.class);

        // 非登陆状态，消息先存储内存
        if (LoginType.LOGIN_IN_SUCCESS.equals(bInf.loginType())) {
            log.debug("kafka not login");
            while (!queue.isEmpty()) {
                log.debug("kafka has oldMq");
                KafkaMq oldMq = queue.poll();
                deal(oldMq);
            }
            deal(mq);
        } else {
            log.debug("kafka cache Mq");
            queue.offer(mq);
        }

    }

    private void deal(KafkaMq mq) {
        byte[] b = Tools.HexString2Bytes(mq.getSourceHex());
        if (mq.getCode() == GBMessageType.GB_MSG_REAL_TIME_TYPE_0X02) {
            GBMessage gb = new GBMessage();
            gb.ReadFromBytes(b);
            if (StringUtils.isEmpty(gb.getErrorMessage())) {
                String time = gb.getMessageContents().getTime();
                // 大于10秒后，置为补发
                DateTime dateTime = DateTime.parse(time, format).plusSeconds(10);
                if (dateTime.getMillis() < System.currentTimeMillis()) {
                    gb.getHeader().setMessageType(GBMessageType.GB_MSG_REAL_TIME_TYPE_0X03);
                    b = gb.WriteToBytes();
                }
            }
        }
        dInf.send(bInf, b);
    }
}
