package com.yuan.spring.boot.test.app1.module.system.dao.impl;

import com.yuan.spring.boot.test.app1.module.commons.dao.impl.BaseJdbcDaoImpl;
import com.yuan.spring.boot.test.app1.module.system.dao.SysUserJdbcDao;
import com.yuan.spring.boot.test.app1.module.system.entity.domain.SysUserJdbc;
import org.springframework.stereotype.Repository;

/**
 * @author yuane
 * @date 2019/7/22 18:43
 **/
@Repository
public class SysUserJdbcDaoImpl extends BaseJdbcDaoImpl<SysUserJdbc> implements SysUserJdbcDao {
}
