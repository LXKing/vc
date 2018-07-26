package com.ccclubs.upgrade.dto;

import com.ccclubs.upgrade.constant.UpgradeType;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author: yeanzi
 * @Date: 2018/5/18
 * @Time: 14:25
 * Email:  yeanzhi@ccclubs.com
 * 车机版本升级任务
 */
public class UpgradeTask implements Serializable {
    /**
     * 该升级任务对应的升级管理ID
     *      用于唯一标识一次升级
     */
    private Integer upgradeManageId;

    @NotNull(message = "车辆vin码必填")
    private String vin;

    private String appId;

    // 升级类型(0=基础升级，1=插件升级，2=主版本升级)
    private UpgradeType upgradeType;

    // 目标升级版本信息
    private UpgradeVersion upgradeVersion;

    // 升级请求神剑
    private Long reqTime;
    // 升级所用时间
    private Long usedTime;

    /**
     * 依赖标记
     */
    // 当前任务的任务ID
    private String taskId;
    // 父升级任务的任务ID
    private String fatherTaskId;
    // 是否根升级任务（区别子升级任务）
    private boolean rootTask;

    // getter and setter--------------------------------------------------------------


    public String getVin() {
        return vin;
    }

    public UpgradeTask setVin(String vin) {
        this.vin = vin;
        return this;
    }

    public String getAppId() {
        return appId;
    }

    public UpgradeTask setAppId(String appId) {
        this.appId = appId;
        return this;
    }

    public UpgradeType getUpgradeType() {
        return upgradeType;
    }

    public UpgradeTask setUpgradeType(UpgradeType upgradeType) {
        this.upgradeType = upgradeType;
        return this;
    }

    public UpgradeVersion getUpgradeVersion() {
        return upgradeVersion;
    }

    public UpgradeTask setUpgradeVersion(UpgradeVersion upgradeVersion) {
        this.upgradeVersion = upgradeVersion;
        return this;
    }

    public Long getReqTime() {
        return reqTime;
    }

    public UpgradeTask setReqTime(Long reqTime) {
        this.reqTime = reqTime;
        return this;
    }

    public Long getUsedTime() {
        return usedTime;
    }

    public UpgradeTask setUsedTime(Long usedTime) {
        this.usedTime = usedTime;
        return this;
    }

    public String getTaskId() {
        return taskId;
    }

    public UpgradeTask setTaskId(String taskId) {
        this.taskId = taskId;
        return this;
    }

    public String getFatherTaskId() {
        return fatherTaskId;
    }

    public UpgradeTask setFatherTaskId(String fatherTaskId) {
        this.fatherTaskId = fatherTaskId;
        return this;
    }

    public boolean isRootTask() {
        return rootTask;
    }

    public UpgradeTask setRootTask(boolean rootTask) {
        this.rootTask = rootTask;
        return this;
    }

    public Integer getUpgradeManageId() {
        return upgradeManageId;
    }

    public UpgradeTask setUpgradeManageId(Integer upgradeManageId) {
        this.upgradeManageId = upgradeManageId;
        return this;
    }

    /**
     * 验证两个升级任务是否为同一任务
     * @param anotherTask
     * @return
     */
    public boolean sameAs(UpgradeTask anotherTask) {
        return
                this.getVin().equals(anotherTask.getVin()) &&
                this.getUpgradeManageId().equals(anotherTask.getUpgradeManageId()) &&
                this.getUpgradeVersion().getId() == anotherTask.getUpgradeVersion().getId() &&
                this.getUpgradeVersion().getPluginFileName().equals(anotherTask.getUpgradeVersion().getPluginFileName());

    }
}
