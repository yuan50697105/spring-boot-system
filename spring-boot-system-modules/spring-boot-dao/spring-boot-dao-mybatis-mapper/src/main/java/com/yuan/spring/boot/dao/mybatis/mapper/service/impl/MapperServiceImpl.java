package com.yuan.spring.boot.dao.mybatis.mapper.service.impl;

import com.yuan.spring.boot.dao.commons.service.impl.BaseServiceImpl;
import com.yuan.spring.boot.dao.mybatis.mapper.dao.MapperDao;
import com.yuan.spring.boot.dao.mybatis.mapper.entity.domain.MapperDomain;
import com.yuan.spring.boot.dao.mybatis.mapper.service.MapperService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author yuane
 * @date 2019/6/15 23:10
 **/
@Transactional(rollbackFor = Exception.class)
public abstract class MapperServiceImpl<S extends MapperDao<T, ID>, T extends MapperDomain<ID>, ID extends Serializable> extends BaseServiceImpl<T, ID> implements MapperService<T, ID> {
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
        T db = baseDao.selectByPrimaryKey(t.getId());
        if (db != null) {
            db.copyFrom(t);
            baseDao.updateByPrimaryKey(db);
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
        return baseDao.selectByPrimaryKey(id);
    }

    @Override
    public List<T> findAllById(ID[] arrays) {
        return findAllById(Arrays.asList(arrays));
    }

    @Override
    public List<T> findAllById(Collection<ID> collection) {
        StringJoiner joiner = new StringJoiner(",");
        for (ID id : collection) {
            joiner.add(id.toString());
        }
        String string = joiner.toString();
        string = string.substring(0, string.lastIndexOf(","));
        return baseDao.selectByIds(string);
    }
}

