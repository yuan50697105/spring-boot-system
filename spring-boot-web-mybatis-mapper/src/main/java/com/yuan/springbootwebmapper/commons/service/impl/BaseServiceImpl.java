package com.yuan.springbootwebmapper.commons.service.impl;

import com.github.pagehelper.IPage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuan.springbootwebmapper.commons.entity.po.BasePo;
import com.yuan.springbootwebmapper.commons.mapper.BaseMapper;
import com.yuan.springbootwebmapper.commons.service.BaseService;
import org.springframework.transaction.annotation.Transactional;
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
public abstract class BaseServiceImpl<T extends BasePo, S extends BaseMapper<T>> implements BaseService<T> {
    public abstract S getMapper();

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(T t) {
        checkInsert(t);
        return getMapper().insert(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertSelective(T t) {
        checkInsertSelective(t);
        return getMapper().insertSelective(t);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertAll(T[] arrays) {
        Arrays.stream(arrays).forEach(this::checkInsert);
        List<T> collect = Arrays.stream(arrays).map(this::setCommonsParameters).collect(Collectors.toList());
        return insertAll(collect);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertAll(List<T> list) {
        list.forEach(this::checkInsert);
        list = list.parallelStream().map(this::setCommonsParameters).collect(Collectors.toList());
        return getMapper().insertList(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(T t) {
        checkUpdate(t);
        return getMapper().updateByPrimaryKey(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateSelective(T t) {
        checkUpdateSelective(t);
        return getMapper().updateByPrimaryKeySelective(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delete(Serializable id) {
        return getMapper().deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delete(Serializable[] ids) {
        return delete(Arrays.asList(ids));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delete(Collection<Serializable> ids) {
        return ids.stream().map(getMapper()::deleteByPrimaryKey).reduce(Integer::sum).orElse(0);
    }

    @Override
    public T findById(Serializable id) {
        return getMapper().selectByPrimaryKey(id);
    }

    @Override
    public T findOne(T t) {
        return getMapper().selectOne(t);
    }

    @Override
    public T findByExample(Example example) {
        return getMapper().selectOneByExample(example);
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

    @Override
    public List<T> findAllByExmaple(Example example) {
        return getMapper().selectByExample(example);
    }

    @Override
    public int count(T t) {
        return getMapper().selectCount(t);
    }

    @Override
    public int countByExample(Example example) {
        return getMapper().selectCountByExample(example);
    }

    private T setCommonsParameters(T t) {
        t.setCreateDate(new Date());
        t.setUpdateDate(new Date());
        t.setCreateUser("");
        t.setUpdateUser("");
        return t;
    }
}

