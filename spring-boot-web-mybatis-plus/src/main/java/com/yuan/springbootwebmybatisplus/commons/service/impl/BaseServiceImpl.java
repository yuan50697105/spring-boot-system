package com.yuan.springbootwebmybatisplus.commons.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuan.springbootwebmybatisplus.commons.entity.BaseEntity;
import com.yuan.springbootwebmybatisplus.commons.mapper.BaseMapper;
import com.yuan.springbootwebmybatisplus.commons.service.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yuane
 * @date 2019/6/15 23:30
 **/
@Transactional
public abstract class BaseServiceImpl<M extends BaseMapper<T>, T extends BaseEntity> extends ServiceImpl<M, T> implements BaseService<T> {
}
