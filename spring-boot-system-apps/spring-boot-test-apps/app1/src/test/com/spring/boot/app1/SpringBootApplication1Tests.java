package com.spring.boot.app1;

import com.google.common.collect.Lists;
import com.yuan.spring.boot.app1.SpringBootWebApplication1;
import com.yuan.spring.boot.app1.modules.system.SysUser;
import com.yuan.spring.boot.app1.modules.system.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuane
 * @date 2019/7/16 20:25
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootWebApplication1.class)
@Slf4j
public class SpringBootApplication1Tests {
    @Autowired
    private ApplicationContext context;

    @Test
    public void before() {

    }

    @Rollback(value = false)
    @Test
    @Transactional
//    @ShardingTransactionType(TransactionType.BASE)
    public void testShardingInsert() {
        long currentTimeMillis = System.currentTimeMillis();
        SysUserService sysUserService = context.getBean(SysUserService.class);
        ArrayList<SysUser> arrayList = Lists.newArrayList();
        for (int i = 1; i < 10000; i++) {

            arrayList.add(SysUser.builder().username(RandomStringUtils.randomAlphabetic(20)).build());


        }
        sysUserService.saveBatch(arrayList);
        log.info(System.currentTimeMillis() - currentTimeMillis + "");
    }

    @Test
    public void select() {
        SysUserService sysUserService = context.getBean(SysUserService.class);
        List<SysUser> list = sysUserService.findAll(SysUser.builder().username("HFhyMdTgyAogFmNQvHRL").build());
        log.info(list.toString());
    }
}
