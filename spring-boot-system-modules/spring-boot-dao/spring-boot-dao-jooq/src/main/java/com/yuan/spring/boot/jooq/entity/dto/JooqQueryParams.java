package com.yuan.spring.boot.jooq.entity.dto;

import com.yuan.spring.boot.dao.commons.entity.dto.BaseQueryParams;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/7/18 22:12
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class JooqQueryParams<ID extends Serializable> extends BaseQueryParams<ID> {
    public JooqQueryParams() {
    }

    public JooqQueryParams(ID id, ID[] ids) {
        super(id, ids);
    }
}
