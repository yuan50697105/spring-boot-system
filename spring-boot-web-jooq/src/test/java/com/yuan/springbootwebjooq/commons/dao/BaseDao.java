package com.yuan.springbootwebjooq.commons.dao;

import com.xphsc.easyjdbc.core.EasyJdbcDao;
import com.xphsc.easyjdbc.page.PageInfo;
import org.jooq.Query;
import org.jooq.SelectQuery;

import java.util.List;
import java.util.Optional;

/**
 * @author yuane
 * @date 2019/6/15 23:37
 **/
public interface BaseDao<T> extends EasyJdbcDao<T> {
    PageInfo<T> findAllByQuery(Query query, PageInfo<T> pageInfo);

    PageInfo<T> findAllByQuery(SelectQuery query, PageInfo<T> pageInfo);

    List<T> findAllByQuery(Query query);

    List<T> findAllByQuery(SelectQuery query);

    Optional<T> findOneByQuery(SelectQuery query);
}
