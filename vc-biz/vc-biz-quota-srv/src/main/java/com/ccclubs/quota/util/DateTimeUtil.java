package com.ccclubs.quota.util;


import com.ccclubs.quota.vo.WeekBeanOutput;
import com.ccclubs.quota.service.PaceBlock;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/5/31 0031.
 */
public class DateTimeUtil {
    public static final String format1="yyyy-MM-dd HH:mm:ss";
    public static final String format2="yyyy-MM-dd";

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

    public  static  List<WeekBeanOutput> getWeekCount(){
        long calSize=0;
        try{
            SimpleDateFormat df = new SimpleDateFormat(format2);
            long from = df.parse("2017-10-02 00:00:00").getTime();
            long to = System.currentTimeMillis();
            calSize=(to-from)/(1000*3600*24*7);
        }catch (Exception e){
            e.printStackTrace();
        }

        List<WeekBeanOutput> weekList = new ArrayList<>();
        WeekBeanOutput weekBean = null;
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        int dayOfWeek = cal1.get(Calendar.DAY_OF_WEEK) - 1;
        int offset1 = 1 - dayOfWeek;
        int offset2 = 7 - dayOfWeek;
        cal1.add(Calendar.DAY_OF_WEEK, offset1 - 7);
        cal2.add(Calendar.DAY_OF_WEEK, offset2 - 7);
        for(int i=0;i<calSize;i++){
            weekBean = new WeekBeanOutput();
            String last_monday_datetime = getDateTimeByFormat1(cal1.getTimeInMillis()).substring(0,10)+" 00:00:00";
            String last_sunday_datetime = getDateTimeByFormat1(cal2.getTimeInMillis()).substring(0,10)+" 23:59:59";
            int year = cal1.get(Calendar.YEAR);
            int month = cal1.get(Calendar.MONTH)+1;
            weekBean.setYear(year);
            weekBean.setMonth(month);
            weekBean.setMonday_datetime(last_monday_datetime);
            weekBean.setSunday_datetime(last_sunday_datetime);
            cal1.add(Calendar.DAY_OF_WEEK, - 7);
            cal2.add(Calendar.DAY_OF_WEEK, - 7);
            weekList.add(weekBean);
        }
        return weekList;

    }

    //取得待计算周列表
    public static List<WeekBeanOutput> getWeekList(String calDate, int calSize){
        List<WeekBeanOutput> weekList = new ArrayList<>();
        WeekBeanOutput weekBean = null;
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        int dayOfWeek = cal1.get(Calendar.DAY_OF_WEEK) - 1;
        int offset1 = 1 - dayOfWeek;
        int offset2 = 7 - dayOfWeek;
        cal1.add(Calendar.DAY_OF_WEEK, offset1 - 7);
        cal2.add(Calendar.DAY_OF_WEEK, offset2 - 7);
        for(int i=0;i<calSize;i++){
            weekBean = new WeekBeanOutput();
            String last_monday_datetime = getDateTimeByFormat1(cal1.getTimeInMillis()).substring(0,10)+" 00:00:00";
            String last_sunday_datetime = getDateTimeByFormat1(cal2.getTimeInMillis()).substring(0,10)+" 23:59:59";
            int year = cal1.get(Calendar.YEAR);
            int month = cal1.get(Calendar.MONTH)+1;
            weekBean.setYear(year);
            weekBean.setMonth(month);
            weekBean.setMonday_datetime(last_monday_datetime);
            weekBean.setSunday_datetime(last_sunday_datetime);
            cal1.add(Calendar.DAY_OF_WEEK, - 7);
            cal2.add(Calendar.DAY_OF_WEEK, - 7);
            weekList.add(weekBean);
        }
        return weekList;
    }


    public static long getTimeMillsFixByInterval(long timeMills){
        long retMills=0;
        try{
            SimpleDateFormat sdf = new SimpleDateFormat(format1);
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(timeMills);
            int minute=cal.get(Calendar.MINUTE);
            minute=((int)(minute/12))*12;
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

    public static Map<Long,PaceBlock> generateBlockMap(String monday_datetime, String sunday_datetime){
        Map<Long,PaceBlock> blockMap = new LinkedHashMap<Long,PaceBlock>();
        try{
            SimpleDateFormat sdf = new SimpleDateFormat(format1);
            sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));

            Calendar start_cal = Calendar.getInstance();
            Calendar end_cal = Calendar.getInstance();

            long monday_timemills = DateTimeUtil.date2UnixFormat(monday_datetime, DateTimeUtil.format1);
            long sunday_timemills = DateTimeUtil.date2UnixFormat(sunday_datetime, DateTimeUtil.format1);

            start_cal.setTimeInMillis(monday_timemills);
            end_cal.setTimeInMillis(sunday_timemills);

            PaceBlock paceBlock = null;
            while(start_cal.getTimeInMillis()<end_cal.getTimeInMillis()){
                paceBlock = new PaceBlock();
                paceBlock.setBlock_start_timemills(start_cal.getTimeInMillis());
                paceBlock.setBlock_end_timemills(start_cal.getTimeInMillis()+12*60*1000);
                blockMap.put(start_cal.getTimeInMillis(),paceBlock);
                start_cal.add(Calendar.MINUTE,12);
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return blockMap;
    }


    public static int getMonthSpace(String date1, String date2)  {

        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String str1 = date2;
            String str2 = date1;
            Calendar bef = Calendar.getInstance();
            Calendar aft = Calendar.getInstance();
            bef.setTime(sdf.parse(str1));
            aft.setTime(sdf.parse(str2));
            int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
            int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
            //
            if(Math.abs(month + result)==0){
                return 1;
            }else{
                return Math.abs(month + result);
            }
        }catch ( Exception e){
            e.printStackTrace();
        }
        return 1;
    }


    /**
     * 计算两个日期之间相差的天数
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     */
    public static int daysBetween(String smdate,String bdate){
        long betweenDays=0;
        try{
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse(smdate));
            long time1 = cal.getTimeInMillis();
            cal.setTime(sdf.parse(bdate));
            long time2 = cal.getTimeInMillis();
            betweenDays =(time2-time1)/(1000*3600*24);

        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        return Integer.parseInt(String.valueOf(betweenDays));
    }

    public static String dateToString(Date date){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }


    public static void main(String[] args) {


//      System.out.print(DateTimeUtil.daysBetween("2017-10-23 00:00:00",DateTimeUtil.getDateTimeByFormat1(System.currentTimeMillis())));

      System.out.println(new Date(System.currentTimeMillis()));
      System.out.println(DateTimeUtil.dateToString(new Date(System.currentTimeMillis())));
//        System.out.println(daysBetween("2017-10-23 00:00:00","2017-10-26 14:23:26"));
    }
}
