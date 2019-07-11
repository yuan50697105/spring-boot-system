package com.yuan.spring.boot.dao.mybatis.mapper.commons.service.impl;

import com.github.pagehelper.IPage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuan.spring.boot.dao.mybatis.mapper.commons.dao.BaseDao;
import com.yuan.spring.boot.dao.mybatis.mapper.commons.entity.po.BasePo;
import com.yuan.spring.boot.dao.mybatis.mapper.commons.service.BaseService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yuane
 * @date 2019/6/15 23:10
 **/
@Transactional(rollbackFor = Exception.class)
public abstract class BaseServiceImpl<T extends BasePo<ID>, ID extends Serializable, S extends BaseDao<T, ID>> implements BaseService<T, ID> {
    public abstract S getMapper();

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(T t) {
        return getMapper().insert(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertSelective(T t) {
        return getMapper().insertSelective(t);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertAll(T[] arrays) {
        List<T> collect = Arrays.stream(arrays).map(this::setCommonsParameters).collect(Collectors.toList());
        return insertAll(collect);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertAll(List<T> list) {
        list = list.parallelStream().map(this::setCommonsParameters).collect(Collectors.toList());
        return getMapper().insertList(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(T t) {
        return getMapper().updateByPrimaryKey(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateSelective(T t) {
        return getMapper().updateByPrimaryKeySelective(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delete(ID id) {
        return getMapper().deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delete(ID[] ids) {
        return delete(Arrays.asList(ids));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delete(Collection<ID> ids) {
        return ids.stream().map(getMapper()::deleteByPrimaryKey).reduce(Integer::sum).orElse(0);
    }

    @Override
    public T findById(ID id) {
        return getMapper().selectByPrimaryKey(id);
    }

    @Override
    public List<T> findAllById(ID[] ids) {
        return Arrays.stream(ids).map(this::findById).collect(Collectors.toList());
    }

    @Override
    public List<T> findAllById(Collection<ID> collection) {
        return collection.stream().map(this::findById).collect(Collectors.toList());
    }

    @Override
    public T findOne(T t) {
        return getMapper().selectOne(t);
    }


    @Override
    public PageInfo<T> findAll(IPage page) {
        PageHelper.startPage(page);
        return PageInfo.of(getMapper().selectAll());
    }

    @Override
    public PageInfo<T> findAll(T t, IPage page) {
        PageHelper.startPage(page);
        return PageInfo.of(getMapper().select(t));
    }

    @Override
    public PageInfo<T> findAll(Example example, IPage page) {
        PageHelper.startPage(page);
        return PageInfo.of(getMapper().selectByExample(example));
    }

    @Override
    public List<T> findAll() {
        return getMapper().selectAll();
    }

    @Override
    public List<T> findAll(T t) {
        return getMapper().select(t);
    }

    protected boolean isNew(T t) {
        return StringUtils.isEmpty(t.getId()) && findById(t.getId()) == null;
    }

    protected T setCommonsParameters(T t) {
        t.setCreateDate(new Date());
        t.setUpdateDate(new Date());
        t.setCreateUser("");
        t.setUpdateUser("");
        return t;
    }


}

