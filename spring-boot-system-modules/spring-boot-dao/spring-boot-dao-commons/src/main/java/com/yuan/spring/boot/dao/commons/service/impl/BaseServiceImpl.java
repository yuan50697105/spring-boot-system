package com.yuan.spring.boot.dao.commons.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.yuan.spring.boot.dao.commons.entity.domain.BaseDomain;
import com.yuan.spring.boot.dao.commons.entity.dto.ServiceResult;
import com.yuan.spring.boot.dao.commons.service.BaseService;
import com.yuan.spring.boot.dao.commons.utils.ServiceResultUtils;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.Collectors;

@Transactional(rollbackFor = Exception.class)
public abstract class BaseServiceImpl<T extends BaseDomain<ID>, ID extends Serializable> implements BaseService<T, ID> {
    /**
     * 设置主键,不添加直接返回
     *
     * @param t
     * @return
     */
    protected abstract T setId(T t);

    /**
     * 设置公共方法，不添加直接返回
     *
     * @param t
     * @return
     */
    protected abstract T setCommonsParams(T t);

    protected boolean isNew(T t) {
        return ObjectUtil.isEmpty(t.getId()) && get(t.getId()) == null;
    }

    protected boolean isNotNew(T t) {
        return !isNew(t);
    }

    /**
     * 基本保存，需要根据底层配合实现
     *
     * @param t
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    protected abstract void baseSave(T t);

    /**
     * 基本保存，需要根据底层配合实现
     *
     * @param t
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    protected abstract void baseUpdate(T t);

    /**
     * 基础删除，需要根据底层配合实现
     *
     * @param t
     */
    @Transactional(rollbackFor = Exception.class)
    protected abstract void baseDelete(T t);

    /**
     * 基础删除，需要根据底层配合实现
     *
     * @param id
     */
    @Transactional(rollbackFor = Exception.class)
    protected abstract void baseDeleteById(ID id);

    protected void updateIgnoreNull(T t) {
        T t1 = get(t.getId());
        t1.copyFrom(t);
        setCommonsParams(t1);
        baseUpdate(t);
    }

    @Transactional(rollbackFor = Exception.class)
    protected void baseSaveOrUpdate(T t) {
        if (isNew(t)) {
            baseSave(t);
        } else {
            baseUpdate(t);
        }
    }

    protected ServiceResult checkBatchSave(Collection<T> collection) {
        return getCheckServiceResult(collection, this::checkSave);
    }

    protected ServiceResult checkBatchUpdate(Collection<T> collection) {
        return getCheckServiceResult(collection, this::checkUpdate);
    }

    protected ServiceResult checkBatchSaveOrUpdate(Collection<T> collection) {
        return getCheckServiceResult(collection, this::checkSaveOrUpdate);
    }

    protected ServiceResult checkBatchDelete(Collection<T> collection) {
        return getCheckServiceResult(collection, this::checkDelete);
    }

    private ServiceResult getCheckServiceResult(Collection<T> collection, Function<? super T, ? extends ServiceResult> mapper) {
        int i = 0;
        boolean isSave = true;
        StringJoiner joiner = new StringJoiner(",");
        List<ServiceResult> results = collection.stream().map(mapper).collect(Collectors.toList());
        reduceCheckMessage(i, joiner, results);
        return ServiceResultUtils.check(isSave, joiner.toString());
    }

    private void reduceCheckMessage(int i, StringJoiner joiner, List<ServiceResult> results) {
        for (ServiceResult result : results) {
            ServiceResult.Status status = result.getStatus();
            String message = result.getMessage();
            if (message.lastIndexOf(",") == message.length()) {
                message = message.substring(0, message.lastIndexOf(","));
            }
            if (!status.equals(ServiceResult.Status.OK)) {
                joiner.add("第" + (++i) + "条" + message);
            }
        }
    }

    @Transactional(rollbackFor = Exception.class)
    protected ServiceResult baseSaveBatch(Collection<T> collection) {
        collection.stream().map(this::setId).map(this::setCommonsParams).forEach(this::baseSave);
        return ServiceResultUtils.ok();
    }

    @Transactional(rollbackFor = Exception.class)
    protected ServiceResult baseUpdateBatch(Collection<T> collection) {
        collection.stream().map(this::setCommonsParams).forEach(this::baseUpdate);
        return ServiceResultUtils.ok();
    }

    @Transactional(rollbackFor = Exception.class)
    protected ServiceResult baseSaveOrUpdateBatch(Collection<T> collection) {
        List<T> saveList = collection.stream().filter(this::isNew).map(this::setId).map(this::setCommonsParams).collect(Collectors.toList());
        List<T> updateList = collection.stream().filter(this::isNotNew).map(this::setCommonsParams).collect(Collectors.toList());
        baseSaveBatch(saveList);
        baseUpdateBatch(updateList);
        return ServiceResultUtils.ok();
    }

    @Transactional(rollbackFor = Exception.class)
    protected ServiceResult baseDeleteBatch(Collection<T> collection) {
        collection.forEach(this::delete);
        return ServiceResultUtils.ok();
    }

    @Transactional(rollbackFor = Exception.class)
    protected ServiceResult baseDeleteBatchById(Collection<ID> collection) {
        collection.forEach(this::deleteById);
        return ServiceResultUtils.ok();
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult save(T t) {
        ServiceResult serviceResult = checkSave(t);
        ServiceResult.Status status = serviceResult.getStatus();
        if (status.equals(ServiceResult.Status.OK)) {
            baseSave(setCommonsParams(setId(t)));
            return ServiceResultUtils.ok();
        } else {
            return serviceResult;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult saveAll(T[] arrays) {
        return saveAll(Arrays.asList(arrays));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult saveAll(Collection<T> collection) {
        ServiceResult serviceResult = checkBatchSave(collection);
        ServiceResult.Status status = serviceResult.getStatus();
        if (status.equals(ServiceResult.Status.OK)) {
            return baseSaveBatch(collection);
        } else {
            return serviceResult;
        }
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult update(T t) {
        ServiceResult serviceResult = checkUpdate(t);
        ServiceResult.Status status = serviceResult.getStatus();
        if (status.equals(ServiceResult.Status.OK)) {
            baseUpdate(t);
            return ServiceResultUtils.ok();
        } else {
            return serviceResult;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult updateAll(T[] arrays) {
        return updateAll(Arrays.asList(arrays));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult updateAll(Collection<T> collection) {
        ServiceResult serviceResult = checkBatchUpdate(collection);
        ServiceResult.Status status = serviceResult.getStatus();
        if (status.equals(ServiceResult.Status.OK)) {
            return baseUpdateBatch(collection);
        } else {
            return serviceResult;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult checkSaveOrUpdate(T t) {
        if (isNew(t)) {
            return checkSave(t);
        } else {
            return checkUpdate(t);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult saveOrUpdate(T t) {
        ServiceResult serviceResult = checkSaveOrUpdate(t);
        ServiceResult.Status status = serviceResult.getStatus();
        if (status.equals(ServiceResult.Status.OK)) {
            baseSaveOrUpdate(t);
            return ServiceResultUtils.ok();
        } else {
            return serviceResult;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult saveOrUpdateAll(T[] arrays) {
        return saveAll(Arrays.asList(arrays));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult saveOrUpdateAll(Collection<T> collection) {
        ServiceResult serviceResult = checkBatchSaveOrUpdate(collection);
        ServiceResult.Status status = serviceResult.getStatus();
        if (status.equals(ServiceResult.Status.OK)) {
            return baseSaveOrUpdateBatch(collection);
        } else {
            return serviceResult;
        }
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult delete(T t) {
        ServiceResult serviceResult = checkDelete(t);
        ServiceResult.Status status = serviceResult.getStatus();
        if (status.equals(ServiceResult.Status.OK)) {
            baseDelete(t);
            return ServiceResultUtils.ok();
        } else {
            return serviceResult;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult deleteAll(T[] arrays) {
        return deleteAll(Arrays.asList(arrays));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult deleteAll(Collection<T> collection) {
        ServiceResult serviceResult = checkBatchDelete(collection);
        ServiceResult.Status status = serviceResult.getStatus();
        if (status.equals(ServiceResult.Status.OK)) {
            return baseDeleteBatch(collection);
        } else {
            return serviceResult;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult deleteById(ID id) {
        ServiceResult serviceResult = checkDelete(get(id));
        ServiceResult.Status status = serviceResult.getStatus();
        if (status.equals(ServiceResult.Status.OK)) {
            baseDeleteById(id);
            return ServiceResultUtils.ok();
        } else {
            return serviceResult;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult deleteAllById(ID[] arrays) {
        return deleteAllById(Arrays.asList(arrays));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult deleteAllById(Collection<ID> collection) {
        ServiceResult serviceResult = checkBatchDelete(findAllById(collection));
        ServiceResult.Status status = serviceResult.getStatus();
        if (status.equals(ServiceResult.Status.OK)) {
            return baseDeleteBatchById(collection);
        } else {
            return serviceResult;
        }
    }

}
