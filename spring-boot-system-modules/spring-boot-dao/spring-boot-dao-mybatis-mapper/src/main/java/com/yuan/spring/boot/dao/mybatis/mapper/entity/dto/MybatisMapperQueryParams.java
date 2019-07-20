package com.yuan.spring.boot.dao.mybatis.mapper.entity.dto;

import com.yuan.spring.boot.dao.commons.entity.dto.BaseQueryParams;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/6/21 21:15
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class MybatisMapperQueryParams<ID extends Serializable> extends BaseQueryParams<ID> implements Serializable {
    public MybatisMapperQueryParams() {
    }

    public MybatisMapperQueryParams(ID id, ID[] ids) {
        super(id, ids);
    }
}
