package com.yuan.springbootutils.utils;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * @author yuane
 * @date 2019/6/15 15:03
 **/
public class DateUtils {
    public static String dateFormat(Date date, String format) {
        return DateFormatUtils.format(date, format);
    }

    public static Date parseDate(String date, String... parse) {
        try {
            return org.apache.commons.lang3.time.DateUtils.parseDate(date, parse);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
