package com.yuan.spring.boot.test.app1.modules.system.dao;

import com.yuan.spring.boot.test.app1.modules.commons.dao.CommonsDao;
import com.yuan.spring.boot.test.app1.modules.system.entity.domain.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author yuane
 * @date 2019/7/17 1:01
 **/
@Repository
@Mapper
public interface SysRoleDao extends CommonsDao<SysRole> {
    boolean existsByName(String name);
}
