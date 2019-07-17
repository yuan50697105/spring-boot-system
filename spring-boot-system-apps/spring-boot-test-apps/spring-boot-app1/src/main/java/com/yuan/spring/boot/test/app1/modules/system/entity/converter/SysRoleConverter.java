package com.yuan.spring.boot.test.app1.modules.system.entity.converter;

import com.yuan.spring.boot.test.app1.modules.system.entity.domain.SysRole;
import com.yuan.spring.boot.test.app1.modules.system.entity.dto.SysRoleExcelEntity;
import com.yuan.spring.boot.test.app1.modules.system.entity.vo.SysRoleVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SysRoleConverter {
    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "enabled", target = "enabled")
    })
    SysRole voToDomain(SysRoleVo sysRoleVo);

    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "enabled", target = "enabled")
    })
    SysRole excelToDomain(SysRoleExcelEntity excelEntity);

    List<SysRole> excelToDomain(List<SysRoleExcelEntity> excelEntities);
}
