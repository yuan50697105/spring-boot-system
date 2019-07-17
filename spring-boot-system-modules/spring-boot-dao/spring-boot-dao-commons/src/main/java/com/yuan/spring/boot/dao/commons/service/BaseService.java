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
     * @param t
     *         需检查的实体
     *
     * @return 返回处理结果，并提交给
     *
     * @throws CheckNotPassException
     */
    ServiceResult checkSaveOrUpdate(T t) throws CheckNotPassException;

    /**
     * 执行保存更新,执行之前会执行checkSaveOrUpdate
     *
     * @param t
     *         操作的实体
     *
     * @return 操作结果
     */
    ServiceResult saveOrUpdate(T t);

    /**
     * 以数组进行批量保存更新
     *
     * @param arrays
     *
     * @return
     */
    ServiceResult saveOrUpdateBatch(T[] arrays);

    /**
     * 以集合方式进行批量保存更新
     *
     * @param collection
     *
     * @return
     */
    ServiceResult saveOrUpdateBatch(Collection<T> collection);

    /**
     * 只检查保存操作
     *
     * @param t
     *
     * @return
     *
     * @throws CheckNotPassException
     */
    ServiceResult checkSave(T t) throws CheckNotPassException;

    /**
     * 只进行保存操作，执行之前执行checkSave
     * @param t
     * @return
     */
    ServiceResult save(T t);

    /**
     * 数组批量保存
     * @param arrays
     * @return
     */
    ServiceResult saveBatch(T[] arrays);

    /**
     * 集合批量保存
     * @param collection
     * @return
     */
    ServiceResult saveBatch(Collection<T> collection);

    /**
     * 检查更新
     * @param t
     * @return
     * @throws CheckNotPassException
     */
    ServiceResult checkUpdate(T t) throws CheckNotPassException;

    /**
     * 更新操作，执行之前检查更新
     * @param t
     * @return
     */
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
