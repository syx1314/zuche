package com.zql.app.lib.util;

import android.content.Context;

import com.zql.app.lib.BaseApplication;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import tjgl.com.android.lib.R;

/**
 * 日期操作工具类.
 * 
 * @author shimiso
 */

public class DateUtil {

	private static final String FORMAT = "yyyy-MM-dd HH:mm:ss";

	private static final SimpleDateFormat SDF_MD = new SimpleDateFormat("MM月dd日");

	private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");


	
	public static String getDateNext(Date date, int dayInterval){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE,dayInterval);//把日期往后增加一天.整数往后推,负数往前移动
		date=calendar.getTime(); //这个时间就是日期往后推一天的结果
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(date);
		return dateString;
	}
	
	public static int getAge(Date birthDay) throws Exception {
        Calendar cal = Calendar.getInstance();

        if (cal.before(birthDay)) {
            throw new IllegalArgumentException(
                "The birthDay is before Now.It's unbelievable!");
        }

        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH)+1;
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
       
        cal.setTime(birthDay);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                //monthNow==monthBirth
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age--;
                }
            } else {
                //monthNow>monthBirth
                age--;
            }
        }

        return age ;
    }


	


	public static Date str2Date(String str) {
		return str2Date(str, null);
	}

	public static Date str2Date(String str, String format) {
		if (str == null || str.length() == 0) {
			return null;
		}
		if (format == null || format.length() == 0) {
			format = FORMAT;
		}
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			date = sdf.parse(str);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;

	}


	public static Calendar str2Calendar(String str, String format) {

		Date date = str2Date(str, format);
		if (date == null) {
			return null;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);

		return c;

	}

	public static String date2Str(Calendar c) {// yyyy-MM-dd HH:mm:ss
		return date2Str(c, null);
	}

	public static String date2Str(Calendar c, String format) {
		if (c == null) {
			return null;
		}
		return date2Str(c.getTime(), format);
	}

	public static String date2Str(Date d) {// yyyy-MM-dd HH:mm:ss
		return date2Str(d, null);
	}

	public static String date2Str(Date d, String format) {// yyyy-MM-dd HH:mm:ss
		if (d == null) {
			return null;
		}
		if (format == null || format.length() == 0) {
			format = FORMAT;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String s = sdf.format(d);
		return s;
	}

	public static String getCurrDateStr(String format) {
		SimpleDateFormat sdf ;
		if(Validator.isBlank(format)){
			 sdf = new SimpleDateFormat(FORMAT);
		}else{
			 sdf = new SimpleDateFormat(format);
		}
		
		String s = sdf.format(new Date());
		return s;
	}



	// 格式到天
	public static String getDay(long time) {

		return new SimpleDateFormat("yyyy-MM-dd").format(time);

	}



	
	public static void calcuInterval(Date start, Date end, CallbackTime callback){
	        try {
	            //毫秒ms
	            long diff = end.getTime() - start.getTime();

	            long seconds = diff / 1000 % 60;
	            long minutes = diff / (60 * 1000) % 60;
	            long hours = diff / (60 * 60 * 1000) % 24;
	            long days = diff / (24 * 60 * 60 * 1000);
	            callback.onCallback(days, hours, minutes, seconds);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    } 


	/**
	 * 毫秒
	 * @param min 毫秒
	 * @return
	 */
	public static String getTimeIntervalStr(Context context,long min){
		StringBuilder sb = new StringBuilder();
        try {
            //毫秒ms
            long diff = min;

            long seconds = diff / 1000 % 60;
            long minutes = diff / (60 * 1000) % 60;
            long hours = diff / (60 * 60 * 1000) % 24;
            long days = diff / (24 * 60 * 60 * 1000);

            if(days>0){
            	sb.append(days).append(context.getString(R.string.day));
            }
            if(hours>0){
            	sb.append(hours).append(context.getString(R.string.hour));
            }
            if(minutes>0){
            	sb.append(minutes).append(context.getString(R.string.fen));
            }
            if(seconds>0){
            	sb.append(seconds).append(context.getString(R.string.miao));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
	/**
	 * 毫秒
	 * @param min 毫秒
	 * @return
	 */
	public static String getTimeIntervalStrHm(Context context,long min){
		StringBuilder sb = new StringBuilder();
		try {
			//毫秒ms
			long diff = min;

			long seconds = diff / 1000 % 60;
			long minutes = diff / (60 * 1000) % 60;
			long hours = diff / (60 * 60 * 1000) % 24;
			long days = diff / (24 * 60 * 60 * 1000);

			if(days>0){
				sb.append(days).append("d");
			}
			if(hours>0){
				sb.append(hours).append("h");
			}
			if(minutes>0){
				sb.append(minutes).append("m");
			}
			if(seconds>0){
				sb.append(seconds).append("s");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
    //时间间隔 5h32m
    public static String getTimeHM(long start, long end){
		StringBuilder sb = new StringBuilder();
        try {
            //毫秒ms
            long diff = end - start;

            long seconds = diff / 1000 % 60;
            long minutes = diff / (60 * 1000) % 60;
            long hours = diff / (60 * 60 * 1000) % 24;
            if(hours>0){
            	sb.append(hours).append("h");
            }
            if(minutes>0){
            	sb.append(minutes).append("m");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    //时间间隔  165 分钟
    public static String getTimeHM(int diff){
		StringBuilder sb = new StringBuilder();
        try {
			long minutes = diff>=60?(diff*1L% 60):diff;
            long hours = diff*1L / (60) ;
            if(hours>0){
            	sb.append(hours).append("h");
            }
            if(minutes>0){
            	sb.append(minutes).append("m");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
	//时间间隔  165 分钟
	public static String getTimeMS(int diff){
		StringBuilder sb = new StringBuilder();
		try {
			long minutes = diff>=60?(diff*1L% 60):diff;
			long hours = diff*1L / (60) ;
			if(hours>0){
				sb.append(hours).append("h");
			}
			if(minutes>0){
				sb.append(minutes).append("m");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	//时间间隔  165 分钟
	public static String getTimeHM2(int diff){
		StringBuilder sb = new StringBuilder();
		try {
			long minutes = diff>=60?(diff*1L% 60):diff;
			long hours = diff*1L / (60) % 24;
			if(hours>0){
				sb.append(hours).append("h");
			}
			if(minutes>0){
				sb.append(minutes).append("m");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

    //时间间隔  165 分钟  分钟
    public static String getMinHM(Context context,int mint){
		StringBuilder sb = new StringBuilder();
        try {

            long hours = mint/60;
			long minutes = mint-hours*60;
            if(hours>0){
            	sb.append(hours).append(context.getString(R.string.hour));
            }
            if(minutes>0){
            	sb.append(minutes).append(context.getString(R.string.fen));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }


	public static String getWeek(Date date,String[] weeks) {

//		String[] weeks = { BaseApplication.mContext.getString(R.string.common_week_sun), BaseApplication.mContext.getString(R.string.common_week_mon),  BaseApplication.mContext.getString(R.string.common_week_tue),  BaseApplication.mContext.getString(R.string.common_week_wed),  BaseApplication.mContext.getString(R.string.common_week_thu),  BaseApplication.mContext.getString(R.string.common_week_fri),  BaseApplication.mContext.getString(R.string.common_week_sat)};
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
		cal.setFirstDayOfWeek(Calendar.MONDAY);
	    int days = cal.get(Calendar.DAY_OF_WEEK);
	    return weeks[days-1];
	}
	public static String getWeek2(Date date) {

		String[] weeks = { "日","一", "二", "三",  "四","五","六"};
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int days = cal.get(Calendar.DAY_OF_WEEK);
		return weeks[days-1];
	}
	public interface CallbackTime{
		void onCallback(long days, long hours, long minutes, long seconds);
	}
	

	public static Date getDate(String dateStr, String format) {
		Date date = null ;
        SimpleDateFormat sdf   =   new SimpleDateFormat(format);
		try {
			
			date =  sdf.parse(dateStr);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}


	public static String getDay(String date) {
		String day = null ;
		try{
			day = date.substring(8);
		}catch(Exception e){
			e.printStackTrace();
		}
		return day;
	}


    /**
	 * 加分钟
	 * @param startTime
	 * @param mm
     * @return
     */
	public static Date addMinute(Date startTime,int mm){
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(startTime);
		calendar.add(Calendar.MINUTE,mm);
		return calendar.getTime();
	}

	/**
	 * 加分钟
	 * @param startTime
	 * @param mm
	 * @return
	 */
	public static Date addMinute(Date startTime,int mm,TimeZone zone){
		Calendar calendar=Calendar.getInstance();
		calendar.setTimeZone(zone);
		calendar.setTime(startTime);
		calendar.add(Calendar.MINUTE,mm);
		return calendar.getTime();
	}


	/**
	 * 加天数
	 * @param startTime
	 * @param day
     * @return
     */
	public static Date addDay(Date startTime,int day){
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(startTime);
		calendar.add(Calendar.DATE,day);
		return calendar.getTime();
	}

	/**
	 * 加月份
	 * @param startTime
	 * @param mm
	 * @return
	 */
	public static Date addMM(Date startTime,int mm){
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(startTime);
		calendar.add(Calendar.MONTH,mm);
		return calendar.getTime();
	}



	/**
	 * 计算两个日期之间的天数
	 * @param date1
	 * @param date2
     * @return
     */
	public static int daysBetween(Date date1, Date date2)
	{
		if(date1!=null && date2 !=null) {
			date1 = str2Date(date2Str(date1, "yyyy-MM-dd 00:00"), "yyy-MM-dd HH:mm");
			date2 = str2Date(date2Str(date2, "yyyy-MM-dd 00:00"), "yyy-MM-dd HH:mm");
			Calendar cal = Calendar.getInstance();
			cal.setTime(date1);
			long time1 = cal.getTimeInMillis();
			cal.setTime(date2);
			long time2 = cal.getTimeInMillis();
			long between_days = (time2 - time1) / (1000 * 3600 * 24);

			return Integer.parseInt(String.valueOf(between_days));
		}
		return 0;
	}

	/**
	 * 获取当前时间的yyyy-MM-dd字符串格式
	 * @return
     */
	public static String getCurrentDateForSDF() {
		return getCurrDateStr("yyyy-MM-dd");
	}
	/**
	 * 获取当前时间的yyyy-MM-dd字符串格式
	 * @return
	 */
	public static String getCurrentDateForSDFHMS() {
		return getCurrDateStr("yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * 获取指定calendar时间的yyyy-MM-dd字符串形式
	 * @param c
     * @return
     */
	public static String getCalendarStr(Calendar c) {
		return date2Str(c, "yyyy-MM-dd");
	}



//	/**
//	 * 获取特殊形式的日期（5月1日）
//	 * @return
//     */
//	public static String getMMDDSpecial(String dateStr) {
//		Date date = str2Date(dateStr, "yyyy-MM-dd");
//		return date2Str(date, BaseApplication.mContext.getString(R.string.date_formet_1));
//	}
	/**
	 * 获取特殊形式的日期（5月1日）
	 * @return
	 */
	public static String getMMDDSpecial(String dateStr,String format) {
		Date date = str2Date(dateStr, "yyyy-MM-dd");
		return date2Str(date, format);
	}
	/**
	 * 获取特殊形式的日期（5月1日）
	 * @return
     */
	public static String getMM_DDSpecial(String dateStr) {
		Date date = str2Date(dateStr, "yyyy-MM-dd");
		return date2Str(date, "MM-dd");
	}

	/**
	 * 获取特殊形式的时间(hh:mm）
	 * @param dateStr
	 * @return
     */
	public static String getHHMMSpecial(String dateStr) {
		Date date = str2Date(dateStr, "yyyy-MM-dd");
		return date2Str(date, "hh:mm");
	}

	/**
	 * 获取特殊形式的时间(hh:mm）
	 * @param dateStr
	 * @return
	 */
	public static String getHHMMFromDate(String dateStr) {
		Date date = str2Date(dateStr, "yyyy-MM-dd HH:mm:ss");
		return date2Str(date, "HH:mm");
	}


	/**
	 * 获取特殊形式的日期（05-01）
	 * @return
	 */
	public static String getMMDD(String dateStr) {
		Date date = str2Date(dateStr, "yyyy-MM-dd");
		return date2Str(date, "MM-dd");
	}


//	/**
//	 * 计算日期是星期几
//	 * @param dateStr
//	 * @return
//     */
//	public static String calculateWeek(String dateStr) {
//		Date date = str2Date(dateStr, "yyyy-MM-dd");
//		return getWeek(date);
//	}
	/**
	 * 计算日期是星期几
	 * @param dateStr
	 * @return
	 */
	public static String calculateWeek(String dateStr,String[] weeks) {
		Date date = str2Date(dateStr, "yyyy-MM-dd");
		return getWeek(date,weeks);
	}

	/**
	 * 判断time2是否在时间区间范围内
	 * @param time1 范围的开始时间
	 * @param time2 要判断是否在范围中的时间
	 * @param time3 范围的结束时间
	 * @return
	 * @throws ParseException
	 */
	public static boolean compareCalendarTimePeriod(String time1, String time2, String time3) throws ParseException {

		DateFormat df = new SimpleDateFormat("HH:mm");
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		Calendar c3 = Calendar.getInstance();
		Calendar c4 = Calendar.getInstance();
		Calendar c5 = Calendar.getInstance();

		// 暂时规定为24:00 用户只能输入至24:00
		c4.setTime(df.parse("24:00"));
		c5.setTime(df.parse("00:00"));

		if (Validator.isNotEmpty(time1) && Validator.isNotEmpty(time2)) {
			c1.setTime(df.parse(time1));
			c2.setTime(df.parse(time2));
			//<=  改成<  2020-1-13
			if ((c1.compareTo(c2) <0) && (c2.compareTo(c4) <= 0)) {
				//验证非正常,需要担保的时间段
				return false;
			} else {
				if (Validator.isNotEmpty(time3)) {
					c3.setTime(df.parse(time3));
                    return (c5.compareTo(c2) > 0) || (c2.compareTo(c3) > 0);
				} else {
					return true;
				}
			}
		} else {
			return true;
		}
	}


	/**
	 * 判断两个日期之间的大小
	 * @param date1
	 * @param date2
     * @return
     */
	public static int compareDate(String date1, String date2) {
		try {
			Date dt1 = SDF.parse(date1);
			Date dt2 = SDF.parse(date2);
			if (dt1.getTime() > dt2.getTime()) {
				return 1;
			} else if (dt1.getTime() < dt2.getTime()) {
				return -1;
			} else {
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}

}
