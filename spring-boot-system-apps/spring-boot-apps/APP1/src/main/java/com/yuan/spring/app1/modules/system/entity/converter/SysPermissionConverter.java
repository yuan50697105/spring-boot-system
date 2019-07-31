package com.yuan.spring.app1.modules.system.entity.converter;

import com.yuan.spring.app1.modules.system.entity.domain.SysPermission;
import com.yuan.spring.app1.modules.system.entity.vo.SysPermissionVo;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author yuane
 * @date 2019/7/30 19:05
 **/
@Mapper(componentModel = "spring", uses = {SysUserConverter.class, SysRoleConverter.class})
public interface SysPermissionConverter {
    SysPermissionVo toVo(SysPermission sysPermission);

    List<SysPermissionVo> toVo(List<SysPermission> sysPermissions);

}
