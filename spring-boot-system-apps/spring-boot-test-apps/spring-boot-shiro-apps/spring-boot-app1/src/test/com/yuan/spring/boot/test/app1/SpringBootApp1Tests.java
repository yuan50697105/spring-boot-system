package com.yuan.spring.boot.test.app1;

import cn.hutool.core.util.IdUtil;
import com.yuan.spring.boot.test.app1.module.system.dao.SysUserDao;
import com.yuan.spring.boot.test.app1.module.system.entity.domain.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.Date;
import java.util.List;

/**
 * @author yuane
 * @date 2019/7/23 21:13
 **/
@SpringBootTest(classes = SpringBootApp1.class)
@RunWith(SpringRunner.class)
public class SpringBootApp1Tests {
    @Autowired
    private ApplicationContext context;
    @Autowired
    private SysUserDao sysUserDao;

    @Test
    @Transactional
    public void slice() {
        SysUserDao sysUserDao = context.getBean(SysUserDao.class);
        List<SysUser> list = sysUserDao.findAllByNameContains("aa");
        System.out.println(list);

    }

    @Test
    @Transactional
    public void name() {
        ListenableFuture<SysUser> aa = sysUserDao.findAllByUsernameContaining("aa");
        aa.addCallback(new ListenableFutureCallback<SysUser>() {
            @Override
            public void onFailure(Throwable ex) {
                ex.printStackTrace();
            }

            @Override
            public void onSuccess(SysUser result) {
                System.out.println(result);
            }
        });
    }

    @Test
    @Transactional
    public void page() {
        Page<SysUser> aa = sysUserDao.findAllByUsernameContainingAndNameContaining(PageRequest.of(0, 1), "a", "a");
        System.out.println(aa.getContent());
    }

    @Test
    public void page2() {

        Page<SysUser> users = sysUserDao.findAll(PageRequest.of(0, 1), SysUser.creator().username("a").name("a").create());
        System.out.println(users.getContent());
    }

    @Test
    public void page3() {
        Page<SysUser> users = sysUserDao.findAllByParams(PageRequest.of(1, 1));
        System.out.println(users.getContent());
    }

    @Test
    public void one() {
        SysUser sysUser = new SysUser();
        sysUser.setId(1153672377603854336L);
//        sysUser.setUsername("a");
        SysUser one = sysUserDao.getOne(sysUser);
        System.out.println(one);
    }

    @Test
    public void list() {
        SysUser sysUser = new SysUser();
        sysUser.setUsername("a");
        List<SysUser> users = sysUserDao.findAll(sysUser);
        System.out.println(users);
    }

    @Test
    public void page1() {
        Page<SysUser> page = sysUserDao.findAll(PageRequest.of(0, 1));
        System.out.println(page.getContent());
    }

    @Test
    @Transactional
    @Rollback(false)
    public void save() {
        SysUser sysUser = new SysUser(IdUtil.getSnowflake(1, 1).nextId(), new Date(), new Date(), 1L, 1L, "AA", "AA", "AA", "AA", "AAA", 1);
        sysUserDao.insert(sysUser);
        sysUser = new SysUser(IdUtil.getSnowflake(1, 1).nextId(), new Date(), new Date(), 1L, 1L, "AA", "AA", "AA", "AA", "AAA", 1);
        sysUserDao.insert(sysUser);
    }
}
