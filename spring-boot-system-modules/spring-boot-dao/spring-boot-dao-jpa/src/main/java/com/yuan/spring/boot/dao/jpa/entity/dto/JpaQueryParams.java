package com.yuan.spring.boot.dao.jpa.entity.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/6/20 19:23
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class JpaQueryParams<ID extends Serializable> extends com.yuan.spring.boot.dao.commons.entity.dto.BaseQueryParams<ID> implements Serializable {
    public JpaQueryParams() {
    }

    public JpaQueryParams(ID id, ID[] ids) {
        super(id, ids);
    }
}
