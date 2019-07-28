package com.yuan.spring.app1.modules.system.entity.converter;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.spring.app1.modules.commons.utils.PageVo;
import com.yuan.spring.app1.modules.system.entity.domain.SysUser;
import com.yuan.spring.app1.modules.system.entity.vo.SysUserVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * @author yuane
 * @date 2019/7/27 11:26
 **/
@Mapper(componentModel = "spring")
public interface SysUserConverter {
    SysUserVo toVo(SysUser sysUser);

    List<SysUserVo> toVo(List<SysUser> sysUsers);

    @Mapping(target = "optimizeCountSql", ignore = true)
    @Mapping(target = "descs", ignore = true)
    @Mapping(target = "descs", ignore = true)
    @Mapping(target = "desc", ignore = true)
    @Mapping(target = "desc", ignore = true)
    @Mapping(target = "ascs", ignore = true)
    @Mapping(target = "ascs", ignore = true)
    @Mapping(target = "asc", ignore = true)
    @Mapping(target = "asc", ignore = true)
    Page<SysUserVo> toVo(Page<SysUser> users);

    org.springframework.data.domain.Page<SysUserVo> toVo(org.springframework.data.domain.Page<SysUser> users);

    SysUser toDomain(SysUserVo sysUserVo);

    PageVo<SysUserVo> toVo(PageVo<SysUser> pageVo);
}
