package com.yuan.springbootwebjpa;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;

/**
 * @author yuane
 * @date 2019/6/8 15:36
 **/
public class Test1 {
    @Test
    public void test(){
        String s = RandomStringUtils.randomNumeric(22);
        String yyyyMMddhhmmss = DateFormatUtils.format(System.currentTimeMillis(), "yyyyMMddHHmmss");
        System.out.println(yyyyMMddhhmmss);
        String id=yyyyMMddhhmmss+s;
        System.out.println(id);
        System.out.println(id.length());
    }

    public void test1() {

    }
}
