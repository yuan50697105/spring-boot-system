package com.yuan.springbootutils.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/6/15 15:02
 **/
public class IdUtils {
    public static String getTimeId(int count) {
        Date date = new Date();
        String dateTimeStr = DateFormatUtils.format(date, "yyyyMMddHHmmss");
        String randomNumeric = RandomStringUtils.randomNumeric(count);
        return dateTimeStr + randomNumeric;

    }
}
