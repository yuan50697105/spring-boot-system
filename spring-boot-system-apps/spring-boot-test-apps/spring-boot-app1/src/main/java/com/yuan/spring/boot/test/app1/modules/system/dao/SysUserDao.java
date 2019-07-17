package com.yuan.spring.boot.test.app1.modules.system.dao;

import com.yuan.spring.boot.test.app1.modules.commons.dao.CommonsDao;
import com.yuan.spring.boot.test.app1.modules.system.entity.domain.SysUser;
import com.yuan.spring.boot.test.app1.modules.system.entity.dto.SysUserQueryParams;
import com.yuan.spring.boot.test.app1.modules.system.entity.dto.SysUserQueryResult;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mybatis.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yuane
 * @date 2019/7/17 0:51
 **/
@Repository
@Mapper
public interface SysUserDao extends CommonsDao<SysUser> {
    @Query
    boolean existsByUsername(String username);

    @Query
    List<SysUserQueryResult> findListByParams(SysUserQueryParams queryParams);

    @Query
    Page<SysUserQueryResult> findPageByParams(SysUserQueryParams queryParams, Pageable pageable);

    @Query
    SysUserQueryResult findOneByParams(SysUserQueryParams queryParams);
}
