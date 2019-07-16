package com.yuan.spring.boot.app1.modules.device.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.yuan.spring.boot.app1.modules.commons.service.impl.BaseServiceImpl;
import com.yuan.spring.boot.app1.modules.device.dao.DeviceTypeDao;
import com.yuan.spring.boot.app1.modules.device.entity.domain.DeviceType;
import com.yuan.spring.boot.app1.modules.device.entity.dto.DeviceTypeQueryParams;
import com.yuan.spring.boot.app1.modules.device.service.DeviceTypeService;
import com.yuan.spring.boot.dao.commons.entity.dto.ServiceResult;
import com.yuan.spring.boot.dao.commons.exception.CheckNotPassException;
import com.yuan.spring.boot.dao.commons.utils.CheckMessageUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.StringJoiner;

/**
 * @author yuane
 * @date 2019/7/16 19:04
 **/
@Service
public class DeviceTypeServiceImpl extends BaseServiceImpl<DeviceTypeDao, DeviceType> implements DeviceTypeService {
    @Override
    public ServiceResult checkSave(DeviceType deviceType) throws CheckNotPassException {
        boolean passFlag = true;
        StringJoiner stringJoiner = new StringJoiner("", ",", ".");
        String name = deviceType.getName();
        if (ObjectUtil.isEmpty(name)) {
            passFlag = false;
            stringJoiner.add("设备类型名称不能为空");
        } else {
            Integer integer = baseDao.selectCount(new QueryWrapper<>(DeviceType.builder().name(name).build()));
            if (integer > 0) {
                passFlag = false;
                stringJoiner.add("设备类型名称" + name + "已存在");
            }
        }
        return CheckMessageUtils.build(passFlag, stringJoiner.toString());
    }

    @Override
    public ServiceResult checkUpdate(DeviceType deviceType) throws CheckNotPassException {
        boolean passFlag = true;
        StringJoiner stringJoiner = new StringJoiner("", ",", ".");
        String name = deviceType.getName();
        if (ObjectUtil.isEmpty(name)) {
            passFlag = false;
            stringJoiner.add("设备类型名称不能为空");
        }
        return CheckMessageUtils.build(passFlag, stringJoiner.toString());
    }

    @Override
    public ServiceResult checkDelete(DeviceType deviceType) throws CheckNotPassException {
        return null;
    }

    @Override
    public IPage<DeviceType> selectPageByParams(Page<DeviceType> objectPage, DeviceTypeQueryParams queryParams) {
        QueryChainWrapper<DeviceType> deviceTypeQueryChainWrapper = getDeviceTypeQueryChainWrapper(queryParams);
        return deviceTypeQueryChainWrapper.page(objectPage);
    }

    private QueryChainWrapper<DeviceType> getDeviceTypeQueryChainWrapper(DeviceTypeQueryParams queryParams) {
        String id = queryParams.getId();
        String[] ids = queryParams.getIds();
        String name = queryParams.getName();
        String createBy = queryParams.getCreateBy();
        String updateBy = queryParams.getUpdateBy();
        Date createDateStart = queryParams.getCreateDateStart();
        Date createDateEnd = queryParams.getCreateDateEnd();
        Date updateDateStart = queryParams.getUpdateDateStart();
        Date updateDateEnd = queryParams.getUpdateDateEnd();
        QueryChainWrapper<DeviceType> deviceTypeQueryChainWrapper = new QueryChainWrapper<>(baseDao);
        deviceTypeQueryChainWrapper.eq(isNotEmpty(id), "id", id);
        deviceTypeQueryChainWrapper.in(isNotEmpty(ids), "id", (Object[]) ids);
        deviceTypeQueryChainWrapper.like(isNotEmpty(name), "name", name);
        deviceTypeQueryChainWrapper.ge(isNotEmpty(createDateStart), "createDate", createDateStart);
        deviceTypeQueryChainWrapper.le(isNotEmpty(createDateEnd), "createDate", DateUtils.addDays(createDateEnd, 1));
        deviceTypeQueryChainWrapper.orderByDesc("createDate");
        return deviceTypeQueryChainWrapper;
    }
}
