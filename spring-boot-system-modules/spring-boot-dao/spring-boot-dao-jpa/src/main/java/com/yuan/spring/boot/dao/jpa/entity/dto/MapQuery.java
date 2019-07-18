package com.yuan.spring.boot.dao.jpa.entity.dto;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuane
 * @date 2019/6/20 19:27
 **/
@Data
public final class MapQuery implements BaseQuery<Map<String, Object>> {
    private String sql;
    private Map<String, Object> params = new HashMap<>();

    public MapQuery() {

    }

    public MapQuery(String sql) {
        this.sql = sql;
        this.params = new HashMap<>(1);
    }

    @Builder
    public MapQuery(String sql, Map<String, Object> params) {
        this.sql = sql;
        this.params = params;
    }

    public static MapQuery build(String sql, Map<String, Object> params) {
        return new MapQuery(sql, params);
    }

    public static MapQuery build(String sql) {
        return new MapQuery(sql);
    }

}
