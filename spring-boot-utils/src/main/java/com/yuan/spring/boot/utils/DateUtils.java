package com.yuan.spring.boot.utils;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * @author yuane
 * @date 2019/6/15 15:03
 **/
public enum DateUtils {
    DATE("yyyy-MM-dd"), DATE_TIME("yyyy-MM-dd HH:mm:ss"),
    DATE_STR("yyyyMMdd"), DATE_TIME_STR("yyyyMMddHHmmss");
    private String pattern;

    DateUtils(String pattern) {
        this.pattern = pattern;
    }

    public static Date parse(String str, String pattern) {
        try {
            return org.apache.commons.lang3.time.DateUtils.parseDate(str, pattern);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String format(Date date, String pattern) {
        return DateFormatUtils.format(date, pattern);
    }

    public static String format(long millis, String pattern) {
        return DateFormatUtils.format(millis, pattern);
    }

    public static String format(Calendar calendar, String pattern) {
        return DateFormatUtils.format(calendar, pattern);
    }

    public Date parse(String dateTimeStr) {
        return parse(dateTimeStr, pattern);
    }

    public String format(Date date) {
        return format(date, pattern);
    }

    public String format(long millis) {
        return format(millis, pattern);
    }

    public String format(Calendar calendar) {
        return format(calendar, pattern);
    }
}
