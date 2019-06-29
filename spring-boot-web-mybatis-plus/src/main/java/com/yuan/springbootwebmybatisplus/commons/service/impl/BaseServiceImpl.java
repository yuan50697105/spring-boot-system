package com.yuan.springbootwebmybatisplus.commons.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuan.springbootwebmybatisplus.commons.entity.po.BasePo;
import com.yuan.springbootwebmybatisplus.commons.mapper.BaseMapper;
import com.yuan.springbootwebmybatisplus.commons.service.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * @author yuane
 * @date 2019/6/15 23:30
 **/
@Transactional(rollbackFor = Exception.class)
public abstract class BaseServiceImpl<M extends BaseMapper<T>, T extends BasePo> extends ServiceImpl<M, T> implements BaseService<T> {
    protected abstract void beforeSave(T t);

    protected abstract void beforeUpdate(T t);

    protected abstract void beforeSaveOrUpdate(T t);

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(T entity) {
        beforeSave(entity);
        return super.save(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveBatch(Collection<T> entityList) {
        entityList.forEach(this::beforeSave);
        return super.saveBatch(entityList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveBatch(Collection<T> entityList, int batchSize) {
        entityList.forEach(this::beforeSave);
        return super.saveBatch(entityList, batchSize);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateById(T entity) {
        beforeUpdate(entity);
        return super.updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateBatchById(Collection<T> entityList) {
        entityList.forEach(this::beforeUpdate);
        return super.updateBatchById(entityList);
    }

    @Override
    public boolean updateBatchById(Collection<T> entityList, int batchSize) {
        entityList.forEach(this::beforeUpdate);
        return super.updateBatchById(entityList, batchSize);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveOrUpdate(T entity) {
        beforeSaveOrUpdate(entity);
        return super.saveOrUpdate(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveOrUpdateBatch(Collection<T> entityList) {
        entityList.forEach(this::beforeSaveOrUpdate);
        return super.saveOrUpdateBatch(entityList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveOrUpdateBatch(Collection<T> entityList, int batchSize) {
        entityList.forEach(this::beforeSaveOrUpdate);
        return super.saveOrUpdateBatch(entityList, batchSize);
    }


}
