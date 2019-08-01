package com.yuan.spring.app1.modules.system.dao;

import com.yuan.spring.app1.modules.commons.dao.BaseDao;
import com.yuan.spring.app1.modules.system.entity.domain.SysPermissionResource;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author yuane
 * @date 2019/8/1 19:11
 **/
@Repository
@Mapper
public interface SysPermissionResourceDao extends BaseDao<SysPermissionResource> {
}
