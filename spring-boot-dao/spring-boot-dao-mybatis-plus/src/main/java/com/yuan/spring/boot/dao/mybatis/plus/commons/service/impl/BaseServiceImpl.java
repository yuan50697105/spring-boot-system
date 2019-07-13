package com.yuan.spring.boot.dao.mybatis.plus.commons.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuan.spring.boot.dao.mybatis.plus.commons.dao.BaseDao;
import com.yuan.spring.boot.dao.mybatis.plus.commons.entity.po.BaseDomain;
import com.yuan.spring.boot.dao.mybatis.plus.commons.exception.CheckNotPassException;
import com.yuan.spring.boot.dao.mybatis.plus.commons.service.BaseService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yuane
 * @date 2019/6/15 23:30
 **/
@Transactional(rollbackFor = Exception.class)
public abstract class BaseServiceImpl<M extends BaseDao<T, ID>, T extends BaseDomain<ID>, ID extends Serializable> extends ServiceImpl<M, T> implements BaseService<T, ID> {

    @Override
    public void checkSaveOrUpdate(T t) throws CheckNotPassException {
        if (isNew(t)) {
            checkSave(t);
        } else {
            checkUpdate(t);
        }
    }

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
        Arrays.stream(arrays).parallel().forEach(this::checkSave);
        List<T> collect = Arrays.stream(arrays).map(this::setCommonsParameters).collect(Collectors.toList());
        return saveBatch(collect);
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
        Arrays.stream(arrays).parallel().forEach(this::checkSave);
        List<T> collect = Arrays.stream(arrays).map(this::setCommonsParameters).collect(Collectors.toList());
        return saveBatch(collect, batchSize);
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
        Arrays.stream(arrays).parallel().forEach(this::checkUpdate);
        List<T> collect = Arrays.stream(arrays).map(this::setCommonsParameters).collect(Collectors.toList());
        return updateBatchById(collect);
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
        Arrays.stream(arrays).parallel().forEach(this::checkUpdate);
        List<T> collect = Arrays.stream(arrays).map(this::setCommonsParameters).collect(Collectors.toList());
        return updateBatchById(collect, batchSize);
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
        Arrays.stream(arrays).parallel().forEach(this::checkSaveOrUpdate);
        List<T> collect = Arrays.stream(arrays).parallel().map(this::setCommonsParameters).collect(Collectors.toList());
        return saveOrUpdateBatch(collect);
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
        Arrays.stream(arrays).parallel().forEach(this::checkSaveOrUpdate);
        List<T> collect = Arrays.stream(arrays).parallel().map(this::setCommonsParameters).collect(Collectors.toList());
        return saveOrUpdateBatch(collect, batchSize);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveOrUpdateBatch(Collection<T> entityList, int batchSize) {
        entityList.parallelStream().forEach(this::checkSaveOrUpdate);
        entityList = entityList.parallelStream().map(this::setCommonsParameters).collect(Collectors.toList());
        return super.saveOrUpdateBatch(entityList, batchSize);
    }

    protected T setCommonsParameters(T entity) {
        entity.setCreateDate(new Date());
        entity.setUpdateDate(new Date());
        return entity;
    }

    protected boolean isNew(T t) {
        return StringUtils.isEmpty(t.getId()) && getById(t.getId()) == null;
    }

}
