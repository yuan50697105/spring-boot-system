package com.yuan.spring.boot.app1.modules.system.entity.converter;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.spring.boot.app1.modules.system.entity.domain.SysRole;
import com.yuan.spring.boot.app1.modules.system.entity.domain.SysUser;
import com.yuan.spring.boot.app1.modules.system.entity.vo.SysRoleVo;
import com.yuan.spring.boot.app1.modules.system.entity.vo.SysUserVo;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author yuane
 * @date 2019/7/14 20:19
 **/
@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface SysRoleConverter {

    SysRole voToDomain(SysRoleVo roleVo);

    @InheritInverseConfiguration
    SysRoleVo domainToVo(SysRole sysRole);

    @InheritConfiguration
    List<SysRole> voToDaMain(List<SysRoleVo> sysRoleVo);

    @InheritInverseConfiguration
    List<SysRoleVo> domainToVo(List<SysRole> sysRoleVo);

    @InheritInverseConfiguration
    Page<SysUserVo> domainToVo(IPage<SysUser> page);

    @InheritInverseConfiguration
    Page<SysUserVo> domainToVo(Page<SysUser> page);

}
