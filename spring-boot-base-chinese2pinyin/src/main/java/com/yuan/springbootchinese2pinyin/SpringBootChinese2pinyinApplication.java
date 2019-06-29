package com.yuan.springbootchinese2pinyin;

import com.yuan.springbootchinese2pinyin.annotation.Name;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(scanBasePackageClasses = SpringBootChinese2pinyinApplication.class)
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringBootChinese2pinyinApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootChinese2pinyinApplication.class, args);
        User user = new User();
    }

    @Data
    static class User {
        @Name
        private String name;
    }

}
