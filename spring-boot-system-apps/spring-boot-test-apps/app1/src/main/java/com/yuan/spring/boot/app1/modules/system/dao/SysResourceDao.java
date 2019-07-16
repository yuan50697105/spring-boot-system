package com.yuan.spring.boot.app1.modules.system.dao;

import com.yuan.spring.boot.app1.modules.commons.dao.BaseDao;
import com.yuan.spring.boot.app1.modules.system.entity.domain.SysResource;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author yuane
 * @date 2019/7/15 23:41
 **/
@Repository
@Mapper
public interface SysResourceDao extends BaseDao<SysResource> {
}
