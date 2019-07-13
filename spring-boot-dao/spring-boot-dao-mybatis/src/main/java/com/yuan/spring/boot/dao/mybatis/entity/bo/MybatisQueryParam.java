package com.yuan.spring.boot.dao.mybatis.entity.bo;

import com.yuan.spring.boot.dao.commons.entity.dto.BaseQueryParams;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/6/20 19:23
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class MybatisQueryParam<ID extends Serializable> extends BaseQueryParams<ID>  {
    public MybatisQueryParam() {
    }

    public MybatisQueryParam(ID id, ID[] ids) {
        super(id, ids);
    }
}
