package com.hly.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	private DateUtil() {
	}

	public static final String ISO_DATETIME_FORMAT = "dd-MMM-yyyy HH:mm:ss";
	public static final String ISO_DATETIME_WITH_MILLISECOND_FORMAT = "dd-MMM-yyyy HH:mm:ss.SSS";
	public static final String ISO_DATE_FORMAT = "dd-MMM-yyyy";
	public static final String ISO_SHORT_DATE_FORMAT = "dd-MMM-yy";
	public static final String ISO_TIME_FORMAT = "HH:mm:ss";
	public static final String ISO_TIME_WITH_MILLISECOND_FORMAT = "HH:mm:ss.SSS";
	public static final String UNIX_LONG_DATE_FORMAT = "EEE MMM dd HH:mm:ss z yyyy";
	public static final String US_DATE_FORMAT = "MM/dd/yyyy";
	public static final String US_SHORT_DATE_FORMAT = "MM/dd/yy";

	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 将日期格式化为特定的字符串(Date to String)
	 * 
	 * @param date
	 *            java.util.Date
	 * @param format
	 *            可以为null,默认格式为"yyyy-MM-dd HH:mm:ss"
	 * @return 返回"yyyy-MM-dd HH:mm:ss,yyyy-MM-dd"格式的字符串,如果为空或null则的返回yyyy-MM-dd HH:mm:ss
	 * @throws Exception
	 */
	public static String format(Date date, String format) throws Exception {
		if (date == null)
			return "";
		try {
			if (format == null) {
				format = DATETIME_FORMAT;
			}
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		} catch (Exception ex) {
			Exception ue = new Exception("日期格式化产生异常", ex);
			throw ue;
		} catch (Throwable t) {
			throw new Exception("日期格式化产生异常", t);
		}
	}

	/**
	 * 将日期格式化为特定的字符串(Date to String)
	 * 
	 * @param date
	 *            java.util.Date
	 * @return 返回"yyyy-MM-dd HH:mm:ss"格式的字符串
	 * @throws Exception
	 */
	public static String format(Date date) throws Exception {

		return format(date, null);
	}

	/**
	 * 将日期字符串解析为日期类型(String to Date)
	 * 
	 * @param dateString
	 *            不可心为null或空
	 * @param format
	 *            可以为null,默认格式化"yyyy-MM-dd"
	 * @return
	 * @throws Exception
	 */
	public static Date parse(String dateString, String format) throws Exception {

		try {
			if (format == null) {
				format = DATETIME_FORMAT;
			}
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.parse(dateString);
		} catch (Exception ex) {
			Exception ue = new Exception("格式化日期产生异常", ex);
			throw ue;
		} catch (Throwable t) {
			throw new Exception("格式化日期产生异常", t);
		}
	}

	/**
	 * 将日期格式化为特定的字符串(Date to String)
	 * 
	 * @param dateString
	 * @return
	 * @throws Exception
	 */
	public static Date parse(String dateString) throws Exception {

		return parse(dateString, null);
	}
	
	
	//字符串形式的时间转化为Long形。
	public static Long toLong(String dateTime,String format) {
		SimpleDateFormat sdf = null;
		sdf = new SimpleDateFormat(format);
		Date date = null;
		if (dateTime != null) {
			try {
				date = sdf.parse(dateTime);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return new Long(date.getTime());
	}
	
	//把Long形的时间转化为string形式的。
	public static String toString(Long dateTime ,String format){
		String str="";
		Date date = new Date();
    	if(dateTime!=null){
    		date.setTime(dateTime.longValue());
    		SimpleDateFormat sdf = null;
    		sdf = new SimpleDateFormat(format);
    		str= sdf.format(date);
    	}else{
    		return "";
    	} 	
		return str ;
	}
	
	//把数据库中 object(long) 型的时间转化为string类型的。
	public static String toString(Object val,String format){
		String str="";
		if(val != null){
			Long dateTime = Long.valueOf(val.toString());
			str = toString(dateTime,format);
		}
		return str;
	}
	

	/**
	 * 比较两个日期间隔，返回天数
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static long getPeriodDate(Date d1, Date d2) {
		return (d1.getTime() - d2.getTime()) / 1000 / 60 / 60 / 24;
	}

	/***
	 * 得到两个时间相隔的时间差
	 * 
	 * @param start
	 *            开始时间字符串 yyyy-MM-dd HH:mm:ss
	 * @param end
	 *            结束时间字符串 yyyy-MM-dd HH:mm:ss
	 * @return XX天XX小时XX分XX秒
	 */
	public static String getTimelag(String start, String end) throws Exception {
		Date now;
		Date date;
		try {
			now = parse(start);
			date = parse(end);
			return getTimelag(now, date);
		} catch (Exception ex) {
			Exception ue = new Exception("获取间隔日期时产生异常", ex);
			throw ue;
		}
	}

	/***
	 * 得到两个时间相隔的时间差
	 * 
	 * @param start
	 *            开始时间
	 * @param end
	 *            结束时间
	 * @return XX天XX小时XX分XX秒
	 */
	public static String getTimelag(Date start, Date end) throws Exception {
		try {
			long l = end.getTime() - start.getTime();
			long day = l / (24 * 60 * 60 * 1000);
			long hour = (l / (60 * 60 * 1000) - day * 24);
			long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
			long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
			return "" + day + "天" + hour + "小时" + min + "分" + s + "秒";

		} catch (Exception ex) {
			Exception ue = new Exception("获取间隔日期时产生异常", ex);
			throw ue;
		}
	}

	/**
	 * 得到两个日期相差多少天
	 * 
	 * @param startDate
	 *            2013-03-01
	 * @param endDate
	 *            2013-03-09
	 * @return
	 * @throws Exception
	 */
	public static long getTimelagDay(String startDate, String endDate)
			throws Exception {
		try {
			startDate = startDate + " 00:00:00";
			endDate = endDate + " 00:00:00";

			Date start = parse(startDate);
			Date end = parse(endDate);

			long l = end.getTime() - start.getTime();
			long day = l / (24 * 60 * 60 * 1000);
			return day;

		} catch (Exception ex) {
			Exception ue = new Exception("获取间隔日期时产生异常", ex);
			throw ue;
		}
	}

	/**
	 * 得到当天时间的区域 如：2011-11-04 00：00：00 ~ 2011-11-04 23：59：59
	 * 
	 * @return
	 */
	public static String[] getCurrentTimeRange() {
		Calendar start = Calendar.getInstance();

		start.set(Calendar.HOUR_OF_DAY, 0);
		start.set(Calendar.MINUTE, 0);
		start.set(Calendar.SECOND, 0);

		Calendar end = Calendar.getInstance();

		end.set(Calendar.HOUR_OF_DAY, 23);
		end.set(Calendar.MINUTE, 59);
		end.set(Calendar.SECOND, 59);

		String[] timeRange = new String[2];
		try {
			timeRange[0] = DateUtil.format(start.getTime());
			timeRange[1] = DateUtil.format(end.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return timeRange;
	}

	public static String[] getTimeRange(String day) {
		if (StringUtil.isNullOrEmpty(day)) {
			day = getSomeDay(0);
		}

		Calendar start = Calendar.getInstance();
		try {
			start.setTime(DateUtil.parse(day, DATE_FORMAT));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		start.set(Calendar.HOUR_OF_DAY, 0);
		start.set(Calendar.MINUTE, 0);
		start.set(Calendar.SECOND, 0);

		Calendar end = Calendar.getInstance();
		try {
			end.setTime(DateUtil.parse(day, DATE_FORMAT));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		end.set(Calendar.HOUR_OF_DAY, 23);
		end.set(Calendar.MINUTE, 59);
		end.set(Calendar.SECOND, 59);

		String[] timeRange = new String[2];
		try {
			timeRange[0] = DateUtil.format(start.getTime());
			timeRange[1] = DateUtil.format(end.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return timeRange;
	}

	/**
	 * 得到某天
	 * 
	 * @param interval
	 * @return
	 */
	public static String getSomeDay(int interval) {
		String day = null;
		Calendar now = Calendar.getInstance();
		now.set(Calendar.DAY_OF_MONTH, now.get(Calendar.DAY_OF_MONTH)
				+ interval);

		try {
			day = DateUtil.format(now.getTime(), DateUtil.DATE_FORMAT);
		} catch (Exception e) {
		}
		return day;
	}
	
	//把超期的时间转化为String字符串，精确到小时
		public static String toOverTimeString(Long lastDate,Long cycle){
			if(lastDate==0){
				return "从未巡检过";
			}
			Long nowDate = (new Date()).getTime();
			Long overDate = nowDate-lastDate-cycle;
			if(overDate<=0){
				return "未超期";
			}else if(overDate>0&&overDate<=3600000){
				return "1小时内";
			}else if(overDate>3600000&&overDate<=86400000){
				//1天内
				int hour = (int) (overDate/3600000);
				return hour+"小时";
			}else{
				//超过1天的
				int day = (int) (overDate/86400000);
				int hour = (int) ((overDate%86400000)/3600000);
				String str = day+"天"+(hour==0?"":hour+"小时");
				return str;
			}
		}
	//把超期的时间转化为String字符串，精确到天	
		public static String toOverTimeString(Long valid){
			Long nowDate = (new Date()).getTime();
			Long overDate = nowDate-valid;
			if(overDate<=0){
				return "未到期";
			}else if(overDate>0&&overDate<=86400000){
				return "今天到期";
			}else{
				//超过1天的
				int day = (int) (overDate/86400000);
				String str = day+"天";
				return str;
			}
		}	
		
		//获取时间的格式信息
		public static String getDateFormatMsg(String date){
			if(date != null && !"".equals(date)){		
				date = date.trim();
				String reg1 = "[0-9]{4}[-]{1}[0-9]{1,2}[-]{1}[0-9]{1,2}";
				if(date.matches(reg1)){
					return "yyyy-MM-dd";
				}
				String reg2 = "[0-9]{4}[-]{1}[0-9]{1,2}[-]{1}[0-9]{1,2}[\\s]+[0-9]{1,2}[:]{1}[0-9]{1,2}";
				if(date.matches(reg2)){
					return "yyyy-MM-dd HH:mm";
				}
				String reg3 = "[0-9]{4}[-]{1}[0-9]{1,2}[-]{1}[0-9]{1,2}[\\s]+[0-9]{1,2}[:]{1}[0-9]{1,2}[:]{1}[0-9]{1,2}";
				if(date.matches(reg3)){
					return "yyyy-MM-dd HH:mm:ss";
				}		
			}
			return null;		
		}

	public static void main(String[] args) throws Exception {
		String start = "2014-08-1 8:8:12";
		String end = "2014-08-2 13:23:11";
		String test="2014-06-1 13:23:11";
		 String timeString="2014-08-02";
		/*System.out.println(DateUtil.toLong(start, DATETIME_FORMAT));
		System.out.println(DateUtil.toLong(end, DATETIME_FORMAT));
		System.out.println(DateUtil.toLong(test, DATETIME_FORMAT));
		System.out.println(DateUtil.toLong(timeString, DATE_FORMAT));
		System.out.println(DateUtil.getTimelag(start, end));*/
     /*
		System.out.println(getCurrentTimeRange()[0] + ":"
				+ getCurrentTimeRange()[1]);*/
		  System.out.println(System.currentTimeMillis());

		  long time=1487838581555L;
		  System.out.println(DateUtil.toString(time, DateUtil.DATETIME_FORMAT));
	}
	
	
	
}
