package com.yuan.spring.boot.dao.commons.service;

import com.yuan.spring.boot.dao.commons.entity.domain.BaseDomain;
import com.yuan.spring.boot.dao.commons.entity.dto.DtoResult;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author yuane
 * @date 2019/7/13 12:38
 **/
public interface BaseService<T extends BaseDomain<ID>, ID extends Serializable> {
    DtoResult checkSaveOrUpdate(T t);

    DtoResult saveOrUpdate(T t);

    DtoResult saveOrUpdateBatch(T[] arrays);

    DtoResult saveOrUpdateBatch(Collection<T> collection);

    DtoResult checkSave(T t);

    DtoResult save(T t);

    DtoResult saveBatch(T[] arrays);

    DtoResult saveBatch(Collection<T> collection);

    DtoResult checkUpdate(T t);

    DtoResult update(T t);

    DtoResult updateBatch(T[] arrays);

    DtoResult updateBatch(Collection<T> collection);

    DtoResult deleteById(ID id);

    DtoResult deleteById(ID[] ids);

    DtoResult deleteById(Collection<ID> collection);

    DtoResult checkDelete(T t);

    DtoResult delete(T t);

    DtoResult delete(T[] arrays);

    DtoResult delete(Collection<T> collection);

    T get(ID id);

}
