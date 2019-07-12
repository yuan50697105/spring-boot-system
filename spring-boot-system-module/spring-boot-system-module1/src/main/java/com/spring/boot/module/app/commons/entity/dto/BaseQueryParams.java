package com.spring.boot.module.app.commons.entity.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class BaseQueryParams extends com.yuan.spring.boot.dao.mybatis.plus.commons.entity.bo.BaseQueryParams<String> {
    public BaseQueryParams() {
    }

    @Builder
    public BaseQueryParams(String s, String[] strings, String createUser, String updateUser, Date createDate, Date updateDate, Date createDateStart, Date createDateEnd, Date updateDateStart, Date updateDateEnd) {
        super(s, strings, createUser, updateUser, createDate, updateDate, createDateStart, createDateEnd, updateDateStart, updateDateEnd);
    }
}
