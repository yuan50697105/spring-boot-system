package com.yuan.spring.boot.dao.commons.service;

import com.yuan.spring.boot.dao.commons.entity.domain.BaseDomain;
import com.yuan.spring.boot.dao.commons.entity.dto.ServiceResult;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @author yuane
 * @date 2019/7/13 12:38
 **/
public interface BaseService<T extends BaseDomain<ID>, ID extends Serializable> {
    /**
     * 检查要保存的实体
     *
     * @param t
     */
    ServiceResult checkSave(T t);

    /**
     * 保存实体
     *
     * @param t
     * @return
     */
    ServiceResult save(T t);

    ServiceResult saveAll(T[] arrays);

    ServiceResult saveAll(Collection<T> collection);

    /**
     * 检查要更新的实体
     *
     * @param t
     * @return
     */
    ServiceResult checkUpdate(T t);

    /**
     * 更新实体
     *
     * @param t
     * @return
     */
    ServiceResult update(T t);

    ServiceResult updateAll(T[] arrays);

    ServiceResult updateAll(Collection<T> collection);

    /**
     * 检查保存更新实体
     *
     * @param t
     * @return
     */
    ServiceResult checkSaveOrUpdate(T t);

    /**
     * 保存更新实体
     *
     * @param t
     * @return
     */
    ServiceResult saveOrUpdate(T t);

    ServiceResult saveOrUpdateAll(T[] arrays);

    ServiceResult saveOrUpdateAll(Collection<T> collection);

    /**
     * 检查删除
     *
     * @param t
     * @return
     */
    ServiceResult checkDelete(T t);

    /*
    删除操作
     */
    ServiceResult delete(T t);

    ServiceResult deleteAll(T[] arrays);

    ServiceResult deleteAll(Collection<T> collection);

    /**
     * 根据ID删除
     *
     * @param id
     * @return
     */
    ServiceResult deleteById(ID id);

    ServiceResult deleteAllById(ID[] arrays);

    ServiceResult deleteAllById(Collection<ID> collection);

    T get(ID id);

    List<T> findAllById(ID[] arrays);

    List<T> findAllById(Collection<ID> collection);
}
