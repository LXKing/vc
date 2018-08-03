package com.ccclubs.upgrade.inf;

import com.ccclubs.upgrade.constant.UpgradeType;
import com.ccclubs.upgrade.dto.UpgradeTask;
import com.ccclubs.upgrade.dto.UpgradeVersion;

/**
 * @Author: yeanzi
 * @Date: 2018/5/18
 * @Time: 15:12
 * Email:  yeanzhi@ccclubs.com
 */
public interface UpgradeTaskQueueInf {

    /**
     * 检查当前任务是否在升级处理队列中
     * @param task
     * @return
     */
    boolean checkExistInProcessQueue(UpgradeTask task);

    /**
     * 检查当前任务是否在升级请求队列中
     * @param currentTask
     * @return
     */
    boolean checkExistInReqQueue(UpgradeTask currentTask);

    /**
     * 当子升级任务完成后，通知延迟升级队列中的父升级任务
     * @param task
     */
    void notifyFatherTask(UpgradeTask task);

    /**
     * 生成子任务，调整升级队列
     * 1. 从升级处理队列中移出
     * 2. 进入延迟升级队列
     * 3. 创建目标主版本升级任务
     * 4. 将子任务加入升级请求队列
     * @param task          当前升级处理的任务
     * @param upgradeType   子任务升级类型
     * @param destVersion   目标升级版本
     */
    void generateSubTaskAndAdjustQueue(UpgradeTask task, UpgradeType upgradeType, UpgradeVersion destVersion);

    /**
     * 当处理队列中的升级任务升级异常或者超时时：
     *      1. 将该任务从处理队列中移出
     *      2. 当存在父任务时，循环移出依赖的父任务
     * @param task
     */
    void removeTasksFromProcessQueueByLoop(UpgradeTask task);
}
