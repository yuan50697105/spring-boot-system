package com.yuan.spring.boot.test.app.nutz.dao.impl;

import com.yuan.spring.boot.test.app.nutz.dao.SysUserDao;
import com.yuan.spring.boot.test.app.nutz.entity.SysUser;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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

    public List<SysUser> findAll() {
        return dao.query(SysUser.class, Cnd.NEW());
    }

    public List<Map<String, Object>> findAllMap() {
        return dao.query("sys_user", Cnd.NEW()).parallelStream().map(record -> {
            Set<String> keySet = record.keySet();
            Map<String, Object> map = new HashMap<>(keySet.size());
            for (String key : keySet) {
                map.put(key, record.get(key));
            }
            return map;
        }).collect(Collectors.toList());
    }
}
