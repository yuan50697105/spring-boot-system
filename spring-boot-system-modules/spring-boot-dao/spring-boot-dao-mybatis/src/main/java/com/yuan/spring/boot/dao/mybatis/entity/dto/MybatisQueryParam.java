package com.yuan.spring.boot.dao.mybatis.entity.dto;

import com.yuan.spring.boot.dao.commons.entity.dto.BaseQueryParams;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/6/20 19:23
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class MybatisQueryParam<ID extends Serializable> extends BaseQueryParams<ID> {
    private int pageNumber;
    private int pageSize;
    private Sort sort;

    public MybatisQueryParam() {
    }

    public MybatisQueryParam(ID id, ID[] ids) {
        super(id, ids);
    }

    public MybatisQueryParam(ID id, ID[] ids, int pageNumber, int pageSize) {
        super(id, ids);
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.sort = Sort.unsorted();
    }

    public MybatisQueryParam(ID id, ID[] ids, int pageNumber, int pageSize, Sort sort) {
        super(id, ids);
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.sort = sort;
    }

    public Pageable getPageable() {
        return PageRequest.of(pageNumber, pageSize, sort);
    }
}
