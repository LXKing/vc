package com.ccclubs.frm.spring.constant;

/**
 * kafka常量
 *
 * @author jianghaiyang
 * @create 2018-03-29
 **/
public class KafkaConst {
    /*--------------------*
     * 规则引擎下行数据 Topic
     *--------------------*/

    /*Topic: GB报文-车辆登入 */
    public static final String KAFKA_TOPIC_GB_LOGIN = "kafka.topic.gb.success-login";
    /*Topic: GB报文-实时信息上报 */
    public static final String KAFKA_TOPIC_GB_REAL = "kafka.topic.gb.success-real";
    /*Topic: GB报文-补发信息上报 */
    public static final String KAFKA_TOPIC_GB_REISSUE = "kafka.topic.gb.success-reissue";
    /*Topic: GB报文-车辆登出 */
    public static final String KAFKA_TOPIC_GB_LOGOUT = "kafka.topic.gb.success-logout";
    /*Topic: GB报文-心跳 */
    public static final String KAFKA_TOPIC_GB_HEART = "kafka.topic.gb.success-heart";
    /*Topic: GB报文-终端校时 */
    public static final String KAFKA_TOPIC_GB_TIME = "kafka.topic.gb.success-time";

    /*Topic: GB历史数据*/
    public static final String KAFKA_TOPIC_GB_MESSAGE = "kafka.topic.history.gb.message";
    /*Topic: CAN历史数据*/
    public static final String KAFKA_TOPIC_CAN = "kafka.topic.history.can";
    /*Topic: CAN异常历史数据*/
    public static final String KAFKA_TOPIC_CAN_EXP = "kafka.topic.history.can-exp";
    /*Topic: 分时租赁实时状态历史数据*/
    public static final String KAFKA_TOPIC_MQTT_STATE = "kafka.topic.history.mqtt.state";
    /*Topic: 分时租赁实时状态异常历史数据*/
    public static final String KAFKA_TOPIC_MQTT_STATE_EXP = "kafka.topic.history.mqtt.state-exp";
    /*Topic: 808位置历史数据*/
    public static final String KAFKA_TOPIC_JT_POSITION = "kafka.topic.history.jt808.position";
    /*Topic: 808位置异常历史数据*/
    public static final String KAFKA_TOPIC_JT_POSITION_EXP = "kafka.topic.history.jt808.position-exp";

    /*--------------------*
     * 网关上行数据 Topic
     *--------------------*/

    /*Topic: GB网关错误报文（协议层面）*/
    public static final String KAFKA_TOPIC_GATEWAY_GB_ERROR = "kafka.topic.gateway.gb.error";
    /*Topic: GB网关正常报文*/
    public static final String KAFKA_TOPIC_GATEWAY_GB_SUCCESS = "kafka.topic.gateway.gb.success";
    /*Topic: 车辆上下线数据*/
    public static final String KAFKA_TOPIC_GATEWAY_CONN = "kafka.topic.gateway.conn";

    /*--------------------*
     * 实时计算 Topic
     *--------------------*/

    /*Topic: 电池跳变数据（实时计算）*/
    public static final String KAFKA_TOPIC_STREAM_JUMP_SOC = "kafka.topic.stream.jump-soc";

    /*--------------------*
     * 规则引擎 消费者组
     *--------------------*/

    /*rule-engine 电池跳变数据（实时计算）消费者组*/
    public static final String KAFKA_CONSUMER_GROUP_RULE_STREAM_JUMP_SOC = "kafka.consumer.group.rule.stream.jump-soc";
    /*rule-engine 车辆上下线数据 消费者组*/
    public static final String KAFKA_CONSUMER_GROUP_RULE_CONN = "kafka.consumer.group.rule.conn";
    /*rule-engine GB网关上报正常数据 消费者组*/
    public static final String KAFKA_CONSUMER_GROUP_RULE_GB_SUCCESS = "kafka.consumer.group.rule.gb.success";
    /*rule-engine GB网关上报错误数据（协议层面） 消费者组*/
    public static final String KAFKA_CONSUMER_GROUP_RULE_GB_ERROR = "kafka.consumer.group.rule.gb.error";

    /*--------------------*
     * 存储服务 消费者组
     *--------------------*/

    /*storage GB历史数据入库 消费者组*/
    public static final String KAFKA_CONSUMER_GROUP_STORAGE_GB_MESSAGE = "kafka.consumer.group.storage.gb.message";
    /*storage CAN历史数据入库 消费者组*/
    public static final String KAFKA_CONSUMER_GROUP_STORAGE_CAN = "kafka.consumer.group.storage.can";
    /*storage CAN异常历史数据入库 消费者组*/
    public static final String KAFKA_CONSUMER_GROUP_STORAGE_CAN_EXP = "kafka.consumer.group.storage.can-exp";
    /*storage 分时租赁（cs_state）历史数据入库 消费者组*/
    public static final String KAFKA_CONSUMER_GROUP_STORAGE_MQTT_STATE = "kafka.consumer.group.storage.mqtt.state";
    /*storage 分时租赁（cs_state）异常历史数据入库 消费者组*/
    public static final String KAFKA_CONSUMER_GROUP_STORAGE_MQTT_STATE_EXP = "kafka.consumer.group.storage.mqtt.state-exp";
    /*storage 808位置 历史数据入库 消费者组*/
    public static final String KAFKA_CONSUMER_GROUP_STORAGE_JT_POSITION = "kafka.consumer.group.storage.jt808.position";
    /*storage 808位置 异常历史数据入库 消费者组*/
    public static final String KAFKA_CONSUMER_GROUP_STORAGE_JT_POSITION_EXP = "kafka.consumer.group.storage.jt808.position-exp";

    /*--------------------*
     * 数据上报平台 消费者组
     *--------------------*/

    /*report GB网关上报正常数据 天津数据中心 消费者组*/
    public static final String KAFKA_CONSUMER_GROUP_REPORT_GB_TIANJING = "kafka.consumer.group.report.gb.tianjing";

}
