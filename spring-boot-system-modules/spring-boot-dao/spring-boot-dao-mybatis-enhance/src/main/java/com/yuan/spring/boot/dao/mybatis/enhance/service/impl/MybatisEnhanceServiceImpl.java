package com.yuan.spring.boot.dao.mybatis.enhance.service.impl;

import com.yuan.spring.boot.dao.commons.service.impl.BaseServiceImpl;
import com.yuan.spring.boot.dao.mybatis.enhance.dao.MybatisEnhanceDao;
import com.yuan.spring.boot.dao.mybatis.enhance.entity.domain.MybatisEnhanceDomain;
import com.yuan.spring.boot.dao.mybatis.enhance.service.MybatisEnhanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Transactional(rollbackFor = Exception.class)
public abstract class MybatisEnhanceServiceImpl<S extends MybatisEnhanceDao<T, ID>, T extends MybatisEnhanceDomain<ID>, ID extends Serializable> extends BaseServiceImpl<T, ID> implements MybatisEnhanceService<T, ID> {
    @Autowired
    protected S baseDao;

    protected S getBaseDao() {
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
        T db = baseDao.selectOne(t.getId());
        if (db != null) {
            db.copyFrom(t);
            baseDao.update(db);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    protected void baseDelete(T t) {
        baseDao.deleteOne(t.getId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
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

