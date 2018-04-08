package com.ccclubs.admin.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

/**
 * @author
 * @create 2018-03-21
 * @category generated by vc-coder
 **/
public class EvAlarmRecord implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * [id]编号
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * [uuid]uuid
     */

    private String uuid;

    /**
     * [vin]vin码
     */

    private String vin;

    /**
     * [alarm_type]故障类型
     */

    private Integer alarmType;

    /**
     * [alarm_type_value]报警类型标志位值
     */

    private Integer alarmTypeValue;

    /**
     * [alarm_level]故障等级
     */

    private Integer alarmLevel;

    /**
     * [hex_message]原始报文
     */

    private String hexMessage;

    /**
     * [start_time]报警时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;

    /**
     * [end_time]解除时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;

    /**
     * [status]状态
     */

    private Integer status;

    /**
     * [add_time]添加时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date addTime;

    /**
     * [update_time]更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;


    //默认构造函数
    public EvAlarmRecord() {

    }

    //主键构造函数
    public EvAlarmRecord(Long id) {
        this.id = id;
    }

    //设置非空字段
    public EvAlarmRecord setNotNull(Long id, String uuid, String vin, Date addTime) {
        this.id = id;
        this.uuid = uuid;
        this.vin = vin;
        this.addTime = addTime;
        return this;
    }


    @Transient
    private Object alarmTypeText;

    public Object getAlarmTypeText() {
        return this.alarmTypeText;
    }

    public void setAlarmTypeText(Object alarmTypeText) {
        this.alarmTypeText = alarmTypeText;
    }

    @Transient
    private Object alarmTypeValueText;

    public Object getAlarmTypeValueText() {
        return this.alarmTypeValueText;
    }

    public void setAlarmTypeValueText(Object alarmTypeValueText) {
        this.alarmTypeValueText = alarmTypeValueText;
    }

    @Transient
    private Object alarmLevelText;

    public Object getAlarmLevelText() {
        return this.alarmLevelText;
    }

    public void setAlarmLevelText(Object alarmLevelText) {
        this.alarmLevelText = alarmLevelText;
    }

    @Transient
    private Object statusText;

    public Object getStatusText() {
        return this.statusText;
    }

    public void setStatusText(Object statusText) {
        this.statusText = statusText;
    }

    /*******************************编号**********************************/
    /**
     * 编号 [非空]
     **/
    public Long getId() {
        return this.id;
    }

    /**
     * 编号 [非空]
     **/
    public void setId(Long id) {
        this.id = id;
    }
    /*******************************uuid**********************************/
    /**
     * uuid [非空]
     **/
    public String getUuid() {
        return this.uuid;
    }

    /**
     * uuid [非空]
     **/
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    /*******************************vin码**********************************/
    /**
     * vin码 [非空]
     **/
    public String getVin() {
        return this.vin;
    }

    /**
     * vin码 [非空]
     **/
    public void setVin(String vin) {
        this.vin = vin;
    }
    /*******************************故障类型**********************************/
    /**
     * 故障类型 [可空]
     **/
    public Integer getAlarmType() {
        return this.alarmType;
    }

    /**
     * 故障类型 [可空]
     **/
    public void setAlarmType(Integer alarmType) {
        this.alarmType = alarmType;
    }
    /*******************************报警类型标志位值**********************************/
    /**
     * 报警类型标志位值 [可空]
     **/
    public Integer getAlarmTypeValue() {
        return this.alarmTypeValue;
    }

    /**
     * 报警类型标志位值 [可空]
     **/
    public void setAlarmTypeValue(Integer alarmTypeValue) {
        this.alarmTypeValue = alarmTypeValue;
    }
    /*******************************故障等级**********************************/
    /**
     * 故障等级 [可空]
     **/
    public Integer getAlarmLevel() {
        return this.alarmLevel;
    }

    /**
     * 故障等级 [可空]
     **/
    public void setAlarmLevel(Integer alarmLevel) {
        this.alarmLevel = alarmLevel;
    }
    /*******************************原始报文**********************************/
    /**
     * 原始报文 [可空]
     **/
    public String getHexMessage() {
        return this.hexMessage;
    }

    /**
     * 原始报文 [可空]
     **/
    public void setHexMessage(String hexMessage) {
        this.hexMessage = hexMessage;
    }
    /*******************************报警时间**********************************/
    /**
     * 报警时间 [可空]
     **/
    public Date getStartTime() {
        return this.startTime;
    }

    /**
     * 报警时间 [可空]
     **/
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    /*******************************解除时间**********************************/
    /**
     * 解除时间 [可空]
     **/
    public Date getEndTime() {
        return this.endTime;
    }

    /**
     * 解除时间 [可空]
     **/
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    /*******************************状态**********************************/
    /**
     * 状态 [可空]
     **/
    public Integer getStatus() {
        return this.status;
    }

    /**
     * 状态 [可空]
     **/
    public void setStatus(Integer status) {
        this.status = status;
    }
    /*******************************添加时间**********************************/
    /**
     * 添加时间 [非空]
     **/
    public Date getAddTime() {
        return this.addTime;
    }

    /**
     * 添加时间 [非空]
     **/
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
    /*******************************更新时间**********************************/
    /**
     * 更新时间 [可空]
     **/
    public Date getUpdateTime() {
        return this.updateTime;
    }

    /**
     * 更新时间 [可空]
     **/
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}