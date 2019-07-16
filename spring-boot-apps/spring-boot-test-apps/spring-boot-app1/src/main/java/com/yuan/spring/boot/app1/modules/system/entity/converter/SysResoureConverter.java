package com.yuan.spring.boot.app1.modules.system.entity.converter;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.spring.boot.app1.modules.system.entity.domain.SysResource;
import com.yuan.spring.boot.app1.modules.system.entity.vo.SysResourceVo;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author yuane
 * @date 2019/7/15 23:50
 **/
@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface SysResoureConverter {

    SysResource voToDomain(SysResourceVo sysResourceVo);

    @InheritInverseConfiguration
    SysResourceVo domainToVo(SysResource sysResource);

    @InheritConfiguration
    List<SysResource> voToDomain(List<SysResourceVo> sysResourceVos);

    @InheritInverseConfiguration
    List<SysResourceVo> domainToVo(List<SysResource> sysResources);

    @InheritInverseConfiguration
    Page<SysResourceVo> domainToVo(IPage<SysResource> sysResourceIPage);

    @InheritInverseConfiguration
    Page<SysResourceVo> domainToVo(Page<SysResource> sysResourceIPage);
}
