package com.yuan.springbootwebmybatisplus.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * @author yuane
 * @date 2019/6/8 15:21
 **/
public class IdUtils {
    public static String generateId() {
        String s = RandomStringUtils.randomNumeric(20);
        String yyyyMMddHHmmss = DateFormatUtils.format(System.currentTimeMillis(), "yyyyMMddhhmmss");
        return yyyyMMddHHmmss + s;
    }
}
