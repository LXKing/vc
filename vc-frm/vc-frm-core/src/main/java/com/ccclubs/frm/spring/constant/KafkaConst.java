package com.ccclubs.frm.spring.constant;

/**
 * kafka常量
 *
 * @author jianghaiyang
 * @create 2018-03-29
 **/
public class KafkaConst {
    /**
     * kafka集群GB实时数据topic配置名称
     */
    public static final String KAFKA_TOPIC_GB_RT = "kafka.topic.gb.rt";

    /**
     * kafka集群GB历史数据topic配置名称
     * */
    public static final String KAFKA_TOPIC_GBMESSAGE = "kafka.topic.gbmessage";

    /**
     * kafka集群CAN历史数据topic配置名称(所有的can报文)s
     * */
    public static final String KAFKA_TOPIC_CSCAN = "kafka.topic.cscan";

    /**
     * kafka集群STATE历史数据topic配置名称(分时租赁实时状态)
     * */
    public static final String KAFKA_TOPIC_CSSTATE = "kafka.topic.csstate";
}
