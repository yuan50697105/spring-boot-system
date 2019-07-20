package com.spring.boot.test.app3.modules.commons.dao;

import com.spring.boot.test.app3.modules.commons.entity.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SysUserDao extends BaseDao<SysUser> {
}
