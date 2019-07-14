package com.yuan.spring.boot.mapper.modules.system.entity.converter;

import com.yuan.spring.boot.mapper.modules.system.entity.domain.SysRole;
import com.yuan.spring.boot.mapper.modules.system.entity.vo.SysRoleVo;
import org.mapstruct.*;

import java.util.List;

/**
 * @author yuane
 * @date 2019/7/14 20:19
 **/
@Mapper(componentModel = "spring")
public interface SysRoleConverter {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "enabled", target = "enabled")
    })
    SysRole voToDomain(SysRoleVo roleVo);

    @InheritInverseConfiguration
    SysRoleVo domainToVo(SysRole sysRole);

    @InheritConfiguration
    List<SysRole> voToDaMain(List<SysRoleVo> sysRoleVo);

    @InheritInverseConfiguration
    List<SysRoleVo> domainToVo(List<SysRole> sysRoleVo);

}
