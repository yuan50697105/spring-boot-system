package com.spring.boot.test.app3.modules.commons.entity.dto;

import com.yuan.spring.boot.dao.mybatis.mapper.entity.dto.MybatisMapperQueryParams;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BaseQueryParams extends MybatisMapperQueryParams<Long> {

    public BaseQueryParams() {
    }

    public BaseQueryParams(Long id, Long[] ids, Integer pageNum, Integer pageSize, String orderBy) {
        super(id, ids, pageNum, pageSize, orderBy);
    }
}
