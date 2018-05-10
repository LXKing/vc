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
     * kafka集群GB数据topic配置名称
     */
    public static final String KAFKA_TOPIC_GB_LOGIN = "kafka.topic.gb.success-login";
    public static final String KAFKA_TOPIC_GB_REAL = "kafka.topic.gb.success-real";
    public static final String KAFKA_TOPIC_GB_REISSUE = "kafka.topic.gb.success-reissue";
    public static final String KAFKA_TOPIC_GB_LOGOUT = "kafka.topic.gb.success-logout";
    public static final String KAFKA_TOPIC_GB_HEART = "kafka.topic.gb.success-heart";
    public static final String KAFKA_TOPIC_GB_TIME = "kafka.topic.gb.success-time";

    /**
     * kafka集群GB历史数据topic配置名称
     */
    public static final String KAFKA_TOPIC_GB_MESSAGE = "kafka.topic.history.gb.message";

    /**
     * kafka集群CAN历史数据topic配置名称(所有的can报文)s
     */
    public static final String KAFKA_TOPIC_CAN = "kafka.topic.history.can";
    public static final String KAFKA_TOPIC_CAN_EXP = "kafka.topic.history.can-exp";

    /**
     * kafka集群STATE历史数据topic配置名称(分时租赁实时状态)
     */
    public static final String KAFKA_TOPIC_MQTT_STATE = "kafka.topic.history.mqtt.state";
    public static final String KAFKA_TOPIC_MQTT_STATE_EXP = "kafka.topic.history.mqtt.state-exp";

    /**
     * kafka集群JT808位置历史数据topic配置名称
     */
    public static final String KAFKA_TOPIC_JT_POSITION = "kafka.topic.history.jt808.position";
    public static final String KAFKA_TOPIC_JT_POSITION_EXP = "kafka.topic.history.jt808.position-exp";
    /*--------------------*
     * TOPIC
     *--------------------*/
    /**
     * kafka集群GB网关协议错误数据topic
     */
    public static final String KAFKA_TOPIC_GATEWAY_GB_ERROR = "kafka.topic.gateway.gb.error";
    /**
     * kafka集群GB网关正常报文topic
     */
    public static final String KAFKA_TOPIC_GATEWAY_GB_SUCCESS = "kafka.topic.gateway.gb.success";
    /**
     * kafka集群车辆上线离线事件topic
     */
    public static final String KAFKA_TOPIC_GATEWAY_CONN = "kafka.topic.gateway.conn";

    /**
     * kafka集群车辆电池跳变事件topic
     */
    public static final String KAFKA_TOPIC_STREAM_JUMP_SOC = "kafka.topic.stream.jump-soc";

    /*--------------------*
     * 消费者组
     *--------------------*/
    public static final String KAFKA_CONSUMER_GROUP_STORAGE_GB_MESSAGE = "kafka.consumer.group.storage.gb.message";
    public static final String KAFKA_CONSUMER_GROUP_STORAGE_CAN = "kafka.consumer.group.storage.can";
    public static final String KAFKA_CONSUMER_GROUP_STORAGE_CAN_EXP = "kafka.consumer.group.storage.can-exp";
    public static final String KAFKA_CONSUMER_GROUP_STORAGE_MQTT_STATE = "kafka.consumer.group.storage.mqtt.state";
    public static final String KAFKA_CONSUMER_GROUP_STORAGE_MQTT_STATE_EXP = "kafka.consumer.group.storage.mqtt.state-exp";
    public static final String KAFKA_CONSUMER_GROUP_STORAGE_JT_POSITION = "kafka.consumer.group.storage.jt808.position";
    public static final String KAFKA_CONSUMER_GROUP_STORAGE_JT_POSITION_EXP = "kafka.consumer.group.storage.jt808.position-exp";

    /*GB网关上报数据*/
    public static final String KAFKA_CONSUMER_GROUP_RULE_GB_ERROR = "kafka.consumer.group.rule.gb.error";
    public static final String KAFKA_CONSUMER_GROUP_RULE_GB_SUCCESS = "kafka.consumer.group.rule.gb.success";
    public static final String KAFKA_CONSUMER_GROUP_RULE_CONN = "kafka.consumer.group.rule.conn";

    /*大数据实时计算*/
    public static final String KAFKA_CONSUMER_GROUP_RULE_STREAM_JUMP_SOC = "kafka.consumer.group.rule.stream.jump-soc";

    /*地标平台*/
    public static final String KAFKA_CONSUMER_GROUP_REPORT_GB_SUCCESS = "kafka.consumer.group.report.gb.success";

}
