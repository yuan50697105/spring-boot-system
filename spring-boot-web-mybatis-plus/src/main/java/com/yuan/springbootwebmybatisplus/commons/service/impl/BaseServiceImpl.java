package com.yuan.springbootwebmybatisplus.commons.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuan.springbootwebmybatisplus.commons.entity.po.BasePo;
import com.yuan.springbootwebmybatisplus.commons.mapper.BaseMapper;
import com.yuan.springbootwebmybatisplus.commons.service.BaseService;
import com.yuan.springbootwebmybatisplus.system.entity.po.SysUser;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * @author yuane
 * @date 2019/6/15 23:30
 **/
@Transactional(rollbackFor = Exception.class)
public abstract class BaseServiceImpl<M extends BaseMapper<T>, T extends BasePo> extends ServiceImpl<M, T> implements BaseService<T> {
    protected abstract void checkSave(T t) throws RuntimeException;

    protected abstract void checkUpdate(T t) throws RuntimeException;

    protected abstract void checkSaveOrUpdate(T t) throws RuntimeException;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(T entity) {
        checkSave(entity);
        setCommonsParameters(entity);
        return super.save(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveBatch(T[] arrays) {
        return saveBatch(Arrays.asList(arrays));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveBatch(Collection<T> entityList) {
        entityList.parallelStream().forEach(this::checkSave);
        entityList = entityList.parallelStream().map(this::setCommonsParameters).collect(Collectors.toList());
        return super.saveBatch(entityList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveBatch(T[] arrays, int batchSize) {
        return saveBatch(Arrays.asList(arrays), batchSize);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveBatch(Collection<T> entityList, int batchSize) {
        entityList.parallelStream().forEach(this::checkSave);
        entityList = entityList.parallelStream().map(this::setCommonsParameters).collect(Collectors.toList());
        return super.saveBatch(entityList, batchSize);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateById(T entity) {
        checkUpdate(entity);
        setCommonsParameters(entity);
        return super.updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateBatchById(T[] arrays) {
        return updateBatchById(Arrays.asList(arrays));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateBatchById(Collection<T> entityList) {
        entityList.parallelStream().forEach(this::checkUpdate);
        entityList = entityList.parallelStream().map(this::setCommonsParameters).collect(Collectors.toList());
        return super.updateBatchById(entityList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateBatchById(T[] arrays, int batchSize) {
        return updateBatchById(Arrays.asList(arrays), batchSize);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateBatchById(Collection<T> entityList, int batchSize) {
        entityList.parallelStream().forEach(this::checkUpdate);
        entityList = entityList.parallelStream().map(this::setCommonsParameters).collect(Collectors.toList());
        return super.updateBatchById(entityList, batchSize);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveOrUpdate(T entity) {
        checkSaveOrUpdate(entity);
        setCommonsParameters(entity);
        return super.saveOrUpdate(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveOrUpdateBatch(T[] arrays) {
        return saveOrUpdateBatch(Arrays.asList(arrays));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveOrUpdateBatch(Collection<T> entityList) {
        entityList.parallelStream().forEach(this::checkSaveOrUpdate);
        entityList = entityList.parallelStream().map(this::setCommonsParameters).collect(Collectors.toList());
        return super.saveOrUpdateBatch(entityList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveOrUpdateBatch(T[] arrays, int batchSize) {
        return saveOrUpdateBatch(Arrays.asList(arrays), batchSize);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveOrUpdateBatch(Collection<T> entityList, int batchSize) {
        entityList.parallelStream().forEach(this::checkSaveOrUpdate);
        entityList = entityList.parallelStream().map(this::setCommonsParameters).collect(Collectors.toList());
        return super.saveOrUpdateBatch(entityList, batchSize);
    }

    private T setCommonsParameters(T entity) {
        entity.setCreateDate(new Date());
        entity.setUpdateDate(new Date());
        entity.setCreateUser("");
        entity.setUpdateUser("");
        return entity;
    }

    void test() {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<SysUser> lambda = queryWrapper.lambda();
        lambda.like(SysUser::getUsername, "aaa");
        lambda.eq(SysUser::getId, "111");
    }

}
