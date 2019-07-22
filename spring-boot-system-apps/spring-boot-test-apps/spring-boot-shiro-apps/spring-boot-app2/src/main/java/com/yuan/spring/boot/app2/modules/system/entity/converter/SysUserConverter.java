package com.yuan.spring.boot.app2.modules.system.entity.converter;

import com.yuan.spring.boot.app2.modules.system.entity.domain.SysUser;
import com.yuan.spring.boot.app2.modules.system.entity.dto.SysUserExcelEntity;
import com.yuan.spring.boot.app2.modules.system.entity.dto.SysUserQueryResult;
import com.yuan.spring.boot.app2.modules.system.entity.vo.SysUserVo;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author yuane
 * @date 2019/7/22 23:01
 **/
@Mapper(componentModel = "spring")
public interface SysUserConverter {
    SysUser voToDomain(SysUserVo sysUserVo);

    List<SysUser> excelToDomain(List<SysUserExcelEntity> excelEntities);

    List<SysUserExcelEntity> queryToExcel(List<SysUserQueryResult> queryResults);

}
