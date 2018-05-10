package com.ccclubs.gateway.gb.message.track;

import com.ccclubs.gateway.gb.inf.IExceptionDtoJsonParse;

/**
 * @Author: yeanzi
 * @Date: 2018/5/4
 * @Time: 14:51
 * Email:  yeanzhi@ccclubs.com
 * 记录消息在每一步的handler中的处理状态
 */
public class HandlerPacTrack {
    /**
     * 开始处理的时间戳
     */
    private Long startTime;

    /**
     * 处理完成时的时间戳
     */
    private Long endTime;

    /**
     * 该handler处理该消息实际用的时间（ms）
     *  usedTime = endTime - startTime
     */
    private Long usedTime;

    /**
     * 是否发生异常或者错误
     */
    private boolean errorOccur;

    private IExceptionDtoJsonParse exceptionDtoJsonParse;

    public HandlerPacTrack reset() {
        this.startTime = 0L;
        this.endTime = 0L;
        this.usedTime = 0L;
        this.errorOccur = false;
        this.exceptionDtoJsonParse = null;
        return this;
    }

    public Long getStartTime() {
        return startTime;
    }

    public HandlerPacTrack setStartTime(Long startTime) {
        this.startTime = startTime;
        return this;
    }

    public Long getEndTime() {
        return endTime;
    }

    public HandlerPacTrack setEndTime(Long endTime) {
        this.endTime = endTime;
        return this;
    }

    public Long getUsedTime() {
        return usedTime;
    }

    public HandlerPacTrack setUsedTime(Long usedTime) {
        this.usedTime = usedTime;
        return this;
    }

    public boolean isErrorOccur() {
        return errorOccur;
    }

    public HandlerPacTrack setErrorOccur(boolean errorOccur) {
        this.errorOccur = errorOccur;
        return this;
    }

    public IExceptionDtoJsonParse getExceptionDtoJsonParse() {
        return exceptionDtoJsonParse;
    }

    public HandlerPacTrack setExceptionDtoJsonParse(IExceptionDtoJsonParse exceptionDtoJsonParse) {
        this.exceptionDtoJsonParse = exceptionDtoJsonParse;
        return this;
    }
}
