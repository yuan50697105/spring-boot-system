package com.yuan.spring.boot.app1.modules.system.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yuan.spring.boot.app1.modules.commons.service.impl.BaseServiceImpl;
import com.yuan.spring.boot.app1.modules.system.dao.SysResourceDao;
import com.yuan.spring.boot.app1.modules.system.entity.domain.SysResource;
import com.yuan.spring.boot.app1.modules.system.service.SysResourceService;
import com.yuan.spring.boot.dao.commons.entity.dto.ServiceResult;
import com.yuan.spring.boot.dao.commons.exception.CheckNotPassException;
import com.yuan.spring.boot.dao.commons.utils.CheckMessageUtils;
import com.yuan.spring.boot.dao.commons.utils.ServiceResultUtils;
import org.springframework.stereotype.Service;

import java.util.StringJoiner;

/**
 * @author yuane
 * @date 2019/7/15 23:41
 **/
@Service
public class SysResourceServiceImpl extends BaseServiceImpl<SysResourceDao, SysResource> implements SysResourceService {
    @Override
    public ServiceResult checkSave(SysResource sysResource) throws CheckNotPassException {
        boolean passFlag = true;
        StringJoiner stringJoiner = new StringJoiner("", "，", "。");
        String name = sysResource.getName();
        String url = sysResource.getUrl();
        Integer type = sysResource.getType();
        if (ObjectUtil.isEmpty(name)) {
            passFlag = false;
            stringJoiner.add("名称不能为空");
        } else {
            Integer integer = baseDao.selectCount(new QueryWrapper<>(SysResource.builder().name(name).build()));
            if (integer > 0) {
                passFlag = false;
                stringJoiner.add(name + "名称已存在");
            }
        }
        if (ObjectUtil.isEmpty(url)) {
            passFlag = false;
            stringJoiner.add("链接不能为空");
        } else {
            Integer integer = baseDao.selectCount(new QueryWrapper<>(SysResource.builder().url(url).build()));
            if (integer > 0) {
                passFlag = false;
                stringJoiner.add(url + "链接已存在");
            }
        }
        if (ObjectUtil.isEmpty(type)) {
            passFlag = false;
            stringJoiner.add("类型不能为空");
        }
        return CheckMessageUtils.build(passFlag, stringJoiner.toString());
    }

    @Override
    public ServiceResult checkUpdate(SysResource sysResource) throws CheckNotPassException {
        boolean passFlag = true;
        StringJoiner stringJoiner = new StringJoiner("", "，", "。");
        String name = sysResource.getName();
        String url = sysResource.getUrl();
        Integer type = sysResource.getType();
        if (ObjectUtil.isEmpty(name)) {
            passFlag = false;
            stringJoiner.add("名称不能为空");
        }
        if (ObjectUtil.isEmpty(url)) {
            passFlag = false;
            stringJoiner.add("链接不能为空");
        }
        if (ObjectUtil.isEmpty(type)) {
            passFlag = false;
            stringJoiner.add("类型不能为空");
        }
        return CheckMessageUtils.build(passFlag, stringJoiner.toString());
    }

    @Override
    public ServiceResult checkDelete(SysResource sysResource) throws CheckNotPassException {
        return ServiceResultUtils.ok();
    }
}
