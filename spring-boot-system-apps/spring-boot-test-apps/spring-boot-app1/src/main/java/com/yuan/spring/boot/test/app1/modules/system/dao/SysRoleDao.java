package com.yuan.spring.boot.test.app1.modules.system.dao;

import com.yuan.spring.boot.test.app1.modules.commons.dao.CommonsDao;
import com.yuan.spring.boot.test.app1.modules.system.entity.domain.SysRole;
import com.yuan.spring.boot.test.app1.modules.system.entity.dto.SysRoleQueryParams;
import com.yuan.spring.boot.test.app1.modules.system.entity.dto.SysRoleQueryResult;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mybatis.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yuane
 * @date 2019/7/17 1:01
 **/
@Repository
@Mapper
public interface SysRoleDao extends CommonsDao<SysRole> {
    @Query
    boolean existsByName(String name);

    @Query
    Page<SysRoleQueryResult> findPageByParams(SysRoleQueryParams queryParams, Pageable pageable);

    @Query
    List<SysRoleQueryResult> findListByParams(SysRoleQueryParams queryParams);

    @Query
    SysRoleQueryResult findOneByParams(SysRoleQueryParams queryParams);
}
