package com.ccclubs.frm.spring.entity;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by taosm on 2017/5/31 0031.
 */
public class DateTimeUtil {
    public static final String format1="yyyy-MM-dd HH:mm:ss";
    public static final String format2="yyyy-MM-dd";
    public static final String format3="yyyy-MM";
    public static final String format4="yyyy-MM-dd HH:mm";

    public static long date2UnixFormat(String dateStr, String format){
        long timeMills=-1;
        try{
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
            timeMills = sdf.parse(dateStr).getTime();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return timeMills;
    }

    public static int getYear(long timeMills){
        int year = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeMills);
        year = calendar.get(Calendar.YEAR);
        return year;
    }

    public static int getMonth(long timeMills){
        int month = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeMills);
        month = calendar.get(Calendar.MONTH)+1;
        return month;
    }

    public static int getDay(long timeMills){
        int day = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeMills);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        return day;
    }

    public static int getHour(long timeMills){
        int hour = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeMills);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        return hour;
    }

    public static int getMinute(long timeMills){
        int minute = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeMills);
        minute = calendar.get(Calendar.MINUTE);
        return minute;
    }

    public static int getSecond(long timeMills){
        int second = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeMills);
        second = calendar.get(Calendar.SECOND);
        return second;
    }

    public static String getDateTimeByFormat1(long timeMills){
        String retDateTime="";
        try{
            SimpleDateFormat sdf = new SimpleDateFormat(format1);
            sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
            Date date = new Date();
            date.setTime(timeMills);
            retDateTime=sdf.format(date);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return retDateTime;
    }

    public static String getDateTimeByFormat(long timeMills,String format){
        String retDateTime="";
        try{
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
            Date date = new Date();
            date.setTime(timeMills);
            retDateTime=sdf.format(date);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return retDateTime;
    }

    //增加指定时间后的日期
    public static String getDateTimeByAddMills(String dateTime, long addMills){
        long timeMills = DateTimeUtil.date2UnixFormat(dateTime, DateTimeUtil.format1);
        return DateTimeUtil.getDateTimeByFormat1(timeMills+addMills);
    }

    //将充电毫秒数转变为#.##格式的小时数
    public static String transformMillsToHourStr(long timeMills){
        String retHourStr = "";
        float hours = (float)timeMills/(1000*60*60);
        DecimalFormat decimalFormat=new DecimalFormat("#.##");
        retHourStr=decimalFormat.format(hours);
        return retHourStr;
    }
    //汽车充电时间修正
    public static long getTimeMillsFixByInterval(long timeMills,int interval){
        long retMills=0;
        try{
            SimpleDateFormat sdf = new SimpleDateFormat(format1);
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(timeMills);
            int minute=cal.get(Calendar.MINUTE);
            minute=((int)(minute/interval))*interval;
            cal.set(Calendar.MINUTE,minute);
            cal.set(Calendar.SECOND,0);
            Date date = new Date();
            retMills=cal.getTimeInMillis();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return retMills;
    }

    //下位机时间修正
    public static String getTimeMillsFixBySecondInterval(long timeMills,int interval){
        long retMills = 0;
        String retDatetime = "";
        try{
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(timeMills);
            int second = cal.get(Calendar.SECOND);
            int num = 60/interval;
            for(int i=1;i<num+1;i++) {
                int start = interval * (i - 1);
                int end = interval * i;
                if (( start < second) && (end > second)) {
                    cal.set(Calendar.SECOND, interval * (i - 1));
                    break;
                }
            }
            retMills = cal.getTimeInMillis();
            retDatetime = getDateTimeByFormat1(retMills);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return retDatetime;
    }

}
