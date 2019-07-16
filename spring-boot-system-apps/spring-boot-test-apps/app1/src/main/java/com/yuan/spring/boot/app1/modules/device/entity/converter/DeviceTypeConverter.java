package com.yuan.spring.boot.app1.modules.device.entity.converter;

import com.yuan.spring.boot.app1.modules.device.entity.domain.DeviceType;
import com.yuan.spring.boot.app1.modules.device.entity.vo.DeviceTypeVo;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author yuane
 * @date 2019/7/16 19:00
 **/
@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface DeviceTypeConverter {

    DeviceType voToDomain(DeviceTypeVo deviceTypeVo);

    @InheritInverseConfiguration
    DeviceTypeVo domainToVo(DeviceType deviceType);

    @InheritConfiguration
    List<DeviceType> voToDomain(List<DeviceTypeVo> deviceTypeVos);

    @InheritInverseConfiguration
    List<DeviceTypeVo> domainToVo(List<DeviceType> deviceTypes);
}
