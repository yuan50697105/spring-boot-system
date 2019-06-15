package com.yuan.springbootwebjpa.commons.service;

import com.yuan.springbootwebjpa.commons.entity.BaseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/6/15 19:07
 **/
public interface BaseSerivce<T extends BaseEntity, ID extends Serializable> {
    @Transactional
    T save(T t);

    Iterable<T> saveAll(Iterable<T> ts);
}
