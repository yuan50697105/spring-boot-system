package com.yuan.springbootwebmybatisplus.commons.service;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author yuane
 * @date 2019/6/15 23:27
 **/
public interface BaseService<T> extends IService<T> {
    boolean saveBatch(T[] arrays);

    boolean saveBatch(T[] arrays, int batchSize);

    boolean updateBatchById(T[] arrays);

    boolean updateBatchById(T[] arrays, int batchSize);

    boolean saveOrUpdateBatch(T[] arrays);

    boolean saveOrUpdateBatch(T[] arrays, int batchSize);
}
