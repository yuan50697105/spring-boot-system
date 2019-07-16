package com.yuan.spring.boot.dao.mybatis.enhance.entity.dto;

import com.yuan.spring.boot.dao.commons.entity.dto.BaseQueryParams;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class EnhanceQueryParams<ID extends Serializable> extends BaseQueryParams<ID> implements Serializable {
    public EnhanceQueryParams() {
    }

    public EnhanceQueryParams(ID id, ID[] ids) {
        super(id, ids);
    }
}
