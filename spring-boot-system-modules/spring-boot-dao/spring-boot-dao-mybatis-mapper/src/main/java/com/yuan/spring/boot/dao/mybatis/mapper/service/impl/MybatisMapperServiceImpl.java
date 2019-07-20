package com.yuan.spring.boot.dao.mybatis.mapper.service.impl;

import com.yuan.spring.boot.dao.commons.service.impl.BaseServiceImpl;
import com.yuan.spring.boot.dao.mybatis.mapper.dao.MybatisMapperDao;
import com.yuan.spring.boot.dao.mybatis.mapper.entity.domain.MybatisMapperDomain;
import com.yuan.spring.boot.dao.mybatis.mapper.service.MybatisMapperService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yuane
 * @date 2019/6/15 23:10
 **/
@Transactional(rollbackFor = Exception.class)
public abstract class MybatisMapperServiceImpl<S extends MybatisMapperDao<T, ID>, T extends MybatisMapperDomain<ID>, ID extends Serializable> extends BaseServiceImpl<T, ID> implements MybatisMapperService<T, ID> {
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
        T db = baseDao.selectByPrimaryKey(t.getId());
        if (db != null) {
            db.copyFrom(t);
            baseDao.updateByPrimaryKey(db);
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
        baseDao.deleteByPrimaryKey(id);
    }

    @Override
    public T get(ID id) {
        return baseDao.selectByPrimaryKey(id);
    }

    @Override
    public List<T> findAllById(ID[] arrays) {
        return findAllById(Arrays.asList(arrays));
    }

    @Override
    public List<T> findAllById(Collection<ID> collection) {
        return collection.stream().map(baseDao::selectByPrimaryKey).collect(Collectors.toList());
    }
}

