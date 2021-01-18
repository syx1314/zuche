package com.zql.app.shop.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by gaofeng on 2017/2/23.
 */
public class CommonTimeConvertUtils {

    /**
     * @param DATE1
     * @param DATE2
     * @return DATE1在后返回true
     */
    public static boolean compare(String DATE1, String DATE2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() >= dt2.getTime()) {
                return true;
            } else if (dt1.getTime() < dt2.getTime()) {
                return false;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }



    public static String DateToStr(Date date, String dateFormat) {

        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        String str = format.format(date);
        return str;
    }



    public static Date StrToDate(String str, String dateFormat) {

        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /*
   * 将时间戳转换为时间
   */
    public static Date StampToDate(String s) {
        long lt = new Long(s);
        Date date = new Date(lt);
        return date;
    }


    public static long StrToStamp(String s, String dateFormat) {
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        Long stamp = 0L;
        try {
            Date date = format.parse(s);
            stamp = date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return stamp;
    }



    public static String StampToStrHourMinute(long stamp) {
        Date date = new Date(stamp);
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        String str = format.format(date);
        return str;
    }



    public static String StampToStr(long stamp, String dateFormat) {
        Date date = new Date(stamp);
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        String str = format.format(date);
        return str;
    }


}
