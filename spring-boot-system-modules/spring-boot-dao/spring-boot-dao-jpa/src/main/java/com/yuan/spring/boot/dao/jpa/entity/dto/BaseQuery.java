package com.yuan.spring.boot.dao.jpa.entity.dto;

public interface BaseQuery<T> {
    String getSql();
    T getParams();
}
