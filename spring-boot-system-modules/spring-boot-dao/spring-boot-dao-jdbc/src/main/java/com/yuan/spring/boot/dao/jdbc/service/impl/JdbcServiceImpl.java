package com.yuan.spring.boot.dao.jdbc.service.impl;

import com.yuan.spring.boot.dao.commons.service.impl.BaseServiceImpl;
import com.yuan.spring.boot.dao.jdbc.dao.JdbcDao;
import com.yuan.spring.boot.dao.jdbc.entity.domain.JdbcDomain;
import com.yuan.spring.boot.dao.jdbc.service.JdbcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * @author yuane
 * @date 2019/7/13 22:42
 **/

public abstract class JdbcServiceImpl<S extends JdbcDao<T, ID>, T extends JdbcDomain<ID>, ID extends Serializable> extends BaseServiceImpl<T, ID> implements JdbcService<T, ID> {
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
        Optional<T> daoById = baseDao.getById(t.getId());
        if (daoById.isPresent()) {
            T t1 = daoById.get();
            t1.copyFrom(t);
            baseDao.update(t1);
        }
    }

    @Override
    protected void baseDelete(T t) {
        baseDao.delete(t);
    }

    @Override
    protected void baseDeleteById(ID id) {
        baseDao.deleteByPrimaryKey(id);
    }

    @Override
    public T get(ID id) {
        return baseDao.getById(id).orElse(null);
    }

    @Override
    public List<T> findAllById(ID[] arrays) {
        return findAllById(Arrays.asList(arrays));
    }

    @Override
    public List<T> findAllById(Collection<ID> collection) {
        return baseDao.findByIds(collection);
    }
}
