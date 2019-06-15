package com.yuan.springbootwebjooq.commons.dao.impl;

import com.xphsc.easyjdbc.EasyJdbcTemplate;
import com.xphsc.easyjdbc.core.SimpleJdbcDao;
import com.xphsc.easyjdbc.page.PageInfo;
import com.yuan.springbootwebjooq.commons.dao.BaseDao;
import org.jooq.DSLContext;
import org.jooq.SelectQuery;

import java.util.List;

/**
 * @author yuane
 * @date 2019/6/15 23:37
 **/
public abstract class BaseDaoImpl<T> extends SimpleJdbcDao<T> implements BaseDao<T> {
    private DSLContext dslContext;
    private EasyJdbcTemplate easyJdbcTemplate;

    protected BaseDaoImpl(DSLContext dslContext, EasyJdbcTemplate easyJdbcTemplate) {
        this.dslContext = dslContext;
        this.easyJdbcTemplate = easyJdbcTemplate;
    }

    public DSLContext getDslContext() {
        return dslContext;
    }

    @Override
    public PageInfo<T> findAllByQuery(SelectQuery query, PageInfo<T> pageInfo) {
        String sql = query.getSQL();
        List<Object> bindValues = query.getBindValues();
        return easyJdbcTemplate.findByPage(sql, modelClass, pageInfo, bindValues.toArray());
    }

    @Override
    public List<T> findAllByQuery(SelectQuery query) {
        String sql = query.getSQL();
        List<Object> bindValues = query.getBindValues();
        return easyJdbcTemplate.find(sql, modelClass, bindValues.toArray());
    }
}
