package com.yuan.spring.boot.app.modules.system.entity.converter;

import com.yuan.spring.boot.app.modules.system.entity.domain.SysUser;
import com.yuan.spring.boot.app.modules.system.entity.vo.SysUserVo;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author yuane
 * @date 2019/7/14 13:21
 **/
@Mapper(componentModel = "spring")
public interface SysUserConvertor {
    //    @Mappings({
//            @Mapping(source = "id", target = "id"),
//            @Mapping(source = "username", target = "username"),
//            @Mapping(source = "name", target = "name"),
//            @Mapping(source = "enabled", target = "enabled")
//    })
    SysUser voToDomain(SysUserVo sysUserVo);

    @InheritInverseConfiguration
    SysUserVo domainToVo(SysUser sysUser);

    @InheritConfiguration
    List<SysUser> voToDomain(List<SysUserVo> sysUserVos);

    @InheritConfiguration
    List<SysUserVo> domainToVo(List<SysUser> sysUsers);
}
