package com.yuan.spring.boot.dao.mybatis.commons.service.impl;

import com.yuan.spring.boot.dao.mybatis.commons.dao.BaseDao;
import com.yuan.spring.boot.dao.mybatis.commons.entity.po.BasePo;
import com.yuan.spring.boot.dao.mybatis.commons.service.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author yuane
 * @date 2019/7/10 21:48
 **/

@Transactional(rollbackFor = Exception.class)
public abstract class BaseServiceImpl<T extends BasePo<ID>, ID extends Serializable, S extends BaseDao<T, ID>> implements BaseService<T, ID> {
    protected abstract S getBaseDao();

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(T t) {
        getBaseDao().save(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveIgnoreNull(T t) {
        getBaseDao().saveIgnoreNull(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveAll(T[] arrays) {
        getBaseDao().saveAll(Arrays.asList(arrays));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveAll(Iterable<T> iterable) {
        getBaseDao().saveAll(iterable);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(T t) {
        getBaseDao().insert(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(T t) {
        getBaseDao().update(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateIgnoreNull(T t) {
        getBaseDao().updateIgnoreNull(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(ID id) {
        getBaseDao().deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(ID[] ids) {
        getBaseDao().findAllById(Arrays.asList(ids)).forEach(getBaseDao()::delete);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Iterable<ID> iterable) {
        getBaseDao().findAllById(iterable).forEach(getBaseDao()::delete);
    }

    @Override
    public Optional<T> findById(ID id){
        return getBaseDao().findById(id);
    }

    @Override
    public List<T> findAllById(ID[] ids){
        return getBaseDao().findAllById(Arrays.asList(ids));
    }

    @Override
    public List<T> findAllById(Iterable<ID> iterable){
        return getBaseDao().findAllById(iterable);
    }

    protected boolean isNew(T t){
        return findById(t.getId()).isPresent();
    }
}

