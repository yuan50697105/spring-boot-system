package com.yuan.spring.app1.modules.commons.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuan.spring.app1.modules.commons.entity.domain.BaseEntity;

/**
 * @author yuane
 * @date 2019/7/27 10:52
 **/
public interface BaseService<T extends BaseEntity> extends IService<T> {
}
