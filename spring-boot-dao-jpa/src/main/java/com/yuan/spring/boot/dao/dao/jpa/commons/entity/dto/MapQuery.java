package com.yuan.spring.boot.dao.dao.jpa.commons.entity.dto;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuane
 * @date 2019/6/20 19:27
 **/
@Data
public final class MapQuery {
    private String sql;
    private Map<String, Object> map = new HashMap<>();

    public MapQuery() {

    }

    public MapQuery(String sql) {
        this.sql = sql;
        this.map = new HashMap<>(1);
    }

    @Builder
    public MapQuery(String sql, Map<String, Object> map) {
        this.sql = sql;
        this.map = map;
    }

    public static MapQuery of(String sql, Map<String, Object> map) {
        return new MapQuery(sql, map);
    }

    public static MapQuery of(String sql) {
        return new MapQuery(sql);
    }
}
