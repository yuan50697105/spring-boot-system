package com.yuan.spring.boot.test.app1.module.system.dao;

import com.yuan.spring.boot.test.app1.module.commons.dao.BaseDao;
import com.yuan.spring.boot.test.app1.module.system.entity.domain.SysUser;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author yuane
 * @date 2019/7/21 23:43
 **/
@Repository
@Mapper
public interface SysUserDao extends BaseDao<SysUser> {
    boolean existsByUsernameEquals(String username);
}
