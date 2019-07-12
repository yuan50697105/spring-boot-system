package com.yuan.springbootutils;

import com.yuan.spring.boot.utils.DateUtils;
import com.yuan.spring.boot.utils.SnowflakeIdWorker;
import org.junit.Test;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/6/15 15:08
 **/
public class Test1 {
    @Test
    public void tse() {
        Date parse = DateUtils.DATE.parse("2019-09-10");
        System.out.println(parse);
        String format = DateUtils.DATE.format(parse);
        System.out.println(format);
        String format1 = DateUtils.DATE_TIME.format(new Date());
        System.out.println(format1);
        String format2 = DateUtils.DATE_STR.format(new Date());
        System.out.println(format2);
        format2 = DateUtils.DATE_TIME_STR.format(new Date());
        System.out.println(format2);
        Date parse1 = DateUtils.DATE_TIME_STR.parse("20190101102022");
        System.out.println(parse1);
    }

    @Test
    public void test2() throws InterruptedException {
        SnowflakeIdWorker idWorker = SnowflakeIdWorker.build(0L, 0L);
        int i = 10;
        while (i >= 0) {

                Long nextId =idWorker.nextId();
                System.out.println(nextId);
            i--;
        }
        idWorker = SnowflakeIdWorker.build(0L, 1L);
        i=10;
        while (i >= 0) {

            Long nextId =idWorker.nextId();
            System.out.println(nextId);
            i--;
        }
    }
}
