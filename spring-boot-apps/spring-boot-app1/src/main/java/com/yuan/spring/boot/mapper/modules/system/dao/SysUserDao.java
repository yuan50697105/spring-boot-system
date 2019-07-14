package com.yuan.spring.boot.mapper.modules.system.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.spring.boot.mapper.modules.commons.dao.BaseDao;
import com.yuan.spring.boot.mapper.modules.system.entity.domain.SysUser;
import com.yuan.spring.boot.mapper.modules.system.entity.dto.SysUserQueryParams;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author yuane
 * @date 2019/7/13 1:26
 **/
@Repository
@Mapper
public interface SysUserDao extends BaseDao<SysUser> {

    IPage<SysUser> selectPageByParams(IPage<SysUser> objectPage, @Param("queryParams") SysUserQueryParams queryParams);
}
