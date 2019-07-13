package com.yuan.spring.boot.dao.hibernate.entity.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/6/20 19:23
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class HibernateQueryParams<ID extends Serializable> extends com.yuan.spring.boot.dao.commons.entity.dto.BaseQueryParams<ID> implements Serializable {
    public HibernateQueryParams() {
    }

    public HibernateQueryParams(ID id, ID[] ids) {
        super(id, ids);
    }
}
