package com.ccclubs.report.api;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccclubs.report.constant.ReportServer;
import com.ccclubs.report.netty.client.NettyClient;
import com.ccclubs.report.service.ReportInf;

@RefreshScope
@RestController
public class TestApi {
    @Autowired
    private NettyClient pool;
    @Autowired
    private KafkaListenerEndpointRegistry registry;
    @Autowired
    private List<ReportInf> list;

    @RequestMapping(path = "/bean1/api", method = {RequestMethod.POST, RequestMethod.GET})
    public String bean1() {
        return "test:";
    }
    @RequestMapping(path = "/log/start", method = {RequestMethod.POST, RequestMethod.GET})
    public String logStart() {
        if (null != list) {
            for (ReportInf bf : list) {
                bf.getReportServer().setLogPrint(1);
            }
        }
        return "test:";
    }
    @RequestMapping(path = "/log/stop", method = {RequestMethod.POST, RequestMethod.GET})
    public String logStop() {
        if (null != list) {
            for (ReportInf bf : list) {
                bf.getReportServer().setLogPrint(0);
            }
        }
        return "test:";
    }
    @RequestMapping(path = "/kafka/start", method = {RequestMethod.POST, RequestMethod.GET})
    public String kafkaStart() {
        registry.start();
        return "test:";
    }
    @RequestMapping(path = "/kafka/stop", method = {RequestMethod.POST, RequestMethod.GET})
    public String kafkaStop() {
        registry.stop();
        return "test:";
    }

    @RequestMapping(path = "/test1/api", method = {RequestMethod.POST, RequestMethod.GET})
    public String test1() {
        pool.send("127.0.0.1", 19000, "one1");
        return "test";
    }

    @RequestMapping(path = "/test2/api", method = {RequestMethod.POST, RequestMethod.GET})
    public String test2() {
        /* pool.send("127.0.0.1", 19001, "two2"); */
        try {
            pool.send("127.0.0.1", 19001, "");
            // final GBMessage shMessage = Struct.readObject(s.getBytes(), GBMessage.class);
            // System.out.println(shMessage);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "test";
    }
}
