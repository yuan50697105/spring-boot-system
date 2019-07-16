package com.yuan.spring.boot.dao.jdbc.entity.dto;

import com.yuan.spring.boot.dao.commons.entity.dto.BaseQueryParams;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/7/13 22:00
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class JdbcQueryParams<ID extends Serializable> extends BaseQueryParams<ID> {
    public JdbcQueryParams() {
    }

    public JdbcQueryParams(ID id, ID[] ids) {
        super(id, ids);
    }
}
