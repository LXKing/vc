package com.ccclubs.report.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccclubs.report.netty.client.NettyClient;

@RefreshScope
@RestController
public class TestApi {
    @Autowired
    private NettyClient pool;
    @Autowired
    private KafkaListenerEndpointRegistry registry;

    @RequestMapping(path = "/bean1/api", method = {RequestMethod.POST, RequestMethod.GET})
    public String bean1() {
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
