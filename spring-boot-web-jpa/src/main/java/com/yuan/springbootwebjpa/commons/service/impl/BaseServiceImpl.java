package com.yuan.springbootwebjpa.commons.service.impl;

import com.yuan.springbootwebjpa.commons.entity.dto.ArrayQuery;
import com.yuan.springbootwebjpa.commons.entity.dto.CollectionQuery;
import com.yuan.springbootwebjpa.commons.entity.dto.MapQuery;
import com.yuan.springbootwebjpa.commons.entity.po.BasePo;
import com.yuan.springbootwebjpa.commons.repository.BaseRepository;
import com.yuan.springbootwebjpa.commons.service.BaseSerivce;
import org.jooq.Record;
import org.jooq.SelectQuery;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.*;

/**
 * @author yuane
 * @date 2019/6/15 19:07
 **/

@Transactional(rollbackFor = Exception.class)
public abstract class BaseServiceImpl<T extends BasePo, ID extends Serializable, S extends BaseRepository<T, ID>> implements BaseSerivce<T, ID> {
    protected abstract S getRepository();

    protected boolean isNotEmpty(Object object) {
        return !StringUtils.isEmpty(object);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save(T t) {
        getRepository().save(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveAll(T[] ts) {
        saveAll(Arrays.asList(ts));
    }

    @Override
    @Transactional
    public void saveAll(Collection<T> collection) {
        saveAll(collection);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(ID id) {
        getRepository().deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(ID[] ids) {
        delete(Arrays.asList(ids));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Collection<ID> collection) {
        getRepository().findAllById(collection).forEach(getRepository()::delete);
    }

    @Override
    public Optional<T> findById(ID id) {
        return getRepository().findById(id);
    }

    @Override
    public List<T> findAllById(ID[] ids) {
        return findAllById(Arrays.asList(ids));
    }

    @Override
    public List<T> findAllById(Collection<ID> collection) {
        return getRepository().findAllById(collection);
    }

    @Override
    public Optional<T> findOne(T t) {
        return getRepository().findOne(Example.of(t));
    }

    @Override
    public Optional<T> findOne(Specification<T> specification) {
        return getRepository().findOne(specification);
    }

    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public List<T> findAll(T t) {
        return getRepository().findAll(Example.of(t));
    }

    @Override
    public List<T> findAll(T t, Sort sort) {
        return getRepository().findAll(Example.of(t), sort);
    }

    @Override
    public List<T> findAll(Specification<T> specification) {
        return getRepository().findAll(specification);
    }

    @Override
    public List<T> findAll(Specification<T> specification, Sort sort) {
        return getRepository().findAll(specification, sort);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    @Override
    public Page<T> findAll(T t, Pageable pageable) {
        return getRepository().findAll(Example.of(t), pageable);
    }

    @Override
    public Page<T> findAll(Specification<T> specification, Pageable pageable) {
        return getRepository().findAll(specification, pageable);
    }


    @Override
    public Optional<T> findOneBySQL(String sql, Object... objects) {
        return getRepository().findOneBySQL(sql, objects);
    }

    @Override
    public Optional<T> findOneBySQL(String sql, Collection collection) {
        return getRepository().findOneBySQL(sql, collection);
    }

    @Override
    public Optional<T> findOneBySQL(String sql, Map<String, Object> map) {
        return getRepository().findOneBySQL(sql, map);
    }

    @Override
    public Optional<T> findOneBySQL(ArrayQuery query) {
        return getRepository().findOneBySQL(query);
    }

    @Override
    public Optional<T> findOneBySQL(CollectionQuery query) {
        return getRepository().findOneBySQL(query);
    }

    @Override
    public Optional<T> findOneBySQL(MapQuery query) {
        return getRepository().findOneBySQL(query);
    }

    @Override
    public Optional<T> findOneByDSL(SelectQuery<Record> selectQuery) {
        return getRepository().findOneByDSL(selectQuery);
    }

    @Override
    public Optional<T> findOneByHQL(String hql, Object... objects) {
        return getRepository().findOneByHQL(hql, objects);
    }

    @Override
    public Optional<T> findOneByHQL(String hql, Collection collection) {
        return getRepository().findOneByHQL(hql, collection);
    }

    @Override
    public Optional<T> findOneByHQL(String hql, Map<String, Object> map) {
        return getRepository().findOneByHQL(hql, map);
    }

    @Override
    public Optional<T> findOneByHQL(ArrayQuery query) {
        return getRepository().findOneByHQL(query);
    }

    @Override
    public Optional<T> findOneByHQL(CollectionQuery query) {
        return getRepository().findOneByHQL(query);
    }

    @Override
    public Optional<T> findOneByHQL(MapQuery query) {
        return getRepository().findOneByHQL(query);
    }

    @Override
    public List<T> findAllBySQL(String sql, Object... objects) {
        return getRepository().findAllBySQL(sql, objects);
    }

    @Override
    public List<T> findAllBySQL(String sql, Collection collection) {
        return getRepository().findAllBySQL(sql, collection);
    }

    @Override
    public List<T> findAllBySQL(String sql, Map<String, Object> map) {
        return getRepository().findAllBySQL(sql, map);
    }

    @Override
    public List<T> findAllBySQL(ArrayQuery query) {
        return getRepository().findAllBySQL(query);
    }

    @Override
    public List<T> findAllBySQL(CollectionQuery query) {
        return getRepository().findAllBySQL(query);
    }

    @Override
    public List<T> findAllBySQL(MapQuery query) {
        return getRepository().findAllBySQL(query);
    }

    @Override
    public List<T> findAllByDSL(SelectQuery<Record> selectQuery) {
        return getRepository().findAllByDSL(selectQuery);
    }

    @Override
    public List<T> findAllByHQL(String hql, Object... objects) {
        return getRepository().findAllByHQL(hql, objects);
    }

    @Override
    public List<T> findAllByHQL(String hql, Collection collection) {
        return getRepository().findAllByHQL(hql, collection);
    }

    @Override
    public List<T> findAllByHQL(String hql, Map<String, Object> map) {
        return getRepository().findAllByHQL(hql, map);
    }

    @Override
    public List<T> findAllByHQL(ArrayQuery query) {
        return getRepository().findAllByHQL(query);
    }

    @Override
    public List<T> findAllByHQL(CollectionQuery query) {
        return getRepository().findAllByHQL(query);
    }

    @Override
    public List<T> findAllByHQL(MapQuery query) {
        return getRepository().findAllByHQL(query);
    }

    @Override
    public Page<T> findAllBySQL(String sql, Pageable pageable, Object... objects) {
        return getRepository().findAllBySQL(sql, pageable, objects);
    }

    @Override
    public Page<T> findAllBySQL(String sql, Pageable pageable, Collection collection) {
        return getRepository().findAllBySQL(sql, pageable, collection);
    }

    @Override
    public Page<T> findAllBySQL(String sql, Pageable pageable, Map<String, Object> map) {
        return getRepository().findAllBySQL(sql, pageable, map);
    }

    @Override
    public Page<T> findAllByDSL(SelectQuery<Record> selectQuery, Pageable pageable) {
        return getRepository().findAllByDSL(selectQuery, pageable);
    }

    @Override
    public Page<T> findAllBySQL(ArrayQuery query, Pageable pageable) {
        return getRepository().findAllBySQL(query, pageable);
    }

    @Override
    public Page<T> findAllBySQL(CollectionQuery query, Pageable pageable) {
        return getRepository().findAllBySQL(query, pageable);
    }

    @Override
    public Page<T> findAllBySQL(MapQuery query, Pageable pageable) {
        return getRepository().findAllBySQL(query, pageable);
    }

}
