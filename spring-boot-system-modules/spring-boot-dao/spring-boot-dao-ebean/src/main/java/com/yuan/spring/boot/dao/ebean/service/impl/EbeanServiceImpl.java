package com.yuan.spring.boot.dao.ebean.service.impl;

import com.yuan.spring.boot.dao.commons.service.impl.BaseServiceImpl;
import com.yuan.spring.boot.dao.ebean.dao.EbeanDao;
import com.yuan.spring.boot.dao.ebean.entity.domain.EbeanDomain;
import com.yuan.spring.boot.dao.ebean.service.EbeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.ebean.querychannel.EbeanQueryChannelService;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * @author yuane
 * @date 2019/7/13 12:37
 **/
public abstract class EbeanServiceImpl<S extends EbeanDao<T, ID>, T extends EbeanDomain<ID>, ID extends Serializable> extends BaseServiceImpl<T, ID> implements EbeanService<T, ID> {
    @Autowired
    protected S baseDao;
    @Autowired
    protected EbeanQueryChannelService ebeanQueryChannelService;

    protected S getBaseDao() {
        return baseDao;
    }

    protected EbeanQueryChannelService getEbeanQueryChannelService() {
        return ebeanQueryChannelService;
    }

    @Override
    protected void baseSave(T t) {
        baseDao.save(t);
    }

    @Override
    protected void baseUpdate(T t) {
        Optional<T> one = baseDao.findById(t.getId());
        if (one.isPresent()) {
            T t1 = one.get();
            t1.copyFrom(t);
            baseDao.save(t1);
        }
    }

    @Override
    protected void baseDelete(T t) {
        baseDao.delete(t);
    }

    @Override
    protected void baseDeleteById(ID id) {
        baseDao.deleteById(id);
    }

    @Override
    public T get(ID id) {
        return baseDao.findById(id).orElse(null);
    }

    @Override
    public List<T> findAllById(ID[] arrays) {
        return findAllById(Arrays.asList(arrays));
    }

    @Override
    public List<T> findAllById(Collection<ID> collection) {
        return baseDao.findAllById(collection);
    }
}
