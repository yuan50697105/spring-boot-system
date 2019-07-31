package com.yuan.spring.app1.modules.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuan.spring.app1.modules.system.entity.domain.SysPermission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author yuane
 * @date 2019/7/30 22:35
 **/
@Repository
@Mapper
public interface SysPermissionDao extends BaseMapper<SysPermission> {
}
