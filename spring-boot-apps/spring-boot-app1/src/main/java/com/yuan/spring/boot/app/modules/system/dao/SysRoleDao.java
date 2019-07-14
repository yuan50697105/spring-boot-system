package com.yuan.spring.boot.app.modules.system.dao;

import com.yuan.spring.boot.app.modules.commons.dao.BaseDao;
import com.yuan.spring.boot.app.modules.system.entity.domain.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author yuane
 * @date 2019/7/14 20:47
 **/
@Mapper
@Repository
public interface SysRoleDao extends BaseDao<SysRole> {
}
