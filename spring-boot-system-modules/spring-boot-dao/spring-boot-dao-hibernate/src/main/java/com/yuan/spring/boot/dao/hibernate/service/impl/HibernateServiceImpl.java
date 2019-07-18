package com.yuan.spring.boot.dao.hibernate.service.impl;

import com.yuan.spring.boot.dao.commons.service.impl.BaseServiceImpl;
import com.yuan.spring.boot.dao.hibernate.dao.HibernateDao;
import com.yuan.spring.boot.dao.hibernate.entity.domain.HibernateDomain;
import com.yuan.spring.boot.dao.hibernate.service.HibernateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * @author yuane
 * @date 2019/6/15 19:07
 **/

@Slf4j
@Transactional(rollbackFor = Exception.class)
public abstract class HibernateServiceImpl<S extends HibernateDao<T, ID>, T extends HibernateDomain<ID>, ID extends Serializable> extends BaseServiceImpl<T, ID> implements HibernateService<T, ID> {
    @Autowired
    protected S baseDao;

    protected S getBaseDao() {
        return baseDao;
    }

    @Override
    protected void baseSave(T t) {
        baseDao.save(t);
    }

    @Override
    protected void baseUpdate(T t) {
        Optional<T> one = baseDao.findById(t.getId());
        if (one.isPresent()) {
            T t1 = one.get();
            t1.copyFrom(t);
            baseDao.save(t1);
        }
    }

    @Override
    protected void baseDelete(T t) {
        baseDao.delete(t);
    }

    @Override
    protected void baseDeleteById(ID id) {
        baseDao.deleteById(id);
    }

    @Override
    public T get(ID id) {
        return baseDao.findById(id).orElse(null);
    }

    @Override
    public List<T> findAllById(ID[] arrays) {
        return findAllById(Arrays.asList(arrays));
    }

    @Override
    public List<T> findAllById(Collection<ID> collection) {
        return baseDao.findAllById(collection);
    }
}
