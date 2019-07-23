package com.yuan.spring.boot.app2;

import com.yuan.spring.boot.app2.modules.system.dao.SysUserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author yuane
 * @date 2019/7/23 22:55
 **/
@SpringBootTest(classes = SpringBootApp2.class)
@RunWith(SpringRunner.class)
public class SpringBootApp2Tests {

    @Autowired
    private SysUserDao sysUserDao;

    @Test
    public void test1() {

    }
}
