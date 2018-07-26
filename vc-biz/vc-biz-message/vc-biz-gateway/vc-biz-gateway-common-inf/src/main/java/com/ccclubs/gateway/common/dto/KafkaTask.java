package com.ccclubs.gateway.common.dto;

import com.ccclubs.gateway.common.constant.KafkaSendTopicType;

/**
 * @Author: yeanzi
 * @Date: 2018/5/17
 * @Time: 9:34
 * Email:  yeanzhi@ccclubs.com
 * kafka发送消息任务
 */
public class KafkaTask {

    /**
     * 要发送的topic
     */
    private KafkaSendTopicType topic;
    /**
     * 可选的key参数
     */
    private String key;
    /**
     * 发送的内容
     */
    private String body;


    public KafkaTask(KafkaSendTopicType topic, String key, String body) {
        this.topic = topic;
        this.key = key;
        this.body = body;
    }

    public KafkaTask(KafkaSendTopicType topic, String body) {
        this.topic = topic;
        this.body = body;
    }

    public KafkaSendTopicType getTopic() {
        return topic;
    }

    public KafkaTask setTopic(KafkaSendTopicType topic) {
        this.topic = topic;
        return this;
    }

    public String getKey() {
        return key;
    }

    public KafkaTask setKey(String key) {
        this.key = key;
        return this;
    }

    public String getBody() {
        return body;
    }

    public KafkaTask setBody(String body) {
        this.body = body;
        return this;
    }
}
