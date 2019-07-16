package com.yuan.spring.boot.dao.hibernate.entity.dto;

public interface BaseQuery<T> {
    String getSql();
    T getParams();
}
