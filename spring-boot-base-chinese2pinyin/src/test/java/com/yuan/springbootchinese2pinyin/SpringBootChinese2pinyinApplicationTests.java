package com.yuan.springbootchinese2pinyin;

import com.yuan.springbootchinese2pinyin.annotation.Name;
import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootChinese2pinyinApplicationTests {

    @Test
    public void contextLoads() {
        User user = new User();
        user.setName("aaa");
        System.out.println(user.getName());
    }

    @Data
    public static class User {
        @Name
        private String name;

    }

}
