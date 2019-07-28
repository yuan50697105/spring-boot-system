package com.yuan.spring.app1.modules.system.dao;

import com.yuan.spring.app1.modules.commons.dao.BaseDao;
import com.yuan.spring.app1.modules.system.entity.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author yuane
 * @date 2019/7/27 11:05
 **/
@Repository
@Mapper
public interface SysUserDao extends BaseDao<SysUser> {
}