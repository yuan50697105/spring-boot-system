package com.yuan.springbootwebjpa.commons.entity.dto;

import lombok.Data;

/**
 * @author yuane
 * @date 2019/6/20 19:28
 **/
@Data
public final class ArrayQuery {
    private String sql;
    private Object[] objects;


    private ArrayQuery(String sql, Object... objects) {
        this.sql = sql;
        this.objects = objects;
    }

    public ArrayQuery of(String sql, Object... objects) {
        return new ArrayQuery(sql, objects);
    }
}
