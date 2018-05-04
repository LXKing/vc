package com.ccclubs.frm.spring.constant;

/**
 * kafka常量
 *
 * @author jianghaiyang
 * @create 2018-03-29
 **/
public class KafkaConst {
    /*--------------------*
     * TOPIC
     *--------------------*/
    /**
     * kafka集群GB实时数据topic配置名称
     */
    public static final String KAFKA_TOPIC_GB_RT = "kafka.topic.gb.rt";

    /**
     * kafka集群GB历史数据topic配置名称
     * */
    public static final String KAFKA_TOPIC_CS_MESSAGE = "kafka.topic.history.csmessage";

    /**
     * kafka集群CAN历史数据topic配置名称(所有的can报文)s
     * */
    public static final String KAFKA_TOPIC_CS_CAN = "kafka.topic.history.cscan";

    /**
     * kafka集群STATE历史数据topic配置名称(分时租赁实时状态)
     * */
    public static final String KAFKA_TOPIC_CS_STATE = "kafka.topic.history.csstate";


    /**
     * GB网关：
     * 消息解析错误
     */
    public static final String KAFKA_TOPIC_GATEWAY_GB_DECODE_ERROR = "kafka.topic.gateway.gb.error.decode";

    /**
     * GB网关：
     * 过程处理的异常
     */
    public static final String KAFKA_TOPIC_GATEWAY_GB_PROCESS_ERROR = "kafka.topic.gateway.gb.error.process";

    /*--------------------*
     * 消费者组
     *--------------------*/
    public static final String KAFKA_CONSUMER_GROUP_STORAGE_CSMESSAGE = "kafka.consumer.group.storage.csmessage";
    public static final String KAFKA_CONSUMER_GROUP_STORAGE_CAN = "kafka.consumer.group.storage.cscan";
    public static final String KAFKA_CONSUMER_GROUP_STORAGE_STATE = "kafka.consumer.group.storage.csstate";
}
