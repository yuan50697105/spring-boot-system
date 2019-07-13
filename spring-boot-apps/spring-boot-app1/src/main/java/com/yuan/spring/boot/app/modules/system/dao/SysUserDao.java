package com.yuan.spring.boot.app.modules.system.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.spring.boot.app.modules.commons.dao.MybatisPlusDao;
import com.yuan.spring.boot.app.modules.system.entity.domain.SysUser;
import com.yuan.spring.boot.app.modules.system.entity.dto.SysUserQueryParams;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author yuane
 * @date 2019/7/13 1:26
 **/
@Repository
@Mapper
public interface SysUserDao extends MybatisPlusDao<SysUser> {

    Page<SysUser> selectPageByParams(Page<SysUser> objectPage, SysUserQueryParams queryParams);

    List<SysUser> selectListByParams(SysUserQueryParams queryParams);

    Optional<SysUser> selectOneByParams(SysUserQueryParams queryParams);
}
