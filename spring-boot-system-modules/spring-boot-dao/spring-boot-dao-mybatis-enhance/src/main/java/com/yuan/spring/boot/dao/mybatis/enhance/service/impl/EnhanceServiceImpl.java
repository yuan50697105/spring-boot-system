package com.yuan.spring.boot.dao.mybatis.enhance.service.impl;

import com.yuan.spring.boot.dao.commons.service.impl.BaseServiceImpl;
import com.yuan.spring.boot.dao.mybatis.enhance.dao.BaseDao;
import com.yuan.spring.boot.dao.mybatis.enhance.entity.domain.EnhanceDomain;
import com.yuan.spring.boot.dao.mybatis.enhance.service.EnhanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Transactional(rollbackFor = Exception.class)
public abstract class EnhanceServiceImpl<S extends BaseDao<T, ID>, T extends EnhanceDomain<ID>, ID extends Serializable> extends BaseServiceImpl<T, ID> implements EnhanceService<T, ID> {
    @Autowired
    protected S baseDao;

    protected S getBaseDao() {
        return baseDao;
    }

    @Override
    protected void baseSave(T t) {
        baseDao.insert(t);
    }

    @Override
    protected void baseUpdate(T t) {
        T db = baseDao.selectOne(t.getId());
        if (db != null) {
            db.copyFrom(t);
            baseDao.update(db);
        }
    }

    @Override
    protected void baseDelete(T t) {
        baseDao.deleteOne(t.getId());
    }

    @Override
    protected void baseDeleteById(ID id) {
        baseDao.deleteOne(id);
    }


    @Override
    public T get(ID id) {
        return baseDao.selectOne(id);
    }

    @Override
    public List<T> findAllById(ID[] arrays) {
        return baseDao.selectArray(arrays);
    }

    @Override
    public List<T> findAllById(Collection<ID> collection) {
        return baseDao.selectCollection(collection);
    }
}

