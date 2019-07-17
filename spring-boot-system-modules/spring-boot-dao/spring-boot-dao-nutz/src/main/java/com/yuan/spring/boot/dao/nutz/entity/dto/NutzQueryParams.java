package com.yuan.spring.boot.dao.nutz.entity.dto;

import com.yuan.spring.boot.dao.commons.entity.dto.BaseQueryParams;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/7/17 23:48
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class NutzQueryParams<ID extends Serializable> extends BaseQueryParams<ID> {
    public NutzQueryParams() {
    }

    public NutzQueryParams(ID id, ID[] ids) {
        super(id, ids);
    }
}
