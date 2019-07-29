package com.yuan.spring.app1.modules.system.entity.converter;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.spring.app1.modules.system.entity.domain.SysRole;
import com.yuan.spring.app1.modules.system.entity.vo.SysRoleVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * @author yuane
 * @date 2019/7/30 1:04
 **/
@Mapper(componentModel = "spring")
public interface SysRoleConverter {
    SysRoleVo toVo(SysRole role);

    List<SysRoleVo> toVo(List<SysRole> roles);

    @Mappings({
            @org.mapstruct.Mapping(target = "asc", ignore = true),
            @org.mapstruct.Mapping(target = "ascs", ignore = true),
            @org.mapstruct.Mapping(target = "ascs", ignore = true),
            @org.mapstruct.Mapping(target = "descs", ignore = true),
            @org.mapstruct.Mapping(target = "desc", ignore = true),
            @org.mapstruct.Mapping(target = "optimizeCountSql", ignore = true)
    })
    Page<SysRoleVo> toVo(Page<SysRole> roles);
}
