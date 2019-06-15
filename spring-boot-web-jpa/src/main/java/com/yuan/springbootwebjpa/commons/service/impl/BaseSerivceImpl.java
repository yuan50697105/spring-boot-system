package com.yuan.springbootwebjpa.commons.service.impl;

import com.yuan.springbootwebjpa.commons.entity.BaseEntity;
import com.yuan.springbootwebjpa.commons.repository.BaseRepository;
import com.yuan.springbootwebjpa.commons.service.BaseSerivce;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/6/15 19:07
 **/

public abstract class BaseSerivceImpl<T extends BaseEntity, ID extends Serializable, S extends BaseRepository<T, ID>> implements BaseSerivce<T, ID> {
    protected abstract S getRepository();

    @Override
    @Transactional
    public T save(T t) {
        return getRepository().save(t);
    }

    @Override
    public Iterable<T> saveAll(Iterable<T> ts) {
        return getRepository().saveAll(ts);
    }
}
