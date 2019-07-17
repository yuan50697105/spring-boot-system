package com.yuan.spring.boot.test.app1.modules.system.dao;

import com.yuan.spring.boot.test.app1.modules.commons.dao.CommonsDao;
import com.yuan.spring.boot.test.app1.modules.system.entity.domain.SysPermission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.mybatis.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author yuane
 * @date 2019/7/17 19:11
 **/
@Repository
@Mapper
public interface SysPermissionDao extends CommonsDao<SysPermission> {
    @Query
    boolean existsByName(String name);
}
