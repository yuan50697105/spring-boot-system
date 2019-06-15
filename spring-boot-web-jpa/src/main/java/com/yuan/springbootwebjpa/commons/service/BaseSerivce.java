package com.yuan.springbootwebjpa.commons.service;

import com.yuan.springbootwebjpa.commons.entity.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * @author yuane
 * @date 2019/6/15 19:07
 **/
public interface BaseSerivce<T extends BaseEntity, ID extends Serializable> {
    @Transactional
    T save(T t);

    Iterable<T> saveAll(Iterable<T> ts);

    void delete(ID id);

    @Transactional
    void delete(ID... ids);

    @Transactional
    void delete(Iterable<ID> ids);

    Optional<T> findById(ID id);

    List<T> findAllById(Iterable<ID> ids);

    Optional<T> findOneByExample(T t);

    List<T> findAll();

    List<T> findAll(T t);

    List<T> findAll(T t, Sort sort);

    Page<T> findAll(Pageable pageable);

    Page<T> findAll(T t, Pageable pageable);
}
