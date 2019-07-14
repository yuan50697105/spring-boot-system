package com.yuan.spring.boot.mapper.modules.commons.entity.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/13 1:15
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class BaseQueryParams extends com.yuan.spring.boot.dao.mybatis.plus.entity.dto.MybatisPlusQueryParams<String> {
    private String createBy;
    private String updateBy;
    private Date createDateStart;
    private Date createDateEnd;
    private Date updateDateStart;
    private Date updateDateEnd;

    public BaseQueryParams() {
    }

    public BaseQueryParams(String createBy, String updateBy, Date createDateStart, Date createDateEnd, Date updateDateStart, Date updateDateEnd) {
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.createDateStart = createDateStart;
        this.createDateEnd = createDateEnd;
        this.updateDateStart = updateDateStart;
        this.updateDateEnd = updateDateEnd;
    }

    public BaseQueryParams(String id, String[] ids, String createBy, String updateBy, Date createDateStart, Date createDateEnd, Date updateDateStart, Date updateDateEnd) {
        super(id, ids);
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.createDateStart = createDateStart;
        this.createDateEnd = createDateEnd;
        this.updateDateStart = updateDateStart;
        this.updateDateEnd = updateDateEnd;
    }
}
