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
    ServiceResult checkSaveOrUpdate(T t) throws CheckNotPassException;

    ServiceResult saveOrUpdate(T t);

    ServiceResult saveOrUpdateBatch(T[] arrays);

    ServiceResult saveOrUpdateBatch(Collection<T> collection);

    ServiceResult checkSave(T t) throws CheckNotPassException;

    ServiceResult save(T t);

    ServiceResult saveBatch(T[] arrays);

    ServiceResult saveBatch(Collection<T> collection);

    ServiceResult checkUpdate(T t) throws CheckNotPassException;

    ServiceResult update(T t);

    ServiceResult updateBatch(T[] arrays);

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
