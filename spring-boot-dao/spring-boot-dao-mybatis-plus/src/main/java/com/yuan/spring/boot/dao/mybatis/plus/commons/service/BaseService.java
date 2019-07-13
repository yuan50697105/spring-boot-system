package com.yuan.spring.boot.dao.mybatis.plus.commons.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuan.spring.boot.dao.mybatis.plus.commons.entity.po.BaseDomain;
import com.yuan.spring.boot.dao.mybatis.plus.commons.exception.CheckNotPassException;

/**
 * @author yuane
 * @date 2019/6/15 23:27
 **/
public interface BaseService<T extends BaseDomain<ID>, ID> extends IService<T> {
    void checkSave(T t) throws CheckNotPassException;

    void checkUpdate(T t) throws CheckNotPassException;

    void checkSaveOrUpdate(T t) throws CheckNotPassException;

    boolean saveBatch(T[] arrays);

    boolean saveBatch(T[] arrays, int batchSize);

    boolean updateBatchById(T[] arrays);

    boolean updateBatchById(T[] arrays, int batchSize);

    boolean saveOrUpdateBatch(T[] arrays);

    boolean saveOrUpdateBatch(T[] arrays, int batchSize);
}
