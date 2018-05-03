package com.ccclubs.gateway.gb.constant;

/**
 * @Author: yeanzi
 * @Date: 2018/5/3
 * @Time: 16:47
 * Email:  yeanzhi@ccclubs.com
 * kafka消费者的Topic
 */
public class KafkaProducerKey {

    /*消息解析错误*/
    public static final String MESSAGE_DECODE_ERROR = "message.decode.error";

    /*消息校验错误*/
    public static final String MESSAGE_VALIDATE_FAIL = "message.validate.fail";

    /*消息处理过程异常*/
    public static final String MESSAGE_CONN_STATISTICS_EXCEPTION = "message.process.exception";

    /*消息业务处理异常*/
    public static final String MESSAGE_DELIVER_EXCEPTION = "message.deliver.exception";

    /*渠道报告异常*/
    public static final String MESSAGE_SINGLE_CHANNEL_DETAIL_EXCEPTION = "message.single.channel.detail.exception";

    /*消息帧过长异常*/
    public static final String MESSAGE_TOOLONG_FRAME_EXCEPTION = "message.toolong.frame.exception";

    /*渠道异常关闭异常*/
    public static final String CHANNEL_DISCONN_EXCEPTION = "channel.disconn.exception";

    /*其他过程处理的异常*/
    public static final String MESSAGE_PROCESS_OTHER_EXCEPTION = "message.process.other.exception";

}
