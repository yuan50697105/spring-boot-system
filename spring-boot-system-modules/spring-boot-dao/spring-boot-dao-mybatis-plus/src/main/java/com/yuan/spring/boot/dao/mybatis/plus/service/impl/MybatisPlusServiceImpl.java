package com.yuan.spring.boot.dao.mybatis.plus.service.impl;

import com.yuan.spring.boot.dao.commons.service.impl.BaseServiceImpl;
import com.yuan.spring.boot.dao.mybatis.plus.dao.MybatisPlusDao;
import com.yuan.spring.boot.dao.mybatis.plus.entity.domain.MybatisPlusDomain;
import com.yuan.spring.boot.dao.mybatis.plus.service.MybatisPlusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author yuane
 * @date 2019/6/15 23:30
 **/
@Transactional(rollbackFor = Exception.class)
public abstract class MybatisPlusServiceImpl<M extends MybatisPlusDao<T, ID>, T extends MybatisPlusDomain<ID>, ID extends Serializable> extends BaseServiceImpl<T, ID> implements MybatisPlusService<T, ID> {
    @Autowired
    protected M baseDao;

    protected M getBaseDao() {
        return baseDao;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    protected void baseSave(T t) {
        baseDao.insert(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    protected void baseUpdate(T t) {
        T db = baseDao.selectById(t.getId());
        if (db != null) {
            db.copyFrom(t);
            baseDao.updateById(db);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    protected void baseDelete(T t) {
        baseDao.deleteByMap(t.toParamsMap());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    protected void baseDeleteById(ID id) {
        baseDao.deleteById(id);
    }

    @Override
    public T get(ID id) {
        return baseDao.selectById(id);
    }

    @Override
    public List<T> findAllById(ID[] arrays) {
        return findAllById(Arrays.asList(arrays));
    }

    @Override
    public List<T> findAllById(Collection<ID> collection) {
        return baseDao.selectBatchIds(collection);
    }
}
