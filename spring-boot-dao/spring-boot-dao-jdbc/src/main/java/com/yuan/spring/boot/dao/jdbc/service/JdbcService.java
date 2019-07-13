package com.yuan.spring.boot.dao.jdbc.service;

import com.xphsc.easyjdbc.core.entity.Sorts;
import com.xphsc.easyjdbc.page.PageInfo;
import com.yuan.spring.boot.dao.commons.service.BaseService;
import com.yuan.spring.boot.dao.jdbc.entity.domain.JdbcDomain;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @author yuane
 * @date 2019/7/13 22:41
 **/
public interface JdbcService<T extends JdbcDomain<ID>, ID extends Serializable> extends BaseService<T, ID> {
    List<T> findAllById(ID[] arrays);

    List<T> findAllById(Collection<ID> collection);

    List<T> findAll();

    PageInfo<T> findAll(PageInfo pageInfo);

    List<T> findAll(Sorts sorts);

    PageInfo<T> findAll(PageInfo pageInfo, Sorts sorts);
}
