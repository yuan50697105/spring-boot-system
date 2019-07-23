package com.spring.boot.test.app3;

import cn.hutool.core.util.IdUtil;
import com.spring.boot.test.app3.modules.commons.dao.SysUserDao;
import com.spring.boot.test.app3.modules.commons.entity.domain.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/23 23:00
 **/
@SpringBootTest(classes = SpringBootApp3.class)
@RunWith(SpringRunner.class)
public class SpringBootApp3Tests {
    @Autowired
    private SysUserDao sysUserDao;

    @Test
    @Transactional
    @Rollback(false)
    public void test() {
        SysUser sysUser = new SysUser();
        sysUser.setId(IdUtil.getSnowflake(1, 1).nextId());
        sysUser.setUsername("AB");
        sysUser.setName("AB");
        sysUser.setNameSpellFull("AB");
        sysUser.setNameSpellSimple("AB");
        sysUser.setCreateDate(new Date());
        sysUser.setModifyDate(new Date());
        sysUser.setCrateBy(1L);
        sysUser.setModifyBy(1L);

        sysUserDao.insert(sysUser);
        SysUser sysUser1 = new SysUser();
        sysUser1.setId(IdUtil.getSnowflake(1, 1).nextId());
        sysUser1.setUsername("AB");
        sysUser1.setName("AB");
        sysUser1.setNameSpellFull("AB");
        sysUser1.setNameSpellSimple("AB");
        sysUser1.setCreateDate(new Date());
        sysUser1.setModifyDate(new Date());
        sysUser1.setCrateBy(1L);
        sysUser1.setModifyBy(1L);
        sysUserDao.insertSelective(sysUser1);
    }
}
