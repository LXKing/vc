package com.ccclubs.gateway.gb.message.common;

import com.ccclubs.gateway.gb.exception.MsgDecodeException;
import com.ccclubs.gateway.gb.utils.ValidUtil;
import io.netty.buffer.ByteBuf;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @Author: yeanzi
 * @Date: 2018/3/26
 * @Time: 16:26
 * Email:  yeanzhi@ccclubs.com
 */
public class GBDateTime {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int min;
    private int sec;

    public int getYear() {
        return year;
    }

    public GBDateTime setYear(int year) {
        this.year = year;
        return this;
    }

    public int getMonth() {
        return month;
    }

    public GBDateTime setMonth(int month) {
        this.month = month;
        return this;
    }

    public int getDay() {
        return day;
    }

    public GBDateTime setDay(int day) {
        this.day = day;
        return this;
    }

    public int getHour() {
        return hour;
    }

    public GBDateTime setHour(int hour) {
        this.hour = hour;
        return this;
    }

    public int getMin() {
        return min;
    }

    public GBDateTime setMin(int min) {
        this.min = min;
        return this;
    }

    public int getSec() {
        return sec;
    }

    public GBDateTime setSec(int sec) {
        this.sec = sec;
        return this;
    }

    public boolean checkDateTime() {
        return
                ValidUtil.rangeValid(this.year, 0, 99)
                        && ValidUtil.rangeValid(this.month, 1, 12)
                        && ValidUtil.rangeValid(this.day, 1, 31)
                        && ValidUtil.rangeValid(this.hour, 0, 23)
                        && ValidUtil.rangeValid(this.min, 0, 59)
                        && ValidUtil.rangeValid(this.sec, 0, 59);
    }

    public GBDateTime write2Buf(ByteBuf buf) {
        buf.writeByte(this.year & 0xFF)
                .writeByte(this.month & 0xFF)
                .writeByte(this.day & 0xFF)
                .writeByte(this.hour & 0xFF)
                .writeByte(this.min & 0xFF)
                .writeByte(this.sec & 0xFF);
        return this;
    }

    public static GBDateTime readFromBuf(ByteBuf buf) {
        GBDateTime newDateTime = new GBDateTime()
                .setYear(buf.readUnsignedByte())
                .setMonth(buf.readUnsignedByte())
                .setDay(buf.readUnsignedByte())
                .setHour(buf.readUnsignedByte())
                .setMin(buf.readUnsignedByte())
                .setSec(buf.readUnsignedByte());

        if (newDateTime.checkDateTime()) {
            return newDateTime;
        } else {
            throw new MsgDecodeException("日期时间不正确");
        }
    }

    public static GBDateTime readFromTime(long timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        GBDateTime newDateTime = new GBDateTime()
                .setYear(localDateTime.getYear() - 2000)
                .setMonth(localDateTime.getMonthValue())
                .setDay(localDateTime.getDayOfMonth())
                .setHour(localDateTime.getHour())
                .setMin(localDateTime.getMinute())
                .setSec(localDateTime.getSecond());

        if (newDateTime.checkDateTime()) {
            return newDateTime;
        } else {
            throw new MsgDecodeException("日期时间不正确");
        }
    }

    public static void main(String[] args) {
        GBDateTime time =
        GBDateTime.readFromTime(new Date().getTime());
        System.out.println(time);
    }

}
