package com.yuan.spring.boot.dao.jpa.service.impl;

import com.yuan.spring.boot.dao.commons.service.impl.BaseServiceImpl;
import com.yuan.spring.boot.dao.jpa.dao.JpaDao;
import com.yuan.spring.boot.dao.jpa.entity.domain.JpaDomain;
import com.yuan.spring.boot.dao.jpa.service.JpaService;
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
public abstract class JpaServiceImpl<S extends JpaDao<T, ID>, T extends JpaDomain<ID>, ID extends Serializable> extends BaseServiceImpl<T, ID> implements JpaService<T, ID> {
    @Autowired
    protected S baseDao;

    protected S getBaseDao() {
        return baseDao;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    protected void baseSave(T t) {
        baseDao.save(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    protected void baseUpdate(T t) {
        Optional<T> one = baseDao.findById(t.getId());
        if (one.isPresent()) {
            T t1 = one.get();
            t1.copyFrom(t);
            baseDao.save(t1);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    protected void baseDelete(T t) {
        baseDao.delete(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
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
