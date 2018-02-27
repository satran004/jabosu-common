package org.jabosu.common.util;

import java.util.Date;
import org.jabosu.common.SystemConfig;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author satya
 */
public class DateUtil {
    
    public static boolean afterToday(long timeInMillis, String timezone) {
        long today = new DateTime().withZone(DateTimeZone.forID(timezone)).withHourOfDay(23).withMinuteOfHour(59).withSecondOfMinute(59).getMillis();
        
        if(timeInMillis > today) {
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean beforeToday(long timeInMillis, String timezone) {
        long today = new DateTime().withTimeAtStartOfDay().withZone(DateTimeZone.forID(timezone)).getMillis();
        
        if(timeInMillis < today) {
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean isToday(long timeInMillis, String timezone) {
        long today = new DateTime().withTimeAtStartOfDay().withZone(DateTimeZone.forID(timezone)).getMillis();
        long inputDate = new DateTime().withMillis(timeInMillis).withTimeAtStartOfDay().getMillis();
        
        if(today == inputDate) {
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean after(long firstDate, long secondDate) {
        long firstDateStart = new DateTime().withMillis(firstDate).withTimeAtStartOfDay().getMillis();
        long secondDateStart = new DateTime().withMillis(secondDate).withHourOfDay(23).withMinuteOfHour(59).withSecondOfMinute(59).getMillis();
        
        if(secondDateStart > firstDateStart)
            return true;
        else
            return false;
    }
    
    public static long getCurrentDate(String timeZone) {
        long today = new DateTime().withZone(DateTimeZone.forID(timeZone)).withTimeAtStartOfDay().getMillis();
        return today;
    }
    
    public static long getStartOfDayForDate(long timeInMillis, String timeZone) {
        return new DateTime().withMillis(timeInMillis).withZone(DateTimeZone.forID(timeZone)).withTimeAtStartOfDay().getMillis();
    }
    
    public static long getEndOfDayForDate(long timeInMillis, String timeZone) {
        return new DateTime().withMillis(timeInMillis).withZone(DateTimeZone.forID(timeZone)).withHourOfDay(23).withMinuteOfHour(59).withSecondOfMinute(59).getMillis();
    }
    
    public static String getFormattedDate(Date date, String country) {
        
        if(StringUtil.isEmpty(country)) {
            return "";
        }
        
        String timezone = SystemConfig.getTimeZone(country);
        
        DateTime dtTime = new DateTime().withMillis(date.getTime()).withZone(DateTimeZone.forID(timezone));
        DateTimeFormatter fmt = DateTimeFormat.forPattern(SystemConfig.getDateTimeFormat());
        
        return dtTime.toString(fmt);
    }
    
    public static String getFormattedDate(long longDate, String country) {
        
        String timezone = null;
        
        if(!StringUtil.isEmpty(country))
            timezone = SystemConfig.getTimeZone(country);
        else
            timezone = DateTimeZone.getDefault().getID();
        
        DateTime dtTime = new DateTime().withMillis(longDate).withZone(DateTimeZone.forID(timezone));
        DateTimeFormatter fmt = DateTimeFormat.forPattern(SystemConfig.getDateTimeFormat());
        
        return dtTime.toString(fmt);
    }
    
    public static Date plusDays(Date date, int days) {
        long millis = new DateTime().withMillis(date.getTime()).plusDays(days).getMillis();
        
        return new Date(millis);
    }
}
