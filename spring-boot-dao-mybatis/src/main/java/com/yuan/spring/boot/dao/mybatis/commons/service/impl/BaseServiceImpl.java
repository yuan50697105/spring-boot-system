package com.yuan.spring.boot.dao.mybatis.commons.service.impl;

import com.yuan.spring.boot.dao.mybatis.commons.repository.BaseRepositoy;
import com.yuan.spring.boot.dao.mybatis.commons.service.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

/**
 * @author yuane
 * @date 2019/7/10 21:48
 **/

@Transactional(rollbackFor = Exception.class)
public abstract class BaseServiceImpl<T, ID, S extends BaseRepositoy<T, ID>> implements BaseService<T, ID> {
    protected abstract S getBaseRepositoy();

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(T t) {
        getBaseRepositoy().save(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveIgnoreNull(T t) {
        getBaseRepositoy().saveIgnoreNull(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveAll(T[] arrays) {
        getBaseRepositoy().saveAll(Arrays.asList(arrays));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveAll(Iterable<T> iterable) {
        getBaseRepositoy().saveAll(iterable);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(T t) {
        getBaseRepositoy().insert(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(T t) {
        getBaseRepositoy().update(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateIgnoreNull(T t) {
        getBaseRepositoy().updateIgnoreNull(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(ID id) {
        getBaseRepositoy().deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(ID[] ids) {
        getBaseRepositoy().findAllById(Arrays.asList(ids)).forEach(getBaseRepositoy()::delete);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Iterable<ID> iterable) {
        getBaseRepositoy().findAllById(iterable).forEach(getBaseRepositoy()::delete);
    }
}

