package com.yuan.spring.boot.test.app.nutz.dao.impl;

import com.yuan.spring.boot.test.app.nutz.dao.SysUserDao;
import com.yuan.spring.boot.test.app.nutz.entity.SysUser;
import org.nutz.dao.Dao;
import org.nutz.dao.sql.Sql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class SysUserDaoImpl implements SysUserDao {
    @Autowired
    private Dao dao;

    @Transactional(rollbackFor = Exception.class)
    public void insert(SysUser sysUser) {
        dao.insert(sysUser);
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(SysUser sysUser, boolean withNull) {
        if (withNull) {
            dao.update(sysUser);
        } else {
            dao.updateIgnoreNull(sysUser);
        }
    }

    public void delete(String id) {
        Sql sql = dao.sqls().create("");
        sql.setPager(dao.createPager(1, 1));
        long aLong = sql.getLong(0);
    }

}
