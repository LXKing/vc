package com.ccclubs.test;

import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;
import org.joda.time.DateTime;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.Producer;
import com.aliyun.openservices.ons.api.SendResult;
import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.PropertyKeyConst;

public class Test {
    static AtomicInteger count = new AtomicInteger(1);
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DateTime now = new DateTime();  
        String s = now.toString("yyyy-MM-dd HH:mm:ss");
        System.out.println(s);
        System.out.println("----------------");
        for(int i=0;i<100;i++) {
            
            
            
            System.out.println(count.get());
            System.out.println(count.get());
            System.out.println("----------------");
            count.getAndIncrement();
        }
        
        DateTime now2 = new DateTime().withTime(23, 59, 59, 999);  
        System.out.println(now2.toString("yyyy-MM-dd HH:mm:ss SSS"));
        long l = now2.getMillis();
        System.out.println(l);
        System.out.println(System.currentTimeMillis());
        
    }
    public static void aa() {

        Properties properties = new Properties();
        // 您在 MQ 控制台创建的 Producer ID
        properties.put(PropertyKeyConst.ProducerId, "PID_terminal_ser");
        // 鉴权用 AccessKey，在阿里云服务器管理控制台创建
        properties.put(PropertyKeyConst.AccessKey, "M6dHCyKyKYUCNbW4");
        // 鉴权用 SecretKey，在阿里云服务器管理控制台创建
        properties.put(PropertyKeyConst.SecretKey, "k6gOSH3dNJjFYze4CuxbBWS1PWqvVk");
        // 设置 TCP 接入域名（此处以公共云的公网接入为例）
        properties.put(PropertyKeyConst.ONSAddr,
                "http://onsaddr-internet.aliyun.com/rocketmq/nsaddr4client-internet");
        Producer producer = ONSFactory.createProducer(properties);
        // 在发送消息前，必须调用 start 方法来启动 Producer，只需调用一次即可
        producer.start();
        // 循环发送消息
        while (true) {
            Message msg = new Message( //
                    // 在控制台创建的 Topic，即该消息所属的 Topic 名称
                    "ser_test",
                    // Message Tag,
                    // 可理解为 Gmail 中的标签，对消息进行再归类，方便 Consumer 指定过滤条件在 MQ 服务器过滤
                    "TagA",
                    // Message Body
                    // 任何二进制形式的数据， MQ 不做任何干预，
                    // 需要 Producer 与 Consumer 协商好一致的序列化和反序列化方式
                    "Hello MQ".getBytes());
            // 设置代表消息的业务关键属性，请尽可能全局唯一，以方便您在无法正常收到消息情况下，可通过 MQ 控制台查询消息并补发
            // 注意：不设置也不会影响消息正常收发
            msg.setKey("ORDERID_100");
            // 发送消息，只要不抛异常就是成功
            // 打印 Message ID，以便用于消息发送状态查询
            SendResult sendResult = producer.send(msg);
            System.out.println("Send Message success. Message ID is: " + sendResult.getMessageId());
        }
    }
}
