package com.yuan.spring.boot.dao.mybatis.service.impl;

import com.yuan.spring.boot.dao.commons.service.impl.BaseServiceImpl;
import com.yuan.spring.boot.dao.mybatis.entity.domain.MybatisDomain;
import com.yuan.spring.boot.dao.mybatis.repository.BaseMybatisRepository;
import com.yuan.spring.boot.dao.mybatis.service.MybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author yuane
 * @date 2019/7/10 21:48
 **/

@Transactional(rollbackFor = Exception.class)
public abstract class MybatisServiceImpl<S extends BaseMybatisRepository<T, ID>, T extends MybatisDomain<ID>, ID extends Serializable> extends BaseServiceImpl<T, ID> implements MybatisService<T, ID> {
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
        T byId = baseDao.getById(t.getId());
        if (byId != null) {
            byId.copyFrom(t);
            baseDao.save(byId);
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

