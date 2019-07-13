package com.yuan.spring.boot.dao.hibernate.entity.dto;

import lombok.Data;

/**
 * @author yuane
 * @date 2019/6/20 19:28
 **/
@Data
public final class ArrayQuery implements BaseQuery<Object[]> {
    private String sql;
    private Object[] params;


    private ArrayQuery(String sql, Object... params) {
        this.sql = sql;
        this.params = params;
    }

    public static ArrayQuery build(String sql, Object... params) {
        return new ArrayQuery(sql, params);
    }

}
