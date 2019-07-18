package com.yuan.spring.boot.dao.commons.service;

import com.yuan.spring.boot.dao.commons.entity.domain.BaseDomain;
import com.yuan.spring.boot.dao.commons.entity.dto.ServiceResult;
import com.yuan.spring.boot.dao.commons.exception.CheckNotPassException;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author yuane
 * @date 2019/7/13 12:38
 **/
public interface BaseService<T extends BaseDomain<ID>, ID extends Serializable> {
    /**
     * 检查保存更新操作
     * 如果在controller中使用请不要使用表单验证
     *
     * @param t 需检查的实体
     * @return 返回处理结果，并提交给
     * @throws CheckNotPassException
     */
    ServiceResult checkSaveOrUpdate(T t) throws CheckNotPassException;

    ServiceResult baseSaveOrUpdate(T t);

    /**
     * 执行保存更新,执行之前会执行checkSaveOrUpdate
     *
     * @param t 操作的实体
     * @return 操作结果
     */
    ServiceResult saveOrUpdate(T t);

    ServiceResult baseSaveOrUpdateBatch(T[] arrays);

    ServiceResult saveOrUpdateBatch(T[] arrays);

    ServiceResult baseSaveOrUpdateBatch(Collection<T> collection);

    ServiceResult saveOrUpdateBatch(Collection<T> collection);

    ServiceResult checkSave(T t) throws CheckNotPassException;

    ServiceResult baseSave(T t);

    ServiceResult save(T t);

    ServiceResult baseSaveBatch(T[] arrays);

    ServiceResult saveBatch(T[] arrays);

    ServiceResult baseSaveBatch(Collection<T> collection);

    ServiceResult saveBatch(Collection<T> collection);

    ServiceResult checkUpdate(T t) throws CheckNotPassException;

    ServiceResult baseUpdate(T t);

    ServiceResult update(T t);

    ServiceResult baseUpdateBatch(T[] arrays);

    ServiceResult updateBatch(T[] arrays);

    ServiceResult baseUpdateBatch(Collection<T> collection);

    ServiceResult updateBatch(Collection<T> collection);

    ServiceResult deleteById(ID id);

    ServiceResult deleteById(ID[] ids);

    ServiceResult deleteById(Collection<ID> collection);

    ServiceResult checkDelete(T t) throws CheckNotPassException;

    ServiceResult delete(T t);

    ServiceResult delete(T[] arrays);

    ServiceResult delete(Collection<T> collection);

    T get(ID id);

}
