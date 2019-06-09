package com.yuan.springbootwebmapper.utils;

import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.entity.EntityTable;
import tk.mybatis.mapper.genid.GenId;
import tk.mybatis.mapper.gensql.GenSql;

/**
 * @author yuane
 * @date 2019/6/8 16:22
 **/
public class MyGenSql implements GenId<String>,GenSql {
    @Override
    public String genSql(EntityTable entityTable, EntityColumn entityColumn) {
        return IdUtils.generateId();
    }

    @Override
    public String genId(String table, String column) {
        return IdUtils.generateId();
    }
}
