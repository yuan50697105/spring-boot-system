package com.yuan.spring.app1.modules.system.entity.converter;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.spring.app1.modules.system.entity.domain.SysResource;
import com.yuan.spring.app1.modules.system.entity.vo.SysResourceVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * @author yuane
 * @date 2019/8/1 19:07
 **/
@Mapper(componentModel = "spring", uses = {SysPermissionConverter.class})
public interface SysResourceConverter {
    SysResourceVo toVo(SysResource resource);

    List<SysResourceVo> toVo(List<SysResource> resources);

    @Mappings({

            @org.mapstruct.Mapping(target = "asc", ignore = true),
            @org.mapstruct.Mapping(target = "ascs", ignore = true),
            @org.mapstruct.Mapping(target = "ascs", ignore = true),
            @org.mapstruct.Mapping(target = "desc", ignore = true),
            @org.mapstruct.Mapping(target = "desc", ignore = true),
            @org.mapstruct.Mapping(target = "descs", ignore = true),
            @org.mapstruct.Mapping(target = "optimizeCountSql", ignore = true)
    })
    Page<SysResourceVo> toVo(Page<SysResource> resources);
}
