package com.yuan.spring.boot.test.app1.modules.system.dao;

import com.yuan.spring.boot.test.app1.modules.commons.dao.CommonsDao;
import com.yuan.spring.boot.test.app1.modules.system.entity.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author yuane
 * @date 2019/7/17 0:51
 **/
@Repository
@Mapper
public interface SysUserDao extends CommonsDao<SysUser> {
    boolean existsByUsername(String username);
}
