package com.yuan.springbootwebjpa;

import lombok.*;
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

    @Test
    public void test2() {
        User build = User.builder().id("aaaaasas").name("aaaasa").build();
        System.out.println(build);
        User aaasa = User.builder().id("aaasa").build();
        System.out.println(aaasa);
        Customer build1 = Customer.builder().id("adasdsa").name("asdas").customerName("asdasd").build();
        System.out.println(build1);
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    static class User {
        private String id;
        private String name;
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @NoArgsConstructor
    static class Customer extends User {
        private String customerName;

        @Builder
        public Customer(String id, String name, String customerName) {
            super(id, name);
            this.customerName = customerName;
        }

        public Customer(String customerName) {
            this.customerName = customerName;
        }
    }
}
