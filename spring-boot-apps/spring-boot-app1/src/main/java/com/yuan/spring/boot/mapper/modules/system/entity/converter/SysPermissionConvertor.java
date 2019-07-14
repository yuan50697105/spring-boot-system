package com.yuan.spring.boot.mapper.modules.system.entity.converter;

import com.yuan.spring.boot.mapper.modules.system.entity.domain.SysPermisson;
import com.yuan.spring.boot.mapper.modules.system.entity.vo.SysPermissionVo;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author yuane
 * @date 2019/7/14 23:24
 **/
@Mapper(componentModel = "spring")
public interface SysPermissionConvertor {
    SysPermisson voToDomain(SysPermissionVo sysPermissionVo);

    List<SysPermisson> voToDomain(List<SysPermissionVo> sysPermissionVos);
}
