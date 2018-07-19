package com.ccclubs.gateway.jt808.service;

import com.ccclubs.gateway.jt808.process.command.Command;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Author: yeanzi
 * @Date: 2018/7/18
 * @Time: 14:49
 * Email:  yeanzhi@ccclubs.com
 * 命令执行缓存
 *     使用方式：
 *          1. 先开启命令监听
 *          2. 使用
 *          3. 关闭命令监听（清除缓存）
 */
public class CommandCache {
    public static final Logger LOG = LoggerFactory.getLogger(CommandCache.class);

    private static volatile Boolean OPEN_STATUS = Boolean.FALSE;

    private static List<Command> CMD_QUEUE = new ArrayList<>();

    private static Integer MAX_CMD_SIZE = 200;

    private static volatile String UNIQUENO;

    public static boolean isOpen() {
        return OPEN_STATUS;
    }

    public static void open(String uniqueNo) {
        if (!OPEN_STATUS) {
            OPEN_STATUS = Boolean.TRUE;
            UNIQUENO = uniqueNo;
            CMD_QUEUE.clear();
        }
    }

    public static void close() {
        if (OPEN_STATUS) {
            OPEN_STATUS = Boolean.FALSE;
            CMD_QUEUE.clear();
        }
    }

    public static List<Command> getAllCmd() {
        Assert.assertTrue(OPEN_STATUS);

        return CMD_QUEUE;
    }

    public static Command addCmd(String uniqueNo) {
        Assert.assertTrue(OPEN_STATUS);

        Command cmd = ofNewCmd(uniqueNo);
        if (CMD_QUEUE.size() > MAX_CMD_SIZE) {
            LOG.error("监听的命令达到最大值，请清除命令缓存: uniqueNo={}", uniqueNo);
        } else {
            CMD_QUEUE.add(cmd);
        }
        return cmd;
    }

    public static Optional<Command> getBy808SerivalNo(short serialNo) {
        Assert.assertTrue(OPEN_STATUS);

        return CMD_QUEUE.stream()
                .filter(cmd -> cmd.getSerialNo808() == serialNo)
                .findFirst();
    }

    public static Optional<Command> getByMqttSerivalNo(long serialNo) {
        Assert.assertTrue(OPEN_STATUS);

        return CMD_QUEUE.stream()
                .filter(cmd -> cmd.getSerialNoMqtt() == serialNo)
                .findFirst();
    }

    public static boolean isCurrent(String uniqueNo) {
        Assert.assertTrue(OPEN_STATUS);

        return UNIQUENO.equals(uniqueNo);
    }

    public static Command ofNewCmd(String uniqueNo) {
        return new Command().setUniqueNo(uniqueNo);
    }





}
