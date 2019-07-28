package com.yuan.spring.app1.modules.commons.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuan.spring.app1.modules.commons.entity.domain.BaseEntity;
import com.yuan.spring.app1.modules.commons.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * @author yuane
 * @date 2019/7/27 10:53
 **/

@Service
public class BaseServiceImpl<M extends BaseMapper<T>, T extends BaseEntity> extends ServiceImpl<M, T> implements BaseService<T> {
    protected boolean isNotEmpty(Object object) {
        return ObjectUtil.isNotEmpty(object);
    }
}
