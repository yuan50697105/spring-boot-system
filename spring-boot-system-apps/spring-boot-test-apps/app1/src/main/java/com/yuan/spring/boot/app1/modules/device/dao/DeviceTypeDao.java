package com.yuan.spring.boot.app1.modules.device.dao;

import com.yuan.spring.boot.app1.modules.commons.dao.BaseDao;
import com.yuan.spring.boot.app1.modules.device.entity.domain.DeviceType;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author yuane
 * @date 2019/7/16 19:03
 **/
@Repository
@Mapper
public interface DeviceTypeDao extends BaseDao<DeviceType> {
}
