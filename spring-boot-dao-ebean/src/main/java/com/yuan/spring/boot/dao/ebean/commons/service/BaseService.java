package com.yuan.spring.boot.dao.ebean.commons.service;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.yuan.spring.boot.dao.ebean.commons.entity.po.BasePo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface BaseService<T extends BasePo<ID>,ID> {
    void checkSave(T t);

    void save(T t);

    void saveAll(T[] arrays);

    void saveAll(Iterable<T> iterable);

    void delete(ID id);

    void delete(ID[] ids);

    void delete(Iterable<ID> iterable);

    Optional<T> findById(ID id);

    Optional<T> findOne(T t);

    List<T> findAllById(ID[] ids);

    List<T> findAll();

    List<T> findAll(T t);

    List<T> findAll(T t, Sort sort);

    Page<T> findAll(Pageable pageable);

    Page<T> findAll(T t, Pageable pageable);
}
