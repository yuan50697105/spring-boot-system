package com.yuan.spring.boot.test.app1.modules.system.entity.converter;

import com.yuan.spring.boot.test.app1.modules.system.entity.domain.SysUser;
import com.yuan.spring.boot.test.app1.modules.system.entity.dto.SysUserExcelEntity;
import com.yuan.spring.boot.test.app1.modules.system.entity.dto.SysUserQueryResult;
import com.yuan.spring.boot.test.app1.modules.system.entity.vo.SysUserVo;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SysUserConverter {
    /**
     * excel表格实体转换为domain
     *
     * @param importEntity
     * @return
     */
    @Mappings({
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "enabled", target = "enabled", defaultValue = "0"),
            @Mapping(target = "nameSpellFull", ignore = true, expression = "java(com.yuan.spring.boot.utils.SpellUtils.getSpell(sysUserVo.getName))"),
            @Mapping(target = "nameSpellSimple", ignore = true, expression = "java(com.yuan.spring.boot.utils.SpellUtils.getFirstSpell(sysUserVo.getName))"),
            @Mapping(target = "password", ignore = true)
    })
    SysUser excelEntityToDomain(SysUserExcelEntity importEntity);

    /**
     * @param importEntities
     * @return
     * @see SysUserConverter
     */
    @InheritConfiguration(name = "excelEntityToDomain")
    List<SysUser> excelEntityToDomain(List<SysUserExcelEntity> importEntities);

    /**
     * @param queryResult
     * @return
     */
    @Mappings({
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "enabled", target = "enabled"),
            @Mapping(target = "errorMsg", ignore = true),
            @Mapping(target = "rowNum", ignore = true)
    })
    SysUserExcelEntity queryResultToExcelEntity(SysUserQueryResult queryResult);

    @InheritConfiguration(name = "queryResultToExcelEntity")
    List<SysUserExcelEntity> queryResultToExcelEntity(List<SysUserQueryResult> queryResults);

    @Mappings({
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "name", target = "name"),
            @Mapping(target = "enabled", defaultValue = "0"),
            @Mapping(target = "nameSpellFull", ignore = true, expression = "java(com.yuan.spring.boot.utils.SpellUtils.getSpell(sysUserVo.getName))"),
            @Mapping(target = "nameSpellSimple", ignore = true, expression = "java(com.yuan.spring.boot.utils.SpellUtils.getFirstSpell(sysUserVo.getName))")
    })
    SysUser voToDomain(SysUserVo sysUserVo);

}
