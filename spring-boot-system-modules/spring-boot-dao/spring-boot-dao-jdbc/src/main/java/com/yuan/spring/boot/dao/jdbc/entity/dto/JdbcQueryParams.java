package com.yuan.spring.boot.dao.jdbc.entity.dto;

import com.xphsc.easyjdbc.page.PageInfo;
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
    private int pageNum;
    private int pageSize;

    public JdbcQueryParams() {
    }

    public JdbcQueryParams(ID id, ID[] ids) {
        super(id, ids);
    }

    public JdbcQueryParams(ID id, ID[] ids, int pageNum, int pageSize) {
        super(id, ids);
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public PageInfo getPageInfo() {
        return PageInfo.builder().pageNum(pageNum).pageSize(pageSize).build();
    }
}
