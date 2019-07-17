package com.yuan.spring.boot.app2.modules.commons.entity.dto;

import com.yuan.spring.boot.dao.mybatis.plus.entity.dto.MybatisPlusQueryParams;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class AbstractQueryParams extends MybatisPlusQueryParams<Long> {
    public AbstractQueryParams() {
    }

    public AbstractQueryParams(Long id, Long[] ids) {
        super(id, ids);
    }
}
