package com.dh.blogrecode.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateKit {
    public static final int INTERVAL_DAY = 1;
    public static final int INTERVAL_WEEK = 2;
    public static final int INTERVAL_MONTH = 3;
    public static final int INTERVAL_YEAR = 4;
    public static final int INTERVAL_HOUR = 5;
    public static final int INTERVAL_MINUTE = 6;
    public static final int INTERVAL_SECOND = 7;

    public static final Date tempDate = new Date((new Long("-2177481952000")).longValue());
    private static List<SimpleDateFormat> dateFormats = new ArrayList(12) {
        private static final long serialVersionUID = 2249396579858199535L;

        {
            this.add(new SimpleDateFormat("yyyy-MM-dd"));
            this.add(new SimpleDateFormat("yyyy/MM/dd"));
            this.add(new SimpleDateFormat("yyyy.MM.dd"));
            this.add(new SimpleDateFormat("yyyy-MM-dd HH:24:mm:ss"));
            this.add(new SimpleDateFormat("yyyy/MM/dd HH:24:mm:ss"));
            this.add(new SimpleDateFormat("yyyy.MM.dd HH:24:mm:ss"));
            this.add(new SimpleDateFormat("M/dd/yyyy"));
            this.add(new SimpleDateFormat("dd.M.yyyy"));
            this.add(new SimpleDateFormat("M/dd/yyyy hh:mm:ss a"));
            this.add(new SimpleDateFormat("dd.M.yyyy hh:mm:ss a"));
            this.add(new SimpleDateFormat("dd.MMM.yyyy"));
            this.add(new SimpleDateFormat("dd-MMM-yyyy"));
        }
    };

    public DateKit() {
    }

    public static boolean isToday(Date date) {
        Date now = new Date();
        boolean result = true;

        result &= date.getYear() == now.getYear();
        result &= date.getMonth() == now.getMonth();
        result &= date.getDate() == now.getDate();

        return result;
    }

    public static long DaysBetween(Date began,Date end) {
        if (end == null) {
            end = new Date();
        }
        long day = (end.getTime() - began.getTime()) / 86400000L;
        return day;
    }

    public static boolean compareDate(String began,String end){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date e = format.parse(began);
            Date d2 = format.parse(end);
            return !e.after(d2);
        } catch (ParseException e1) {
            e1.printStackTrace();
            return false;
        }
    }

    public static String dateFormat(Date date,String dateFormat){
        if (date != null) {
            SimpleDateFormat format = new SimpleDateFormat(dateFormat);
            if (date != null){
                return format.format(date);
            }
        }
        return "";
    }
}
