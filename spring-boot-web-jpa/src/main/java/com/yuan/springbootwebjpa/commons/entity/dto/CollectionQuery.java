package com.yuan.springbootwebjpa.commons.entity.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author yuane
 * @date 2019/6/20 19:30
 **/
@Data
public class CollectionQuery {
    private String sql;
    private Collection collection;

    public CollectionQuery() {
    }

    private CollectionQuery(String sql) {
        this.sql = sql;
        this.collection = new ArrayList(1);
    }

    private CollectionQuery(String sql, Collection collection) {
        this.sql = sql;
        this.collection = collection;
    }

    public static CollectionQuery of(String sql, Collection collection) {
        return new CollectionQuery(sql, collection);
    }

    public static CollectionQuery of(String sql) {
        return new CollectionQuery(sql);
    }
}
