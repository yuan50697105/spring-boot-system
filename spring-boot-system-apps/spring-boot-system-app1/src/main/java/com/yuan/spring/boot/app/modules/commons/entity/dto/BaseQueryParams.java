package com.yuan.spring.boot.app.modules.commons.entity.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/13 1:15
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class BaseQueryParams extends com.yuan.spring.boot.dao.mybatis.plus.commons.entity.bo.BaseQueryParams<String> {
    public BaseQueryParams() {
    }

    public BaseQueryParams(String id, String[] ids, String createUser, String updateUser, Date createDate, Date updateDate, Date createDateStart, Date createDateEnd, Date updateDateStart, Date updateDateEnd) {
        super(id, ids, createUser, updateUser, createDate, updateDate, createDateStart, createDateEnd, updateDateStart, updateDateEnd);
    }
}
