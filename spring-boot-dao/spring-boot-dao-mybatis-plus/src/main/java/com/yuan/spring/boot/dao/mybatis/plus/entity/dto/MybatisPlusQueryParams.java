package com.yuan.spring.boot.dao.mybatis.plus.entity.dto;

import com.yuan.spring.boot.dao.commons.entity.dto.BaseQueryParams;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/6/20 22:56
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class MybatisPlusQueryParams<ID extends Serializable> extends BaseQueryParams<ID> implements Serializable {

    public MybatisPlusQueryParams() {
    }

    public MybatisPlusQueryParams(ID id, ID[] ids) {
        super(id, ids);
    }
}
