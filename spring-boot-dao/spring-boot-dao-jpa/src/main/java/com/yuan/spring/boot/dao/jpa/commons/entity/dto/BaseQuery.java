package com.yuan.spring.boot.dao.jpa.commons.entity.dto;

public interface BaseQuery<T> {
    String getSql();
    T getParams();
}
