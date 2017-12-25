package com.ccclubs.frm.spring.entity;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by taosm on 2017/5/31 0031.
 */
public class DateTimeUtil {
    public static final String UNIX_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String format2 = "yyyy-MM-dd";
    public static final String format3 = "yyyy-MM";
    public static final String format4 = "yyyy-MM-dd HH:mm";
    public static final String FORMAT5 = "yyyy-MM-dd HH:mm:ss.f";
    private static final SimpleDateFormat SDF_FORMAT1 = new SimpleDateFormat(UNIX_FORMAT);

    static {
        SDF_FORMAT1.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
    }


    public static Date getDateByFormat(String timeStr, String format) {
        // 日期时间格式
        //DateFormat datetimeDf = new SimpleDateFormat(format);

        Date date = null;
        // 根据日期时间格式将时间字符串转化为对象
        if (timeStr != null && !timeStr.isEmpty()) {
            Timestamp ts = Timestamp.valueOf(timeStr);
            date = new Date(ts.getTime());
        }
        return date;
    }

    public static long date2UnixFormat(String dateStr, String format) {
        long timeMills = -1;

        if (null != dateStr && !dateStr.isEmpty()) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
            Date result = null;
            try {
                result = sdf.parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (null != result) {
                timeMills = result.getTime();
            }
        }


        return timeMills;
    }


    public static int getSingleDate(long timeMills, int CalenderField) {
        int result = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeMills);
        result = calendar.get(CalenderField);
        return result;
    }

    public static String getDateTimeByUnixFormat(long timeMills) {
        String retDateTime = "";
        Date date = new Date(timeMills);
        retDateTime = SDF_FORMAT1.format(date);
        return retDateTime;
    }

    public static String getDateTimeByFormat(long timeMills, String format) {
        String retDateTime = "";

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        Date date = new Date(timeMills);
        retDateTime = sdf.format(date);

        return retDateTime;
    }

    //增加指定时间后的日期
    public static String getDateTimeByAddMills(String dateTime, long addMills) {
        long timeMills = DateTimeUtil.date2UnixFormat(dateTime, DateTimeUtil.UNIX_FORMAT);
        return DateTimeUtil.getDateTimeByUnixFormat(timeMills + addMills);
    }

    //将充电毫秒数转变为#.##格式的小时数
    public static String transformMillsToHourStr(long timeMills) {
        String retHourStr = "";
        float hours = (float) timeMills / (1000 * 60 * 60);
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        retHourStr = decimalFormat.format(hours);
        return retHourStr;
    }

    //汽车充电时间修正
    public static long getTimeMillsFixByInterval(long timeMills, int interval) {
        long retMills = 0;

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timeMills);
        int minute = cal.get(Calendar.MINUTE);
        minute = ((minute / interval)) * interval;
        cal.set(Calendar.MINUTE, minute);
        cal.set(Calendar.SECOND, 0);
        retMills = cal.getTimeInMillis();
        return retMills;
    }

    //下位机时间修正
    public static String getTimeMillsFixBySecondInterval(long timeMills, int interval) {
        long retMills = 0;
        String retDatetime = "";
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timeMills);
        int second = cal.get(Calendar.SECOND);
        int num = 60 / interval;
        for (int i = 1; i < num + 1; i++) {
            int start = interval * (i - 1);
            int end = interval * i;
            if ((start < second) && (end > second)) {
                cal.set(Calendar.SECOND, interval * (i - 1));
                break;
            }
        }
        retMills = cal.getTimeInMillis();
        retDatetime = getDateTimeByUnixFormat(retMills);
        return retDatetime;
    }

}
