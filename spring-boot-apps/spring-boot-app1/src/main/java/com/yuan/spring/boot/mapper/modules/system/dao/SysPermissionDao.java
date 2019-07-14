package com.yuan.spring.boot.mapper.modules.system.dao;

import com.yuan.spring.boot.mapper.modules.commons.dao.BaseDao;
import com.yuan.spring.boot.mapper.modules.system.entity.domain.SysPermisson;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author yuane
 * @date 2019/7/14 23:36
 **/
@Repository
@Mapper
public interface SysPermissionDao extends BaseDao<SysPermisson> {
}
