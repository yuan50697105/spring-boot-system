package com.yuan.spring.boot.dao.ebean.entity.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/7/13 12:22
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class EbeanQueryParams<ID extends Serializable> extends com.yuan.spring.boot.dao.commons.entity.dto.BaseQueryParams<ID> {

    public EbeanQueryParams() {
    }

    public EbeanQueryParams(ID id, ID[] ids) {
        super(id, ids);
    }

}
