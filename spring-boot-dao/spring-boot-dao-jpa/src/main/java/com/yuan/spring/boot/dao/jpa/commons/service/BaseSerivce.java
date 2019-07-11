package com.yuan.spring.boot.dao.jpa.commons.service;

import com.yuan.spring.boot.dao.jpa.commons.entity.po.BasePo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * @author yuane
 * @date 2019/6/15 19:07
 **/
public interface BaseSerivce<T extends BasePo<ID>, ID extends Serializable> {

    void checkSave(T t) throws RuntimeException;

    void save(T t);

    void saveAll(T[] ts);

    void saveAll(Collection<T> collection);

    void delete(ID id);

    void delete(ID[] ids);

    void delete(Collection<ID> collection);

    Optional<T> findById(ID id);

    List<T> findAllById(ID[] ids);

    List<T> findAllById(Collection<ID> collection);

    Optional<T> findOne(T t);

    List<T> findAll();

    List<T> findAll(T t);

    List<T> findAll(T t, Sort sort);

    Page<T> findAll(Pageable pageable);

    Page<T> findAll(T t, Pageable pageable);

}
