package com.ccclubs.gateway.gb.handler.process;

import com.ccclubs.gateway.gb.inf.MsgSender;
import com.ccclubs.gateway.gb.message.GBPackage;
import com.ccclubs.gateway.gb.reflect.ClientCache;
import com.ccclubs.gateway.gb.reflect.GBConnection;

import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author: yeanzi
 * @Date: 2018/4/2
 * @Time: 15:02
 * Email:  yeanzhi@ccclubs.com
 * 用于下发下行命令
 */
@Deprecated
public class GBMsgResponser {

    /**
     * TODO 这里的消息队列意义不大，但是如果考虑 write(msg)的消息的顺序性的话，还是有必要的
     *      并且，给每个channel都定义一个自己的下行消息队列，保证消息的顺序性
     */
    private static final ConcurrentLinkedQueue<GBPackage> TASK_QUEUE = new ConcurrentLinkedQueue<>();

    private ExecutorService taskExecutor;

    private MsgSender sender;

    private int threadPoolSize;

    public static GBMsgResponser ofSpecifiedSize(int threadPoolSize) {
        GBMsgResponser newResponser = new GBMsgResponser();
        newResponser.threadPoolSize = threadPoolSize;
        newResponser.taskExecutor = Executors.newFixedThreadPool(threadPoolSize);
        return newResponser;
    }

    public static void addTask(GBPackage pac) {
        TASK_QUEUE.add(pac);
    }

    public void start() {
        for (int i = 0; i < this.threadPoolSize; i++) {
            taskExecutor.execute(() -> {
                while(true) {
                    final GBPackage pac = TASK_QUEUE.poll();
                    if (null != pac) {
                        // TODO 消息处理

                        // 获取sockeChannel
                        GBConnection conn = ClientCache.getByVIN(pac.getHeader().getUniqueNo());
                        if (Objects.nonNull(conn)) {
                            conn.send(pac);
                        }
                        System.out.println("下发命令完成");
                    } else {
                        try {
                            TimeUnit.MILLISECONDS.sleep(2L);
                        } catch (InterruptedException exp) {
                            exp.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            GBPackage newPac = new GBPackage();
            newPac.setValidCode((byte)i);
            TASK_QUEUE.offer(newPac);
        }
        GBMsgResponser newResp = GBMsgResponser.ofSpecifiedSize(3);
        newResp.start();
    }
}
