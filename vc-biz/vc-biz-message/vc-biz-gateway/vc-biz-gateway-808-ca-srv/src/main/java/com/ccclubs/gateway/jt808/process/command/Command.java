package com.ccclubs.gateway.jt808.process.command;

import com.ccclubs.gateway.jt808.constant.CommandStatu;
import com.ccclubs.gateway.jt808.constant.msg.DownPacType;

import java.time.LocalDateTime;

/**
 * @Author: yeanzi
 * @Date: 2018/6/4
 * @Time: 18:01
 * Email:  yeanzhi@ccclubs.com
 * 下行命令
 */
public class Command {

    /**
     * 终端唯一标识
     */
    private String uniqueNo;

    /**
     * 下行消息类型
     */
    private DownPacType downPacType;

    /**
     * 命令状态
     */
    private CommandStatu commandStatu;

    /**
     * 命令发送时间
     */
    private LocalDateTime sendTime;


}