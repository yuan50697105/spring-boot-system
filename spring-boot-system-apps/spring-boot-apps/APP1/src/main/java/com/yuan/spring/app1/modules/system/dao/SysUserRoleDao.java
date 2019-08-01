package com.yuan.spring.app1.modules.system.dao;

import com.yuan.spring.app1.modules.commons.dao.BaseDao;
import com.yuan.spring.app1.modules.system.entity.domain.SysUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author yuane
 * @date 2019/8/1 19:10
 **/
@Repository
@Mapper
public interface SysUserRoleDao extends BaseDao<SysUserRole> {
}
