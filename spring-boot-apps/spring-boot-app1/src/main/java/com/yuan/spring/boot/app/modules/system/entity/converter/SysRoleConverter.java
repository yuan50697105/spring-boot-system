package com.yuan.spring.boot.app.modules.system.entity.converter;

import com.yuan.spring.boot.app.modules.system.entity.domain.SysRole;
import com.yuan.spring.boot.app.modules.system.entity.vo.SysRoleVo;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author yuane
 * @date 2019/7/14 20:19
 **/
@Mapper(componentModel = "spring")
public interface SysRoleConverter {

    SysRole voToDomain(SysRoleVo roleVo);

    @InheritInverseConfiguration
    SysRoleVo domainToVo(SysRole sysRole);

    @InheritConfiguration
    List<SysRole> voToDaMain(List<SysRoleVo> sysRoleVo);

    @InheritInverseConfiguration
    List<SysRoleVo> domainToVo(List<SysRole> sysRoleVo);

}
