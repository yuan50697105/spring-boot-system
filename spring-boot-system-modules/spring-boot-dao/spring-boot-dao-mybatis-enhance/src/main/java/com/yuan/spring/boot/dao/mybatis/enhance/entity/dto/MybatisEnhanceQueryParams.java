package com.yuan.spring.boot.dao.mybatis.enhance.entity.dto;

import com.gitee.hengboy.mybatis.pageable.common.annotations.PageIndex;
import com.gitee.hengboy.mybatis.pageable.common.annotations.PageSize;
import com.yuan.spring.boot.dao.commons.entity.dto.BaseQueryParams;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class MybatisEnhanceQueryParams<ID extends Serializable> extends BaseQueryParams<ID> implements Serializable {
    @PageIndex
    private Integer pageIndex;
    @PageSize
    private Integer pageSize;

    public MybatisEnhanceQueryParams() {
    }

    public MybatisEnhanceQueryParams(ID id, ID[] ids) {
        super(id, ids);
    }
}
