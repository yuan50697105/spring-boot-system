package com.yuan.spring.boot.dao.ebean.entity.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/7/13 12:22
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class EbeanQueryParams<ID extends Serializable> extends com.yuan.spring.boot.dao.commons.entity.dto.BaseQueryParams<ID> {
    private int pageNumber;
    private int pageSize;
    private Sort sort;

    public EbeanQueryParams() {
    }

    public EbeanQueryParams(ID id, ID[] ids) {
        super(id, ids);
    }

    public EbeanQueryParams(ID id, ID[] ids, int pageNumber, int pageSize) {
        super(id, ids);
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.sort = Sort.unsorted();
    }

    public EbeanQueryParams(ID id, ID[] ids, int pageNumber, int pageSize, Sort sort) {
        super(id, ids);
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.sort = sort;
    }

    public Pageable getPageable() {
        return PageRequest.of(pageNumber, pageSize, sort);
    }
}
