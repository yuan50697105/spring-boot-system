package com.yuan.spring.boot.test.app1.modules.system.entity.converter;

import com.yuan.spring.boot.test.app1.modules.system.entity.domain.SysPermission;
import com.yuan.spring.boot.test.app1.modules.system.entity.dto.SysPermissionExcelEntity;
import com.yuan.spring.boot.test.app1.modules.system.entity.dto.SysPermissionQueryResult;
import com.yuan.spring.boot.test.app1.modules.system.entity.vo.SysPermissionVo;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * @author yuane
 * @date 2019/7/17 19:00
 **/
@Mapper(componentModel = "spring")
public interface SysPermissionConverter {
    SysPermission voToDomain(SysPermissionVo sysPermissionVo);

    @Mapping(target = "rowNum", ignore = true)
    @Mapping(target = "errorMsg", ignore = true)
    SysPermissionExcelEntity queryResultToExcelEntity(SysPermissionQueryResult queryResult);

    @InheritConfiguration(name = "queryResultToExcelEntity")
    List<SysPermissionExcelEntity> queryResultToExcelEntity(List<SysPermissionQueryResult> queryResults);

    SysPermission excelToDomain(SysPermissionExcelEntity excelEntity);

    @InheritConfiguration(name = "queryResultToExcelEntity")
    List<SysPermission> excelToDomain(List<SysPermissionExcelEntity> excelEntities);

}
